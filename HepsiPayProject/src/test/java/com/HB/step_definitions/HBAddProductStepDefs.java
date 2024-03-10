package com.HB.step_definitions;

import com.HB.pages.BasePage;
import com.HB.pages.LoginPage;
import com.HB.pages.BankaPage;
import com.HB.pages.SepetimPage;
import com.HB.pages.OdemePage;
import com.HB.utilities.ConfigurationReader;
import com.HB.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.HB.utilities.BrowserUtils;

import java.awt.*;
import java.io.IOException;

public class HBAddProductStepDefs {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    BankaPage bankaPage = new BankaPage();
    SepetimPage sepetimPage = new SepetimPage();
    OdemePage odemePage = new OdemePage();

    @Given("the user go to HB url")
    public void the_user_go_to_HB_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("verify the user is on the homepage")
    public void verify_the_user_is_on_the_homepage() throws IOException, AWTException {
        org.junit.Assert.assertEquals("https://www.hepsiburada.com/", Driver.get().getCurrentUrl());
    }

    @When("the user login with valid credentials")
    public void theUserLoginWithValidCredentials() {
        BrowserUtils.waitForVisibility(basePage.GirisYapVeyaUyeOlButonMenu,10);
        BrowserUtils.hover(basePage.GirisYapVeyaUyeOlButonMenu);
        BrowserUtils.waitFor(3);
        basePage.MenudenGirisYapButon.click();
        loginPage.EpostaAlani.sendKeys("testdenemeqa@gmail.com");
        loginPage.GirisYapButonEmail.click();
        loginPage.SifreAlani.sendKeys("Testdeneme06*");
        loginPage.GirisYapButonSifre.click();

    }

    @Then("verify the user can login successfully")
    public void verifyTheUserCanLoginSuccessfully() {
        Assert.assertEquals("Hesabım", basePage.HesabimKontrol.getText());

    }

    @When("the user should be able to add products to the cart")
    public void theUserShouldBeAbleToAddProductsToTheCart() {
        basePage.UrunArama.sendKeys("iş bankası kürk mantolu madonna");
        basePage.AraButon.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(basePage.IlkUrunHoverOver);
        basePage.SepeteEkleButon.click();
        Assert.assertEquals("Ürün sepete eklendi", basePage.UrunSepeteEklendiYesilEtiket.getText());
        basePage.SepeteGitYesilEtiket.click();

    }

    @Then("verify the user is on the sepetim page")
    public void verifyTheUserIsOnTheSepetimPage() {
        org.junit.Assert.assertTrue(Driver.get().getCurrentUrl().contains("sepetim"));

    }


    @Then("verify the user is on the odeme page")
    public void verifyTheUserIsOnTheOdemePage() {
        sepetimPage.AlisverisiTamamlaButon.click();
        BrowserUtils.waitForClickablility(odemePage.DigerOdemeSecenekleriButon, 3);
        org.junit.Assert.assertTrue(Driver.get().getTitle().contains("Ödeme"));

    }

    @When("the user should be able to check that the KuveytTurk bank payment amount is correct")
    public void theUserShouldBeAbleToCheckThatTheKuveytTurkBankPaymentAmountIsCorrect() {
        odemePage.DigerOdemeSecenekleriButon.click();
        odemePage.AnindaHavaleRadioButon.click();
        BrowserUtils.waitForVisibility(odemePage.KuveytTurkSecimi, 2);
        odemePage.KuveytTurkSecimi.click();
        odemePage.FormSozlesmeOnayRadioButon.click();
        BrowserUtils.waitFor(2);
        odemePage.SiparisiOnaylaButon.click();
        BrowserUtils.waitForVisibility(odemePage.SiparisEkraniOdemeTutari, 5);
        Assert.assertEquals(odemePage.SiparisEkraniOdemeTutari.getText(), bankaPage.BankaEkraniOdemeTutari.getText());
        BrowserUtils.waitFor(2);
        bankaPage.AlisveriseGeriDon.click();

    }


    @When("the user should be able to check that the FibaBanka bank payment amount is correct")
    public void theUserShouldBeAbleToCheckThatTheFibaBankaBankPaymentAmountIsCorrect() {
        sepetimPage.AlisverisiTamamlaButon.click();
        BrowserUtils.waitForClickablility(odemePage.DigerOdemeSecenekleriButon, 3);
        org.junit.Assert.assertTrue(Driver.get().getTitle().contains("Ödeme"));
        odemePage.DigerOdemeSecenekleriButon.click();
        odemePage.AnindaHavaleRadioButon.click();
        BrowserUtils.waitForVisibility(odemePage.FibaBankaSecimi, 2);
        odemePage.FibaBankaSecimi.click();
        odemePage.FormSozlesmeOnayRadioButon.click();
        BrowserUtils.waitFor(2);
        odemePage.SiparisiOnaylaButon.click();
        BrowserUtils.waitForVisibility(odemePage.SiparisEkraniOdemeTutari, 5);
        Assert.assertEquals(odemePage.SiparisEkraniOdemeTutari.getText(), bankaPage.BankaEkraniOdemeTutari.getText());
        BrowserUtils.waitFor(2);
        bankaPage.AlisveriseGeriDon.click();

    }
}
