package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	@FindBy(linkText="Leads")
	private WebElement LeadLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;

	public WebElement getLeadLink() {
		return LeadLink;
	}
	

	public WebElement getAdministratorText() {
		return AdministratorImg;
	}


	public WebElement getSingOutLink() {
		return SignOutLink;
	}
	
	public void LogOut() {
		Actions action=new Actions(driver);
		action.moveToElement(AdministratorImg).perform();
		SignOutLink.click();
	}
	
	

}
