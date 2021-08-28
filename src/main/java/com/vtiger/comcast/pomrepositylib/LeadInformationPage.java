package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement SuccessFullMessage;
	
	@FindBy(xpath = "//td[text()='Lead No']/following-sibling::td[@class='dvtCellInfo']")
	private WebElement uniqueLeadNo;
	

	public WebElement getUniqueLeadNo() {
		return uniqueLeadNo;
	}


	public WebElement getSuccessFullMessage() {
		return SuccessFullMessage;
			
	}
	
}
