/**
 * Add New UAS Page
 */
package faa.cucumber.pages;

//import static org.testng.AssertJUnit.assertEquals;
import static org.junit.Assert.*;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;
//import faa.utils.PageSourceParser;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;

/** @author jfranklin */
public class AddNewUasPage extends BasePageObject {

	BillingInformationPage billingInformationPage;
	GmailLoginPage gmailLoginPage;
	String expectedUasTypePurchased = "Purchased";
	String expectedUasTypeHomeBuilt = "Home Built";

	String limitOf50Message1 = "was added to your Shopping Cart. The limit of";
	String limitOf50Message2 = "Shopping Cart limit of";

	/**
	 * Shopping Cart limit of 50 has been displayed from the "Add UAS" Button
	 **/
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(), 'was added to your Shopping Cart. The limit of')]")
	private WebElementFacade shoppingCartlimitOf50Message1;

	/**
	 * Shopping Cart limit of 50 has been displayed from the "Add UAS" Button
	 **/
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(), 'Shopping Cart limit of')]")
	private WebElementFacade shoppingCartlimitOf50Message2;

	/** Verify the UAS Type Home Built **/
	@FindBy(xpath = "//div[contains(text(), 'Home Built')]")	private WebElementFacade verifyUasTypeHomeBuilt;
	/** Verify the UAS Type Purchased **/
	@FindBy(xpath = "//div[contains(text(), 'Purchased')]")	private WebElementFacade verifyUasTypePurchased;

	/** Verify the UAS Details Title **/
	@FindBy(xpath = "//h1[@id='myModalLabel' and contains(text(), 'UAS Details')]")	private WebElementFacade verifyUasDetailsTitle;

	/** UAS Type Page **/
	@FindBy(css = "#assetAcquiredType") 	private WebElementFacade assetAcquiredType;
	/** Add UAS Page **/
	@FindBy(xpath = "//button[@id='addUasCartButton' and contains(text(), 'Add UAS')]")	private WebElementFacade addUasToCartButton;
	// Modal Label
	@FindBy(xpath = "//h1[@id='myModalLabel' and contains(text(), 'Add New UAS')]")	private WebElementFacade myModalLabel;
	/** Check Out Button **/
	@FindBy(xpath = "//button[@id='proceedToCheckoutCart' and contains(text(), 'Checkout')]")	private WebElementFacade checkOutButton;

	/** Check box for acknowledgment of the FAA Requirements **/
	/**
	 * Checking the 'acknowledge' checkbox acknowledging the FAA requirements
	 **/
	// @FindBy(css = "input#acknowledge") protected WebElementFacade
	// checkTheAcknowledgeBox;
	@FindBy(xpath = "//input[@id='acknowledge']") 	protected WebElementFacade checkTheAcknowledgeBox;

	/** Check Out Next Button //input[contains(@title, 'Next')] **/
	@FindBy(xpath = "//button[@id='next' and contains(text(), 'Next')]")	private WebElementFacade checkAcknowledgeNextButton;

	// body#body div div div div div div div div h1
	/** Congratulations for completing payment **/
	@FindBy(css = "body#body div div div div div div div div h1")	private WebElementFacade congratulationsConfirmationText;
	@FindBy(xpath = "//select[@id='uasType']")	private WebElementFacade uasTypeDropdown;
	@FindBy(xpath = "//input[@id='nickname']")	private WebElementFacade assetNickname;
	@FindBy(xpath = "//input[@id='manufacturer']")	private WebElementFacade manufacturer;
	@FindBy(xpath = "//input[@id='model']")	private WebElementFacade model;
	@FindBy(xpath = "//input[@id='serialNumber']")	private WebElementFacade serialNumber;

	//Titles on 'Add New UAS' Modal screen
	@FindBy(xpath = "//select[@title='Select UAS type. This is a required field.']")	private WebElementFacade uasTypeDropdownTitle;
	@FindBy(xpath = "//input[@title='Enter a Nickname. This is a required field.']")	private WebElementFacade assetNicknameTitle;
	@FindBy(xpath = "//input[@title='Enter a Manufacturer. This is a required field.']")	private WebElementFacade manufacturerTitle;
	@FindBy(xpath = "//input[@title='Enter a Model. This is a required field.']")	private WebElementFacade modelTitle;
	@FindBy(xpath = "//input[@title='Enter a Serial Number. This is a required field.']")	private WebElementFacade serialNumberTitle;
	
	
	
	
	/** Clicking on the 'Add' button on the Add New UAS Modal Page **/
	@FindBy(xpath = "//button[@id='primaryButtonSubmit' and contains(text(), 'Add UAS')]")	protected WebElementFacade clickOnAddSubmitButton;

	/** Clicking on the 'Done' Link when user has finished adding New UAS **/
	@FindBy(xpath = "//button[@id='primaryButtonDone' and contains(text(), 'Done')]")	protected WebElementFacade clickOn50DoneButton;

	/**
	 * Clicking on the 'Done' button on the Add New UAS Page when the count gets
	 * to 50
	 **/
	@FindBy(xpath = "//button[@id='Done_button' and contains(text(), 'Done')]")	protected WebElementFacade clickOnDoneButton;

	
	@FindBy(xpath = "//button[@id='returnToDashboard' and contains(text(), 'Done')]")	private WebElementFacade paymentDoneButton;

	
	//oKButton and shoppingCartLimitReachedMessage
	/**
	 * click on the Secondary OK button showing that our shopping cart has maxed
	 * out to hit the 50
	 **/
	@FindBy(xpath = "//button[@id='cartLimitOkButton' and contains(text(), 'Ok')]")	private WebElementFacade cartLimitOkButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Shopping Cart Limit Reached')]" ) private WebElementFacade shoppingCartLimitReachedMessage;
	
	@FindBy(xpath = "//h1[@class='modal-title' and contains(text(), 'Add New UAS')]")	private WebElementFacade addNewUasTitle;

	/**
	 * OK button appears when trying to cancel a UAS that was recently edited
	 **/
	@FindBy(xpath = "//button[@id='okModalButton' and contains(text(), 'Ok')]")	private WebElementFacade editedUasOkButton;
	/** cloneUasFlag Clone Previous UAS check box **/
	@FindBy(xpath = "//input[@id='cloneUasFlag' and contains(text(), 'Clone Previous UAS')]")	private WebElementFacade cloneUasFlag;
	/** Ellipse Menu Clone Button **/
	@FindBy(xpath = "//span[@class='icon-clone' and contains(text(), 'Clone')]")	private WebElementFacade ellipseMenuClone;
	/** Add New UAS Page **/
	@FindBy(xpath = "//button[class='bt n btn-primary'][@type='button']")	private WebElementFacade submitButton;
	/** Click the Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-remote']")	private WebElementFacade modelAircraft;
	/** Click the Non-Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-heads']")	private WebElementFacade nonModelAircraft;
	/** Edit UAS Page Save Button **/
	// static final String editUasSaveButtonCssSelector = "#body >
	// div.modal.fade.ng-isolate-scope.in > div > div > div > form > div > div >
	// div.col-md-4.col-sm-6.col-xs-12.text-center > button";
	@FindBy(xpath = "//button[@id='saveUAS' and contains(text(), 'Save')]")	private WebElementFacade editUasSaveButton;

	@FindBy(xpath = "//h1[@class='modal-title nma-km-bottom' and contains(text(), 'Which email address should we send to')]") private WebElementFacade userHasAltEmailAddress;
	@FindBy(xpath = "//h1[@class='modal-title nma-km-bottom' and contains(text(), 'Email Registration Certificate')]") private WebElementFacade userHasNoAltEmailAddress;	
	
	@FindBy(xpath = "//button[@id='hobResendEmailButton' and contains(text(), 'Email')]")	private WebElementFacade resendEmailCertificateButton;
	@FindBy(xpath = "//button[@id='emailCertificate' and contains(text(), 'Email Certificate')]")	private WebElementFacade sendEmailCertificateButton;
	@FindBy(xpath = "//button[@id='dismissModal' and contains(text(), 'Return to Dashboard')]")	private WebElementFacade returnToDashboardButton;

	@FindBy(xpath = "//h1[@class='modal-title nma-km-bottom' and contains(text(), 'Which email address should we send to?')]")	private WebElementFacade whichEmailAddressModalTitle;

	
	/** primary Email **/
	@FindBy(xpath = "//input[@id='primaryEmail']")	private WebElementFacade primaryEmailRadioButton;
	/** Alternate Email **/
	@FindBy(xpath = "//input[@id='alternateEmail']")	private WebElementFacade alternateEmailRadioButton;

	/** Return To Inventory Button **/
	@FindBy(xpath = "//button[@id='returnToInventory' and contains(text(), 'Return to Inventory')]")	private WebElementFacade returnToInventoryButton;

	/**
	 * <p>
	 * NonModelAircraftButtonCssSelector Button Css Selector Click this Button
	 * to Add a New UAS
	 **/
	static final String NonModelAircraftButtonCssSelector = "body#body div div div div div div div div.icon-heads";

	public WebElementFacade elementLocatedByCss(String cssLocator) {
		return find(By.cssSelector(cssLocator));
	}

	/** check to see if the shopping cart of 50 has been met. **/
	@FindBy(xpath = "//a[@class='uas-cart' and contains(text(), '$250.00')]")	private WebElementFacade maxSizeOf50InCartLink;

	public void shoppingCartLimitMessageIsVisible() {
		elementLocatedByCss("body#body div div div div div div div div p span.ng-binding")
				.shouldContainText("Shopping Cart limit of 50 has been reached. Please continue to checkout.");
	}

	public void clickOnMaxSizeOf50InCartLink() {
		System.out
				.println("Max size of 50 in shopping cart has been reached.  Must complete payment before continuing");
		click(maxSizeOf50InCartLink);
	}

	// cloneUasFlag
	public void checkCloneUasFlag() {
		waitABit(2000);
		System.out.println("Check Clone UAS Flag checkbox ");
		cloneUasFlag.click();
	}
	// //ellipseMenuClone
	// public void clickOnEllipseMenuCloneButton() {
	// waitABit(2000);
	// System.out.println("Click On Ellipse Menu Clone Button");
	// ellipseMenuClone.click();
	// }

	// editedUasOkButton
	public void clickOnOkModalButton() {
		waitABit(2000);
		System.out.println("Click On Ellipse Menu Clone Button");
		editedUasOkButton.click();
	}

	// click on Non-Model Aircraft Complete Your Profile Button
	public void clickOnNonModelAircraftButton() {
		waitABit(2000);
		System.out.println("Click on the NonModelAircraftButtonCssSelector button ");
		click(NonModelAircraftButtonCssSelector);
	}

	// Edit UAS Save Button
	public void clickOnEditUasSaveButton() {
		waitABit(2000);
		System.out.println("Click on the Edit UAS Save button with New xpath ID");
		editUasSaveButton.click();
	}

	public String getMyModalLabel() {
		return myModalLabel.getAttribute("value");
	}

	public void clickOnPrimaryEmailRadioButton() {
		waitABit(1000);
		System.out.println("Click on the Primary Email Radio Button");
		primaryEmailRadioButton.click();
	}

	public void clickOnAlternateEmailRadioButton() {
		waitABit(1000);
		System.out.println("Click on the Alternate Email Radio Button");
		alternateEmailRadioButton.click();
	}

	public void clickOnReturnToInventoryButton() {
		waitABit(1000);
		System.out.println("Click on the Return To Inventory Button");
		returnToInventoryButton.click();
	}

	// editUasEmailCertificateButton
	// Edit UAS Email Certificate Button
	public void clickOnEmailPrimaryCertificateButton() {
		waitABit(2000);
		System.out.println("Send email to primary email address");
		if (resendEmailCertificateButton.isCurrentlyVisible()){
		// waitForElement(editUasSaveButtonCssSelector);
		clickOnResendEmailCertificateButton();
		if (userHasAltEmailAddress.isCurrentlyVisible()){
			System.out.println("User has a Primary and Alternate Email Address");	
			clickOnPrimaryEmailRadioButton();
			clickOnSendEmailCertificateButton();
			System.out.println("Just sent email to primary email address");
		} else if (userHasNoAltEmailAddress.isCurrentlyVisible()){
			System.out.println("No certificate available to send to Primary Email Address");
			clickOnSendEmailCertificateButton();
		}
	} else {
		System.out.println("User does not have an Alternate Email Address");	
	}
}		

	public void clickOnEmailAlternateCertificateButton() {
		waitABit(2000);
		System.out.println("Send email to alternate email address");
		if (resendEmailCertificateButton.isCurrentlyVisible()){
		clickOnResendEmailCertificateButton();
		if (userHasAltEmailAddress.isCurrentlyVisible()){
			System.out.println("User has an Alternate Email Address");	
		clickOnAlternateEmailRadioButton();
		clickOnSendEmailCertificateButton();
		System.out.println("Just sent email to alternate email address");
		} else if (userHasNoAltEmailAddress.isCurrentlyVisible()){
			System.out.println("No certificate available to send to Primary Email Address");
			clickOnSendEmailCertificateButton();
		}
		} else {
			System.out.println("User does not have an Alternate Email Address");	
	}
}
		
		
		
		
		
		
		
		
		
	// Send the Email Certificate Button
	public void clickOnResendEmailCertificateButton() {
		waitABit(2000);
		System.out.println("Click on the Resend Email Certificate button");
		resendEmailCertificateButton.click();
	}
	
	// Send the Email Certificate Button
	public void clickOnSendEmailCertificateButton() {
		waitABit(2000);
		System.out.println("Click on the Email Certificate button");
		if (whichEmailAddressModalTitle.isCurrentlyVisible()) {
		sendEmailCertificateButton.click();
	} else {
		System.out.println("Email address modal window is not displayed.  No further action can be performed");
		}
	}		
	
	
	// Add UAS Button
	public void clickToAddOneUas() {
		if (addUasToCartButton.isCurrentlyVisible()) {
			System.out.println("Add UAS Button is clicked--Adding Only 1 UAS");
				clickToAddUasButton();
			}
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoModelNumberField();
			typeIntoSerialNumberField();
			clickAddSubmitButton();
			clickOnDoneButton();
			LogToFile.write(getTitle());
			LogToFile.write("GP-23");
			LogToFile.write("Add UAS");
			LogToFile.write("As a non-hobbyist user, I need to be able to add UAS to my shopping cart so that I can register them");
			waitABit(1000);
			
	}	
	

	
	
	
