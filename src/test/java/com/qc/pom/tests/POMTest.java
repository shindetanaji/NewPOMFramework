package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.HomePage;
import com.qc.pom.pages.LoginPage;

public class POMTest extends BaseIntegration{

	@Test
	public void doLogin() {
		LoginPage login = new LoginPage(driver);
		HomePage home = login.loginWithValid("queuecodes@gmail.com", "123456");
		Assert.assertTrue(home.verifyHomePage());
	}
}
