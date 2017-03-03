package faa.cucumber.pages;

import java.util.List;

import org.apache.xmlbeans.SystemProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import faa.utils.DataGenerator;
import faa.utils.Verify;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @authors jfranklin
 * Update Profile Page and test the 3 strike rule for address validation 
 */
public class UpdateStrikeProfilePage extends BasePageObject {

	@FindBy(id = "firstName") private WebElementFacade createProfileFirstName;
	@FindBy(id = "middleInitial") private WebElementFacade createProfileMiddleInitial;
	@FindBy(id = "lastName") private WebElementFacade createProfileLastName;
	@FindBy(id = "nameSuffix") private WebElementFacade createProfileNameSuffix;
	@FindBy(id = "title") private WebElementFacade createProfileUserTitle;
	@FindBy(id = "alternateEmail") private WebElementFacade createProfileAlternateEmail;
	@FindBy(xpath = "//input[@id='phone' and @name='phone']") private WebElementFacade createProfilePhone;
//	@FindBy(id = "phone") private WebElementFacade createProfilePhone;
	@FindBy(id = "phoneExt") private WebElementFacade createProfilePhoneExt;
	@FindBy(id = "orgName") private WebElementFacade createProfileOrganizationName;
	@FindBy(id = "dba") private WebElementFacade createProfileDBA;

	
	
	@FindBy(id = "physicalAddress_country") private WebElementFacade createProfilePhysicalCountry;
	@FindBy(id = "physicalAddress_addressLine1") private WebElementFacade createProfilePhysicalAddress1;
	@FindBy(id = "physicalAddress_addressLine2") private WebElementFacade createProfilePhysicalAddress2;
	@FindBy(id = "physicalAddress_city") private WebElementFacade createProfilePhysicalCity;
	@FindBy(id = "physicalAddress_stateProvinceRegion") private WebElementFacade createProfilePhysicalState;
	@FindBy(id = "physicalAddress_zipPostal") private WebElementFacade createProfilePhysicalZip;

	
	@FindBy(id = "mailingSameAsPhysical") private WebElementFacade createProfileaddressIsSame;
	@FindBy(id = "mailingAddress_country") private WebElementFacade createProfileMailingCountry;
	@FindBy(id = "mailingAddress_addressLine1") private WebElementFacade createProfileMailingAddress1;
	@FindBy(id = "mailingAddress_addressLine2") private WebElementFacade createProfileMailingAddress2;
	@FindBy(id = "mailingAddress_city") private WebElementFacade createProfileMailingCity;
	@FindBy(id = "mailingAddress_stateProvinceRegion") private WebElementFacade createProfileMailingState;
	@FindBy(id = "mailingAddress_zipPostal") private WebElementFacade createProfileMailingZip;
	
//	@FindBy(id = "physicalCountry") private WebElementFacade createProfilePhysicalCountry;
//	@FindBy(id = "physicalAddress1") private WebElementFacade createProfilePhysicalAddress1;
//	@FindBy(id = "physicalAddress2") private WebElementFacade createProfilePhysicalAddress2;
//	@FindBy(id = "physicalCity") private WebElementFacade createProfilePhysicalCity;
//	@FindBy(id = "physicalState") private WebElementFacade createProfilePhysicalState;
//	@FindBy(id = "physicalZip") private WebElementFacade createProfilePhysicalZip;

//	@FindBy(id = "mailingSameAsPhysical") private WebElementFacade createProfileaddressIsSame;
//	@FindBy(id = "mailingCountry") private WebElementFacade createProfileMailingCountry;
//	@FindBy(id = "mailingAddress1") private WebElementFacade createProfileMailingAddress1;
//	@FindBy(id = "mailingAddress2") private WebElementFacade createProfileMailingAddress2;
//	@FindBy(id = "mailingCity") private WebElementFacade createProfileMailingCity;
//	@FindBy(id = "mailingState") private WebElementFacade createProfileMailingState;
//	@FindBy(id = "mailingZip") private WebElementFacade createProfileMailingZip;

	//Physical Postal Code not applicable
	@FindBy(id = "physicalAddress_noPostalCodeIndicated") private WebElementFacade physicalZipPostalNotApplicable;
	//Mailing Postal Code not applicable
	@FindBy(id = "mailingAddress_noPostalCodeIndicated") private WebElementFacade mailingZipPostalNotApplicable;

	
	
	@FindBy(id = "email") private WebElementFacade newAccountEmail;
	@FindBy(id = "password") private WebElementFacade newAccountPassword;
	@FindBy(id = "confirmPassword") private WebElementFacade newAccountConfirmPassword;
	@FindBy(id = "Create_Account") private WebElementFacade newAccountCreateAccount;

