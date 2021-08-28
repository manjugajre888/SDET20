package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@title='Create Lead...']")
		private WebElement CreateleadImg;
		
		
		public WebElement getCreateleadImg() {
			return CreateleadImg;
		}
		
		
		
	}


