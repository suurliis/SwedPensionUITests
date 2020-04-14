package com.liis.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static com.liis.steps.driver.DriverSetUp.getBaseURL;
import static com.liis.steps.driver.DriverSetUp.getDriver;
import static com.liis.steps.enums.FundRatesElements.*;
import static java.lang.Thread.sleep;

public class FundRatesUserSteps {

    JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    @Given("^site for pension fund rates is open$")
    public void site_for_pension_fund_rates_is_open(){
        getDriver().get(getBaseURL() + "/pensions/pillar3/allFunds?language=ENG");
    }

    @Given("^the following information is shown in the tabs:$")
    public void the_following_information_is_shown_in_the_tabs(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

        int tabElementNumber = 1;
        for(int listElement=0; listElement<list.size(); listElement++) {
            String selectorForTab = "#Tab" + tabElementNumber + " > a > span";
            WebElement performanceTabElement = getDriver().findElement(By.cssSelector(selectorForTab));
            performanceTabElement.click();
            sleep(1000L);
            String peformanceCalculationText = getDriver().findElement(By.id("fundList")).getText();
            String textForThatTabFromTable = list.get(listElement).get("Text shown for that tab");
            Assert.assertTrue(peformanceCalculationText.contains(textForThatTabFromTable ));
            tabElementNumber++;
        }
    }

    @Given("^fund 'Swedbank Pension fund K(\\d+)' is open$")
    public void fund_Swedbank_Pension_fund_K_is_open(int arg1) throws InterruptedException {
        sleep(1000L);
        WebElement swedbankPenionFundK60Info = getDriver().findElement(By.cssSelector(SWEDBANK_PENSION_FUND_K60_PAGE.getRatesElement()));
        executor.executeScript("arguments[0].click();", swedbankPenionFundK60Info);
    }

    @When("^user presses 'Performance' tab$")
    public void user_presses_Performance_tab() throws InterruptedException {
        sleep(1000L);
        WebElement performanceTab = getDriver().findElement(By.cssSelector(PENSION_FUND_K60_PERFORMANCE_TAB.getRatesElement()));
        executor.executeScript("arguments[0].click();", performanceTab);

    }

    @When("^user clicks on 'Prices history' link$")
    public void user_clicks_on_Prices_history_link() throws InterruptedException {
        sleep(1000L);
        WebElement pricesHistoryLink = getDriver().findElement(By.cssSelector(PENSION_FUND_PRICES_HISTORY_LINK.getRatesElement()));
        executor.executeScript("arguments[0].click();", pricesHistoryLink);
    }

    @Then("^for this fund security type is displayed as \"([^\"]*)\", currency as \"([^\"]*)\" and security as \"([^\"]*)\"$")
    public void for_this_fund_security_type_is_displayed_as_currency_as_and_security_as(String securityTypeText, String currency, String security) {
        WebElement securityType = getDriver().findElement(By.cssSelector(PENSION_FUND_K60_SECURITY_TYPE_SELECT_VALUE.getRatesElement()));
        WebElement currencySelection = getDriver().findElement(By.cssSelector(PENSION_FUND_K60_CURRENCY_SELECT_VALUE.getRatesElement()));
        WebElement securitySelection = getDriver().findElement(By.cssSelector(PENSION_FUND_K60_SECURITY_SELECT_VALUE.getRatesElement()));
         Assert.assertEquals(securityType.getText(), securityTypeText);
         Assert.assertEquals(currencySelection.getText(), currency);
         Assert.assertEquals(securitySelection.getText(), security);
    }
}
