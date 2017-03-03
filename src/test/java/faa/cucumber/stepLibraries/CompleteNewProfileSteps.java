package faa.cucumber.stepLibraries;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import faa.cucumber.pages.AddNewUasPage;
import faa.cucumber.pages.AddressValidationPage;
import faa.cucumber.pages.BillingInformationPage;
import faa.cucumber.pages.CreateNewProfilePage;
import faa.cucumber.pages.FaaHomePage;
import faa.cucumber.pages.RandomValuesPage;
//import faa.cucumber.pages.NewAccountPage;
import faa.utils.DataGenerator;
import faa.utils.LogToFile;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
//import cucumber.api.java.Before;


public class CompleteNewProfileSteps {

	//NewAccountPage newAccountPage;
	CreateNewProfilePage createNewProfilePage;
	AddressValidationPage addressValidationPage;
	BillingInformationPage billingInformationPage;
	AddNewUasPage addNewUasPage;
	FaaHomePage faaHomePage;
	RandomValuesPage randomValuesPage;
	
	public static Properties serenityProperties;
	
	String physicalCountry = "United States";
	String[] profileAddress  = DataGenerator.randomAddress();
	String[] mailingAddress  = DataGenerator.randomAddress();
	
	String[] profileInternationalAddress  = DataGenerator.randomAddressInternational();
	String[] mailingInternationalAddress  = DataGenerator.randomAddressInternational();
	
	@Step
	public void clickOnCancelHobbyistRegistrationButton(){
		createNewProfilePage.clickOnHobbyistCancelRegistrationButton(); 
	}
	
	@Step
	public void clickOnRenewHobbyistRegistrationButton(){
		createNewProfilePage.clickOnHobbyistRenewRegistrationButton(); 
	}
	
	@Step 
	public void clickOnModelAircraftTypeButton(){
		createNewProfilePage.clickOnModelAircraftButton();
	}
	@Step 
	public void clickOnNonModelAircraftButton(){
		createNewProfilePage.clickOnNonModelAircraftButton();
	}
	
	@Step
	public void clickOnManageSuasInventoryButton(){
		createNewProfilePage.clickOnManageSuasInventoryButton();
	}
	@Step
	public void clickOnManageUserAccountsButton(){
		createNewProfilePage.clickOnManageUserAccountsButton();
	}
	
	@Step 
	public void clickOnManageAccessToolButton(){
		createNewProfilePage.clickOnManageAccessToolButton();
	}
	
	@Step
	public void clickOnUsersTab(){
		faaHomePage.clickOnUsersTab();
	}
	
	@Step
	public void clickOnExpiredUserDetailsButton(){
		faaHomePage.clickOnExpiredUserDetailsButton();
	}
	
	
	@Step
	public void clickOnExpiredUserEditButton(){
		faaHomePage.clickOnExpiredUserEditButton();
	}
	
	@Step
	public void clickOnExpiredUserResendInvitationButton(){
		faaHomePage.clickOnExpiredUserResendInvitationButton();
	}
	
	@Step
	public void clickOnAddUserOption(){
		faaHomePage.clickOnAddUserOption();
	}
	
	@Step
	public void clickOnAddUserButton(){
		faaHomePage.clickOnAddUserButton();
	}
	
	@Step
	public void typeIntoInvitedNewUserProfile(){
		faaHomePage.typeIntoInvitedNewUserProfile();
	}
	
	@Step
	public void typeIntoInvitedExistingUserProfile(){
		faaHomePage.typeIntoInvitedExistingUserProfile();
	}

	@Step
	public void verifyUserAlreadyInvitedMessageDisplayed(){
		faaHomePage.verifyUserAlreadyInvitedMessageDisplayed();
	}	
		
	
	@Step
	public void clickCancelInviteButton(){
		faaHomePage.clickCancelInviteButton();
	}

	
	
	@Step
	public void typeIntoAcceptInvitation(){
		String varNewInvitedEmailAccount = Serenity.sessionVariableCalled("newInvitedEmailAccount").toString();
		//Serenity.setSessionVariable("newInvitedEmailAccount").to(newInvitedEmailAccount);
		System.out.println("Email address of Newly Invited User is-->" + varNewInvitedEmailAccount);
		///faaHomePage.switchToNextTab();
		//faaHomePage.clickOnSubmitAcceptInvitationButton();
//		System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
//		driver= new ChromeDriver();
//		driver.get("http://www.google.com");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		faaHomePage.typeIntoAcceptInvitationPasswordField();
		faaHomePage.typeIntoAcceptInvitationConfirmPasswordField();
		faaHomePage.clickOnSubmitAcceptInvitationButton();
		
		System.out.println("Logged in with accepted invitation account");
	}
	
