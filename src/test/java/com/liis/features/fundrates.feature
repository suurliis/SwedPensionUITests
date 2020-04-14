Feature: Verify information on 'Pension fund rates' page

  Background:
    Given site for pension fund rates is open

  Scenario: verify information shown in the tabs
    Given the following information is shown in the tabs:
      | Tab opened by user               | Text shown for that tab     |
      | Short term performance           | Short term returns          |
      | Long term annualized performance | Long term return            |
      | Long term cumulative performance | Long term cumulative return |
      | Risk statistics                  | Standard deviation          |

  Scenario: verify information shown on 'Swedbank Pension fund K60' information page
    Given fund 'Swedbank Pension fund K60' is open
    When user presses 'Performance' tab
    And user clicks on 'Prices history' link
    Then for this fund security type is displayed as "fund", currency as "EUR" and security as "SWEDBANK PENSIONIFOND K60"
