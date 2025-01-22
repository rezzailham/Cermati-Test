@regress @cermati @register

Feature: Register

  Scenario:Positive Case Register successfully
    Given user access page "https://www.cermati.com/app/gabung"
    When user input mobilePhone "083820289064"
    And user input email "test@example.id"
    And input First Name "Juan Francisco"
    And input Last Name "Garcia Flores"
    And users click on Daftar button
    Then system display OTP Page