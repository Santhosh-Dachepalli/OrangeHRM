package com.orangehrm.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.automation.base.BasePage;

public class Admin_UserManagementPage extends BasePage {

    private WebDriver driver;

    public Admin_UserManagementPage(WebDriver driver) {
        super(driver);  // call BasePage constructor if it manages waits
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
    private List<WebElement> menu;  // ✅ instance, not static

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
    private WebElement addBtn;  // ✅ instance, not static

    public void selectItem(String item) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfAllElements(menu));
        for (WebElement each : menu) {
            if (each.getText().equalsIgnoreCase(item)) {
                each.click();
                break;
            }
        }
    }

    public void clickCreateNewUserBtn() {
        BasePage.isDisplayed(addBtn);
        BasePage.click(addBtn);
    }
}
