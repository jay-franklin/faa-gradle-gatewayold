package faa.cucumber.maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import faa.cucumber.pages.LoginPage;
import faa.cucumber.stepLibraries.BaseUserSteps;
import faa.cucumber.stepLibraries.GmailLoginSteps;
//import faa.cucumber.stepLibraries.MenuUser;
import faa.utils.DataGenerator;
import net.thucydides.core.annotations.Managed;
//import faa.cucumber.stepLibraries.click;
//import faa.cucumber.stepLibraries.inbox;
//import faa.cucumber.stepLibraries.to;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
//make sure have correct import statements - I had to add these
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationMap {
	@Steps BaseUserSteps baseUserSteps;
	@Steps GmailLoginSteps gmailLoginSteps;
//	@Managed(driver = "chrome") WebDriver driver;
	
	String newGmailEmailAccount = "mynewfaadrone+" + DataGenerator.randomIntegerBetween(10,4000) + "@gmail.com";

	
	@Given("i have accessed the gmail login page")
	public void gmail_login() {
		gmailLoginSteps.navigateToGmailLoginPage();
		System.out.println("On the Gmail Login page. ");
	}

	@When("i log on using newly created email address")
	public void when_i_enter_gmail_email_address() {
			gmailLoginSteps.typeGmailEmailAddressField("mynewfaadrone@gmail.com");
			System.out.println("mynewfaadrone@gmail.com email address entered");
		}

	@When("i log on to gmail as mynewfaadrone@gmail.com email address")
	public void log_in_to_gmail_as_newfaa_email_address() {
//			WebDriver driver = new ChromeDriver();
//			driver.manage().window().maximize();
			gmailLoginSteps.typeGmailEmailFaaNewAddressField("mynewfaadrone@gmail.com");
			System.out.println("mynewfaadrone@gmail.com email address entered");
		}

	
	
	@When("i enter my gmail password '(.*)'")
	public void when_i_enter_gmail_password(String password) {
			gmailLoginSteps.goToGmailAndLogInUsingCredentials(password);
//			String newxxGmailAccountVariable = Serenity.sessionVariableCalled(newGmailEmailAccount).toString();
//			System.out.println("myxxxEmail Gmail address of new account is " + newxxGmailAccountVariable);
	}
	
	@Then("i click on the gmail inbox")
	public void click_on_gmail_inbox() {
		gmailLoginSteps.clickOnGmailInbox();
	}
	
	@Then("click to Accept Your Invitation")
	public  void click_on_accept_your_invitation(){
		gmailLoginSteps.clickOnAcceptYourInvitation();
	}
	
	@Then("open a new Browser Tab")
	public void click_to_open_new_browser_tab(){
		gmailLoginSteps.clickToOpenNewBrowserTab();
		
	}
	
	
	
	//clickToSwitchBrowserTabs
	@Then("switch to another browser tab")
	public void click_to_switch_browser_tabs(){
		gmailLoginSteps.clickToSwitchBrowserTabs();
	}
	
	
	@Then("i select and delete all messages from the inbox")
	public void selectAllFromGmailMenu() {
		gmailLoginSteps.clickSelectOptionFromGmailMenu();
		//gmailLoginSteps.clickSelectAllOptionFromGmailMenu();
		System.out.println("Select All messages to delete Option.");
		gmailLoginSteps.clickOnGmailDeleteMessageButton();
		System.out.println("Select Delete Messages Button");
	}

	
	@When("i click on the gmail signin button")
	public void when_click_gmail_signin_button() {
		gmailLoginSteps.clickOnGmailSignInButton(); 
		gmailLoginSteps.waitABit(1000);
	}

	
	@Then("i click on the gmail confirmation email")
	public void the_click_gmail_confirmation_message() {
		gmailLoginSteps.clickOnGmailConfirmationMessage(); 
		System.out.println("Confirmation message has been clicked. ");
		gmailLoginSteps.waitABit(1000);
	}

	@Then("i click on the account verifed gmail message")
	public void click_account_verified_gmail_essage() {
		gmailLoginSteps.clickOnGmailMessageToVerifyAccount();
		System.out.println("Verify the Account verified gmail message has been clicked. ");
		gmailLoginSteps.waitABit(1000);
	}

	@Then("i click on inbox message to confirm account")
	public void click_inbox_confirm_gmail_message() {
		gmailLoginSteps.waitABit(1000);
		gmailLoginSteps.clickOnInboxMessageToConfirmAccount();
		//Serenity.takeScreenshot();
		System.out.println("Verify the Account gmail inbox message has been clicked.");
		System.out.println("3 Second Delay");
		gmailLoginSteps.waitABit(3000);
		System.out.println("3 Second Delay ends");
	}	
	
	
	//clickOnInboxMessagePrimaryEmailChange()
	@Then("i click on inbox message for Primary Email Change")
	public void clickOnInboxMessagePrimaryEmailChange() {
		gmailLoginSteps.waitABit(1000);
		gmailLoginSteps.clickOnInboxMessagePrimaryEmailChange();
		//Serenity.takeScreenshot();
		System.out.println("Click the Primary Email Change gmail inbox message.");
		System.out.println("3 Second Delay");
		gmailLoginSteps.waitABit(3000);
		System.out.println("3 Second Delay ends");
	}	

	

	@Then("i click on email link to confirm account")
	public void click_inbox_confirm_gmail_message_Link() {
		gmailLoginSteps.clickOnInboxMessageToConfirmLinkAccount();
		////Serenity.takeScreenshot();
		System.out.println("Verify the Account gmail inbox message Link has been clicked2. ");
		System.out.println("3 Second Delay");
		gmailLoginSteps.waitABit(3000);
		System.out.println("3 Second Delay ends");
		//gmailLoginSteps.clickOnIAgreeButton();
		//System.out.println("The I Agree Button has been clicked. ");
		/////////gmailLoginSteps.clickToSwitchBrowserTabs();
		////Serenity.takeScreenshot();
		//gmailLoginSteps.clickOnGmailDeleteMessageButton();
		//gmailLoginSteps.clickOnGmailInbox();
		
	
	}	
//	Then i click open email that verifies account registration
	@Then("i click open email that verifies account registration")
	public void click_inbox_gmail_message_to_verify_account() {
		//gmailLoginSteps.clickToSwitchBrowserTabs();
		gmailLoginSteps.clickOnGmailInbox();
		//gmailLoginSteps.waitABit(5000);
		////Serenity.takeScreenshot();
		gmailLoginSteps.gmailEmailLinkToVerifyAccountRegistration();
		System.out.println("Verify the Account gmail inbox message Link has been clicked. ");
		gmailLoginSteps.waitABit(5000);
		System.out.println("Only to Display the New Account Email address1111!!!!!!");
	}	
	

	
	@Then("i click on inbox message Forgot your password")
	public void click_inbox_gmail_message_forgot_your_password() {
		gmailLoginSteps.waitABit(1000);
		gmailLoginSteps.gmailLinkToForgotPassword();
		System.out.println("Verify the Forgot Password gmail inbox message has been clicked. ");
		gmailLoginSteps.waitABit(1000);
	}	
	
	@Then("i sign out of gmail")
	public void gmail_sign_out_button() {
		gmailLoginSteps.clickToLogOutOfGmailButton();
	}

	@Then("i close the browser window")
	public void close_browser_window() {
		gmailLoginSteps.clickToCloseBrowserWindow(); 
	}

	
	@Given("i have accessed the welcome page")
	public void given_welcome() {
		baseUserSteps.navigateToTheFaaHomePage();
		baseUserSteps.waitABit(100);
	}
	@Given("access the welcome page (.*)$")
//	@Given("i have accessed the welcome page <number>")
	public void given_welcome_multiple(String number) {
		baseUserSteps.navigateToTheFaaHomePage();
		baseUserSteps.waitABit(100);
	}
	
	@When("i have log in as Username: '(.*)' with Password: '(.*)'")
	public void given1(String username, String password) {
		//baseUserSteps.goTofaaAndLogInAsA(userRole);
		baseUserSteps.goTofaaAndLogInUsingCredentials(username, password);
	}

	
	@Then("i click on the I Agree button")
	public void clickOnIAgreeButton(){
		baseUserSteps.clickOnIAgreeButton();
	}
	
	@When("i click on the Login button")
	public void when_click_login_button() {
		baseUserSteps.clickOnLogInButton();
		baseUserSteps.waitABit(1000);
//		baseUserSteps.clickOnIAgreeButton();
	}

	@Then("i log on using username: '(.*)'")
    public void iLoginWithUsername(String userEmail) {
    	baseUserSteps.goTofaaAndLogInAs(userEmail); 
    }

	@Then("i log in as '(.*)'")
	public void iloginAsUsername(String existingUser){
		baseUserSteps.logInWithExistingUser(existingUser);
		
	}

	@Then("log in with existing random account")
	public void iloginWithRandomAccount(){
		baseUserSteps.logInWithExistingRandomAccount();
	}
	
	//logInWithExistingNonHobbistRandomAccount
	@Then("log in with random non hobbyist account")
	public void iloginWithRandomNonHobbyistAccount(){
		baseUserSteps.logInWithExistingNonHobbyistRandomAccount();
	}
	@Then("log in with random account to change primary email")
	public void iloginWithRandomAccountChangePrimaryEmail(){
		baseUserSteps.logInWithExistingRandomAccountChangePrimaryEmail();
	}

	//Then login as org admin with expired users
	@Then("login as active user in org with expired users")
	public void iloginAsUserWithExpiredInvitedUsers(){
		baseUserSteps.loginAsUserWithExpiredInvitedUsers();
	}

	@Then("log in with random hobbyist account")
	public void iloginWithRandomHobbyistAccount(){
		baseUserSteps.logInWithExistingHobbyistRandomAccount();
	}

	@Then("log in with random gateway hobbyist account")
	public void iloginWithRandomGatewayHobbyistAccount(){
		baseUserSteps.logInWithRandomGatewayHobbyistAccount();
	}

	@Then("log in with random gateway non hobbyist account")
	public void iloginWithRandomGatewayNonHobbyistAccount(){
		baseUserSteps.logInWithExistingGatewayNonHobbyistRandomAccount();
	}
	
	@Then("log in with random account to update personal and organization info")
	public void loginWithRandomGatewayPersonalAndOrgProfile(){
		baseUserSteps.logInRandomNonHobbyistPersonalAndOrgProfile();
	}
	
	

	@Then("log in with gateway hobbyist account to cancel registration")
	public void iloginWithGatewayHobbyistAccountCancelRegistration(){
		baseUserSteps.logInWithGatewayHobbyistAccountCancelRegistration();
	}
	
	
	@Then("validate the random hobbyist account")
	public void validateRandomHobbyistAccount(){
		baseUserSteps.validateExistingHobbyistAccount();
	}
	@Then("validate the random non hobbyist account")
	public void validateRandomNonHobbyistAccount(){
		baseUserSteps.validateExistingNonHobbyistAccount();
	}
	
	
	@Then("login as '(.*)'")
	//mynewfaadrone+nh1237@gmail.com
	public void loginAsExistingUser(String existingUser){
		baseUserSteps.logInAsExistingUser(existingUser);
	}
	
	//Access to the Manage Access Tool
	//i log in as admin using 'mynewfaadrone+JayAdmin@gmail.com'
	@Then("i log in as admin using '(.*)'")
	public void iloginAsAdminUsername(String existingAdminUser){
		baseUserSteps.logInAsAdminWithExistingUserAccount(existingAdminUser);
	}

	@Then("click on the Contact Information option")
	public void contactInformationButton(){
		baseUserSteps.clickOnContactInformationButton();
	}

	
//	//verifyInternationalCallerEquals();
//	@Then("click on International Caller")
//	public void verifyInternationalCallerEqualsButton(){
//		baseUserSteps.clickOnContactInternationalCallerButton();
//	}

	//verifycontactInformationEmailEquals();
	@Then("click on email")
	public void verifyContactInformationEmailEqualsButton(){
		baseUserSteps.clickOnContactEmailButton();
	}
//
//	//verifycontactInformationPhoneEquals();
//	@Then("click on phone")
//	public void verifyContactInformationPhoneEqualsButton(){
//		baseUserSteps.clickOnContactPhoneButton();
//	}
//
//	//verifycontactInformationFaqsEquals();
	@Then("click on faqs")
	public void verifyContactInformationFaqsEqualsButton(){
		baseUserSteps.clickOnContactFaqsButton();
	}

	
	@Then("click on Footer Menu RegisterByPaperButton")
	public void footerMenuRegisterByPaperButton(){
		baseUserSteps.clickOnFooterMenuRegisterByPaperButton();
	}

	@Then("click on Footer Menu RegisterByPaperLink")
	public void footerMenuRegisterByPaperLink(){
		baseUserSteps.clickOnFooterMenuRegisterByPaperLink();
	}
	//clickOnFooterMenuPasrnLink
	@Then("click on Footer Menu PasrnLink")
	public void footerMenuPasrnLink(){
		baseUserSteps.clickOnFooterMenuPasrnLink();
	}
	
	@Then("click on Footer Menu Dot")
	public void footerMenuDot(){
		baseUserSteps.clickOnFooterMenuDot();
	}
	
	
	
	@Then("click on Footer Menu WebPolicies")
	public void clickOnFooterMenuWebPolicies(){
		baseUserSteps.clickOnFooterMenuWebPolicies();
	}
	@Then("click on Footer Menu PrivacyPolicy")
	public void clickOnFooterMenuPrivacyPolicy(){
		baseUserSteps.clickOnFooterMenuPrivacyPolicy();
	}
	@Then("click on Footer Menu Accessibility")
	public void clickOnFooterMenuAccessibility(){
		baseUserSteps.clickOnFooterMenuAccessibility();
	}
	@Then("click on Footer Menu Transportation")
	public void clickOnFooterMenuTransportation(){
		baseUserSteps.clickOnFooterMenuTransportation();
	}
	@Then("click on Footer Menu Usa")
	public void clickOnFooterMenuUsa(){
		baseUserSteps.clickOnFooterMenuUsa();
	}
	@Then("click on Footer Menu Plainlanguage")
	public void clickOnFooterMenuPlainlanguage(){
		baseUserSteps.clickOnFooterMenuPlainlanguage();
	}
	@Then("click on Footer Menu Regulations")
	public void clickOnFooterMenuRegulations(){
		baseUserSteps.clickOnFooterMenuRegulations();
	}
	@Then("click on Footer Menu Data")
	public void clickOnFooterMenuData(){
		baseUserSteps.clickOnFooterMenuData();
	}
	@Then("click on Footer Menu Faq")
	public void clickOnFooterMenuFaq(){
		baseUserSteps.clickOnFooterMenuFaq();
	}
	@Then("click on Footer Menu AllQuestions")
	public void clickOnFooterMenuAllQuestions(){
		baseUserSteps.clickOnFooterMenuAllQuestions();
	}
	@Then("click on Footer Menu ContactFaa")
	public void clickOnFooterMenuContactFaa(){
		baseUserSteps.clickOnFooterMenuContactFaa();
	}
	@Then("click on Footer Menu Oig")
	public void clickOnFooterMenuOig(){
		baseUserSteps.clickOnFooterMenuOig();
	}
	@Then("click on Footer Menu Foia")
	public void clickOnFooterMenuFoia(){
		baseUserSteps.clickOnFooterMenuFoia();
	}
	
	
	
	@Then("i log on using new email account")
    public void iLoginWithNewUsername() {
		String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
		System.out.println("Log in with New Account On Verify Account part of test  1111!!!!!!");
		System.out.println("Log in with New Account On Verify Account part of test  " + newFaaAcountEmail);
    	//baseUserSteps.goTofaaAndLogInAs(newFaaAcountEmail); 
    	baseUserSteps.logInWithNewlyCreatedEmailAccount(newFaaAcountEmail);
      }
	
	@Given("i navigate to the FAA UAS welcome page")
	public void clickNewAccountLink() {
		baseUserSteps.navigateToTheFaaHomePage();
		baseUserSteps.waitABit(100);
	}
	
	@Given("navigate to the login page (.*)$")
	public void clickNewAccountLink(String number) {
		baseUserSteps.navigateToTheFaaHomePage();
		baseUserSteps.waitABit(100);
	}

	@When("i click on Create New Account button")
	public void createNewAccount(){
		baseUserSteps.clickOnCreateAccountButton();
		System.out.println("Confirmed user clicked on the Create Account button. ");
	}

	@When("i create a new account")
	public void createNewHobbyistGatewayAccount(){
		baseUserSteps.clickOnCreateAccountButton();
		System.out.println("Confirmed user clicked on the Gateway appliction new Account button. ");
	}

	
	
	@Then("i enter a new hobbyist account email address")
	public void typeIntoHobbyistEmailAddressField(){
		baseUserSteps.waitABit(100);
		System.out.println("Confirmed new Email Address entered. ");
		baseUserSteps.typeIntoNewHobbyistAccountEmailAddressField();   
		baseUserSteps.waitABit(100);
	}

	@Then("enter a new non hobbyist account email address")
	public void typeIntoNonHobbyistEmailAddressField(){
		baseUserSteps.waitABit(100);
		System.out.println("Confirmed new Email Address entered. ");
		baseUserSteps.typeIntoNewNonHobbyistAccountEmailAddressField();   
		baseUserSteps.waitABit(1000);
	}
	
	
	@Then("i enter a new non hobbyist account upper case email address")
	public void typeIntoNewNonHobbyistAccountInvalidEmailAddressField(){
		baseUserSteps.waitABit(100);
		System.out.println("Confirmed new Email Address entered. ");
		baseUserSteps.typeIntoNewNonHobbyistAccountInvalidEmailAddressField();   
		baseUserSteps.waitABit(100);
	}

	
	
	@Then("i enter a new account password '(.*)'")
	public void typeIntoNewAccountPasswordField(String newPassword){
		baseUserSteps.typeIntoNewAccountPasswordField(newPassword);
		System.out.println("Confirmed new password entered. "+ newPassword );
		baseUserSteps.waitABit(100);
	}
	@Then("i confirm a new account passord '(.*)'")
	public void typeIntoNewAccountConfirmPasswordField(String confirmPassword){
		baseUserSteps.typeIntoNewAccountConfirmPasswordField(confirmPassword);	
		System.out.println("Confirmed New password entered. "+ confirmPassword);
		baseUserSteps.waitABit(100);
	}
	@Then("click the Create Account button")
	public void clickOnCreateAccountButton(){
		baseUserSteps.clickOnCreateAccountButton();
		System.out.println("Confirmed click on the New Account Button. ");
	}

	
	@Then("i click on Create New Account link")
	public void clickOnCreateNewAccountLink(){
		baseUserSteps.clickOnCreateNewAccountLink();
		System.out.println("Confirmed click on the Creat New Account Link.");
	}

	
	
	@Then("i verify the account is created")
	public void verifyAlmostDoneMessageIsDisplayed(){
		baseUserSteps.verifyAccountCreation();
		System.out.println("Confirmed verify New Account message is displayed. ");
		
	}
	@Then("Account already exists")
	public void verifyAlmostExistsMessageIsDisplayed(){
	}
	@Then("i click on the resend verification email link")
	public void clickOnResendVerificationEmailLink(){
		baseUserSteps.clickOnResendVerificationEmailButton();
	}
	
	@Then("i click the forgot password link")
	public void clickOnForgotPasswordLink(){
		baseUserSteps.clickOnForgotPasswordLink();
	}
	
	
	@Then("i type email address to receive verification")
	public void typeIntoResendEmailVerificationField(){
//		String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
//		System.out.println("On Verify Account part of test  1111!!!!!!");
//		System.out.println("On Verify Account part of test  " + newFaaAcountEmail);
//    	baseUserSteps.goTofaaAndLogInAs(newFaaAcountEmail); 
//    	//baseUserSteps.logInWithNewlyCreatedEmailAccount(newFaaAcountEmail);
		System.out.println("Type Into Resend Email Verification Field");
		baseUserSteps.typeIntoResendEmailVerificationField();
	}
	
		
	@Then("i type email address from forgot password page")
	public void typeIntoForgotPasswordEmailField(){
		System.out.println("Type Into Email from the Forgot Password page");
		baseUserSteps.typeIntoForgotPasswordEmailField();
	}
	
//	gmailClickToResetPassword
	@Then("i click email message to reset password")
	public void gmailClickToResetPassword(){
		System.out.println("Click the Forgot Your Password Email");
		baseUserSteps.gmailClickToResetPassword();

	}
	
	@Then("i click the send button")
	public void clickOnSendEmailButton(){
		baseUserSteps.clickOnSendEmailButton();
	}
	
	@Then("i enter and confirm new password")
	public void enterAndConfirmNewPassword(){
		System.out.println("Enter and Confirm New Password");
		baseUserSteps.enterAndConfirmNewPassword();
	}
		
	
	
	@Given("show random values")
	public void given_temp() {

		baseUserSteps.navigateToTheFaaHomePage();
		baseUserSteps.waitABit(100);
		
	}

	
	
	
	
	
	
	
		// Will direct to Menu Selection Page
//	public void clickMenuSelection(String menuSelection){
//			
//		switch (menuSelection.toLowerCase()) {
//
//		// Selects Menu Item from Administration
//		case ("manage users"):
//			menuUser.clickManageUsersFromAdministration();
//			break;
//
//		case ("list of administrators"):
//			menuUser.clickManageUsersFromAdministration();
//			break;
//			
//		case ("list of employees"):
//			menuUser.clickListOfEmployeesFromAdministration();
//			break;
//
//		case ("manage sites"):
//			menuUser.clickManageSitesFromAdministration();
//			break;
//
//		case ("list of sites"):
//			menuUser.clickListOfSitesFromAdministration();
//			break;
//
//		case ("manage holidays"):
//			menuUser.clickManageHolidaysFromAdministration();
//			break;
//
//		case ("audit logs"):
//			menuUser.clickAuditLogsFromAdministration();
//			break;
//
//		// Selects Menu Item from Schedules
//		case ("create schedules"):
//			menuUser.clickCreateSchedulesFromScheduling();
//			break;
//
//		case ("view schedules"):
//			menuUser.clickViewSchedulesFromScheduling();
//			break;
//
//		case ("manage appointments"):
//			menuUser.clickManageAppointmentsFromScheduling();
//			break;
//
//		case ("reschedule appointments"):
//			menuUser.clickRescheduleAppointmentsFromScheduling();
//			break;
//
//		case ("book appointments"):
//			menuUser.clickBookAppointmentsFromScheduling();
//			break;
//
//		case ("check in/check out"):
//			menuUser.clickCheckInCheckOutFromScheduling();
//			break;
//
//		// Selects the menu Item from Reports
//		case ("daily roster"):
//			menuUser.clickDailyRosterFromReports();
//			break;
//
//		case ("applicant history"):
//			menuUser.clickApplicantHistoryFromReports();
//			break;
//
//		case ("no show rate per site"):
//			menuUser.clickNoShowRateFromReports();
//			break;
//
//		case ("no show roster"):
//			menuUser.clickNoShowRosterFromReports();
//			break;
//
//		case ("applicant email list"):
//			menuUser.clickApplicantEmailListFromReports();
//			break;
//
//		case ("site look up by zipcode"):
//			menuUser.clickSiteLookupbyZipcodeFromReports();
//			break;
//
//		case ("usage statistics"):
//			menuUser.clickUsageStatisticsFromReports();
//			break;
//
//		// To be added in menu User
//		/*
//		 * case ("kiosk usage statistics"):
//		 * menuUser.clickKioskUsageStatisticsFromReports(); break;
//		 */
//
//		/*
//		 * case ("schedule monitor"):
//		 * menuUser.clickScheduleMonitorFromReports(); break;
//		 */
//
//		case ("customer search"):
//			menuUser.clickCustomerSearchFromReports();
//			break;
//
//		/*
//		 * case("zipcode statistics"):
//		 * menuUser.clickZipCodeStasticsFromReports();
//		 */
//
//		/*
//		 * case("appointment type statistics"):
//		 * menuUser.clickAppointmentTypeStatisticsFromReports();
//		 */
//
//		/*
//		 * case("language statistics"):
//		 * menuUser.clickLanguageStatisticsFromReport();
//		 */
//
//		default:
//			break;
//		}
//
//	}

//*	

}