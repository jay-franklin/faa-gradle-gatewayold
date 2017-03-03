package faa.cucumber.maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import faa.cucumber.pages.AddressValidationPage;
import faa.cucumber.pages.FaaHomePage;
import faa.cucumber.stepLibraries.AddNewUasSteps;
//import faa.cucumber.pages.LoginPage;
import faa.cucumber.stepLibraries.BaseUserSteps;
import faa.cucumber.stepLibraries.CompleteNewProfileSteps;
import faa.cucumber.stepLibraries.ManageUserSteps;
//import faa.cucumber.stepLibraries.MenuUser;
import faa.cucumber.stepLibraries.UpdateStrikeProfileSteps;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

//make sure have correct import statements - I had to add these
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class UserProfileMap {
	@Steps CompleteNewProfileSteps completeNewProfileSteps;
	@Steps BaseUserSteps baseUserSteps;
	@Steps UpdateStrikeProfileSteps updateStrikeProfileSteps;
	@Steps ManageUserSteps manageUserSteps;
	@Steps AddNewUasSteps addNewUasSteps;

	//private static final String newProfileCssSelector = "div.my-profile h1";
	@FindBy(css = "div.my-profile h1") private WebElementFacade newProfileCss;

	@Then("click on the Hobbyist Model Aircraft Tab")
	public void clickOnModelAircraftButton(){
		completeNewProfileSteps.clickOnModelAircraftTypeButton();     
	}	
	@Then("click on the Non-Model Aircraft Tab")
	public void clickOnNonModelAircraftButton(){
		completeNewProfileSteps.clickOnNonModelAircraftButton();
	}	

//	@Then("i click on the I Agree button")
//	public void clickOnIAgreeButton(){
//		baseUserSteps.clickOnIAgreeButton();
//	}
	
	
//	click the MANAGE USER ACCOUNTS button
	@Then("click the MANAGE USER ACCOUNTS button")
	public void clickOnManageUserAccountsButton(){
		completeNewProfileSteps.clickOnManageUserAccountsButton();
	}	

	@Then("click the MANAGE sUAS INVENTORY button")
	public void clickOnManageSuasInventoryButton(){
		completeNewProfileSteps.clickOnManageSuasInventoryButton();
	}
	
    @Then("click the Add UAS button")
    public void clickOnAddUasButton(){
    	addNewUasSteps.clickOnAddUasButton();
    }
	
	@Then("click on the Users Tab")
	public void clickOnUsersTab(){
		completeNewProfileSteps.clickOnUsersTab();
	}	
	
	@Then("filter by '(.*)' Users")
	public void selectInvitedUsers(String invitedUser){
		completeNewProfileSteps.selectInvitedUsersDropList(invitedUser);	
	}	
	
	@Then("click on expired user details button")
	public void clickOnExpiredUserDetailsButton(){
		completeNewProfileSteps.clickOnExpiredUserDetailsButton();
	}	
	
	@Then("click on the edit button")
	public void clickOnExpiredUserEditButton(){
		completeNewProfileSteps.clickOnExpiredUserEditButton();
	}	
	
	
	@Then("click on Resend Invitation")
	public void clickOnExpiredUserResendInvitationButton(){
		completeNewProfileSteps.clickOnExpiredUserResendInvitationButton();
	}	
	
	@Then("click on the Add User Option")
	public void clickOnAddUserOption(){
		completeNewProfileSteps.clickOnAddUserOption();
	}	

	@Then("click on the Add User Button")
	public void clickOnAddUserButton(){
		completeNewProfileSteps.clickOnAddUserButton();
	}	

	
	@Then("enter new Invited User Information")
	public void typeIntoInvitedNewUserProfile(){
		completeNewProfileSteps.typeIntoInvitedNewUserProfile();
	}
	
	
	@Then("enter existing Invited User Information")
	public void typeIntoInvitedExistingUserProfile(){
		completeNewProfileSteps.typeIntoInvitedExistingUserProfile();
	}
	
	//verifyUserAlreadyInvitedMessageDisplayed
	@Then("verify user already invited message is Displayed")
	public void verifyUserAlreadyInvitedMessageDisplayed(){
		completeNewProfileSteps.verifyUserAlreadyInvitedMessageDisplayed();
	}
	
	
	@Then("click the cancel invite button")
	public void clickCancelInviteUser(){
		completeNewProfileSteps.clickCancelInviteButton();
	}
	
	@Then("enter password and confirm password to accept invitation")
	public void typeIntoAcceptInvitation(){
		completeNewProfileSteps.typeIntoAcceptInvitation();
	}


	@Then("i click on the Manage Access Tool option")
	public void clickOnManageAccessToolButton(){
		completeNewProfileSteps.clickOnManageAccessToolButton();
	}	
	
	//Send the certificate to primary email address
	@Then("email the receipt to primary email address")
	public void emailCertificatePrimaryEmail() {
		addNewUasSteps.clickOnSendEmailCertificatePrimaryButton();
		//clickOnEmailCertificateButton();
	}
	
	//Send the certificate to alternate email address
	@Then("email the receipt to alternate email address")
	public void emailCertificateAlternateEmail() {
		addNewUasSteps.clickOnSendEmailCertificateAlternateButton();
		//clickOnEmailCertificateButton();
	}

	
	
	//Cancel Certificate
	@Then("i cancel certificate if hobbyist already has one")
	public void clickOnCancelRegistrationButton(){
		completeNewProfileSteps.clickOnCancelHobbyistRegistrationButton();
	}
	
	//Renew Certificate
	@Then("renew certificate")
	public void clickOnRenewRegistrationButton(){
		completeNewProfileSteps.clickOnRenewHobbyistRegistrationButton();
	}
	
	@Then("i click the logout button")
	public void clickOnLogoutButton() {
		manageUserSteps.clickOnLogoutButton();
	}
	
	@Then("i click on the Profile Tab")
	public void clickOnProfileTab(){
		manageUserSteps.clickOnProfileTab();
	}

	@Then("click on the change primary email link")
	public void clickOnChangePrimaryEmailLink() {
		manageUserSteps.clickOnChangePrimaryEmailLink();
	}
	
	@Then("complete the change primary email address form")
	public void completeChangePrimaryEmailForm(){
		manageUserSteps.completeChangePrimaryEmailForm();
	}
	
	
	
	@Then("i click on the Inventory tab")
	public void clickOnInventoryTab() {
		manageUserSteps.clickOnInventoryTab();
	}
	
	@Then("click the welcome dropdown menu")
	public void clickOnWelcomeDropdownMenuButton(){
		manageUserSteps.clickOnWelcomeDropdownMenuButton();
	}
	
	@Then("i click on the edit Profile button")
	public void clickOnEditProfileButton(){
		manageUserSteps.clickOnEditProfileButton();
	}

	@Then("click to edit non hobbyist Account Details")
	public void clickOnEditNonHobbyistAccountDetailsButton(){
		manageUserSteps.clickOnEditNonHobbyistAccountDetailsButton();
	}
	
	@Then("edit non hobbyist Account Details")
	public void clickToEditNonHobbyistAccountDetails(){
//	public void clickToEditNonHobbyistPersonalInformation(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Edit Account Details Profile are saved! " );
		
	}
	
	
	@Then("click to edit Primary Email Address")
	public void clickOnEditPrimaryEmailAddressButton(){
		manageUserSteps.clickOnEditPrimaryEmailAddressButton();
	}

	

	@Then("click to edit non hobbyist Personal Information")
	public void clickOnEditNonHobbyistPersonalInformationDetailsButton(){
		manageUserSteps.clickOnEditNonHobbyistPersonalInformation();
	}
	
	
	
	
	@Then("click on edit non hobbyist Organization Information")
	public void clickOnEditNonHobbyistOrganizationInformationDetailsButton(){
		manageUserSteps.clickOnEditNonHobbyistOrganizationInformation();
	}
	
	@Then("edit non hobbyist Organization Information")
	public void clickToEditNonHobbyistOrganizationInformation(){
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Edit Organization Information Profile is saved! " );
	}
	
	@Then("edit non hobbyist Personal Information")
	public void clickToEditNonHobbyistPersonalInformation(){
//			completeNewProfileSteps.typeIntoCreateProfileFirstName();
//			completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
//			completeNewProfileSteps.typeIntoCreateProfileLastName();
//			completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
//			completeNewProfileSteps.typeIntoCreateProfileTitle();
//			System.out.println("********Enter the Alternate Email Address********" );
//			completeNewProfileSteps.typeIntoCreateProfileAltEmail();
			completeNewProfileSteps.typeIntoCreateProfilePhone();
			completeNewProfileSteps.typeIntoCreateProfileAltEmail();
//			completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
//			completeNewProfileSteps.typeIntoCreateProfileOrganization();
//			completeNewProfileSteps.typeIntoCreateProfileDba();
			completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
			completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
			completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
			completeNewProfileSteps.typeIntoCreateProfileCity();
			completeNewProfileSteps.selectProfilePhysicalStateDropList();
			//baseUserSteps.waitABit(2000);
			completeNewProfileSteps.typeIntoCreateProfileZipCode();
			baseUserSteps.waitABit(1000);
			completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
			completeNewProfileSteps.selectProfileMailingCountryFromDropList();
			completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
			completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
			completeNewProfileSteps.typeIntoCreateProfileMailingCity();
			completeNewProfileSteps.selectProfileMailingStateDropList();
			completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
			completeNewProfileSteps.clickOnNextOrSaveButton();
			System.out.println("Test is Complete.  Edit Personal Information Profile is saved! " );
		}
	
	@Then("complete non hobbyist international profile")
	public void completeNonHobbyistInternationalProfile(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalIntCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntAddress2();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntCity();
		completeNewProfileSteps.selectProfilePhysicalIntStateDropList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntZipCode();
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.selectProfileMailingIntCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntCity();
		completeNewProfileSteps.selectProfileMailingIntStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntZipCode();
		completeNewProfileSteps.clickOnProceedToDashboardButton();
		//completeNewProfileSteps.clickOnProceedToCheckoutButton();
		System.out.println("International Test is Complete.  Non Hobbyist International Profile is saved! " );

	}

	
	
	
	@Then("update your hobbyist international address")
	public void completeHobbyistInternationalProfile(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		//completeNewProfileSteps.clickOnProceedToCheckoutButton();
		completeNewProfileSteps.clickOnSaveProfileButton();
		
		System.out.println("Test is Complete.  Hobbyist Profile is saved! " );

	}
	
	@Then("update your hobbyist profile")
	public void completeHobbyistProfile(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		//completeNewProfileSteps.clickOnProceedToCheckoutButton();
		completeNewProfileSteps.clickOnSaveProfileButton();
		
		System.out.println("Test is Complete.  Hobbyist Profile is saved! " );

	}
	
	
	@Then("i complete your profile page")
	public void completeUserProfilePage(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		System.out.println("********Enter the Alternate Email Address********" );
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		//baseUserSteps.waitABit(1000);
///		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Profile is saved! " );

	}
	
	//typeIntoCreateNewProfileAltEmail
	@Then("complete your new non hobbyist profile")
	public void completeNewUserProfilePage(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateNewProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		//baseUserSteps.waitABit(1000);
///		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		completeNewProfileSteps.clickOnProceedToDashboardButton();
		//completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Non-Model Profile is saved! " );

	}	
	
	@Then("complete new non Model profile page")
	public void completeNewUserNonModelProfilePage(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateNewProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		//baseUserSteps.waitABit(1000);
///		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		completeNewProfileSteps.clickOnProceedToDashboardButton();
		//completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Non-Model Profile is saved! " );

	}	

	@Then("acknowledge safety guidance")
	public void acknowledgeSafetyGuidance(){
		completeNewProfileSteps.clickOnAcknowledgeSafetyGuidance();
	}
	
	
	
	
	@Then("i update your non hobbyist name")
	public void updateUserProfileName(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
//		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
//		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
//		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
//		completeNewProfileSteps.typeIntoCreateProfileCity();
//		completeNewProfileSteps.selectProfilePhysicalStateDropList();
//		//baseUserSteps.waitABit(2000);
//		completeNewProfileSteps.typeIntoCreateProfileZipCode();
//		baseUserSteps.waitABit(1000);
//		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
//		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
//		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
//		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
//		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
//		completeNewProfileSteps.selectProfileMailingStateDropList();
//		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Profile name is saved! " );
	}

	@Then("update nh alternate email address to match user account")
	public void createProfileAltEmail(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		System.out.println("**************BEGIN **************");
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileTitle();
//		String newxFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
//		System.out.println("Update Profile On Verify Account part of test  1111!!!!!!");
//		System.out.println("Update Profile On Verify Account part of test  " + newxFaaAcountEmail);
		completeNewProfileSteps.typeIntoCreateNewProfileAltEmail();
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
//		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
//		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
//		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
//		completeNewProfileSteps.typeIntoCreateProfileCity();
//		completeNewProfileSteps.selectProfilePhysicalStateDropList();
//		//baseUserSteps.waitABit(2000);
//		completeNewProfileSteps.typeIntoCreateProfileZipCode();
//		baseUserSteps.waitABit(1000);
//		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
//		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
//		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
//		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
//		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
//		completeNewProfileSteps.selectProfileMailingStateDropList();
//		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Profile name is saved! " );
	}
	

	@Then("i add profile for non hobbyist alternate email address to '(.*)'")
	public void updateUserProfileAltEmail(String altEmail){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoUpdateProfileAltEmail(altEmail);
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfileOrganization();
		completeNewProfileSteps.typeIntoCreateProfileDba();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		completeNewProfileSteps.clickOnNextOrSaveButton();
		System.out.println("Test is Complete.  Profile Alternate Email is saved! " );
	}
	
	@Then("update the international hobbyist profile")
	public void completeUserInternationalProfile(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.typeIntoCreateProfilePhone();
//		completeNewProfileSteps.typeIntoCreateProfileTitle();
		completeNewProfileSteps.typeIntoCreateProfileAltEmail();
//		completeNewProfileSteps.typeIntoCreateProfilePhoneExt();
		baseUserSteps.waitABit(1000);
//		completeNewProfileSteps.typeIntoCreateProfileOrganization();
//		completeNewProfileSteps.typeIntoCreateProfileDba();
		//Serenity.takeScreenshot();
		completeNewProfileSteps.selectProfilePhysicalIntCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntAddress2();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntCity();
		completeNewProfileSteps.selectProfilePhysicalIntStateDropList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalIntZipCode();
		//Serenity.takeScreenshot();
		baseUserSteps.waitABit(1000);
//		completeNewProfileSteps.clickMaSameAsPa();  
//		completeNewProfileSteps.clickMaSameAsPa();  
		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingIntCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntCity();
		completeNewProfileSteps.selectProfileMailingIntStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingIntZipCode();
		//Serenity.takeScreenshot();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.clickOnProceedToCheckoutOrSaveButton();
		System.out.println("International Profile Update Test is Complete.  Profile is saved! " );
	}
	
	@Then("i update my profile for strike three test")
	public void completeUserProfileStrikePage(){
		updateStrikeProfileSteps.typeIntoCreateProfileFirstName();
		updateStrikeProfileSteps.typeIntoCreateProfileMiddleInitial();
		updateStrikeProfileSteps.typeIntoCreateProfileLastName();
		updateStrikeProfileSteps.typeIntoCreateProfileNameSuffix();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfileTitle();
		updateStrikeProfileSteps.typeIntoCreateProfileAltEmail();
		updateStrikeProfileSteps.typeIntoCreateProfilePhone();
		updateStrikeProfileSteps.typeIntoCreateProfilePhoneExt();
		//Serenity.takeScreenshot();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfileOrganization();
		updateStrikeProfileSteps.typeIntoCreateProfileDba();
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.selectProfilePhysicalCountryDropDownList();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileCity();
		updateStrikeProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		updateStrikeProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.clickOnAddressIsSameCheckbox();  
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.selectProfileMailingCountryFromDropList();
		baseUserSteps.waitABit(1000);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingCity();
		updateStrikeProfileSteps.selectProfileMailingStateDropList();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.clickOnNextOrSaveButton();
		baseUserSteps.waitABit(3000);
		System.out.println("Strike Test is Complete.  Profile is saved! " );
	}

	@Then("update personal information for strike test")
	public void updatePersonalInformtionStrikePage(){
//		updateStrikeProfileSteps.typeIntoCreateProfileFirstName();
//		updateStrikeProfileSteps.typeIntoCreateProfileMiddleInitial();
//		updateStrikeProfileSteps.typeIntoCreateProfileLastName();
//		updateStrikeProfileSteps.typeIntoCreateProfileNameSuffix();
//		baseUserSteps.waitABit(1000);
//		updateStrikeProfileSteps.typeIntoCreateProfileTitle();
		updateStrikeProfileSteps.typeIntoCreateProfilePhone();
		updateStrikeProfileSteps.typeIntoCreateProfileAltEmail();
//		updateStrikeProfileSteps.typeIntoCreateProfilePhoneExt();
		//Serenity.takeScreenshot();
		baseUserSteps.waitABit(1000);
//		updateStrikeProfileSteps.typeIntoCreateProfileOrganization();
//		updateStrikeProfileSteps.typeIntoCreateProfileDba();
//		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.selectProfilePhysicalCountryDropDownList();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileCity();
		updateStrikeProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		updateStrikeProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.clickOnAddressIsSameCheckbox();  
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.selectProfileMailingCountryFromDropList();
		baseUserSteps.waitABit(1000);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingCity();
		updateStrikeProfileSteps.selectProfileMailingStateDropList();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.clickOnNextOrSaveButton();
		baseUserSteps.waitABit(3000);
		System.out.println("Strike Test is Complete.  Profile is saved! " );
	}

	@Then("update organization information for strike test")
	public void updateOrganizationInformtionStrikePage(){
//		updateStrikeProfileSteps.typeIntoCreateProfileFirstName();
//		updateStrikeProfileSteps.typeIntoCreateProfileMiddleInitial();
//		updateStrikeProfileSteps.typeIntoCreateProfileLastName();
//		updateStrikeProfileSteps.typeIntoCreateProfileNameSuffix();
//		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfilePhone();
		updateStrikeProfileSteps.typeIntoCreateProfilePhoneExt();
		updateStrikeProfileSteps.typeIntoCreateProfileTitle();
		updateStrikeProfileSteps.typeIntoCreateProfileAltEmail();
		updateStrikeProfileSteps.typeIntoCreateProfileOrganization();
		updateStrikeProfileSteps.typeIntoCreateProfileDba();
		//Serenity.takeScreenshot();
		baseUserSteps.waitABit(1000);
//		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.selectProfilePhysicalCountryDropDownList();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileCity();
		updateStrikeProfileSteps.selectProfilePhysicalStateDropList();
		//baseUserSteps.waitABit(2000);
		updateStrikeProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.clickOnAddressIsSameCheckbox();  
		baseUserSteps.waitABit(1000);
		updateStrikeProfileSteps.selectProfileMailingCountryFromDropList();
		baseUserSteps.waitABit(1000);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress1();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingAddress2();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingCity();
		updateStrikeProfileSteps.selectProfileMailingStateDropList();
		updateStrikeProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		//Serenity.takeScreenshot();
		updateStrikeProfileSteps.clickOnNextOrSaveButton();
		baseUserSteps.waitABit(3000);
		System.out.println("Strike Test is Complete.  Profile is saved! " );
	}
	
	
	
	
	@Then("i complete a new hobbyist profile")
	public void completeHobbyistUserProfilePage(){
		completeNewProfileSteps.typeIntoCreateProfileFirstName();
		completeNewProfileSteps.typeIntoCreateProfileMiddleInitial();
		completeNewProfileSteps.typeIntoCreateProfileLastName();
		completeNewProfileSteps.typeIntoCreateProfileNameSuffix();
		//Serenity.takeScreenshot();		
		completeNewProfileSteps.typeIntoCreateProfilePhone();
		completeNewProfileSteps.typeIntoCreateNewProfileAltEmail();
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		//Serenity.takeScreenshot();		
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		//Serenity.takeScreenshot();		
		baseUserSteps.waitABit(100);
		completeNewProfileSteps.clickOnProceedToCheckoutOrSaveButton();
		//Serenity.takeScreenshot();		
		System.out.println("Test is Complete.  Hobbyist Profile is saved! " );
//		}
//		else {
//			System.out.println("Unable to complete profile.  Hobbyist Profile already exists!" );
//			
//	    }
	}
	
	
	@Then("i update the Physical Address for an existing account")
	public void updatePhysicalAddressPage(){
		completeNewProfileSteps.selectProfilePhysicalCountryDropDownList();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress1();
		completeNewProfileSteps.typeIntoCreateProfilePhysicalAddress2();
		completeNewProfileSteps.typeIntoCreateProfileCity();
		completeNewProfileSteps.selectProfilePhysicalStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileZipCode();
		baseUserSteps.waitABit(1000);
		completeNewProfileSteps.clickOnSaveProfileButton();
		System.out.println("Physical Address has been updated.  Smarty Street validation will now begin! " );
		baseUserSteps.waitABit(1000);
	}

	@Then("i update the Mailing Address for an existing account")
	public void updateMailingAddressPage(){
		completeNewProfileSteps.clickOnAddressIsSameCheckbox();  
		completeNewProfileSteps.selectProfileMailingCountryFromDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress1();
		completeNewProfileSteps.typeIntoCreateProfileMailingAddress2();
		completeNewProfileSteps.typeIntoCreateProfileMailingCity();
		completeNewProfileSteps.selectProfileMailingStateDropList();
		completeNewProfileSteps.typeIntoCreateProfileMailingZipCode();
		baseUserSteps.waitABit(100);
		//Serenity.takeScreenshot(); 
		completeNewProfileSteps.clickOnSaveProfileButton();
		System.out.println("Mailing Address has been updated.  Smarty Street validation will now begin! " );
		baseUserSteps.waitABit(1000);
	}

	@Then("i validate the physical and mailing address")
	public void validatePhysicalAndMailingAddress() {
		completeNewProfileSteps.validatePhysicalAndMailingAddress();
	}
	@Then("i validate the physical address")
	public void validatePhysicalAddress() {
		completeNewProfileSteps.validatePhysicalAddress();
	}

	@Then("i validate the mailing address")
	public void validateMailingAddress() {
		completeNewProfileSteps.validateMailingAddress();
	}

	@Then("strike validate the physical and mailing address")
	public void validateStrikePhysicalAndMailingAddress() {
		updateStrikeProfileSteps.validateStrikePhysicalAndMailingAddress();
	}

	@Then("strike validate the physical address")
	public void validateStrikePhysicalAddress() {
		updateStrikeProfileSteps.validateStrikePhysicalAddress();
	}

	@Then("strike validate the mailing address")
	public void validateStrikeMailingAddress() {
		updateStrikeProfileSteps.validateStrikeMailingAddress();
	}

	
	@Then("display random data")
	public void displayRandomDataPage(){
		completeNewProfileSteps.randomRoleType();
		System.out.println("Test is Complete.  Role Types are displayed" );
	}

}
	




	

