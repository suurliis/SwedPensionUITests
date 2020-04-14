package com.liis.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liis.steps.driver.DriverSetUp;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import static com.liis.steps.driver.DriverSetUp.getDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/liis/features/fundrates.feature", "src/test/java/com/liis/features/thirdpillar.feature"}
        , glue = {"com/liis/steps"}, plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)
public class TestRunner {

    @BeforeClass
    public static void setUp() {
        DriverSetUp driverSetUp = new DriverSetUp();
    }

    @AfterClass
    public static void tearDown() {
        getDriver().close();
    }

}
