package com.liis.steps.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetUp {
    public static WebDriver driver = null;
    public static String baseURL = null;

    public DriverSetUp() {
        if (driver == null) {
            if (System.getProperty("browser") != null) {
                if (System.getProperty("browser").equals("firefox")) {
                    driver = new FirefoxDriver();
                } else {
                    driver = new ChromeDriver();
                }
            } else {
                driver = new ChromeDriver();
            }
        }
        if (baseURL == null) {
            if (System.getProperty("baseUrl") != null) {
                baseURL = System.getProperty("baseUrl");
            } else {
                baseURL = "https://www.swedbank.ee/private";
            }
        }
        driver.get(getBaseURL() + "?language=ENG");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBaseURL() {
        if (baseURL == null) {
            return baseURL;
        } else {
            return baseURL;
        }
    }
}
