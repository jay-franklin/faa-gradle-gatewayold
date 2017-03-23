package faa.cucumber.pages;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.xmlbeans.SystemProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import net.thucydides.core.screenshots.*;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;
import faa.utils.Verify;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


/**
 * @authors jfranklin
 * Create FAA New Profile Page
 */
public class CreateNewProfilePage extends BasePageObject {

	AddNewUasPage addNewUasPage;
	BillingInformationPage billingInformationPage;
	
	@FindBy(xpath = "//input[@id='firstName']") private WebElementFacade createProfileFirstName;
	@FindBy(xpath = "//input[@id='middleInitial']") private WebElementFacade createProfileMiddleInitial;
	@FindBy(id = "formLastName") private WebElementFacade createProfileLastName;
	@FindBy(id = "nameSuffix") private WebElementFacade createProfileNameSuffix;
	@FindBy(id = "title") private WebElementFacade createProfileUserTitle;
	@FindBy(id = "alternateEmail") private WebElementFacade createProfileAlternateEmail;
	@FindBy(id = "phone") private WebElementFacade createProfilePhone;
	@FindBy(id = "phoneExt") private WebElementFacade createProfilePhoneExt;
	@FindBy(id = "orgName") private WebElementFacade createProfileOrganizationName;
	@FindBy(id = "dba") private WebElementFacade createProfileDBA;
	@FindBy(id = "physicalAddress_country") private WebElementFacade createProfilePhysicalCountry;
	@FindBy(id = "physicalAddress_addressLine1") private WebElementFacade createProfilePhysicalAddress1;
	@FindBy(id = "physicalAddress_addressLine2") private WebElementFacade createProfilePhysicalAddress2;
	@FindBy(id = "physicalAddress_city") private WebElementFacade createProfilePhysicalCity;
	@FindBy(id = "physicalAddress_stateProvinceRegion") private WebElementFacade createProfilePhysicalState;
	@FindBy(id = "physicalAddress_zipPostal") private WebElementFacade createProfilePhysicalZip;

	
	@FindBy(id = "mailingSameAsPhysical") private WebElementFacade createProfileaddressIsSame;
	@FindBy(id = "mailingAddress_country") private WebElementFacade createProfileMailingCountry;
	@FindBy(id = "mailingAddress_addressLine1") private WebElementFacade createProfileMailingAddress1;
	@FindBy(id = "mailingAddress_addressLine2") private WebElementFacade createProfileMailingAddress2;
	@FindBy(id = "mailingAddress_city") private WebElementFacade createProfileMailingCity;
	@FindBy(id = "mailingAddress_stateProvinceRegion") private WebElementFacade createProfileMailingState;
	@FindBy(id = "mailingAddress_zipPostal") private WebElementFacade createProfileMailingZip;

	//Physical Postal Code not applicable
	@FindBy(id = "physicalAddress_noPostalCodeIndicated") private WebElementFacade physicalZipPostalNotApplicable;
	//Mailing Postal Code not applicable
	@FindBy(id = "mailingAddress_noPostalCodeIndicated") private WebElementFacade mailingZipPostalNotApplicable;


	@FindBy(id = "email") private WebElementFacade newAccountEmail;
	@FindBy(id = "password") private WebElementFacade newAccountPassword;
	@FindBy(id = "confirmPassword") private WebElementFacade newAccountConfirmPassword;
	@FindBy(id = "Create_Account") private WebElementFacade newAccountCreateAccount;

	@FindBy(xpath = "//div[@id='modelAircraftUser']") private WebElementFacade modelAircraftButton;
	@FindBy(xpath = "//div[@id='nonModelAircraftUser']") private WebElementFacade nonModelAircraftButton;
	@FindBy(xpath = "//div[@id='manageAccessTool']") private WebElementFacade manageAccessToolButton;	
	
	//Cancel Registration Button
	@FindBy(xpath = "//button[@id='hobCancelRegButton' and contains(text(), 'Cancel')]") private WebElementFacade hobCancelRegistration;
	//Resend Email Registration Button
	@FindBy(xpath = "//button[@id='hobResendEmailButton' and contains(text(), 'Email')]") private WebElementFacade hobResendEmailRegistration;
	//Print Registration Button
	@FindBy(xpath = "//button[@id='hobPrintCertButton' and contains(text(), 'Print')]") private WebElementFacade hobPrintRegistration;
	
	//Renew Registration Button
	@FindBy(xpath = "//button[@id='hobRenewRegButton' and contains(text(), 'Register')]") private WebElementFacade hobRenewRegistration;
	
	//Cancel Registration Reason
	@FindBy(xpath = "//input[@id='cancelReason']") private WebElementFacade hobCancelRegistrationReason;
	//Cancel Registration Reason Checkbox
	@FindBy(xpath = "//input[@id='confirmCancel']") private WebElementFacade hobCancelRegistrationReasonCheckbox;

	//Cancel Registration Reason Checkbox
	@FindBy(xpath = "//button[@id='confirmCancelButton' and contains(text(), 'Confirm Cancellation') ]") private WebElementFacade hobConfirmCancellationButton;
	//Registration Canceled title 
	@FindBy(xpath = "/html/body/modal[2]/div/div/div[1]/div/div[1]/h1") private WebElementFacade hobRegistrationCancelation;
	//Confirm Cancel Registration OK Button
	@FindBy(xpath = "//button[@id='canceledConfirmedButton' and contains(text(),'Ok')]") private WebElementFacade hobConfirmCancelationOkButton;

	//Alternate Email Address Error Message when user attempts to enter Alt Email the same as Login Email.  Both fields must be different
//	@FindBy(xpath = "//span[@class='error-text ng-scope' and contains(text(), 'Email has to be different than the primary email address.')]") private WebElementFacade altEmailErrorMessage;
	//span app-validation-messages div
//	@FindBy(css = "span app-validation-messages div") private WebElementFacade altEmailErrorMessage;
	@FindBy(xpath = "//div[contains(text(), 'Email has to be different than primary email address.')]") private WebElementFacade altEmailErrorMessage;
	
