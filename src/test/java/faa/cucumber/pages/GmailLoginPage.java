package faa.cucumber.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Properties;
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;

import org.apache.xmlbeans.impl.common.XPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import faa.utils.DataGenerator;
import net.serenitybdd.core.Serenity;

//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.DriverSource;

/**
 * @authors jfranklin
 */
public class GmailLoginPage extends BasePageObject {
	FaaHomePage faaHomePage;
	LoginPage loginPage;
	public static Properties serenityProperties;
	
	@FindBy(id = "gmail-sign-in") private WebElementFacade gmailSignInLink;
	@FindBy(id = "Email") private WebElementFacade gmailEmailField;
	@FindBy(id = "next") private WebElementFacade gmailNextButton;
	@FindBy(id = "Passwd") private WebElementFacade gmailPasswordField;
	@FindBy(id = "signIn") private WebElementFacade gmailSignInButton;
	
	//password
	@FindBy(id = "password") private WebElementFacade changePassword;
	//confirmPassword
	@FindBy(id = "confirmPassword") private WebElementFacade changeConfirmPassword;
	/** Click on the link within the gmail account page.   **/

	@FindBy(xpath = "//button[@data-value='myfaadrone@gmail.com'  and @type='submit' ]") private WebElementFacade gmailChooseAccountLink;

	/** Click on the gmail COMPOSE Email Button.   **/
	@FindBy(xpath = "//div[@role='button' and contains(text(), 'COMPOSE')]") private WebElementFacade gmailComposeButton;
	
	//Gmail Delete Messages Button 
	@FindBy(xpath = "//div[@class='ar9 T-I-J3 J-J5-Ji']") private WebElementFacade clickOnGmailDeleteMessageButton;
	
	//Gmail Select Option Menu  
	@FindBy(xpath = "//div[@data-tooltip='Select' and @aria-label='Select']") private WebElementFacade gmailSelectOptionMenu;

	//Select All email conversations to delete
	@FindBy(xpath = "//span[@class='x8' and @role='link']") private WebElementFacade gmailSelectAllConversationsFromInbox;

	//Select OK button to delete All conversations
	@FindBy(xpath = "//button[@name='ok' and contains(text(), 'OK')]") private WebElementFacade gmailOKBulkConversationsDeleteFromInbox;
	
	
	@FindBy(xpath = "//div[@class='J-N' and @selector='all' contains(text(),'All')]") private WebElementFacade gmailSelectAllOptionMenu;

	
	@FindBy(id = "account-chooser-link") private WebElementFacade gmailSignInDifferentAccountLink;
	/**"click on the gmail message Confirm your account with the FAA sUAS Registration Site 
	 * table tbody tr td div div div span */ 
	@FindBy(css = "table tbody tr td div div div span ") private WebElementFacade openGmailConfirmationMessage;
	
//	Confirm your account with the FAA sUAS Registration Site
	@FindBy(css = "a[href*='https://accounts.google.com/Logout']") private WebElementFacade gmailSignOutButton;
	
		
	@FindBy(id = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]")  private WebElementFacade openGmailMessage;

	@FindBy(css = "a[href*='https://registermyuas-integration.csra-dronezone.com/verify?sptoken']") WebElementFacade gmailClickToVerifyAccount;
	
	//@FindBy(css = "a[href*='https://registermyuas-integration.csra-dronezone.com/change?sptoken']") WebElementFacade gmailClickToResetPassword;
	//@FindBy(css = "a[href*='https://registermyuas-integration.csra-dronezone.com/change?sptoken']") WebElementFacade gmailClickToResetPassword;
	@FindBy(xpath = "//a[starts-with(@href,'https://public-gateway.csra-dronezone.com')]") WebElementFacade gmailClickToResetPassword;
	
	@FindBy(xpath = "//div[@class='aRv' and contains(text(),'Your Primary tab is empty.')]") private WebElementFacade gmailAccountInboxIsEmpty;
	
