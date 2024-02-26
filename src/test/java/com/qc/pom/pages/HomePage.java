package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "hlogout")
	WebElement logoutBtn;
	
	public void doLogout() {
		logoutBtn.click();
	}
	
	public boolean verifyHomePage() {
		String actTitle = driver.getTitle();
		String expTitle = "Queue Codes | Dashboard";
		doLogout();
		return actTitle.equals(expTitle);
	}
}
