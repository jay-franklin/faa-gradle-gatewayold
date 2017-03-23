package faa.cucumber.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Step;
import net.thucydides.junit.annotations.Concurrent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThat;
//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import javax.management.modelmbean.ModelMBeanInfoSupport;

import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;
import faa.utils.LogToFileCsv;
import faa.utils.LogToFileXlsx;
import faa.utils.Sele1;
import faa.utils.WriteOpenCSV2;
import faa.models.InviteUser;

/** @author jfranklin */
public class FaaHomePage extends BasePageObject {
	
	LoginPage loginPage;
		
	public static Properties serenityProperties;
	@FindBy(xpath = "//h1[contains(text(), 'Change Your Password')]") WebElementFacade changeYourPasswordText;
	
	/**body#body div div div uas-breadcrumbs ol li a
	UAS Registration Home Link **/
	@FindBy(css = "body#body div div div uas-breadcrumbs ol li a") private WebElementFacade uasRegistrationLink;
//	@FindBy(xpath = "//button[@class='center-block btn btn-primary'and contains(text(), 'I Agree') ]") private WebElementFacade iAgreeButton;
	
	//Welcome banner on welcome page
	@FindBy(css = "html body div div div div div div h1") private WebElementFacade welcomeBanner;

	
	//Contact Information
	@FindBy(xpath = "//a[@id='contact']") WebElementFacade contactInformation;
	@FindBy(xpath = "//button[@id='closeButton' and contains(text(), 'Close')]") WebElementFacade close;
	@FindBy(xpath = "//a[@id='internationalNumber']") WebElementFacade contactInformationInternationalCaller; 
	
	//Icons
	@FindBy(xpath = "//a[@id='phoneIcon']") WebElementFacade contactInformationPhoneIcon; 
	@FindBy(xpath = "//a[@id='emailIcon']") WebElementFacade contactInformationEmailIcon;
	@FindBy(xpath = "//a[@id='faqIcon']") WebElementFacade contactInformationFaqIcon; 

	
	@FindBy(xpath = "//a[@id='phoneNumber']") WebElementFacade contactInformationPhone; 
	@FindBy(xpath = "//a[@id='emailAddress']") WebElementFacade contactInformationEmail;
	@FindBy(xpath = "//a[@id='faqLink']") WebElementFacade contactInformationFaqLink; 
	
	
	@FindBy(xpath = "//input[@id='loginField' and @placeholder='Enter Email Address']") WebElementFacade usernameField;
	@FindBy(xpath = "//input[@id='passwordField' and @placeholder='Enter Password']") private WebElementFacade passwordField;
	
	@FindBy(xpath = "//div[@class='alert alert-danger' and contains(text(),'Invalid username or password.')]") private WebElementFacade invalidUsernamePasswordMessage;
	
	
	@FindBy(xpath = "//div[contains(text(), 'Invalid username or password')]") private WebElementFacade invalidUsernameMessage;

	@FindBy(xpath = "//a[@id='logoutAccount' and contains(text(), 'Logout')]") private WebElementFacade logoutButton;
			
	@FindBy(xpath = "//input[@id='password' and @name='password']") private WebElementFacade newPassword;
	@FindBy(xpath = "//input[@id='confirmPassword' and @name='confirmPassword']") private WebElementFacade confirmNewPassword;

	@FindBy(xpath = "//button[@type='submit' and contains(text(), 'Submit')]") private WebElementFacade changePasswordSubmitButton;

	@FindBy(xpath = "//p[contains(text(), 'You have successfully changed your password. You may now login')]") private WebElementFacade successfullyChangedPasswordMessage;
	@FindBy(xpath = "//p[starts-with(text(), 'This user is already a member of an organization.')]") private WebElementFacade alertUserAlreadyInvitedMessage;

	
	//clickOnProfileTab
	@FindBy(xpath = "//div[@id='profileTab' and contains(text(), 'Profile')]") private WebElementFacade profileTab;
	//clickOnInventoryTab
	@FindBy(xpath = "//div[@id='inventoryTab' and contains(text(), 'Inventory')]") private WebElementFacade inventoryTab;
	//clickOnUsersTab
	@FindBy(xpath = "//div[@id='userTab' and contains(text(), 'Users')]") private WebElementFacade usersTab;

	
	//addUser   a title="Add User"
	@FindBy(xpath = "//div[@title='Add User']") private WebElementFacade addUser;

	// Invite New User Modal Window
	@FindBy(xpath = "//input[@id='firstName']") WebElementFacade inviteFirstName;
	@FindBy(xpath = "//input[@id='lastName']") WebElementFacade inviteLastName;
	@FindBy(xpath = "//input[@id='email']") WebElementFacade inviteEmail;
	@FindBy(xpath = "//select[@id='roleCode']") WebElementFacade inviteRoleCode;
	@FindBy(xpath = "//button[@id='primaryButtonSubmit']") WebElementFacade submitInviteUser;
	@FindBy(xpath = "//button[@id='Cancel_button']") WebElementFacade cancelInviteUser;
	

	// Invite New User Accept Invitaion screen
	@FindBy(xpath = "//input[@id='password' and @type='password']") WebElementFacade invitePassword;
	@FindBy(xpath = "//input[@id='confirmPassword' and @type='password']") WebElementFacade inviteConfirmPassword;
	@FindBy(xpath = "//button[@id='acceptButton' and contains(text(), 'Accept Invitation')]") WebElementFacade submitAcceptInvitation;
	
	@FindBy(xpath="//a[contains(@href,'public-gateway.csra-dronezone.com') and contains(text(), 'Click here to accept your invitation')]") private WebElementFacade acceptFaaHomePageYourInvitationLink;

	
//	@FindBy(xpath = "//h1[contains(text(), 'Accept Invitation']") WebElementFacade formAcceptInvitation;
	//sUAS Registration - Accept Invitation
	@FindBy(xpath = "//html/head/title[1]") WebElementFacade titleAcceptInvitation;

	
	
	//Gateway Welcome Dropdown Menu
	//welcomeDropdown
	@FindBy(xpath = "//a[@id='welcomeDropdown']") private WebElementFacade welcomeDropdownButton;
	//Edit Profile
	@FindBy(xpath = "//a[@id='editProfile' and contains(text(), 'Edit Profile')]") private WebElementFacade editProfileButton;

	//Change Primary Email
	@FindBy(xpath = "//a[@id='changePrimaryEmail' and contains(text(), 'Change Primary Email')]") private WebElementFacade changePrimaryEmailButton;