//	public void writeToCsc() {
//	    public static void main(String[]args) throws FileNotFoundException{
//		PrintWriter pw = null;
//		try {
//			FileWriter pw = new FileWriter("F:\\data.csv",true); 
//		    pw = new PrintWriter(new File("C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.csv"));
//		} catch (FileNotFoundException e) {
//		    e.printStackTrace();
//		}
//	        StringBuilder sb = new StringBuilder();
//	        sb.append("id");
//	        sb.append(',');
//	        sb.append("Name");
//	        sb.append('\n');
//
//	        sb.append("1");
//	        sb.append(',');
//	        sb.append("Prashant Ghimire");
//	        sb.append('\n');
//	        pw.write(sb.toString());
//	        pw.close();
//	        System.out.println("done!");
//	    }
//	
//	
	
	
	
	
	// Add UAS Button
	public void clickOnAddUasButton() {
		if (addUasToCartButton.isCurrentlyVisible()) {
			System.out.println("Add UAS Button is clicked--Adding UAS");
			// click(addUasButton);
			clickToAddUasButton();
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoModelNumberField();
			typeIntoSerialNumberField();
			clickAddSubmitButton();
			clickOnDoneButton();
			waitABit(1000);
			billingInformationPage.clickOnSortByShoppingCartNicknameButton();
			waitABit(500);
			billingInformationPage.clickOnSortByShoppingCartManufacturerButton();
			waitABit(500);
			billingInformationPage.clickOnSortByShoppingCartModelButton();
			waitABit(500);
			billingInformationPage.clickOnSortByShoppingCartSerialNumberButton();
			waitABit(500);
			billingInformationPage.clickOnSortByShoppingCartSerialNumberButton();
			billingInformationPage.clickOnShoppingCartEllipseButton();
			billingInformationPage.clickOnShoppingCartEllipseEditButton();
			typeIntoSerialNumberField();
			clickOnEditUasSaveButton();
			waitABit(1000);
			billingInformationPage.clickOnShoppingCartEllipseButton();
			billingInformationPage.clickOnShoppingCartEllipseCloneButton();
			typeIntoManufacturerNameField();
			clickAddSubmitButton();
			clickOnDoneButton();
			waitABit(1000);
			billingInformationPage.clickOnShoppingCartEllipseButton();
			billingInformationPage.clickOnShoppingCartEllipseRemoveButton();
			waitABit(1000);
			billingInformationPage.clickOnShoppingCartUndoRemovalButton();

			// Complete payment process
			clickOnCheckOutButton();
			checkTheAcknowledgeBox();
			clickOnAcknowledgeNextButton();
			billingInformationPage.typeIntoCardNumber();
			billingInformationPage.typeCvcNumber();
			billingInformationPage.selectARandomExpirationMonth();
			billingInformationPage.selectARandomExpirationYear();
			billingInformationPage.typeIntoBillingFirstName();
			billingInformationPage.typeIntoBillingLastName();
			billingInformationPage.selectARandomCountry(); // United States
			billingInformationPage.typeIntoBillingAddress1();
			billingInformationPage.typeIntoBillingAddress2();
			billingInformationPage.typeIntoBillingCity();
			billingInformationPage.selectBillingState();
			billingInformationPage.typeIntoBillingZip();
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			waitABit(1000);
			billingInformationPage.clickOnViewInventoryButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseEditButton1();
			// assertEquals(expectedUasTypePurchased,
			// billingInformationPage.getVerifyUasTypePurchased());
			billingInformationPage.clickOnCancelButton();
			waitABit(1000);
			billingInformationPage.clickOnEllipse1Button();
			waitABit(1000);
			billingInformationPage.clickOnEllipseCancelButton();
			billingInformationPage.clickOnReturnToInventoryButton();
			waitABit(1000);
			billingInformationPage.clickOnSortByNicknameButton();
			billingInformationPage.clickOnSortByManufacturerButton();
			billingInformationPage.clickOnSortByModelButton();
			billingInformationPage.clickOnSortBySerialNumberButton();
			billingInformationPage.clickOnSortByRegistrationButton();
			billingInformationPage.clickOnSortByIssuedButton();
			billingInformationPage.clickOnSortByExpiresButton();
			billingInformationPage.clickOnSortByStatusButton();
			billingInformationPage.clickOnSortByIssuedButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseEditButton1();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoSerialNumberField();
			typeIntoModelNumberField();
			waitABit(2000);
			clickOnEditUasSaveButton();
			waitABit(2000);
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseEmailButton();
			waitABit(1000);
//			clickOnEmailCertificateButton();
			System.out.println("!!!Email Certificate Test Completed-Adding UAS!!!");
			waitABit(1000);
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseCloneButton();
			// Add New UAS from a Clone
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoSerialNumberField();
			typeIntoModelNumberField();
			clickAddSubmitButton();
			clickOnDoneButton();

			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseDetailsButton();
			System.out.println("!!!Click On Ellipse Details Button Test Completed!!!");
			getAssetAcquiredType();

			if (verifyUasTypePurchased.isVisible()) {
				System.out.println("Purchased UAS is shown");
			} else if (verifyUasTypeHomeBuilt.isVisible()) {
				System.out.println("Home Built UAS is shown");
			}
			billingInformationPage.clickOnReturnToInventoryButton();
			System.out.println("Return Button Clicked");
			billingInformationPage.clickOnRegisteredInventory1();
			System.out.println("Opens PDF Certificate");
			waitABit(2000);
			gmailLoginPage.switchBrowserTabs();
			System.out.println("Confirmed click on the close browser tabs");
		} else if (maxSizeOf50InCartLink.isVisible()) {
			System.out.println("Max size of 50 in shopping cart is visible");
			clickOnCheckOutButton();
			checkTheAcknowledgeBox();
			clickOnAcknowledgeNextButton();
			billingInformationPage.typeIntoCardNumber();
			billingInformationPage.typeCvcNumber();
			billingInformationPage.selectARandomExpirationMonth();
			billingInformationPage.selectARandomExpirationYear();
			billingInformationPage.typeIntoBillingFirstName();
			billingInformationPage.typeIntoBillingLastName();
			billingInformationPage.selectARandomCountry(); // United States
			billingInformationPage.typeIntoBillingAddress1();
			billingInformationPage.typeIntoBillingAddress2();
			billingInformationPage.typeIntoBillingCity();
			billingInformationPage.selectBillingState();
			billingInformationPage.typeIntoBillingZip();
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			billingInformationPage.clickOnViewInventoryButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseEditButton1();
			// assertEquals(expectedUasTypePurchased,
			// billingInformationPage.getVerifyUasTypePurchased());
			billingInformationPage.clickOnCancelButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseDetailsButton();
			if (verifyUasTypeHomeBuilt.isVisible()) {
				System.out.println("Home Built UAS is shown");
			}
			if (verifyUasTypePurchased.isVisible()) {
				System.out.println("Purchased UAS is shown");
			}
			billingInformationPage.clickOnReturnToInventoryButton();
			billingInformationPage.clickOnRegisteredInventory1();
			System.out.println("Opens PDF Certificate");
			gmailLoginPage.switchBrowserTabs();
			System.out.println("Confirmed click on the close browser tabs");
		} else if (cartLimitOkButton.isVisible()) {
			System.out.println(
					"Secondry OK Button is clicked, max shopping cart size of 50 has been added.  Complete payment process now");
			clickOnCartLimitOkButton();
			clickOnCheckOutButton();
			checkTheAcknowledgeBox();
			clickOnAcknowledgeNextButton();
			billingInformationPage.typeIntoCardNumber();
			billingInformationPage.typeCvcNumber();
			billingInformationPage.selectARandomExpirationMonth();
			billingInformationPage.selectARandomExpirationYear();
			billingInformationPage.typeIntoBillingFirstName();
			billingInformationPage.typeIntoBillingLastName();
			billingInformationPage.selectARandomCountry(); // United States
			billingInformationPage.typeIntoBillingAddress1();
			billingInformationPage.typeIntoBillingAddress2();
			billingInformationPage.typeIntoBillingCity();
			billingInformationPage.selectBillingState();
			billingInformationPage.typeIntoBillingZip();
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			billingInformationPage.clickOnViewInventoryButton();

			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseCloneButton();

			// Add New UAS from a Clone
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoSerialNumberField();
			typeIntoModelNumberField();
			clickAddSubmitButton();
			clickOnDoneButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseEditButton1();
			assertEquals(expectedUasTypePurchased, billingInformationPage.getVerifyUasTypePurchased());
			billingInformationPage.clickOnCancelButton();
			billingInformationPage.clickOnEllipse1Button();
			billingInformationPage.clickOnEllipseDetailsButton();
			billingInformationPage.clickOnReturnToInventoryButton();
			billingInformationPage.clickOnRegisteredInventory1();
			System.out.println("Opens PDF Certificate");
			gmailLoginPage.switchBrowserTabs();
			System.out.println("Confirmed click on the close browser tabs");
		}
	}

	public void clickToAddMultipleUAS() {
		//// Works/////
		System.out.println("Add 50 UAS ");
		System.out.println("Add Button is here ");
		waitABit(2000);
		addUasToCartButton.click();
		System.out.println("Add UAS Button is clicked ");
		for (int x = 1; x < 51; x++) { // Beginning of FOR LOOP!
			System.out.println("BEGINNING of For Loop " + x + " to Add 50 New UAS");
			waitABit(2000);
			if (clickOnAddSubmitButton.isCurrentlyVisible()) {
				System.out.println("clickOnAddSubmitButton is visible, Now Select a random UAS Type!!! ");
				selectARandomUasType();
				System.out.println("Random UAS Type has been selected");
				typeIntoNicknameField();
				typeIntoManufacturerNameField();
				typeIntoModelNumberField();
				//Serenity.takeScreenshot();
				typeIntoSerialNumberField();
				System.out.println("UAS has been added.  Now click the Add Submit Button to save");
				clickAddSubmitButton();
				if (x > 47) {
					waitABit(2000);
					System.out.println("Shopping cart is getting full. Give us a 2 second delay for UAS Number-->" + x);
				} 
				if (shoppingCartLimitReachedMessage.isCurrentlyVisible() && cartLimitOkButton.isCurrentlyVisible()){
					clickOnCartLimitOkButton();
					System.out.println("Max of 50 UASs have been added to shopping cart.  Click the Done Button and Continue to payment process.");
					x = 50;
				}
				//oKButton and shoppingCartLimitReachedMessage
//				if (maxSizeOf50InCartLink.isCurrentlyVisible() | clickOn50DoneButton.isCurrentlyVisible()) {
//					System.out.println(
//							"Max of 50 UASs have been added to shopping cart.  Click the Done Button and Continue to payment process.");
//					clickOn50DoneButton();
//					x = 50;
//				}
				//Serenity.takeScreenshot();
				waitABit(1000);
				System.out.println("Count of New UAS's Added is " + x);
			}
			System.out.println("END of For Loop " + x + " to Add fifty New UASs");
		}
		System.out.println("END of For Loop to Add Fifty New UASs.  Now Begin payment process.");

		// if (maxSizeOf50InCartLink.isCurrentlyVisible() |
		// clickOn50DoneButton.isCurrentlyVisible()){
		// System.out.println("Max of 50 UASs have been added to shopping cart.
		// Continue to payment process.");
		// clickOn50DoneButton();
		// }
		// clickOnDoneButton();
		System.out.println("Else Done Button has been clicked ");
		waitABit(2000);
		clickOnCheckOutButton();
		System.out.println("clickOnCheckOutButton Button has been clicked ");
		//Serenity.takeScreenshot();
		waitABit(1000);
		System.out.println("Checkout Button has been clicked ");
		checkTheAcknowledgeBox();
		System.out.println("checkTheAcknowledgeBox has been clicked ");
		//Serenity.takeScreenshot();
		clickOnAcknowledgeNextButton();
		System.out.println("clickOnAcknowledgeNextButton has been clicked ");
		//Serenity.takeScreenshot();
		waitABit(1000);
		System.out.println("Then continue with payment!!");
		System.out.println("Count of New UAS's Added has reached my limit...for this test ");
		waitABit(1000);
		System.out.println("Outer Else Checkout Button has been clicked ");
		billingInformationPage.typeIntoCardNumber();
		billingInformationPage.typeCvcNumber();
		//Serenity.takeScreenshot();
		billingInformationPage.selectARandomExpirationMonth();
		billingInformationPage.selectARandomExpirationYear();
		billingInformationPage.typeIntoBillingFirstName();
		billingInformationPage.typeIntoBillingLastName();
		billingInformationPage.selectARandomCountry(); // United States
		billingInformationPage.typeIntoBillingAddress1();
		billingInformationPage.typeIntoBillingAddress2();
		billingInformationPage.typeIntoBillingCity();
		billingInformationPage.selectBillingState();
		billingInformationPage.typeIntoBillingZip();
		billingInformationPage.clickOnBillingNextButton();
		billingInformationPage.clickOnReviewAcknowledgmentButton();
		billingInformationPage.clickOnReviewPayButton();
		//Serenity.takeScreenshot();
		billingInformationPage.clickOnDoneButton();    
	}	

	
	
