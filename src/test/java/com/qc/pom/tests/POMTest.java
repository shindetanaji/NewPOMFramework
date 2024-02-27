package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.HomePage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData", priority = 1)
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			HomePage home = login.loginWithValid(uName, uPass);
			Assert.assertTrue(home.verifyHomePage());
		} else {
			login.loginWithInValid(uName, uPass);
			Assert.assertTrue(login.verifyLoginPage());
		}
	}

	@Test(dataProvider = "registerData", priority = 2)
	public void doRegister(String tName, String uName, String uMobile, String uEmail, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (driver.getTitle().equals("Queue Codes | Log in")) {
			login.clickOnRegstrationLink();
		}
		RegisterPage register = new RegisterPage(driver);
		register.doRegister(uName, uMobile, uEmail, uPass);
		if(tName.equals("All are valid")) {
			boolean result = register.handleAlert();
			Assert.assertTrue(result);
		}else {
			Assert.assertTrue(register.verifyRegisterPage());
		}
	}
}