	@FindBy(xpath="//div[@class='icon-remote']") private WebElementFacade modelAircraftButton;
	@FindBy(xpath="//html/body/div[2]/div/div/div/div[2]/a/div/div/div") private WebElementFacade nonModelAircraftButton;

	//Alternate Email Address Error Message when user attempts to enter Alt Email the same as Login Email.  Both fields must be different
	@FindBy(xpath = "//div[contains(text(), 'Email has to be different than primary email address.')]") private WebElementFacade altEmailErrorMessage;

	
	public void clickOnNonModelAircraftButton() {
		waitABit(2000);
		System.out.println("Click on the Model Aircraft Account Type button ");
		//waitForElement(NonModelAircraftButtonCssSelector);
		nonModelAircraftButton.click();
		//hobbyistAccountType.click();
	}		

	//*[@id="addressIsSame" and   @aria-checked='false']
	@FindBy(xpath = "//*[@id='addressIsSame' and   @aria-checked='false']") private WebElementFacade addressIsSameFalse;

	//*[@id="addressIsSame" and   @aria-checked='true']
	@FindBy(xpath = "//*[@id='addressIsSame' and   @aria-checked='true']") private WebElementFacade addressIsSameTrue;

	
	//Profile Tab
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), 'Profile')]") private WebElementFacade profileTab;
	//Inventory Tab
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), 'Inventory')]") private WebElementFacade inventoryTab;
	
	//Edit Profile Button
	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Edit')]") private WebElementFacade editProfileButton;

	
	
	/** Save Button on Strike Address Validation Screen  **/
	@FindBy(xpath="//button[@id='saveEditButton' and contains(text(), 'Save')]") private WebElementFacade saveEditButton;
	
	/** Next Button on Strike Address Validation Screen  **/
	@FindBy(xpath = "//button[@id='next' and contains(text(), 'Next')]") private WebElementFacade nextButton;
	
	//Hobbyist Proceed to Checkout Button
	@FindBy(xpath = "//button[@class='btn btn-primary ng-scope' and contains(text(), 'Proceed to Checkout')]") private WebElementFacade proceedToCheckoutButton;
	
	
	/**<p>SaveButtonCssSelector Save Button Css Selector for Organization Profile
	 * 	body#body div div div div div div div div form div div div div button.btn.btn-primary  **/
	private static final String saveButtonCssSelector = "body#body div div div div div div div div form div div div div button.btn.btn-primary";
	
	
	
	//String country1 = "United States";
	//String country = "United States";

	
	//modelAircraftButton
	public void clickOnModelAircraftButton() {
		waitABit(1000);
		modelAircraftButton.click();
	}

