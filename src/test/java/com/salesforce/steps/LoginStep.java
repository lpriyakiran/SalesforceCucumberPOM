package com.salesforce.steps;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.salesforce.pages.base.BasePage;
import com.salesforce.pages.home.Home;
import com.salesforce.pages.login.Login;
import com.salesforce.utilities.CommonUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	//WebDriver driver = BasePage.getDriverInstance();
	String url = CommonUtilities.getApplicationProperty("url");
	Login login;
	Home home;
	
	@Before
	public void setUp() {
		String browser = "firefox";
		System.out.println("BeforeMethod - testing on "+browser);
		BasePage.driverSetUp(browser);
	}
		
	@After
		public static void tearDown() {
		System.out.println("AfterMethod");
		BasePage.closeDriver();
		//closeAllDrivers();
	}
	
	@Given("User open SalesForce application")
	public void user_open_sales_force_application() {
		BasePage.getUrl(url);
	}

	@When("user on {string}")
	public void user_on(String page) {
	    if(page.equalsIgnoreCase("Login")){
	    	login = new Login(BasePage.getDriverInstance());
	    }else if(page.equalsIgnoreCase("Home")) {
	    	home = new Home(BasePage.getDriverInstance());
	    }
	}
	
	@When("click on button {string}")
	public void click_on_button(String button) {
	   if(button.equalsIgnoreCase("Login")) {
		   login.loginClick();
	   }else if(button.equalsIgnoreCase("Logout")) {
		   home.logout();
	   }	
	}

	@When("User enters value into text box username")
	public void user_enters_value_into_text_box_username() {
	    login.enterUserName();
	}
	
	@When("User enters value into text box password")
	public void user_enters_value_into_text_box_password() {
	    login.enterPassword();
	}

	@When("User clears text box password")
	public void user_clears_text_box_password() {
	    login.clearPassword();
	}
	
	@When("User checks remember me checkbox")
	public void user_checks_remember_me_checkbox() {
		login.checkRememberMeCheckBox();
	}
	
	@When("click on forgot password")
	public void click_on_forgot_password() {
		login.clickForgotPassword();
	}
	
	@When("user is on forgot password page")
	public void user_is_on_forgot_password_page() {
		login.forgotPasswordProcess();
	}
	
	@When("User enters wrong value into text box username")
	public void user_enters_wrong_value_into_text_box_username() {
	    login.enterWrongUserName();
	}
	
	@When("User enters wrong value into text box password")
	public void user_enters_wrong_value_into_text_box_password() {
	    login.enterWrongPassword();
	}

	@Then("enter password message should be displayed")
	public void enter_password_message_should_be_displayed() {
	    login.checkEmptyPasswordErrorMsg();
	    String expectedErrorMsg = CommonUtilities.getApplicationProperty("emptypwderror");
		String errorMsg = login.checkEmptyPasswordErrorMsg();
		Assert.assertEquals(errorMsg, expectedErrorMsg);
	}
	
	@Then("User should be on {string}")
	public void user_should_be_on(String page) {
		if(page.equalsIgnoreCase("home")) {
			String homeTitle = CommonUtilities.getApplicationProperty("homepagetitle");
			BasePage.waitUntilTitle(homeTitle);
		}
		
	}
	
	@Then("username should be displayed")
	public void username_should_be_displayed() throws Exception {
		String expected = CommonUtilities.getApplicationProperty("username");
		String actual = login.checkUsernameRemember();
		Assert.assertEquals(actual, expected);
	}
	
	@Then("check your email message should be displayed ")
	public void check_your_email_message_should_be_displayed() {
		boolean actual = login.checkForgotPwdEmailMsg();
		Assert.assertEquals(actual, true);
	}
	
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		boolean actual = login.checkLoginErrorMsg();
		Assert.assertEquals(actual, true);
	}

}
