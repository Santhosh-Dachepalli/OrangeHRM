package com.orangehrm.automation.base;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    public static void setUp() {
        if (driver == null) {
            driver = DriverManager.getDriver("chrome"); // 🔹 can later make dynamic
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(ConfigReader.get("url"));
        }
    }

    public static void tearDown() {
        DriverManager.quitDriver();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
