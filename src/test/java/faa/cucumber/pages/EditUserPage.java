/**
 * 
 */
package faa.cucumber.pages;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import faa.utils.DataGenerator;
//import faa.cucumber.pages.CreateNewProfilePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/** @author jfranklin */
public class EditUserPage extends BasePageObject {

	//CreateNewProfilePage createNewProfilePage;
	GmailLoginPage gmailLoginPage;
	
	@FindBy(id = "searchbox") private WebElementFacade searchBox;
	@FindBy(id = "firstName") private WebElementFacade firstNameField;
	
	//@FindBy(id = "save") private WebElementFacade saveButton;
	@FindBy(xpath="//button[@id='saveEditButton']") private WebElementFacade saveButton;
	@FindBy(id = "middleInitial") public WebElementFacade middleInitialField;
	@FindBy(id = "formLastName") public WebElementFacade formLastNameField;
	@FindBy(id = "nameSuffix") public WebElementFacade nameSuffixField;

	/** After Updating the profile page, this success message is displayed at the top of the page **/
	@FindBy(xpath="//p[@class='text-center' and contains(text(), 'Your profile has been successfully updated.')]") private WebElementFacade messageUpdateProfileSuccess;
	@FindBy(id = "searchBtn") public WebElementFacade searchButton;

	
	
	// Change Primary Email address
	@FindBy(id = "orgChangePrimaryEmailBtnRegistered") public WebElementFacade changeNonHobbyistPrimaryEmail;

	@FindBy(id = "newPrimaryEmail") public WebElementFacade changeNewEmail;
	@FindBy(id = "confirmNewPrimaryEmail") public WebElementFacade changeConfirmNewEmail;
	@FindBy(id = "newConfirmEmailPassword") public WebElementFacade changePassword;
	@FindBy(id = "isConfirmEmail") public WebElementFacade changeCheckboxToConfirm;
	@FindBy(id = "submitPrimaryEmailChange") public WebElementFacade changeSubmitButton;
	@FindBy(id = "verificationCode") public WebElementFacade changeVerificationCode;
	@FindBy(id = "submitVerificationCode") public WebElementFacade changeSubmitVerificationCode;
	
	
	@FindBy(xpath="//a[@id='editGeneralAccountInformation']") private WebElementFacade editGeneralAccountInformation;
	@FindBy(xpath="//a[@id='editPrimaryEmail']") private WebElementFacade editPrimaryEmail;
	@FindBy(xpath="//a[@id='editPersonalInformation']") private WebElementFacade editPersonalInformation;
	@FindBy(xpath="//a[@id='editOrganizationInformation']") private WebElementFacade editOrganizationInformation;

//	@FindBy(id = "phone") private WebElementFacade editProfilePhone;
//	@FindBy(id = "phoneExt") private WebElementFacade editProfilePhoneExt;
//	@FindBy(id = "physicalAddress_country") private WebElementFacade editProfilePhysicalCountry;
//	@FindBy(id = "physicalAddress_addressLine1") private WebElementFacade editProfilePhysicalAddress1;
//	@FindBy(id = "physicalAddress_addressLine2") private WebElementFacade editProfilePhysicalAddress2;
//	@FindBy(id = "physicalAddress_city") private WebElementFacade editProfilePhysicalCity;
//	@FindBy(id = "physicalAddress_stateProvinceRegion") private WebElementFacade editProfilePhysicalState;
//	@FindBy(id = "physicalAddress_zipPostal") private WebElementFacade editProfilePhysicalZip;
//
//	
//	@FindBy(id = "mailingSameAsPhysical") private WebElementFacade editProfileaddressIsSame;
//	@FindBy(id = "mailingAddress_country") private WebElementFacade editProfileMailingCountry;
//	@FindBy(id = "mailingAddress_addressLine1") private WebElementFacade editProfileMailingAddress1;
//	@FindBy(id = "mailingAddress_addressLine2") private WebElementFacade editProfileMailingAddress2;
//	@FindBy(id = "mailingAddress_city") private WebElementFacade editProfileMailingCity;
//	@FindBy(id = "mailingAddress_stateProvinceRegion") private WebElementFacade editProfileMailingState;
//	@FindBy(id = "mailingAddress_zipPostal") private WebElementFacade editProfileMailingZip;
//
//	
	
	
	/* Verification code in the email for changing primary email address */
	@FindBy(xpath="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]/p[1]") public WebElementFacade changePrimaryEmailVerificationCode;		
	
