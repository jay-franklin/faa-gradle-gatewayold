package faa.cucumber.stepLibraries;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.junit.annotations.Concurrent;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Then;
import faa.utils.*;
import gherkin.formatter.Reporter;
//import faa.cucumber.pages.MenuPage;
import faa.cucumber.pages.NewAccountPage;
//import faa.cucumber.pages.typeIntoLoginField;
import faa.cucumber.pages.CreateNewProfilePage;
import faa.cucumber.pages.FaaHomePage;
import faa.cucumber.pages.GmailLoginPage;
import faa.cucumber.pages.LoginPage;


/** @author jfranklin */
public class BaseUserSteps extends ScenarioSteps {
	private static final long serialVersionUID = -4504654965851163432L;
	
	FaaHomePage faaHomePage;
//	MenuPage menuPage;
	LoginPage loginPage;
	NewAccountPage newAccountPage;
	GmailLoginPage gmailLoginPage;
	CreateNewProfilePage createNewProfilePage;

	public static Properties serenityProperties;
//	@Managed  WebDriver driver;
//	@Managed(driver = "htmlunit") WebDriver driver;

	@Step
	public void navigateToTheFaaHomePage() {
		loadSerenityProperties();
		String Url = getfaaUrl();
		faaHomePage.openAt(Url);
	}