	@Step
	public void typeIntoCreateProfileFirstName(){
		createNewProfilePage.typeIntoCreateProfileFirstName();
		Serenity.setSessionVariable(null);
		System.out.println("Profile First Name is " + createNewProfilePage.getTypeIntoCreateProfileFirstName());
		String newNonHobbyistFirstName = createNewProfilePage.getTypeIntoCreateProfileFirstName();
		Serenity.setSessionVariable("newNonHobbyistFirstName").to(newNonHobbyistFirstName);
	}

	@Step
	public void typeIntoCreateProfileMiddleInitial(){
		createNewProfilePage.typeIntoCreateProfileMiddleInitial();
		System.out.println("Profile Middle Intial is " + createNewProfilePage.getTypeIntoCreateProfileMiddleInitial());
	}
	
	@Step
	public void typeIntoCreateProfileLastName(){
		createNewProfilePage.typeIntoCreateProfileLastName();
		System.out.println("Profile Last Name is " + createNewProfilePage.getTypeIntoCreateProfileLastName());
		String newNonHobbyistLastName = createNewProfilePage.getTypeIntoCreateProfileLastName();
		Serenity.setSessionVariable("newNonHobbyistLastName").to(newNonHobbyistLastName);
		
	}
	
	@Step
	public void typeIntoCreateProfileNameSuffix(){
		createNewProfilePage.typeIntoCreateProfileNameSuffix();
		System.out.println("Profile Suffix Name is " + createNewProfilePage.getCreateProfileNameSuffix());

	}
	@Step
	public void typeIntoCreateProfileTitle(){
		createNewProfilePage.typeIntoCreateProfileTitle();
		System.out.println("Profile Title is " + createNewProfilePage.getCreateProfileNameTitle());
	}
	//Update an existing account
	@Step
	public void typeIntoCreateProfileAltEmail(){
		//String varNewFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAcountEmail").toString();
		String varNewFaaAcountEmail = "mynewfaadrone+300@gmail.com";
		System.out.println("Type newFaaAcountEmail Into Alternate Email-->" + varNewFaaAcountEmail);
		createNewProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAcountEmail);
	}

	//Creating a new account
	@Step
	public void typeIntoCreateNewProfileAltEmail(){
		//Retrieve new account
		String varNewFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
		System.out.println("Type New Email Address for newFaaAccount Into Alternate Email-->" + varNewFaaAcountEmail);
		createNewProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAcountEmail);
	}
	
	
	
	
	
	
	
	
	
	