	@FindBy(id = "myModalLabel") public WebElementFacade enterVerificationCodeModal;
	
	/**Done button to be clicked to complete the payment process...  button[@class='btn btn-primary center-block' and contains(text(), 'Done')] **/
	@FindBy(xpath="//div[@class='text-center ng-binding' and contains(text(), 'Your Primary Email has successfully been changed')]") private WebElementFacade messagePrimaryEmailChangeSuccess;

	
	public void clickOnEditGeneralAccountInformation() {
		editGeneralAccountInformation.click();
	}

	public void editNonHobbyistAccountDetails() {
		firstNameField.typeAndEnter(DataGenerator.randomFirstName());
		middleInitialField.typeAndEnter(DataGenerator.randomAlphabetic(1));
		formLastNameField.typeAndEnter(DataGenerator.randomLastName());
		nameSuffixField.typeAndEnter(DataGenerator.randomSuffixName());
		clickSaveButton();
		if(messageUpdateProfileSuccess.isCurrentlyVisible()) {
			System.out.println("Profile has been updated successfully");
		} else {
			System.out.println("Error occured. Profile has NOT been updated");
			}
		}

	
	//clickOnEditPrimaryEmailAddressButton
	public void clickOnEditPrimaryEmailAddressButton() {
		if(editPrimaryEmail.isCurrentlyVisible()) {
			System.out.println("Edit Primary Email Address link is visible");
			editPrimaryEmail.click();
		} else {
			System.out.println("Error occured. Personal Information is not available for this Profile");
			}
		}
	

	
	public void clickOnEditNonHobbyistPersonalInformation() {
		if(editPersonalInformation.isCurrentlyVisible()) {
			System.out.println("Edit Personal Information is visible");
			editPersonalInformation.click();
		} else {
			System.out.println("Error occured. Personal Information is not available for this Profile");
			}
		}

	public void clickOnEditNonHobbyistOrganizationInformation() {
		if(editOrganizationInformation.isCurrentlyVisible()) {
			System.out.println("Edit Organization Information is visible");
			editOrganizationInformation.click();
		} else {
			System.out.println("Error occured. Organization Information is not available for this Profile");
			}
		}
	
	
	
//	public void editNonHobbyistPersonalInformation() {
//		editProfilePhone.typeAndEnter(DataGenerator.randomNumber(10));
//		
//editProfileAlternateEmail
//editProfilePhysicalCountry
//editProfilePhysicalAddress1
//editProfilePhysicalAddress2
//editProfilePhysicalCity
//editProfilePhysicalState
//editProfilePhysicalZip
//
//editProfileaddressIsSame
//editProfileMailingCountry
//editProfileMailingAddress1
//editProfileMailingAddress2
//editProfileMailingCity
//editProfileMailingState
//editProfileMailingZip
		
//		createNewProfilePage.typeIntoCreateProfilePhone();
//		createNewProfilePage.typeIntoCreateProfilePhoneExt();
//		createNewProfilePage.selectProfilePhysicalCountryDropDown(country1);
//		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(newAddress1);
//		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(newAddress2);
//		createNewProfilePage.typeIntoCreateProfilePhysicalCity(newCity);
//		createNewProfilePage.selectFromPhysicalStateNameDropdownList(newState);
//		createNewProfilePage.typeIntoCreateProfilePhysicalZip(newZip);
//		createNewProfilePage.
//		createNewProfilePage.
		
//		createProfilePhysicalCountry
//		createProfilePhysicalAddress1
//		createProfilePhysicalAddress2
//		createProfilePhysicalCity
//		createProfilePhysicalState
//		createProfilePhysicalZip
//
//		createProfileaddressIsSame
//		createProfileMailingCountry
//		createProfileMailingAddress1
//		createProfileMailingAddress2
//		createProfileMailingCity
//		createProfileMailingState
//		createProfileMailingZip
		
//		firstNameField.typeAndEnter(DataGenerator.randomFirstName());
//		middleInitialField.typeAndEnter(DataGenerator.randomAlphabetic(1));
//		formLastNameField.typeAndEnter(DataGenerator.randomLastName());
//		nameSuffixField.typeAndEnter(DataGenerator.randomSuffixName());
//		clickSaveButton();
//		if(messageUpdateProfileSuccess.isCurrentlyVisible()) {
//			System.out.println("Profile has been updated successfully");
//		} else {
//			System.out.println("Error occured. Profile has NOT been updated");
//			}
//}
//	
//	
	
	
//	editPrimaryEmail
//	editPersonalInformation
//	editOrganizationInformation	
	
	
	