	//changePassword Profile
	@FindBy(xpath = "//a[@id='changePassword' and contains(text(), 'Change Password')]") private WebElementFacade changePasswordButton;

	
	//Next Button on Complete Your Profile page
	@FindBy(xpath = "//button[@id='next' and contains(text(), 'Next')]") private WebElementFacade nextButton;
	
	
	/** Click the Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-remote']") private WebElementFacade modelAircraft;

	/** Click the Non-Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-heads']") private WebElementFacade nonModelAircraft;
	
	//Register Button on Welcome to the UAS Registration home page
	@FindBy(xpath = "//a[@class='btn btn-info btn-lg' and contains(text(), 'Register')]") private WebElementFacade registerButton;

	//Footer Menu links
	@FindBy(xpath="//a[@href='https://www.transportation.gov/individuals/privacy/privacy-act-system-records-notices' and contains(text(), 'https://www.transportation.gov/individuals/privacy/privacy-act-system-records-notices')]") private WebElementFacade footerMenuPasrnLink;
	@FindBy(xpath="//a[@href='http://www.faa.gov/licenses_certificates/aircraft_certification/aircraft_registry/UA/' and contains(text(), 'Register by Paper')]") private WebElementFacade footerMenuRegisterByPaperButton;
	@FindBy(xpath="//a[@href='http://www.faa.gov/licenses_certificates/aircraft_certification/aircraft_registry/UA/' and contains(text(), 'http://www.faa.gov/licenses_certificates/aircraft_certification/aircraft_registry/UA/')]") private WebElementFacade footerMenuRegisterByPaperLink;
	@FindBy(xpath="//a[@href='https://www.transportation.gov/' and contains(text(), 'U.S. Department of Transportation')]") private WebElementFacade footerMenuDot;
	@FindBy(xpath="//a[@href='https://www.faa.gov/web_policies/' and contains(text(), 'Web Policies & Notices')]") private WebElementFacade footerMenuWebPolicies;
	@FindBy(xpath="//a[@href='https://www.faa.gov/privacy/' and contains(text(), 'Privacy Policy')]") private WebElementFacade footerMenuPrivacyPolicy;
	@FindBy(xpath="//a[@href='https://www.faa.gov/accessibility/' and contains(text(), 'Accessibility')]") private WebElementFacade footerMenuAccessibility;
	@FindBy(xpath="//a[@href='https://www.transportation.gov/' and contains(text(), 'Transportation.gov')]") private WebElementFacade footerMenuTransportation;
	@FindBy(xpath="//a[@href='https://www.usa.gov/' and contains(text(), 'USA.gov')]") private WebElementFacade footerMenuUsa;
	@FindBy(xpath="//a[@href='http://www.plainlanguage.gov/' and contains(text(), 'Plainlanguage.gov')]") private WebElementFacade footerMenuPlainLanguage;
	@FindBy(xpath="//a[@href='https://www.regulations.gov/' and contains(text(), 'Regulations.gov')]") private WebElementFacade footerMenuRegulations;
	@FindBy(xpath="//a[@href='https://www.data.gov/' and contains(text(), 'Data.gov')]") private WebElementFacade footerMenuData;
	@FindBy(xpath="//a[@href='https://www.faa.gov/uas/faqs' and contains(text(), 'Frequently Asked Questions')]") private WebElementFacade footerMenuFaq;
	@FindBy(xpath="//a[@href='https://faa.custhelp.com/cgi-bin/faa.cfg/php/enduser/std_alp.php?p_sid=uLVYT9Rj' and contains(text(), 'All Questions')]") private WebElementFacade footerMenuAllQuestions;
	@FindBy(xpath="//a[@href='https://www.faa.gov/contact/' and contains(text(), 'Contact FAA')]") private WebElementFacade footerMenuContactFaa;
	@FindBy(xpath="//a[@href='https://www.oig.dot.gov/Hotline' and contains(text(), 'Office of Inspector General')]") private WebElementFacade footerMenuOigHotline;
	@FindBy(xpath="//a[@href='https://www.faa.gov/foia/' and contains(text(), 'Freedom of Information Act')]") private WebElementFacade footerMenuFoia;
	
	@FindBy(xpath = "//div div app-dashboard h1") private WebElementFacade modelAircraftDashboard;
	@FindBy(xpath = "//div[@id='nonModelAircraftUser']") private WebElementFacade nonModelAircraftButton;
	@FindBy(xpath = "//div[@id='manageAccessTool']") private WebElementFacade manageAccessToolButton;	
	
	
	
	
	//List of Users with Expired Status shown on the Manage Users page
	@FindBy(xpath = "//div[@class='user-content user-invite-status ng-binding' and contains(text(), 'Expired')]") private WebElementFacade ListOfExpiredUsers;

	
	@FindBy(xpath = "//div[starts-with(@id,'expiredUserDetails') and contains(text(), 'Details')]") List<WebElementFacade>  ListOfExpiredUsersDetails;
	@FindBy(xpath = "//h4[starts-with(@class,'user-wrap ng-binding')]") List<WebElementFacade>  ListOfInvitedUsersNames;

	@FindBy(xpath = "//div[starts-with(@id,'editUser') and contains(text(), 'Edit')]") List<WebElementFacade>  ListOfExpiredUsersEdit;

	
	//Edit User Page
	//List of Users with Expired Status shown on the Manage Users page
	@FindBy(xpath = "//select[@id='roleType']") private WebElementFacade roleType;
	@FindBy(xpath = "//button[@id='submitEditUser']") private WebElementFacade submitEditUser;
	
	
	@FindBy(xpath = "//button[starts-with(@id,'inviteUserDetailsBtn') and contains(text(), 'Close')]") private WebElementFacade  InvitedUsersDetailsCloseButton;
	@FindBy(xpath = "//button[starts-with(@id,'editUser') and contains(text(), 'Edit')]") List<WebElementFacade> InvitedUsersEditButton;

	@FindBy(xpath = "//div[starts-with(@id,'resendInvitation')]") List<WebElementFacade> InvitedUsersResendInvitationButton;
	
	//userFilter
	@FindBy(xpath = "//select[@id='userFilter']") private WebElementFacade  manageUsersFilterDropDown;

	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[4]/div/div[1]/div[2]/div/p/div/strong") private WebElementFacade AssertInviteResentTopMessage;
	
	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[4]/div/div[3]/div[2]/div/div[2]/div[6]/p") private WebElementFacade AssertInviteResentMessage;
	
	@FindBy(xpath = "//div[@class='user-wrap-read-only' and contains(text(), 'Email resent to')]") private WebElementFacade AssertInviteEmailResentMessage;
	
	
	

	
	public void validateExistingHobbyistAccount() {	
		if (modelAircraftDashboard.isCurrentlyVisible()){
			System.out.println("Successfully Logged in with an existing Hobbyist Account ...");
		} else { 
			if(invalidUsernameMessage.isCurrentlyVisible()) { 
				System.out.println("Not Successfully Logged in...Reenter Username and password");
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveHobbyistUserFromGatewayIntegrationDB();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			String randomLogin = DataGenerator.getActiveHobbyistUserFromGatewayTestDB();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.faa.gov")){
			String randomLogin = DataGenerator.randomEmailLoginStage();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
			}
		}
	}
}	

	public void validateExistingNonHobbyistAccount() {	
		//If the manageAccessTool button is available, user is logged in as a Admin account
		if (manageAccessToolButton.isCurrentlyVisible()){ 
			System.out.println("Successfully Logged in with an existing Non Hobbyist Account ...");
		} else { 
			if(invalidUsernameMessage.isCurrentlyVisible()) { // .containsText("Invalid username or password.")) {
				System.out.println("Not Successfully Logged in...Reenter Username and password");
		String environment = serenityProperties.getProperty("app.base.host");
		if (environment.equals("public-gateway.csra-dronezone.com")){
			String randomLogin = DataGenerator.randomEmailLoginIntegration();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
		} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
			String randomLogin = DataGenerator.randomEmailLoginTest();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
		} else if (environment.equals("registermyuas-stage.faa.gov")){
			String randomLogin = DataGenerator.randomEmailLoginStage();
			loginPage.typeIntoLoginField(randomLogin);
			loginPage.typeIntoPasswordField("Dummy$11");
			loginPage.clickOnSubmitButton();
			if (invalidUsernamePasswordMessage.isCurrentlyVisible()) {
				loginPage.typeIntoLoginField(randomLogin);
				loginPage.typeIntoPasswordField("MyfaaDummy$11");
				loginPage.clickOnSubmitButton();
			}
			System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
			}
		}
	}
}		
	
	
	
	//Footer Menu options.  Button Register by Paper
	public void clickOnFooterMenuRegisterByPaperButton(){
		footerMenuRegisterByPaperButton.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Link Register by Paper
	public void clickOnFooterMenuRegisterByPaperLink(){
		footerMenuRegisterByPaperLink.click();
		waitABit(2000);
		closeFaaBrowserTabs();

	}
	//Footer Menu options.  Link Privacy Act System Records Notices.
	public void clickOnFooterMenuPasrnLink(){
		footerMenuPasrnLink.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	
	//Footer Menu options.  U.S. Department of Transportation
	public void clickOnFooterMenuDot(){
		footerMenuDot.click();
		waitABit(2000);
		
		
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  WebPolicies  & Notices
	public void clickOnFooterMenuWebPolicies(){
		footerMenuWebPolicies.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Privacy Policy
	public void clickOnFooterMenuPrivacyPolicy(){
		footerMenuPrivacyPolicy.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Accessibility
	public void clickOnFooterMenuAccessibility(){
		footerMenuAccessibility.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Transportation.gov
	public void clickOnFooterMenuTransportation(){
		footerMenuTransportation.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  USA.gov
	public void clickOnFooterMenuUsa(){
		footerMenuUsa.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Plainlanguage.gov
	public void clickOnFooterMenuPlainlanguage(){
		footerMenuPlainLanguage.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Regulations.gov
	public void clickOnFooterMenuRegulations(){
		footerMenuRegulations.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Data.gov
	public void clickOnFooterMenuData(){
		footerMenuData.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Frequently Asked Questions
	public void clickOnFooterMenuFaq(){
		footerMenuFaq.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  All Questions
	public void clickOnFooterMenuAllQuestions(){
		footerMenuAllQuestions.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Contact FAA
	public void clickOnFooterMenuContactFaa(){
		footerMenuContactFaa.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Office of Inspector General
	public void clickOnFooterMenuOig(){
		footerMenuOigHotline.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}
	//Footer Menu options.  Freedom of Information Act
	public void clickOnFooterMenuFoia(){
		footerMenuFoia.click();
		waitABit(2000);
		closeFaaBrowserTabs();
	}

	
	//contactInformation
	public void clickOnContactInformationButton(){
		contactInformation.click();
		waitABit(3000);
		System.out.println("Contact Information Button has been clicked");
		if (contactInformationEmailIcon.isCurrentlyVisible()) {//Works
			System.out.println("!!!!!!!!!!!!!!!!!!Email Icon is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationPhoneIcon.isCurrentlyVisible()) {//Works
			System.out.println("!!!!!!!!!!!!!!!!!!Phone Icon is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationFaqIcon.isCurrentlyVisible()) {//Works
			System.out.println("!!!!!!!!!!!!!!!!!!FAQ Icon is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationEmail.isCurrentlyVisible()) {//Works
			System.out.println("!!!!!!!!!!!!!!!!!!Email Link is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationPhone.isCurrentlyVisible()) {//Works
			System.out.println("!!!!!!!!!!!!!!!!!!Phone Link is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationInternationalCaller.isCurrentlyVisible()) { //Visible
			System.out.println("!!!!!!!!!!!!!!!!!!International Caller Number Link is visible and displayed!!!!!!!!!!!!!!!");
		}
		if (contactInformationFaqLink.isCurrentlyVisible()) {//Visible
			System.out.println("!!!!!!!!!!!!!!!!!!FAQs is visible and displayed!!!!!!!!!!!!!!!");
		}
		//Serenity.takeScreenshot();
		clickOnCloseButton();
	}	
		
//		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
//			waitABit(5000);
//			System.out.println("Loop Count to wait for International Phone Number to be displayed... " + i);
//			if (contactInformationInternationalCaller.isCurrentlyVisible()){
//			i=19;
//			if (contactInformationInternationalCaller.isCurrentlyVisible()){
//				//contactInformationInternationalCaller.click();
//				System.out.println("International Phone Number is visible");
//			} else {
//				System.out.println("International Phone Number is NOT visible");
//			}
//			System.out.println("Verify the International Phone Number is visible on the screen");
//			}
//			else 
//			{
//			System.out.println("could not click element.. Trying again in 5 seconds");
//			waitABit(5000);//wait 3 seconds before trying to click again
//			}
//		}
//		//Serenity.takeScreenshot();
//		clickOnCloseButton();
//	}	
		
//		
//		if (contactInformationInternationalCaller.isCurrentlyVisible()) {
//				// && contactInformationEmail.isCurrentlyVisible()) {
//				//& contactInformationPhone.isCurrentlyVisible() & contactInformationFaqs.isCurrentlyVisible() ){
//			System.out.println("Contact Information international Caller phone number is displayed correctly");
////			System.out.println("Contact Information Email is displayed correctly");
////			System.out.println("Contact Information Phone is displayed correctly");
////			System.out.println("Contact Information FAQs are displayed correctly");
//			//Serenity.takeScreenshot();
//		} else {
//			System.out.println("The Contact Information window did not appear correctly.  Review the content again.");
//		}
//			
//		if (contactInformationEmail.isCurrentlyVisible()){
//			System.out.println("Contact Information Email is displayed correctly");
//			//Serenity.takeScreenshot();
//		}	
//		if (contactInformationPhone.isCurrentlyVisible()){
//					System.out.println("Contact Information Phone is displayed correctly");
//					//Serenity.takeScreenshot();
//		}
//		if (contactInformationFaqs.isCurrentlyVisible()){
//			System.out.println("Contact Information FAQs are displayed correctly");
//			//Serenity.takeScreenshot();
//		}
//		clickOnCloseButton();
//}

//	contactInformationInternationalCaller
//	contactInformationEmail
//	contactInformationPhone
//	contactInformationFaqs

//	
	public void verifyInternationalCallerEquals() {
		String InternationalCaller = contactInformationInternationalCaller.getValue();
		assertThat(InternationalCaller).isEqualTo(contactInformationInternationalCaller); 
		System.out.println("International Caller Number is -->" + contactInformationInternationalCaller );
		System.out.println("International Caller Number getValue is -->" + contactInformationInternationalCaller.getValue() );
		
		
//		assertThat(newUserSuccessMessage.getText()).containsIgnoringCase("Successfully saved user:")
//		.overridingErrorMessage("ERROR: User success message not displayed");
	}
	
	public void verifyContactInformationEmailEquals() {
		String email = contactInformationEmail.getValue();
		assertThat(email).isEqualTo(contactInformationEmail); 
//		String email = contactInformationEmail.getValue();
//		assertThat(email).containsIgnoringCase(string);
		System.out.println("Contact Email is-->" + contactInformationEmail );
	}

	public void verifyContactInformationPhoneEquals(String string) {
		String phone = contactInformationPhone.getValue();
		assertThat(phone).containsIgnoringCase(string);
		System.out.println("Contact Phone is-->" + contactInformationPhone );
	}	

	public void verifyContactInformationFaqsEquals() {
		contactInformationFaqLink.click();
//		String faqs = contactInformationFaqs.getValue();
//		assertThat(faqs).containsIgnoringCase(string);
		System.out.println("<<Contact FAQs has been clicked>>"  );
	}	

	
//	verifyInternationalCallerEquals
//	verifyContactInformationEmailEquals
//	verifyContactInformationPhoneEquals
//	verifyContactInformationFaqsEquals
	//close
	public void clickOnCloseButton(){
		close.click();
	}
	
	//logoutButton
	public void clickOnLogoutButton() {
		for(int i = 0 ; i < 10;i++){ //attempt to click the element 10 times
			waitABit(2000);
			System.out.println("Loop Count to wait for Logout Button to be displayed... " + i);
			if (logoutButton.isCurrentlyVisible()) {
				logoutButton.click();
				i = 9;
			} else 	{
			System.out.println("could not click element.. Trying again in 2 seconds");
			}
		}
			LogToFile.write("\t**************************************************************");
			LogToFile.write("\t**********FAA Drone Gateway Automation Test Results***********");
			LogToFile.write("\t**************************************************************");
			LogToFile.write("\tGP-165\tMouse over text on payment page");
			LogToFile.write("\tGP-145\tIncorporate International Address Validation into Mailing Address - Happy path");
			LogToFile.write("\tGP-144\tIncorporate International Address Validation into Physical Address - Happy path");
			LogToFile.write("\tGP-143\tIncorporate US Address Validation into Mailing Address - Happy path");
			LogToFile.write("\tGP-142\tIncorporate US Address Validation into Physical Address - Happy path");
			LogToFile.write("\tGP-141\tUS Address Validation - UI Scenario 1");
			LogToFile.write("\tGP-140\tUS Address Validation - UI Scenario 2");
			LogToFile.write("\tGP-139\tUS Address Validation - UI Scenario 4");
			LogToFile.write("\tGP-138\tUS Address Validation - UI Scenario 5");
			LogToFile.write("\tGP-137\tInternational Address Validation - UI Scenario 2");
			LogToFile.write("\tGP-136\tInternational Address Validation - UI Scenario 4");
			LogToFile.write("\tGP-135\tUS Address Validation - UI Scenario 3");
			LogToFile.write("\tGP-134\tInternational Address Validation - UI Scenario 3");
			LogToFile.write("\tGP-133\tInternational Address Validation - UI Scenario 1");
			LogToFile.write("\tGP-132\t2 Strike Rule (SS)");
			LogToFile.write("\tGP-119\tAlready a Non-Hobbyist scenario");
			LogToFile.write("\tGP-108\tView Shopping Cart by Logged in User vs Org");
			LogToFile.write("\tGP-99 \tAdd User");
			LogToFile.write("\tGP-97 \tInvited Users Tile");
			LogToFile.write("\tGP-96 \tActive Users Tile");
			LogToFile.write("\tGP-95 \tManage Users Filter and Sort");
			LogToFile.write("\tGP-89 \tNon-Hobbyist Congratulations Page");
			LogToFile.write("\tGP-88 \tOrganization Users Empty Tile on Non-Hob Dashboard");
			LogToFile.write("\tGP-73 \tEmpty New Non-Hobbyist Dashboard + Empty Inventory Tile");
			LogToFile.write("\tGP-64 \t50 Item Shopping Cart Limit");
			LogToFile.write("\tGP-37 \tNon-Hobbyist Dashboard - Tile for Recent Registrations");
			LogToFile.write("\tGP-33 \tView Non-Hobbyist Registered UAS Details");
			LogToFile.write("\tGP-32 \tEdit Registered UAS");
			LogToFile.write("\tGP-30 \tNon-Hobbyist Review Order Page");
			LogToFile.write("\tGP-29 \tNon-Hobbyist Checkout/Payment Info");
			LogToFile.write("\tGP-28 \tNon-Hobbyist Acknowledgment of FAA Requirements");
			LogToFile.write("\tGP-27 \tRemove Shopping Cart UAS");
			LogToFile.write("\tGP-26 \tClone UAS (Shopping Cart and Registered Inventory)");
			LogToFile.write("\tGP-25 \tEdit Shopping Cart UAS");
			LogToFile.write("\tGP-24 \tView Shopping Cart (Filter, Sort)");
			LogToFile.write("\tGP-23 \tAdd UAS");
			LogToFile.write("\tGP-22 \tNew Non-Hobbyist User Completes Org Profile");
			LogToFile.write("\tGP-20 \tCentralized User Profile (View/Edit)");
			LogToFile.write("\tGP-17 \tGateway Contact Us Modal");
			LogToFile.write("\tGP-16 \tChange Primary Email in gateway");
			LogToFile.write("\tGP-15 \tChange Password in Gateway");
			LogToFile.write("\tGP-13 \tRe-send Hobbyist PDF Certificate Email");
			LogToFile.write("\tGP-11 \tHobbyist Renew Registration");
			LogToFile.write("\tGP-10 \tBuild Placeholder for Top Right Corner Profile Menu");
			LogToFile.write("\tGP-9  \tModel Aircraft Dashboard - Safety Guidance Tile");
			LogToFile.write("\tGP-8  \tModel Aircraft Dashboard - Registration Tile");
			LogToFile.write("\tGP-7  \tHobbyist Congratulations Page");
			LogToFile.write("\tGP-6  \tHobbyist Review Order Page");
			LogToFile.write("\tGP-5  \tHobbyist Checkout/Payment Info");
			LogToFile.write("\tGP-4  \tAcknowledge Hobbyist Safety Rules");
	}
	
	
	//welcomeDropdownButton
	public void clickOnWelcomeDropdownButton() {
		welcomeDropdownButton.click();
	}

//	editProfileButton
//	changePrimaryEmailButton
//	changePasswordButton

	
	
	//clickOnEditProfileButton
	public void clickOnEditProfileButton() {
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to wait for Edit Profile Button to be displayed... " + i);
			if (editProfileButton.isCurrentlyVisible() | nextButton.isCurrentlyVisible()){
			i=19;
			if (editProfileButton.isCurrentlyVisible()){
				editProfileButton.click();
				System.out.println("Edit Button is visible.  Continue with Editing Profile");
			} else if (nextButton.isCurrentlyVisible()) {
				System.out.println("Next Button is visible.  Continue with Adding Profile");
			}
			System.out.println("Verify Edit Profile Button OR Next Button have been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}
		
//			
//			
//			if (editProfileButton.isCurrentlyVisible()){
//			editProfileButton.click();
//			System.out.println("Edit Button is visible.  Continue with Editing Profile");
//		} else if (nextButton.isCurrentlyVisible()) {
//			System.out.println("Next Button is visible.  Continue with Adding Profile");
//		}
//			else {
//				System.out.println("Buttons are NOT visible.  Quit the test and start over :");
//			}
	}		
		
	//verifyPasswordChanged
	public String getVerifyPasswordChanged() {
		return changeYourPasswordText.getAttribute("value");
	}
	
//	//iAgreeButton
//	public void clickOnIAgreeButton() {
//		iAgreeButton.click();
//	}
	
	//uasRegistrationLink
	public void clickOnUasRegistrationLink() {
		click(uasRegistrationLink);
	}

	//Profile Tab
	public void clickOnProfileTab(){
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to wait for Profile Tab to be displayed... " + i);
			if (profileTab.isCurrentlyVisible()){
			i=19;
			profileTab.click();
			System.out.println("Verify Profile Tab has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}
	}	
	
	//inventoryTab
	public void clickOnInventoryTab(){
		inventoryTab.click();
	}


	//UsersTab
	public void clickOnUsersTab(){
		usersTab.click();
	}

	
	
	//Add User 
	public void clickOnAddUserButton(){
		addUser.click();
	}
	
	
//	//roleType
//	public void selectRoleTypeDropList(String roleTypeUser) {
////		if (manageUsersFilterDropDown.isCurrentlyVisible()){
//
//		if (roleType.getText().equalsIgnoreCase("Inventory Manager"){
//			
//			Select dropDownList = new Select(roleType);
//		dropDownList.selectByVisibleText(roleTypeUser);
//		System.out.println("Manage User Role Type-->" + roleTypeUser);
////		} else {
////		System.out.println("Manage User Page Filter cannot be selected");
////		}
//	}	
	
///////////////////////
		public void selectARoleType() {
			//uastypedropdown.selectByIndex(DataGenerator.randomIntegerBetween(0,uastypedropdown.getSelectOptions().size()) - 1);
			System.out.println("Randomly selected UAS Type Size is " + roleType.getSelectOptions().size());
//			String currentSelectedRoleType = roleType.getSelectedValue();  //    "Organization Administrator";
			String currentSelectedRoleType = roleType.getSelectedVisibleTextValue();  //    "Organization Administrator";
			System.out.println("Current selected Role Type is " + currentSelectedRoleType);
			waitABit(5000);
			if (currentSelectedRoleType.equals("Organization Administrator" )){
				Select dropDownList = new Select(roleType);
				dropDownList.selectByVisibleText("Inventory Manager");
				//roleType.selectByVisibleText("Inventory Manager");
				System.out.println("Newly selected Role Type is " + getCurrentRoleType());
				//Serenity.takeScreenshot();
			}	
			else if (currentSelectedRoleType.equals("Inventory Manager")){
				Select dropDownList = new Select(roleType);
				dropDownList.selectByVisibleText("Organization Administrator");
				//roleType.selectByVisibleText("Organization Administrator");
				System.out.println("Newly selected Role Type is " + getCurrentRoleType());
				//Serenity.takeScreenshot();
			}
		}	

		public String getCurrentRoleType() {
			System.out.println("Get the Newly selected Role Type -->" + roleType.getSelectedVisibleTextValue());
			return roleType.getSelectedVisibleTextValue();    //getAttribute("value");
		}
		
		
//////////////////////		
		
		//Edit User Page click on the Update User Button
		public void clickOnSubmitEditUserButton(){
			submitEditUser.click();
		}
	
	public void selectInvitedUsersDropList(String invitedUser) {
//		if (manageUsersFilterDropDown.isCurrentlyVisible()){
		Select dropDownList = new Select(manageUsersFilterDropDown);
		dropDownList.selectByVisibleText(invitedUser);
		System.out.println("Manage User Page Filter by " + invitedUser);
	}	
	
	
	////////////////////	
	//ListOfExpiredUsersEdit
	public void clickOnExpiredUserEditButton(){
		List <WebElementFacade> expiredUserEditlistings = ListOfExpiredUsersEdit;  
		System.out.println("Size of This User Org with Expired Users to Edit their Users List--> " + expiredUserEditlistings.size());
		
		if (expiredUserEditlistings.size() == 0) {
			System.out.println("This User has no Expired Users edit their Users List--> " + expiredUserEditlistings.size());
		}
		else {
		Random r = new Random();
		int randomEditValue = r.nextInt(expiredUserEditlistings.size()); //Getting a random value that is between 0 and (list's size)-1
		Serenity.setSessionVariable("randomExpiredUserEditValue").to(randomEditValue); 
		//Retrieving a SessionVariables
		int varRandomExpiredUserEditValue = Serenity.sessionVariableCalled("randomExpiredUserEditValue");
		
		System.out.println("Random value from Session Variable--> " + varRandomExpiredUserEditValue);
		System.out.println("Number of Users in List--> " + expiredUserEditlistings.size());
		
		System.out.println("==>1 ListOfExpiredUsersEdit session Variable==> "+ ListOfExpiredUsersEdit.get(varRandomExpiredUserEditValue).getTextValue());
		expiredUserEditlistings.get(varRandomExpiredUserEditValue).click(); //Clicking on the random item in the list.
		System.out.println("<<----Random Edit Value -->" + expiredUserEditlistings.get(varRandomExpiredUserEditValue).getText());
		waitABit(1000);
		selectARoleType();
		clickOnSubmitEditUserButton();
		}
		
	}
	
	///////////////////////
	//Expired User Details Button
	//clickOnExpiredUserDetailsButton
	public void clickOnExpiredUserDetailsButton(){
		System.out.println("Click on  Details Button");
	
		waitABit(2000);
		List <WebElementFacade> expiredUserDetailslistings = ListOfExpiredUsersDetails;  
		System.out.println("111This User has no Expired Users in their Users List--> " + expiredUserDetailslistings.size());
		
//		List <WebElementFacade> expiredUserNameslistings = ListOfInvitedUsersNames;
		if (expiredUserDetailslistings.size() == 0) {
//		if (ListOfExpiredUsersDetails.isEmpty()){
			System.out.println("This User has no Expired Users in their Users List--> " + expiredUserDetailslistings.size());
		}
		else {
//		List <WebElementFacade> expiredUserDetailslistings = ListOfExpiredUsersDetails;  
		List <WebElementFacade> expiredUserNameslistings = ListOfInvitedUsersNames;
		Random r = new Random();
		int randomDetailsValue = r.nextInt(expiredUserDetailslistings.size()); //Getting a random value that is between 0 and (list's size)-1
		Serenity.setSessionVariable("randomExpiredUserValue").to(randomDetailsValue); 
		//Retrieving a SessionVariables
		int varRandomDetailsValue = Serenity.sessionVariableCalled("randomExpiredUserValue");
		System.out.println("Random value from Session Variable--> " + varRandomDetailsValue);
		System.out.println("Number of Users in List--> " + expiredUserDetailslistings.size());
		
		System.out.println("==>1 ListOfExpiredUsersDetails session Variable==> "+ ListOfExpiredUsersDetails.get(varRandomDetailsValue).getTextValue());
		System.out.println("==>1 ListOfExpiredUsersDetails get getTextValue ==> " +randomDetailsValue + " " + ListOfExpiredUsersDetails.get(randomDetailsValue).getTextValue());
		
		System.out.println("==>2 randomDetailsValue ==> " +randomDetailsValue +" " + expiredUserDetailslistings.get(randomDetailsValue).getText());
		int randomNameValue = r.nextInt(expiredUserNameslistings.size()); //Getting a random value that is between 0 and (list's size)-1
		
		System.out.println("==>3 randomNameValue ==> " +randomDetailsValue + " " + expiredUserNameslistings.get(randomDetailsValue).getText());
		System.out.println("==>4 ListOfExpiredUsersNames ==> " +randomDetailsValue + " " + ListOfInvitedUsersNames.get(randomDetailsValue).getText());
		//Retrieving a SessionVariables
//		int varRandomDetailsValue = Serenity.sessionVariableCalled("randomExpiredUserValue");

		expiredUserDetailslistings.get(varRandomDetailsValue).click(); //Clicking on the random item in the list.
		System.out.println("<<----Random Details Value -->" + expiredUserNameslistings.get(varRandomDetailsValue).getText());
		waitABit(1000);
		clickOnInvitedUsersDetailsCloseButton();
		}
		System.out.println("<<----NO Random Details Value -->");
	}

	
	public  void clickOnExpiredUserResendInvitationButton(){
		List <WebElementFacade> expiredUserResendInvite = InvitedUsersResendInvitationButton;
		System.out.println("111 This User has no Users to Resend Invitations in their Users List--> " + expiredUserResendInvite.size());

		if (expiredUserResendInvite.size() == 0 ) {
			System.out.println("This User has no Users to Resend Invitations in their Users List--> " + expiredUserResendInvite.size());
		}
		else  {
//		List <WebElementFacade> expiredUserResendInvite = InvitedUsersResendInvitationButton;
		//Retrieving a SessionVariables
		int varRandomDetailsValue = Serenity.sessionVariableCalled("randomExpiredUserValue"); //Count of Invited Users with Invited Status
//		Random r = new Random();
//		int randomResendInviteValue = r.nextInt(expiredUserResendInvite.size()); //Getting a random value that is between 0 and (list's size)-1
		//InvitedUsersResendInvitationButton
		System.out.println("==>1 InvitedUsersResendInvitationButton ==> " + varRandomDetailsValue + " " + InvitedUsersResendInvitationButton.get(varRandomDetailsValue).getTextValue());
//		System.out.println("==>2 expiredUserResendInvite ==> " +varRandomDetailsValue +" " + expiredUserResendInvite.get(randomResendInviteValue).getText());
//		System.out.println("==>3 expiredUserResendInvite ==> " +randomResendInviteValue + " " + expiredUserResendInvite.get(randomResendInviteValue).getText());
//		System.out.println("==>4 expiredUserResendInvite ==> " + expiredUserResendInvite.get(randomResendInviteValue));
//		System.out.println("==>5 expiredUserResendInvite ==> " + expiredUserResendInvite.get(randomResendInviteValue).getTextValue());
//		System.out.println("==>6 expiredUserResendInvite ==> " +randomResendInviteValue +" " + expiredUserResendInvite.get(randomResendInviteValue).getText());
//		System.out.println("==>7 expiredUserResendInvite ==> " +randomResendInviteValue + " " + expiredUserResendInvite.get(randomResendInviteValue).getText());
		
		expiredUserResendInvite.get(varRandomDetailsValue).click(); //Clicking on the random item in the list.
//		System.out.println("<<----Random Resend Invitation Value -->" + expiredUserResendInvite.get(varRandomDetailsValue).getText());
		waitABit(1000);
/////		assertThat(AssertInviteEmailResentMessage.getText()).containsIgnoringCase("Email resent to ").overridingErrorMessage("ERROR: User success message not displayed");
//		System.out.println("==>1 AssertInviteEmailResentMessage getText ==> " +      AssertInviteEmailResentMessage.getText() );
//		System.out.println("==>1 AssertInviteEmailResentMessage getTextValue ==> " + AssertInviteEmailResentMessage.getTextValue() );
////		System.out.println("==>1 AssertInviteEmailResentMessage getTextValue ==> " + AssertInviteEmailResentMessage.getTextValue() );
//		System.out.println("==>2 AssertInviteResentTopMessage getTextValue ==> " +   AssertInviteResentTopMessage.getTextValue() );
		}
	}	
		
	
	public void clickOnInvitedUsersDetailsCloseButton() {
		InvitedUsersDetailsCloseButton.click();
	}
	
//	public void clickOnExpiredUserDetailsButton() {
//		List<String> expiredUserDetails = ListOfExpiredUsersDetails2.getSelectOptions();
//		ListOfExpiredUsersDetails2.selectByVisibleText(expiredUserDetails.get(DataGenerator.randomIntegerBetween(0,expiredUserDetails.size() - 1)));
//		ListOfExpiredUsersDetails2.click();
//	}
	
		
//	public void selectAnAppointmentCategoryRandomly() {
//		List<String> categoryOptions = appointmentCategoryDropdown.getSelectOptions();
//		appointmentCategoryDropdown.selectByVisibleText(categoryOptions.get(DataGenerator.randomIntegerBetween(0,categoryOptions.size() - 1)));
//	}
	
		
		
		
		
		
		
		
		
		
//		// create list
//		List<String> ListOfExpiredUsersDetails = new ArrayList<String>();
//		// iterate via "for loop"
//		System.out.println("==> List of Invited Users with Expired Status");
//		for (int i = 0; i < ListOfExpiredUsersDetails.size(); i++) {
//			System.out.println(ListOfExpiredUsersDetails.get(i));
//		}
//		
//		 Select objSel = new Select(ListOfExpiredUsersDetails2);
//		 List <WebElement> weblist = objSel.getOptions();
//		//Taking the count of items
//		 int iCnt = weblist.size();
//		 //Using Random class to generate random values
//		 Random num = new Random();
//		 int iSelect = num.nextInt(iCnt);
//		 //Selecting value from DropDownList
//		 objSel.selectByIndex(iSelect);
//		 //Selected Value
//		 System.out.println("List from 2nd -->" + ListOfExpiredUsersDetails2.getAttribute("value"));
//		 ListOfExpiredUsersDetails2.selectByIndex(iSelect).click();
//		 System.out.println("List from 2nd has been clicked-->" + iSelect);
//
//	}
//	
//	
	
	//clickOnAddUserOption
	public void clickOnAddUserOption(){
		addUser.click();
	}
	
	
	//typeIntoInvitedNewUserProfile
	public void typeIntoInvitedNewUserProfile(){
		typeIntoinviteFirstNameField();
		typeIntoinviteLastNameField();
		typeIntoInviteEmailAddressField();
		selectFromRoleTypeCode();
		clickOnSubmitInviteUserButton();

	}
	

	//typeIntoPopulateInviteNewUserProfile
	public void typeIntoPopulateInviteNewUserProfile(){
		
		//		typeIntoinviteFirstNameField();
//		typeIntoinviteLastNameField();
//		typeIntoInviteEmailAddressField();
//		selectFromRoleTypeCode();
		clickOnSubmitInviteUserButton();

	}

	
	
	
	//GP119
	public void typeIntoInvitedExistingUserProfile(){
		typeIntoinviteFirstNameField();
		typeIntoinviteLastNameField();
		typeIntoInviteExistingEmailAddressField();
		selectFromRoleTypeCode();
		clickOnSubmitInviteUserButton();
	}

	
	public void verifyUserAlreadyInvitedMessageDisplayed() {
		if (alertUserAlreadyInvitedMessage.isCurrentlyVisible()){
			System.out.println("This user is already a member of an organization.  Test Passes!!!");
		} else {
			System.out.println("This user is NOT a member of an organization. Test Fails!!!");
		}
	}
	

	
	
	
	
	
	//cancelInviteUser
	public void clickCancelInviteUser() {
		cancelInviteUser.click();
	}

	
	
	public void clickCancelInviteButton(){
		cancelInviteUser.click();
	}
	
	public void clickmodelAircraftButton() {
		click(modelAircraft);
	}

	public void clicknonModelAircraftButton() {
		click(nonModelAircraft);
	}

	public void clickOnRegisterButton() {
		registerButton.click();
	}
	
	
	public void typeIntoUsernameField(String username) {
		usernameField.type(username);
	}

	public void typeIntoPasswordField(String password) {
		passwordField.type(password);
	}

//	public void clickSubmitButton() {
//		submitButton.click();
//		waitABit(3000);
//		if (!invalidUsernameMessage.isCurrentlyVisible()) { // .containsText("Invalid username or password.")) {
//			System.out.println("Successfully Logged in...");
//		} else {
//			System.out.println("Invalid username or password."); 
//			String environment = serenityProperties.getProperty("app.base.host");
//			if (environment.equals("registermyuas-integration.faa.gov")){
//				String randomLogin = DataGenerator.randomNonHobbyistEmailLoginIntegration();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				submitButton.click();
//				System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
//			} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
//				String randomLogin = DataGenerator.randomEmailLoginTest();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				submitButton.click();
//				System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
//			} else if (environment.equals("registermyuas-stage.faa.gov")){
//				String randomLogin = DataGenerator.randomEmailLoginStage();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				submitButton.click();
//				System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
//			}
//			else
//				System.out.println("Invalid Messsage not found.  Logged in Successfully");
//		}
//	}	
//		}
//	}
//		Dimension errorMessageSize = invalidUsernameMessage.getSize();
//		if (errorMessageSize.equals(0) ){
//			System.out.println("Invalid Messsage not found.  Logged in Successfully");
//		} else {	
////		assertThat(invalidUsernameMessage.getText()).contains("Invalid username or password.");
//		if (invalidUsernameMessage.getSize().equals(0)){
		
//		if (invalidUsernameMessage.containsText("Invalid username or password.")) {
			
//		String user1 = 	invalidUsernameMessage.getText();
//		System.out.println("1 invalidUsernameMessage.getText() " + user1);
//		//invalidUsernameMessage.getTextValue();
//		String user2 = 	invalidUsernameMessage.getTextValue();
//		System.out.println("2 invalidUsernameMessage.getTextValue() " + user2);
//
//		String user3 = 	invalidUsernameMessage.getAttribute("Value");
//		System.out.println("3 invalidUsernameMessage.getAttribute(Value) " + user3);
//	
//		
////		assertEquals(invalidUsernameMessage, true);
//		
//		if (invalidUsernameMessage == null)
//		{

//		String environment = serenityProperties.getProperty("app.base.host");
//			if (environment.equals("registermyuas-integration.faa.gov")){
//				String randomLogin = DataGenerator.randomNonHobbyistEmailLoginIntegration();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				click(submitButton);
//				System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
//			} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
//				String randomLogin = DataGenerator.randomEmailLoginTest();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				click(submitButton);
//				System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
//			} else if (environment.equals("registermyuas-stage.faa.gov")){
//				String randomLogin = DataGenerator.randomEmailLoginStage();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				click(submitButton);
//				System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
//			}
//			else
//				System.out.println("Invalid Messsage not found.  Logged in Successfully");
//		}
//	}	
			
//		} catch (Exception  e){
//			e.printStackTrace();
//		}
//	}	
//		return null;
//	}
	
				
//			
//			if (invalidUsernameMessage.isVisible()){
//				String environment = serenityProperties.getProperty("app.base.host");
//				if (environment.equals("registermyuas-integration.faa.gov")){
//					String randomLogin = DataGenerator.randomNonHobbyistEmailLoginIntegration();
//					loginPage.typeIntoLoginField(randomLogin);
//					loginPage.typeIntoPasswordField("Dummy$11");
//					System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
//				} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
//					String randomLogin = DataGenerator.randomEmailLoginTest();
//					loginPage.typeIntoLoginField(randomLogin);
//					loginPage.typeIntoPasswordField("Dummy$11");
//					System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
//				} else if (environment.equals("registermyuas-stage.faa.gov")){
//					String randomLogin = DataGenerator.randomEmailLoginStage();
//					loginPage.typeIntoLoginField(randomLogin);
//					loginPage.typeIntoPasswordField("Dummy$11");
//					System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
//				}
//			}
////			click(submitButton);
//	} catch (noSuchElementException e){
//		return false;
//	} return true;
//
//}
			
//		
//		if (invalidUsernameMessage.isVisible()){
//			String environment = serenityProperties.getProperty("app.base.host");
//			if (environment.equals("registermyuas-integration.faa.gov")){
//				String randomLogin = DataGenerator.randomNonHobbyistEmailLoginIntegration();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				System.out.println("Logged in with an existing random account in Integration--->" + randomLogin);
//			} else if (environment.equals("public-gateway.test.csra-dronezone.com")){
//				String randomLogin = DataGenerator.randomEmailLoginTest();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				System.out.println("Logged in with an existing random account in Test--->" + randomLogin);
//			} else if (environment.equals("registermyuas-stage.faa.gov")){
//				String randomLogin = DataGenerator.randomEmailLoginStage();
//				loginPage.typeIntoLoginField(randomLogin);
//				loginPage.typeIntoPasswordField("Dummy$11");
//				System.out.println("Logged in with an existing random account in Stage--->" + randomLogin);
//			}
//			
//		}
//		click(submitButton);
//	}
	
	public void typeIntoNewPasswordField(String password1) {
		System.out.println("***New Password is ***" + password1 +"***");
		newPassword.type(password1);
		if (newPassword.isCurrentlyVisible()) {
			System.out.println("YES!!!, newPassword is isDisplayed..." + password1);
			//newPassword.clear();
			newPassword.type(password1);
		} else {
			System.out.println("NO!!!, newPassword is NOT isDisplayed...So we cannot enter it.  Test Ends..." + password1);	
		}
	}	
	
	public void typeIntoConfirmNewPasswordField(String password1) {
		//System.out.println("Confirm New Password is **" + password +"***");
		//confirmNewPassword.hasFocus();
		if (confirmNewPassword.isCurrentlyVisible()) {
			System.out.println("YES!!!, confirmNewPassword is isDisplayed..." + password1);
			//confirmNewPassword.clear();
			confirmNewPassword.type(password1);
		} else {
			System.out.println("NO!!!, confirmNewPassword is NOT isDisplayed...So we cannot enter it.  Test Ends..." + password1);	
		}
	}

	public void clickOnChangePasswordSubmitButton() {
		changePasswordSubmitButton.click();
//		successfullyChangedPasswordMessage.getValue();
//		assertThat(successfullyChangedPasswordMessage.getText()).containsIgnoringCase("You have successfully changed your password. You may now login.")
//		.overridingErrorMessage("ERROR: User change password message was not displayed");
	}

	
	
	
	public void pressShiftKey(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Keypress Shift Key to Open a New Browser" );
			robot.keyPress(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Pressed" );
//			robot.keyPress(KeyEvent.VK_TAB);	
//			System.out.println("Shift Key Pressed" );
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Released" );
//			robot.keyRelease(KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Released" );
//			System.out.println("Browser Tabs have been switched.");
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	public void switchPressControlTab(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Switching Tabs, Keypress Control Tab" );
			robot.keyPress(KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			robot.keyPress(KeyEvent.VK_TAB);	
			System.out.println("TAB Key Pressed" );
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Released" );
//			robot.keyRelease(KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Released" );
//			System.out.println("Browser Tabs have been switched.");
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchReleaseControlTab(){	
		waitABit(2000);	
		Robot robot;
		try {
			robot = new Robot();
			System.out.println("Release Control Tab Keys" );
			System.out.println("TAB Key keyRelease" );
			robot.keyRelease(KeyEvent.VK_TAB);	
			System.out.println("TAB Key keyRelease" );
			robot.keyRelease(KeyEvent.VK_CONTROL);
			System.out.println("Control Key keyRelease" );
//			robot.keyRelease(KeyEvent.VK_TAB);	
//			System.out.println("TAB Key keyRelease" );
//	robot.keyRelease(KeyEvent.VK_CONTROL);
//	System.out.println("Control Key Released" );
//	robot.keyRelease(KeyEvent.VK_TAB);	
//	System.out.println("TAB Key Released" );
//	System.out.println("Browser Tabs have been switched.");
	
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	//Switch Browser Tab	
	public void switchFaaBrowserTabs(){	
		waitABit(2000);
			Robot robot;
		try {

//			//Navigate from Left to Right
//			Actions action= new Actions(driver);
//			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();

			robot = new Robot();
			System.out.println("Switching Tabs" );
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			waitABit(1000);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);	
			System.out.println("TAB Key Pressed" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);	
			System.out.println("TAB Key Released" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Released" );

//			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);	
//			waitABit(1000);
//			System.out.println("TAB Key Pressed..Second Time" );
//			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Pressed..third Time" );
//			waitABit(1000);


			
//			System.out.println("Switching Tabs Again" );
//			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Pressed" );
//			waitABit(1000);
//			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Pressed" );
//			waitABit(1000);
//			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Released" );
//			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Released" );
//			
//			
//			//Navigate from Left to Right
//			Actions action= new Actions(driver);
//			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
			
	
			//
//			System.out.println("Switching Tabs" );
//			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Pressed 2" );
//			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Pressed2 " );
//			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Released 2" );
//			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);	
//			System.out.println("TAB Key Released 2" );
			
			//			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Pressed" );
//			robot.keyPress(java.awt.event.KeyEvent.VK_W);
//			System.out.println("W Key Pressed" );
//			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println("Control Key Released" );
//			robot.keyRelease(java.awt.event.KeyEvent.VK_W);	
//			System.out.println("W Key Released" );
		}
		catch (AWTException e)
		{
			System.out.println("Error has occured when attempting to Switch Browser Tabs!!");
			e.printStackTrace();
		}
	}
	
	public void switchBrowserTabs(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Switching Tabs" );
			robot.keyPress(KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			robot.keyPress(KeyEvent.VK_TAB);	
			System.out.println("TAB Key Pressed" );
			robot.keyRelease(KeyEvent.VK_CONTROL);
			System.out.println("Control Key Released" );
			robot.keyRelease(KeyEvent.VK_TAB);	
			System.out.println("TAB Key Released" );
			System.out.println("Browser Tabs have been switched.");
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//switchToNextTab
	public void switchToNextTab(){	
	waitABit(2000);
	Robot robot;
	try {
		robot = new Robot();
		System.out.println("Switch to the Next Tab" );
		robot.keyPress(KeyEvent.VK_CONTROL);
		System.out.println("Control Key Pressed" );
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);	
		System.out.println("Page Down Key Pressed" );
		robot.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println("Control Key Released" );
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);	
		System.out.println("Page Down Key Released" );
		System.out.println("Next Browser Tab has been switched.");
	
}
catch (AWTException e)
{
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	
	

	//Switch Browser Tab	
	public void closeFaaBrowserTabs(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Close Tab" );
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			robot.keyPress(java.awt.event.KeyEvent.VK_W);	
			System.out.println("W Key Pressed" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_W);	
			System.out.println("W Key Released" );
			System.out.println("Control Key Released" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Switch Browser Tab	
	public void switchFaaBrowserRefresh(){	
		waitABit(2000);
			Robot robot;
		try {

			robot = new Robot();
			System.out.println("Refresh Browser Window" );
			robot.keyPress(java.awt.event.KeyEvent.VK_F5);
			System.out.println("F5 Key Pressed" );
			waitABit(1000);
			robot.keyRelease(java.awt.event.KeyEvent.VK_F5);	
			System.out.println("F5 Key Released" );
		}
		catch (AWTException e)
		{
			System.out.println("Error has occured when attempting to Refresh Browser Window!!");
			e.printStackTrace();
		}
	}
	
	
	//Press W Key	
	public void wKeyPress(){	
		waitABit(2000);
			Robot robot;
		try {

			robot = new Robot();
			System.out.println("Press W Key" );
			robot.keyPress(java.awt.event.KeyEvent.VK_W);
			System.out.println("W Key Pressed" );
			waitABit(1000);
		}
		catch (AWTException e)
		{
			System.out.println("Error has occured when attempting to Refresh Browser Window!!");
			e.printStackTrace();
		}
	}
	
	//Press W Key	
	public void wKeyRelease(){	
		waitABit(2000);
			Robot robot;
		try {

			robot = new Robot();
			System.out.println("Release W Key" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_W);
			System.out.println("W Key Release" );
			waitABit(1000);
		}
		catch (AWTException e)
		{
			System.out.println("Error has occured when attempting to Refresh Browser Window!!");
			e.printStackTrace();
		}
	}
	
	
	
	
/////////////Invite New User Modal Window /////////////////////
	public void typeIntoinviteFirstNameField() {
		String randomFirstName = DataGenerator.randomFirstName();
		System.out.println("Random First Name-->" + randomFirstName);
		inviteFirstName.type(randomFirstName);
	}
	public void typeIntoModelFirstName(String inputText) {
		inviteFirstName.type(inputText);
	}

	
	public void typeIntoinviteLastNameField() {
		String randomLastName = DataGenerator.randomLastName();
		inviteLastName.type(randomLastName);
		System.out.println("Random Last Name-->" + randomLastName);
	}
	public void typeIntoModelLastName(String inputText) {
		inviteLastName.type(inputText);
	}

	
	public void typeIntoInviteEmailAddressField(){
		//Setting up a session variable
		String newInvitedEmailAccount = "mynewfaadrone+Invite" + DataGenerator.randomIntegerBetween(20,10000) + "@gmail.com";
		Serenity.setSessionVariable("newInvitedEmailAccount").to(newInvitedEmailAccount);
		inviteEmail.type(newInvitedEmailAccount);
		System.out.println("Random Invited Email Address-->" + newInvitedEmailAccount);
	} 

	public void typeIntoModelEmail(String inputText) {
		inviteEmail.type(inputText);
	}

	
	public void selectFromRoleTypeCode(String inputText) {
		inviteRoleCode.selectByVisibleText(inputText);
//		inviteRoleCode.type(inputText);
	}
	
	
	
	public void typeIntoInviteExistingEmailAddressField(){
		//Setting up a session variable
		String existingInvitedEmailAccount = "mynewfaadrone+Edge2@gmail.com";
		Serenity.setSessionVariable("newInvitedEmailAccount").to(existingInvitedEmailAccount);
		inviteEmail.type(existingInvitedEmailAccount);
		System.out.println("Random Invited Email Address-->" + existingInvitedEmailAccount);
	} 

//	public void selectModeRoleTypeCode(String inviteRoleCode) {
//		WebElementFacade dropdown =       inviteRoleCode;     // findWebElementByCssSelector(appointmentCategoryDropdownCssSelector);
//		dropdown.selectByValue(inviteRoleCode);
//		click(dropdown);
//	}

	public void selectARoleTypeCodeRandomly() {

//		//Drop Down List Physical Country
////		public void selectProfilePhysicalCountryDropDown(String country1) {
//			waitABit(1000);
//			if (inviteRoleCode.isCurrentlyVisible()){
//			Select dropDownList = new Select(inviteRoleCode);
//			dropDownList.selectByVisibleText(inviteRoleCode.trim());
//			createProfilePhysicalCountry.selectByVisibleText(inviteRoleCode);
//			System.out.println("Selected Physical Country from drop down list is..." + inviteRoleCode + "***" );
//			} else {
//				System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
//			}
//
//		}	
//
		List<String> categoryOptions = inviteRoleCode.getSelectOptions();
		inviteRoleCode.selectByVisibleText(categoryOptions.get(DataGenerator.randomIntegerBetween(0,categoryOptions.size() - 1)));
		System.out.println("Random Invited Role Code--> " + inviteRoleCode);
		System.out.println("Random Invited Role Code categoryOptions--> " + categoryOptions);
		
//		System.out.println("Randomly selected UAS Type Size is " + uasTypeDropdown.getSelectOptions().size());
//		String randomUasType = DataGenerator.randomUasType();
//		System.out.println("Randomly selected UAS Type from new text file is " + randomUasType);
//		uasTypeDropdown.selectByVisibleText(randomUasType);
//		System.out.println("Randomly selected UAS Type is " + getARandomUasType());
//		assertThat(uasTypeDropdownTitle.isCurrentlyVisible()).isTrue();

		
//    	Select dropDownList = new Select(inviteRoleCode);
//		dropDownList.selectByVisibleText(randomWord);

		
	}

//	public String selectModelARoleTypeCodeRandomly(String string) {
	public void selectModelRandomRoleTypeCode() {

//		//Drop Down List Physical Country
////		public void selectProfilePhysicalCountryDropDown(String country1) {
//			waitABit(1000);
//			if (inviteRoleCode.isCurrentlyVisible()){
//			Select dropDownList = new Select(inviteRoleCode);
//			dropDownList.selectByVisibleText(inviteRoleCode.trim());
//			createProfilePhysicalCountry.selectByVisibleText(inviteRoleCode);
//			System.out.println("Selected Physical Country from drop down list is..." + inviteRoleCode + "***" );
//			} else {
//				System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
//			}
//
//		}	
//
		List<String> categoryOptions = inviteRoleCode.getSelectOptions();
		inviteRoleCode.selectByVisibleText(categoryOptions.get(DataGenerator.randomIntegerBetween(0,categoryOptions.size() - 1)));
		System.out.println("Random Invited Role Code--> " + inviteRoleCode);
		System.out.println("Random Invited Role Code categoryOptions--> " + categoryOptions);
		Select dropDownList = new Select(inviteRoleCode);
//		dropDownList.selectByVisibleText(inviteRoleCode);
//		return null;
		
//		System.out.println("Randomly selected UAS Type Size is " + uasTypeDropdown.getSelectOptions().size());
//		String randomUasType = DataGenerator.randomUasType();
//		System.out.println("Randomly selected UAS Type from new text file is " + randomUasType);
//		uasTypeDropdown.selectByVisibleText(randomUasType);
//		System.out.println("Randomly selected UAS Type is " + getARandomUasType());
//		assertThat(uasTypeDropdownTitle.isCurrentlyVisible()).isTrue();

		
//    	Select dropDownList = new Select(inviteRoleCode);
//		dropDownList.selectByVisibleText(randomWord);

		
	}

	
	
//	public void selectModeRoleTypeCode(String inviteRoleCodeString) {
//		Select dropDownList = new Select(inviteRoleCodeString);
//		dropDownList.selectByVisibleText(randomWord);
//		System.out.println("Selected from Role Type Drop Down List-->" + randomWord);
//		inviteRoleCode.selectByValue(inviteRoleCodeString);
//	}
	
	public void  selectFromRoleTypeCode() {
		//String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
			  Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/role_types.txt"));
			  //Path pathToMyTextFile = Paths.get("C:/Users/jfrankl6/workspacex/faa-gradle-newtest/src/test/java/faa/utils/role_types.txt");
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Role Code Random min-->" + max);
		        System.out.println("Role Code Random max-->" + min);
		        System.out.println("Role Code  Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Role Types 4-->" + randomWord);
//		        System.out.println("returnValue Random Role Types -->" + returnValue);
//		        returnValue = randomWord;
//		        System.out.println("returnValue Random Role Types -->" + returnValue);
		    	Select dropDownList = new Select(inviteRoleCode);
				dropDownList.selectByVisibleText(randomWord);
				System.out.println("Selected from Role Type Drop Down List-->" + randomWord);
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
//			Select dropDownList = new Select(inviteRoleType);
//			dropDownList.selectByVisibleText(roleType);
//			System.out.println("Selected from Role Type Drop Down List-->" + roleType);
		  //return returnValue;
	}
	
	public void selectFromRoleTypeCodeWorks() {
		String roleType = DataGenerator.randomRoleType();
			if (roleType  == null){
			roleType = "Organization Administrator";
			System.out.println("New Role Type is-->" + roleType);
			}
			inviteRoleCode.click();
			Select dropDownList = new Select(inviteRoleCode);
			dropDownList.selectByVisibleText(roleType);
			System.out.println("Selected from Role Type Drop Down List-->" + roleType);
			//
//			Select selectByVisibleText = new Select (inviteRoleCode);
//			selectByVisibleText.selectByVisibleText(roleType);
		}

	
	
	public void clickOnSubmitInviteUserButton() {
		submitInviteUser.click();
	}
	
/////////////Invite New User Accept Invitaion Window /////////////////////

	//invitePassword
	public void typeIntoAcceptPasswordField() {
		waitABit(2000);
//		WebDriver driver = new ChromeDriver();
//		//Get the current window handle
//		String windowHandle = driver.getWindowHandle();
//		//Get the list of window handles
//		ArrayList tabs = new ArrayList (driver.getWindowHandles());
//		System.out.println(tabs.size());
//		//Use the list of window handles to switch between windows
//		driver.switchTo().window(tabs.get(0));
//
//		//Switch back to original window
//		driver.switchTo().window(mainWindowHandle);
//		
//		
		
//		WebDriver driver = new ChromeDriver();
//		driver.close();
//		driver.manage().window().maximize();  //Seems to open and maximizes a new blank window
		System.out.println("Enter Accept Invitation Password");
		//invitePassword.type("Dummy$11");
//		if (formAcceptInvitation.isCurrentlyVisible()){
//			System.out.println("formAcceptInvitation is visible!!!!!!!!!!!!!");
//		}		
//		System.out.println("formAcceptInvitation Accept Invitation is Not displayed");
//		if (invitePassword.isCurrentlyVisible()){
//			System.out.println("invitePassword is visible!!!!!!!!!!!!!");
//		} else {
//			System.out.println("invitePassword is NOT visible!!!!!!!!!!!!!");
//			switchPressControlTab();
//			waitABit(1000);
//			switchReleaseControlTab();
//			waitABit(1000);
//			////////////////////////////switchFaaBrowserTabs();
//			////////////System.out.println("Switch Browser Tabs");
//			}	

//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        System.out.println("Tab Size -->" + tabs2.size());
 //       int tabSize = tabs2.size();
        //driver.switchTo().defaultContent();
        
        //        driver.switchTo().window(tabs2.get(tabSize - 1));
//
//        
//        Robot robot2 = new Robot();
//        robot2.keyPress(KeyEvent.VK_CONTROL);
//        robot2.keyPress(KeyEvent.VK_TAB);
//        robot2.keyRelease(KeyEvent.VK_TAB);
//        robot2.keyRelease(KeyEvent.VK_CONTROL);
        System.out.println("Title 1-->" + getTitle());
//        driver.close();
//        driver.switchTo().parentFrame();
		System.out.println("Password can now be entered-->");
			String varInvitePassword = "Dummy$11";
//			if (invitePassword.isCurrentlyVisible()){
//				System.out.println("invitePassword is still visible!!!!!!!!!!!!!");
//			} else {
//				System.out.println("invitePassword is STILL NOT visible!!!!!!!!!!!!!");

//				switchPressControlTab();
//				switchReleaseControlTab();
//		        System.out.println("Title 2-->" + getTitle());
				//clickOnSubmitAcceptInvitationButton();
//				inviteConfirmPassword.type("Dummy");
//				inviteConfirmPassword.clear();
//		        System.out.println("Title 3-->" + getTitle());
//				invitePassword.clear();
//				invitePassword.type("Dummy");
//				waitABit(2000);
				invitePassword.clear();
				invitePassword.type(varInvitePassword);
				//switchFaaBrowserTabs();
//				invitePassword.type(varInvitePassword);
//			}	
//			invitePassword.type(varInvitePassword);
			System.out.println("Password-->" + varInvitePassword);
		}

	//inviteConfirmPassword
	public void typeIntoAcceptInvitationPasswordField() {
		System.out.println("Enter Accept Invitation Password");
		String varInvitePassword = "Dummy$11";
		invitePassword.type(varInvitePassword);
		System.out.println("Password-->" + varInvitePassword);
	}
	
	//inviteConfirmPassword
	public void typeIntoAcceptInvitationConfirmPasswordField() {
		System.out.println("Enter Accept Invitation Confirm Password");
		String varInviteConfirmPassword = "Dummy$11";
		inviteConfirmPassword.type(varInviteConfirmPassword);
		System.out.println("Confirm Password-->" + varInviteConfirmPassword);
	}

	
	//submitAcceptInvitation
	public void clickOnSubmitAcceptInvitationButton() {
		submitAcceptInvitation.click();
		System.out.println("Accept Invitation Submit Button has been clicked");
		
	}
	
	
}
