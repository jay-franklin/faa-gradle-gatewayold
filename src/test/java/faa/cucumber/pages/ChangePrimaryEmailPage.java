package faa.cucumber.pages;

import org.openqa.selenium.support.FindBy;

import faa.utils.DataGenerator;
import faa.utils.Verify;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
/** @author jfranklin */
public class ChangePrimaryEmailPage {

	/** Change Primary Email Button */
	@FindBy(xpath = "//button[@class='btn' and contains(text(), 'Change Primary Email')]") private WebElementFacade changePrimaryEmailButton;
	/** newPrimaryEmail textbox */
	@FindBy(xpath = "//input[@id='newPrimaryEmail' and @title='Enter a new Primary Email']") private WebElementFacade newPrimaryEmailTextBox;
	/**confirmNewPrimaryEmail textbox */
	@FindBy(xpath = "//input[@id='confirmNewPrimaryEmail' and @title='Confirm new Primary Email']") private WebElementFacade ConfirmNewPrimaryEmailTextBox;
	/**newConfirmEmailPassword textbox */
	@FindBy(xpath = "//input[@id='newConfirmEmailPassword']") private WebElementFacade newConfirmNewEmailPasswordTextBox;
	/**isConfirmEmail Checkbox */
	@FindBy(xpath = "//input[@id='isConfirmEmail']") private WebElementFacade isConfirmedEmailCheckBox;
	/** Save Button */
	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Submit')]") private WebElementFacade submitButton;

	
//	Serenity.setSessionVariable("userName").to(newUser.getFullName());
//	
//	String newxFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
//	
//	
//	//updatedPhysicalCountry
//	Serenity.setSessionVariable("varProfilePhysicalCountry").to(newProfilePhysicalAddress[0]);
//	String updatedProfilePhysicalCountry = Serenity.sessionVariableCalled("varProfilePhysicalCountry").toString();
//	System.out.println("On Verify new Physical Country is--->  " + updatedProfilePhysicalCountry);
//
//	
//	
//
	public void typeIntoNewPrimaryEmailField() {
		String newPrimaryEmail = "mynewfaadrone+nhNewPrimaryEmail" + DataGenerator.randomIntegerBetween(1,10000) + "@gmail.com";
		System.out.println("New Primary Email Address is --->" + newPrimaryEmail);
		Serenity.setSessionVariable("varNewPrimaryEmailAddress").to(newPrimaryEmail);
		String newPrimaryEmail2 = Serenity.sessionVariableCalled("varNewPrimaryEmailAddress").toString();
		System.out.println("Verify New Primary Email Address is--->" + newPrimaryEmail2);
		newPrimaryEmailTextBox.clear();
		newPrimaryEmailTextBox.typeAndTab(newPrimaryEmail);
		//Serenity.takeScreenshot(); 
	}

	public void typeIntoConfirmNewPrimaryEmailField() {
		String confirmNewPrimaryEmail =   Serenity.sessionVariableCalled("varNewPrimaryEmailAddress").toString();      //"mynewfaadrone+nhNewPrimaryEmail" + DataGenerator.randomIntegerBetween(1,10000) + "@gmail.com";
		System.out.println("Confirm New Primary Email Address is --->" + confirmNewPrimaryEmail);
//		Serenity.setSessionVariable("varNewPrimaryEmailAddress").to(confirmNewPrimaryEmail);
//		confirmNewPrimaryEmail = Serenity.sessionVariableCalled("varNewPrimaryEmailAddress").toString();
		System.out.println("Verify Confirm New Primary Email Address is--->" + confirmNewPrimaryEmail);
		ConfirmNewPrimaryEmailTextBox.clear();
		ConfirmNewPrimaryEmailTextBox.typeAndTab(confirmNewPrimaryEmail);
		//Serenity.takeScreenshot(); 
	}
	