//	//click on Non-Model Aircraft Complete Your Profile Button
//	public void clickOnNonModelAircraftButton() {
//		waitABit(2000);
//		System.out.println("Click on the NonModelAircraftButtonCssSelector button ");
//		nonModelAircraftButton.waitUntilVisible();
//		nonModelAircraftButton.click();
//	}		
	
	
//	//nonModelAircraftButton
//	public void clickOnNonModelAircraftButton() {
//		waitABit(1000);
//		nonModelAircraftButton.click();
//	}
	
	//Profile Tab Organization Profile
	public void clickOnProfileTab() {
		waitABit(1000);
		profileTab.click();
	}
	//Profile Tab Organization Profile
	public void clickOnInventoryTab() {
		waitABit(1000);
		inventoryTab.click();
	}
	//Edit Profile Button
	public void clickOnEditProfileButton(){
		editProfileButton.click();
	}
	//nextButton
	public void clickOnNextButton(){
		nextButton.click();
	}
	//saveButton
	public void clickOnSaveButton(){
		saveEditButton.click();
	}

	public void clickOnNextOrSaveButton() {
		if (saveEditButton.isCurrentlyVisible()){
			System.out.println("Save Edit Button is Present " );
			clickOnSaveButton();
			System.out.println("Save Edit Button is Present and has been clicked");
		} else {
			System.out.println("Next Button is Present " );
			clickOnNextButton();
			System.out.println("Next Button is Present and has been clicked");
		} 	
	}
	
	
	//proceedToCheckoutButton
	public void clickOnProceedToCheckoutButton(){
		proceedToCheckoutButton.click();
	}
	
	
	
	public String getTypeIntoCreateProfileFirstName() {
		return createProfileFirstName.getAttribute("value");

	}
	public void typeIntoCreateProfileFirstName() {
			createProfileFirstName.clear();
			createProfileFirstName.type(DataGenerator.randomFirstName());	
	}
	public void typeIntoCreateProfileMiddleInitial() {
		createProfileMiddleInitial.clear();
		createProfileMiddleInitial.type(DataGenerator.randomAlphabetic(1).toUpperCase());
		System.out.println("Middle Initial is " + getTypeIntoCreateProfileMiddleInitial());
	}
	public String getTypeIntoCreateProfileMiddleInitial() {
		return createProfileMiddleInitial.getAttribute("value");
	}
	public void typeIntoCreateProfileLastName() {
		createProfileLastName.clear();
		createProfileLastName.type(DataGenerator.randomLastName());
		System.out.println(getTypeIntoCreateProfileFirstName());
		System.out.println("Last Name is " + getTypeIntoCreateProfileLastName());
	}
	public String getTypeIntoCreateProfileLastName() {
		return createProfileLastName.getAttribute("value");
	}
	public void typeIntoCreateProfileNameSuffix() {
		createProfileNameSuffix.click();
		createProfileNameSuffix.type(DataGenerator.randomSuffixName());
		System.out.println("Suffix Name is " + getCreateProfileNameSuffix());

	}
	public String getCreateProfileNameSuffix() {
		return createProfileNameSuffix.getAttribute("value");
	}
	public void typeIntoCreateProfileTitle() {
		createProfileUserTitle.clear();
		createProfileUserTitle.type(DataGenerator.randomTitle());
		System.out.println("Title is " + getCreateProfileNameTitle());

	}
	public String getCreateProfileNameTitle() {
		return createProfileUserTitle.getAttribute("value");
	}

	public void typeIntoUpdateProfileAlternateEmail(String updateAltEmail) {
		String upperUpdateAltEmail = updateAltEmail.toUpperCase();
		String camelUpdateAltEmail = Verify.toCamelCase(updateAltEmail);
		System.out.println("Upper Case Alternate Email Address " + upperUpdateAltEmail );
		System.out.println("Camel Case Alternate Email Address " + camelUpdateAltEmail );
		createProfileAlternateEmail.clear();
		createProfileAlternateEmail.type(updateAltEmail);
		//Serenity.takeScreenshot(); 
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(upperUpdateAltEmail);
			System.out.println("Upper Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			//Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type(camelUpdateAltEmail);
			System.out.println("Camel Case Alternate Email Address has been updated.  It must be different than the primary Email address" );
			//Serenity.takeScreenshot(); 
		}
		if (altEmailErrorMessage.isCurrentlyVisible()) {
			createProfileAlternateEmail.type("myfaadrone+300@gmail.com");
			System.out.println("Email Address has been updated with a valid email that is different than the primary Email address" );
			System.out.println("Alternate Email Address is myfaadrone+300@gmail.com ");

			//Serenity.takeScreenshot(); 
		}
		//Serenity.takeScreenshot(); 
}

	public String getUpdateProfileAlternateEmail() {
		return createProfileAlternateEmail.getAttribute("value");
	}
	
	
	public void typeIntoCreateProfileAlternateEmail() {
		createProfileAlternateEmail.clear();
		createProfileAlternateEmail.type("myfaadrone+300@gmail.com");
	}
	public String getCreateProfileAlternateEmail() {
		return createProfileAlternateEmail.getAttribute("value");
	}
	public void typeIntoCreateProfilePhone() {
		createProfilePhone.clear();
		createProfilePhone.type(DataGenerator.randomNumber(10));
	}
	public String getCreateProfilePhone() {
		return createProfilePhone.getAttribute("value");
	}
	public void typeIntoCreateProfilePhoneExt() {
		createProfilePhoneExt.clear();
		createProfilePhoneExt.type(DataGenerator.randomNumber(6));
	}
	public String getCreateProfilePhoneExt() {
		return createProfilePhoneExt.getAttribute("value");
	}

	public void clickProfileAddressIsSame() {
		if(createProfileaddressIsSame.isSelected()){
			createProfileaddressIsSame.click();
			System.out.println("click on the Address is the same checkbox...to Uncheck it so we can edit the Organization Address");
			System.out.println("Uncheck the Same As checkbox!!" );
		} 
		if (!createProfileaddressIsSame.isSelected()){ 
			//createProfileaddressIsSame.click();
			System.out.println("Do NOT click on the Address is the same checkbox...to Uncheck it so we can edit the Organization Address");
			System.out.println("The CheckBox is already Unchecked..No action to take !!" );
		} 
	}	
	
	public void typeIntoCreateProfileOrganizationName() {
		String organization = DataGenerator.randomCompanyName();
		System.out.println("Randomly Generated Organization is..." + organization + "***" );
		if (createProfileOrganizationName.isCurrentlyVisible()){
		createProfileOrganizationName.type(organization);
		System.out.println("Profile Organization Name is: " + organization);
		//Serenity.takeScreenshot();
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	public String getCreateProfileOrganizationName() {
		return createProfileOrganizationName.getAttribute("value");
	}
	public void typeIntoCreateProfileDba() {
		String profileDba = DataGenerator.randomCompanyName();
		System.out.println("Randomly Generated DBA is..." + profileDba + "***" );
		if (createProfileDBA.isCurrentlyVisible()){
		createProfileDBA.type(profileDba);
		System.out.println("Profile DBA Name is: " + profileDba);
		//Serenity.takeScreenshot();
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileDba() {
		return createProfileDBA.getAttribute("value");
	}
	//Drop Down List Physical Country
	public void selectProfilePhysicalCountryDropDown(String country1) {
		if (createProfilePhysicalCountry.isCurrentlyVisible()){
		Select dropDownList = new Select(createProfilePhysicalCountry);
		dropDownList.selectByVisibleText(country1.trim());
		createProfilePhysicalCountry.selectByVisibleText(country1);
		System.out.println("Selected Physical Country from drop down list is..." + country1 + "***" );
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfilePhysicalCountry() {
		return createProfilePhysicalCountry.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalAddress1(String newAddress1) {
		if (createProfilePhysicalAddress1.isCurrentlyVisible()){
		createProfilePhysicalAddress1.type(newAddress1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfilePhysicalAddress1() {
		return createProfilePhysicalAddress1.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalAddress2(String newAddress2) {
		if (createProfilePhysicalAddress2.isCurrentlyVisible()){
		createProfilePhysicalAddress2.type(newAddress2);
		System.out.println("5 Second Wait...");
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfilePhysicalAddress2() {
		return createProfilePhysicalAddress2.getAttribute("value");
	}
	public void typeIntoCreateProfilePhysicalCity(String newCity) {
		if (createProfilePhysicalCity.isCurrentlyVisible()){
			createProfilePhysicalCity.type(newCity);
			//Serenity.takeScreenshot();
		} else {
		System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfilePhysicalCity() {
		return createProfilePhysicalCity.getAttribute("value");
	}           
	public void selectFromPhysicalStateNameDropdownList(String newState) {
		if (createProfilePhysicalState.isCurrentlyVisible()){
		Select dropDownList = new Select(createProfilePhysicalState);
		dropDownList.selectByVisibleText(newState.trim());
		System.out.println("Selected Physical New State Name inputText is " + newState);
		} else {
		System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	            
	public void typeIntoCreateProfilePhysicalStateNameField(String newState) {
		if (createProfilePhysicalState.isCurrentlyVisible()){
		createProfilePhysicalState.type(newState);
		System.out.println("Selected New Physical State Name inputText is " + newState);
		System.out.println("5 Second Wait...");
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	public void typeIntoCreateProfilePhysicalZip(String newZip) {
		if (newZip.equals("N/A")) {
			System.out.println("On Verify new Physical Zip is N/A --->  " + newZip);
			clickOnPhysicalZipPostalNotApplicableCheckbox();
			System.out.println("New Zip variable is " + newZip);
			} else {
				if (createProfilePhysicalZip.isCurrentlyVisible()){	
					System.out.println("New Zip is " + newZip);
					createProfilePhysicalZip.type(newZip);
					System.out.println("Newly updated Physical Zip is--> " + newZip);
					System.out.println("5 Second Wait...");
					//Serenity.takeScreenshot();
				} else {
					System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
				}
			}
	}	
	//physicalZipPostalNotApplicable
	public void clickOnPhysicalZipPostalNotApplicableCheckbox() {
		physicalZipPostalNotApplicable.click();
	}
	//mailingZipPostalNotApplicable
	public void clickOnMailingZipPostalNotApplicableCheckbox() {
		mailingZipPostalNotApplicable.click();
	}
	
	//Drop Down List Mailing Country 
	public void selectProfileMailingCountryDropDown(String newMailingCountry) {
		if (createProfileMailingCountry.isCurrentlyVisible()){	
		Select dropDownList = new Select(createProfileMailingCountry);
		dropDownList.selectByVisibleText(newMailingCountry.trim());
		//Serenity.takeScreenshot();
		createProfileMailingCountry.selectByVisibleText(newMailingCountry);
		System.out.println("Selected Mailing Country from drop down list is..." + newMailingCountry + "***" );
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
		
	}
	public String getCreateProfileMailingCountry() {
		return createProfileMailingCountry.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingAddress1(String newMailingAddress1) {
		if (createProfileMailingAddress1.isCurrentlyVisible()){	
		createProfileMailingAddress1.clear();
		System.out.println("Newly Updated Address 1 is-->" + newMailingAddress1);
		createProfileMailingAddress1.type(newMailingAddress1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingAddress1() {
		return createProfileMailingAddress1.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingAddress2(String newMailingAddress2) {
		if (createProfileMailingAddress2.isCurrentlyVisible()){	
		createProfileMailingAddress2.clear();
		createProfileMailingAddress2.type(newMailingAddress2);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingAddress2() {
		return createProfileMailingAddress2.getAttribute("value");
	}
	public void typeIntoCreateProfileMailingCity(String newMailingCity1) {
		if (createProfileMailingCity.isCurrentlyVisible()){	
		createProfileMailingCity.clear();
		createProfileMailingCity.type(newMailingCity1);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}	
	public String getCreateProfileMailingCity() {
		return createProfileMailingCity.getAttribute("value");
	}
	
	public void selectFromMailingStateNameDropdownList(String inputText) {
		if (createProfileMailingState.isCurrentlyVisible()){	
			Select dropDownList = new Select(createProfileMailingState);
			dropDownList.selectByVisibleText(inputText.trim());
			//Serenity.takeScreenshot();
			System.out.println("Selected from Drop Down List, New Mailing State Name inputText is " + inputText);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}

	public void typeIntoMailingStateNameField(String newState) {
		if (createProfileMailingState.isCurrentlyVisible()){	
			createProfileMailingState.clear();
			createProfileMailingState.type(newState.trim());
			System.out.println("Typed into Text Box, New Mailing State Name inputText is " + newState);
		} else {
			System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
		}
	}
	
	
	
	public void typeIntoCreateProfileMailingZip(String newMailingZip1) {
		if (newMailingZip1.equals("N/A")) {
			System.out.println("On Verify new Zip is N/A --->  " + newMailingZip1);
			//clickOnPhysicalZipPostalNotApplicableCheckbox();
			clickOnMailingZipPostalNotApplicableCheckbox();
			} else {
				if (createProfileMailingZip.isCurrentlyVisible()){	
					System.out.println("New Mailing Zip is " + newMailingZip1);
					createProfileMailingZip.clear();
					createProfileMailingZip.type(newMailingZip1.trim());
					System.out.println("Newly updated Mailing Zip is--> " + newMailingZip1);
					//Serenity.takeScreenshot();
				} else {
					System.out.println("User has Inventory Manager Role.  This information cannot be updated...");
				}
			}
		System.out.println("New Mailing Zip variable is " + newMailingZip1);
	}	

	public String getCreateProfileMailingZip() {
		return createProfileMailingZip.getAttribute("value");
	}
	//New Account Page
	/**<p>New Account Button Css Selector {@value}*/
	static final String newAccountButtonCssSelector = "li a[href='register']";

		
		//click on Save Button to Complete Your Profile
		public void clickOnSaveButtonCssSelectorButton() {
			waitABit(2000);
			System.out.println("Click on the saveButtonCssSelector button ");
			//waitForElement(NonModelAircraftButtonCssSelector);
			click(saveButtonCssSelector);
		}		
		
		
		//button[@class='btn btn-primary' and contains(text(), 'Next')]
		
		
		public String getNewEmailAccountAddressFieldValue() {
			return newAccountEmail.getValue();
		}
		public void typeIntoNewAccountEmailAddressField() {
			newAccountEmail.type("myfaadrone+" + DataGenerator.randomIntegerBetween(10,200) + "@gmail.com");
			waitABit(1000);
		}
		
		public void typeIntoPasswordField(String inputText) {
			newAccountPassword.type("Dummy$11");
		}
		public void typeIntoConfirmPasswordField(String inputText) {
			newAccountConfirmPassword.type("Dummy$11");
		}
		//Create Account Button
		public void clickOnCreateAccountButton() {
			click(newAccountCreateAccount);
		}
		//Verify the create account success
	
		
		
		//Verify the create account success
		/** {@value} */
		private static final String successMessageCssSelector = "html body div div.email-password-area.col-md-12.col-sm-12.col-xs-12.large h1";

		
		public void verifyAlmostDoneMessageIsDisplayed() {
			findWebElementByCssSelector(successMessageCssSelector).shouldContainText("Almost done!");
		}

		public void selectProfilePhysicalIntCountryDropDown(String newIntCountry1) {
			// TODO Auto-generated method stub
			
		}


	
}
