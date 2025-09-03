package com.orangehrm.automation.stepdefs;

import com.orangehrm.automation.base.BaseTest;
import com.orangehrm.automation.pages.Admin_UserManagementPage;
import com.orangehrm.automation.pages.DashboardPage;
import com.orangehrm.automation.pages.LoginPage;
import com.orangehrm.automation.utils.ExcelReader;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ExcelReader excel = new ExcelReader("src/test/resources/testdata/TestData.xlsx");
	Admin_UserManagementPage adminPage = new Admin_UserManagementPage(driver);

	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String userCol, String passCol) {
		/*
		 * String username = excel.getCellData("LoginData", userCol, 1); String password
		 * = excel.getCellData("LoginData", passCol, 1);
		 */
		Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login page not loaded");
		loginPage.enterUsername("admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLogin();
	}

	@Then("User should land on dashboard")
	public void user_should_land_on_dashboard() {
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "❌ Dashboard not displayed!");
		System.out.println("✅ Login successful!");
	}

	@Then("User select role from the list")
	public void User_select_role_from_the_list() {
		adminPage.selectItem("Admin");  // pass the actual menu item
	}

	@And("User click on add button")
	public void User_click_on_add_button() {
		adminPage.clickCreateNewUserBtn();
	}
}
