package com.HB.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpResponseException;
import org.testng.Assert;

import static org.junit.Assert.assertThrows;

public class PetSwaggerApiTestStepDefs {
    Object petId;

    @Given("create a new pet and verify created successfully")
    public void create_a_new_pet_and_verify_created_successfully() {

        String body = "{\"id\":0,\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"newdog\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/pet");
        petId = response.path("id");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.path("name"), "newdog");
        System.out.println("petId = " + petId);
    }

    @When("can not create a new pet and verify created unsuccessfully")
    public void canNotCreateANewPetAndVerifyCreatedUnsuccessfully() {
        //according to swagger document in order to retrieve 405 status code, I didn't send a body

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().post("/pet");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        System.out.println("petId = " + petId);
    }

    @When("update an existing pet verify updated successfully")
    public void update_an_existing_pet_verify_updated_successfully() {
        String updatedBody = "{\"id\":" + petId + ",\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"updatedDogName\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(updatedBody)
                .when().put("/pet");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.path("name"), "updatedDogName");
        Assert.assertEquals(response.path("id"), petId);
    }

    @And("can not update an existing pet and verify updated unsuccessfully")
    public void canNotUpdateAnExistingPetAndVerifyUpdatedunsuccessfully() {
        String updatedBody = "{{\"id\":0,\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"updatedDogName\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}";

        HttpResponseException exception = assertThrows(HttpResponseException.class, () -> RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(updatedBody)
                .when().put("/pet"));

        Assert.assertEquals(exception.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(exception.getMessage(), "Bad Request");
    }

    @When("find pet by ID and verify get successfully")
    public void find_pet_by_ID_and_verify_get_successfully() {

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .and().pathParams("petId", petId)
                .when().get("/pet/{petId}");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.path("name"), "newdog");
        Assert.assertEquals(response.path("id"), petId);
    }

    @And("can not find pet by ID and verify get unsuccessfully")
    public void canNotFindPetByIDAndVerifyGetUnsuccessfully() {

        HttpResponseException exception = assertThrows(HttpResponseException.class, () -> RestAssured.given().contentType(ContentType.JSON)
                .and().pathParams("petId", "12321234323")
                .when().get("/pet/{petId}"));

        Assert.assertEquals(exception.getStatusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(exception.getMessage(), "Not Found");
    }

    @When("deletes a pet and verify deleted successfully")
    public void deletes_a_pet_and_verify_deleted_successfully() {

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .and().pathParams("petId", petId)
                .when().delete("/pet/{petId}");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.path("message"), String.valueOf(petId));
        response.prettyPrint();
    }

    @And("can not deletes a pet and verify deleted unsuccessfully")
    public void canNotDeletesAPetAndVerifyDeletedUnsuccessfully() {
        HttpResponseException exception = assertThrows(HttpResponseException.class, () -> RestAssured.given().contentType(ContentType.JSON)
                .and().pathParams("petId", "22")
                .when().delete("/pet/{petId}"));

        Assert.assertEquals(exception.getStatusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(exception.getMessage(), "Not Found");

    }
}