	@FindBy(xpath = "//*[@id='addressIsSame' and   @aria-checked='false']") private WebElementFacade addressIsSameFalse;
	@FindBy(xpath = "//*[@id='addressIsSame' and   @aria-checked='true']") private WebElementFacade addressIsSameTrue;

	//Profile Tab
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), 'Profile')]") private WebElementFacade profileTab;
	//Inventory Tab
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), 'Inventory')]") private WebElementFacade inventoryTab;
	
	//Edit Profile Button
	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Edit')]") private WebElementFacade editProfileButton;
	//Next Button on Complete Your Profile page
	@FindBy(xpath = "//button[@id='next' and contains(text(), 'Next')]") private WebElementFacade nextButton;
	//Hobbyist Proceed to Checkout Button
	@FindBy(xpath = "//button[@id='proceedToCheckout' and contains(text(), 'Proceed to Checkout')]") private WebElementFacade proceedToCheckoutButton;
	
	//Save Button on Complete Your Profile page
	@FindBy(xpath = "//button[@id='saveProfile' and contains(text(), 'Save')]") private WebElementFacade saveProfileButton;
	//Save Button on Edit your Profile page
	@FindBy(xpath = "//button[@id='saveEditButton' and contains(text(), 'Save')]") private WebElementFacade saveEditButton;
	
	
	//Non-Model [Non Hobbyist] Proceed to Dashboard Button
	@FindBy(xpath = "//button[@id='proceedToDashboard' and contains(text(), 'Proceed to Dashboard')]") private WebElementFacade proceedToDashboardButton;
	
	//Email Certificate Button
	@FindBy(xpath = "//button[@id='hobResendEmailButton' and contains(text(), 'Email Certificate')]") private WebElementFacade emailCertificate;
	
	/**<p>SaveButtonCssSelector Save Button Css Selector for Organization Profile
	 * 	body#body div div div div div div div div form div div div div button.btn.btn-primary  **/
	private static final String saveButtonCssSelector = "body#body div div div div div div div div form div div div div button.btn.btn-primary";
	
	//Add A Service Tab
	@FindBy(xpath = "//a[@id='addServiceInternal']") private WebElementFacade addServiceTab;
	//Model Aircraft Tab
	@FindBy(xpath = "//a[@id='modelAircraftDashboard' and starts-with(text(), 'Model Aircraft')]") private WebElementFacade modelAircraftTab;

	//Non-Model Aircraft Tab
	@FindBy(xpath = "//a[@id='organizationDashboard' and starts-with(text(), 'Non-Model Aircraft')]") private WebElementFacade nonModelAircraftTab;
	
	//Non-Model Aircraft Manage sUAS Inventory Button
	@FindBy(xpath = "//button[@id='manageInventoryButton' and starts-with(text(), 'MANAGE sUAS INVENTORY')]") private WebElementFacade manageSuasInventoryButton;
	//Non-Model Aircraft Manage User Accounts Button
	@FindBy(xpath = "//button[@id='manageUserAccounts' and starts-with(text(), 'MANAGE USER ACCOUNTS')]") private WebElementFacade manageUserAccountsButton;
	
	
	//Select a Service Drop Down list from the 'Select a Service' modal
	@FindBy(xpath = "//select[@id='select_service' and @title='Select a Service']") private WebElementFacade selectAServiceDropDownList;

	//Select a Service Drop Down list from the 'Select a Service' modal
	@FindBy(xpath = "//button[@id='confirm_select_service_button' and  starts-with(text(), 'Select')]") private WebElementFacade selectButton;
	
	
	
	String country1 = "United States";
//	Serenity.setSessionVariable(country1).toString();
//	Serenity.sessionVariableCalled("country1").toString();

	
	String[] cityStateZip  = DataGenerator.randomCityStateZip();
	String city1 = cityStateZip[0];
	String state1 = cityStateZip[1];
	String zip1  = cityStateZip[2];
	String country = "United States";

	
//	nonModelAircraftTab
//	modelAircraftTab
//	addServiceTab

	public void selectNonModelFromServiceDropdown() {
		Select dropDownList = new Select(selectAServiceDropDownList);
		dropDownList.selectByVisibleText("Non-Model Aircraft");
		}
		
	
	public void clickOnSelectButton() {
		waitABit(1000);
		selectButton.click();
	}

	public void clickOnAddServiceTab() {
		waitABit(1000);
		addServiceTab.click();
	}
	
	public void clickOnModelAircraftButton() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(1000);
			System.out.println("Loop Count to verify Model Aircraft Tab is clicked... " + i);
			if (modelAircraftButton.isCurrentlyVisible()){
				System.out.println("Model Aircraft Tab is Visible. Will now click it.");
				i = 4;
				modelAircraftButton.click();//attempt to click the element
			System.out.println("Model Aircraft Tab has been clicked. ");
			}
			else 
			{
			System.out.println("Model Aircraft Tab is NOT Visible... Trying again in 3 seconds");
			waitABit(1000);//wait 3 seconds before trying to click again
			}
		}	
		
	}
	
	public void clickOnNonModelAircraftButton() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(1000);
			System.out.println("Loop Count to verify Non Model Aircraft Tab is clicked... " + i);
			if (nonModelAircraftTab.isCurrentlyVisible()){
				System.out.println("Non Model Aircraft Tab is Visible. Will now click it.");
				i = 4;
				nonModelAircraftTab.click();//attempt to click the element
			System.out.println("Non Model Aircraft Tab has been clicked. ");
			}
			else 
			{
			System.out.println("Non Model Aircraft Tab is NOT Visible... Trying again in 3 seconds");
			waitABit(1000);//wait 3 seconds before trying to click again
			}
		} 
//		if (nonModelAircraftTab.isCurrentlyVisible()){
//		System.out.println("Non Model Aircraft Tab is STILL NOT Visible...Not expecting it to be displayed.  Add Service");
//			clickOnAddServiceTab();	
//			selectNonModelFromServiceDropdown();
//			clickOnSelectButton();
//		}
	}		
		
