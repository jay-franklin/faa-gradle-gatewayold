package faa.cucumber.pages;


import faa.utils.LogToFile;
import faa.utils.LogToFileCsv;
import faa.utils.CsvFile;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @authors jfranklin
 */
public class LoginPage extends BasePageObject {

	@FindBy(id = "loginField") private WebElementFacade loginField;
	@FindBy(id = "passwordField") private WebElementFacade passwordField;
	@FindBy(xpath = "//button[@id='loginButton' and @type='submit' and contains(text(), 'Login')]") private WebElementFacade submitButton;

	@FindBy(xpath = "//div[@class='alert alert-danger' and contains(text(),'Invalid username or password.')]") private WebElementFacade invalidUsernamePasswordMessage;
	
	static final String IAgreeButtonCssSelector = "div#systemUseModal div div div button.center-block.btn.btn-primary";

	/**Done button to be clicked to complete the payment process...  button[@class='btn btn-primary center-block' and contains(text(), 'Done')] **/
	@FindBy(xpath="//button[@id='agreeToNotice' and contains(text(), 'I Agree')]") private WebElementFacade iAgreeButton;
	
	@FindBy(xpath = "//button[@id='loginAccount' and contains(text(), 'Login')]") private WebElementFacade loginAccountButton;
	
	@FindBy(xpath = "//button[@id='loginButton' and contains(text(), 'Login')]") private WebElementFacade loginButton;
	
	@FindBy(xpath = "//a[@id='logout' and contains(text(), 'Logout')]") private WebElementFacade logoutButton;

	@FindBy(xpath = "//a[@id='forgotPassword']") private WebElementFacade forgotPassword;
	@FindBy(xpath = "//a[@id='createAccount']") private WebElementFacade createAccount;
	@FindBy(xpath = "//a[@id='resendVerification']") private WebElementFacade resendVerificationEmail;
	
	@FindBy(id = "email") private WebElementFacade emailTextField;
	@FindBy(xpath = "//button[@type='submit' and contains(text(), 'Send Email')]") private WebElementFacade sendEmailButton;
	@FindBy(xpath = "//a[@class='to-login' and contains(text(), 'Forgot Password')]") private WebElementFacade forgotPasswordLink;
			
	//IAgreeButton
	public void clickOnIAgreeButton() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to verify I Agree Button is visible... " + i);
			if (iAgreeButton.isCurrentlyVisible()){
				i = 4;
				iAgreeButton.click();//attempt to click the element
			System.out.println("I Agree button has been clicked. ");
			}
			else 
			{
			System.out.println("could not click I agree button.. Trying again in 3 seconds");
			waitABit(3000);//wait 3 seconds before trying to click again
			}
		}	
	}
	
	public void typeIntoLoginField(String inputText) {
		loginField.type(inputText);
	}
	public void typeIntoPasswordField(String inputText) {
		passwordField.type(inputText);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
		waitABit(1000);
		if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
			System.out.println("<---Invalid Password...Reenter new password--->");
			//typeIntoLoginField(randomLogin);
			typeIntoPasswordField("MyfaaDummy$11");
			submitButton.click();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()){ 
				typeIntoPasswordField("Dummy$11");
				submitButton.click();
			}
		}
		System.out.println("<---Logged in with an existing random account in Integration--->");
//		LogToFileCsv.write("GP-144\tIncorporate International Address Validation into Physical Address - Happy path");
//		LogToFileCsv.write("GP-143\tIncorporate US Address Validation into Mailing Address - Happy path");
//		LogToFileCsv.write("GP-142\tIncorporate US Address Validation into Physical Address - Happy path");
//		LogToFileCsv.write("GP-141\tUS Address Validation - UI Scenario 1");
//		LogToFileCsv.write("GP-140\tUS Address Validation - UI Scenario 2");
//		LogToFileCsv.write("GP-139\tUS Address Validation - UI Scenario 4");
//		LogToFileCsv.write("GP-138\tUS Address Validation - UI Scenario 5");
//		LogToFileCsv.write("GP-137\tInternational Address Validation - UI Scenario 2");
//		LogToFileCsv.write("GP-136\tInternational Address Validation - UI Scenario 4");
//		LogToFileCsv.write("GP-135\tUS Address Validation - UI Scenario 3");
//		LogToFileCsv.write("GP-134\tInternational Address Validation - UI Scenario 3");
//		LogToFileCsv.write("GP-133\tInternational Address Validation - UI Scenario 1");
//		LogToFileCsv.write("GP-108\tView Shopping Cart by Logged in User vs Org");
//		LogToFileCsv.write("GP-99\tAdd User");
//		LogToFileCsv.write("GP-97\tInvited Users Tile");
//		LogToFileCsv.write("GP-96\tActive Users Tile");
//		LogToFileCsv.write("GP-64\t50 Item Shopping Cart Limit");
//		LogToFileCsv.write("GP-32\tEdit Registered UAS");
//		LogToFileCsv.write("GP-27\tRemove Shopping Cart UAS");
//		LogToFileCsv.write("GP-26\tClone UAS (Shopping Cart and Registered Inventory)");
//		LogToFileCsv.write("GP-25\tEdit Shopping Cart UAS");
//		LogToFileCsv.write("GP-20\tCentralized User Profile (View/Edit)");
//		LogToFileCsv.write("GP-16\tChange Primary Email in gateway");
//		LogToFileCsv.write("GP-15\tChange Password in Gateway");		
		


	}
	
	
	//logOutButton
	public void ClickOnLogoutButton() {
		logoutButton.click();
	}
	
	//loginButton
	public void ClickOnLoginButton() {
		loginAccountButton.click();

	}
	
	//resendVerificationEmail
	public void clickOnResendVerificationEmailButton() {
		waitABit(1000);
		resendVerificationEmail.click();
	}
	
	//emailTextField used as part of resend email verification test
	public void typeIntoEmailTextField(String GmailFaaDroneEmailAccount) {
		emailTextField.clear();
		emailTextField.type(GmailFaaDroneEmailAccount);
		System.out.println("Email address has been entered" + GmailFaaDroneEmailAccount);
	}
	
	//click the Send Email Button to allow user to receive email to reverify their account
	public void clickOnSendEmailButton() {
		sendEmailButton.click();
	}

	public void clickOnForgotPasswordLink() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(3000);
			System.out.println("Loop Count to verify Account Registration... " + i);
			if (forgotPasswordLink.isCurrentlyVisible()){
				i = 4;
				forgotPasswordLink.click();//attempt to click the element
			System.out.println("Forgot Password Link has been clicked. ");
			}
			else 
			{
			System.out.println("could not click Forgot Password element.. Trying again in 3 seconds");
			waitABit(3000);//wait 3 seconds before trying to click again
			}
		}	
	}


}
