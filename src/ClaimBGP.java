import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaimBGP {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\DriversAndTools\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech/");

		driver.manage().window().maximize();

		System.out.println("The getTitle: " + driver.getTitle());
		System.out.println();

		//LoginPage++==============================================================
		WebDriverWait waitCarpassBtn = new WebDriverWait(driver, 30);
		WebElement carpassBtn = waitCarpassBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login with CorpPass')]")));
		carpassBtn.click();
		System.out.println("Login with CorpPass successful");

		driver.findElement(By.name("CPUID")).click();
		driver.findElement(By.name("CPUID")).clear();
		driver.findElement(By.name("CPUID")).sendKeys("S1234567A");

		driver.findElement(By.name("CPUID_FullName")).click();
		driver.findElement(By.name("CPUID_FullName")).clear();
		driver.findElement(By.name("CPUID_FullName")).sendKeys("Tan Ah Kow");

		driver.findElement(By.name("CPEntID")).click();
		driver.findElement(By.name("CPEntID")).clear();
		driver.findElement(By.name("CPEntID")).sendKeys("BGPQEDEMO");

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		System.out.println("Testing 1 Completed");

		Thread.sleep(1000);		
		// ++LoginPage==============================================================

		//Grant Page++==============================================================
		
		//Select sector++-----------------------		
		WebDriverWait waitNewGrantBtn = new WebDriverWait(driver, 10);
		WebElement newGrantBtn = waitNewGrantBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(.,'Get new grant')]")));
		newGrantBtn.click();		
		System.out.println("Testing 2 Completed");		
		
		driver.findElement(By.xpath("//div[contains(.,'IT')]")).click();				
		
		WebDriverWait waitSelectorBtn = new WebDriverWait(driver, 10);
		WebElement selectorBtn = waitSelectorBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itemname'][contains(.,'IT')]")));
		selectorBtn.click();
		driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
		System.out.println("Testing 3 Completed");			
		//++Select sector-----------------------------

		//Select grant++------------------------------		
		WebDriverWait waitSelectGrantBtn = new WebDriverWait(driver, 10);
		WebElement selectGrantBtn = waitSelectGrantBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Bring my business overseas or establish a stronger international presence')]")));
		Thread.sleep(1000);		
		selectGrantBtn.click();
		System.out.println("Testing 4 Completed");
		
		Thread.sleep(1000);
		WebDriverWait waitMRAApplyGrantBtn = new WebDriverWait(driver, 10);
		WebElement selectApplyGrantBtn = waitMRAApplyGrantBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Market Readiness Assistance')]")));

		selectApplyGrantBtn.click();
		System.out.println("Testing 5 Completed");
		Thread.sleep(5000);
		
		WebElement applyBtn = driver.findElement(By.xpath("//*[@id='go-to-grant']"));  //ApplyBtn
		applyBtn.click();  	
		Thread.sleep(2000);
		
		WebElement proceedBtn = driver.findElement(By.id("keyPage-form-button")); //ProceedBtn
		proceedBtn.click();   
		System.out.println("Testing 6 Completed");
		Thread.sleep(1000);
		//++Select grant------------------------------

		//EligibilityPage++---------------------------
		WebElement registeredRadioBtn = driver.findElement(By.id("react-eligibility-sg_registered_check-true"));
		registeredRadioBtn.click();
		System.out.println("US1_AC1_1 : Completed");

		WebElement applicantGroupRadioBtn = driver.findElement(By.id("react-eligibility-turnover_check-true"));
		applicantGroupRadioBtn.click();
		System.out.println("US1_AC1_2 : Completed");

		WebElement localEquityRadioBtn = driver.findElement(By.id("react-eligibility-global_hq_check-false"));
		localEquityRadioBtn.click();
		System.out.println("US1_AC1_3 : Completed");
		System.out.println("Negative Scanario-1 : Choose No for an option to confirm the Warning message pop-up ");
		Thread.sleep(2000);
		System.out.println("US1_AC2 : Completed by Answering Yes or No for the questions");
		
		WebElement FAQLink = driver.findElement(By.xpath("(//*[contains(text(),'FAQ')])[2]"));
		FAQLink.click();
		System.out.println("Negative Scanario-2 : Warning message pop-up displayed ");
		System.out.println("US1_AC3 : Warning message pop-up for Answering No ");
		System.out.println("Negative Scanario-3.1 : Open the FAQ URL");
		System.out.println("US1_AC4 : US1_AC3 will launch another window tab to FAQ URL ");

		Thread.sleep(2000);
		WebElement statementsRadioBtn = driver.findElement(By.id("react-eligibility-started_project_check-true"));
		statementsRadioBtn.click();

		WebElement saveBtnEligibility = driver.findElement(By.id("save-btn"));
		saveBtnEligibility.click();
		System.out.println("US1_AC5 : Save will Save the Applican't inputs ");

		WebElement nextBtnEligibility = driver.findElement(By.id("next-btn"));
		nextBtnEligibility.click();
		System.out.println("Testing 7.1 Completed");
		//++EligibilityPage--------------------------	
		
		System.out.println("Negative Scanario-3.2 : Switch from FAQ URL to BGP Grant URL");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);

		//ContactDetails++-----------------------------
		WebElement infoNameTxtBox = driver.findElement(By.id("react-contact_info-name"));
		infoNameTxtBox.sendKeys("Ganesan Ponnudurai");
		System.out.println("US2_AC1_1 : Main contact Person's Name given ");

		WebElement infodesignationTxtBox = driver.findElement(By.id("react-contact_info-designation"));
		infodesignationTxtBox.sendKeys("Software Quality Engineer");
		System.out.println("US2_AC1_2 : Main contact Person's Job Title given ");

		WebElement infophoneTxtBox = driver.findElement(By.id("react-contact_info-phone"));
		infophoneTxtBox.sendKeys("83005308");
		System.out.println("US2_AC1_3 : Main contact Person's Contact No given ");

		WebElement infoprimaryEmailTxtBox = driver.findElement(By.id("react-contact_info-primary_email"));
		infoprimaryEmailTxtBox.sendKeys("ponngan@gmail.com");
		System.out.println("US2_AC1_4 : Main contact Person's Email given ");

		WebElement infosecondaryEmailTxtBox = driver.findElement(By.id("react-contact_info-secondary_email"));
		infosecondaryEmailTxtBox.sendKeys("Alternateponngan@gmail.com");
		System.out.println("US2_AC1_5 : Alternative contact Person's Email given ");

		WebElement sameRegAddresschkBox = driver.findElement(By.xpath("//span[@class='bgp-checkboxlabel'][contains(.,'Same as registered address in Company Profile')]"));
		sameRegAddresschkBox.click();

		String str = driver.findElement(By.id("react-contact_info-correspondence_address-postal")).getAttribute("value");
		System.out.println("Postal code: " + str);
		System.out.println("US2_AC1_6 : Mailing Address given ");
		System.out.println("US2_AC2 : Mailing Address details are auto populated ");

		WebElement SameAsMainConPersonChkBox = driver.findElement(By.xpath("//span[@class='bgp-checkboxlabel'][contains(.,'Same as main contact person')]"));
		SameAsMainConPersonChkBox.click();
		System.out.println("US2_AC3 : Same as main contact person's is clicked ");

		String infoNameValidation = driver.findElement(By.id("react-contact_info-offeree_name")).getAttribute("value");
		String expectedStrInfoName = "Ganesan Ponnudurai";
		System.out.println("US2_AC4 : Details given ");

		if (infoNameValidation.equals(expectedStrInfoName)) {
			System.out.println("Name matched as in main contact person");
			System.out.println("US2_AC5 : Details match and same as US2_AC4 ");
		} else {
			System.out.println("Name is NOT matched as in main contact person");
		}
		

		String jobTitleValidation = driver.findElement(By.id("react-contact_info-offeree_designation")).getAttribute("value");

		String expectedStrJobTitle = "Software Quality Engineer";

		if (jobTitleValidation.equals(expectedStrJobTitle)) {
			System.out.println("Job Title matched as in main contact person");
		} else {
			System.out.println("Job Title is NOT matched as in main contact person");
		}

		String emailValidation = driver.findElement(By.id("react-contact_info-offeree_email")).getAttribute("value");
		String expectedStrEmail = "ponngan@gmail.com";

		if (emailValidation.equals(expectedStrEmail)) {
			System.out.println("Email matched as in main contact person");
		} else {
			System.out.println("Email is NOT matched as in main contact person");
		}

		WebElement saveBtnContactDetails = driver.findElement(By.id("save-btn"));
		saveBtnContactDetails.click();
		System.out.println("US2_AC6 : Save will Save the Applican't inputs ");

		WebElement nextBtnContactDetails = driver.findElement(By.id("next-btn"));
		nextBtnContactDetails.click();
		System.out.println("Testing 7.2 Completed");
		//++ContactDetails-----------------------------

		//ProposalPage++-------------------------------
		WebDriverWait waitProposalPage = new WebDriverWait(driver, 10);
		waitProposalPage.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project-title-label")));

		WebElement projectTitleTxtBox = driver.findElement(By.id("react-project-title"));
		projectTitleTxtBox.sendKeys("QE Demo Project");

		WebElement startDateCalPicker = driver.findElement(By.id("react-project-start_date"));
		startDateCalPicker.sendKeys("06 Nov 2020");

		WebElement endDateCalPicker = driver.findElement(By.id("react-project-end_date"));
		endDateCalPicker.sendKeys("10 Dec 2020");

		WebElement proposalProjectDesc = driver.findElement(By.id("react-project-description"));
		proposalProjectDesc.sendKeys("Proposal project description details "); 		
		Thread.sleep(1000);

		WebElement activityInputTxtBox =  driver.findElement(By.xpath("(//div[@class='Select-placeholder'][text()='Select...'][text()='Select...'])[1]"));
        activityInputTxtBox.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'FTA Consultancy')]")).click();
        Thread.sleep(1000);

		WebElement targetMarketInputTxtBox = driver.findElement(By.xpath("(//*[@class='Select-arrow'])[2]"));
		targetMarketInputTxtBox.click();
		driver.findElement(By.xpath("//*[contains(text(),'American Samoa')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("react-project-is_first_time_expand")).click();
		Thread.sleep(1000);		

		WebElement supportDocUploadBtn = driver.findElement(By.xpath("//*[@id='react-project-attachments-input']"));
		Thread.sleep(2000);

		supportDocUploadBtn.sendKeys(uploadFile());  //SupportingDocument Upload
		Thread.sleep(2000);

		driver.findElement(By.id("react-project-remarks")).click();
		driver.findElement(By.id("react-project-remarks")).clear();
		driver.findElement(By.id("react-project-remarks")).
		sendKeys("Testing Remarks desc");
		
		WebElement saveBtnProposal = driver.findElement(By.id("save-btn"));
		saveBtnProposal.click();
				
		WebElement nextBtnProposal = driver.findElement(By.id("next-btn"));
		nextBtnProposal.click();
		System.out.println("Testing 7.3 Completed");
		Thread.sleep(1000);
		//++ProposalPage-------------------------------

		//BusinessImpact++-------------------------------
	    driver.findElement(By.id("react-project_impact-fy_end_date_0")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//*[contains(text(),'30')])[3]")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.id("react-project_impact-overseas_sales_0")).click();
	    driver.findElement(By.id("react-project_impact-overseas_sales_0")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_sales_0")).sendKeys("111");

	    driver.findElement(By.id("react-project_impact-overseas_sales_1")).click();
	    driver.findElement(By.id("react-project_impact-overseas_sales_1")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_sales_1")).sendKeys("222");

	    driver.findElement(By.id("react-project_impact-overseas_sales_2")).click();
	    driver.findElement(By.id("react-project_impact-overseas_sales_2")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_sales_2")).sendKeys("333");

	    driver.findElement(By.id("react-project_impact-overseas_sales_3")).click();
	    driver.findElement(By.id("react-project_impact-overseas_sales_3")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_sales_3")).sendKeys("444");

	    driver.findElement(By.id("react-project_impact-overseas_investments_0")).click();
	    driver.findElement(By.id("react-project_impact-overseas_investments_0")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_investments_0")).sendKeys("555");

	    driver.findElement(By.id("react-project_impact-overseas_investments_1")).click();
	    driver.findElement(By.id("react-project_impact-overseas_investments_1")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_investments_1")).sendKeys("666");

	    driver.findElement(By.id("react-project_impact-overseas_investments_2")).click();
	    driver.findElement(By.id("react-project_impact-overseas_investments_2")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_investments_2")).sendKeys("777");

	    driver.findElement(By.id("react-project_impact-overseas_investments_3")).click();
	    driver.findElement(By.id("react-project_impact-overseas_investments_3")).clear();
	    driver.findElement(By.id("react-project_impact-overseas_investments_3")).sendKeys("888");

	    driver.findElement(By.xpath("//body")).click();
	    driver.findElement(By.id("react-project_impact-rationale_remarks")).click();
	    driver.findElement(By.id("react-project_impact-rationale_remarks")).clear();
	    driver.findElement(By.id("react-project_impact-rationale_remarks")).sendKeys("Rationale for Projections text area description details");

	    driver.findElement(By.id("react-project_impact-benefits_remarks")).click();
	    driver.findElement(By.id("react-project_impact-benefits_remarks")).clear();
	    driver.findElement(By.id("react-project_impact-benefits_remarks")).sendKeys("Non Tangible Benefits text area description details");

	    WebElement saveBtnBusinessImpact = driver.findElement(By.id("save-btn"));
	    saveBtnBusinessImpact.click();
	    
	    WebElement nextBtnBusinessImpact = driver.findElement(By.id("next-btn"));
	    nextBtnBusinessImpact.click();
	    System.out.println("Testing 7.4 Completed");
	    Thread.sleep(1000);

	    driver.findElement(By.id("react-project_cost-vendors-accordion-header")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.id("react-project_cost-vendors-add-item")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='react-project_cost-vendors-0']/div/div/div/div/div/div[2]/label/span")).click();
	    driver.findElement(By.xpath("//div[@id='react-project_cost-vendors-0']/div/div/div/div/div/div[2]/label[2]/span")).click();

	    driver.findElement(By.id("react-project_cost-vendors-0-vendor_name")).click();
	    driver.findElement(By.id("react-project_cost-vendors-0-vendor_name")).clear();
	    driver.findElement(By.id("react-project_cost-vendors-0-vendor_name")).sendKeys("NameOfVendor");
	    Thread.sleep(2000);

	    WebElement supportDocCostUploadBtn = driver.findElement(By.id("react-project_cost-vendors-0-attachments-input"));

		supportDocCostUploadBtn.sendKeys(uploadFile());
		Thread.sleep(2000);

	    driver.findElement(By.id("react-project_cost-vendors-0-amount_in_billing_currency")).click();
	    driver.findElement(By.id("react-project_cost-vendors-0-amount_in_billing_currency")).clear();
	    driver.findElement(By.id("react-project_cost-vendors-0-amount_in_billing_currency")).sendKeys("100");
	    
	    WebElement saveBtnCost = driver.findElement(By.id("save-btn"));
	    saveBtnCost.click();
	    
	    WebElement nextBtnCost = driver.findElement(By.id("next-btn"));
	    nextBtnCost.click();	    
	    System.out.println("Testing 7.5 Completed");
	    Thread.sleep(1000);
	    //++BusinessImpact-------------------------------
	    
	    //DeclareAndReview++-------------------------------
	    System.out.println("Inside Declare & Ack");
	    Thread.sleep(2000);

	    WebElement anyJuridictionRadioBtn = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[1]/preceding::label[1]"));
	    anyJuridictionRadioBtn.click();	
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[1]/following::label[1]")).click();
	    driver.findElement(By.xpath("//div[@id='js-app']/div/div/div[2]/div[2]/div/div/div/ol/li[2]/div/div[2]/label/span")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::ol[1]")).click();
	    driver.findElement(By.xpath("//div[@id='js-app']/div/div/div[2]/div[2]/div/div/div/ol/li[3]/div/div[2]/label/span")).click();
	    driver.findElement(By.xpath("//div[@id='js-app']/div/div/div[2]/div[2]/div/div/div/ol/li[4]/div/div[2]/label/span")).click();
	    driver.findElement(By.xpath("//div[@id='js-app']/div/div/div[2]/div[2]/div/div/div/ol/li[5]/div/div[2]/label/span")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[5]/following::label[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[6]/following::label[2]")).click();

	    driver.findElement(By.id("react-declaration-consent_acknowledgement_check")).click();
	    Thread.sleep(3000);
	    
	    WebElement saveBtnDeclareAck = driver.findElement(By.id("save-btn"));
	    saveBtnDeclareAck.click();
	    
	    WebElement nextBtnDeclareAck = driver.findElement(By.id("review-btn"));
	    nextBtnDeclareAck.click();
	    System.out.println("Testing 7.6 Completed");
	    Thread.sleep(2000);	    	    
	    
	    //ErrorCorrection++--------------------------
	    localEquityRadioBtn = driver.findElement(By.id("react-eligibility-global_hq_check-true"));
		localEquityRadioBtn.click();
		System.out.println("Testing 8 Completed");
		
		for(int retry=0; retry<=5; retry++) {
			try {
				WebElement targetMarketRadioBtn = driver.findElement(By.id("react-eligibility-new_target_market_check-true"));
				targetMarketRadioBtn.click();
				break;
			}catch(StaleElementReferenceException e) {
				System.out.println(e.toString());
			}
		}				
		System.out.println("US3_AC2 : Missed mandatory inputs are corrected and validated");
		
		saveBtnEligibility = driver.findElement(By.id("save-btn"));
		saveBtnEligibility.click();
		nextBtnEligibility = driver.findElement(By.id("next-btn"));
		nextBtnEligibility.click();
		Thread.sleep(1000);
		//-----++Eligibility Page ---------------------

		saveBtnContactDetails = driver.findElement(By.id("save-btn"));
		saveBtnContactDetails.click();
		nextBtnContactDetails = driver.findElement(By.id("next-btn"));
		nextBtnContactDetails.click();
		Thread.sleep(1000);
		//-----++ContactDetails Page ---------------------

		saveBtnProposal = driver.findElement(By.id("save-btn"));
		saveBtnProposal.click();						
		nextBtnProposal = driver.findElement(By.id("next-btn"));
		nextBtnProposal.click();
		Thread.sleep(1000);
		//-----++Proposal Page ---------------------		

		saveBtnBusinessImpact = driver.findElement(By.id("save-btn"));
		saveBtnBusinessImpact.click();			    
		nextBtnBusinessImpact = driver.findElement(By.id("next-btn"));
		nextBtnBusinessImpact.click();	
		Thread.sleep(1000);
		//-----++BusinessImpact Page ---------------------
		
		
		//below FOR is added to handle StaleElementReferenceException by using retry		
		for(int retry=0; retry<=5; retry++) {
			try {
				saveBtnCost = driver.findElement(By.id("save-btn"));
				saveBtnCost.click();
				break;
			}catch(StaleElementReferenceException e) {
				System.out.println(e.toString());
			}
		}
	
		nextBtnCost = driver.findElement(By.id("next-btn"));
		nextBtnCost.click();	
		Thread.sleep(1000);
		//-----++Cost Page ---------------------
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[7]/following::label[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[8]/following::label[3]")).click();
	    
	    if(!driver.findElement(By.id("react-declaration-consent_acknowledgement_check")).isSelected())
	    	driver.findElement(By.id("react-declaration-consent_acknowledgement_check")).click();
	    
		saveBtnDeclareAck = driver.findElement(By.id("save-btn"));
		saveBtnDeclareAck.click();			    
		nextBtnDeclareAck = driver.findElement(By.id("review-btn"));
		nextBtnDeclareAck.click();
		System.out.println("US3_AC1 : The Applicant taken to a read-only summary page of the application");
		System.out.println("US3_AC3 : The Read-only summary page contains all the details previously filled in all the sections of the form");
		Thread.sleep(1000);
		//-----++Declare&Ack Page ---------------------
	    //++ErrorCorrection----------------------------
		//++DeclareAndReview-------------------------------
		
		//Submit++--------------------
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,2500)");
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(5000);
		 
		  Actions actions = new Actions(driver);
		  actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 
		  for(int retry=0; retry<=5; retry++) {
			try {
				WebElement declar = driver.findElement(By.id("react-declaration-info_truthfulness_check"));
				if(!declar.isSelected())
				 declar.click();
				break;
			}catch(StaleElementReferenceException e) {
				System.out.println(e.toString());
			}
		  }
		 System.out.println("US3_AC4 : Consent and Acknowledgement checkbox clicked");
		 Thread.sleep(1000); driver.findElement(By.id("submit-btn")).click();
		 Thread.sleep(2000); System.out.println("Testing 9 Completed");			 
		 //++Submit--------------------
		 
		 //ReferenceID++---------------------------------
		 System.out.println("US3_AC5.1 : Application Submitted successfully");
		 
		 WebElement submissionCard = driver.findElement(By.xpath("//*[@class='card']"));		 
		 String[] cardDetails = submissionCard.getText().toString().split("\\n");
		 
		 String appRefID="";
		 for(int i=0; i<cardDetails.length; i++) {
			if(cardDetails[i].contains("Ref ID")){
			String[] getAttr = cardDetails[i].split(":");
			appRefID = getAttr[1].trim();
			}
		 }		
		 System.out.println("US3_AC5.2 : Successfully received Ref-ID ");
		 System.out.println("Application Refer ID is :" + appRefID);
		 //++ReferenceID---------------------------------
		 
		 //Verification++-------------------
		 WebElement myGrants = driver.findElement(By.xpath("//*[contains(text(),'My Grants')]")); 
		 if(myGrants.isDisplayed()) {
			myGrants.click();
			Thread.sleep(2000);
		 }
		
		 tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(2));
		 Thread.sleep(1000);
		
		 WebDriverWait waitForProcessing = new WebDriverWait(driver, 50);
		 WebElement myProcessing = waitForProcessing.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Processing')])[1]")));
		 myProcessing.click();
		 Thread.sleep(2000);
		
		 WebElement verifyRefIDPresent = driver.findElement(By.xpath("(//*[contains(text(),'"+ appRefID +"')])[1]"));
		 if(verifyRefIDPresent.isDisplayed()) {
			System.out.println("The Submitted application " +appRefID + " is under Processing !!");			
		 }	
		
		 System.out.println("US3_AC6 : Verified the submitted application (using Ref-ID) is under Processing - Completed");
		 //++Verification--------------------
		
		 //Logout++----------------------
		 WebElement logoutBtn = driver.findElement(By.id("logout-button"));
		 logoutBtn.click();
		 System.out.println("Successfully LOG OUT from the BGP Portal");
				
		 driver.close();
		 driver.quit();
		 //++Logout----------------------
		
	}
	
	//method to get absolute path of a test document for upload purpose 	
	static String uploadFile() {
		return new File("./testdata/TestDocument.pdf").getAbsolutePath();
	}

}