/**		--

//Serenity.takeScreenshot();
		billingInformationPage.clickOnSortByNicknameButton();
		billingInformationPage.clickOnSortByManufacturerButton();
		billingInformationPage.clickOnSortByModelButton();
		billingInformationPage.clickOnSortBySerialNumberButton();
		billingInformationPage.clickOnSortByRegistrationButton();
		billingInformationPage.clickOnSortByIssuedButton();
		billingInformationPage.clickOnSortByExpiresButton();
		billingInformationPage.clickOnSortByStatusButton();
		//Serenity.takeScreenshot();
		billingInformationPage.clickOnSortByIssuedButton();
		billingInformationPage.clickOnSortByIssuedButton();
		billingInformationPage.clickOnSortByExpiresButton();
		billingInformationPage.clickOnEllipse1Button();
		billingInformationPage.clickOnEllipseCancelButton();
		waitABit(3000);
		System.out.println("**3 second wait before selecting a random Cancel Reason**");
		// Retrieve list of Categories in TEST
		// List<String> listOfCancelReasons =
		// billingInformationPage.getListOfCancelReasons();
		// int cancelReasonsIndex =
		// DataGenerator.randomIntegerBetween(1,listOfCancelReasons.size() - 1);
		// // From District drop down list
		// //createSchedulePage.selectCategories(listOfCancelReasons.get(cancelReasonsIndex));
		// billingInformationPage.selectRandomCancelReason(listOfCancelReasons.get(cancelReasonsIndex));
		billingInformationPage.selectRandomCancelReason();
		billingInformationPage.clickOnConfirmCancelRegistrationCheckbox();
		billingInformationPage.clickOnCancelRegistrationButton();
		billingInformationPage.clickOnReturnToInventoryButton();
		System.out.println("***Return to Inventory***");
		//Serenity.takeScreenshot();
		System.out.println("689***Click on Ellipse Button***");
		billingInformationPage.clickOnEllipse1Button();
		System.out.println("691***Just Clicked on Ellipse Button***");
		billingInformationPage.clickOnEllipseEmailButton();
		System.out.println("693***Just Clicked om Email Ellipse Button***");
		//Serenity.takeScreenshot();
		waitABit(1000);
		System.out.println("696***Click om Email Certification Button***");
//		clickOnEmailCertificateButton();
		System.out.println("698***Just Clicked on Email Certification Button***");
		System.out.println("!!!Email Certificate Test Completed Adding 50 UAS!!!");
		waitABit(1000);
		billingInformationPage.clickOnEllipse1Button();
		billingInformationPage.clickOnEllipseCloneButton();
		// Add New UAS from a Clone
		selectARandomUasType();
		typeIntoNicknameField();
		typeIntoManufacturerNameField();
		typeIntoSerialNumberField();
		typeIntoModelNumberField();
		//Serenity.takeScreenshot();
		clickAddSubmitButton();
		clickOnDoneButton();
		//Serenity.takeScreenshot();
		System.out.println("New Inventory has been added, Then continue with payment!!");
		if (checkOutButton.isCurrentlyVisible()) {
			clickOnCheckOutButton();
			System.out.println("Click On the Checkout Button...So the Payment Begins");
			checkTheAcknowledgeBox();
			clickOnAcknowledgeNextButton();
			//Serenity.takeScreenshot();
			billingInformationPage.typeIntoCardNumber();
			billingInformationPage.typeCvcNumber();
			billingInformationPage.selectARandomExpirationMonth();
			billingInformationPage.selectARandomExpirationYear();
			billingInformationPage.typeIntoBillingFirstName();
			billingInformationPage.typeIntoBillingLastName();
			billingInformationPage.selectARandomCountry(); // United States
			billingInformationPage.typeIntoBillingAddress1();
			billingInformationPage.typeIntoBillingAddress2();
			billingInformationPage.typeIntoBillingCity();
			billingInformationPage.selectBillingState();
			billingInformationPage.typeIntoBillingZip();
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnViewInventoryButton();
			//Serenity.takeScreenshot();
**/
		

	// public void clickToAddMultipleUAS() {
	////// Works/////
	// System.out.println("Add UAS Button is clicked for test to add multiple
	// UAS");
	// System.out.println("Add Button is here ");
	// waitABit(2000);
	// if (maxSizeOf50InCartLink.isCurrentlyVisible()){
	// clickOnCheckOutButton();
	// checkTheAcknowledgeBox();
	// clickOnAcknowledgeNextButton();
	// billingInformationPage.typeIntoCardNumber();
	// billingInformationPage.typeCvcNumber();
	// billingInformationPage.selectARandomExpirationMonth();
	// billingInformationPage.selectARandomExpirationYear();
	// billingInformationPage.typeIntoBillingFirstName();
	// billingInformationPage.typeIntoBillingLastName();
	// billingInformationPage.selectARandomCountry(); //United States
	// billingInformationPage.typeIntoBillingAddress1();
	// billingInformationPage.typeIntoBillingAddress2();
	// billingInformationPage.typeIntoBillingCity();
	// billingInformationPage.selectBillingState();
	// billingInformationPage.typeIntoBillingZip();
	// ////Serenity.takeScreenshot();
	// billingInformationPage.clickOnBillingNextButton();
	// billingInformationPage.clickOnReviewAcknowledgmentButton();
	// billingInformationPage.clickOnReviewPayButton();
	// billingInformationPage.clickOnViewInventoryButton();
	// billingInformationPage.clickOnSortByNicknameButton();
	// billingInformationPage.clickOnSortByManufacturerButton();
	// billingInformationPage.clickOnSortByModelButton();
	// billingInformationPage.clickOnSortBySerialNumberButton();
	// billingInformationPage.clickOnSortByRegistrationButton();
	// billingInformationPage.clickOnSortByIssuedButton();
	// billingInformationPage.clickOnSortByExpiresButton();
	// billingInformationPage.clickOnSortByStatusButton();
	// billingInformationPage.clickOnSortByIssuedButton();
	// billingInformationPage.clickOnEllipse1Button();
	// billingInformationPage.clickOnEllipseEditButton1();
	// typeIntoNicknameField();
	// typeIntoManufacturerNameField();
	// typeIntoSerialNumberField();
	// typeIntoModelNumberField();
	// waitABit(2000);
	// clickOnEditUasSaveButton();
	// ////Serenity.takeScreenshot();
	// waitABit(2000);
	// billingInformationPage.clickOnEllipse1Button();
	// billingInformationPage.clickOnEllipseEmailButton();
	// ////Serenity.takeScreenshot();
	// waitABit(1000);
	// clickOnEditUasEmailCertificateButton();
	// System.out.println("!!!Email Certificate Test Completed!!!");
	// waitABit(1000);
	// billingInformationPage.clickOnEllipse1Button();
	// billingInformationPage.clickOnEllipseCloneButton();
	// //Add New UAS from a Clone
	// selectARandomUasType();
	// typeIntoNicknameField();
	// typeIntoManufacturerNameField();
	// typeIntoSerialNumberField();
	// typeIntoModelNumberField();
	// clickAddSubmitButton();
	// clickOnDoneButton();
	// ////Serenity.takeScreenshot();
	// System.out.println("MAX has been met, Then continue with payment!!");
	// } else
	// {
	// addUasButton.click();
	// System.out.println("Add UAS Button is clicked ");
	// for (int x=1;x<52; x++){ //Beginning of FOR LOOP!
	// System.out.println("BEGINNING of For Loop " + x + " to add 50 UASs");
	// waitABit(2000);
	// if (clickOnAddSubmitButton.isCurrentlyVisible())
	// {
	// System.out.println("Now Select a random UAS Type!!! ");
	// //////clickAddSubmitButton();
	// selectARandomUasType();
	// System.out.println("Random UAS Type has been selected");
	// typeIntoNicknameField();
	// typeIntoManufacturerNameField();
	// typeIntoModelNumberField();
	// typeIntoSerialNumberField();
	// clickAddSubmitButton();
	// ////Serenity.takeScreenshot();
	// waitABit(1000);
	// System.out.println("Count of New UAS's Added is " + x);
	// } else if (clickOnDoneButton.isCurrentlyVisible()){
	// clickOnDoneButton();
	// System.out.println("Else Done Button has been clicked ");
	// clickOnCheckOutButton();
	// ////Serenity.takeScreenshot();
	// waitABit(1000);
	// System.out.println("Else Checkout Button has been clicked ");
	// } else if (oKButton.isCurrentlyVisible()){
	// clickOnOkButton();
	// clickOnCheckOutButton();
	// checkTheAcknowledgeBox();
	// clickOnAcknowledgeNextButton();
	// ////Serenity.takeScreenshot();
	// waitABit(1000);
	// System.out.println("Then continue with payment!!");
	// }
	// System.out.println("Count of New UAS's Added has reached my limit...for
	// this test " );
	// waitABit(1000);
	// if (clickOnDoneButton.isCurrentlyVisible()){
	// clickOnDoneButton();
	// System.out.println("Outer Else Done Button has been clicked ");
	// clickOnCheckOutButton();
	// System.out.println("Outer Else Checkout Button has been clicked ");
	// checkTheAcknowledgeBox();
	// clickOnAcknowledgeNextButton();
	// billingInformationPage.typeIntoCardNumber();
	// billingInformationPage.typeCvcNumber();
	// billingInformationPage.selectARandomExpirationMonth();
	// billingInformationPage.selectARandomExpirationYear();
	// billingInformationPage.typeIntoBillingFirstName();
	// billingInformationPage.typeIntoBillingLastName();
	// billingInformationPage.selectARandomCountry(); //United States
	// billingInformationPage.typeIntoBillingAddress1();
	// billingInformationPage.typeIntoBillingAddress2();
	// billingInformationPage.typeIntoBillingCity();
	// billingInformationPage.selectBillingState();
	// billingInformationPage.typeIntoBillingZip();
	// billingInformationPage.clickOnBillingNextButton();
	// billingInformationPage.clickOnReviewAcknowledgmentButton();
	// billingInformationPage.clickOnReviewPayButton();
	// billingInformationPage.clickOnViewInventoryButton();
	// System.out.println("Payment has been completed");
	// ////Serenity.takeScreenshot();
	// billingInformationPage.clickOnSortByNicknameButton();
	// billingInformationPage.clickOnSortByManufacturerButton();
	// billingInformationPage.clickOnSortByModelButton();
	// billingInformationPage.clickOnSortBySerialNumberButton();
	// billingInformationPage.clickOnSortByRegistrationButton();
	// billingInformationPage.clickOnSortByIssuedButton();
	// billingInformationPage.clickOnSortByExpiresButton();
	// billingInformationPage.clickOnSortByStatusButton();
	// billingInformationPage.clickOnSortByIssuedButton();
	// billingInformationPage.clickOnSortByIssuedButton();
	// billingInformationPage.clickOnEllipse1Button();
	// billingInformationPage.clickOnEllipseCancelButton();
	// billingInformationPage.clickOnConfirmCancelRegistrationCheckbox();
	// System.out.println("Cancel one of the UAS's has been completed");
	// waitABit(1000);
	// billingInformationPage.clickOnCancelRegistrationButton();
	// waitABit(1000);
	// billingInformationPage.clickOnReturnToInventoryButton();
	// ////Serenity.takeScreenshot();
	// }
	// else {
	// System.out.println("Do Nothing, just go back to loop to continue adding
	// UAS's! ");
	// }
	// } ////End of FOR LOOP!
	// System.out.println("Loops are complete...for this test " );
	// }
	// }
	/// End of this that works////

	public void clickToAddFiveUAS() {
		//// Works/////
		System.out.println("Add Five UAS ");
		System.out.println("Add Button is here ");
		waitABit(2000);
		addUasToCartButton.click();
		if (cartLimitOkButton.isCurrentlyVisible()) {
			System.out.println(
					"Secondry OK Button is clicked, max shopping cart size of 50 has been added.  Complete payment process now");
			clickOnCartLimitOkButton();
			clickOnCheckOutButton();
		} else {
			System.out.println("Add UAS Button is clicked ");
			for (int x = 1; x < 6; x++) { // Beginning of FOR LOOP!
				System.out.println("BEGINNING of For Loop " + x + " to Add Five New UAS");
				waitABit(2000);

				if (clickOnAddSubmitButton.isCurrentlyVisible()) {
					System.out.println("clickOnAddSubmitButton is visible, Now Select a random UAS Type!!! ");
					selectARandomUasType();
					System.out.println("Random UAS Type has been selected");
					typeIntoNicknameField();
					typeIntoManufacturerNameField();
					typeIntoModelNumberField();
					//Serenity.takeScreenshot();
					typeIntoSerialNumberField();
					System.out.println("UAS has been added.  Now click the Add Submit Button to save");
					clickAddSubmitButton();
					if (clickOn50DoneButton.isCurrentlyVisible()) {
						x = 5;
						clickOn50DoneButton();
					}
					//Serenity.takeScreenshot();
					waitABit(1000);
					System.out.println("Count of New UAS's Added is " + x);
				}
				System.out.println("END of For Loop " + x + " to Add Five New UAS");
			}
			System.out.println("END of For Loop to Add Five New UAS.  Now Begin payment process.");
			clickOnDoneButton();
			System.out.println("Else Done Button has been clicked ");
			waitABit(2000);

			clickOnCheckOutButton();
			System.out.println("clickOnCheckOutButton Button has been clicked ");
			//Serenity.takeScreenshot();
			waitABit(1000);
			System.out.println("Checkout Button has been clicked ");
			checkTheAcknowledgeBox();
			System.out.println("checkTheAcknowledgeBox has been clicked ");
			//Serenity.takeScreenshot();
			clickOnAcknowledgeNextButton();
			System.out.println("clickOnAcknowledgeNextButton has been clicked ");
			//Serenity.takeScreenshot();
			waitABit(1000);
			System.out.println("Then continue with payment!!");
			System.out.println("Count of New UAS's Added has reached my limit...for this test ");
			waitABit(1000);
			System.out.println("Outer Else Checkout Button has been clicked...Continue with payment ");
			billingInformationPage.typeIntoCardNumber();
			billingInformationPage.typeCvcNumber();
			billingInformationPage.selectARandomExpirationMonth();
			billingInformationPage.selectARandomExpirationYear();
			billingInformationPage.typeIntoBillingFirstName();
			billingInformationPage.typeIntoBillingLastName();
			//Serenity.takeScreenshot();
			billingInformationPage.selectARandomCountry(); // United States
			billingInformationPage.typeIntoBillingAddress1();
			billingInformationPage.typeIntoBillingAddress2();
			billingInformationPage.typeIntoBillingCity();
			billingInformationPage.selectBillingState();
			billingInformationPage.typeIntoBillingZip();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnBillingNextButton();
			billingInformationPage.clickOnReviewAcknowledgmentButton();
			billingInformationPage.clickOnReviewPayButton();
			//Serenity.takeScreenshot();
			System.out.println("**Click Inventory Button**");
			billingInformationPage.clickOnViewInventoryButton();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnSortByNicknameButton();
			billingInformationPage.clickOnSortByManufacturerButton();
			billingInformationPage.clickOnSortByModelButton();
			billingInformationPage.clickOnSortBySerialNumberButton();
			billingInformationPage.clickOnSortByRegistrationButton();
			billingInformationPage.clickOnSortByIssuedButton();
			billingInformationPage.clickOnSortByExpiresButton();
			System.out.println("**Sort by Expires Button**");
			billingInformationPage.clickOnSortByStatusButton();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnSortByIssuedButton();
			billingInformationPage.clickOnSortByIssuedButton();
			billingInformationPage.clickOnSortByExpiresButton();
			System.out.println("**Sort by Expires Button Again**");
			billingInformationPage.clickOnEllipse1Button();
			System.out.println("**Sort by Ellipse Button**");
			billingInformationPage.clickOnEllipseCancelButton();
			waitABit(3000);
			System.out.println("**3 second wait before selecting a random Cancel Reason**");
			// Retrieve list of Categories in TEST
			// List<String> listOfCancelReasons =
			// billingInformationPage.getListOfCancelReasons();
			// int cancelReasonsIndex =
			// DataGenerator.randomIntegerBetween(1,listOfCancelReasons.size() -
			// 1); // From District drop down list
			// //createSchedulePage.selectCategories(listOfCancelReasons.get(cancelReasonsIndex));
			// billingInformationPage.selectRandomCancelReason(listOfCancelReasons.get(cancelReasonsIndex));
			billingInformationPage.selectRandomCancelReason();
			billingInformationPage.clickOnConfirmCancelRegistrationCheckbox();
			billingInformationPage.clickOnCancelRegistrationButton();
			System.out.println("**Just Clicked Cancel Registration Button**");
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnReturnToInventoryButton();
			System.out.println("852***Sort by Status Button***");
			waitABit(1000);
			billingInformationPage.clickOnSortByStatusButton();
			billingInformationPage.clickOnSortByStatusButton();
			System.out.println("***Return to Inventory***");
			//Serenity.takeScreenshot();
			System.out.println("854***Click on Ellipse Button***");
			waitABit(1000);
			billingInformationPage.clickOnEllipse1Button();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnEllipseEmailButton();
			//Serenity.takeScreenshot();
			waitABit(2000);
//			clickOnEmailCertificateButton();
			System.out.println("!!!Email Certificate Test Completed --Adding 5 UAS!!!");
			waitABit(1000);
			System.out.println("864***Click on Ellipse Button***");
			billingInformationPage.clickOnEllipse1Button();
			//Serenity.takeScreenshot();
			billingInformationPage.clickOnEllipseEmailButton();
			//Serenity.takeScreenshot();
			if (alternateEmailRadioButton.isCurrentlyVisible()) {
				System.out.println("***Click on Alternate Email radio Button***");
				clickOnAlternateEmailRadioButton();
				//Serenity.takeScreenshot();
//				clickOnEmailCertificateButton();
			} else {
				//Serenity.takeScreenshot();
				clickOnReturnToInventoryButton();
				System.out.println(
						"***No Alternatate Email Address has been found. Click on Return to Inventory Button***");
			}
			System.out.println("***Click on Alternate Email radio Button***");
			//Serenity.takeScreenshot();
			// clickOnEditUasEmailCertificateButton();
			waitABit(1000);
			// billingInformationPage.clickOnEllipse1Button();
			//Serenity.takeScreenshot();
			// billingInformationPage.clickOnEllipseEmailButton();
			// Email to Alternate Email address: altEmail
			billingInformationPage.clickOnEllipse1Button();
			//Serenity.takeScreenshot();
			if (ellipseMenuClone.isCurrentlyVisible()) {
				System.out.println("***Click on Ellipse Menu Clone Button***");
				billingInformationPage.clickOnEllipseCloneButton();
				// clickOnEllipseMenuCloneButton();
			} else {
				System.out.println("***Ellipse Menu Clone Button is not visible***");
				System.out.println("**Sort by Status Button**");
				billingInformationPage.clickOnSortByStatusButton();
				billingInformationPage.clickOnEllipse1Button();
				//Serenity.takeScreenshot();
				billingInformationPage.clickOnEllipseCloneButton();
				// clickOnEllipseMenuCloneButton();
				// clickOnEllipseCloneButton();
				// billingInformationPage.clickOnEllipseCloneButton();
				//Serenity.takeScreenshot();

			}
			// Add New UAS from a Clone
			// addUasButton.click();
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoSerialNumberField();
			typeIntoModelNumberField();
			//Serenity.takeScreenshot();
			clickAddSubmitButton();
			System.out.println("Clone 1 !!! Now click the Done Button --Adding 5 UAS!!!");
			waitABit(2000);
			//Serenity.takeScreenshot();
			// Add New UAS from a Clone
			selectARandomUasType();
			typeIntoNicknameField();
			typeIntoManufacturerNameField();
			typeIntoSerialNumberField();
			typeIntoModelNumberField();
			//Serenity.takeScreenshot();
			clickAddSubmitButton();
			System.out.println("Added a New UAS 2 !!! Now click the Done Button --Adding 5 UAS!!!");
			waitABit(2000);
			clickOnDoneButton();
			System.out.println("New Inventory has been added, Then continue with payment!!");
			waitABit(1000);
			if (checkOutButton.isCurrentlyVisible()) {
				clickOnCheckOutButton();
				System.out.println("Click On the Checkout Button...So the Payment Begins");
				checkTheAcknowledgeBox();
				clickOnAcknowledgeNextButton();
				System.out.println("Payment Begins for newly added UAS's");
				billingInformationPage.typeIntoCardNumber();
				billingInformationPage.typeCvcNumber();
				billingInformationPage.selectARandomExpirationMonth();
				billingInformationPage.selectARandomExpirationYear();
				billingInformationPage.typeIntoBillingFirstName();
				billingInformationPage.typeIntoBillingLastName();
				//Serenity.takeScreenshot();
				billingInformationPage.selectARandomCountry(); // United States
				billingInformationPage.typeIntoBillingAddress1();
				billingInformationPage.typeIntoBillingAddress2();
				billingInformationPage.typeIntoBillingCity();
				billingInformationPage.selectBillingState();
				billingInformationPage.typeIntoBillingZip();
				//Serenity.takeScreenshot();
				billingInformationPage.clickOnBillingNextButton();
				billingInformationPage.clickOnReviewAcknowledgmentButton();
				//Serenity.takeScreenshot();
				billingInformationPage.clickOnReviewPayButton();
				if (editedUasOkButton.isCurrentlyVisible()) {
					System.out.println("The OK Modal Button appeared and has will be clicked");
					clickOnOkModalButton();
				}
				//Serenity.takeScreenshot();
				billingInformationPage.clickOnViewInventoryButton();
				//Serenity.takeScreenshot();
			}
		}
	}
	/// End of this that works////

	
	public void clickToAddTenUasDoNotPay() {
		//// Works/////
		System.out.println("Add Ten UAS ");
		System.out.println("Add Button is here ");
		waitABit(2000);
		addUasToCartButton.click();
		if (cartLimitOkButton.isCurrentlyVisible()) {
			System.out.println(
					"Secondry OK Button is clicked, max shopping cart size of 50 has been added.  Complete payment process now");
			clickOnCartLimitOkButton();
			clickOnCheckOutButton();
		} else {
			System.out.println("Add UAS Button is clicked ");
			for (int x = 1; x < 11; x++) { // Beginning of FOR LOOP!
				System.out.println("BEGINNING of For Loop " + x + " to Add Ten New UAS");
				waitABit(2000);

				if (clickOnAddSubmitButton.isCurrentlyVisible()) {
					System.out.println("clickOnAddSubmitButton is visible, Now Select a random UAS Type!!! ");
					selectARandomUasType();
					System.out.println("Random UAS Type has been selected");
					typeIntoNicknameField();
					typeIntoManufacturerNameField();
					typeIntoModelNumberField();
					//Serenity.takeScreenshot();
					typeIntoSerialNumberField();
					System.out.println("UAS has been added.  Now click the Add Submit Button to save");
					clickAddSubmitButton();
					if (clickOn50DoneButton.isCurrentlyVisible()) {
						x = 5;
						clickOn50DoneButton();
					}
					//Serenity.takeScreenshot();
					waitABit(1000);
					System.out.println("Count of New UAS's Added is " + x);
				}
				System.out.println("END of For Loop " + x + " to Add Ten New UAS");
			}
			System.out.println("END of For Loop to Add Ten New UAS.  Now Begin payment process.");
			clickOnDoneButton();
			System.out.println("Else Done Button has been clicked ");
			System.out.println("***END OF TEST, PAYMENT IS NOT PART OF THIS TEST**** ");
			waitABit(2000);
		}
	}
	
	
	
	
	public void clickToAddUasButton() {
		System.out.println("Add UAS Button is clicked");
		addUasToCartButton.click();
	}

	public void clickOnCheckOutButton() {
		System.out.println("Check Out Button is clicked");
		checkOutButton.click();
	}

	public void checkTheAcknowledgeBox() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(3000);
			System.out.println("Loop Count to verify checkTheAcknowledgeBox is visible... " + i);
			if (checkTheAcknowledgeBox.isCurrentlyVisible()){
				System.out.println("checkTheAcknowledgeBox is Visible. Will now click it.");
				i = 4;
				checkTheAcknowledgeBox.click();//attempt to click the element
			System.out.println("checkTheAcknowledgeBox has been clicked. ");
			}
			else 
			{
			System.out.println("checkTheAcknowledgeBox is NOT Visible... Trying again in 3 seconds");
			waitABit(3000);//wait 3 seconds before trying to click again
			}
		}	
	}
		

	public void clickOnAcknowledgeNextButton() {
		waitABit(1000);
		for(int i = 0 ; i < 5;i++){ //attempt to click the element 5 times
			waitABit(2000);
			System.out.println("Loop Count to verify checkAcknowledgeNextButton is visible... " + i);
			if (checkAcknowledgeNextButton.isCurrentlyVisible()){
				System.out.println("checkAcknowledgeNextButton is Visible. Will now click it.");
				i = 4;
				checkAcknowledgeNextButton.click();//attempt to click the element
			System.out.println("checkAcknowledgeNextButton has been clicked. ");
			}
			else 
			{
			System.out.println("checkAcknowledgeNextButton is NOT Visible... Trying again in 3 seconds");
			waitABit(2000);//wait 2 seconds before trying to click again
			}
		}	
	}

	public void selectARandomUasType() {
		///*** This works.  Just want to try it different way ***
		System.out.println("Randomly selected UAS Type Size is " + uasTypeDropdown.getSelectOptions().size());
		String randomUasType = DataGenerator.randomUasType();
		System.out.println("Randomly selected UAS Type from new text file is " + randomUasType);
		uasTypeDropdown.selectByVisibleText(randomUasType);
		System.out.println("Randomly selected UAS Type is " + getARandomUasType());
		//assertThat(uasTypeDropdownTitle.isCurrentlyVisible()).isTrue();

}

	
	
	
	public void selectARandomUasTypex() {
//	///*** This works.  Just want to try it different way ***
//	System.out.println("Randomly selected UAS Type Size is " + uasTypeDropdown.getSelectOptions().size());
//	String randomUasType = DataGenerator.randomUasType();
//	System.out.println("Randomly selected UAS Type from new text file is " + randomUasType);
//	uasTypeDropdown.selectByVisibleText(randomUasType);
//	System.out.println("Randomly selected UAS Type is " + getARandomUasType());
	
	  //Object of the Dropdownlist
//	 WebElement drpDwnList = randomUasType;  //     driver.findElement(By.xpath(".//*[@id='drpdwnTopics']"));
	 //Using FindElements to create a List object
	 //List <WebElement> weblist = driver.findElements(By.xpath(".//*[@id='drpdwnTopics']/option"));
	 //Using Select Class to fetch the count
	 Select objSel = new Select(uasTypeDropdown);
	 List <WebElement> weblist = objSel.getOptions();
	 //Taking the count of items
	 int iCnt = weblist.size();
	 System.out.println("iCnt ==>  "+ iCnt);
	 //Using Random class to generate random values
	 Random num = new Random();
	 System.out.println("num ==>  "+ num);

	 int iSelect = num.nextInt(iCnt);
	 System.out.println("iSelect ==>  "+ iSelect);

	 //Selecting value from DropDownList
	 objSel.selectByIndex(iSelect);
	 //Selected Value
	 System.out.println("Random UAS Type " +  uasTypeDropdown.getAttribute("value"));
	 getARandomUasType();
	
}

	public String getARandomUasType() {
		 System.out.println("Get Random UAS Type " +  uasTypeDropdown.getAttribute("value"));
			return uasTypeDropdown.getAttribute("value");
	}

	public void typeIntoManufacturerNameField() {
		manufacturer.clear();
		manufacturer.type(DataGenerator.randomCompanyName());
		System.out.println(getManufacturerName());
		System.out.println("Manufacturer Name is " + getManufacturerName());
		assertThat(manufacturerTitle.isCurrentlyVisible()).isTrue();

	}

	public String getManufacturerName() {
		return manufacturer.getAttribute("value");
	}

	public void typeIntoSerialNumberField() {
		serialNumber.clear();
		serialNumber.type(DataGenerator.randomSerialNumbersNonHobbyist());
		System.out.println(getSerialNumberName());
		System.out.println("Serial Number Name is " + getSerialNumberName());
		assertThat(serialNumberTitle.isCurrentlyVisible()).isTrue();

	}

	public String getSerialNumberName() {
		return serialNumber.getAttribute("value");
	}

	public void typeIntoNicknameField() {
		assetNickname.clear();
		assetNickname.type("Nickname" + DataGenerator.randomIntegerBetween(1, 1000));
		System.out.println(getNickname());
		System.out.println("Nickname is " + getNickname());
		assertThat(assetNicknameTitle.isCurrentlyVisible()).isTrue();

	}

	public String getNickname() {
		return assetNickname.getAttribute("value");
	}

	public void typeIntoModelNumberField() {
		model.clear();
		model.type("Mod:" + DataGenerator.randomIntegerBetween(1, 1000));
		System.out.println(getModelNumber());
		System.out.println("Model Number is " + getModelNumber());
		assertThat(modelTitle.isCurrentlyVisible()).isTrue();

	}

	public String getModelNumber() {
		return model.getAttribute("value");
	}

	public void clickAddSubmitButton() {
		System.out.println("Click the Add Submit Button");
		clickOnAddSubmitButton.click();
	}

	public void clickOnCartLimitOkButton() {
		cartLimitOkButton.click();
	}

	public void clickOnDoneButton() {
		clickOnDoneButton.click();
	}

	public void clickOn50DoneButton() {
		clickOn50DoneButton.click();
	}

	public String getCongratulationsConfirmationText() {
		return congratulationsConfirmationText.getAttribute("value");
	}

	// assetAcquiredType
	public String getAssetAcquiredType() {
		System.out.println("UAS Type is printed " + assetAcquiredType.getAttribute("value"));
		return assetAcquiredType.getAttribute("value");
	}

}