//		
//		
//		System.out.println("Click on the Non Model Aircraft Account [Non Hobbyist Type button ");
//		if (nonModelAircraftTab.isCurrentlyVisible()){
//			nonModelAircraftTab.click();
//		} else  {
//			    clickOnAddServiceTab();	
//			    selectNonModelFromServiceDropdown();
//			   	clickOnSelectButton();
//			}
//		}
	
	public void clickOnManageSuasInventoryButton(){
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(1000);
			System.out.println("Loop Count to verify MANAGE sUAS INVENTORY button... " + i);
			if (manageSuasInventoryButton.isCurrentlyVisible()){
				System.out.println("MANAGE sUAS INVENTORY button is Visible. Will now click it.");
				i = 4;
				manageSuasInventoryButton.click();//attempt to click the element
			System.out.println("MANAGE sUAS INVENTORY button has been clicked. ");
			}
			else 
			{
			System.out.println("MANAGE sUAS INVENTORY is NOT Visible... Trying again in 3 seconds");
			waitABit(1000);//wait 3 seconds before trying to click again
			}
		}	
	}

	public void clickOnManageUserAccountsButton(){
		System.out.println("Click on the Non Model MANAGE USER ACCOUNTS button ");
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(1000);
			System.out.println("Loop Count to verify manageUserAccountsButton [MANAGE USER ACCOUNTS] button... " + i);
			if (manageUserAccountsButton.isCurrentlyVisible()){
				System.out.println("manageUserAccountsButton [MANAGE USER ACCOUNTS] is Visible. Will now click it.");
				i = 4;
				manageUserAccountsButton.click();//attempt to click the element
			System.out.println("manageUserAccountsButton [MANAGE USER ACCOUNTS] button has been clicked. ");
			}
			else 
			{
			System.out.println("manageUserAccountsButton [MANAGE USER ACCOUNTS] is NOT Visible... Trying again in 3 seconds");
			waitABit(3000);//wait 3 seconds before trying to click again
			}
		}	
	}
		
		
