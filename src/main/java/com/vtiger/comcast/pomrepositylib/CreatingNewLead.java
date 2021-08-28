package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLead {
	WebDriver driver;
	
	public CreatingNewLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name="firstname")
	private WebElement FirstNameTextField;
	
	@FindBy(name="noofemployees")
	private WebElement NoOfEmployessTextField;
	
	@FindBy(name="secondaryemail")
	private WebElement SecondaryTextField;
	
	@FindBy(id="phone")
	private WebElement PhonenoTextField;
	
	@FindBy(id="mobile")
	private WebElement MobilenoTextField;
	
	@FindBy(id="fax")
	private WebElement FaxnoTextField;
	
	@FindBy(name="website")
	private WebElement WebsiteTextField;
	
	
	@FindBy(name="lastname")
	private WebElement LastNameTextField;
	
	@FindBy(name="company")
	private WebElement CompanyTextField;
	
	@FindBy(name="designation")
	private WebElement TitleTextField;
	
	@FindBy(id="email")
	private WebElement EmailTextField;
	
	@FindBy(xpath="//td[text()='Lead No ']/following-sibling::td[@class='dvtCellInfo']")
	private WebElement LeadNoTextField;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return CompanyTextField;
	}
	
	

	
	

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public void setTitleTextField(WebElement titleTextField) {
		TitleTextField = titleTextField;
	}

	public WebElement getTitleTextField() {
		return  EmailTextField;
	}
	
	
	

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getNoOfEmployessTextField() {
		return NoOfEmployessTextField;
	}

	public WebElement getSecondaryTextField() {
		return SecondaryTextField;
	}

	public WebElement getPhonenoTextField() {
		return PhonenoTextField;
	}

	public WebElement getMobilenoTextField() {
		return MobilenoTextField;
	}

	public WebElement getFaxnoTextField() {
		return FaxnoTextField;
	}

	public WebElement getWebsiteTextField() {
		return WebsiteTextField;
	}

	public WebElement getLeadNoTextField() {
		return LeadNoTextField;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void CreateLead(String lastname,String company,String title,String email,String firstname,String phone,String fax,String website,String employes,String secondary) {
		LastNameTextField.sendKeys(lastname);
		CompanyTextField.sendKeys(company);
		TitleTextField.sendKeys(title);
		EmailTextField.sendKeys(email);
		FirstNameTextField.sendKeys(firstname);
		PhonenoTextField.sendKeys(phone);
		FaxnoTextField.sendKeys(fax);
		WebsiteTextField.sendKeys(website);
		NoOfEmployessTextField.sendKeys(employes);
		SecondaryTextField.sendKeys(secondary);
		SaveButton.click();
	}	
	public void CreateLead1(String lastname,String company,String title) {
		LastNameTextField.sendKeys(lastname);
		CompanyTextField.sendKeys(company);
		TitleTextField.sendKeys(title);
		SaveButton.click();
	}
	
	
  }
	


	
		
	   	
		


