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
	
	@Given("User is on user management page")
	public void user_is_on_user_management_page() {
	   
	}

	@When("User clicks on user role")
	public void user_clicks_on_user_role() {
		adminPage.clickUserRole();
	}

	@Then("User should should select an option from drop down")
	public void user_should_should_select_an_option_from_drop_down() {
	   adminPage.selectingUserRole("Admin");
	}

	@When("User enter text in the employee name field")
	public void user_enter_text_in_the_employee_name_field() {
	    adminPage.typeEmployeeName("savina dulvin dulvin");
	}

	@Then("User need to select a name from the dropdown")
	public void user_need_to_select_a_name_from_the_dropdown() {
	   adminPage.selectEmployeeName("savina dulvin dulvin");
	}
	
	@When("User clicks on status")
	public void User_clicks_on_status() {
		adminPage.clickStatus();
	}
	
	@Then("User need to select a status from the dropdown")//User should select an status from drop down
	public void user_need_to_select_a_status_from_the_dropdown() {
		adminPage.selectStatus("Disabled");
	}
}