	public WebElementFacade elementLocatedByCss(String cssLocator) {
		return find(By.cssSelector(cssLocator));
	}

	public void clickEditButtonForResult(int resultNum) {
		List<WebElementFacade> searchResultTable = findWebElementsByCssSelectorWithError(
				"table.table.table-striped.table-bordered tbody tr td button");
		if ((searchResultTable.size() != 0))
			searchResultTable.get(0).waitUntilEnabled();
		if (searchResultTable.size() >= (resultNum * 2)) {
			click(searchResultTable.get(((resultNum - 1) * 2) + 0));
		} else {
			System.out.println("Error: No table action taken!");
		}
	}

	public void searchForUser(String searchStringa) {
		searchBox.typeAndEnter(searchStringa);
		waitForSplashScreenToFinish();
		click(searchButton);
		waitABit(700);

	}

//	public void typeIntoProfilePhone(String phone){
//		createProfilePhone.type(phone);
//	}
	
	public void typeIntoFirstNameField(String newFirstName) {
		firstNameField.type(newFirstName);
	}

	public void clickSaveButton() {
		saveButton.click();

	}

	public void successfullyUpdatedMessageShouldBeVisible() {
		elementLocatedByCss("div.alert.ng-isolate-scope.alert-success div span.ng-binding.ng-scope")
				.shouldContainText("Successfully updated user:");
	}

	public void successfullySavedMessageShouldBeVisible() {
		elementLocatedByCss("div.alert.ng-isolate-scope.alert-success div span.ng-binding.ng-scope")
				.shouldContainText("Successfully saved user:");
	}

	public void verifyFirstNameEquals(String string) {
		String firstName = firstNameField.getValue();
		assertThat(firstName).containsIgnoringCase(string);
	}

	public void verifyMiddleNameEquals(String string) {
		String middleName = middleInitialField.getValue();
		assertThat(middleName).containsIgnoringCase(string);
	}

	public void verifyLastNameEquals(String string) {
		String lastName = formLastNameField.getValue();
		assertThat(lastName).containsIgnoringCase(string);
	}

	public void typeIntoMiddleInitialField(String string) {
		middleInitialField.type(string);
	}

	public void typeIntoLastNameField(String newLastName) {
		formLastNameField.type(newLastName);
	}

	//changeVerificationCode
	public void typeIntoVerificationCodeField() {
		//Retrieve Session Variable
		String varPrimaryEmailChangeVerificationCode = Serenity.sessionVariableCalled("primaryEmailChangeVerificationCode").toString();
		System.out.println("Type Into Verification Code Field->Primary Email Change Verification Code-->" + varPrimaryEmailChangeVerificationCode );
		changeVerificationCode.clear();
		changeVerificationCode.type(varPrimaryEmailChangeVerificationCode);
	}
	