//		if (manageUserAccountsButton.isCurrentlyVisible()){
//			System.out.println("manageUserAccountsButton [MANAGE USER ACCOUNTS] is Visible. Will now click it.");
//			manageUserAccountsButton.click();
//		} else {
//			System.out.println("MANAGE USER ACCOUNTS is NOT Visible.");
//	}
//}		
//	
	
	
	public void clickOnManageAccessToolButton() {
		waitABit(2000);
		System.out.println("Click on the Manage Access Tool button ");
		manageAccessToolButton.click();
	}

	//Profile Tab Organization Profile
	public void clickOnProfileTab() {
		waitABit(1000);
		profileTab.click();
	}
	
	//Email Certificate Button
	public void clickOnEmailCertificateButton() {
		waitABit(1000);
		emailCertificate.click();
	}
	
	//Renew Registration Button
	public void clickOnRenewRegistrationButton() {
		waitABit(1000);
		hobRenewRegistration.click();
		System.out.println("Renew Registration Button was just clicked" );			
	}


	
	//Click on Hobbyist Renew Registration Button
	public void clickOnHobbyistRenewRegistrationButton() {
		waitABit(1000);
		hobRenewRegistration.waitUntilVisible();
		if (hobRenewRegistration.isCurrentlyVisible()){
			System.out.println("Renew Registration Button is Present " );			
			clickOnRenewRegistrationButton();
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
			Serenity.takeScreenshot(); 
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			Serenity.takeScreenshot(); 
			System.out.println("Payment process has completed successfully!!");
			billingInformationPage.clickOnDoneButton();
			//assertThat(hobRegistrationCancelation.isCurrentlyVisible()).isTrue();
			Serenity.takeScreenshot(); 
		} else {
			System.out.println("Renew Registration Button is NOT Present..no further action can be taken at this time." );		
		}
	}	

	
	//Click on Hobbyist Cancel Registration Button
	public void clickOnHobbyistCancelRegistrationButton() {
		waitABit(1000);
		if (hobCancelRegistration.isCurrentlyVisible()){
			System.out.println("Cancel Registration Button is Present " );			
			hobCancelRegistration.click();
			typeIntoOnHobbyistCancelRegistrationReason();
			clickOnHobbyistCancelRegistrationReasonCheckbox();
			clickOnHobbyistConfirmCancelRegistrationButton();
			//assertThat(hobRegistrationCancelation.isCurrentlyVisible()).isTrue();
			waitABit(2000);
			hobConfirmCancelationOkButton.waitUntilVisible();
			clickOnHobbyistConfirmCancelRegistrationOkButton();
			Serenity.takeScreenshot(); 
			waitABit(2000);
		} else {
			System.out.println("Cancel Registration Button is NOT Present..no further action can be taken at this time." );		
		}
	}	

	//Complete Payment for New Non Hobbyist Account
	public void clickOnAcknowledgeSafetyGuidance() {
		waitABit(1000);
//		hobRenewRegistration.waitUntilVisible();
//		if (hobRenewRegistration.isCurrentlyVisible()){
//			System.out.println("Renew Registration Button is Present " );			
//			clickOnRenewRegistrationButton();
			addNewUasPage.checkTheAcknowledgeBox();
			addNewUasPage.clickOnAcknowledgeNextButton();
	}
	
	
	//hobCancelRegistrationReason
	public void typeIntoOnHobbyistCancelRegistrationReason() {
			System.out.println("Cancel Registration Reason" );			
			hobCancelRegistrationReason.type("Not a good Gateway reason, but a good one is not needed");
			Serenity.takeScreenshot(); 
	}	

	//hobCancelRegistrationReasonCheckbox
	public void clickOnHobbyistCancelRegistrationReasonCheckbox() {
		hobCancelRegistrationReasonCheckbox.click();
		Serenity.takeScreenshot(); 
	}	

	//hobConfirmCancelationButton
	public void clickOnHobbyistConfirmCancelRegistrationButton() {
			hobConfirmCancellationButton.click();
	}	
	
	
	//hobConfirmCancelationOkButton
	public void clickOnHobbyistConfirmCancelRegistrationOkButton() {
		hobConfirmCancelationOkButton.click();
}	


	//Profile Tab Organization Profile
	public void clickOnInventoryTab() {
		waitABit(1000);
		inventoryTab.click();
	}
	//Edit Profile Button
	public void clickOnEditProfileButton(){
		editProfileButton.click();
	}
	//nextButton
	public void clickOnNextButton(){
		nextButton.click();
	}
	//saveButton
	public void clickOnSaveProfileButton(){
		saveProfileButton.click();
	}
	
	//saveEditButton
	public void clickOnSaveEditButton(){
		saveEditButton.click();
	}
	
	public void clickOnNextOrSaveButton() {
		waitABit(1000);
		if (saveEditButton.isCurrentlyVisible()){
			System.out.println("Save Edit Profile Button is Present " );
			clickOnSaveEditButton();
			System.out.println("Save Edit Profile Button is Present and has been clicked");
		}  else	if (nextButton.isCurrentlyEnabled())  {
			System.out.println("Next Button is Present " );
			clickOnNextButton();
			System.out.println("Next Button is Present and has been clicked");
		}  else if (saveProfileButton.isCurrentlyVisible()){
			System.out.println("Save Button is Present " );
			clickOnSaveProfileButton();
			System.out.println("Save Button is Present and has been clicked");
		}   else 
			System.out.println("Buttons are NOT Present!!!!");
	} 	
	
	public void clickOnProceedToDashboardButton() {
		if (proceedToDashboardButton.isCurrentlyVisible()){
			System.out.println("Proceed to Dashboard Button is visible and will be clicked" );
			proceedToDashboardButton.click();
			System.out.println("Proceed to Dashboard Button has been clicked" );
			} else {
				System.out.println("Proceed to Dashboard Button is NOT visible.");
			}
	}		
		
	
	
	//proceedToCheckoutButton
	public void clickOnProceedToCheckoutButton(){
		if (proceedToCheckoutButton.isCurrentlyVisible()){
		proceedToCheckoutButton.click();
		}
	}
	

	//proceedToCheckoutOrSaveButton
	public void clickOnProceedToCheckoutOrSaveButton(){
		if (proceedToCheckoutButton.isCurrentlyVisible()){
			System.out.println("Proceed to Checkout Button is Present " );
			proceedToCheckoutButton.click();
			System.out.println("Proceed to Checkout Button is Present and has been clicked" );
		}	else if (saveProfileButton.isCurrentlyVisible()){
			System.out.println("Save Button is Present " );
			clickOnSaveProfileButton();
			System.out.println("Save Button is Present and has been clicked");			
		}
	}
	
	public String getTypeIntoCreateProfileFirstName() {
		return createProfileFirstName.getAttribute("value");

	}
	public void typeIntoCreateProfileFirstName() {
//		if (proceedToCheckoutButton.isVisible()){
//			createProfileFirstName.clear();
		createProfileFirstName.type(DataGenerator.randomFirstName());	
		System.out.println("Beginning of Profile ");
		System.out.println("City1 is " + cityStateZip[0]);
		System.out.println("State1 is " + cityStateZip[1]);
		System.out.println("Zip1 is " + cityStateZip[2]);
		System.out.println("First Name is " + getTypeIntoCreateProfileFirstName());
		Serenity.setSessionVariable(cityStateZip[0]).to(city1);
		Serenity.setSessionVariable(cityStateZip[1]).to(state1);
		Serenity.setSessionVariable(cityStateZip[2]).to(zip1);
        String newCity = Serenity.sessionVariableCalled(cityStateZip[0]).toString();
        System.out.println("New City is " + newCity);
        String newState = Serenity.sessionVariableCalled(cityStateZip[1]).toString();
        System.out.println("New State is " + newState);
        String newZip = Serenity.sessionVariableCalled(cityStateZip[2]).toString();
        System.out.println("New Zip is " + newZip);
	}


	public void typeIntoCreateProfileMiddleInitial() {
		createProfileMiddleInitial.clear();
		createProfileMiddleInitial.type(DataGenerator.randomAlphabetic(1).toUpperCase());
		System.out.println("Middle Initial is " + getTypeIntoCreateProfileMiddleInitial());
	}
	public String getTypeIntoCreateProfileMiddleInitial() {
		return createProfileMiddleInitial.getAttribute("value");
	}
	public void typeIntoCreateProfileLastName() {
		createProfileLastName.clear();
		createProfileLastName.type(DataGenerator.randomLastName());
		System.out.println(getTypeIntoCreateProfileFirstName());
		System.out.println("Last Name is " + getTypeIntoCreateProfileLastName());
		Serenity.takeScreenshot(); 
	}
	public String getTypeIntoCreateProfileLastName() {
		return createProfileLastName.getAttribute("value");
	}
	public void typeIntoCreateProfileNameSuffix() {
		createProfileNameSuffix.click();
		createProfileNameSuffix.type(DataGenerator.randomSuffixName());
		System.out.println("Suffix Name is " + getCreateProfileNameSuffix());

	}
	public String getCreateProfileNameSuffix() {
		return createProfileNameSuffix.getAttribute("value");
	}
	public void typeIntoCreateProfileTitle() {
		createProfileUserTitle.clear();
		String newTitle = DataGenerator.randomTitle();
		if (newTitle.equals(null)){
			newTitle = "Title for update Generator gave us a NULL-->";
		}
		createProfileUserTitle.type(newTitle);
		System.out.println("Title is " + getCreateProfileNameTitle());
	}
	public String getCreateProfileNameTitle() {
		return createProfileUserTitle.getAttribute("value");
	}

	public void typeIntoCreateProfileAlternateEmail() {
//		String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
		String newFaaAcountEmail = "mynewfaadrone@gmail.com";
		System.out.println("Edit Profile On Verify Account part of test  1111!!!!!!");
		System.out.println("Edit Profile On Verify Account part of test  " + newFaaAcountEmail);
		String upperUpdateAltEmail = newFaaAcountEmail.toUpperCase();
		String camelUpdateAltEmail = Verify.toCamelCase(newFaaAcountEmail);
		System.out.println("Upper Case Alternate Email Address " + upperUpdateAltEmail );
		System.out.println("Camel Case Alternate Email Address " + camelUpdateAltEmail );
		createProfileAlternateEmail.clear();
		createProfileAlternateEmail.type(newFaaAcountEmail);
		Serenity.takeScreenshot(); 
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(upperUpdateAltEmail);
			System.out.println("Upper Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(camelUpdateAltEmail);
			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type("myfaadrone+300@gmail.com");
			System.out.println("Email Address has been updated with a valid email that is different than the primary Email address" );
			System.out.println("Alternate Email Address is myfaadrone+300@gmail.com ");
			Serenity.takeScreenshot(); 
		}
		Serenity.takeScreenshot(); 
	}
	
	public String getCreateProfileAlternateEmail() {
		return createProfileAlternateEmail.getAttribute("value");
	}

	public void typeIntoUpdateProfileAlternateEmail(String updateAltEmail) {
		String upperUpdateAltEmail = updateAltEmail.toUpperCase();
		String camelUpdateAltEmail = Verify.toCamelCase(updateAltEmail);
		System.out.println("Upper Case Alternate Email Address " + upperUpdateAltEmail );
		System.out.println("Camel Case Alternate Email Address " + camelUpdateAltEmail );
		createProfileAlternateEmail.clear();
		createProfileAlternateEmail.type(updateAltEmail);
		Serenity.takeScreenshot(); 
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(upperUpdateAltEmail);
			System.out.println("Upper Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(camelUpdateAltEmail);
			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type("mynewfaadrone+AlternateEmail_1@gmail.com");
			System.out.println("Email Address has been updated with a valid email that is different than the primary Email address" );
			System.out.println("Alternate Email Address is mynewfaadrone+AlternateEmail_1@gmail.com ");

			Serenity.takeScreenshot(); 
		}
		Serenity.takeScreenshot(); 
//		LogToFile.write(getTitle());
//		LogToFile.write("GP-3");
//		LogToFile.write("New Hobbyist User First Time Profile Entry");
//		LogToFile.write("As a new hobbyist user of the gateway, I need to enter profile information so that I can proceed through the registration process.");
//		LogToFile.write("GP-22");
//		LogToFile.write("New Non-Hobbyist User Completes Org Profile");
//		LogToFile.write("As a new non-hobbyist user of the gateway, I need to enter profile and org information so that I can proceed through the registration process.");
}

	public String getUpdateProfileAlternateEmail() {
		return createProfileAlternateEmail.getAttribute("value");
	}
	
