package faa.cucumber.stepLibraries;

import java.util.Properties;

import faa.cucumber.pages.AddNewUasPage;
import faa.cucumber.pages.AddressValidationPage;
import faa.cucumber.pages.BillingInformationPage;
//import faa.cucumber.pages.CreateNewProfilePage;
import faa.cucumber.pages.NewAccountPage;
import faa.cucumber.pages.UpdateStrikeProfilePage;
import faa.utils.DataGenerator;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import cucumber.api.java.Before;


public class UpdateStrikeProfileSteps {

	//NewAccountPage newAccountPage;
	//CreateNewProfilePage createNewProfilePage;
	UpdateStrikeProfilePage updateStrikeProfilePage;
	AddressValidationPage addressValidationPage;
	BillingInformationPage billingInformationPage;
	AddNewUasPage addNewUasPage;
	
	public static Properties serenityProperties;
	
//	String physicalCountry = "United States";
	String[] profileAddress  = DataGenerator.randomAddressStrike();
	String[] mailingAddress  = DataGenerator.randomAddressStrike();
	
	String[] profileInternationalAddress  = DataGenerator.randomAddressInternational();
	String[] mailingInternationalAddress  = DataGenerator.randomAddressInternational();
	
	@Step 
	public void clickOnNonModelAircraftButton(){
		updateStrikeProfilePage.clickOnNonModelAircraftButton();
	}

	@Step 
	public void clickOnModelAircraftTypeButton(){
		updateStrikeProfilePage.clickOnModelAircraftButton();
	}
	
	@Step
	public void typeIntoCreateProfileFirstName(){
		updateStrikeProfilePage.typeIntoCreateProfileFirstName();
		Serenity.setSessionVariable(null);
		System.out.println("Profile First Name is " + updateStrikeProfilePage.getTypeIntoCreateProfileFirstName());
		String newNonHobbyistFirstName = updateStrikeProfilePage.getTypeIntoCreateProfileFirstName();
		Serenity.setSessionVariable("newNonHobbyistFirstName").to(newNonHobbyistFirstName);
	}

	@Step
	public void typeIntoCreateProfileMiddleInitial(){
		updateStrikeProfilePage.typeIntoCreateProfileMiddleInitial();
		System.out.println("Profile Middle Intial is " + updateStrikeProfilePage.getTypeIntoCreateProfileMiddleInitial());
	}
	
	@Step
	public void typeIntoCreateProfileLastName(){
		updateStrikeProfilePage.typeIntoCreateProfileLastName();
		System.out.println("Profile Last Name is " + updateStrikeProfilePage.getTypeIntoCreateProfileLastName());
		String newNonHobbyistLastName = updateStrikeProfilePage.getTypeIntoCreateProfileLastName();
		Serenity.setSessionVariable("newNonHobbyistLastName").to(newNonHobbyistLastName);
		
	}
	
	@Step
	public void typeIntoCreateProfileNameSuffix(){
		updateStrikeProfilePage.typeIntoCreateProfileNameSuffix();
		System.out.println("Profile Suffix Name is " + updateStrikeProfilePage.getCreateProfileNameSuffix());

	}
	@Step
	public void typeIntoCreateProfileTitle(){
		updateStrikeProfilePage.typeIntoCreateProfileTitle();
		System.out.println("Profile Title is " + updateStrikeProfilePage.getCreateProfileNameTitle());
	}
	
	//Update an existing account
	@Step
	public void typeIntoCreateProfileAltEmail(){
		String varNewFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAcountEmail").toString();
		System.out.println("Type newFaaAcountEmail Into Alternate Email-->" + varNewFaaAcountEmail);
		updateStrikeProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAcountEmail);
	}

	
	
	
	
	
	
	
	
	
	//Creating a new account
	@Step
	public void typeIntoCreateNewProfileAltEmail(){
		//Retrieve new account
		String varNewFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
		System.out.println("Type New Email Address for newFaaAccount Into Alternate Email-->" + varNewFaaAcountEmail);
		updateStrikeProfilePage.typeIntoUpdateProfileAlternateEmail(varNewFaaAcountEmail);
	}
	
	
	
	