	public void clickOnChangePrimaryEmailLink() {
		changeNonHobbyistPrimaryEmail.click();
	}

	public void completeChangePrimaryEmailForm() {
		//This is a string identifier for the current window so that we can find it later
		String windowHandleBefore = getDriver().getWindowHandle();
        System.out.println("Title 1-->" + getTitle());
		//Then you want to search for any new handles that may be present (there should now be 2)
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
		}
		//System.out.println("Title 2-->" + getTitle());
		String varNewNumber = DataGenerator.randomNumber(8);
		String varNewEmail = "mynewfaadrone+nhCPE" + varNewNumber + "@gmail.com";
		System.out.println("New Email Address is -->" + varNewEmail);
		changeNewEmail.type(varNewEmail);
		changeConfirmNewEmail.type(varNewEmail);
		changePassword.type("Dummy$11");
		changeCheckboxToConfirm.click();
		changeSubmitButton.click();
		
		gmailLoginPage.clickToOpenNewBrowserTab();
		//JUST ADDED THIS...
		//Then you want to search for any new handles that may be present (there should now be 2)
				for (String winHandle : getDriver().getWindowHandles()) {
		            getDriver().switchTo().window(winHandle);
		}
		System.out.println("Title 3-->" + getTitle());
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
		}
		System.out.println("Title 4-->" + getTitle());
		getDriver().navigate().to("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/");
        System.out.println("Title 5 after switching back to original browser Tab-->" + getTitle());
		//When you're done switch back to the original saved window handle
        ////getDriver().switchTo().window(windowHandleBefore);  
        gmailLoginPage.typeIntoEmailField("mynewfaadrone@gmail.com");
        gmailLoginPage.typeIntoGmailPasswordField("Dummy$11");
        gmailLoginPage.clickOnGmailInboxEmailLink();
        System.out.println("Title 6 after logging into Gmail-->" + getTitle());
        gmailLoginPage.clickOnGmailLinkToChangePrimaryEmail();
      //Retrieve Session Variable
//        String varPrimaryEmailChangeVerificationCode = Serenity.sessionVariableCalled("primaryEmailChangeVerificationCode").toString();
//        System.out.println("Primary Email Change Verification Code is-->" + varPrimaryEmailChangeVerificationCode);
        getDriver().switchTo().window(windowHandleBefore);  
        System.out.println("Title 7-->" + getTitle());
        typeIntoVerificationCodeField();
        //Serenity.takeScreenshot();
        verificationCodeSubmit();
        //Serenity.takeScreenshot();
        //assertThat(messagePrimaryEmailChangeSuccess.getText().contains("Your Primary Email has successfully been changed."));
        assertThat(messagePrimaryEmailChangeSuccess.getText()).contains("Your Primary Email has successfully been changed.").overridingErrorMessage("ERROR: Primary Email Address was not successfully completed");
//		assertThat(successfullyChangedPasswordMessage.getText()).containsIgnoringCase("You have successfully changed your password. You may now login.")
//		.overridingErrorMessage("ERROR: User change password message was not displayed");

        
        //Assert.assertTrue(messagePrimaryEmailChangeSuccess.getText().contains("Your Primary Email has successfully been changed."), "ERROR: Primary Email Address was not successfully completed");
//      assertThat(messagePrimaryEmailChangeSuccess.getText().contains("Your Primary Email has successfully been changed."), "ERROR: Primary Email Address was not successfully completed");
//        assertThat("Your Primary Email has successfully been changed.", messagePrimaryEmailChangeSuccess.getText().contains("Your Primary Email has successfully been changed."));  // ,"ERROR: Primary Email Address was not successfully completed");
        //        String messageEmailChange = messagePrimaryEmailChangeSuccess.getValue();
//		assertThat(messageEmailChange).containsIgnoringCase(string);
        
        
	}   
        
	
	public void verificationCodeSubmit(){
		changeSubmitVerificationCode.click();
	}
	
}