////////////
//	typeIntoProfileAltEmailMatchUserEmail
	public void typeIntoProfileAltEmailMatchUserEmail(String updateAltEmail) {
		String upperUpdateAltEmail = updateAltEmail.toUpperCase();
		String camelUpdateAltEmail = Verify.toCamelCase(updateAltEmail);
		System.out.println("Upper Case Alternate Email Address " + upperUpdateAltEmail );
		System.out.println("Camel Case Alternate Email Address " + camelUpdateAltEmail );
		createProfileAlternateEmail.clear();
		createProfileAlternateEmail.type(updateAltEmail);
		Serenity.takeScreenshot(); 
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			waitABit(1000);
			createProfileAlternateEmail.type(upperUpdateAltEmail);
			System.out.println("Upper Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			waitABit(1000);
			createProfileAlternateEmail.type(camelUpdateAltEmail);
			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			waitABit(1000);
			createProfileAlternateEmail.type("myfaadrone+2000@gmail.com");
			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			Serenity.takeScreenshot(); 
		}
		Serenity.takeScreenshot(); 
		System.out.println("Alternate Email Address has been updated.  It must be different than the primary Email address" );
		
	}
	
	
//////////////	
	public void typeIntoCreateProfilePhone() {
		//createProfilePhone.clear();
		String profilePhone = DataGenerator.randomNumber(10);
		createProfilePhone.type(profilePhone);
		System.out.println("Profile Phone Number is: " + profilePhone);
		System.out.println("5 Second Wait...");
		//Serenity.takeScreenshot();
		////waitABit(5000);;

	}
