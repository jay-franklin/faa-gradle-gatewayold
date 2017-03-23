
package faa.cucumber.pages;

import org.openqa.selenium.support.FindBy;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;
import faa.utils.WriteOpenCSV2;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddressValidationPage extends BasePageObject  {

	CreateNewProfilePage createNewProfilePage;
	UpdateStrikeProfilePage updateStrikeProfilePage;
	FaaHomePage faaHomePage;
	
	String[] newPhysicalAddress  = DataGenerator.randomAddress();
	String[] newMailingAddress  = DataGenerator.randomAddress();
	
	String[] newProfilePhysicalAddress  = DataGenerator.randomAddress();
	String[] newProfileMailingAddress  = DataGenerator.randomAddress();

	String[] newStrikeProfilePhysicalAddress  = DataGenerator.randomAddressStrike();
	String[] newStrikeProfileMailingAddress  = DataGenerator.randomAddressStrike();
	
//	physical-suggestedAddress1
//	physical-suggestedAddress2

	
	
//	/** originalPhysicalAddress Original**/
//	@FindBy(xpath="//input[@id='selectedPhysicalAddrEntered']") private WebElementFacade originalPhysicalAddress;
	/** originalPhysicalAddress New Gateway**/
	@FindBy(xpath="//input[@id='physical-enteredAddress']") private WebElementFacade originalPhysicalAddress;
	
//	/** smartyStreetPhysicalAddress selectedPhysicalAddr0 **/
//	@FindBy(xpath="//input[@id='selectedPhysicalAddr0']") private WebElementFacade smartyStreetPhysicalAddress;
	/** smartyStreetPhysicalAddress selectedPhysicalAddr0 **/
	@FindBy(xpath="//input[@id='physical-suggestedAddress1']") private WebElementFacade smartyStreetPhysicalAddress;

	
//	/** selectedMailingAddrEntered Original **/
//	@FindBy(xpath="//input[@id='selectedMailingAddrEntered']") private WebElementFacade originalMailingAddress;
	/** selectedMailingAddrEntered New Gateway**/
	@FindBy(xpath="//input[@id='mailing-enteredAddress']") private WebElementFacade originalMailingAddress;

	
	//	/** smartyStreetMailingAddress **/ Original 
//	@FindBy(xpath="//input[@id='selectedMailingAddr0']") private WebElementFacade smartyStreetMailingAddress;
	/** smartyStreetMailingAddress  New Gateway **/
	@FindBy(xpath="//input[@id='mailing-suggestedAddress1']") private WebElementFacade smartyStreetMailingAddress;
	
	
	/** Checkbox to confirm selected physical address is valid...confirmPhysicalAddress  **/
	@FindBy(xpath="//input[@id='physical-confirmAddress']") private WebElementFacade confirmPhysicalAddressCheckbox;

	/** Checkbox to confirm selected mailing address is valid...confirmMailingAddress **/
	@FindBy(xpath="//input[@id='mailing-confirmAddress']") private WebElementFacade confirmMailingAddressCheckbox;
		
//	/** Cancel Button on Address Validation Screen  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] Original **/
//	@FindBy(xpath="//button[@class='btn btn-primary' and contains(text(), 'Cancel')]") private WebElementFacade cancelButton;
	/** Cancel Button on Address Validation Screen  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] New Gateway **/
	@FindBy(xpath="//button[@id='cancelValidation' and contains(text(), 'Cancel')]") private WebElementFacade cancelButton;
	
	/** Cancel Button on Confirm Your Address Screen  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] **/
	@FindBy(xpath="//button[@class='btn' and contains(text(), 'Cancel')]") private WebElementFacade cancelConfirmAddressButton;

	
	/** Save Button on Address Validation Screen  //button[@id='saveEditButton' and contains(text(), 'Save')]] **/
	@FindBy(xpath="//button[@id='saveEditButton' and contains(text(), 'Save')]") private WebElementFacade saveButton;
	
	
	/** Your profile has been successfully updated.  Confirm Your Profile Updated Successfully  //p[contains(text(), 'Your profile has been successfully updated.')] **/
	@FindBy(xpath="//p[contains(text(), 'Your profile has been successfully updated.')]") private WebElementFacade confirmProfileSuccessfullyUpdated;
	
	
//	/** Submit Selection Button on Address Validation Screen  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] **/ Original
//	@FindBy(xpath="//button[@class='btn btn-primary' and contains(text(), 'Submit Selection')]") private WebElementFacade submitSelectionButton;
	/** Submit Selection Button on Address Validation Screen  //button[@class='btn btn-primary' and contains(text(), 'Cancel')]  Gateway **/
	@FindBy(xpath="//button[@id='submitValidation' and contains(text(), 'Submit Selection')]") private WebElementFacade submitSelectionButton;
	
	//Next Button on Complete Your Profile page
	@FindBy(xpath = "//button[@id='next' and contains(text(), 'Next')]") private WebElementFacade nextButton;
	
	//Next Button on Complete Your Hobbyist Profile page
	@FindBy(xpath = "//input[@class='btn btn-primary' and @title='Next']") private WebElementFacade hobbyistNextButton;

	//Hobbyist Proceed to Checkout Button
	@FindBy(xpath = "//button[@id='proceedToCheckout' and contains(text(), 'Proceed to Checkout')]") private WebElementFacade proceedToCheckoutButton;

	//Non-Model [Non Hobbyist] Proceed to Dashboard Button
	@FindBy(xpath = "//button[@id='proceedToDashboard' and contains(text(), 'Proceed to Dashboard')]") private WebElementFacade proceedToDashboardButton;

	
	//If either of these elements are visible, click the 'Cancel' button to start over with editing the address.
	/** Unable to Confirm Your Physical Address  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your physical address. Please select Cancel and update your physical address')]") private WebElementFacade unableToConfirmPhysicalAddress;
	/** Unable to Confirm Your Mailing Address  //button[@class='btn btn-primary' and contains(text(), 'Cancel')] **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your mailing address. Please select Cancel and update your mailing address')]") private WebElementFacade unableToConfirmMailingAddress;

	/** Our system was unable to validate your physical address. PO Boxes are not allowed.**/
	@FindBy(xpath="//p[@class='ng-binding' and contains(text(), 'Our system was unable to validate your physical address. PO Boxes are not allowed.')]") private WebElementFacade unableToValidatePhysicalAddressNoPo;

	/** Our system was unable to validate your physical address. You may continue with entered physical address, or click Cancel and update your physical address. **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your physical address. You may continue with the entered physical address, or click Cancel and update your physical address.')]") private WebElementFacade keepEnteredPhysicalAddress;
	
	/** Our system was unable to validate your mailing address. You may continue with entered mailing address, or click Cancel and update your mailing address **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your mailing address. You may continue with the entered mailing address, or click Cancel and update your mailing address')]") private WebElementFacade keepEnteredMailingAddress;
	
	
	//Strike 2 Primary Address
	/** Our system was unable to validate your physical address. You may continue with entered physical address, or click Cancel and update your physical address. **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your physical address. You may continue with a previously attempted physical address by making a selection and checking the box below.')]") private WebElementFacade strikePhysicalAddress;
	//Strike 2 Mailing Address
	/** Our system was unable to validate your mailing address. You may continue with entered mailing address, or click Cancel and update your mailing address **/
	@FindBy(xpath="//p[contains(text(), 'Our system was unable to validate your mailing address. You may continue with a previously attempted mailing address by making a selection and checking the box below.')]") private WebElementFacade strikeMailingAddress;


	//p[contains(text(), 'Based on your input, 1 other potential physical address was located in our system. Please choose the correct address or select Cancel and update your address.')]
	/** Physical address was located in our system. Please choose the correct physical address or select Cancel and update your address. **/
	@FindBy(xpath="//p[contains(text(), 'other potential physical address was located in our system. Please choose the correct physical address or select Cancel and update your physical address.')]") private WebElementFacade unableToConfirmCloseMatchTo1PhysicalAddress;

	/** Mailing address was located in our system. Please choose the correct mailing address or select Cancel and update your address.**/
	@FindBy(xpath="//p[contains(text(), 'other potential mailing address was located in our system. Please choose the correct mailing address or select Cancel and update your mailing address')]") private WebElementFacade unableToConfirmCloseMatchTo1MailingAddress;

	
	//2 or More Physical Addresses found ****//
	//p[contains(text(), 'Based on your input, 1 other potential physical address was located in our system. Please choose the correct address or select Cancel and update your address.')]
	/** Physical address was located in our system. Please choose the correct physical address or select Cancel and update your address. **/
	@FindBy(xpath="//p[contains(text(), 'other potential physical addresses were located in our system. Please choose the correct physical address or select Cancel and update your physical address.')]") private WebElementFacade unableToConfirmCloseMatchTo2PhysicalAddress;
	//2 or More Mailing Addresses found ****//
	/** Mailing address was located in our system. Please choose the correct mailing address or select Cancel and update your address.**/
	@FindBy(xpath="//p[contains(text(), 'other potential mailing addresses were located in our system. Please choose the correct mailing address or select Cancel and update your mailing address')]") private WebElementFacade unableToConfirmCloseMatchTo2MailingAddress;

	
	
	/** Mailing address must be updated.**/
	@FindBy(xpath="//input[@id='selectedMailingAddr' and contains(text(), 'I will edit my mailing address on my own.')]") private WebElementFacade editMyMailingAddress;

	//Edit Profile Button
	@FindBy(xpath = "//button[@id='edit' and contains(text(), 'Edit')]") private WebElementFacade editProfileButton;

	//Add UAS Button
	@FindBy(xpath = "//button[@id='addUas' and contains(text(), 'Add UAS')]") private WebElementFacade addUasButton;
	
	
	//Profile Tab
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), 'Profile')]") private WebElementFacade profileTab;

	//ConfirmYourAddress popup window 
	@FindBy(xpath = "//h1[@class='ng-scope' and contains(text(), 'Confirm Your Addresses')]") private WebElementFacade confirmYourAddress;

	//ConfirmYourPhysicalAddress popup window 
	@FindBy(xpath = "//h1[@class='ng-scope' and contains(text(), 'Confirm Your Physical Address')]") private WebElementFacade confirmYourPhysicalAddress;
	//ConfirmYourMailingAddress popup window 
	@FindBy(xpath = "//h1[@class='ng-scope' and contains(text(), 'Confirm Your Mailing Address')]") private WebElementFacade confirmYourMailingAddress;


	public void clickOnProfileTab(){
		System.out.println("Profile Tab is Visible, so it will be clicked");
		profileTab.click();
		System.out.println("Profile Tab has been clicked");
	}
	
	
	//originalPhysicalAddress
	public void clickOnOriginalPhysicalAddressRadioButton() {
		System.out.println("Click the originalPhysicalAddress Radio Button");
		originalPhysicalAddress.click();
	}
	//smartyStreetPhysicalAddress
	public void clickOnSmartyStreetPhysicalAddressRadioButton() {
		System.out.println("id selectedPhysicalAddr0 Click the smartyStreetPhysicalAddress Radio Button");
		waitABit(1000);
		smartyStreetPhysicalAddress.click();
		
	}
	//originalMailingAddress
	public void clickOnOriginalMailingAddressRadioButton() {
		System.out.println("Click the originalMailingAddress Radio Button");
		waitABit(1000);
		originalMailingAddress.click();
	}
	//smartyStreetMailingAddress
	public void clickOnSmartyStreetMailingAddressRadioButton() {
		System.out.println("Click the smartyStreetMailingAddress Radio Button");
		waitABit(1000);
		smartyStreetMailingAddress.click();
	}
	
	
	
	public void clickOnConfirmPhysicalAddressCheckbox() {
		System.out.println("Click the confirmPhysicalAddressCheckbox");
		waitABit(1000);
		confirmPhysicalAddressCheckbox.click();
	}
	
	
	public void clickOnConfirmMailingAddressCheckbox() {
		System.out.println("Click the ConfirmMailingAddressCheckbox");
		waitABit(1000);
		confirmMailingAddressCheckbox.click();
	}
	

	//editMyMailingAddress
	public void clickOneEditMyMailingAddressRadioButton() {
		System.out.println("Click the editMyMailingAddress Button");
		editMyMailingAddress.click();
	}
	
	
	//submitSelectionButton
	public void clickOnSubmitSelectionButton() {
		System.out.println("Click the submitSelectionButton Button");
		submitSelectionButton.click();
	}
	//unableToConfirmPhysicalAddress
	public void clickOnUnableToConfirmPhysicalAddressButton() {
		System.out.println("Click the unableToConfirmPhysicalAddress Button");
		unableToConfirmPhysicalAddress.click();
	}
	public String getUnableToConfirmPhysicalAddress() {
		return unableToConfirmPhysicalAddress.getAttribute("value");
	}

	public String getUnableToConfirmMailingAddress() {
		return unableToConfirmMailingAddress.getAttribute("value");
	}
	
	public void clickOnCancelButton() {
		System.out.println("Click the Confirm Mailing Address Cancel 'btn btn-primary' Button");
		cancelButton.click();
	}
	
	public void clickOnCancelConfirmAddressButton() {
		System.out.println("Click the Cancel Confirm Address 'btn' Button");
		cancelConfirmAddressButton.click();
	}
	public void clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton() {
		if (proceedToDashboardButton.isCurrentlyVisible()){
		System.out.println("Click the Proceed to Dashboard Button");
		createNewProfilePage.clickOnProceedToDashboardButton();
		Serenity.takeScreenshot(); 
		} else if (saveButton.isCurrentlyVisible()){
			System.out.println("Click the Save Button");
			saveButton.click();
			Serenity.takeScreenshot(); 
		} else if (proceedToCheckoutButton.isCurrentlyVisible()){
			System.out.println("Click the Proceed to Checkout Button");
			createNewProfilePage.clickOnProceedToCheckoutButton();
			Serenity.takeScreenshot(); 
		} else if(nextButton.isCurrentlyVisible()) {
			System.out.println("Click the Next Button");
			createNewProfilePage.clickOnNextButton();
			Serenity.takeScreenshot(); 
		} else if(editProfileButton.isCurrentlyVisible()) {
			System.out.println("Addresses have been saved.  Test is complete.");
			//createNewProfilePage.clickOnEditProfileButton();
			Serenity.takeScreenshot(); 
		}
	}
	
	
	public void clickOnNextOrSaveButton() {
		if (saveButton.isCurrentlyVisible()){
			System.out.println("Click the Save Button");
			saveButton.click();
			Serenity.takeScreenshot(); 
		} else if (nextButton.isCurrentlyVisible()){
			System.out.println("Click the Next Button");
			nextButton.click();
			Serenity.takeScreenshot(); 
		}
	}
	
	public void validateAllAddreses(){
		System.out.println("Validate All Physical and Mailing Address Next Steps");
		waitABit(3000);
//		if(profileTab.isCurrentlyVisible()) {
//			System.out.println("Profile Tab must be clicked to update the address.");
//			Serenity.takeScreenshot(); 
//			profileTab.click();
//		}		
//		if (confirmYourAddress.isCurrentlyVisible() | confirmYourPhysicalAddress.isCurrentlyVisible() | confirmYourMailingAddress.isCurrentlyVisible()){
		//if (editProfileButton.isCurrentlyVisible() | addUasButton.isCurrentlyVisible()){
		if(hobbyistNextButton.isCurrentlyVisible() | editProfileButton.isCurrentlyVisible()| addUasButton.isCurrentlyVisible()) {
			System.out.println("Addresses have been saved.  No additional Validation is required. Test is complete.");
			Serenity.takeScreenshot(); 
		} else { 
		if (unableToConfirmCloseMatchTo1PhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()){
			System.out.println("1 XXXXXXXXXunableToConfirmCloseMatchToPhysicalAddressXXXXXXXXXX");
			System.out.println("...UI Scenario 1 Physical Address and Mailing Address...");
			System.out.println("...UI Scenario 4 Physical Address and Mailing Address...");
			System.out.println("Smarty Street clicks the Physical Addresses Radio Button for 1 potential Physical Address");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			System.out.println("Smarty Street clicks the Mailing Addresses Radio Button for 1 potential Mailing Address");
			System.out.println("***If Number 1***");
			clickOnSmartyStreetMailingAddressRadioButton();
			waitABit(1000);
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			System.out.println("***If Number 1 Complete***");
			Serenity.takeScreenshot(); 
			waitABit(3000);
		} 
		if (unableToConfirmCloseMatchTo2PhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()){
			System.out.println("1 XXXXXXXXXunableToConfirmCloseMatchToPhysicalAddressXXXXXXXXXX");
			System.out.println("...UI Scenario 1 Physical Address and Mailing Address...");
			System.out.println("...UI Scenario 4 Physical Address and Mailing Address...");
			System.out.println("Smarty Street clicks the Physical Addresses Radio Button for 2 potential Physical Address");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			System.out.println("Smarty Street clicks the Mailing Addresses Radio Button for 1 potential Mailing Address");
			System.out.println("***If Number 2***");
			clickOnSmartyStreetMailingAddressRadioButton();
			waitABit(1000);
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			System.out.println("***If Number 2 Complete***");
			Serenity.takeScreenshot(); 
			waitABit(3000);
		} else if ( unableToConfirmCloseMatchTo1PhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible()){
			System.out.println("***If Number 3 ***");
			System.out.println("1 Potential Physical Address and 2 or more potentail mailing addresses have been found");
			System.out.println("2 The Mailing Address was found. Click Submit Button to Accept the Mailing Address");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			System.out.println("***If Number 3 Complete***");
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			if(editProfileButton.isCurrentlyVisible()) {
				System.out.println("Addresses have been saved.  Test is complete.");
				Serenity.takeScreenshot(); 
			}
		}	else if (unableToConfirmCloseMatchTo2PhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible()){
				System.out.println("2 or more XXXXXXXXXunableToConfirmCloseMatchToPhysicalAddressXXXXXXXXXX");
				System.out.println("...UI Scenario 1 Physical Address and Mailing Address...");
				System.out.println("...UI Scenario 4 Physical Address and Mailing Address...");
				System.out.println("Smarty Street clicks the Physical Addresses Radio Button for 2 or more potential Physical Addresses");
				clickOnSmartyStreetPhysicalAddressRadioButton();
				System.out.println("Smarty Street clicks the Mailing Addresses Radio Button for 2 or more potential Mailing Addresses");
				System.out.println("***If Number 4***");
				clickOnSmartyStreetMailingAddressRadioButton();
				waitABit(1000);
				Serenity.takeScreenshot(); 
				clickOnSubmitSelectionButton();
				System.out.println("***If Number 4 Complete***");
				Serenity.takeScreenshot(); 
				waitABit(3000);
		} else if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
			Serenity.takeScreenshot(); 
			System.out.println("...UI Scenario 2 Physical Address and Mailing Address..");
			System.out.println("***If Number 5***");
			waitABit(2000);
			clickOnCancelButton();
			//clickOnProfileTab();
			System.out.println("***If Number 5 Complete now must update Physical and Mailing Address***");
			updatePhysicalAndMailingAddress();	
			Serenity.takeScreenshot(); 			

		} else if (unableToConfirmCloseMatchTo1PhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 4 Physical Address and Mailing Address..");
			System.out.println("***If Number 6***");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			System.out.println("***If Number 6 Complete now update the Mailing Address***");
			waitABit(3000);
			System.out.println("Accept the SS Physical Address and Update the Mailing Address");
			updateMailingAddress();
		} 
		//////////////new 1
		else if (unableToConfirmCloseMatchTo1PhysicalAddress.isCurrentlyVisible() & keepEnteredMailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 4 Physical Address and UI Scenario 5 Mailing Address..");
			System.out.println("***If Number 7***");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnOriginalMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			waitABit(3000);
			System.out.println("Accept the SS Physical Address and Save the Entered Mailing Address.  No additional address updates needed");
			//updateMailingAddress();
		}	
		else if (unableToConfirmCloseMatchTo2PhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
			System.out.println("2...UI Scenario 4 Physical Address and Mailing Address..");
			System.out.println("***If Number 8***");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			waitABit(3000);
			System.out.println("2 Accept the SS Physical Address and Update the Mailing Address");
			updateMailingAddress();
		} 
		//////////////new 1
		else if (unableToConfirmCloseMatchTo2PhysicalAddress.isCurrentlyVisible() & keepEnteredMailingAddress.isCurrentlyVisible()){
			System.out.println("2...UI Scenario 4 Physical Address and UI Scenario 5 Mailing Address..");
			System.out.println("***If Number 9***");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			waitABit(3000);
			System.out.println("2 Accept the SS Physical Address and Save the Entered Mailing Address.  No additional address updates needed");
			//updateMailingAddress();
		}	else if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 2 Physical Address and UI Scenario 1 and 4 for Mailing Address..");
			System.out.println("***If Number 10***");
			clickOnSmartyStreetMailingAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("Update the Physical Address and Accept the SS Mailing Address");
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			updatePhysicalAddress();
		}	else if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 3 Physical Address NO PO Boxes and UI Scenario 1 and 4 for Mailing Address...");
			System.out.println("***If Number 11***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("The Mailing Address was found. Click Submit Button to Accept the Mailing Address and to Update the Physical Address");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			updatePhysicalAddress();
		} 	else if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible()){
			System.out.println("2...UI Scenario 2 Physical Address and UI Scenario 1 and 4 for Mailing Address..");
			System.out.println("***If Number 12***");
			clickOnSmartyStreetMailingAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("Update the Physical Address and Accept the SS Mailing Address");
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			updatePhysicalAddress();
		}	else if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible()){
			System.out.println("2...UI Scenario 3 Physical Address NO PO Boxes and UI Scenario 1 and 4 for Mailing Address...");
			System.out.println("***If Number 13***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("The Mailing Address was found. Click Submit Button to Accept the Mailing Address and to Update the Physical Address");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			updatePhysicalAddress();
		} 			
		//Strike 3 Primary and Mailing Address
		else if (strikePhysicalAddress.isCurrentlyVisible() & strikeMailingAddress.isCurrentlyVisible()){
			System.out.println("***Strike Test Primary and Mailing Address***");
			System.out.println("***If Number 14***");
			System.out.println("Physical and Mailing address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnConfirmPhysicalAddressCheckbox();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Strike Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 	else if (strikePhysicalAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 6 Physical Address Only..Strike Test");
			System.out.println("***If Number 15***");
			System.out.println("Physical Address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnConfirmPhysicalAddressCheckbox();
//			clickOnSmartyStreetMailingAddressRadioButton();
//			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 	else if (strikeMailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 6 Mailing Address Only..Strike Test");
			System.out.println("***If Number 16***");
			System.out.println("Mailing Address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update mailing address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 
		//Physical Address -- PO Box Not Allowed
		//Mailing Address  -- Not Found
		else if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 3 Physical Address No PO Boxes and UI Scenario 2 for Mailing Address");
			System.out.println("***If Number 17***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("The Mailing Address also was NOT found. Click the Cancel Button to Update the Physical Address and Mailing Address");
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Confirmation Button is clicked");
			} 
			if (cancelButton.isCurrentlyVisible()){
				clickOnCancelButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Button is clicked");
			}
			Serenity.takeScreenshot(); 
			updatePhysicalAndMailingAddress();
		} 
		//Physical Address -- 1 Match Found
		else if (unableToConfirmCloseMatchTo1PhysicalAddress.isCurrentlyVisible() & smartyStreetPhysicalAddress.isCurrentlyVisible()) {
			System.out.println("***If Number 18***");
			System.out.println("XXXXXXXXXunableToConfirmCloseMatchToPhysicalAddressXXXXXXXXXX");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			waitABit(1000);
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			System.out.println("Smarty Street clicks the Physical Addresses Radio Button");
		} 
// If Number 34 instead of this one.
//		//Physical Address -- 1 Match Found  //unableToConfirmCloseMatchTo2PhysicalAddress
//		else if (unableToConfirmCloseMatchTo2PhysicalAddress.isCurrentlyVisible() & smartyStreetPhysicalAddress.isCurrentlyVisible()) {
//			System.out.println("***If Number 17***");
//			System.out.println("XXXXXXXXXunableToConfirmCloseMatchTo2PhysicalAddressXXXXXXXXXX");
//			clickOnSmartyStreetPhysicalAddressRadioButton();
//			waitABit(1000);
//			Serenity.takeScreenshot(); 
//			clickOnSubmitSelectionButton();
//			System.out.println("Smarty Street clicks the Physical Addresses Radio Button for 2 or more potential physical address matches");
//		}  
		else if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & cancelConfirmAddressButton.isCurrentlyVisible() ||unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & cancelButton.isCurrentlyVisible() ){
			System.out.println("***If Number 19***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. Click Cancel and update address again");
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				System.out.println("Cancel Confirmation Button is clicked");
			} else {
				clickOnCancelButton();
				//clickOnProfileTab();
				System.out.println("Cancel Button is clicked");
			}
			System.out.println("3 SECOND DELAY!!!!!!!");
			waitABit(3000);
			Serenity.takeScreenshot(); 
			updatePhysicalAddress();
		}   else if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & keepEnteredMailingAddress.isCurrentlyVisible() ){
			System.out.println("***If Number 20***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. Update the physical address and Keep entered mailing address");
			clickOnSmartyStreetMailingAddressRadioButton();
			System.out.println("3 SECOND DELAY!!!!!!!");
			waitABit(3000);
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			updatePhysicalAddress();
		}	else if (keepEnteredPhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()) {
			System.out.println("...UI Scenario 5 Physical Address..");
			System.out.println("***If Number 21***");
			System.out.println("Physical Address cannot be validated, but will keep Physical address. Mailing address to be updated");
			//clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			updateStrikeMailingAddress();
			//updateMailingAddress();
		} 	else if ((unableToConfirmPhysicalAddress.isCurrentlyVisible() & cancelConfirmAddressButton.isCurrentlyVisible()) ||(unableToConfirmPhysicalAddress.isCurrentlyVisible() & cancelButton.isCurrentlyVisible())){
			System.out.println("***If Number 22***");
			System.out.println("Physical Address cannot be validated. Click Cancel and update address again");
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Confirmation Button is clicked");
			} 
			if (cancelButton.isCurrentlyVisible()){
				clickOnCancelButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Button is clicked");
			}
			Serenity.takeScreenshot(); 
			updatePhysicalAddress();
		}	else if ((unableToConfirmMailingAddress.isCurrentlyVisible() & cancelConfirmAddressButton.isCurrentlyVisible())||(unableToConfirmMailingAddress.isCurrentlyVisible() & cancelButton.isCurrentlyVisible())){
			System.out.println("***If Number 23***");
			System.out.println("Mailing Address cannot be validated.  Click Cancel and update address again");
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Confirmation Button is clicked");
			} 
			if (cancelButton.isCurrentlyVisible()){
				clickOnCancelButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Button is clicked");
			}

			Serenity.takeScreenshot(); 
			updateMailingAddress();
		} 	else if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & keepEnteredMailingAddress.isCurrentlyVisible()){
			System.out.println("***If Number 24***");
			System.out.println("Physical Address cannot be validated. Keep entered mailing addres and update physicl address again");
			clickOnOriginalMailingAddressRadioButton();
			Serenity.takeScreenshot(); 
			clickOnSubmitSelectionButton();
			updatePhysicalAddress();
		}	else if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & cancelButton.isCurrentlyVisible()){
			System.out.println("***If Number 25***");
			System.out.println("Physical Address cannot be validated. Click Cancel and update address again2");
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Confirmation Button is clicked");
			} 
			if (cancelButton.isCurrentlyVisible()){
				clickOnCancelButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Button is clicked");
			}

			Serenity.takeScreenshot(); 
			updatePhysicalAddress();
		}	else if (unableToConfirmMailingAddress.isCurrentlyVisible() & cancelButton.isCurrentlyVisible()){
			System.out.println("***If Number 26***");
			System.out.println("Mailing Address cannot be validated.  Click Cancel and update address again2");
			if (cancelConfirmAddressButton.isCurrentlyVisible()){
				clickOnCancelConfirmAddressButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Confirmation Button is clicked");
			} 
			if (cancelButton.isCurrentlyVisible()){
				clickOnCancelButton();
				//clickOnProfileTab();
				Serenity.takeScreenshot(); 
				System.out.println("Cancel Button is clicked");
			}
			Serenity.takeScreenshot(); 
			updateMailingAddress();
		}	else if (keepEnteredPhysicalAddress.isCurrentlyVisible() & keepEnteredMailingAddress.isCurrentlyVisible()) {
			System.out.println("...UI Scenario 5 Physical Address and Mailing Address..");
			System.out.println("***If Number 27***");
			System.out.println("Physical and Mailing Address cannot be validated.  Click Submit Selection Button to keep both addresses you entered");
			clickOnOriginalPhysicalAddressRadioButton();
			clickOnOriginalMailingAddressRadioButton();

//			clickOnSmartyStreetPhysicalAddressRadioButton();
//			clickOnConfirmPhysicalAddressCheckbox();
//			clickOnSmartyStreetMailingAddressRadioButton();
//			clickOnConfirmMailingAddressCheckbox();
			clickOnSubmitSelectionButton();
//			clickOnOriginalPhysicalAddressRadioButton();
//			clickOnOriginalMailingAddressRadioButton();
//			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
//			
//clickOnSmartyStreetPhysicalAddressRadioButton();
//clickOnConfirmPhysicalAddressCheckbox();
//clickOnSmartyStreetMailingAddressRadioButton();
//clickOnConfirmMailingAddressCheckbox();
//clickOnSubmitSelectionButton();
//
//			
			
			System.out.println("Originally entered Physical and mailing address will be saved");
			//clickOnCancelConfirmAddressButton();
		}	else if (keepEnteredPhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()  ) {
			System.out.println("***If Number 28***");
			System.out.println("Physical cannot be validated.  Click Submit Selection Button to keep the Physical address you entered");
			clickOnOriginalPhysicalAddressRadioButton();
			//clickOnOriginalMailingAddressRadioButton();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			System.out.println("***If Number 28 is complete and will keep the Physical Address***");
			Serenity.takeScreenshot(); 
			System.out.println("Originally entered Physical address will be saved");
		}	else if (keepEnteredPhysicalAddress.isCurrentlyVisible() & unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible()  ) {
			System.out.println("***If Number 29***");
			System.out.println("Physical cannot be validated.  Click Submit Selection Button to keep the Physical address you entered");
			clickOnOriginalPhysicalAddressRadioButton();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("Originally entered Physical address will be saved");
		}	else if (keepEnteredMailingAddress.isCurrentlyVisible() & originalMailingAddress.isCurrentlyVisible()) {
			System.out.println("***If Number 30***");
			System.out.println("Mailing Address cannot be validated.  Click Submit Selection Button to keep the mailing address you entered");
			clickOnOriginalMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("Originally entered mailing address will be saved");
		}	else if (keepEnteredPhysicalAddress.isCurrentlyVisible()) {
			System.out.println("***If Number 31***");
			System.out.println("Physical Address cannot be validated.  Click Cancel to keep the address you entered");
			clickOnOriginalPhysicalAddressRadioButton();
			clickOnSubmitSelectionButton();
			System.out.println("Originally entered Physical address will be saved");
			Serenity.takeScreenshot(); 
		}   else if (unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible() & smartyStreetMailingAddress.isCurrentlyVisible()){
			System.out.println("***If Number 32***");
			System.out.println("Physical Address is valid");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("The Mailing Address was found. Click Submit Button to Accept the Mailing Address");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
//			if(editProfileButton.isCurrentlyVisible()) {
//				System.out.println("Addresses have been saved.  Test is complete.");
//				Serenity.takeScreenshot(); 
//			}
//			else if (editProfileButton.isCurrentlyVisible()){
//			System.out.println("***If Number 32***");
//			System.out.println("Smarty Street Addresses have been Validated and Excepted.  No further updates are required");
			Serenity.takeScreenshot(); 
		
		
	
			
		} 	else if (unableToConfirmCloseMatchTo2MailingAddress.isCurrentlyVisible() & smartyStreetMailingAddress.isCurrentlyVisible()){
			System.out.println("***If Number 33***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("2 The Mailing Address was found. Click Submit Button to Accept the Mailing Address");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			if(editProfileButton.isCurrentlyVisible()) {
				System.out.println("Addresses have been saved.  Test is complete.");
				Serenity.takeScreenshot(); 
			}

			
			
			else if (editProfileButton.isCurrentlyVisible()){
			System.out.println("***If Number 34***");
			System.out.println("Smarty Street Addresses have been Validated and Excepted.  No further updates are required");
			Serenity.takeScreenshot(); 
			} else if (keepEnteredPhysicalAddress.isCurrentlyVisible() & originalPhysicalAddress.isCurrentlyVisible()  ) {
			System.out.println("***If Number 35");
			System.out.println("Physical cannot be validated.  Click Submit Selection Button to keep the Physical address you entered");
			clickOnOriginalPhysicalAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("Originally entered Physical address will be saved");
		}
	} 
		
		if (unableToValidatePhysicalAddressNoPo.isCurrentlyVisible() & unableToConfirmCloseMatchTo1MailingAddress.isCurrentlyVisible()){
			System.out.println("***If Number 36***");
			System.out.println("Physical Address cannot be validated. P.O. Boxes are now allowed in the physical address. ");
			System.out.println("The Mailing Address was found. Click Submit Button to Accept the Mailing Address and to Update the Physical Address");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnSubmitSelectionButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			if(editProfileButton.isCurrentlyVisible()) {
				System.out.println("Addresses have been saved.  Test is complete.");
				Serenity.takeScreenshot(); 
				}
			
			} 
		}
		waitABit(5000);
		System.out.println("Address Validation on Physical Address and Mailing Address is complete...");
		//completeNewProfileSteps.clickOnProceedToDashboardButton();
		Serenity.takeScreenshot();
		createNewProfilePage.clickOnProceedToDashboardButton();
		
	}