	private String getfaaUrl() {
		URL faaUrl = null;
		try {
			faaUrl = new URL(serenityProperties.getProperty("app.base.protocol"),
					serenityProperties.getProperty("app.base.host"),
					serenityProperties.getProperty("app.base.loginPath"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("There was a problem creating the URL for faa");
		}
		return faaUrl.toString();
	}

	private static void loadSerenityProperties() {
//		  final WebDriver driver = new HtmlUnitDriver();
//	    ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
		    
		serenityProperties = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("serenity.properties");
			serenityProperties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error reading serenity.properties file");
		}

	}

// Begin of gmail
	@Step
	public void navigateToGmailLoginPage() {
		loadGmailSerenityProperties();
		String Url = getgmailUrl();
		gmailLoginPage.openAt(Url);
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
	public void clickOnLogInButton(){
		loginPage.ClickOnLoginButton();
		System.out.println("Confirmed click on the gmail login Button. ");
	}
	
	@Step
	public void clickOnIAgreeButton(){
		loginPage.clickOnIAgreeButton();
		System.out.println("Confirmed click on the I Agree Button. ");
	}
	
	
	/** if you need to log in with a specific user
	 * 
	 * @param username
	 * @param password */
	@Step
	public void goTofaaAndLogInUsingCredentials(String username, String password) {
		waitABit(100);
		loginPage.typeIntoLoginField(username);
		loginPage.typeIntoPasswordField(password);
		loginPage.clickOnSubmitButton();
	}

	@Step
	public void logInWithNewlyCreatedEmailAccount(String username){
		loginPage.typeIntoLoginField(username);
		loginPage.typeIntoPasswordField("Dummy$11");
		loginPage.clickOnSubmitButton();
		System.out.println("Logged in Using newly created Email Account "+ username );
	}
	
	@Step
	public void clickOnResendVerificationEmailButton(){
		loginPage.clickOnResendVerificationEmailButton();
		System.out.println("Click On the Resend Verification Email Link");
	}

	@Step
	public void clickOnForgotPasswordLink(){
		loginPage.clickOnForgotPasswordLink();
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
	public void goTofaaAndLogInAs(String accountType) {
		accountType = accountType.toLowerCase();
		//navigateToThefaaHomePage();
		switch (accountType) {

		case "myfaadrone@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+1@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+1@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+2@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+2@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+3@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+3@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+140@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+140@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+177@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+177@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
		case "myfaadrone+331@gmail.com":
			loginPage.typeIntoLoginField("myfaadrone+331@gmail.com");
			loginPage.typeIntoPasswordField("Dummy$11");
			break;
			
		default:
			assertThat(true).overridingErrorMessage("Tried to login as invalid user type: " + accountType).isFalse();
			break;

		}
		loginPage.clickOnSubmitButton();
		waitABit(1000);
		//faaHomePage.clickOnUasRegistrationLink();
	}

	@Step
	public void logInWithExistingUser(String existingUser){
		loginPage.typeIntoLoginField(existingUser);
		loginPage.typeIntoPasswordField("Dummy$11");
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	@Step
	public void logInAsAdminWithExistingUserAccount(String existingAdminUser){
		loginPage.typeIntoLoginField(existingAdminUser);
		loginPage.typeIntoPasswordField("Dummy$11");
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	@Step
	public void logInAsExistingUser(String existingUser){
		loginPage.typeIntoLoginField(existingUser);
		loginPage.typeIntoPasswordField("Dummy$11");
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	
	
	@Step
	public void logInWithExistingRandomAccount(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("registermyuas-integration.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromIntegrationDB();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
		} else if (environment.equals("registermyuas-test.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromTestDB();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromStageDB();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		}
		System.out.println("Click Submit Button first");
		//Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	
	//getActiveUserWithExpiredInvitesFromIntegrationDB
	@Step
	public void loginAsUserWithExpiredInvitedUsers(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("registermyuas-integration.csra-dronezone.com")){
			System.out.println("Drone Zone Environment in integration--->" + environment);
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveUserWithExpiredInvitesFromIntegrationDB();
			System.out.println("Logging in with an existing random account in Integration--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);			                           
		} else if (environment.equals("registermyuas-test.csra-dronezone.com")){
			System.out.println("Drone Zone Environment in Test--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromTestDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Test--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			System.out.println("Drone Zone Environment in Stage--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromStageDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Stage--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		} 
		System.out.println("Click the Submit Button");
		//Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 
	
	@Step
	public void logInWithExistingNonHobbyistRandomAccount(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			System.out.println("Environment in integration--->" + environment);
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromIntegrationDB();
			System.out.println("Logging in with an existing random account in Integration--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);			                           
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			System.out.println("Environment in Test--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromTestDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Test--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			System.out.println("Environment in Stage--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromStageDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Stage--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		} 
		System.out.println("Click the Submit Button");
		//Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	
	@Step
	public void logInWithExistingGatewayNonHobbyistRandomAccount(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			System.out.println("Gateasy Environment in integration--->" + environment);
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginIntegration();
//			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromIntegrationDB();
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromGatewayIntegrationDB();
			System.out.println("Logging in with an existing random account in Integration--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);			                           
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			System.out.println("Environment in Test--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromTestDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Test--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			System.out.println("Environment in Stage--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromStageDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Stage--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		} 
		System.out.println("Click the Submit Button");
		//Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 
	

	@Step
	public void logInRandomNonHobbyistPersonalAndOrgProfile(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			System.out.println("Gateasy Environment in integration--->" + environment);
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveNonHobbyistPersonalAndOrgProfile();
			//String randomLogin = DataGenerator.getActiveNonHobbyistUserFromGatewayIntegrationDB();
			System.out.println("Logging in with an existing random account in Integration--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);			                           
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			System.out.println("Environment in Test--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromTestDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Test--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			System.out.println("Environment in Stage--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistUserFromStageDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Stage--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		} 
		System.out.println("Click the Submit Button");
		////Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 

	
	
	
	
	@Step
	public void logInWithExistingRandomAccountChangePrimaryEmail(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("registermyuas-integration.csra-dronezone.com")){
			System.out.println("Environment in integration--->" + environment);
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveNonHobbyistCpeUserFromIntegrationDB();
			System.out.println("Logging in with an existing random account in Integration--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);			                           
		} else if (environment.equals("registermyuas-test.csra-dronezone.com")){
			System.out.println("Environment in Test--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistCpeUserFromTestDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Test--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.csra-dronezone.com")){
			System.out.println("Environment in Stage--->" + environment);
			String randomLogin = DataGenerator.getActiveNonHobbyistCpeUserFromStageDB();
			//String randomLogin = DataGenerator.getRandomNonHobbyistEmailLoginTest();
			System.out.println("Logging in with an existing random account in Stage--->" + randomLogin);
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
		} 
		System.out.println("Click the Submit Button");
		//Serenity.takeScreenshot();
		loginPage.clickOnSubmitButton();
		waitABit(1000);
	} 
	
	@Step
	public void logInWithExistingHobbyistRandomAccount(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("registermyuas-integration.csra-dronezone.com")){
			//randomHobbyistEmailLoginIntegration
			//String randomLogin = DataGenerator.getRandomHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveHobbyistUserFromDB();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
		} else if (environment.equals("registermyuas-test.csra-dronezone.com")){
			String randomLogin = DataGenerator.getRandomHobbyistEmailLoginTest();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} 
		waitABit(1000);
	} 

	@Step
	public void logInWithRandomGatewayHobbyistAccount(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			//randomHobbyistEmailLoginIntegration
			//String randomLogin = DataGenerator.getRandomHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getActiveHobbyistUserFromGatewayIntegrationDB();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
//			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Gateway Logged in with an existing random Hobbyist account in Integration--->" + randomLogin);
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveHobbyistUserFromGatewayTestDB();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
//			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Gateway Logged in with an existing random Hobbyist account in Test--->" + randomLogin);
		} 
		waitABit(1000);
		
	} 	
	
	
	
	
	//Retrieve Email address for Cancel Registration
	@Step
	public void logInWithGatewayHobbyistAccountCancelRegistration(){
		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			//randomHobbyistEmailLoginIntegration
			//String randomLogin = DataGenerator.getRandomHobbyistEmailLoginIntegration();
			String randomLogin = DataGenerator.getHobbyistUserFromGatewayCancelRegistrationIntegrationDB();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Gateway Logged in with an existing random Hobbyist account in Integration--->" + randomLogin);
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			String randomLogin = DataGenerator.getHobbyistUserFromGatewayCancelRegistrationTestDB();
			Serenity.setSessionVariable("newFaaAcountEmail").to(randomLogin);
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			//Serenity.takeScreenshot();
			loginPage.clickOnSubmitButton();
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} 
		waitABit(1000);
	} 	
	
	
	
	
	
	
	
	@Step
	public void validateExistingHobbyistAccount(){
		faaHomePage.validateExistingHobbyistAccount();	
	}
	
	@Step
	public void validateExistingNonHobbyistAccount(){
		faaHomePage.validateExistingNonHobbyistAccount();	
	}
	
	
	
	@Step
	public void clickOnCreateAccountButton(){
		newAccountPage.clickOnCreateAccountButton();
		waitABit(2000);
	}

	@Step
	public void clickOnCreateNewAccountLink(){
		newAccountPage.clickOnCreateNewAccountLink();
		waitABit(2000);
	}
	
	
	
	@Step
	public String getNewAccountEmailAddress(){
		return newAccountPage.getNewEmailAccountAddressFieldValue();
	}
	
	@Step
	public void typeIntoNewHobbyistAccountEmailAddressField(){
		String newGmailEmailAccount = "mynewfaadrone+hGateway" + DataGenerator.randomIntegerBetween(10,10000) + "@gmail.com";
		Serenity.setSessionVariable("newFaaAccount").to(newGmailEmailAccount);
		newAccountPage.typeIntoNewAccountEmailAddressField(newGmailEmailAccount);
	}

	@Step
	public void typeIntoNewNonHobbyistAccountEmailAddressField(){
		String newGmailEmailAccount = "mynewfaadrone+nhGateway" + DataGenerator.randomIntegerBetween(10,10000) + "@gmail.com";
		Serenity.setSessionVariable("newFaaAccount").to(newGmailEmailAccount);
		newAccountPage.typeIntoNewAccountEmailAddressField(newGmailEmailAccount);
	}

	@Step
	public void typeIntoNewNonHobbyistAccountInvalidEmailAddressField(){
		String newEmailAccount = "MynewFaaDrone+nhPublic_" + DataGenerator.randomIntegerBetween(20,10000) + "@gmail.com";
		Serenity.setSessionVariable("newFaaAccount").to(newEmailAccount);
		newAccountPage.typeIntoNewAccountEmailAddressField(newEmailAccount);
	}

	
	
	
	@Step
	public void typeIntoForgotPasswordEmailField(){
		String GmailFaaDroneEmailAccount = "mynewfaadrone@gmail.com";
		System.out.println("On Forgot Password Account part of test  " + GmailFaaDroneEmailAccount);
		loginPage.typeIntoEmailTextField(GmailFaaDroneEmailAccount);
	}

	@Step
	public void gmailClickToResetPassword(){
		//String GmailFaaDroneEmailAccount = "myfaadrone@gmail.com";
		System.out.println("click On Forgot Password email message");
		gmailLoginPage.gmailClickToResetPassword();
	}
	
	@Step
	public void enterAndConfirmNewPassword(){
		String newPassword = "Dummy$11";
		System.out.println("Enter New Password");
		faaHomePage.typeIntoNewPasswordField(newPassword);
		System.out.println("New Password Entered");
		faaHomePage.typeIntoConfirmNewPasswordField(newPassword);
		System.out.println("New Confirm Password Entered");
		waitABit(1000);
		faaHomePage.clickOnChangePasswordSubmitButton();
		clickOnIAgreeButton();
		waitABit(1000);
	}
	
	@Step
	public void typeIntoResendEmailVerificationField(){
		String GmailFaaDroneEmailAccount = "mynewfaadrone@gmail.com";
		System.out.println("On Verify Account part of test  " + GmailFaaDroneEmailAccount);
		loginPage.typeIntoEmailTextField(GmailFaaDroneEmailAccount);
	}

	@Step
	public void clickOnSendEmailButton(){
		loginPage.clickOnSendEmailButton();
		//loginPage.clickOnIAgreeButton();
	}
	
	
	@Step
	public void typeIntoNewAccountPasswordField(String inputText){
		newAccountPage.typeIntoPasswordField(inputText);
	}
	@Step
	public void typeIntoNewAccountConfirmPasswordField(String inputText){
		newAccountPage.typeIntoConfirmPasswordField(inputText);
	}
	@Step
	public void clickOnNewAccountCreateButton(){
		newAccountPage.clickOnCreateAccountButton();
	}
	@Step
	public void verifyAccountCreation(){
		System.out.println("On Verify Account part of test!!!!!!");
		newAccountPage.verifyAccount();
		
			
	}
	
	@Step 
	public void clickOnNonModelAircraftButtonCssSelectorButton(){
		String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
		System.out.println("On Verify Account part of test  " + newFaaAcountEmail);
		newAccountPage.clickOnNonModelAircraftButtonCssSelectorButton();
	}
	
	
	@Step
	public void logOutOffaa() {
		// TODO finish this method
	}
	
	public void clickOnContactInformationButton() {
		faaHomePage.clickOnContactInformationButton();
	}

	
//	clickOnContactInternationalCallerButton();	
	public void clickOnContactInternationalCallerButton() {
//		faaHomePage.clickOnContactInternationalCallerButton();
		faaHomePage.verifyInternationalCallerEquals();
//		faaHomePage.verifyContactInformationEmailEquals();
	}

////	clickOnContactEmailButton();
	public void clickOnContactEmailButton() {
		faaHomePage.verifyContactInformationEmailEquals();
	}
	//
////	clickOnContactPhoneButton();
//	public void clickOnContactPhoneButton() {
//		faaHomePage.clickOnContactPhoneButton();
//	}
//	verifyContactInformationFaqsEquals
	public void clickOnContactFaqsButton() {
		faaHomePage.verifyContactInformationFaqsEquals();
	}

	
//	clickOnContactInternationalCallerButton
//	clickOnContactEmailButton
//	clickOnContactPhoneButton
//	clickOnContactFaqsButton
	

	public void clickOnFooterMenuRegisterByPaperButton() {
		faaHomePage.clickOnFooterMenuRegisterByPaperButton();
	}
	public void clickOnFooterMenuRegisterByPaperLink() {
		faaHomePage.clickOnFooterMenuRegisterByPaperLink();
	}
	public void clickOnFooterMenuPasrnLink() {
		faaHomePage.clickOnFooterMenuPasrnLink();
	}
	public void clickOnFooterMenuDot() {
		faaHomePage.clickOnFooterMenuDot();
	}
	public void clickOnFooterMenuWebPolicies() {
		faaHomePage.clickOnFooterMenuWebPolicies();
	}
	public void clickOnFooterMenuPrivacyPolicy() {
		faaHomePage.clickOnFooterMenuPrivacyPolicy();
	}
	public void clickOnFooterMenuAccessibility() {
		faaHomePage.clickOnFooterMenuAccessibility();
	}
	public void clickOnFooterMenuTransportation() {
		faaHomePage.clickOnFooterMenuTransportation();
	}
	public void clickOnFooterMenuUsa() {
		faaHomePage.clickOnFooterMenuUsa();
	}
	public void clickOnFooterMenuPlainlanguage() {
		faaHomePage.clickOnFooterMenuPlainlanguage();
	}
	public void clickOnFooterMenuRegulations() {
		faaHomePage.clickOnFooterMenuRegulations();
	}
	public void clickOnFooterMenuData() {
		faaHomePage.clickOnFooterMenuData();
	}
	public void clickOnFooterMenuFaq() {
		faaHomePage.clickOnFooterMenuFaq();
	}
	public void clickOnFooterMenuAllQuestions() {
		faaHomePage.clickOnFooterMenuAllQuestions();
	}
	public void clickOnFooterMenuContactFaa() {
		faaHomePage.clickOnFooterMenuContactFaa();
	}
	public void clickOnFooterMenuOig() {
		faaHomePage.clickOnFooterMenuOig();
	}
	public void clickOnFooterMenuFoia() {
		faaHomePage.clickOnFooterMenuFoia();
	}

}
