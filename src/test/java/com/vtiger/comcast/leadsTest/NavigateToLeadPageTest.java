package com.vtiger.comcast.leadsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.CreatingNewLead;
import com.vtiger.comcast.pomrepositylib.HomePage;
import com.vtiger.comcast.pomrepositylib.LeadInformationPage;
import com.vtiger.comcast.pomrepositylib.LeadsPage;

//@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementingClass.class)
public class NavigateToLeadPageTest extends BaseClass{
	
    @Test(priority=1,groups = {"smokeTest"})
	public void  navigateToLeadPageTest() throws Throwable {
		
		
		
		//step 02 Navigate to Leads
		HomePage homepage=new HomePage(driver);
		boolean verifyhomepage=homepage.getAdministratorText().isDisplayed();
		Assert.assertTrue(verifyhomepage);
		System.out.println(verifyhomepage);
		
		
		homepage.getLeadLink().click();
		
		
		//step 03 "create new leads page"by click on"+" image
		LeadsPage leadspage=new LeadsPage(driver);
		leadspage.getCreateleadImg().click();
		
		CreatingNewLead createnewlead=new CreatingNewLead(driver);
		boolean verifycreatelead=createnewlead.getSaveButton().isDisplayed();
		Assert.assertTrue(verifycreatelead);
		
		
	 }

	
   @Test(priority=2,groups= {"smokeTest","regressionTest"})
	public void CreateNewLeadByFillAllTheMandotoryFieldsAndSaveTest() throws Throwable {
		
	   int randomint = jLib.getRanDomNumber();
	   
	   /*test script Data*/
		String lastname = eLib.getDataFromExcel("Sheet1", 4,2)+randomint;
		String company = eLib.getDataFromExcel("Sheet1", 4, 3);
		String title = eLib.getDataFromExcel("Sheet1", 4, 4);
		
		HomePage homepage=new HomePage(driver);
		boolean verifyhomepage=homepage.getAdministratorText().isDisplayed();
		Assert.assertTrue(verifyhomepage);
		
		homepage.getLeadLink().click();
		
		
		//step 03 "create new leads page"by click on"+" image
		LeadsPage leadspage=new LeadsPage(driver);
		leadspage.getCreateleadImg().click();
		
		//step 04 create leads
		CreatingNewLead createnewlead=new CreatingNewLead(driver);
		
		boolean verifycreatelead=createnewlead.getSaveButton().isDisplayed();
		Assert.assertTrue(verifycreatelead);
		
		createnewlead.CreateLead1(lastname, company, title);
		
		
		Thread.sleep(5000);
		
		
		//step 05 verify the successful message with leads name
		LeadInformationPage leadinformationpage=new LeadInformationPage(driver);
		String actsuccessmsg = leadinformationpage.getSuccessFullMessage().getText();
		
		boolean verifysuccessfullmsg=actsuccessmsg.contains(lastname);
		Assert.assertTrue(verifysuccessfullmsg);
		
		boolean verifyleadno=leadinformationpage.getUniqueLeadNo().isDisplayed();
		Assert.assertTrue(verifyleadno);
		System.out.println("LeadNo:="+leadinformationpage.getUniqueLeadNo().getText());
   }
		
		
		 @Test(priority=3,groups= {"regressionTest"})
			public void CreateNewLeadByFillAllTheFieldsAndSaveTest() throws Throwable {
				
			   int randomint = jLib.getRanDomNumber();
			   
			   /*test script Data*/
				String lastname = eLib.getDataFromExcel("Sheet1", 1,2)+randomint;
				String company = eLib.getDataFromExcel("Sheet1", 1, 3);
				String title = eLib.getDataFromExcel("Sheet1", 1, 4);
				String firstname = eLib.getDataFromExcel("Sheet1", 1, 5);
				String phone = eLib.getDataFromExcel("Sheet1", 1, 6);
				String email = eLib.getDataFromExcel("Sheet1", 1, 7);
				String fax = eLib.getDataFromExcel("Sheet1", 1, 8);
				String website = eLib.getDataFromExcel("Sheet1", 1, 9);
				String employes = eLib.getDataFromExcel("Sheet1", 1, 10);
				String secondary = eLib.getDataFromExcel("Sheet1", 1, 11);
				HomePage homepage=new HomePage(driver);
				boolean verifyhomepage=homepage.getAdministratorText().isDisplayed();
				Assert.assertTrue(verifyhomepage);
				
				homepage.getLeadLink().click();
				
				
				//step 03 "create new leads page"by click on"+" image
				LeadsPage leadspage=new LeadsPage(driver);
				leadspage.getCreateleadImg().click();
				
				//step 04 create leads
				CreatingNewLead createnewlead=new CreatingNewLead(driver);
				
				boolean verifycreatelead=createnewlead.getSaveButton().isDisplayed();
				Assert.assertTrue(verifycreatelead);
				
				createnewlead.CreateLead(lastname, company, title, email, firstname, phone, fax, website, employes, secondary);
			
				
				
				Thread.sleep(5000);
				
				
				//step 05 verify the successful message with leads name
				LeadInformationPage leadinformationpage=new LeadInformationPage(driver);
				String actsuccessmsg = leadinformationpage.getSuccessFullMessage().getText();
				if(actsuccessmsg.contains(lastname)) {
					System.out.println(lastname + "CREATED SUCCESSFULLY");
				}else {
					System.out.println(lastname + "NOT CREATED SUCCESSFULLY");
				}
				
				boolean verifyleadno=leadinformationpage.getUniqueLeadNo().isDisplayed();
				Assert.assertTrue(verifyleadno);
				System.out.println("LeadNo:="+leadinformationpage.getUniqueLeadNo().getText());
				 
		 
		
	}

}
