package com.orangehrm.automation.base;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    public void setUp() {
        String browser = ConfigReader.get("browser");
        driver = DriverManager.getDriver(browser);
        driver.get(ConfigReader.get("url"));
    }

    public void tearDown() {
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