//	@Step
//	public void typeIntoCreateProfileAltEmail(){
//		updateStrikeProfilePage.typeIntoCreateProfileAlternateEmail();
//		System.out.println("Profile Alternate Email Address is: " + updateStrikeProfilePage.getCreateProfileAlternateEmail());
//	}
	@Step
	public void typeIntoCreateProfilePhone(){
		updateStrikeProfilePage.typeIntoCreateProfilePhone();
		System.out.println("Profile Phone Number is: " + updateStrikeProfilePage.getCreateProfilePhone());

	}
	@Step
	public void typeIntoCreateProfilePhoneExt(){
		updateStrikeProfilePage.typeIntoCreateProfilePhoneExt();
		System.out.println("Profile Phone Number Extension is: " + updateStrikeProfilePage.getCreateProfilePhoneExt());

		
	}
	@Step
	public void typeIntoCreateProfileOrganization(){
		updateStrikeProfilePage.typeIntoCreateProfileOrganizationName();
		System.out.println("Profile Organization Name is: " + updateStrikeProfilePage.getCreateProfileOrganizationName());

	}
	@Step
	public void typeIntoCreateProfileDba(){
		updateStrikeProfilePage.typeIntoCreateProfileDba();
		System.out.println("Profile DBA Name is: " + updateStrikeProfilePage.getCreateProfileDba());
	}

	@Step
	public void selectProfilePhysicalCountryDropDownList(){
		//String[] profileAddress  = DataGenerator.randomAddressStrike();
		Serenity.setSessionVariable("sessionPhysicalCountry").to(profileAddress[0]);
		String newPhysicalCountry = Serenity.sessionVariableCalled("sessionPhysicalCountry").toString();
		System.out.println("On Verify new newPhysicalCountry is--->" + newPhysicalCountry + "***");
		System.out.println("On Verify new sessionPhysicalCountry is--->" + profileAddress[0] + "***");
		
//		if (newCountry1.equals(null)){
//			newCountry1 = "United States";
//		}
		System.out.println("On Verify new Country1 is new updated to--->" + newPhysicalCountry + "***");
		updateStrikeProfilePage.selectProfilePhysicalCountryDropDown(newPhysicalCountry);
		System.out.println("Strike Physical Country Name is: " + newPhysicalCountry); 
		System.out.println("Strike Physical Country Name is: " + profileAddress[0]); 
		System.out.println("Strike Physical Address1 Name is: " + profileAddress[1]);
		System.out.println("Strike Physical Address2 Name is: " + profileAddress[2]); 
		System.out.println("Strike Physical City Name is: " + profileAddress[3]); 		
		System.out.println("Strike Physical State Name is: " + profileAddress[4]); 
		System.out.println("Strike Physical Zip Name is: " + profileAddress[5]); 
		
	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress1(){
		Serenity.setSessionVariable("address1").to(profileAddress[1]);
		String newAddress1 = Serenity.sessionVariableCalled("address1").toString();
		System.out.println("On Verify new Address1 is--->" + newAddress1 + "***");
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress1(newAddress1);
		System.out.println("Strike PhysicalAddress 1 is: " + newAddress1);
	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress2(){
		Serenity.setSessionVariable("address2").to(profileAddress[2]);
		String newAddress2 = Serenity.sessionVariableCalled("address2").toString();
		System.out.println("On Verify new Address2 is--->" + newAddress2 + "***");
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress2(newAddress2);
		System.out.println("Strike PhysicalAddress 2 is: " + newAddress2);
	}
	@Step
	public void typeIntoCreateProfileCity(){
		Serenity.setSessionVariable("city1").to(profileAddress[3]);
		String newCity = Serenity.sessionVariableCalled("city1").toString();
		System.out.println("On Verify new City is--->  " + newCity);
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalCity(newCity);
		System.out.println("Strike City 2 is: " + newCity);
		
	}
	@Step
	public void selectProfilePhysicalStateDropList(){
		Serenity.setSessionVariable("state1").to(profileAddress[4]);
		String newState = Serenity.sessionVariableCalled("state1").toString();
		System.out.println("On Verify new State is--->  " + newState  + "*****");
		System.out.println("New Strike Country is--->" + profileAddress[0] + "*****");
		if (profileAddress[0].equals("United States")) {
		updateStrikeProfilePage.selectFromPhysicalStateNameDropdownList(newState);  
		System.out.println("Physical State Selected from Drop Down List is: " + profileAddress[4]);
		} else {
			if (newState == null ||newState.equals(null)||newState.equals(""))		
			{
				System.out.println("The New State value is NULL ---> " + newState  + "*****So Do NOT Add a State Value for this address!*****");
			} else {
				updateStrikeProfilePage.typeIntoCreateProfilePhysicalStateNameField(newState.trim());
				System.out.println("Strike Physical Country is not United States, so here is the Country TEXT value: " + profileAddress[0]);
			}
		}	
	}
	@Step
	public void typeIntoCreateProfileZipCode(){
		Serenity.setSessionVariable("zip1").to(profileAddress[5]);
		String newZip = Serenity.sessionVariableCalled("zip1").toString();
		System.out.println("Strike Physical Zip Name from array is: " + profileAddress[5]);
        System.out.println("New Zip is " + newZip);
        updateStrikeProfilePage.typeIntoCreateProfilePhysicalZip(newZip);
        ////Serenity.takeScreenshot(); 
	}
	
	@Step
	public void clickOnAddressIsSameCheckbox(){
		updateStrikeProfilePage.clickProfileAddressIsSame();
	}
	
	@Step
	public void selectProfileMailingCountryFromDropList(){
		//String[] mailingAddress  = DataGenerator.randomAddressStrike();
		Serenity.setSessionVariable("sessionMailingCountry").to(mailingAddress[0]);
		String newMailingCountry = Serenity.sessionVariableCalled("sessionMailingCountry").toString();
		System.out.println("On Verify Array for new Mailing Country is--->  " + mailingAddress[0]);
//		System.out.println("On Verify Session Variable for new Mailing Country is--->  " + Serenity.setSessionVariable("mailingCountry"));
		System.out.println("On Verify new Mailing Country is--->  " + newMailingCountry);
//		if (newMailingCountry.equals(null)){
//			newMailingCountry = "United States";
//		}
		System.out.println("Strike Mailing Country Name is: " + mailingAddress[0]); 
		System.out.println("Strike Mailing Address1 Name is: " + mailingAddress[1]);
		System.out.println("Strike Mailing Address2 Name is: " + mailingAddress[2]); 
		System.out.println("Strike Mailing City Name is: " + mailingAddress[3]); 		
		System.out.println("Strike Mailing State Name is: " + mailingAddress[4]); 
		System.out.println("Strike Mailing Zip Name is: " + mailingAddress[5]); 

		updateStrikeProfilePage.selectProfileMailingCountryDropDown(newMailingCountry);
		System.out.println("New Strike Mailing Country Name is: " + newMailingCountry);

	}
	@Step
	public void typeIntoCreateProfileMailingAddress1(){
		Serenity.setSessionVariable("mailingAddress1").to(mailingAddress[1]);
		String newMailingAddress1 = Serenity.sessionVariableCalled("mailingAddress1").toString();
		System.out.println("On Verify new mailing Address1 is--->  " + newMailingAddress1);
		updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(newMailingAddress1);
		System.out.println("Strike Mailing Address 1 is: " + newMailingAddress1);
	}
	@Step
	public void typeIntoCreateProfileMailingAddress2(){
		Serenity.setSessionVariable("mailingAddress2").to(mailingAddress[2]);
		String newMailingAddress2 = Serenity.sessionVariableCalled("mailingAddress2").toString();
		System.out.println("On Verify new mailing Address2 is--->  " + newMailingAddress2);
		updateStrikeProfilePage.typeIntoCreateProfileMailingAddress2(newMailingAddress2);
		System.out.println("Strike Mailing Address 2 is: " + newMailingAddress2);
	}
	@Step
	public void typeIntoCreateProfileMailingCity(){
		Serenity.setSessionVariable("mailingCity1").to(mailingAddress[3]);
		String newMailingCity = Serenity.sessionVariableCalled("mailingCity1").toString();
		System.out.println("On Verify new mailing City is--->  " + newMailingCity);
		updateStrikeProfilePage.typeIntoCreateProfileMailingCity(newMailingCity);
		System.out.println("Strike Mailing City is: " + newMailingCity);
	}
	
	@Step
	public void selectProfileMailingStateDropList(){
		Serenity.setSessionVariable("mailingState1").to(mailingAddress[4]);
		String newMailingState = Serenity.sessionVariableCalled("mailingState1").toString();
		System.out.println("On Verify new mailing State is--->  " + newMailingState);
		if (mailingAddress[0].equals("United States")){
			updateStrikeProfilePage.selectFromMailingStateNameDropdownList(newMailingState);
			////Serenity.takeScreenshot(); 
			System.out.println("Strike Selected new mailing State is--->  " + newMailingState);
		} else {
				if (newMailingState == null ||newMailingState.equals(null)||newMailingState.equals(""))		
			{
				System.out.println("The New Mailing State value is NULL ---> " + newMailingState  + "*****So Do NOT Add a State Value for this address!*****");
			} else { 
				updateStrikeProfilePage.typeIntoMailingStateNameField(newMailingState);
				////Serenity.takeScreenshot(); 
				System.out.println("Strike Mailing Country is not United States, so here is the new State TEXT value:***" + mailingAddress[0] + "***");
				System.out.println("Strike Check to see what Mailing Country is TEXT value:***" + newMailingState + "***");
				}
			}
		}		
	@Step
	public void typeIntoCreateProfileMailingZipCode(){
		Serenity.setSessionVariable("mailingZip1").to(mailingAddress[5]);
		String newMailingZip = Serenity.sessionVariableCalled("mailingZip1").toString();
		updateStrikeProfilePage.typeIntoCreateProfileMailingZip(newMailingZip);
		////Serenity.takeScreenshot(); 
		System.out.println("Strike Mailing Zip***" + newMailingZip + "***");
	}
////////Begin of Int Address
	
	@Step
	public void selectProfilePhysicalIntCountryDropDownList(){
		Serenity.setSessionVariable("intCountry1").to(profileInternationalAddress[0]);
		String newIntCountry1 = Serenity.sessionVariableCalled("intCountry1").toString();
		System.out.println("On Verify newInt intCountry1 is--->" + newIntCountry1 + "***");
		updateStrikeProfilePage.selectProfilePhysicalIntCountryDropDown(newIntCountry1);
		System.out.println("Physical Country Name is: " + newIntCountry1); 
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntAddress1(){
		Serenity.setSessionVariable("intAddress1").to(profileInternationalAddress[1]);
		String newIntAddress1 = Serenity.sessionVariableCalled("intAddress1").toString();
		System.out.println("On Verify newInt intAddress1 is--->" + newIntAddress1 + "***");
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress1(newIntAddress1);
		System.out.println("PhysicalAddress 1 is: " + newIntAddress1);
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntAddress2(){
		Serenity.setSessionVariable("intAddress2").to(profileInternationalAddress[2]);
		String newIntAddress2 = Serenity.sessionVariableCalled("intAddress2").toString();
		System.out.println("On Verify newInt intAddress2 is--->" + newIntAddress2 + "***");
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress2(newIntAddress2);
		System.out.println("PhysicalAddress 2 is: " + newIntAddress2);
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntCity(){
		Serenity.setSessionVariable("intCity1").to(profileInternationalAddress[3]);
		String newIntCity = Serenity.sessionVariableCalled("intCity1").toString();
		System.out.println("On Verify newInt intCity1 is--->  " + newIntCity);
		updateStrikeProfilePage.typeIntoCreateProfilePhysicalCity(newIntCity);
	}
	@Step
	public void selectProfilePhysicalIntStateDropList(){
		Serenity.setSessionVariable("intState1").to(profileInternationalAddress[4]);
		String newIntState = Serenity.sessionVariableCalled("intState1").toString();
		System.out.println("On Verify newInt intState1 is--->  " + newIntState  + "*****");
		System.out.println("New Country is--->" + profileInternationalAddress[0] + "*****");
		if (profileInternationalAddress[0].equals("United States")) {
		updateStrikeProfilePage.selectFromPhysicalStateNameDropdownList(newIntState);  
		System.out.println("Physical Int State Selected from Drop Down List is: " + profileInternationalAddress[4]);
		} else {
			if (newIntState == null ||newIntState.equals(null)||newIntState.equals(""))		
			{
				System.out.println("The New Int State value is NULL ---> " + newIntState  + "*****So Do NOT Add a State Value for this address!*****");
			} else {
				updateStrikeProfilePage.typeIntoCreateProfilePhysicalStateNameField(newIntState);
				System.out.println("Physical Country is not United States, so here is the Country TEXT value: " + profileInternationalAddress[0]);
			}
		}	
	}
	@Step
	public void typeIntoCreateProfilePhysicalIntZipCode(){
		Serenity.setSessionVariable("intZip1").to(profileInternationalAddress[5]);
		String newIntZip = Serenity.sessionVariableCalled("intZip1").toString();
		System.out.println("Physical intZip1 Name from array is: " + profileInternationalAddress[5]);
        System.out.println("New intZip1 is " + newIntZip);
        updateStrikeProfilePage.typeIntoCreateProfilePhysicalZip(newIntZip);
	}
	
	@Step
	public void selectProfileMailingIntCountryDropDownList(){
		Serenity.setSessionVariable("intCountry1").to(mailingInternationalAddress[0]);
		String newIntMailingCountry1 = Serenity.sessionVariableCalled("intCountry1").toString();
		System.out.println("On Verify newIntMailing intCountry1 is--->" + newIntMailingCountry1 + "***");
		updateStrikeProfilePage.selectProfileMailingCountryDropDown(newIntMailingCountry1);
		System.out.println("Physical Country Name is: " + newIntMailingCountry1); 
	}
	@Step
	public void typeIntoCreateProfileMailingIntAddress1(){
		Serenity.setSessionVariable("intAddress1").to(mailingInternationalAddress[1]);
		String newIntMailingAddress1 = Serenity.sessionVariableCalled("intAddress1").toString();
		System.out.println("On Verify newIntMailing intAddress1 is--->" + newIntMailingAddress1 + "***");
		updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(newIntMailingAddress1);
		System.out.println("PhysicalAddress 1 is: " + newIntMailingAddress1);
	}
	@Step
	public void typeIntoCreateProfileMailingIntAddress2(){
		Serenity.setSessionVariable("intAddress2").to(mailingInternationalAddress[2]);
		String newIntMailingAddress2 = Serenity.sessionVariableCalled("intAddress2").toString();
		System.out.println("On Verify newIntMailing intAddress2 is--->" + newIntMailingAddress2 + "***");
		updateStrikeProfilePage.typeIntoCreateProfileMailingAddress2(newIntMailingAddress2);
		System.out.println("PhysicalAddress 2 is: " + newIntMailingAddress2);
	}
	@Step
	public void typeIntoCreateProfileMailingIntCity(){
		Serenity.setSessionVariable("intCity1").to(mailingInternationalAddress[3]);
		String newIntMailingCity = Serenity.sessionVariableCalled("intCity1").toString();
		System.out.println("On Verify newIntMailing intCity1 is--->  " + newIntMailingCity);
		updateStrikeProfilePage.typeIntoCreateProfileMailingCity(newIntMailingCity);
	}
	@Step
	public void selectProfileMailingIntStateDropList(){
		Serenity.setSessionVariable("intState1").to(mailingInternationalAddress[4]);
		String newIntMailingState = Serenity.sessionVariableCalled("intState1").toString();
		System.out.println("On Verify newIntMailing intState1 is--->  " + newIntMailingState  + "*****");
		System.out.println("New Country is--->" + mailingInternationalAddress[0] + "*****");
		if (mailingInternationalAddress[0].equals("United States")) {
		updateStrikeProfilePage.selectFromPhysicalStateNameDropdownList(newIntMailingState.trim());  
		System.out.println("Physical State Selected from Drop Down List is: " + mailingInternationalAddress[4]);
		} else {
			if (newIntMailingState == null ||newIntMailingState.equals(null)||newIntMailingState.equals(""))		
			{
				System.out.println("The New State value is NULL ---> " + newIntMailingState  + "*****So Do NOT Add a State Value for this address!*****");
			} else {                 
				updateStrikeProfilePage.typeIntoCreateProfilePhysicalStateNameField(newIntMailingState.trim());
				System.out.println("Physical Country is not United States, so here is the Country TEXT value: " + mailingInternationalAddress[0]);
			}
		}	
	}
	@Step
	public void typeIntoCreateProfileMailingIntZipCode(){
		Serenity.setSessionVariable("intZip1").to(mailingInternationalAddress[5]);
		String newIntMailingZip = Serenity.sessionVariableCalled("intZip1").toString();
		System.out.println("Physical intZip1 Name from array is: " + mailingInternationalAddress[5]);
        System.out.println("New intZip1 is " + newIntMailingZip);
        updateStrikeProfilePage.typeIntoCreateProfileMailingZip(newIntMailingZip);
	}
	///////////end of Inter address
	@Step
	public  void confirmSSPhysicalAddressRadioButton(){
		addressValidationPage.clickOnSmartyStreetPhysicalAddressRadioButton();
	}
	
	
	
	//Next button when editing profile
	@Step
	public void clickOnNextButton(){
		updateStrikeProfilePage.clickOnNextButton();
	}
		
//	@Step
//	public void clickOnSaveButtonCssSelectorButton(){
//		updateStrikeProfilePage.clickOnSaveButtonCssSelectorButton();
//	}
	@Step
	public void clickOnNextOrSaveButton(){
		updateStrikeProfilePage.clickOnNextOrSaveButton();
	}
	
	@Step
	public void clickOnSaveProfileButton(){
		updateStrikeProfilePage.clickOnSaveButton();
	}
	
	@Step
	public void clickOnProceedToCheckoutButton(){
		updateStrikeProfilePage.clickOnProceedToCheckoutButton();
	}
	

	//validatePhysicalAndMailingAddress
	@Step
	public void validatePhysicalAndMailingAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validatePhysicalAndMailingAddress();
		////Serenity.takeScreenshot();
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
	//////////
	@Step
	public void validateStrikePhysicalAndMailingAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validateAllStrikeAddreses();
		////Serenity.takeScreenshot();
		System.out.println("End of Smarty Street Strike Physical and Mailing Address validation Test!!");
	}

	
	@Step
	public void validateStrikePhysicalAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validateAllStrikeAddreses();
		////Serenity.takeScreenshot(); 
		System.out.println("End of Smarty Street Physical Address validation Test!!");
	}
	
	@Step
	public void validateStrikeMailingAddress(){
		////Serenity.takeScreenshot(); 
		addressValidationPage.validateAllStrikeAddreses();
		////Serenity.takeScreenshot(); 
		System.out.println("End of Smarty Street Mailing Address validation Test!!");
	}
	
	//////////
	
	
	@Step
	public void completeHobbyistPaymentProcess() {
		//addNewUasPage.clickOnCheckOutButton();
		addNewUasPage.checkTheAcknowledgeBox();
		addNewUasPage.clickOnAcknowledgeNextButton();
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
	public void completeNonHobbyistPaymentProcess() {
		//addNewUasPage.clickOnCheckOutButton();
		addNewUasPage.checkTheAcknowledgeBox();
		addNewUasPage.clickOnAcknowledgeNextButton();
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
		billingInformationPage.clickOnBillingNextButton();
		billingInformationPage.clickOnReviewAcknowledgmentButton();
		billingInformationPage.clickOnReviewPayButton();
		////Serenity.takeScreenshot(); 
		//billingInformationPage.clickOnViewInventoryButton();
		////Serenity.takeScreenshot(); 
		System.out.println("Payment process has completed successfully!!");
		billingInformationPage.clickOnDoneButton();
	}
	
}