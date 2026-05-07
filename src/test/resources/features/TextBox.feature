Feature: Text Box Form submission

    Scenario: Submit text box form with valid data
    Given user is on DemoQA text box page
    When user enters valid name, email and address
    And user clicks submit button
    Then submitted details should be displayed



