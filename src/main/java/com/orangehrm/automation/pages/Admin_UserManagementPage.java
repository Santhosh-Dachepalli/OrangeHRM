package com.orangehrm.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		super(driver); // call BasePage constructor if it manages waits
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
	private List<WebElement> menu; // ✅ instance, not static

	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
	private WebElement addBtn; // ✅ instance, not static

	@FindBy(xpath = "//label[text()='User Role']//parent::div/parent::div//following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']")
	private WebElement userRole;
	
	@FindBy(xpath = "//div[@class='oxd-select-wrapper']/div[@role='listbox']/div/span")
	private List<WebElement> roles;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']/div[@role='listbox']/div/span")
	private List<WebElement> names;

	public void selectItem(String item) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(menu));
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
	
	 public void clickUserRole() {
	        BasePage.click(userRole);
	    }

	    public void selectingUserRole(String roleName) {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfAllElements(roles));
	        for (WebElement role : roles) {
	            if (role.getText().equalsIgnoreCase(roleName)) {
	                role.click();
	                break;
	            }
	        }
	    }

	    public void typeEmployeeName(String inputName) {
	        employeeName.clear();
	        employeeName.sendKeys(inputName);
	    }

	    public void selectEmployeeName(String expectedName) {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfAllElements(employeeName));
	        for (WebElement option : names) {
	            if (option.getText().equalsIgnoreCase(expectedName)) {
	                option.click();
	                break;
	            }
	        }
	    }}
