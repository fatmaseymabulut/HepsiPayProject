@Api

Feature: CRUD operation functionally

  Scenario: Post positive and negative scenario
    Given create a new pet and verify created successfully
    When can not create a new pet and verify created unsuccessfully

  Scenario: Put positive and negative scenario
    Given create a new pet and verify created successfully
    When update an existing pet verify updated successfully
    And can not update an existing pet and verify updated unsuccessfully

  Scenario: Get positive and negative scenario
    Given create a new pet and verify created successfully
    When find pet by ID and verify get successfully
    And can not find pet by ID and verify get unsuccessfully

  Scenario: Delete positive and negative scenario
    Given create a new pet and verify created successfully
    When deletes a pet and verify deleted successfully
    And can not deletes a pet and verify deleted unsuccessfully