//	public String getCreateProfilePhone() {
//		return createProfilePhone.getAttribute("value");
//	}
	public void typeIntoCreateProfilePhoneExt() {
		//createProfilePhoneExt.clear();
		String profilePhoneExt = DataGenerator.randomNumber(6);
		createProfilePhoneExt.type(profilePhoneExt);
		System.out.println("Profile Phone Extension is: " + profilePhoneExt);
		System.out.println("5 Second Wait...");
		////waitABit(5000);;;


	}
	public void clickMaSameAsPa() {
		createProfileaddressIsSame.click();
		waitABit(3000);
		System.out.println("3 Second Delay --- click on the Address is the same checkbox...");
	
	}
	
	public void clickProfileAddressIsSame() {
		if (createProfileaddressIsSame.isCurrentlyVisible()){
		if(createProfileaddressIsSame.isSelected()){
			createProfileaddressIsSame.click();
			System.out.println("click on the Address is the same checkbox...to Uncheck it so we can edit the Organization Address");
			System.out.println("Uncheck the Same As checkbox!!" );
		} 
		if (!createProfileaddressIsSame.isSelected()){ 
			//createProfileaddressIsSame.click();
			System.out.println("Do NOT click on the Address is the same checkbox...to Uncheck it so we can edit the Organization Address");
			System.out.println("The CheckBox is already Unchecked..No action to take !!" );
		} 
	}
		System.out.println("Same As checkbox is not visible...Do Nothing..." );
		
	}
	
	public void typeIntoCreateProfileOrganizationName() {
		String organization = DataGenerator.randomCompanyName();
		System.out.println("Randomly Generated Organization is..." + organization + "***" );
		if (createProfileOrganizationName.isCurrentlyVisible()){
		createProfileOrganizationName.type(organization);
		System.out.println("Profile Organization Name is: " + organization);
		//Serenity.takeScreenshot();
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	public String getCreateProfileOrganizationName() {
		return createProfileOrganizationName.getAttribute("value");
	}
	public void typeIntoCreateProfileDba() {
		String profileDba = DataGenerator.randomCompanyName();
		System.out.println("Randomly Generated DBA is..." + profileDba + "***" );
		if (createProfileDBA.isCurrentlyVisible()){
		createProfileDBA.type(profileDba);
		System.out.println("Profile DBA Name is: " + profileDba);
		//Serenity.takeScreenshot();
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileDba() {
		return createProfileDBA.getAttribute("value");
	}
	//Drop Down List Physical Country
	public void selectProfilePhysicalCountryDropDown(String country1) {
		waitABit(1000);
		if (createProfilePhysicalCountry.isCurrentlyVisible()){
		Select dropDownList = new Select(createProfilePhysicalCountry);
		dropDownList.selectByVisibleText(country1.trim());
		createProfilePhysicalCountry.selectByVisibleText(country1);
		System.out.println("Selected Physical Country from drop down list is..." + country1 + "***" );
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}

	}	
	
	public String getCreateProfilePhysicalCountry() {
		return createProfilePhysicalCountry.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalAddress1(String newAddress1) {
		waitABit(1000);
		if (createProfilePhysicalAddress1.isCurrentlyVisible()){
		createProfilePhysicalAddress1.type(newAddress1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}

	}	
	public String getCreateProfilePhysicalAddress1() {
		return createProfilePhysicalAddress1.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalAddress2(String newAddress2) {
		if (createProfilePhysicalAddress2.isCurrentlyVisible()){
		createProfilePhysicalAddress2.type(newAddress2);
		System.out.println("5 Second Wait...");
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	

	public String getCreateProfilePhysicalAddress2() {
		return createProfilePhysicalAddress2.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalCity(String newCity) {
		if (createProfilePhysicalCity.isCurrentlyVisible()){
			createProfilePhysicalCity.type(newCity);
			//Serenity.takeScreenshot();
		} else {
		System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	
	public String getCreateProfilePhysicalCity() {
		return createProfilePhysicalCity.getAttribute("value");
	}           
	public void selectFromPhysicalStateNameDropdownList(String newState) {
		if (createProfilePhysicalState.isCurrentlyVisible()){
		Select dropDownList = new Select(createProfilePhysicalState);
		dropDownList.selectByVisibleText(newState.trim());
		System.out.println("Selected Physical New State Name inputText is " + newState);
		} else {
		System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
//		System.out.println("Select Physical State Name is " + createProfilePhysicalState);
//**This section of code prints the list of States on the sceen.  ***
//		List<WebElement> options = dropDownList.getOptions();
//		for (WebElement option : options) {
//		    System.out.println(option.getText()); //Prints "Option", followed by "Not Option"
//		}
	
	            
	public void typeIntoCreateProfilePhysicalStateNameField(String newState) {
		if (createProfilePhysicalState.isCurrentlyVisible()){
			if (newState.equals(null)){
				System.out.println("New Physical State Name is  NULL");
			} else {
			createProfilePhysicalState.type(newState);
		System.out.println("Selected New Physical State Name inputText is " + newState);
		System.out.println("5 Second Wait...");
			}
		}	else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}

	public void typeIntoCreateProfilePhysicalZip(String newZip) {
	if (createProfilePhysicalZip.isCurrentlyVisible()){	
		System.out.println("New Physical Zip is " + newZip);
		createProfilePhysicalZip.type(newZip);
		System.out.println("Newly updated Physical Zip is-->" + newZip);
		//Serenity.takeScreenshot();
	} else {
		System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
	}
	}
	
	
//	public void typeIntoCreateProfilePhysicalZip(String newZip) {
////		////waitABit(5000);;
////		System.out.println("New Zip is " + newZip);
////		createProfilePhysicalZip.clear();
////		createProfilePhysicalZip.type(newZip.trim());
////		System.out.println("Newly updated Physical Zip is--> " + newZip);
//	 
//	if (newZip.equals("N/A")) {
//			System.out.println("Zip is N/A so make sure the checkbox is checked...On Verify new Physical Zip is N/A --->  " + newZip);
//			clickOnPhysicalZipPostalNotApplicableCheckbox();
//			//physicalZipPostalNotApplicable.click();
//			//clickOnMailingZipPostalNotApplicableCheckbox
//			System.out.println("New Zip Physical Variable is " + newZip);
//			} else {
//				if (physicalZipPostalNotApplicable.isPresent()){
//				physicalZipPostalNotApplicable.click(); // Uncheck the N/A zip 
//				//clickOnPhysicalZipPostalNotApplicableCheckbox();
//				createProfilePhysicalZip.clear();
//				createProfilePhysicalZip.type(newZip.trim());
//				System.out.println("New Zip Physical variable is NOT NULL " + newZip);
//			} else {
//				createProfilePhysicalZip.clear();
//				createProfilePhysicalZip.type(newZip.trim());
//				System.out.println("Newly updated Physical Zip is--> " + newZip);
//			}
//		}		
//	}	


	
	
//		public void typeIntoCreateProfilePhysicalZip(String newZip) {
//		////waitABit(5000);;
//		System.out.println("New Zip is " + newZip);
//		if (newZip.equals("N/A")) {
//			System.out.println("Zip is N/A so make sure the checkbox is checked...On Verify new Physical Zip is N/A --->  " + newZip);
//			clickOnPhysicalZipPostalNotApplicableCheckbox();
//			//physicalZipPostalNotApplicable.click();
//			//clickOnMailingZipPostalNotApplicableCheckbox
//			System.out.println("New Zip Physical Variable is " + newZip);
//			} else {
//				if (physicalZipPostalNotApplicable.isPresent()){
//				physicalZipPostalNotApplicable.click(); // Uncheck the N/A zip 
//				//clickOnPhysicalZipPostalNotApplicableCheckbox();
//				createProfilePhysicalZip.clear();
//				createProfilePhysicalZip.type(newZip.trim());
//				System.out.println("New Zip Physical variable is NOT NULL " + newZip);
//			} else {
//				createProfilePhysicalZip.clear();
//				createProfilePhysicalZip.type(newZip.trim());
//				System.out.println("Newly updated Physical Zip is--> " + newZip);
//			}
//		}		
//	}	
	//physicalZipPostalNotApplicable
	public void checkThatPhysicalZipPostalNotApplicableCheckboxIsChecked() {
		if (physicalZipPostalNotApplicable.isSelected()) {
			physicalZipPostalNotApplicable.click();
			System.out.println("Zip is N/A and Physical Zip Code Not Applicable checkbox is already checked.  Do not select it again...");
	} else {
		physicalZipPostalNotApplicable.click();
		System.out.println("Check the Physical Zip Code Not Applicable checkbox ");
		
//	} else {
//		System.out.println("POSTAL CODE NOT APPLICABLE options is not displayed...Do nothing");
	}
}
	
	//physicalZipPostalNotApplicable
	public void unCheckPhysicalZipPostalNotApplicableCheckbox() {
		if (physicalZipPostalNotApplicable.isSelected()) {
			physicalZipPostalNotApplicable.click();
		System.out.println("Zip is N/A and Physical Zip Code Not Applicable checkbox is already checked.  Do not select it again...");
		} else {
//		physicalZipPostalNotApplicable.click();
		System.out.println("Check the Physical Zip Code Not Applicable checkbox ");
	}
}		
	
	//physicalZipPostalNotApplicable
	public void checkPhysicalZipPostalNotApplicableCheckbox() {
		if (physicalZipPostalNotApplicable.isSelected()) {
			//physicalZipPostalNotApplicable.click();
		System.out.println("Zip is N/A and Physical Zip Code Not Applicable checkbox is already checked.  Do not select it again...");
		} else {
		//physicalZipPostalNotApplicable.click();
		System.out.println("Check the Physical Zip Code Not Applicable checkbox ");
	}
}		

	
	
	//mailingZipPostalNotApplicable
	public void checkThatMailingZipPostalNotApplicableCheckboxIsChecked() {
//		if (mailingZipPostalNotApplicable.isPresent()){
		if (mailingZipPostalNotApplicable.isSelected()){
			//mailingZipPostalNotApplicable.click();
			System.out.println("Mailing Zip Code Not Applicable checkbox is already checked.  Do not select it again...");
	} else {
		mailingZipPostalNotApplicable.click();
		System.out.println("Check the Mailing Zip Code Not Applicable checkbox ");
	}
//	} else {
//		System.out.println("POSTAL CODE NOT APPLICABLE options is not displayed...Do nothing");
//	}
}

	//mailingZipPostalNotApplicable
	public void unCheckMailingZipPostalNotApplicableCheckbox() {
		if (mailingZipPostalNotApplicable.isCurrentlyVisible()){
			if(mailingZipPostalNotApplicable.isSelected()){
			mailingZipPostalNotApplicable.click();
			System.out.println("Mailing Zip Code Not Applicable checkbox is already checked, so we are unselecting it.  Do not select it again...");
	} else {
//		mailingZipPostalNotApplicable.click();
		System.out.println("Check the Mailing Zip Code Not Applicable checkbox.  Already unselected.  ");
	}
//	} else {
//		System.out.println("POSTAL CODE NOT APPLICABLE options is not displayed...Do nothing");
//	}
		}
	}		
	//mailingZipPostalNotApplicable
	public void checkMailingZipPostalNotApplicableCheckbox() {
		if (mailingZipPostalNotApplicable.isSelected()){
			//mailingZipPostalNotApplicable.click();
			System.out.println("Mailing Zip Code Not Applicable checkbox is already checked.  Do not select it again...");
	} else {
		mailingZipPostalNotApplicable.click();
		System.out.println("Check the Mailing Zip Code Not Applicable checkbox ");
	}
}

	
		
		
	//Drop Down List Mailing Country 
	public void selectProfileMailingCountryDropDown(String newMailingCountry) {
		waitABit(1000);
		if (createProfileMailingCountry.isCurrentlyVisible()){	
		Select dropDownList = new Select(createProfileMailingCountry);
		dropDownList.selectByVisibleText(newMailingCountry.trim());
		//Serenity.takeScreenshot();
		createProfileMailingCountry.selectByVisibleText(newMailingCountry);
		System.out.println("Selected Mailing Country from drop down list is..." + newMailingCountry + "***" );
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
//		System.out.println("Check the Mailing Postal Code Not Applicatable option.");
//		if (newMailingCountry.equals("United States")||newMailingCountry.equals("Virgin Islands, U.S." ) || newMailingCountry.equals("Guam")|| newMailingCountry.equals("Puerto Rico")){
//			System.out.println("Mailing Country is -->" + newMailingCountry);
//		} else {
//		if (mailingZipPostalNotApplicable.isSelected()) {
//			mailingZipPostalNotApplicable.click();
//			System.out.println("Mailing Zip Code Not Applicable checkbox is already checked.  Select it again to uncheck it...");
//	} else {
//		mailingZipPostalNotApplicable.click();
//		System.out.println("Check the Mailing Zip Code Not Applicable checkbox ");
//
//		}
//	}

	public String getCreateProfileMailingCountry() {
		return createProfileMailingCountry.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingAddress1(String newMailingAddress1) {
		if (createProfileMailingAddress1.isCurrentlyVisible()){	
		createProfileMailingAddress1.clear();
		System.out.println("Newly Updated Address 1 is-->" + newMailingAddress1);
		createProfileMailingAddress1.type(newMailingAddress1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingAddress1() {
		return createProfileMailingAddress1.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingAddress2(String newMailingAddress2) {
		if (createProfileMailingAddress2.isCurrentlyVisible()){	
		createProfileMailingAddress2.clear();
		createProfileMailingAddress2.type(newMailingAddress2);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingAddress2() {
		return createProfileMailingAddress2.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingCity(String newMailingCity1) {
		if (createProfileMailingCity.isCurrentlyVisible()){	
		createProfileMailingCity.clear();
		createProfileMailingCity.type(newMailingCity1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingCity() {
		return createProfileMailingCity.getAttribute("value");
	}
	
	public void selectFromMailingStateNameDropdownList(String inputText) {
		if (createProfileMailingState.isCurrentlyVisible()){	
			Select dropDownList = new Select(createProfileMailingState);
			dropDownList.selectByVisibleText(inputText.trim());
			//Serenity.takeScreenshot();
			System.out.println("Selected from Drop Down List, New Mailing State Name inputText is " + inputText);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	

	public void typeIntoMailingStateNameField(String newState) {
		if (createProfileMailingState.isCurrentlyVisible()){	
			createProfileMailingState.clear();
			createProfileMailingState.type(newState.trim());
			System.out.println("Typed into Text Box, New Mailing State Name inputText is " + newState);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
//		System.out.println("Select State Name is " + createProfilePhysicalState);
//		List<WebElement> options = dropDownList.getOptions();
//		for (WebElement option : options) {
//		    System.out.println(option.getText()); //Prints "Option", followed by "Not Option"
//		}

	
	
//	public void typeIntoCreateProfilePhysicalZip(String newZip) {
//	System.out.println("New Zip is " + newZip);
//	createProfilePhysicalZip.clear();
//	createProfilePhysicalZip.type(newZip.trim());
//	System.out.println("Newly updated Physical Zip is--> " + newZip);
//	}


	public void typeIntoCreateProfileMailingZip(String newMailingZip1) {
		if (createProfileMailingZip.isCurrentlyVisible()){	
			System.out.println("New Mailing Zip is -->" + newMailingZip1);
			//createProfileMailingZip.clear();
			createProfileMailingZip.type(newMailingZip1);
			System.out.println("Newly updated Mailing Zip is-->" + newMailingZip1);
			//Serenity.takeScreenshot();
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	
	
	
//	public void typeIntoCreateProfileMailingZip(String newMailingZip1) {
//		////waitABit(5000);;
//		System.out.println("Beginning:  New Mailing Zip is-->" + newMailingZip1);
////		if (newMailingZip1.equals("N/A")) {
////			System.out.println("On Verify new Mailing Zip is --->" + newMailingZip1);
//			//clickOnPhysicalZipPostalNotApplicableCheckbox();
////			checkThatMailingZipPostalNotApplicableCheckboxIsChecked();
////			} else {
//				if (mailingZipPostalNotApplicable.isPresent()){
//				mailingZipPostalNotApplicable.click(); // Uncheck the N/A zip 
//				createProfileMailingZip.clear();
//				createProfileMailingZip.type(newMailingZip1.trim());
//				System.out.println("New Mailing Zip variable is " + newMailingZip1);
////				System.out.println("Get New Mailing Zip Vale is " + getCreateProfileMailingZip());
//			} else {
//				createProfileMailingZip.clear();
//				createProfileMailingZip.type(newMailingZip1.trim());
//				System.out.println("Newly updated Mailing Zip is--> " + newMailingZip1);
//			}
//		}
////	}
	
	

//	public String getCreateProfileMailingZip() {
//		return createProfileMailingZip.getAttribute("value");
//	}
	
	
	
	
	
///////////////////////////////	
	
//	/**<p>NonModelAircraftButtonCssSelector Button Css Selector 
//	 * Button displays the Complete Your Profile page for new users*/
//	//static final String IAgreeButtonCssSelector = "div#systemUseModal div div div button";
//	static final String NonModelAircraftButtonCssSelector = "body#body div div div div div div div div.icon-heads";

	
	
	//New Account Page
	/**<p>New Account Button Css Selector {@value}*/
	static final String newAccountButtonCssSelector = "li a[href='register']";

//	//click on Non-Model Aircraft Complete Your Profile Button
//	public void clickOnModelAircraftButton() {
//		waitABit(2000);
//		System.out.println("Click on the Model Aircraft Account Type button ");
//		//waitForElement(NonModelAircraftButtonCssSelector);
//		hobbyistAccountType.click();
//	}		

	
	
		
		
		//click on Save Button to Complete Your Profile
		public void clickOnSaveButtonCssSelectorButton() {
			waitABit(2000);
			System.out.println("Click on the saveButtonCssSelector button ");
			//waitForElement(NonModelAircraftButtonCssSelector);
			click(saveButtonCssSelector);
		}		
		
		
		//button[@class='btn btn-primary' and contains(text(), 'Next')]
		
		
		public String getNewEmailAccountAddressFieldValue() {
			return newAccountEmail.getValue();
		}
		public void typeIntoNewAccountEmailAddressField() {
			newAccountEmail.type("myfaadrone+" + DataGenerator.randomIntegerBetween(10,200) + "@gmail.com");
			waitABit(1000);
		}
		
		public void typeIntoPasswordField(String inputText) {
			newAccountPassword.type("Dummy$11");
		}
		public void typeIntoConfirmPasswordField(String inputText) {
			newAccountConfirmPassword.type("Dummy$11");
		}
		//Create Account Button
		public void clickOnCreateAccountButton() {
			click(newAccountCreateAccount);
		}
		//Verify the create account success
	
		
		
		//Verify the create account success
		/** {@value} */
		private static final String successMessageCssSelector = "html body div div.email-password-area.col-md-12.col-sm-12.col-xs-12.large h1";

		
		public void verifyAlmostDoneMessageIsDisplayed() {
			findWebElementByCssSelector(successMessageCssSelector).shouldContainText("Almost done!");
		}

//		public void selectProfilePhysicalIntCountryDropDown(String newIntCountry1) {
//			// TODO Auto-generated method stub
//			
//		}


	
}
