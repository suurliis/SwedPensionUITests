Feature: "Choose V-fund" and "Enter into agreement" direct user further to information sections. User is requested to log in to start an agreement

  Background:
    Given site for third pillar description page is opened

  Scenario: "Choose V-fund" page directs user to "Swedbank V-funds page" where user can choose to "Start saving". This needs user to log in
    Given 'Choose V-fund' button is shown on the page
    When user presses the Choose V-fund button
    Then user is redirected to Swedbank V-funds page

    Given Start saving button is shown on the page
    When user presses the 'Start saving' button
    Then user is requested to log in

  Scenario: "Enter into agreement" button on the page requests user to log in to proceed
    Given 'Enter into agreement' button is shown on the page
    When user presses the 'Enter into agreement' button
    Then user is requested to log in
