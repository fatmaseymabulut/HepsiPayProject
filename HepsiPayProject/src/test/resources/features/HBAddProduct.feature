@UI
Feature: add product to cart and control of amount to be paid with Instant transfer

  Scenario: The user should be able to see that the "Amount to be Paid" information on the payment page is the same as the amount information in the "Shopping Amount" field.
    Given the user go to HB url
    Then verify the user is on the homepage

    When the user login with valid credentials
    Then verify the user can login successfully

    When the user should be able to add products to the cart
    Then verify the user is on the sepetim page

    Then verify the user is on the odeme page
    When the user should be able to check that the KuveytTurk bank payment amount is correct

    When the user should be able to check that the FibaBanka bank payment amount is correct