	//Gmail Account to Sign Out button
	@FindBy(xpath = "	//a[starts-with(@title,'Google Account') and starts-with(@href,'https://accounts.google.com/SignOutOptions')]") private WebElementFacade clickOnGmailAccountToLogOutIcon;

//	//	@FindBy(xpath = "//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span") private WebElementFacade clickOnGmailAccountToLogOutIcon;
//	//a[starts-with(@href,'https://accounts.google.com/Logout') and contains(text(),'Sign out')]
//	https://accounts.google.com/Logout?hl=en&continue=https://mail.google.com/mail&service=mail&timeStmp=1478549440&secTok=.AG5fkS_5CMMb-geitS2LFEQ4PLCrDFwUjw
		
	
	//Gmail Sign out button
	@FindBy(xpath = "//a[starts-with(@href,'https://accounts.google.com/Logout') and contains(text(),'Sign out')]") private WebElementFacade gmailAccountSignOutButton;
	
	/** Click on the link within the Inbox to open the Email to Confirm Forgot Password Reset   **/
	@FindBy(xpath = "//span[@class='y2' and contains(text(), 'received a request to reset the password for this email address. To reset your password, please click on this link or cut and paste')]") private WebElementFacade gmailLinkToForgotPassword;
	
	/** Click on the link within the Inbox to open the Email to Confirm your email account.   **/
	@FindBy(xpath = "//span[@class='y2' and contains(text(), 'Thank you for creating an account with the FAA Small Unmanned Aircraft System')]") private WebElementFacade gmailLinkToConfirmNewAccount;

	/** Click on the link within the Inbox to open the Email to Change Primary Email Address.   **/
	@FindBy(xpath = "//span[@class='y2' and contains(text(), 'Please enter the verification code to complete your primary email change')]") private WebElementFacade gmailLinkToChangePrimaryEmail;
	
	//Gmail Change Primary Email Verification Code

	//@FindBy(xpath = "//div[starts-with(@class,'a3s aXjCH')]/div/p") private WebElementFacade gmailChangePrimaryEmailVerificationCode;
	//div:nth-child(2) > p
	//@FindBy(xpath = "//div[@id=':jc']//div/p[1]") private WebElementFacade gmailChangePrimaryEmailVerificationCode;
	@FindBy(css = "div[class*='a3s aXjCH'] div p:nth-child(2)") private WebElementFacade gmailChangePrimaryEmailVerificationCode;
	//div[class^='a3s aXjCH'] div p:nth-child(2)
	
	/** Integration Environment Gateway Click on the link within the email to Confirm your email account.   **/
	@FindBy(xpath = "//a[starts-with(@href,'https://public-gateway.csra-dronezone.com')]") private WebElementFacade gmailEmailLinkToConfirmIntNewAccount;
	/** Test Environment Gateway Click on the link within the email to Confirm your email account.   **/
	@FindBy(xpath = "//a[starts-with(@href,'https://public-gateway.test.csra-dronezone.com')]") private WebElementFacade gmailEmailLinkToConfirmTestNewAccount;
	
	/** Click on the link within the email to Confirm your email account.   **/
	@FindBy(xpath = "//span[@class='y2' and contains(text(), 'Your account with the FAA Small Unmanned Aircraft System (sUAS) Registration Site has been successfully verified')]") private WebElementFacade gmailEmailLinkToVerifyAccountRegistration;

	//This will check to see if the email address has already been entered
	@FindBy(xpath="//span[@id='reauthEmail' and contains(text(),'myfaadrone@gmail.com')]") private WebElementFacade faaExitingEmailDisplayed;
	
	
	//a[starts-with(@href,'https://registermyuas') and contains(text(), 'Click here to accept your invitation')]
	@FindBy(xpath="//a[contains(@href,'public-gateway.csra-dronezone.com') and contains(text(), 'Click here to accept your invitation')]") private WebElementFacade acceptYourIntegretionInvitationLink;
	@FindBy(xpath="//a[contains(@href,'public-gateway.test.csra-dronezone.com') and contains(text(), 'Click here to accept your invitation')]") private WebElementFacade acceptYourTestInvitationLink;
	@FindBy(xpath="//a[contains(@href,'public-gateway.stage.csra-dronezone.com') and contains(text(), 'Click here to accept your invitation')]") private WebElementFacade acceptYourStageInvitationLink;
	
	