	public void typeIntoConfirmNewEmailPasswordField() {
		String newPrimaryEmailPassword = "Dummy$11";
		System.out.println("New Primary Email Address Password is --->" + newPrimaryEmailPassword);
//		Serenity.setSessionVariable("varNewPrimaryEmailAddress").to(newPrimaryEmail);
//		String newPrimaryEmail2 = Serenity.sessionVariableCalled("varNewPrimaryEmailAddress").toString();
		System.out.println("Verify New Primary Email Address Password is--->" + newPrimaryEmailPassword);
		newConfirmNewEmailPasswordTextBox.clear();
		newConfirmNewEmailPasswordTextBox.typeAndTab(newPrimaryEmailPassword);
		//Serenity.takeScreenshot(); 
	}

	
//	//updatedPhysicalCountry
//	Serenity.setSessionVariable("varProfilePhysicalCountry").to(newProfilePhysicalAddress[0]);
//	String updatedProfilePhysicalCountry = Serenity.sessionVariableCalled("varProfilePhysicalCountry").toString();

	public void clickOnIsConfirmedEmailCheckbox() {
		isConfirmedEmailCheckBox.click();
		System.out.println("The New Primary Email Address Is Confirmed Checkbox is selected");
		//Serenity.takeScreenshot(); 
	}	

	public void clickOnSubmitButton() {
		submitButton.click();
		System.out.println("The New Primary Email Address Submit Button is Clicked");
		//Serenity.takeScreenshot(); 
	}	
	
	
//	typeIntoNewPrimaryEmailField();
//	typeIntoConfirmNewPrimaryEmailField();
//	typeIntoConfirmNewEmailPasswordField();
//	clickOnIsConfirmedEmailCheckbox();
//	clickOnSubmitButton();
	
	//
//	public void typeIntoConfirmNewEmailField() {
//		ConfirmNewPrimaryEmailTextBox.clear();
//		//String newEmail = "mynewfaadrone+nhNewEmail" + DataGenerator.randomIntegerBetween(1,10000) + "@gmail.com";
//		System.out.println("New Primary Email Address is --->" + newEmail);
//		ConfirmNewPrimaryEmailTextBox.typeAndTab(newEmail);
//		//Serenity.takeScreenshot(); 
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//hobCancelRegistrationReason
//	public void typeIntoOnHobbyistCancelRegistrationReason() {
//			System.out.println("Cancel Registration Reason" );			
//			hobCancelRegistrationReason.type("Not a good reason, but a good one is not needed");
//			//Serenity.takeScreenshot(); 
//	}	
//
//	//hobCancelRegistrationReasonCheckbox
//	public void clickOnHobbyistCancelRegistrationReasonCheckbox() {
//		hobCancelRegistrationReasonCheckbox.click();
//		//Serenity.takeScreenshot(); 
//	}	
//
//	public void typeIntoCreateProfileAlternateEmail() {
////		String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
//		String newFaaAcountEmail = "mynewfaadrone@gmail.com";
//		System.out.println("Edit Profile On Verify Account part of test  1111!!!!!!");
//		System.out.println("Edit Profile On Verify Account part of test  " + newFaaAcountEmail);
//		String upperUpdateAltEmail = newFaaAcountEmail.toUpperCase();
//		String camelUpdateAltEmail = Verify.toCamelCase(newFaaAcountEmail);
//		System.out.println("Upper Case Alternate Email Address " + upperUpdateAltEmail );
//		System.out.println("Camel Case Alternate Email Address " + camelUpdateAltEmail );
//		createProfileAlternateEmail.clear();
//		createProfileAlternateEmail.typeAndTab(newFaaAcountEmail);
//		//Serenity.takeScreenshot(); 
//		if (altEmailErrorMessage.isCurrentlyVisible()) {
//			createProfileAlternateEmail.typeAndTab(upperUpdateAltEmail);
//			System.out.println("Upper Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
//			//Serenity.takeScreenshot(); 
//		}
//		if (altEmailErrorMessage.isCurrentlyVisible()) {
//			createProfileAlternateEmail.typeAndTab(camelUpdateAltEmail);
//			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
//			//Serenity.takeScreenshot(); 
//		}
//		if (altEmailErrorMessage.isCurrentlyVisible()) {
//			createProfileAlternateEmail.typeAndTab("myfaadrone+300@gmail.com");
//			System.out.println("Email Address has been updated with a valid email that is different than the primary Email address" );
//			System.out.println("Alternate Email Address is myfaadrone+300@gmail.com ");
//			//Serenity.takeScreenshot(); 
//		}
//		//Serenity.takeScreenshot(); 
//	}
//	
}
