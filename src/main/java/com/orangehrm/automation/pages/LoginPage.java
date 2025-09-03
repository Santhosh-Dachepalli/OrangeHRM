// src/main/java/com/orangehrm/automation/pages/LoginPage.java
package com.orangehrm.automation.pages;

import com.orangehrm.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // keep both names so whichever you call, it compiles
    public boolean isLoginButtonVisible() { 
        return isDisplayed(loginButton); 
    }

    public boolean loginPageLoaded() { 
        return isDisplayed(loginButton); 
    }

    public void enterUsername(String username) { type(usernameField, username); }
    public void enterPassword(String password) { type(passwordField, password); }
    public void clickLogin() { click(loginButton); }
}