	/** Click on the link within the Inbox to open the Email to Confirm your email account.   **/
	@FindBy(xpath = "//span[@class='y2' and contains(text(), 'You have been invited to join')]") private WebElementFacade gmailMessageInvitation;

	
	/** Displays the "successfully verified your account" message   **/
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/p") private WebElementFacade successfullyVerifiedNewAccount;

	
	
	//Old Show trimmed content of email message
	@FindBy(xpath = "//div[@data-tooltip='Show trimmed content' and @aria-label='Show trimmed content']") private WebElementFacade gmailShowTrimmedContent;


//	//New Show trimmed content of email message
//	@FindBy(xpath = "//div[@aria-label='Show trimmed content' and @data-tooltip='Hide expanded content']") private WebElementFacade gmailShowTrimmedContent;

	
	public void typeIntoChangePasswordField() {
			changePassword.type("Dummy$11");
		}

	public void typeIntoChangeConfirmPasswordField() {
		changeConfirmPassword.type("Dummy$11");
	}

	public void clickGmailAccountVerifiedMessageForResult(int resultNum) {
		List<WebElementFacade> searchResultTable = findAll(By.xpath("//span[contains(text(), 'Account verified')]"));
		for(WebElementFacade w : searchResultTable){
            System.out.println(w.isCurrentlyVisible());
    		System.out.println("list of Gmail Inbox messages text:" + searchResultTable.get(resultNum) );
        }
		if ((searchResultTable.size() != 0))
			searchResultTable.get(0).waitUntilEnabled();
		if (searchResultTable.size() >= (resultNum * 2)) {
			click(searchResultTable.get(((resultNum - 1) * 2) + 0));
		} else {
			System.out.println("Jay Error: No table action taken!");
		}
	}
	
	
	//List of all Messages in Gmail inbox where the Subject begins ith 'Confirm your account'
	public List<WebElementFacade> gmailConfirmYourAccountMessageFromInbox(){
		return findAll(By.xpath("//span[contains(text(), 'Confirm your account')]"));
	}

	//Link to Gmail Inbox
	@FindBy(xpath="//a[contains(text(), 'Inbox')]") private WebElementFacade gmailInboxEmailLink;  
	

	
	
	//List of inbox messages 
	@FindBy(css = "span[email='myfaadrone+111@gmail.com']") private WebElementFacade gmailEmailAddress;

	
	public List<WebElementFacade> gmailMessageListFromInbox(){
		return findAll(By.cssSelector("td[class='xY a4W'] div div div span[class='y2']"));
	}

	
	
