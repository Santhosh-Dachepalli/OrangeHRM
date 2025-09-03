package com.orangehrm.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        int timeout = Integer.parseInt(ConfigReader.get("timeout")); // from config.properties
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Wait for visibility
    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for clickability
    public static void waitForClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Type text
    protected void type(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    // Click element
    public static void click(WebElement element) {
        waitForClick(element);
        element.click();
    }

    // Get text
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    // Check element is displayed
    public static boolean isDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
