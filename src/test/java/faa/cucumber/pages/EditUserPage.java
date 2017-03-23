/**
 * 
 */
package faa.cucumber.pages;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThat;

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

	@FindBy(id = "newEmail") public WebElementFacade changeNewEmail;
	@FindBy(id = "confirmEmail") public WebElementFacade changeConfirmNewEmail;
	@FindBy(id = "password") public WebElementFacade changePassword;
	@FindBy(id = "confirmEmailChange") public WebElementFacade changeCheckboxToConfirm;

	
	//@FindBy(id = "save") public WebElementFacade changeSubmitButton;
	@FindBy(xpath="//button[@id='savePrimaryEmail' and contains(text(), 'Save')] ") private WebElementFacade changeSubmitButton;
	//@FindBy(id = "verificationCode") public WebElementFacade changeVerificationCode;
	@FindBy(xpath="//input[@id='verficationCode']") private WebElementFacade changeVerificationCode;

	
	//@FindBy(id = "submitVerificationCode") public WebElementFacade changeSubmitVerificationCode;
	@FindBy(xpath="//a[@id='submitVerificationCode']") private WebElementFacade changeSubmitVerificationCode;
	
	@FindBy(xpath="//a[@id='editGeneralAccountInformation']") private WebElementFacade editGeneralAccountInformation;
	@FindBy(xpath="//a[@id='editPrimaryEmail']") private WebElementFacade editPrimaryEmail;
	@FindBy(xpath="//a[@id='editPersonalInformation']") private WebElementFacade editPersonalInformation;
	@FindBy(xpath="//a[@id='editOrganizationInformation']") private WebElementFacade editOrganizationInformation;

	/* Verification code in the email for changing primary email address */
	@FindBy(xpath="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]/p[1]") public WebElementFacade changePrimaryEmailVerificationCode;		
	
	@FindBy(id = "myModalLabel") public WebElementFacade enterVerificationCodeModal;
	
	/**Done button to be clicked to complete the payment process...  button[@class='btn btn-primary center-block' and contains(text(), 'Done')] **/
	@FindBy(xpath="//p[@class='text-center' and contains(text(), 'Your primary email has been successfully updated')]") private WebElementFacade messagePrimaryEmailChangeSuccess;

	
	public void clickOnEditGeneralAccountInformation() {
		Serenity.takeScreenshot();
		editGeneralAccountInformation.click();
	}
	
	public void verifyProfileUpdatedSuccessMessage() {
		waitABit(1000);
		assertThat(messageUpdateProfileSuccess.isCurrentlyVisible()).isTrue();
		
	}

	public void editNonHobbyistAccountDetails() {
		firstNameField.typeAndEnter(DataGenerator.randomFirstName());
		middleInitialField.typeAndEnter(DataGenerator.randomAlphabetic(1));
		formLastNameField.typeAndEnter(DataGenerator.randomLastName());
		nameSuffixField.typeAndEnter(DataGenerator.randomSuffixName());
		Serenity.takeScreenshot();
		clickSaveButton();
		if(messageUpdateProfileSuccess.isCurrentlyVisible()) {
			System.out.println("Profile has been updated successfully");
		} else {
			System.out.println("Error occured. Profile has NOT been updated");
			}
		}

	
	//clickOnEditPrimaryEmailAddressButton
	public void clickOnEditPrimaryEmailAddressButton() {
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to wait for Primary Email Address link to be displayed... " + i);
			if (editPrimaryEmail.isCurrentlyVisible()){
			i=19;
			editPrimaryEmail.click();
			System.out.println("Primary Email Address link has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(2000);//wait 3 seconds before trying to click again
			}
		}
	}	
	
	public void clickOnEditNonHobbyistPersonalInformation() {
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to wait for Edit Personal Information link to be displayed... " + i);
			if (editPersonalInformation.isCurrentlyVisible()){
			i=19;
			Serenity.takeScreenshot();
			editPersonalInformation.click();
			System.out.println("Edit Personal Information link has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(2000);//wait 3 seconds before trying to click again
			}
		}
	}	
		
		

	public void clickOnEditNonHobbyistOrganizationInformation() {
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to wait for Edit Organization Information link to be displayed... " + i);
			if (editOrganizationInformation.isCurrentlyVisible()){
			Serenity.takeScreenshot();
			i=19;
			editOrganizationInformation.click();
			System.out.println("Edit Organization Information link has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(2000);//wait 3 seconds before trying to click again
			}
		}
	}	


	
	
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
		//changeVerificationCode.clear();
        Serenity.takeScreenshot();
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
        Serenity.takeScreenshot();
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
        //changeSubmitButton.click();
        Serenity.takeScreenshot();
        changeSubmitButton.click();
        Serenity.takeScreenshot();
        assertThat(messagePrimaryEmailChangeSuccess.getText()).contains("Your primary email has been successfully updated to " + varNewEmail).overridingErrorMessage("ERROR: Primary Email Address was not successfully completed");
        waitABit(2000);
        if (messagePrimaryEmailChangeSuccess.isCurrentlyVisible()){
        	 System.out.println("Your primary email has been successfully updated!!!! ");
        } else {
        	 System.out.println("Your primary email has NOT been updated!!!! ");
        }
	}   
        
	
//	public void verificationCodeSubmit(){
//		changeSubmitButton.click();
//	}
	
}