	@FindBy(css = "td[class='xY a4W']") private WebElementFacade firstGmailMessageFromInbox;
	//Click on the first gmail message in Inbox
	public void clickOnFirstGmailMessageFromInbox() {
		waitABit(1000);
		firstGmailMessageFromInbox.click();
	}
	public void clickOnGmailOKBulkConversationsDeleteFromInbox() {
		gmailOKBulkConversationsDeleteFromInbox.click();
	}
	
	
	public void clickOnGmailSignInLink() {
		gmailSignInLink.click();
		//Serenity.takeScreenshot();
	}
	public void clickOnGmailInboxEmailLink() {
		gmailInboxEmailLink.click();
		//Serenity.takeScreenshot();
	}
	
	
	public void clickOnAcceptYourInvitation() {
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to wait for Accept Your Invitation Message to be displayed... " + i);
			if (gmailMessageInvitation.isCurrentlyVisible()){
			i=19;
			if (gmailMessageInvitation.isCurrentlyVisible()){
				gmailMessageInvitation.click();
				System.out.println("Gmail Messages is visible");
			} else {
				System.out.println("Message is not visible");
			}
			System.out.println("Verify the Gmail Accept Your Invitation Message is visible on the screen");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}
		System.out.println("Click to Accept Your Invitation");
		clickOnGmailGmailShowTrimmedContentLink();
		//Serenity.takeScreenshot();
		waitABit(1000);
        System.out.println("Title 1-->" + getTitle());
		//This is a string identifier for the current window so that we can find it later
		String windowHandleBefore = getDriver().getWindowHandle();
        System.out.println("Title 2-->" + getTitle());
		if (acceptYourIntegretionInvitationLink.isCurrentlyVisible()){
			 System.out.println("Integration Environment--> public-gateway.csra-dronezone.com");
			 acceptYourIntegretionInvitationLink.click();
		} else if (acceptYourTestInvitationLink.isCurrentlyVisible()){
			 System.out.println("Test Environment--> public-gateway.test.csra-dronezone.com");
			 acceptYourTestInvitationLink.click();
		} else if (acceptYourStageInvitationLink.isCurrentlyVisible()){
			 System.out.println("Stage Environment--> public-gateway.stage.csra-dronezone.com");
			 acceptYourStageInvitationLink.click();
		}
        System.out.println("Title 3-->" + getTitle());
		//Then you want to search for any new handles that may be present (there should now be 2)
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
		}
		waitABit(1000);
		//Then you would want to do whatever actions you want on the new page here
		loginPage.clickOnIAgreeButton();
		faaHomePage.typeIntoAcceptInvitationPasswordField();
		faaHomePage.typeIntoAcceptInvitationConfirmPasswordField();
		//Serenity.takeScreenshot();
		faaHomePage.clickOnSubmitAcceptInvitationButton();
		//Serenity.takeScreenshot();
//		faaHomePage.typeIntoAcceptPasswordField();
//		faaHomePage.typeIntoAcceptConfirmPasswordField();
////	    System.out.println("Title 4-->" + getTitle());
//		faaHomePage.clickOnSubmitAcceptInvitationButton();
		//When you're done switch back to the original saved window handle
		getDriver().switchTo().window(windowHandleBefore);
        System.out.println("Title 5-->" + getTitle());
		System.out.println("Entered Password, Confirm Password and clicked the Submit Button to complete the Invitation process");
	}
	


	public void clickOnGmailGmailShowTrimmedContentLink() {
		if (gmailShowTrimmedContent.isCurrentlyVisible()){
		gmailShowTrimmedContent.click();
		System.out.println("gmailShowTrimmedContent is visible and has been clicked");
		}
	}

	
	
	//gmailComposeButton
	public void clickOnGmailComposeButton() {
		gmailComposeButton.click();
	}
	
	
	public void clickOnSelectAllFromGmailInbox() {
		gmailInboxEmailLink.click();
	}
		
	public void gmailEmailLinkToConfirmNewAccount() {
		////Serenity.takeScreenshot();
		//////////shiftKeyPressBrowserTabs();
		//Serenity.takeScreenshot();
		waitABit(1000);
        System.out.println("Title 1-->" + getTitle());
		//This is a string identifier for the current window so that we can find it later
		String windowHandleBefore = getDriver().getWindowHandle();
        System.out.println("Title 2-->" + getTitle());
		switchBrowserTabs();
        System.out.println("Title 3-->" + getTitle());
//		System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
//		String environment = serenityProperties.getProperty("app.base.host");
		if (gmailEmailLinkToConfirmIntNewAccount.isCurrentlyVisible()){
			 System.out.println("Integration Environment--> public-gateway.csra-dronezone.com");
			gmailEmailLinkToConfirmIntNewAccount.click();
		} else if (gmailEmailLinkToConfirmTestNewAccount.isCurrentlyVisible()){
			 System.out.println("Integration Environment--> public-gateway.test.csra-dronezone.com");
			gmailEmailLinkToConfirmTestNewAccount.click();
		}
			waitABit(7000);
		//Then you want to search for any new handles that may be present (there should now be 2)
//		for (String winHandle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(winHandle);
//		}
		//loginPage.clickOnIAgreeButton();
/////		switchBrowserTabs();
//		System.out.println("5 Second Delay to make sure confirmation completes");
//		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
//			waitABit(5000);
//			System.out.println("Loop Count to display Successfully Verified New Account message... " + i);
//			if (successfullyVerifiedNewAccount.isCurrentlyVisible()){
//			i=19;
//			//gmailEmailLinkToVerifyAccountRegistration.click();//attempt to click the element
//			System.out.println("Verify Account Registration Email message has been received and clicked. ");
//			}
//			else 
//			{
//			System.out.println("could not click element.. Trying again in 5 seconds");
//			waitABit(5000);//wait 3 seconds before trying to click again
//			}
//		}
//		//When you're done switch back to the original saved window handle
//		getDriver().switchTo().window(windowHandleBefore);
//        System.out.println("Title 5-->" + getTitle());

//		closeBrowserTabs();
	}
	
	//Account Verified message in Email
	public void gmailEmailLinkToVerifyAccountRegistration() {
		waitABit(3000);
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to verify Account Registration... " + i);
			if (gmailEmailLinkToVerifyAccountRegistration.isCurrentlyVisible()){
			i=19;
			gmailEmailLinkToVerifyAccountRegistration.click();//attempt to click the element
			System.out.println("Verify Account Registration Email message has been received and clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		
		}	
		clickOnGmailInboxEmailLink();
		////Serenity.takeScreenshot();
		System.out.println("Inbox clicked!");
		clickOnGmailAccountToSignOutButton();
		clickOnGmailSignOutButton();
		System.out.println("!!!Test Completed!!!");
	}
	
	
	//Switch Browser Tab	
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
			System.out.println("Browsers Tabs have been switched.");
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//Switch Browser Tab	
	public void closeBrowserTabs(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Close Tab" );
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			robot.keyPress(java.awt.event.KeyEvent.VK_W);	
			System.out.println("W Key Pressed" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Released" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_W);	
			System.out.println("W Key Released" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Open a new Browser Tab	
	public void openNewBrowserTab(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Open New Browser Tab" );
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			robot.keyPress(java.awt.event.KeyEvent.VK_T);	
			System.out.println("T Key Pressed" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			System.out.println("Control Key Released" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_T);	
			System.out.println("T Key Released" );
			System.out.println("New Browser Tab has been opened" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	//KeyPress the Shift Key	
	public void shiftControlKeyPress(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Control" );
			robot.keyPress(KeyEvent.VK_CONTROL);
			System.out.println("Control Key Pressed" );
			System.out.println("Shift" );
			robot.keyPress(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Pressed" );
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//KeyPress the Shift Key	
	public void shiftControlKeyRelease(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Control" );
			robot.keyRelease(KeyEvent.VK_CONTROL);
			System.out.println("Control Key Released" );
			System.out.println("Shift" );
			robot.keyRelease(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Released" );
			
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//KeyPress the Tab Key	
	public void TabKeyPress(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Tab Key" );
			robot.keyPress(KeyEvent.VK_TAB);
			System.out.println("Tab Key Pressed" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//KeyPress the Tab Key	
	public void TabKeyRelease(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Tab Key" );
			robot.keyRelease(KeyEvent.VK_TAB);
			System.out.println("Tab Key Released" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	//Close Browser window
	public void closeBrowserWindow(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Close Browser Window" );
			robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
			System.out.println("Alt Key Pressed" );
			robot.keyPress(java.awt.event.KeyEvent.VK_F4);	
			System.out.println("Alt-F4 Key Pressed" );
			System.out.println("Close Browser Window" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
			System.out.println("Alt-F4 Key Released" );
			robot.keyRelease(java.awt.event.KeyEvent.VK_F4);	
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	//KeyPress the Shift Key and Release it	
	public void shiftKeyPressAndReleaseShiftKey(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Press the Shift Key" );
			robot.keyPress(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Pressed" );
			System.out.println("Release the Shift Key" );
			robot.keyRelease(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Released" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	//KeyPress the Shift Key	
	public void pressShiftKey(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Press Shift Key" );
			robot.keyPress(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Pressed" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//KeyRelease the Shift Key	
	public void releaseShiftKey(){	
		waitABit(2000);
			Robot robot;
		try {
			robot = new Robot();
			System.out.println("Release Shift Key" );
			robot.keyRelease(KeyEvent.VK_SHIFT);
			System.out.println("Shift Key Released" );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

	public void clickOnGmailMessageToVerifyAccount() {
		gmailClickToVerifyAccount.click();
	}
	
	public void clickOnGmailAccountToSignOutButton() {
		System.out.println("Selected gmail Sign out button");
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to click on Gmail Account Log out " + i);
			if (clickOnGmailAccountToLogOutIcon.isCurrentlyVisible()){
			i=19;
			clickOnGmailAccountToLogOutIcon.click();
			System.out.println("Sign out of Account has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}	
	}

	public void clickOnGmailSignOutButton() {
		waitABit(2000);
		System.out.println("Selected Account Sign Out button");
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to click on Gmail Log out " + i);
			if (gmailAccountSignOutButton.isCurrentlyVisible()){
			i=19;
			gmailAccountSignOutButton.click();
			System.out.println("Sign out has been clicked. ");
			}
			else 
			{
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}	
	}

	
	
	
	
	public void gmailClickToResetPassword() {
		waitABit(1000);
		System.out.println("Robot to Click to Reset your Password");
	      System.out.println("Title 1-->" + getTitle());
			//This is a string identifier for the current window so that we can find it later
			String windowHandleBefore = getDriver().getWindowHandle();
	        System.out.println("Title 2-->" + getTitle());
			gmailClickToResetPassword.click();
	        System.out.println("Title 3-->" + getTitle());
			//Then you want to search for any new handles that may be present (there should now be 2)
			for (String winHandle : getDriver().getWindowHandles()) {
	            getDriver().switchTo().window(winHandle);
			}
			String varNewPassword = "Dummy$11";
			//Then you would want to do whatever actions you want on the new page here
			faaHomePage.typeIntoNewPasswordField(varNewPassword);
			faaHomePage.typeIntoConfirmNewPasswordField(varNewPassword);
	        System.out.println("Title 4-->" + getTitle());
	        faaHomePage.clickOnChangePasswordSubmitButton();
			//When you're done switch back to the original saved window handle
			getDriver().switchTo().window(windowHandleBefore);
	        System.out.println("Title 5-->" + getTitle());
	        System.out.println("Password Test complete, Password has been changed");
	}
	
	
	public void clickOnGmailDeleteMessageButton() {
		System.out.println("Delete button is being clicked");
		if (!clickOnGmailDeleteMessageButton.isCurrentlyVisible()) {
			System.out.println("Delete button is NOT visible, so no action needs to be taken.  Exit Gmail");
		} else {
			for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to wait for Delete Message to Appear... " + i);
			if (clickOnGmailDeleteMessageButton.isCurrentlyVisible()){
				i=19;
				clickOnGmailDeleteMessageButton.click();//attempt to click the element
			System.out.println("Delete Email message has been received and clicked. ");
			}
			else {
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}	
	}
}
	

	
	public void gmailLinkToForgotPassword(){
		waitABit(3000);
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to Forgot Password... " + i);
			if (gmailLinkToForgotPassword.isCurrentlyVisible()){
				i=19;
				gmailLinkToForgotPassword.click();
				System.out.println("Gmail Link to Forgot Password has been clicked");
			}
			else {
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}
	}

	public void clickOnGmailLinkToConfirmAccount() {
		waitABit(3000);
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to Confirm Account Registration... " + i);
			if (gmailLinkToConfirmNewAccount.isCurrentlyVisible()){
				i=19;
				gmailLinkToConfirmNewAccount.click();//attempt to click the element
				//gmailLinkToConfirmNewAccount.click();//attempt to click the element
				waitABit(1000);
			System.out.println("Confirm Account Registration Email message has been received and clicked. ");
			}
			else {
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}	
	}	
	
	
	
	public void clickOnGmailLinkToChangePrimaryEmail() {
		waitABit(3000);
		for(int i = 0 ; i < 20;i++){ //attempt to click the element 5 times
			waitABit(5000);
			System.out.println("Loop Count to Change Primary Email... " + i);
			if (gmailLinkToChangePrimaryEmail.isCurrentlyVisible()){
				i=19;
				gmailLinkToChangePrimaryEmail.click();//attempt to click the element
				System.out.println("Opened Email to change Primary Email");
				//System.out.println("Old Value of gmailChangePrimaryEmailVerificationCode before the test is run 2-->" +	gmailChangePrimaryEmailVerificationCode.getText());
				waitABit(2000);
				//getGmailChangePrimaryEmailVerificationCode();
				if (gmailChangePrimaryEmailVerificationCode.isCurrentlyVisible()){
				gmailChangePrimaryEmailVerificationCode.click();//clicking element came from idea on the web to click it before reading value.
				String varPrimaryEmailChangeVerificationCode = gmailChangePrimaryEmailVerificationCode.getText();   //.getAttribute("value");
				System.out.println("varPrimaryEmailChangeVerificationCode--> Gmail Change Primary Email Verification Code-->" + varPrimaryEmailChangeVerificationCode);
				Serenity.setSessionVariable("primaryEmailChangeVerificationCode").to(varPrimaryEmailChangeVerificationCode);
				String updatedprimaryEmailChangeVerificationCode = Serenity.sessionVariableCalled("primaryEmailChangeVerificationCode").toString();
				System.out.println("updatedprimaryEmailChangeVerificationCode--> Gmail Change Primary Email Verification Code-->" + updatedprimaryEmailChangeVerificationCode);
				System.out.println("Confirm Change Primary Email message has been received and clicked. ");
				}
			}
			else {
			System.out.println("could not click element.. Trying again in 5 seconds");
			waitABit(5000);//wait 3 seconds before trying to click again
			}
		}	
	}	

	//get Gmail Change Primary Email Verification Code
	public void getGmailChangePrimaryEmailVerificationCode() {
//	public String getGmailChangePrimaryEmailVerificationCode() {
//		String value = gmailChangePrimaryEmailVerificationCode.getText();
//		System.out.println("Gmail Change Primary Email Verification Code-->" + value); 
//		String varPrimaryEmailChangeVerificationCode = gmailChangePrimaryEmailVerificationCode.getText();
//		Serenity.setSessionVariable("primaryEmailChangeVerificationCode").to(varPrimaryEmailChangeVerificationCode);
//		System.out.println("Gmail Change Primary Email Verification Code-->" + varPrimaryEmailChangeVerificationCode);
		//return gmailChangePrimaryEmailVerificationCode.getAttribute("value");
	}

	
	
	
	public void clickOnGmailEmailLinkToConfirmNewAccount() {
		pressShiftKey();
		gmailEmailLinkToConfirmIntNewAccount.click();
		releaseShiftKey();
	}

		

	//Gmail Select Option Menu
	public void clickOnGmailSelectOptionMenu() {
		if (gmailAccountInboxIsEmpty.isCurrentlyVisible()){
			System.out.println("The Gmail Inbox is currently empty.  No action is required.");
		} else {  
			gmailSelectOptionMenu.click();
			System.out.println("Selected gmailSelectAllConversationsFromInbox is Visible...I will click it");
			System.out.println("Selected gmailSelectAllConversationsFromInbox has been clicked");
			}
		}
	
	//Gmail Select All Option Menu
	public void clickOnGmailSelectAllOptionMenu() {
		gmailSelectAllOptionMenu.click();
	}


	
	public void confirmYourAccountGmailList(String inputText) {
		Select dropDownList = new Select(gmailClickToVerifyAccount);
		dropDownList.selectByVisibleText(inputText.trim());
		System.out.println("Selected State Name inputText is " + inputText);
		System.out.println("Select State Name is " + gmailClickToVerifyAccount);
		List<WebElement> options = dropDownList.getOptions();
		for (WebElement option : options) {
		    System.out.println(option.getText()); //Prints "Option", followed by "Not Option"
		}
	}	


	//gmailChooseAccountLink
	public void clickOnGmailChooseAccountButton() {
		waitABit(1000);
		System.out.println("Selected button for myfaadrone Account");
		gmailChooseAccountLink.click();
	}

	
	public void clickOnConfirmationGmailMessage() {
		waitABit(1000);
		click(openGmailConfirmationMessage);
	}

	public void clickOnGmailMessage() {
		waitABit(1000);
		openGmailMessage.click();
	}

	
	public void typeIntoGmailEmailAddressField(String input) {
		if (clickOnGmailAccountToLogOutIcon.isPresent()){
			clickOnGmailAccountToSignOutButton();
			clickOnGmailSignOutButton();
		}
		else
		if (gmailChooseAccountLink.isCurrentlyVisible()){
			clickOnGmailChooseAccountButton();
			typeIntoMyFaaGmailPasswordField("Dummy$11");
			ClickOnGmailSignInButton();
		}
		else
		{
			
		}
		
	}
	
	

	//Check to see if I am already logged in/
	//If already logged in, this will log the user out and then enter password to log back into Gmail.
	public void typeIntoGmailPasswordField(String inputText) {
		gmailPasswordField.type(inputText);
		ClickOnGmailSignInButton();
}

	//GmailNextButton
	public void ClickOnGmailNextButton() {
		waitABit(1000);
		System.out.println("Click the Gmail Next Button");
		gmailNextButton.click();
	}

	//GmailSignInButton
	public void ClickOnGmailSignInButton() {
		waitABit(1000);
		System.out.println("Click the Gmail Sign in Button");
		gmailSignInButton.click();
	}
	
	public void typeIntoEmailField(String inputText) {
		if (faaExitingEmailDisplayed.isCurrentlyVisible()){
			System.out.println("Email Address already entered...Do Nothing");
		} else {
		gmailEmailField.type(inputText);
		ClickOnGmailNextButton();
		}
	}	

/*	changePassword
	changeConfirmPassword
*/
	public void typeIntoNewFaaEmailField(String inputText) {
		if (faaExitingEmailDisplayed.isCurrentlyVisible()){
			System.out.println("Email Address already entered...Do Nothing");
		} else {
		gmailEmailField.type(inputText);
		ClickOnGmailNextButton();
		}
	}	

	
	
	
//	//gmailPasswordField
	public void typeIntoMyFaaGmailPasswordField(String inputText) {
		gmailPasswordField.type(inputText);
	}


	public void clickToOpenNewBrowserTab() {
//		gmailLoginPage.clickToOpenNewBrowserTab();
		//This is a string identifier for the current window so that we can find it later
//		String windowHandleBefore = getDriver().getWindowHandle();
//        System.out.println("WindowHandleBefore 1-->" + windowHandleBefore);
		openNewBrowserTab();
		//Then you want to search for any new handles that may be present (there should now be 2)
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
            System.out.println("winHandle 2-->" + winHandle);
		}
		System.out.println("Confirmed opening of a new browser tab");
//		System.out.println("WindowHandleBefore 3-->" + windowHandleBefore);
		
	}

	public void clickToSwitchBrowserTabs() {
		//This is a string identifier for the current window so that we can find it later
		String windowHandleBefore = getDriver().getWindowHandle();
        System.out.println("Title Browser Switch-->" + getTitle());
//		gmailLoginPage.switchBrowserTabs();
		switchBrowserTabs();
		//Then you want to search for any new handles that may be present (there should now be 2)
		for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
		}
		 System.out.println("Title Browser Switch 2-->" + getTitle());
		System.out.println("Confirmed click on the Switch browser tabs");
	}

}

