package faa.cucumber.pages;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @authors jfranklin
 */
public class NewAccountPage extends BasePageObject {

	
	
	/**<p>NonModelAircraftButtonCssSelector Button Css Selector 
	 * Button displays the Complete Your Profile page for new users*/
	static final String NonModelAircraftButtonCssSelector = "body#body div div div div div div div div.icon-heads";
	/** Success Message */
	//@FindBy(xpath = "/html/body/div[2]/div[2]/h1") private WebElementFacade accountCreateSuccessMessage;
//	@FindBy(css="html body app-root div div div div div div h1") private WebElementFacade accountCreateSuccessMessage;
	/** Account Creattion Success Message */
	@FindBy(xpath = "//h1[contains(text(), 'Almost done! We just sent you a verification email.')]") private WebElementFacade accountCreateSuccessMessage;
	
	
	/** Account Already Exists Message */
	@FindBy(xpath = "//div[contains(text(), 'Account with that email already exists. Please choose another email.')]") private WebElementFacade accountCreateAlreadyExistsMessage;

	
	
	@FindBy(id = "email") private WebElementFacade newAccountEmail;
	@FindBy(id = "password") private WebElementFacade newAccountPassword;
	@FindBy(id = "confirmPassword") private WebElementFacade newAccountConfirmPassword;
	@FindBy(id = "createAccount") private WebElementFacade newAccountCreateAccount;

	
	/** New Account Link */
	@FindBy(xpath = "//a[@id='createNewAccount' and contains(text(), 'Create Account')]") private WebElementFacade createNewAccountLink;
	/** Create Account Submit Button  */
	@FindBy(xpath = "//button[@id='createAccount' and contains(text(), 'Create Account')]") private WebElementFacade createAccountButton;

	/** clickOnRegisterNonModelButton */
	@FindBy(xpath = "//button[@id='nonModelAircraftUser' and contains(text(), 'REGISTER')]") private WebElementFacade registerNonModelButton;

	
	
	
	//clickOnRegisterNonModelButton	
	//Register Non Model Account Button
	public void clickOnRegisterNonModelButton() {
		waitABit(2000);
		registerNonModelButton.click();
	}

	//New Account Link
	public void clickOnCreateNewAccountLink() {
		waitABit(2000);
		createNewAccountLink.click();
	}

	//Create Account Button
	public void clickOnCreateAccountButton() {
		waitABit(2000);
		createAccountButton.click();
	}
	
	
		//click on Non-Model Aircraft Complete Your Profile Button
		public void clickOnNonModelAircraftButtonCssSelectorButton() {
			waitABit(2000);
			//waitForElement(NonModelAircraftButtonCssSelector);
			click(NonModelAircraftButtonCssSelector);
		}
		
		
		public void typeIntoNewAccountEmailAddressField(String newFaaAccount) {
			newAccountEmail.type(newFaaAccount);
			System.out.println("Email address of new account is getValue " + newAccountEmail.getValue());
			System.out.println("Session Variable Email Gmail address of new account is " + newFaaAccount);
			System.out.println("3 Second Deplay");
				waitABit(3000);
			System.out.println("3 Second Deplay ends");
		}
		public String getNewEmailAccountAddressFieldValue() {
			return newAccountEmail.getValue();
		}
		
		public void typeIntoEmailAddressField(String newGmailEmailAccount) {
			newAccountEmail.clear();
//			String newGmailEmailAccount = "myfaadrone+" + DataGenerator.randomIntegerBetween(10,400) + "@gmail.com";
//			Serenity.setSessionVariable("newFaaAccount").to(newGmailEmailAccount);
//			String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
            System.out.println("On Verify new FAA Drone Email Account part of test  " + newGmailEmailAccount);
			newAccountEmail.type(newGmailEmailAccount);   
			System.out.println("XXXXXXXXXXXXXNew Email address of new account is " + getNewEmailAccountAddressFieldValue());
			System.out.println("XXXXXXXXXXXXXEmail address of new account is " + getTypeIntoEmailAddressFieldValue());
			System.out.println("3 Second Deplay");
			//Serenity.setSessionVariable(newAccountEmail.getValue()).to(newEmailAccount);
			waitABit(3000);
			System.out.println("3 Second Deplay ends");
			
		}
		
		
		public String getNewEmailAddressFieldValue() {
			return newAccountEmail.getValue();
		}

		
		
		public String getTypeIntoEmailAddressFieldValue() {
			return newAccountEmail.getValue();
		}
		public void typeIntoPasswordField(String inputText) {
			newAccountPassword.type(inputText);
		}
		public void typeIntoConfirmPasswordField(String inputText) {
			newAccountConfirmPassword.type(inputText);
		}
//		//Create Account Button
//		public void clickOnCreateAccountButton() {
//			newAccountCreateAccount.click();
//		}
		//Verify the create account success
		
		/** {@value} */
		public static final String successMessageCssSelector = "html body div div.email-password-area.col-md-12.col-sm-12.col-xs-12.large h1";

		
		public void verifyAlmostDoneMessageIsDisplayed() {
			findWebElementByCssSelector(successMessageCssSelector).shouldContainText("Almost done!");
		}

		/** {@value} */
		private static final String AccountExistsMessageCssSelector = "//p[contains(text(), 'Account with that email already exists')] ";
		public void accountAlreadyExistsMessageIsDisplayed() {
			findWebElementByCssSelector(AccountExistsMessageCssSelector).shouldContainText("Account with that email already exists");
		}

		public void verifyAccount(){
			if (accountCreateSuccessMessage.isCurrentlyVisible()){  // shouldContainText("Almost done! We just sent you a verification email.")){
				System.out.println("Account Created Successfully. ");
			} else if (accountCreateAlreadyExistsMessage.isCurrentlyVisible()){
				System.out.println("Account with that email already exists. Please choose another email.");
    		String newGmailEmailAccount = "mynewfaadrone+hGateway" + DataGenerator.randomIntegerBetween(100,10000) + "@gmail.com";
    		Serenity.setSessionVariable("newFaaAccount").to(newGmailEmailAccount);
				System.out.println("Account Already Exists. ");
				typeIntoEmailAddressField(newGmailEmailAccount);
				typeIntoPasswordField("Dummy$11");
				typeIntoConfirmPasswordField("Dummy$11");
				//Serenity.takeScreenshot();
				clickOnCreateNewAccountLink();
			}
			
		}
	

}
		
		
