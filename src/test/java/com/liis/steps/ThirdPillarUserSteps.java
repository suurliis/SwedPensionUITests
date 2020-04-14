package com.liis.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.liis.steps.driver.DriverSetUp;
import static com.liis.steps.enums.LoginElements.LOGIN_PAGE_TITLE;
import static com.liis.steps.enums.ThirdPillarElements.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.cssSelector;

public class ThirdPillarUserSteps extends DriverSetUp{

    JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    @Given("^site for third pillar description page is opened$")
    public void site_for_third_pillar_description_page_is_opened() {
        getDriver().get(getBaseURL() + "/pensions/pillar3/description?language=ENG");
    }

    @Given("^'Choose V-fund' button is shown on the page$")
    public void choose_V_fund_button_is_shown_on_the_page() {
        WebElement chooseVFundButton = getDriver().findElement(By.cssSelector(CHOOSE_V_FUND_BUTTON.getPillarElement()));
        chooseVFundButton.isDisplayed();
    }

    @When("^user presses the Choose V-fund button$")
    public void user_presses_the_Choose_V_fund_button() throws InterruptedException {
        WebElement chooseVFundButton = getDriver().findElement(cssSelector(CHOOSE_V_FUND_BUTTON.getPillarElement()));
        executor.executeScript("arguments[0].click();", chooseVFundButton);
        sleep(2000L);
    }

    @Then("^user is redirected to Swedbank V-funds page$")
    public void user_is_redirected_to_Swedbank_V_funds_page() {
        WebElement swedbankVFundPageTitle = getDriver().findElement(cssSelector(SWEDBANK_V_FUND_PAGE_TITLE.getPillarElement()));
        assertEquals(swedbankVFundPageTitle.getText(), "Swedbank V-funds");
    }

    @Given("^Start saving button is shown on the page$")
    public void start_saving_button_is_shown_on_the_page() {
        WebElement startSavingButton = getDriver().findElement(cssSelector(START_SAVING_BUTTON.getPillarElement()));
        assertTrue(startSavingButton.isDisplayed());
    }

    @When("^user presses the 'Start saving' button$")
    public void user_presses_the_Start_saving_button() throws InterruptedException {
        WebElement startSavingButton = getDriver().findElement(cssSelector(START_SAVING_BUTTON.getPillarElement()));
        executor.executeScript("arguments[0].click();", startSavingButton);
        sleep(2000L);
    }

    @Then("^user is requested to log in$")
    public void userIsRequestedToLogIn() {
        WebElement loginPageTitle = getDriver().findElement(cssSelector(LOGIN_PAGE_TITLE.getLoginElement()));
        assertEquals(loginPageTitle.getText(), "Log in with");
    }

    @Given("^'Enter into agreement' button is shown on the page$")
    public void enterIntoAgreementButtonIsShownOnThePage() {
        WebElement enterIntoAgreementButton = getDriver().findElement(cssSelector(ENTER_INTO_AGREEMENT_BUTTON.getPillarElement()));
        assertTrue(enterIntoAgreementButton.isDisplayed());
    }

    @When("^user presses the 'Enter into agreement' button$")
    public void userPressesTheEnterIntoAgreementButton() throws InterruptedException{
        WebElement enterIntoAgreementButton = getDriver().findElement(cssSelector(ENTER_INTO_AGREEMENT_BUTTON.getPillarElement()));
        executor.executeScript("arguments[0].click();", enterIntoAgreementButton);
        sleep(2000L);
    }
}