//}	
	
	
	
	
//	
//	if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
//		Serenity.takeScreenshot(); 
//		System.out.println("...UI Scenario 2 Physical Address and Mailing Address..");
//		System.out.println("***If Number 3***");
//		waitABit(2000);
//		clickOnCancelButton();
//		//clickOnProfileTab();
//		updatePhysicalAndMailingAddress();	
//		Serenity.takeScreenshot(); 		
//	
//	
	
	
	public void validateAllStrikeAddreses(){
		System.out.println("Validate All Strike Physical and Mailing Address Steps");
		waitABit(2000);
		if (confirmProfileSuccessfullyUpdated.isCurrentlyVisible()){
			System.out.println("Strike Physical Address and Mailing Address have already been updated.  No additional validation is required...");
		} 
		if (unableToConfirmPhysicalAddress.isCurrentlyVisible() & unableToConfirmMailingAddress.isCurrentlyVisible()){
			Serenity.takeScreenshot(); 
			System.out.println("...UI Scenario 2 Physical Address and Mailing Address.Strike Test.");
			System.out.println("***If Number 38 Strike Test***");
			waitABit(1000);
			////clickOnCancelConfirmAddressButton();
			clickOnCancelButton();
			waitABit(1000);
			clickOnNextOrSaveButton();
			Serenity.takeScreenshot(); 		
			waitABit(1000);
			//clickOnCancelConfirmAddressButton();
			clickOnCancelButton();
			waitABit(1000);
			clickOnNextOrSaveButton();
			//clickOnCancelConfirmAddressButton();
			Serenity.takeScreenshot(); 
//			validateAllAddreses();
			
			clickOnSmartyStreetPhysicalAddressRadioButton();  
			clickOnConfirmPhysicalAddressCheckbox();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnConfirmMailingAddressCheckbox();
			waitABit(1000);
			Serenity.takeScreenshot(); 		
			clickOnSubmitSelectionButton();
			////AddressValidationThreeStrike();
//			click selectedPhysicalAddr0
//			check confirmPhysicalAddress
//			click selectedMailingAddr0
//			check confirmMailingAddress
			Serenity.takeScreenshot(); 		
		} else if (unableToConfirmPhysicalAddress.isCurrentlyVisible()) {
				//& unableToConfirmMailingAddress.isCurrentlyVisible()){
			Serenity.takeScreenshot(); 
			System.out.println("...UI Scenario 2 Physical Address and Mailing Address.Strike Test.");
			System.out.println("***If Number 38 Strike Test***");
			waitABit(1000);
			////clickOnCancelConfirmAddressButton();
			clickOnCancelButton();
			waitABit(1000);
			clickOnNextOrSaveButton();
			Serenity.takeScreenshot(); 		
			waitABit(1000);
			//clickOnCancelConfirmAddressButton();
			clickOnCancelButton();
			waitABit(1000);
			clickOnNextOrSaveButton();
			//clickOnCancelConfirmAddressButton();
			Serenity.takeScreenshot(); 

			clickOnSmartyStreetPhysicalAddressRadioButton();  
			clickOnConfirmPhysicalAddressCheckbox();
//			clickOnSmartyStreetMailingAddressRadioButton();
//			clickOnConfirmMailingAddressCheckbox();
			waitABit(1000);
			Serenity.takeScreenshot(); 		
			clickOnSubmitSelectionButton();
			////AddressValidationThreeStrike();
//			click selectedPhysicalAddr0
//			check confirmPhysicalAddress
//			click selectedMailingAddr0
//			check confirmMailingAddress
			Serenity.takeScreenshot(); 		
		}	else if (unableToConfirmMailingAddress.isCurrentlyVisible()){
		Serenity.takeScreenshot(); 
		System.out.println("...UI Scenario 2 Physical Address and Mailing Address.Strike Test.");
		System.out.println("***If Number 38 Strike Test Update Mailing Address***");
		waitABit(1000);
		////clickOnCancelConfirmAddressButton();
		clickOnCancelButton();
		waitABit(1000);
		clickOnNextOrSaveButton();
		Serenity.takeScreenshot(); 		
		waitABit(1000);
		//clickOnCancelConfirmAddressButton();
		clickOnCancelButton();
		waitABit(1000);
		clickOnNextOrSaveButton();
		//clickOnCancelConfirmAddressButton();
		Serenity.takeScreenshot(); 

//	clickOnSmartyStreetPhysicalAddressRadioButton();  
//		clickOnConfirmPhysicalAddressCheckbox();
		clickOnSmartyStreetMailingAddressRadioButton();
		clickOnConfirmMailingAddressCheckbox();
		waitABit(1000);
		Serenity.takeScreenshot(); 		
		clickOnSubmitSelectionButton();
		////AddressValidationThreeStrike();
//		click selectedPhysicalAddr0
//		check confirmPhysicalAddress
//		click selectedMailingAddr0
//		check confirmMailingAddress
		Serenity.takeScreenshot(); 		
	}
		
		
		
		
		
		
		
		
		
		
		
		else if (strikePhysicalAddress.isCurrentlyVisible() & strikeMailingAddress.isCurrentlyVisible()){
			System.out.println("***Strike Test Primary and Mailing Address***");
			System.out.println("***If Number 14***");
			System.out.println("Physical and Mailing address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnConfirmPhysicalAddressCheckbox();
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Strike Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 	else if (strikePhysicalAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 6 Physical Address Only..Strike Test");
			System.out.println("***If Number 15***");
			System.out.println("Physical Address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetPhysicalAddressRadioButton();
			clickOnConfirmPhysicalAddressCheckbox();
//			clickOnSmartyStreetMailingAddressRadioButton();
//			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 	else if (strikeMailingAddress.isCurrentlyVisible()){
			System.out.println("...UI Scenario 6 Mailing Address Only..Strike Test");
			System.out.println("***If Number 16***");
			System.out.println("Mailing Address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
			clickOnSmartyStreetMailingAddressRadioButton();
			clickOnConfirmMailingAddressCheckbox();
//			clickOnOriginalPhysicalAddressRadioButton();
			Serenity.takeScreenshot(); 
			System.out.println("3 SECOND DELAY to then update mailing address!!!!!!!");
			waitABit(3000);
			clickOnSubmitSelectionButton();
			System.out.println("Address validation is complete, no need to update address anyfurther");
//			updatePhysicalAddress();
		} 
		
		//////////////////
//		if (unableToConfirmPhysicalAddress.isCurrentlyVisible()){
//			// & unableToConfirmMailingAddress.isCurrentlyVisible()){
//			Serenity.takeScreenshot(); 
//			System.out.println("...UI Scenario 2 Physical Address and Mailing Address.Strike Test.");
//			System.out.println("***If Number 38 Strike Test***");
//			System.out.println("***Confirm Physical Address***");
//			waitABit(1000);
//			////clickOnCancelConfirmAddressButton();
//			clickOnCancelButton();
//			waitABit(1000);
//
//			
//			
//			clickOnNextOrSaveButton();
//			Serenity.takeScreenshot(); 		
//			waitABit(1000);
//			//clickOnCancelConfirmAddressButton();
//			clickOnCancelButton();
//			waitABit(2000);
//			clickOnNextOrSaveButton();
//			//clickOnCancelConfirmAddressButton();
//			Serenity.takeScreenshot(); 
////			validateAllAddreses();
//			
//			clickOnSmartyStreetPhysicalAddressRadioButton();  
//			clickOnConfirmPhysicalAddressCheckbox();
//			clickOnSmartyStreetMailingAddressRadioButton();
//			clickOnConfirmMailingAddressCheckbox();
//			waitABit(2000);
//			Serenity.takeScreenshot(); 		
//			clickOnSubmitSelectionButton();
//			////AddressValidationThreeStrike();
////			click selectedPhysicalAddr0
////			check confirmPhysicalAddress
////			click selectedMailingAddr0
////			check confirmMailingAddress
//			Serenity.takeScreenshot(); 		
//		}
//		
		
		
	}
	
	//unableToConfirmPhysicalAddress
///////////////////////This one works////////////////////////////	
	public void validatePhysicalAndMailingAddressOriginal() {
		System.out.println("Original Validate Physical and Mailing Address Steps after new profile saved");
		waitABit(1000);
//		validateAllAddreses();
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to wait Confirm Your Address Message Message to be displayed... " + i);
			if (hobbyistNextButton.isCurrentlyVisible() | addUasButton.isCurrentlyVisible() | editProfileButton.isCurrentlyVisible() | confirmYourAddress.isCurrentlyVisible() | confirmYourPhysicalAddress.isCurrentlyVisible() | confirmYourMailingAddress.isCurrentlyVisible()){
			//if (editProfileButton.isCurrentlyVisible() | addUasButton.isCurrentlyVisible()){
			i=19;
			//if (editProfileButton.isCurrentlyVisible() | addUasButton.isCurrentlyVisible()){
			//confirmYourAddress.isCurrentlyVisible() | confirmYourPhysicalAddress.isCurrentlyVisible() | confirmYourMailingAddress.isCurrentlyVisible()
			validateAllAddreses();
				System.out.println("confirm Your Address Messages is visible");
			} else {
				System.out.println("confirm Your Address is not visible no need to validate addresses");
			}
//		}	
			System.out.println("Confirm Your Address Message is visible on the screen");
			//}
			//else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}
	}
//}

	public void validatePhysicalAndMailingAddress() {
		System.out.println("Validate Physical and Mailing Address Steps after new profile saved");
		waitABit(1000);
		validateAllAddreses();

		
	}	
	


	public void validatePhysicalAddress() {
		System.out.println("Validate Physical Address Steps");
		waitABit(1000);
		validateAllAddreses();
	}		

	
	public void validateMailingAddress() {
	System.out.println("Validate Mailing Address Steps");
	waitABit(1000);
	validateAllAddreses();
	}
	
	
//////////////////////
	public void updatePhysicalAndMailingAddress(){
		System.out.println("New Physical Country is " + newProfilePhysicalAddress[0]);
		System.out.println("New Physical Address1 is " + newProfilePhysicalAddress[1]);
		System.out.println("New Physical Address2 is " + newProfilePhysicalAddress[2]);
		System.out.println("New Physical City is " + newProfilePhysicalAddress[3]);
		System.out.println("New Physical State is " + newProfilePhysicalAddress[4]);
		System.out.println("New Physical Zip is " + newProfilePhysicalAddress[5]);
		
		System.out.println("New Mailing Country is " + newProfileMailingAddress[0]);
		System.out.println("New Mailing Address1 is " + newProfileMailingAddress[1]);
		System.out.println("New Mailing Address2 is " + newProfileMailingAddress[2]);
		System.out.println("New Mailing City is " + newProfileMailingAddress[3]);
		System.out.println("New Mailing State is " + newProfileMailingAddress[4]);
		System.out.println("New Mailing Zip is " + newProfileMailingAddress[5]);
		//updatedPhysicalCountry
		Serenity.setSessionVariable("varProfilePhysicalCountry").to(newProfilePhysicalAddress[0]);
		String updatedProfilePhysicalCountry = Serenity.sessionVariableCalled("varProfilePhysicalCountry").toString();
		System.out.println("On Verify new Physical Country is--->  " + updatedProfilePhysicalCountry);
		createNewProfilePage.selectProfilePhysicalCountryDropDown(updatedProfilePhysicalCountry); 
		
		//updatedProfilePhysicalAddress1
		Serenity.setSessionVariable("varProfilePhysicalAddress1").to(newProfilePhysicalAddress[1]);
		String updatedProfilePhysicalAddress1 = Serenity.sessionVariableCalled("varProfilePhysicalAddress1").toString();
		System.out.println("On Verify new Physical Address1 is--->  " + updatedProfilePhysicalAddress1);
//		createNewProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfilePhysicalAddress1);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(updatedProfilePhysicalAddress1);

		//updatedProfilePhysicalAddress2
		Serenity.setSessionVariable("varProfilePhysicalAddress2").to(newProfilePhysicalAddress[2]);
		String updatedProfilePhysicalAddress2 = Serenity.sessionVariableCalled("varProfilePhysicalAddress2").toString();
		System.out.println("On Verify new Physical Address2 is--->  " + updatedProfilePhysicalAddress2);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(updatedProfilePhysicalAddress2);
		
		//updatedProfilePhysicalCity
		Serenity.setSessionVariable("varProfilePhysicalCity").to(newProfilePhysicalAddress[3]);
		String updatedProfilePhysicalCity = Serenity.sessionVariableCalled("varProfilePhysicalCity").toString();
		System.out.println("On Verify new Physical City is--->" + updatedProfilePhysicalCity);
		createNewProfilePage.typeIntoCreateProfilePhysicalCity(updatedProfilePhysicalCity);

		//updatedProfilePhysicalState
		System.out.println("Physical Country Value from Session Variable--->" + updatedProfilePhysicalCountry);
		Serenity.setSessionVariable("varProfilePhysicalState").to(newProfilePhysicalAddress[4]);
		String updatedPhysicalState = Serenity.sessionVariableCalled("varProfilePhysicalState").toString();
		System.out.println("On Verify new Physical State is--->" + updatedPhysicalState);
		//if (newProfilePhysicalAddress[0].equals("United States")) {
		if (updatedProfilePhysicalCountry.equals("United States")) {
			createNewProfilePage.selectFromPhysicalStateNameDropdownList(updatedPhysicalState);  
			System.out.println("Physical State Selected from Drop Down List is: " + updatedPhysicalState);
		} else {
			createNewProfilePage.typeIntoCreateProfilePhysicalStateNameField(updatedPhysicalState);
			System.out.println("Physical Country is not United States, so here is the new Country TEXT value: " + updatedProfilePhysicalCountry);
		}
		
		//updatedProfilePhysicalZip
		Serenity.setSessionVariable("varProfilePhysicalZip").to(newProfilePhysicalAddress[5]);
		String updatedProfilePhysicalZip = Serenity.sessionVariableCalled("varProfilePhysicalZip").toString();
		System.out.println("On Verify new Physical Zip is--->  " + updatedProfilePhysicalZip);
		createNewProfilePage.typeIntoCreateProfilePhysicalZip(updatedProfilePhysicalZip);
		//createNewProfilePage.typeIntoCreateProfileMailingZip(updatedProfilePhysicalZip);
		Serenity.takeScreenshot(); 

		//**Update Mailing Address **//
		//updatedMailingCountry
		Serenity.setSessionVariable("varProfileMailingCountry").to(newProfileMailingAddress[0]);
		String updatedProfileMailingCountry = Serenity.sessionVariableCalled("varProfileMailingCountry").toString();
		System.out.println("On Verify new Mailing Country is--->  " + updatedProfileMailingCountry);
		createNewProfilePage.selectProfileMailingCountryDropDown(updatedProfileMailingCountry);  
		
		//updatedProfileMailingAddress1
		Serenity.setSessionVariable("varProfileMailingAddress1").to(newProfileMailingAddress[1]);
		String updatedProfileMailingAddress1 = Serenity.sessionVariableCalled("varProfileMailingAddress1").toString();
		System.out.println("On Verify new mailing Address1 is--->  " + updatedProfileMailingAddress1);
		createNewProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfileMailingAddress1);

		//updatedProfileMailingAddress2
		Serenity.setSessionVariable("varProfileMailingAddress2").to(newProfileMailingAddress[2]);
		String updatedProfileMailingAddress2 = Serenity.sessionVariableCalled("varProfileMailingAddress2").toString();
		System.out.println("On Verify new mailing Address2 is--->  " + updatedProfileMailingAddress2);
		createNewProfilePage.typeIntoCreateProfileMailingAddress2(updatedProfileMailingAddress2);

		//updatedProfileMailingCity
		Serenity.setSessionVariable("varProfileMailingCity").to(newProfileMailingAddress[3]);
		String updatedProfileMailingCity = Serenity.sessionVariableCalled("varProfileMailingCity").toString();
		System.out.println("On Verify new mailing City is--->  " + updatedProfileMailingCity);
		createNewProfilePage.typeIntoCreateProfileMailingCity(updatedProfileMailingCity);

		//updatedProfileMailingState
		Serenity.setSessionVariable("varProfileMailingState").to(newProfileMailingAddress[4]);
		String updatedProfileMailingState = Serenity.sessionVariableCalled("varProfileMailingState").toString();
		System.out.println("On Verify new mailing State is--->  " + updatedProfileMailingState);
		if (newProfileMailingAddress[0].equals("United States")) {
			createNewProfilePage.selectFromMailingStateNameDropdownList(updatedProfileMailingState);
			System.out.println("Mailing State Selected from Drop Down List is: " + updatedProfileMailingState);
		} else {
			createNewProfilePage.typeIntoMailingStateNameField(updatedProfileMailingState); 
			System.out.println("Mailing Country is not United States, so here is the new Country TEXT value: " + newProfileMailingAddress[0]);
		}

		//updatedProfileMailingZip
		Serenity.setSessionVariable("varProfileMailingZip").to(newProfileMailingAddress[5]);
		String updatedProfileMailingZip = Serenity.sessionVariableCalled("varProfileMailingZip").toString();
		System.out.println("On Verify new mailing Zip is--->  " + updatedProfileMailingZip);
		createNewProfilePage.typeIntoCreateProfileMailingZip(updatedProfileMailingZip);
		Serenity.takeScreenshot(); 
		clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
		validatePhysicalAndMailingAddress();
		
	}	
	
	
	public void updatePhysicalAddress(){
		waitABit(1000);
//////		if (saveButton.isCurrentlyVisible()){
//////		System.out.println("Save Button is Visible.  We can now Update our Physical Address Data");	
		String[] newPhysicalAddress  = DataGenerator.randomAddress();
		//String[] newMailingAddress  = DataGenerator.randomAddress();
		System.out.println("New Physical Country is " + newPhysicalAddress[0]);
		System.out.println("New Physical Address1 is " + newPhysicalAddress[1]);
		System.out.println("New Physical Address2 is " + newPhysicalAddress[2]);
		System.out.println("New Physical City is " + newPhysicalAddress[3]);
		System.out.println("New Physical State is " + newPhysicalAddress[4]);
		System.out.println("New Physical Zip is " + newPhysicalAddress[5]);
		//updatedPhysicalCountry
		Serenity.setSessionVariable("varPhysicalCountry1").to(newPhysicalAddress[0]);
		String updatedPhysicalCountry = Serenity.sessionVariableCalled("varPhysicalCountry1").toString();
		System.out.println("On Verify new Physical Country is--->" + updatedPhysicalCountry);
		createNewProfilePage.selectProfilePhysicalCountryDropDown(updatedPhysicalCountry); 

		//updatedPhysicalAddress1
		Serenity.setSessionVariable("varPhysicalAddress1").to(newPhysicalAddress[1]);
		String updatedPhysicalAddress1 = Serenity.sessionVariableCalled("varPhysicalAddress1").toString();
		System.out.println("On Verify new Physical Address1 is--->" + updatedPhysicalAddress1);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(updatedPhysicalAddress1);

		//updatedPhysicalAddress2
		Serenity.setSessionVariable("varPhysicalAddress2").to(newPhysicalAddress[2]);
		String updatedPhysicalAddress2 = Serenity.sessionVariableCalled("varPhysicalAddress2").toString();
		System.out.println("On Verify new Physical Address2 is--->" + updatedPhysicalAddress2);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(updatedPhysicalAddress2);
		
		//updatedPhysicalCity
		Serenity.setSessionVariable("varPhysicalCity").to(newPhysicalAddress[3]);
		String updatedPhysicalCity = Serenity.sessionVariableCalled("varPhysicalCity").toString();
		System.out.println("On Verify new Physical City is--->" + updatedPhysicalCity);
		createNewProfilePage.typeIntoCreateProfilePhysicalCity(updatedPhysicalCity);

		//updatedPhysicalState
		Serenity.setSessionVariable("varPhysicalState").to(newPhysicalAddress[4]);
		String updatedPhysicalState = Serenity.sessionVariableCalled("varPhysicalState").toString();
		System.out.println("On Verify new Physical State is--->  " + updatedPhysicalState);
		if (newPhysicalAddress[0].equals("United States")) {
		createNewProfilePage.selectFromPhysicalStateNameDropdownList(updatedPhysicalState);  
		System.out.println("Physical State Selected from Drop Down List is: " + newPhysicalAddress[4]);
		} else {
		createNewProfilePage.typeIntoCreateProfilePhysicalStateNameField(updatedPhysicalState);
		System.out.println("Physical Country is not United States, so here is the new Country TEXT value: " + newPhysicalAddress[0]);
		}
		
		//updatedPhysicalZip
		Serenity.setSessionVariable("varPhysicalZip").to(newPhysicalAddress[5]);
		String updatedPhysicalZip = Serenity.sessionVariableCalled("varPhysicalZip").toString();
		System.out.println("On Verify new Physical Zipcode is--->  " + updatedPhysicalZip);
		createNewProfilePage.typeIntoCreateProfilePhysicalZip(updatedPhysicalZip);
		Serenity.takeScreenshot(); 
		waitABit(1000);
		System.out.println("Next Step is to click on the Proceed To Checkout button");
		clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
		validatePhysicalAndMailingAddress();
		}	
/////	}
	
	public void updateMailingAddress(){
		String[] newMailingAddress  = DataGenerator.randomAddress();
		System.out.println("New Mailing Country is " + newMailingAddress[0]);
		System.out.println("New Mailing Address1 is " + newMailingAddress[1]);
		System.out.println("New Mailing Address2 is " + newMailingAddress[2]);
		System.out.println("New Mailing City is " + newMailingAddress[3]);
		System.out.println("New Mailing State is " + newMailingAddress[4]);
		System.out.println("New Mailing Zip is " + newMailingAddress[5]);
		//updatedMailingCountry
		Serenity.setSessionVariable("varMailingCountry").to(newMailingAddress[0]);
		String updatedMailingCountry = Serenity.sessionVariableCalled("varMailingCountry").toString();
		System.out.println("On Verify new Mailing Country is--->  " + updatedMailingCountry);
		
		createNewProfilePage.selectProfileMailingCountryDropDown(updatedMailingCountry);  
		
		//updatedMailingAddress1
		Serenity.setSessionVariable("varMailingAddress1").to(newMailingAddress[1]);
		String updatedMailingAddress1 = Serenity.sessionVariableCalled("varMailingAddress1").toString();
		System.out.println("On Verify new mailing Address1 is--->  " + updatedMailingAddress1);
		createNewProfilePage.typeIntoCreateProfileMailingAddress1(updatedMailingAddress1);

		//updatedMailingAddress2
		Serenity.setSessionVariable("varMailingAddress2").to(newMailingAddress[2]);
		String updatedMailingAddress2 = Serenity.sessionVariableCalled("varMailingAddress2").toString();
		System.out.println("On Verify new mailing Address2 is--->  " + updatedMailingAddress2);
		createNewProfilePage.typeIntoCreateProfileMailingAddress2(updatedMailingAddress2);
		
		//newMailingCity
		Serenity.setSessionVariable("varMailingCity").to(newMailingAddress[3]);
		String updatedMailingCity = Serenity.sessionVariableCalled("varMailingCity").toString();
		System.out.println("On Verify new mailing City is--->  " + updatedMailingCity);
		createNewProfilePage.typeIntoCreateProfileMailingCity(updatedMailingCity);

		//updatedMailingState
		Serenity.setSessionVariable("varMailingState").to(newMailingAddress[4]);
		String updatedMailingState = Serenity.sessionVariableCalled("varMailingState").toString();
		if (newMailingAddress[0].equals("United States")) {
		System.out.println("On Verify new mailing State is--->  " + updatedMailingState);
		createNewProfilePage.selectFromMailingStateNameDropdownList(updatedMailingState);
		System.out.println("Mailing State Selected from Drop Down List is: " + updatedMailingState);
		} else {
		createNewProfilePage.typeIntoMailingStateNameField(updatedMailingState);  
		System.out.println("Mailing Country is not United States, so here is the new Country TEXT value: " + newMailingAddress[0]);
		}
		//updatedMailingZip
		Serenity.setSessionVariable("varMailingZip").to(newMailingAddress[5]);
		String updatedMailingZip = Serenity.sessionVariableCalled("varMailingZip").toString();
		System.out.println("On Verify new mailing Zipcode is--->  " + updatedMailingZip);
		createNewProfilePage.typeIntoCreateProfileMailingZip(updatedMailingZip);
		Serenity.takeScreenshot(); 
		clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
		waitABit(1000);
		Serenity.takeScreenshot(); 
		validatePhysicalAndMailingAddress();
		}
//	}
///////////////////////
//////////////////////physicalStrikeAddress   mailingStrikeAddress
public void updateStrikePhysicalAndMailingAddress(){
System.out.println("New Physical Country is " + newStrikeProfilePhysicalAddress[0]);
System.out.println("New Physical Address1 is " + newStrikeProfilePhysicalAddress[1]);
System.out.println("New Physical Address2 is " + newStrikeProfilePhysicalAddress[2]);
System.out.println("New Physical City is " + newStrikeProfilePhysicalAddress[3]);
System.out.println("New Physical State is " + newStrikeProfilePhysicalAddress[4]);
System.out.println("New Physical Zip is " + newStrikeProfilePhysicalAddress[5]);

System.out.println("New Mailing Country is " + newStrikeProfileMailingAddress[0]);
System.out.println("New Mailing Address1 is " + newStrikeProfileMailingAddress[1]);
System.out.println("New Mailing Address2 is " + newStrikeProfileMailingAddress[2]);
System.out.println("New Mailing City is " + newStrikeProfileMailingAddress[3]);
System.out.println("New Mailing State is " + newStrikeProfileMailingAddress[4]);
System.out.println("New Mailing Zip is " + newStrikeProfileMailingAddress[5]);
//updatedPhysicalCountry
Serenity.setSessionVariable("varProfilePhysicalCountry").to(newStrikeProfilePhysicalAddress[0]);
String updatedProfilePhysicalCountry = Serenity.sessionVariableCalled("varProfilePhysicalCountry").toString();
System.out.println("On Verify new Physical Country is--->  " + updatedProfilePhysicalCountry);
updateStrikeProfilePage.selectProfilePhysicalCountryDropDown(updatedProfilePhysicalCountry); 


//updatedProfilePhysicalAddress1
Serenity.setSessionVariable("varProfilePhysicalAddress1").to(newStrikeProfilePhysicalAddress[1]);
String updatedProfilePhysicalAddress1 = Serenity.sessionVariableCalled("varProfilePhysicalAddress1").toString();
System.out.println("On Verify new Physical Address1 is--->  " + updatedProfilePhysicalAddress1);
//updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfilePhysicalAddress1);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress1(updatedProfilePhysicalAddress1);

//updatedProfilePhysicalAddress2
Serenity.setSessionVariable("varProfilePhysicalAddress2").to(newStrikeProfilePhysicalAddress[2]);
String updatedProfilePhysicalAddress2 = Serenity.sessionVariableCalled("varProfilePhysicalAddress2").toString();
System.out.println("On Verify new Physical Address2 is--->  " + updatedProfilePhysicalAddress2);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress2(updatedProfilePhysicalAddress2);

//updatedProfilePhysicalCity
Serenity.setSessionVariable("varProfilePhysicalCity").to(newStrikeProfilePhysicalAddress[3]);
String updatedProfilePhysicalCity = Serenity.sessionVariableCalled("varProfilePhysicalCity").toString();
System.out.println("On Verify new Physical City is--->  " + updatedProfilePhysicalCity);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalCity(updatedProfilePhysicalCity);

//updatedProfilePhysicalState
Serenity.setSessionVariable("varProfilePhysicalState").to(newStrikeProfilePhysicalAddress[4]);
String updatedPhysicalState = Serenity.sessionVariableCalled("varProfilePhysicalState").toString();
System.out.println("On Verify new Physical State is--->  " + updatedPhysicalState);
if (newStrikeProfilePhysicalAddress[0].equals("United States")) {
updateStrikeProfilePage.selectFromPhysicalStateNameDropdownList(updatedPhysicalState);  
System.out.println("Physical State Selected from Drop Down List is: " + updatedPhysicalState);
} else {
updateStrikeProfilePage.typeIntoCreateProfilePhysicalStateNameField(updatedPhysicalState);
System.out.println("Physical Country is not United States, so here is the new Country TEXT value: " + newStrikeProfilePhysicalAddress[0]);
}

//updatedProfilePhysicalZip
Serenity.setSessionVariable("varProfilePhysicalZip").to(newStrikeProfilePhysicalAddress[5]);
String updatedProfilePhysicalZip = Serenity.sessionVariableCalled("varProfilePhysicalZip").toString();
System.out.println("On Verify new Physical Zip is--->  " + updatedProfilePhysicalZip);
updateStrikeProfilePage.typeIntoCreateProfileMailingZip(updatedProfilePhysicalZip);
Serenity.takeScreenshot(); 

//**Update Mailing Address **//
//updatedMailingCountry
Serenity.setSessionVariable("varProfileMailingCountry").to(newStrikeProfileMailingAddress[0]);
String updatedProfileMailingCountry = Serenity.sessionVariableCalled("varProfileMailingCountry").toString();
System.out.println("On Verify new Mailing Country is--->  " + updatedProfileMailingCountry);
updateStrikeProfilePage.selectProfileMailingCountryDropDown(updatedProfileMailingCountry);  

//updatedProfileMailingAddress1
Serenity.setSessionVariable("varProfileMailingAddress1").to(newStrikeProfileMailingAddress[1]);
String updatedProfileMailingAddress1 = Serenity.sessionVariableCalled("varProfileMailingAddress1").toString();
System.out.println("On Verify new mailing Address1 is--->  " + updatedProfileMailingAddress1);
updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfileMailingAddress1);

//updatedProfileMailingAddress2
Serenity.setSessionVariable("varProfileMailingAddress2").to(newStrikeProfileMailingAddress[2]);
String updatedProfileMailingAddress2 = Serenity.sessionVariableCalled("varProfileMailingAddress2").toString();
System.out.println("On Verify new mailing Address2 is--->  " + updatedProfileMailingAddress2);
updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfileMailingAddress2);

//updatedProfileMailingCity
Serenity.setSessionVariable("varProfileMailingCity").to(newStrikeProfileMailingAddress[3]);
String updatedProfileMailingCity = Serenity.sessionVariableCalled("varProfileMailingCity").toString();
System.out.println("On Verify new mailing City is--->  " + updatedProfileMailingCity);
updateStrikeProfilePage.typeIntoCreateProfileMailingCity(updatedProfileMailingCity);

//updatedProfileMailingState
Serenity.setSessionVariable("varProfileMailingState").to(newStrikeProfileMailingAddress[4]);
String updatedProfileMailingState = Serenity.sessionVariableCalled("varProfileMailingState").toString();
System.out.println("On Verify new mailing State is--->  " + updatedProfileMailingState);
if (newStrikeProfileMailingAddress[0].equals("United States")) {
updateStrikeProfilePage.selectFromMailingStateNameDropdownList(updatedProfileMailingState);
System.out.println("Mailing State Selected from Drop Down List is: " + updatedProfileMailingState);
} else {
updateStrikeProfilePage.typeIntoMailingStateNameField(updatedProfileMailingState); 
System.out.println("Mailing Country is not United States, so here is the new Country TEXT value: " + newStrikeProfileMailingAddress[0]);
}

//updatedProfileMailingZip
Serenity.setSessionVariable("varProfileMailingZip").to(newStrikeProfileMailingAddress[5]);
String updatedProfileMailingZip = Serenity.sessionVariableCalled("varProfileMailingZip").toString();
System.out.println("On Verify new mailing Zip is--->  " + updatedProfileMailingZip);
updateStrikeProfilePage.typeIntoCreateProfileMailingZip(updatedProfileMailingZip);
Serenity.takeScreenshot(); 
clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
validatePhysicalAndMailingAddress();

}	


public void updateStrikePhysicalAddress(){
waitABit(1000);
//if (saveButton.isCurrentlyVisible()){
System.out.println("Save Button is Visible.  We can now Update our Physical Address Data");	
String[] newStrikePhysicalAddress  = DataGenerator.randomAddressStrike();
System.out.println("New Physical Country is " + newStrikePhysicalAddress[0]);
System.out.println("New Physical Address1 is " + newStrikePhysicalAddress[1]);
System.out.println("New Physical Address2 is " + newStrikePhysicalAddress[2]);
System.out.println("New Physical City is " + newStrikePhysicalAddress[3]);
System.out.println("New Physical State is " + newStrikePhysicalAddress[4]);
System.out.println("New Physical Zip is " + newStrikePhysicalAddress[5]);
//updatedPhysicalCountry
Serenity.setSessionVariable("varPhysicalCountry1").to(newStrikePhysicalAddress[0]);
String updatedPhysicalCountry = Serenity.sessionVariableCalled("varPhysicalCountry1").toString();
System.out.println("On Verify new Physical Country is--->  " + updatedPhysicalCountry);
updateStrikeProfilePage.selectProfilePhysicalCountryDropDown(updatedPhysicalCountry); 

//updatedPhysicalAddress1
Serenity.setSessionVariable("varPhysicalAddress1").to(newStrikePhysicalAddress[1]);
String updatedPhysicalAddress1 = Serenity.sessionVariableCalled("varPhysicalAddress1").toString();
System.out.println("On Verify new Physical Address1 is--->  " + updatedPhysicalAddress1);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress1(updatedPhysicalAddress1);

//updatedPhysicalAddress2
Serenity.setSessionVariable("varPhysicalAddress2").to(newStrikePhysicalAddress[2]);
String updatedPhysicalAddress2 = Serenity.sessionVariableCalled("varPhysicalAddress2").toString();
System.out.println("On Verify new Physical Address2 is--->  " + updatedPhysicalAddress2);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalAddress2(updatedPhysicalAddress2);


//updatedPhysicalCity
Serenity.setSessionVariable("varPhysicalCity").to(newStrikePhysicalAddress[3]);
String updatedPhysicalCity = Serenity.sessionVariableCalled("varPhysicalCity").toString();
System.out.println("On Verify new Physical City is--->  " + updatedPhysicalCity);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalCity(updatedPhysicalCity);

//updatedPhysicalState
Serenity.setSessionVariable("varPhysicalState").to(newStrikePhysicalAddress[4]);
String updatedPhysicalState = Serenity.sessionVariableCalled("varPhysicalState").toString();
System.out.println("On Verify new Physical State is--->  " + updatedPhysicalState);
if (newStrikePhysicalAddress[0].equals("United States")) {
updateStrikeProfilePage.selectFromPhysicalStateNameDropdownList(updatedPhysicalState);  
System.out.println("Physical State Selected from Drop Down List is: " + newStrikePhysicalAddress[4]);
} else {
updateStrikeProfilePage.typeIntoCreateProfilePhysicalStateNameField(updatedPhysicalState);
System.out.println("Physical Country is not United States, so here is the new Country TEXT value: " + newStrikePhysicalAddress[0]);
}

//updatedPhysicalZip
Serenity.setSessionVariable("varPhysicalZip").to(newStrikePhysicalAddress[5]);
String updatedPhysicalZip = Serenity.sessionVariableCalled("varPhysicalZip").toString();
System.out.println("On Verify new Physical Zipcode is--->  " + updatedPhysicalZip);
updateStrikeProfilePage.typeIntoCreateProfilePhysicalZip(updatedPhysicalZip);
Serenity.takeScreenshot(); 
waitABit(1000);
clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
validatePhysicalAndMailingAddress();
}	
//}

public void updateStrikeMailingAddress(){
//if (saveButton.isCurrentlyVisible()){
System.out.println("Save Button is Visible.  We can now Update our Mailing Address Data");	
String[] newStrikeMailingAddress  = DataGenerator.randomAddressStrike();
System.out.println("Strike New Mailing Country is " + newStrikeMailingAddress[0]);
System.out.println("Strike New Mailing Address1 is " + newStrikeMailingAddress[1]);
System.out.println("Strike New Mailing Address2 is " + newStrikeMailingAddress[2]);
System.out.println("Strike New Mailing City is " + newStrikeMailingAddress[3]);
System.out.println("Strike New Mailing State is " + newStrikeMailingAddress[4]);
System.out.println("Strike New Mailing Zip is " + newStrikeMailingAddress[5]);
//updatedMailingCountry
Serenity.setSessionVariable("varMailingCountry").to(newStrikeMailingAddress[0]);
String updatedMailingCountry = Serenity.sessionVariableCalled("varMailingCountry").toString();
System.out.println("On Verify new Mailing Country is--->  " + updatedMailingCountry);
updateStrikeProfilePage.selectProfileMailingCountryDropDown(updatedMailingCountry);  

//updatedMailingAddress1
Serenity.setSessionVariable("varMailingAddress1").to(newStrikeMailingAddress[1]);
String updatedMailingAddress1 = Serenity.sessionVariableCalled("varMailingAddress1").toString();
System.out.println("On Verify new mailing Address1 is--->  " + updatedMailingAddress1);
updateStrikeProfilePage.typeIntoCreateProfileMailingAddress1(updatedMailingAddress1);

//updatedMailingAddress2
Serenity.setSessionVariable("varMailingAddress2").to(newStrikeMailingAddress[2]);
String updatedMailingAddress2 = Serenity.sessionVariableCalled("varMailingAddress2").toString();
System.out.println("On Verify new mailing Address2 is--->  " + updatedMailingAddress2);
updateStrikeProfilePage.typeIntoCreateProfileMailingAddress2(updatedMailingAddress2);

//newMailingCity
Serenity.setSessionVariable("varMailingCity").to(newStrikeMailingAddress[3]);
String updatedMailingCity = Serenity.sessionVariableCalled("varMailingCity").toString();
System.out.println("On Verify new mailing City is--->  " + updatedMailingCity);
updateStrikeProfilePage.typeIntoCreateProfileMailingCity(updatedMailingCity);

//updatedMailingState
Serenity.setSessionVariable("varMailingState").to(newStrikeMailingAddress[4]);
String updatedMailingState = Serenity.sessionVariableCalled("varMailingState").toString();
if (newStrikeMailingAddress[0].equals("United States")) {
System.out.println("On Verify new mailing State is--->  " + updatedMailingState);
updateStrikeProfilePage.selectFromMailingStateNameDropdownList(updatedMailingState);
System.out.println("Mailing State Selected from Drop Down List is: " + updatedMailingState);
} else {
updateStrikeProfilePage.typeIntoMailingStateNameField(updatedMailingState);  
System.out.println("Mailing Country is not United States, so here is the new Country TEXT value: " + newStrikeMailingAddress[0]);
}
//updatedMailingZip
Serenity.setSessionVariable("varMailingZip").to(newStrikeMailingAddress[5]);
String updatedMailingZip = Serenity.sessionVariableCalled("varMailingZip").toString();
System.out.println("On Verify new mailing Zipcode is--->  " + updatedMailingZip);
updateStrikeProfilePage.typeIntoCreateProfileMailingZip(updatedMailingZip);
Serenity.takeScreenshot(); 
clickOnProceedToDashboardOrCheckoutOrNextOrSaveButton();
waitABit(1000);
Serenity.takeScreenshot(); 
validatePhysicalAndMailingAddress();
}
//}
	
	
	
	public void AddressValidationThreeStrike(){
	if (strikePhysicalAddress.isCurrentlyVisible() & strikeMailingAddress.isCurrentlyVisible()){
		System.out.println("Physical and Mailing address cannot be validated. Keep previously entered address or click the Checkbox to confirm the physical address is valid");
		System.out.println("...UI Scenario 2 Physical Address and Mailing Address.Strike Test.");
		System.out.println("***If Number 39 Strike Test***");
		clickOnSmartyStreetPhysicalAddressRadioButton();
		clickOnConfirmPhysicalAddressCheckbox();
		clickOnSmartyStreetMailingAddressRadioButton();
		clickOnConfirmMailingAddressCheckbox();
//		clickOnOriginalPhysicalAddressRadioButton();
		Serenity.takeScreenshot(); 
		System.out.println("3 SECOND DELAY to then update physical address!!!!!!!");
		waitABit(3000);
		Serenity.takeScreenshot();
		clickOnSubmitSelectionButton();
		System.out.println("Strike Address validation is complete, no need to update address anyfurther");
//		updatePhysicalAddress();
		} 
	}
	
	


}		
		