//
//		
//		if (Serenity.sessionVariableCalled("newFaaAccount").toString().equals(null)){
//			String varNewFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAcountEmail").toString();
//			System.out.println("Type newFaaAcountEmail Into Alternate Email-->" + varNewFaaAcountEmail);
//			createNewProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAcountEmail);
//		} else {
//		String varNewFaaAccount = Serenity.sessionVariableCalled("newFaaAccount").toString();
//		System.out.println("Type newFaaAccount Into Alternate Email-->" + varNewFaaAccount);
//		createNewProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAccount);
//		}
//	}	

	@Step
	public void typeIntoUpdateProfileAltEmail(String updateAltEmail){
		createNewProfilePage.typeIntoUpdateProfileAlternateEmail(updateAltEmail);
		System.out.println("Update Profile Alternate Email Address as: " + updateAltEmail); 
		//createNewProfilePage.getCreateProfileAlternateEmail());
	}
	

	
	@Step
	public void typeIntoCreateProfilePhone(){
		createNewProfilePage.typeIntoCreateProfilePhone();
//		System.out.println("Profile Phone Number is: " + createNewProfilePage.getCreateProfilePhone());

	}
	@Step
	public void typeIntoCreateProfilePhoneExt(){
		createNewProfilePage.typeIntoCreateProfilePhoneExt();
		//Serenity.takeScreenshot(); 
//		System.out.println("Profile Phone Number Extension is: " + createNewProfilePage.getCreateProfilePhoneExt());

		
	}
	@Step
	public void typeIntoCreateProfileOrganization(){
		createNewProfilePage.typeIntoCreateProfileOrganizationName();
		
	}
	@Step
	public void typeIntoCreateProfileDba(){
		createNewProfilePage.typeIntoCreateProfileDba();
		//Serenity.takeScreenshot(); 
	}

	@Step
	public void selectProfilePhysicalCountryDropDownList(){
		//String[] profileAddress  = DataGenerator.randomAllAddress();
		System.out.println("Physical Country Name is: " + profileAddress[0]);
		System.out.println("Physical Address 1 Name is: " + profileAddress[1]);
		System.out.println("Physical Address 2 Name is: " + profileAddress[2]);
		System.out.println("Physical City Name is: " + profileAddress[3]);
		System.out.println("Physical State Name is: " + profileAddress[4]);
		System.out.println("Physical Zip Name is: " + profileAddress[5]);
		Serenity.setSessionVariable("country1").to(profileAddress[0]);
		String newCountry1 = Serenity.sessionVariableCalled("country1").toString();
		System.out.println("On Verify new Country1 is--->" + newCountry1 + "***");
		createNewProfilePage.selectProfilePhysicalCountryDropDown(newCountry1);
		System.out.println("Physical Country Name is: " + newCountry1); 
		////Serenity.takeScreenshot(); 
	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress1(){
		Serenity.setSessionVariable("address1").to(profileAddress[1]);
		String newAddress1 = Serenity.sessionVariableCalled("address1").toString();
		System.out.println("On Verify new Address1 is--->" + newAddress1 + "***");
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(newAddress1);
		System.out.println("PhysicalAddress 1 is: " + newAddress1);
	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress2(){
		Serenity.setSessionVariable("address2").to(profileAddress[2]);
		String newAddress2 = Serenity.sessionVariableCalled("address2").toString();
		System.out.println("On Verify new Address2 is--->" + newAddress2 + "***");
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(newAddress2);
		System.out.println("PhysicalAddress 2 is: " + newAddress2);
	}
	@Step
	public void typeIntoCreateProfileCity(){
		Serenity.setSessionVariable("city1").to(profileAddress[3]);
		String newCity = Serenity.sessionVariableCalled("city1").toString();
		System.out.println("On Verify new City is--->  " + newCity);
		createNewProfilePage.typeIntoCreateProfilePhysicalCity(newCity);
		////Serenity.takeScreenshot(); 
	}
	@Step
	public void selectProfilePhysicalStateDropList(){
		Serenity.setSessionVariable("state1").to(profileAddress[4]);
		String newState = Serenity.sessionVariableCalled("state1").toString();
		System.out.println("On Verify new State is--->" + newState  + "*****");
		System.out.println("New Country is--->" + profileAddress[0] + "*****");
//		if (profileAddress[0].equals("United States")||profileAddress[0].equals("Virgin Islands, U.S." ) || profileAddress[0].equals("Guam") || profileAddress[0].equals("Puerto Rico")){
		if (profileAddress[0].equals("United States")){
		createNewProfilePage.selectFromPhysicalStateNameDropdownList(newState.trim());  
		System.out.println("Physical State Selected from Drop Down List is:-->" + profileAddress[4]);
		} else {
			if (newState == null ||newState.equals(null)||newState.equals(""))		
			{
				System.out.println("The New State value is NULL --->" + newState  + "*****So Do NOT Add a State Value for this address!*****");
			} else {
				createNewProfilePage.typeIntoCreateProfilePhysicalStateNameField(newState.trim());
				System.out.println("Physical Country is not United States, so here is the Country TEXT value: " + profileAddress[0]);
			}
		}	////Serenity.takeScreenshot(); 
	}
	@Step
	public void typeIntoCreateProfileZipCode(){
		Serenity.setSessionVariable("zip1").to(profileAddress[5]);
		String newZip = Serenity.sessionVariableCalled("zip1").toString();
		System.out.println("Physical Country is:-->" + profileAddress[0] + " Physical Zip is:-->" + profileAddress[5]);
		System.out.println("Physical Zip Name from array is: " + profileAddress[5]);
        System.out.println("Physical New Zip is " + newZip);
		if (profileAddress[0].equals("United States")||profileAddress[0].equals("Virgin Islands, U.S." ) || profileAddress[0].equals("Guam") || profileAddress[0].equals("Puerto Rico") ){
        createNewProfilePage.typeIntoCreateProfilePhysicalZip(newZip); 
		} else {
		if (profileAddress[5].equals("N/A")){
		createNewProfilePage.checkThatPhysicalZipPostalNotApplicableCheckboxIsChecked();
		//createNewProfilePage.typeIntoCreateProfilePhysicalZip(newZip);	
		System.out.println("Physical Zip is N/A and POSTAL CODE NOT APPLICABLE Checkbox is checked");
		}
	}	////Serenity.takeScreenshot(); 
}
	
	@Step
	public void clickOnAddressIsSameCheckbox(){
		createNewProfilePage.clickProfileAddressIsSame();
	}
	
	@Step
	public void clickMaSameAsPa(){
		createNewProfilePage.clickMaSameAsPa();
		}
	
	
	@Step
	public void selectProfileMailingCountryFromDropList(){
		System.out.println("Mailing Country Name is: " + mailingAddress[0]);
		System.out.println("Mailing Address 1 Name is: " + mailingAddress[1]);
		System.out.println("Mailing Address 2 Name is: " + mailingAddress[2]);
		System.out.println("Mailing City Name is: " + mailingAddress[3]);
		System.out.println("Mailing State Name is: " + mailingAddress[4]);
		System.out.println("Mailing Zip Name is: " + mailingAddress[5]);
		Serenity.setSessionVariable("mailingCountry").to(mailingAddress[0]);
		String newMailingCountry = Serenity.sessionVariableCalled("mailingCountry").toString();
		System.out.println("On Verify new Mailing Country is--->" + newMailingCountry);
		//Serenity.setSessionVariable("United States").to(country);
		createNewProfilePage.selectProfileMailingCountryDropDown(newMailingCountry);
		System.out.println("Mailing Country Name is: " + newMailingCountry);
		////Serenity.takeScreenshot(); 

	}
	@Step
	public void typeIntoCreateProfileMailingAddress1(){
		Serenity.setSessionVariable("mailingAddress1").to(mailingAddress[1]);
		String newMailingAddress1 = Serenity.sessionVariableCalled("mailingAddress1").toString();
		System.out.println("On Verify new mailing Address1 is--->  " + newMailingAddress1);
		createNewProfilePage.typeIntoCreateProfileMailingAddress1(newMailingAddress1);
		System.out.println("Mailing Address 1 is: " + newMailingAddress1);
	}
	@Step
	public void typeIntoCreateProfileMailingAddress2(){
		Serenity.setSessionVariable("mailingAddress2").to(mailingAddress[2]);
		String newMailingAddress2 = Serenity.sessionVariableCalled("mailingAddress2").toString();
		System.out.println("On Verify new mailing Address2 is--->  " + newMailingAddress2);
		createNewProfilePage.typeIntoCreateProfileMailingAddress2(newMailingAddress2);
		System.out.println("Mailing Address 2 is: " + newMailingAddress2);
	}
	@Step
	public void typeIntoCreateProfileMailingCity(){
		Serenity.setSessionVariable("mailingCity1").to(mailingAddress[3]);
		String newMailingCity = Serenity.sessionVariableCalled("mailingCity1").toString();
		System.out.println("On Verify new mailing City is--->  " + newMailingCity);
		createNewProfilePage.typeIntoCreateProfileMailingCity(newMailingCity);
		System.out.println("Mailing City is: " + newMailingCity);
		////Serenity.takeScreenshot(); 
	}
	
//	@Step
//	public void selectProfileMailingStateDropList(){
//		Serenity.setSessionVariable("mailingState1").to(mailingAddress[4]);
//		String newMailingState = Serenity.sessionVariableCalled("mailingState1").toString();
//		System.out.println("On Verify new mailing State is--->  " + newMailingState);
//		if (mailingAddress[0].equals("United States")||mailingAddress[0].equals("Virgin Islands, U.S." ) || mailingAddress[0].equals("Guam") || mailingAddress[0].equals("Puerto Rico") ){
//			createNewProfilePage.selectFromMailingStateNameDropdownList(newMailingState);
//			//////Serenity.takeScreenshot(); 
//			System.out.println("Selected new mailing State is--->  " + newMailingState);
//		} else {
//			if (newMailingState == null ||newMailingState.equals(null)||newMailingState.equals(""))
//			{
//				System.out.println("The New Mailing State value is NULL ---> " + newMailingState  + "*****So Do NOT Add a State Value for this address!*****");
//			} else { 
//				createNewProfilePage.typeIntoMailingStateNameField(newMailingState.trim());
//				////Serenity.takeScreenshot(); 
//				System.out.println("Mailing Country is not United States, so here is the new State TEXT value:***" + mailingAddress[0] + "***");
//				System.out.println("Check to see what Mailing Country is TEXT value:***" + newMailingState + "***");
//				}
//			}
//		}		

	@Step
	public void selectProfileMailingStateDropList(){
		Serenity.setSessionVariable("mailingState1").to(mailingAddress[4]);
		String newMailingState = Serenity.sessionVariableCalled("mailingState1").toString();
		System.out.println("On Verify new mailing State is--->  " + newMailingState);
//		if (mailingAddress[0].equals("United States")||mailingAddress[0].equals("Virgin Islands, U.S." ) || mailingAddress[0].equals("Guam") || mailingAddress[0].equals("Puerto Rico") ){
		if (mailingAddress[0].equals("United States")){
		createNewProfilePage.selectFromMailingStateNameDropdownList(newMailingState);
			////Serenity.takeScreenshot(); 
		System.out.println("Selected new mailing State is--->  " + newMailingState);
		} else {
			if (newMailingState == null ||newMailingState.equals(null)||newMailingState.equals(""))
			{
				System.out.println("The New Mailing State value is NULL ---> " + newMailingState  + "*****So Do NOT Add a State Value for this address!*****");
			} else { 
				createNewProfilePage.typeIntoMailingStateNameField(newMailingState.trim());
				//Serenity.takeScreenshot(); 
				System.out.println("Mailing Country is not United States, so here is the new State TEXT value:***" + mailingAddress[0] + "***");
				System.out.println("Check to see what Mailing Country is TEXT value:***" + newMailingState + "***");
				}
			}
		}		
	
	
//	@Step
//	public void typeIntoCreateProfileMailingZipCode(){
//		Serenity.setSessionVariable("mailingZip1").to(mailingAddress[5]);
//		String newMailingZip = Serenity.sessionVariableCalled("mailingZip1").toString();
////		if (mailingAddress[0].equals("United States")||mailingAddress[0].equals("Virgin Islands, U.S." ) || mailingAddress[0].equals("Guam") || mailingAddress[0].equals("Puerto Rico") ){
//		System.out.println("Mailing Country is:-->" + mailingAddress[0] + " Physical Zip is:-->" + mailingAddress[5]);
//		createNewProfilePage.typeIntoCreateProfileMailingZip(newMailingZip);
//		//Serenity.takeScreenshot(); 
//	}
//}

	@Step
	public void typeIntoCreateProfileMailingZipCode(){
		Serenity.setSessionVariable("mailingZip1").to(mailingAddress[5]);
		String newMailingZip = Serenity.sessionVariableCalled("mailingZip1").toString();
		System.out.println("Mailing Country is:-->" + mailingAddress[0] + " Mailing Zip is:-->" + mailingAddress[5]);
		System.out.println("Mailing Zip Name from array is: " + mailingAddress[5]);
        System.out.println("Mailing New Zip is " + newMailingZip);
		if (mailingAddress[0].equals("United States")||mailingAddress[0].equals("Virgin Islands, U.S." ) || mailingAddress[0].equals("Guam") || mailingAddress[0].equals("Puerto Rico") ){
		createNewProfilePage.typeIntoCreateProfileMailingZip(newMailingZip);
		//Serenity.takeScreenshot(); 
		} else {
		if (mailingAddress[5].equals("N/A")){
		createNewProfilePage.checkThatMailingZipPostalNotApplicableCheckboxIsChecked();
		//createNewProfilePage.typeIntoCreateProfilePhysicalZip(newZip);	
		System.out.println("Mailing Zip is N/A and POSTAL CODE NOT APPLICABLE Checkbox is checked");
		//Serenity.takeScreenshot(); 

		}
	}	
}
	
	
////////Begin of Int Address
	
	@Step
	public void selectProfilePhysicalIntCountryDropDownList(){
		System.out.println("International Physical Country Name is:" + profileInternationalAddress[0]);
		System.out.println("International Physical Address 1 Name is:" + profileInternationalAddress[1]);
		System.out.println("International Physical Address 2 Name is:" + profileInternationalAddress[2]);
		System.out.println("International Physical City Name is:" + profileInternationalAddress[3]);
		System.out.println("International Physical State Name is:" + profileInternationalAddress[4]);
		System.out.println("International Physical Zip Name is:" + profileInternationalAddress[5]);
		Serenity.setSessionVariable("intPhysicalCountry1").to(profileInternationalAddress[0]);
		String newIntCountry1 = Serenity.sessionVariableCalled("intPhysicalCountry1").toString();
		System.out.println("On Verify intPhysicalCountry1 is--->" + newIntCountry1 + "***");
		createNewProfilePage.selectProfilePhysicalCountryDropDown(newIntCountry1);
		System.out.println("Physical Country Name is: " + newIntCountry1); 
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntAddress1(){
		Serenity.setSessionVariable("intPhysicalAddress1").to(profileInternationalAddress[1]);
		String newIntAddress1 = Serenity.sessionVariableCalled("intPhysicalAddress1").toString();
		System.out.println("On Verify newInt intPhysicalAddress1 is--->" + newIntAddress1 + "***");
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(newIntAddress1);
		System.out.println("PhysicalAddress 1 is: " + newIntAddress1);
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntAddress2(){
		Serenity.setSessionVariable("intPhysicalAddress2").to(profileInternationalAddress[2]);
		String newIntAddress2 = Serenity.sessionVariableCalled("intPhysicalAddress2").toString();
		System.out.println("On Verify newInt intPhysicalAddress2 is--->" + newIntAddress2 + "***");
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(newIntAddress2);
		System.out.println("PhysicalAddress 2 is: " + newIntAddress2);
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntCity(){
		Serenity.setSessionVariable("intPhysicalCity1").to(profileInternationalAddress[3]);
		String newIntCity = Serenity.sessionVariableCalled("intPhysicalCity1").toString();
		System.out.println("On Verify intPhysicalCity1 is--->  " + newIntCity);
		createNewProfilePage.typeIntoCreateProfilePhysicalCity(newIntCity);
	}
	@Step
	public void selectProfilePhysicalIntStateDropList(){
		Serenity.setSessionVariable("intPhysicalState1").to(profileInternationalAddress[4]);
		String newIntState = Serenity.sessionVariableCalled("intPhysicalState1").toString();
		System.out.println("On Verify newInt intPhysicalState1 is--->" + newIntState  + "*****");
		System.out.println("New Country is--->" + profileInternationalAddress[0] + "*****");
		if (profileInternationalAddress[0].equals("United States")) {
		createNewProfilePage.selectFromPhysicalStateNameDropdownList(newIntState);   
		System.out.println("Physical Int State Selected from Drop Down List is: " + profileInternationalAddress[4]);
		} else {
			if (newIntState.equals(null)||newIntState.equals(""))
			{
				System.out.println("The New Int State value is NULL --->" + newIntState  + "*****So Do NOT Add a State Value for this address!*****");
				createNewProfilePage.typeIntoCreateProfilePhysicalStateNameField(" ");
			} else {
				createNewProfilePage.typeIntoCreateProfilePhysicalStateNameField(newIntState);
				System.out.println("Physical Country is not United States, so here is the Country TEXT value: " + profileInternationalAddress[0]);
			}
		}	
	}
//	@Step //Original
//	public void typeIntoCreateProfilePhysicalIntZipCode(){
//		Serenity.setSessionVariable("intPhysicalZip1").to(profileInternationalAddress[5]);
//		String newIntZip = Serenity.sessionVariableCalled("intPhysicalZip1").toString();
//		System.out.println("Physical intPhysicalZip1 Name from array is: " + profileInternationalAddress[5]);
//        System.out.println("New intZip1 is " + newIntZip);
//        createNewProfilePage.typeIntoCreateProfilePhysicalZip(newIntZip);
//	}
	@Step
	public void typeIntoCreateProfilePhysicalIntZipCode(){
		Serenity.setSessionVariable("intPhysicalZip1").to(profileInternationalAddress[5]);
		String newIntZip = Serenity.sessionVariableCalled("intPhysicalZip1").toString();
		System.out.println("Physical International Country is:-->" + profileInternationalAddress[0] + " Physical International Zip is:-->" + profileInternationalAddress[5]);
		if (!profileInternationalAddress[0].equals("United States")||!profileInternationalAddress[0].equals("Virgin Islands, U.S." ) || !profileInternationalAddress[0].equals("Guam") || 
				!profileInternationalAddress[0].equals("Puerto Rico") ||!profileInternationalAddress[0].equals("Northern Mariana Islands")||!profileInternationalAddress[0].equals("American Samoa")  ){
			createNewProfilePage.unCheckPhysicalZipPostalNotApplicableCheckbox();
			createNewProfilePage.typeIntoCreateProfilePhysicalZip(newIntZip); 
			System.out.println("Type into Zip Field-->" + newIntZip );
			} else {
		createNewProfilePage.typeIntoCreateProfilePhysicalZip(newIntZip); 
		System.out.println("Physical Zip is-->" + newIntZip);
		}
		if (profileInternationalAddress[5].equals("N/A")){
			createNewProfilePage.typeIntoCreateProfilePhysicalZip(newIntZip); 
			//createNewProfilePage.checkPhysicalZipPostalNotApplicableCheckbox();
			System.out.println("Physical Zip equals N/A");
		} 
	}
	
	
	@Step
	public void selectProfileMailingIntCountryDropDownList(){
		System.out.println("International Mailing Country Name is: " + mailingInternationalAddress[0]);
		System.out.println("International Mailing Address 1 Name is: " + mailingInternationalAddress[1]);
		System.out.println("International Mailing Address 2 Name is: " + mailingInternationalAddress[2]);
		System.out.println("International Mailing City Name is: " + mailingInternationalAddress[3]);
		System.out.println("International Mailing State Name is: " + mailingInternationalAddress[4]);
		System.out.println("International Mailing Zip Name is: " + mailingInternationalAddress[5]);
		Serenity.setSessionVariable("intMailingCountry1").to(mailingInternationalAddress[0]);
		String newIntMailingCountry1 = Serenity.sessionVariableCalled("intMailingCountry1").toString();
		System.out.println("On Verify Mailing newIntMailing intCountry1 is--->" + newIntMailingCountry1 + "***");
		createNewProfilePage.selectProfileMailingCountryDropDown(newIntMailingCountry1);
		System.out.println("International Mailing Country Name is: " + newIntMailingCountry1); 
		
	}
	@Step
	public void typeIntoCreateProfileMailingIntAddress1(){
		Serenity.setSessionVariable("intMailingAddress1").to(mailingInternationalAddress[1]);
		String newIntMailingAddress1 = Serenity.sessionVariableCalled("intMailingAddress1").toString();
		System.out.println("On Verify Mailing intMailingAddress1 is--->" + newIntMailingAddress1 + "***");
		createNewProfilePage.typeIntoCreateProfileMailingAddress1(newIntMailingAddress1);
		System.out.println("International Mailing Address 1 is: " + newIntMailingAddress1);
	}
	@Step
	public void typeIntoCreateProfileMailingIntAddress2(){
		Serenity.setSessionVariable("intMailingAddress2").to(mailingInternationalAddress[2]);
		String newIntMailingAddress2 = Serenity.sessionVariableCalled("intMailingAddress2").toString();
		System.out.println("On Verify Mailing intAddress2 is--->" + newIntMailingAddress2 + "***");
		createNewProfilePage.typeIntoCreateProfileMailingAddress2(newIntMailingAddress2);
		System.out.println("International Mailing Address 2 is: " + newIntMailingAddress2);
	}
	@Step
	public void typeIntoCreateProfileMailingIntCity(){
		Serenity.setSessionVariable("intMailingCity1").to(mailingInternationalAddress[3]);
		String newIntMailingCity = Serenity.sessionVariableCalled("intMailingCity1").toString();
		System.out.println("On Verify Mailing intCity1 is--->  " + newIntMailingCity);
		createNewProfilePage.typeIntoCreateProfileMailingCity(newIntMailingCity);
		System.out.println("International Mailing City is: " + newIntMailingCity);
		
	}
	@Step
	public void selectProfileMailingIntStateDropList(){
		Serenity.setSessionVariable("intMailingState1").to(mailingInternationalAddress[4]);
		String newIntMailingState = Serenity.sessionVariableCalled("intMailingState1").toString();
		System.out.println("On Verify Mailing intMailingState1 is--->" + newIntMailingState  + "*****");
		System.out.println("New Country is--->" + mailingInternationalAddress[0] + "*****");
		if (mailingInternationalAddress[0].equals("United States")) {
		createNewProfilePage.selectFromMailingStateNameDropdownList(newIntMailingState);  
		System.out.println("Mailing State Selected from Drop Down List is:" + mailingInternationalAddress[4]);
		} else {
			if (newIntMailingState.equals(null)||newIntMailingState.equals(""))
			{
				System.out.println("The New State value is NULL --->" + newIntMailingState  + "*****So Do NOT Add a State Value for this address!*****");
				createNewProfilePage.typeIntoMailingStateNameField(" ");
			} else {                 
				createNewProfilePage.typeIntoMailingStateNameField(newIntMailingState);
				System.out.println("Mailing Country is not United States, so here is the Country TEXT value: " + mailingInternationalAddress[0]);
			}
		}	
	}
	@Step
	public void typeIntoCreateProfileMailingIntZipCode(){
		Serenity.setSessionVariable("intMailingZip1").to(mailingInternationalAddress[5]);
		String newIntMailingZip = Serenity.sessionVariableCalled("intMailingZip1").toString();
		System.out.println("Mailing International Zip is-->" + newIntMailingZip  );
		System.out.println("Mailing International Country is:-->" + mailingInternationalAddress[0] + " Mailing International Zip is:-->" + mailingInternationalAddress[5]);
		if (!mailingInternationalAddress[0].equals("United States")||!mailingInternationalAddress[0].equals("Virgin Islands, U.S." ) || !mailingInternationalAddress[0].equals("Guam") ||
				!mailingInternationalAddress[0].equals("Puerto Rico")||!mailingInternationalAddress[0].equals("Northern Mariana Islands")||!mailingInternationalAddress[0].equals("American Samoa") ){
			createNewProfilePage.unCheckMailingZipPostalNotApplicableCheckbox();
			createNewProfilePage.typeIntoCreateProfileMailingZip(newIntMailingZip); 
			System.out.println("Country is International, Type into International Mailing Zip Field-->" + newIntMailingZip );
		} else {
			createNewProfilePage.typeIntoCreateProfileMailingZip(newIntMailingZip); 
			System.out.println("Country is US, Type into International Mailing Zip Field-->" + newIntMailingZip );
		}
	
		if (mailingInternationalAddress[5].equals("N/A")){
		createNewProfilePage.checkThatMailingZipPostalNotApplicableCheckboxIsChecked();
		System.out.println("Mailing International Zip is N/A and POSTAL CODE NOT APPLICABLE Checkbox is checked");
		} 
	}	
	

	
	
	///////////end of Inter address
	@Step
	public  void confirmSSPhysicalAddressRadioButton(){
		addressValidationPage.clickOnSmartyStreetPhysicalAddressRadioButton();
	}
	//Next button when editing profile
	@Step
	public void clickOnNextButton(){
		createNewProfilePage.clickOnNextButton();
	}
	@Step
	public void clickOnNextOrSaveButton(){
		createNewProfilePage.clickOnNextOrSaveButton();
	}
	
	@Step
	public void clickOnProceedToDashboardButton(){
		createNewProfilePage.clickOnProceedToDashboardButton();
	}
	@Step
	public void clickOnAcknowledgeSafetyGuidance(){
		createNewProfilePage.clickOnAcknowledgeSafetyGuidance();
	}
	
	@Step
	public void clickOnSaveProfileButton(){
		createNewProfilePage.clickOnSaveProfileButton();
	}
	
	@Step
	public void clickOnProceedToCheckoutButton(){
		createNewProfilePage.clickOnProceedToCheckoutButton();
	}
	
	
	@Step
	public void clickOnProceedToCheckoutOrSaveButton(){
		createNewProfilePage.clickOnProceedToCheckoutOrSaveButton();
		
	}
	

	//validatePhysicalAndMailingAddress
	@Step
	public void validatePhysicalAndMailingAddress(){
		//Serenity.takeScreenshot(); 
		addressValidationPage.validatePhysicalAndMailingAddress();
		//Serenity.takeScreenshot();
		System.out.println("End of Smarty Street Physical and Mailing Address validation Test!!");
	}

	
	@Step
	public void validatePhysicalAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validatePhysicalAddress();
		////Serenity.takeScreenshot(); 
		System.out.println("End of Smarty Street Physical Address validation Test!!");
	}
	
	@Step
	public void validateMailingAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validateMailingAddress();
		////Serenity.takeScreenshot(); 
		System.out.println("End of Smarty Street Mailing Address validation Test!!");
	}
	
//	@Step
//	public void cancelHobRegistration(){
//		createNewProfilePage.clickOnHobCancelRegistrationButton();
//		
//	}
	
	
	@Step
	public void completeHobbyistPaymentProcess() {
		//addNewUasPage.clickOnCheckOutButton();
		addNewUasPage.checkTheAcknowledgeBox();
		addNewUasPage.clickOnAcknowledgeNextButton();
		billingInformationPage.typeIntoCardNumber();
		billingInformationPage.typeCvcNumber();
		billingInformationPage.selectARandomExpirationMonth();
		billingInformationPage.selectARandomExpirationYear();
		billingInformationPage.clickOnBillingIsSameCheckbox();
		billingInformationPage.typeIntoBillingFirstName();
		billingInformationPage.typeIntoBillingLastName();
		billingInformationPage.selectARandomCountry(); //United States
		billingInformationPage.typeIntoBillingAddress1();
		billingInformationPage.typeIntoBillingAddress2();
		billingInformationPage.typeIntoBillingCity();
		billingInformationPage.selectBillingState();
		billingInformationPage.typeIntoBillingZip();
		//Serenity.takeScreenshot(); 
		billingInformationPage.clickOnBillingNextButton();
		billingInformationPage.clickOnReviewAcknowledgmentButton();
		billingInformationPage.clickOnReviewPayButton();
		//Serenity.takeScreenshot(); 
		//billingInformationPage.clickOnViewInventoryButton();
		////Serenity.takeScreenshot(); 
		System.out.println("Payment process has completed successfully!!");
		billingInformationPage.clickOnDoneButton();
	}
	
	
	@Step
	public void completeNonHobbyistPaymentProcess() {
//		addNewUasPage.clickOnCheckOutButton();
//		addNewUasPage.checkTheAcknowledgeBox();
//		addNewUasPage.clickOnAcknowledgeNextButton();
		billingInformationPage.typeIntoCardNumber();
		billingInformationPage.typeCvcNumber();
		billingInformationPage.selectARandomExpirationMonth();
		billingInformationPage.selectARandomExpirationYear();
		billingInformationPage.typeIntoBillingFirstName();
		billingInformationPage.typeIntoBillingLastName();
		billingInformationPage.selectARandomCountry(); //United States
		billingInformationPage.typeIntoBillingAddress1();
		billingInformationPage.typeIntoBillingAddress2();
		billingInformationPage.typeIntoBillingCity();
		billingInformationPage.selectBillingState();
		billingInformationPage.typeIntoBillingZip();
		//Serenity.takeScreenshot(); 
		billingInformationPage.clickOnBillingNextButton();
		billingInformationPage.clickOnReviewAcknowledgmentButton();
		billingInformationPage.clickOnReviewPayButton();
		////Serenity.takeScreenshot(); 
		//billingInformationPage.clickOnViewInventoryButton();
		////Serenity.takeScreenshot(); 
		System.out.println("Payment process has completed successfully!!");
		billingInformationPage.clickOnDoneButton();
		
	}
		
	@Step
	public void randomRoleType(){
		randomValuesPage.randomRoleTypes();
		randomValuesPage.randomRoleTypes3();
		randomValuesPage.randomTitle();
	}
	
	
	@Step
	public void selectInvitedUsersDropList(String invitedUser){
		System.out.println("Manage User page Filter by --->" + invitedUser  + "*****");
		faaHomePage.selectInvitedUsersDropList(invitedUser);  
		//Serenity.takeScreenshot(); 
	}
	
	
	
	
}