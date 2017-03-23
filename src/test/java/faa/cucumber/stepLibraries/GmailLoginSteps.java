package faa.cucumber.stepLibraries;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.webdriver.stubs.WindowStub;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

//import org.seleniumhq.jetty9.http.DateGenerator;

import cucumber.api.java.en.Then;
//import com.jayway.restassured.RestAssured;
import faa.utils.*;
//import faa.cucumber.pages.MenuPage;
import faa.cucumber.pages.NewAccountPage;
import faa.cucumber.pages.FaaHomePage;
import faa.cucumber.pages.GmailLoginPage;
import faa.cucumber.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/** @author jfranklin */
public class GmailLoginSteps extends ScenarioSteps {
	private static final long serialVersionUID = -4504654965851163432L;

//	FaaHomePage faaHomePage;
//	MenuPage menuPage;
	LoginPage loginPage;
	NewAccountPage newAccountPage;
	GmailLoginPage gmailLoginPage;
	FaaHomePage  faaHomePage;

	public static Properties serenityProperties;


//	@Step
//	public void navigateToThefaaHomePage() {
//		loadSerenityProperties();
//		String Url = getfaaUrl();
//		faaHomePage.openAt(Url);
//	}
//
//	private String getfaaUrl() {
//		URL faaUrl = null;
//		try {
//			faaUrl = new URL(serenityProperties.getProperty("app.base.protocol"),
//					serenityProperties.getProperty("app.base.host"),
//					//Integer.parseInt(serenityProperties.getProperty("app.base.port")),
//					serenityProperties.getProperty("app.base.loginPath"));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//			System.out.println("There was a problem creating the URL for faa");
//		}
//		return faaUrl.toString();
//	}
//
//	private static void loadSerenityProperties() {
//		serenityProperties = new Properties();
//		FileInputStream in;
//		try {
//			in = new FileInputStream("serenity.properties");
//			serenityProperties.load(in);
//			in.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("Error reading serenity.properties file");
//		}
//
//	}

// Begin of gmail
	@Step
	public void navigateToGmailLoginPage() {
		loadGmailSerenityProperties();
		String Url = getgmailUrl();
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		gmailLoginPage.openAt(Url);
		//Then you want to search for any new handles that may be present (there should now be 2)
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
		}
		for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().manage().window().maximize();  //  switchTo().window(winHandle);
		}

		
	}

	private String getgmailUrl() {
		URL faaUrl = null;
		try {
			faaUrl = new URL(serenityProperties.getProperty("app.gmailbase.protocol"),
					serenityProperties.getProperty("app.gmailbase.host"),
					//Integer.parseInt(serenityProperties.getProperty("app.gmailbase.port")),
					serenityProperties.getProperty("app.gmailbase.loginPath"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("There was a problem creating the URL for Gmail Login");
		}
		return faaUrl.toString();
	}

	private static void loadGmailSerenityProperties() {
		serenityProperties = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("serenity.properties");
			serenityProperties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error reading serenity.properties file for Gmail Login");
		}

	}
	
//End of gmail	
	
	@Step
	public void clickOnGmailSignInButton(){
		gmailLoginPage.ClickOnGmailSignInButton(); 
		System.out.println("Confirmed click on the gmail login Button. ");
		//waitABit(2000);
		//loginPage.clickOnIAgreeButtonButton();
	}
	@Step
	public void clickOnGmailInbox(){
		gmailLoginPage.clickOnGmailInboxEmailLink();
		System.out.println("Confirmed click on the Gmail Inbox Button. ");
	}
	
	@Step
	public void clickOnAcceptYourInvitation(){
		gmailLoginPage.clickOnAcceptYourInvitation();
	}
	
	
	@Step
	public void clickOnSelectAllFromGmailInbox(){
		gmailLoginPage.clickOnGmailInboxEmailLink();
		System.out.println("Confirmed click on the Gmail Inbox Button. ");
	}

		
	@Step
	public void clickOnInboxMessageToConfirmAccount(){
		//gmailLoginPage.clickOnGmailInboxEmailLink();
		gmailLoginPage.clickOnGmailLinkToConfirmAccount();
		System.out.println("Confirmed click on the Gmail Inbox Message. ");
	}

	@Step
	public void clickOnInboxMessagePrimaryEmailChange(){
		//gmailLoginPage.clickOnGmailInboxEmailLink();
		gmailLoginPage.clickOnGmailLinkToChangePrimaryEmail();
		System.out.println("Confirmed click on the Gmail Inbox Message --Primary Email Change");
	}

	
	
	
	
	@Step
	public void clickOnInboxMessageToConfirmLinkAccount(){
		gmailLoginPage.gmailEmailLinkToConfirmNewAccount();
		System.out.println("Confirmed click on the Gmail Inbox Message Link. ");
	}
	
	//Account verify email message
	@Step
	public void gmailEmailLinkToVerifyAccountRegistration(){
		gmailLoginPage.gmailEmailLinkToVerifyAccountRegistration();
		System.out.println("Confirmed click on the Gmail Inbox Message Account Verified Message. ");
		
	}

	//faaExitingEmailDisplayed
	
	
	
	//click on the I Agree button
	@Step
	public void clickOnIAgreeButton(){
		loginPage.clickOnIAgreeButton();
		System.out.println("Confirmed click on the I Agree Button ");
	}
	
	@Step
	public void clickOnGmailDeleteMessageButton(){
		gmailLoginPage.clickOnGmailDeleteMessageButton();
		System.out.println("Confirmed click on the Gmail Delete Message Button");
	}
	
	@Step
	public void clickSelectOptionFromGmailMenu(){
		gmailLoginPage.clickOnGmailSelectOptionMenu();
		System.out.println("Select Menu Option from Gmail");
	}
	
	@Step
	public void clickSelectAllOptionFromGmailMenu(){
		gmailLoginPage.clickOnGmailSelectAllOptionMenu();
		waitABit(2000);
		System.out.println("Select All Menu Option from Gmail");
	}
	@Step
	public void clickToCloseBrowserTabs(){
		waitABit(2000);
		gmailLoginPage.closeBrowserTabs();
		System.out.println("Confirmed click on the close browser tabs");
	}
	@Step
	public void clickToSwitchBrowserTabs(){
		waitABit(2000);
		gmailLoginPage.clickToSwitchBrowserTabs();
	}
	
//		//This is a string identifier for the current window so that we can find it later
//		String windowHandleBefore = getDriver().getWindowHandle();
//        //System.out.println("Title 2-->" + getTitle());
//		gmailLoginPage.switchBrowserTabs();
//		//Then you want to search for any new handles that may be present (there should now be 2)
//		for (String winHandle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(winHandle);
//		}
//		System.out.println("Confirmed click on the Switch browser tabs");
//	}

	@Step
	public void clickToOpenNewBrowserTab(){
		waitABit(2000);
		gmailLoginPage.clickToOpenNewBrowserTab();
	}	
//		//This is a string identifier for the current window so that we can find it later
//		String windowHandleBefore = getDriver().getWindowHandle();
//        System.out.println("WindowHandleBefore 1-->" + windowHandleBefore);
//		//gmailLoginPage.openNewBrowserTab();
//		//Then you want to search for any new handles that may be present (there should now be 2)
////		for (String winHandle : getDriver().getWindowHandles()) {
////            getDriver().switchTo().window(winHandle);
////            System.out.println("winHandle 2-->" + winHandle);
////		}
//		System.out.println("Confirmed opening of a new browser tab");
//		System.out.println("WindowHandleBefore 3-->" + windowHandleBefore);
//	}
	
	
	
	
	
	@Step
	public void clickToCloseBrowserWindow(){
		waitABit(2000);
		gmailLoginPage.closeBrowserWindow();
		System.out.println("Confirmed close browser Window");
	}
	
	
	
	@Step
	public void clickToLogOutOfGmailButton(){
		//waitABit(2000);
		gmailLoginPage.clickOnGmailAccountToSignOutButton();
		gmailLoginPage.clickOnGmailSignOutButton();
		System.out.println("Confirmed click on the Gmail Log Out Button. ");
		
	}
//	
//	
	/** if you need to log in with a specific user
	 * 
	 * @param username
	 * @param password */
	@Step
	public void goToGmailAndLogInUsingCredentials(String password) {
		waitABit(1000);
		System.out.println("The Password to be entered from goToGmailAndLogInUsingCredentials is " + password);
//		try {
			gmailLoginPage.typeIntoGmailPasswordField(password);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
		System.out.println("The Password has been entered correctly " + password);
		///////////gmailLoginPage.ClickOnGmailSignInButton();
		System.out.println("The Gmail Sign In button has been entered correctly " + password);
		
	}

	/** <p>
	 * This will allow you to sign in as different users. If the DB is updated
	 * or changed its possible that the user names need to be updated or added.
	 * </p>
	 * 
	 * <p>
	 * do not use this if you want to log in with new users use:
	 * logsInUsingCredentials(username, password)
	 * </p>
	 * 
	 * @param role
	 *            - the role you would like to sign in as */
	@Step
	public void goToGmailAndSignInAs(String accountType) {
		accountType = accountType.toLowerCase();
		//navigateToThefaaHomePage();
		switch (accountType) {

		case "myfaadrone@gmail.com":
			try {
				gmailLoginPage.typeIntoGmailPasswordField("Dummy$11");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // typeIntoPasswordField(password);


		default:
			assertThat(true).overridingErrorMessage("Tried to login as invalid user type: " + accountType).isFalse();
			break;
			

		}
		gmailLoginPage.ClickOnGmailSignInButton();
		waitABit(1000);
	}
	
	
	@Step
	public void gmailLinkToForgotPassword(){
		gmailLoginPage.gmailLinkToForgotPassword();
		System.out.println("Confirmed click on the Forgot Your Password Gmail Inbox Message. ");
		//gmailLoginPage.closeBrowserTabs();
	}

	
	@Step
	public void gmailClickToResetPassword(){
		gmailLoginPage.gmailClickToResetPassword();
		System.out.println("Confirmed click on the email to reset Your Password Gmail Inbox Message. ");
	}
	
	
	@Step
	public void typeGmailEmailAddressField(String input){
		gmailLoginPage.typeIntoEmailField(input);
	}
	
	@Step
	public void typeGmailEmailFaaNewAddressField(String input){
		gmailLoginPage.typeIntoNewFaaEmailField(input);
	}
	
	
	@Step
	public void typeNewGmailEmailAddress(String input){
		gmailLoginPage.typeIntoGmailEmailAddressField(input);
	}
	
	@Step
	public void clickOnGmailConfirmationMessage(){
		gmailLoginPage.clickOnConfirmationGmailMessage();
		
	}
	
	@Step
	public void clickOnGmailMessage(){
		gmailLoginPage.clickOnGmailMessage();
	}
	
	@Step
	public void clickOnGmailMessageToVerifyAccount(){
		gmailLoginPage.clickGmailAccountVerifiedMessageForResult(1);    //.clickOnGmailMessageToVerifyAccount();
	}
	
	@Step
	public  void clickOnFirstGmailMessageFromInbox(){
		gmailLoginPage.clickOnFirstGmailMessageFromInbox();
		System.out.print("Click On first Email message");
		gmailLoginPage.clickOnGmailMessageToVerifyAccount();
		gmailLoginPage.clickOnGmailAccountToSignOutButton();
		System.out.print("Click On Gmail Log Out button ");
		gmailLoginPage.clickOnGmailSignOutButton();
		System.out.print("Click On Gmail Sign Out button");
	}
	
	
	@Step
	public void logOutOffaa() {
		// TODO finish this method
	}

}

