/**
 * 
 */
package faa.cucumber.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import faa.utils.DataGenerator;
import faa.utils.LogToFile;

/** @author jfranklin */
public class BillingInformationPage extends BasePageObject {

	//Titles for Payment Information Page.  To be used for Asserts to verify titles are being displayed currently.
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the credit card number.  This is a required field')]") private WebElementFacade cardNumberTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'For most cards it is the last three digits in the signature area on the back of the card.  For American Express it is the four digits on the front of the card.')]") private WebElementFacade cvcNumberTitle;
	@FindBy(xpath = "//select[starts-with(@title, 'Enter the credit card expiration month.  This is a required field.')]") private WebElementFacade expMonthTitle;
	@FindBy(xpath = "//select[starts-with(@title, 'Enter the credit card expiration year.  This is a required field.')]") private WebElementFacade expYearTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the first name. This is a required field.')]") private WebElementFacade billingFirstNameTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the last name. This is a required field.')]") private WebElementFacade billingLastNameTitle;
	@FindBy(xpath = "//select[starts-with(@title, 'Select the country of your billing address. This is a required field.')]") private WebElementFacade billingAddress_countryTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the first line of your billing address. This is a required field.')]") private WebElementFacade billingAddress_addressLine1Title;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the second line of your billing address. This is an optional field.')]") private WebElementFacade billingAddress_addressLine2Title;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the city of your billing address. This is a required field.')]") private WebElementFacade billingAddress_cityTitle;
	@FindBy(xpath = "//select[starts-with(@title, 'Select the State / Province / Region of your billing address. This is a required field.')]") private WebElementFacade billingAddress_stateProvinceRegionTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the State / Province / Region of your billing address.')]") private WebElementFacade billingAddress_stateProvinceRegionNonUsTitle;
	@FindBy(xpath = "//input[starts-with(@title, 'Enter the Zip code of your billing address. This is a required field.')]") private WebElementFacade billingAddress_zipPostalTitle;

	/**cardNumber **/
	@FindBy(id = "cardNumber") private WebElementFacade cardNumber;
	/**cvcNumber **/
	@FindBy(id = "cvcNumber") private WebElementFacade cvcNumber;
	/**expMonth **/
	@FindBy(id = "expMonth") private WebElementFacade expMonth;
	/**	expYear **/
	@FindBy(id = "expYear") private WebElementFacade expYear;
	/** billingAddressIsSame Checkbox **/
	//Billing address is the same as the mailing address
	@FindBy(xpath = "//input[@id='billingAddressIsSame' and @name='billingAddressIsSame']") private WebElementFacade billingAddressIsSame;
	@FindBy(id = "billingFirstName") private WebElementFacade billingFirstName;
	@FindBy(id = "billingLastName") private WebElementFacade billingLastName;
	@FindBy(id = "billingAddress_country") private WebElementFacade billingCountry;
	@FindBy(id = "billingAddress_addressLine1") private WebElementFacade billingAddress1;
	@FindBy(id = "billingAddress_addressLine2") private WebElementFacade billingAddress2;
	@FindBy(id = "billingAddress_city") private WebElementFacade billingCity;
	@FindBy(id = "billingAddress_stateProvinceRegion") private WebElementFacade billingState;
	@FindBy(id = "billingAddress_zipPostal") private WebElementFacade billingZip;
	/** Acknowledgment of FAA Requirements Next Button **/
	@FindBy(xpath = "//input[contains(@value, 'Next')]") private WebElementFacade acknowledgmentNextButton;

	/** Billing Information Next Button **/
//	@FindBy(xpath = "//input[contains(@type, 'submit') and contains(@ng-click, 'PaymentDetails')]") private WebElementFacade billingNextButton;
	@FindBy(xpath = "//button[@id='next' and contains(@type, 'submit') and contains(text(), 'Next')]") private WebElementFacade billingNextButton;
	
	
	/** Review Order Checkbox to Accept and verify information is accurate **/
	@FindBy(id="acknowledge") private WebElementFacade reviewAcknowledgeButton;
	/** Review Order Pay button **/
	@FindBy(xpath="//input[@id='pay' and contains(@type, 'submit') and contains(@title, 'Pay')]") private WebElementFacade reviewPayButton;

	
	/**Done button to be clicked to complete the payment process...  button[@class='btn btn-primary center-block' and contains(text(), 'Done')] **/
	@FindBy(xpath="//button[@id='returnToDashboard' and contains(text(), 'Done')]") private WebElementFacade paymentDoneButton;
	/** Click the view inventory button **/
	@FindBy(xpath="//button[contains(text(), 'View Inventory')]") private WebElementFacade viewInventoryButton;
	
	/** Click the Cancel button **/
	@FindBy(xpath="//button[@class='btn' and contains(text(), 'Cancel')]") private WebElementFacade cancelButton;

//	/** Click the Return to Inventory button to Return to Inventory **/
//	@FindBy(xpath="//button[@class='btn' and contains(text(), 'Return to Inventory')]") private WebElementFacade returnToInventoryOnCancelUasScreen;
	
	
	/** Click the Registered Inventory UAS 1 **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(5) > div > a > span") private WebElementFacade registeredInventory1;

	
	

	/** Click the Shopping Cart Ellipse  **/
	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div[1]/span") private WebElementFacade shoppingCartEllipse;
	/** Click the Shopping Cart Ellipse Edit **/
	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div[2]/div[2]/div/div/a[1]/span") private WebElementFacade shoppingCartEllipseEdit;
	/** Click the Shopping Cart Ellipse Clone**/
	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div[2]/div[2]/div/div/a[2]/span") private WebElementFacade shoppingCartEllipseClone;
	/** Click the Shopping Cart Ellipse Remove **/
	@FindBy(xpath = "//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div[2]/div[2]/div/div/a[3]/span") private WebElementFacade shoppingCartEllipseRemove;
	
	/** Click the Shopping Cart Undo Removal **/
	@FindBy(xpath = "//*[@id='undoRemoval']") private WebElementFacade shoppingCartUndoRemoval;
	
	
	
	
	/** Click the ellipse #inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div > span**/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div > span") private WebElementFacade ellipse1;
	/** Click the ellipse Edit Button 1 **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(1) > span") private WebElementFacade ellipseEditButton1;
	/** Click the Ellipse Clone Button **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(2) > span") private WebElementFacade ellipseCloneButton1;
	/** Click the Ellipse Cancel Button **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(3) > span") private WebElementFacade ellipseCancelButton1;
	/** Click the Ellipse Email Button **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(4) > span") private WebElementFacade ellipseEmailButton1;
	/** Click the Ellipse Renew Button **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(5) > span") private WebElementFacade ellipseRenewButton1;
	/** Click the Ellipse Details Button **/
	@FindBy(css = "#inventoryBody > tr:nth-child(1) > td:nth-child(9) > div > div.popover.ng-isolate-scope.bottom.fade.in > div.popover-inner > div > div > a:nth-child(6) > span") private WebElementFacade ellipseDetailsButton1;

	
	/** Click the Return to Inventory Button **/
	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Return to Inventory')]") private WebElementFacade returnToInventoryButton;

	/** Click the Cancel Registration button to Return to Inventory **/
	@FindBy(xpath="//button[@id='cancelRegistration' and contains(text(), 'Cancel Registration')]") private WebElementFacade cancelRegistrationButton;
	
	/** Click the Checkbox to Confirm Cancel Registration button  **/
	@FindBy(xpath="//input[@id='confirmCancel']") private WebElementFacade confirmCancelRegistrationCheckbox;

	
	
	/** UAS Details assetAcquiredType **/
	@FindBy(css = "div#assetAcquiredType") private WebElementFacade assetAcquiredType;
	
	//div[@id='assetAcquiredType' and contains(text(), 'Home Built')]
	/** Verify the UAS Type Home Built **/
	@FindBy(xpath="//div[contains(text(), 'Home Built')]") private WebElementFacade verifyUasTypeHomeBuilt;
	/** Verify the UAS Type Purchased **/
	@FindBy(xpath="//div[contains(text(), 'Purchased')]") private WebElementFacade verifyUasTypePurchased;
	
	
	
	
	//verifyUasTypeHomeBuilt
	public String getVerifyUasTypeHomeBuilt() {
		return verifyUasTypeHomeBuilt.getAttribute("value");
	}
	//verifyUasTypePurchased
	public String getVerifyUasTypePurchased() {
		return verifyUasTypePurchased.getAttribute("value");
	}

	
	String country1 = "United States";
//	Serenity.sessionVariableCalled("country1").toString();
//	Serenity.setSessionVariable(country1).toString();
	
	String[] cityStateZip  = DataGenerator.randomCityStateZip();
	String city1 = cityStateZip[0];
	String state1 = cityStateZip[1];
	String zip1  = cityStateZip[2];
	static String country = "United States";
	private static final String varBillingCountry = country;
	
	/** Click the Shopping Cart Sort by Nickname button **/
	@FindBy(xpath="//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/thead/tr/th[1]/a/span") private WebElementFacade sortByShoppingCartNickname;
	/** Click the Shopping Cart Sort by Manufacturer button **/
	@FindBy(xpath="//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/thead/tr/th[2]/a/span") private WebElementFacade sortByShoppingCartManufacturer;
	/** Click the Shopping Cart Sort by Model button **/
	@FindBy(xpath="//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/thead/tr/th[3]/a/span") private WebElementFacade sortByShoppingCartModel;
	/** Click the Shopping Cart Sort by Serial Number button **/
	@FindBy(xpath="//*[@id='body']/div[2]/div/div/div[3]/div[3]/div/div[2]/div/div[3]/ngcart-cart/div[2]/div[3]/table/thead/tr/th[4]/a/span")  private WebElementFacade sortByShoppingCartSerialNumber;

	/** Click the SortByNickname button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[1]/a/span") private WebElementFacade SortByNickname;
	/** Click the SortByManufacturer button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[2]/a/span") private WebElementFacade SortByManufacturer;
	/** Click the SortByModel button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[3]/a/span") private WebElementFacade SortByModel;
	/** Click the SortBySerialNumber button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[4]/a/span") private WebElementFacade SortBySerialNumber;
	/** Click the SortByRegistration button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[5]/a/span") private WebElementFacade SortByRegistration;
	/** Click the SortByIssued button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[6]/a/span") private WebElementFacade SortByIssued;
	/** Click the SortByExpires button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[7]/a/span") private WebElementFacade SortByExpires;
	/** Click the SortByStatus button **/
	@FindBy(xpath="//*[@id='#inventoryTable']/thead/tr/th[8]/a/span") private WebElementFacade SortByStatus;

	//cancelReason -- Select a random value from the drop down list
	@FindBy(xpath = "//select[@id='cancelReason']") private WebElementFacade cancelReason;
	
	public void selectRandomCancelReason1(){
	 Select randonCancelReason = new Select(cancelReason);
	 List <WebElement> weblist = randonCancelReason.getOptions();
	 //Taking the count of items
	 int iCnt = weblist.size();
	 //Using Random class to generate random values
	 Random num = new Random();
	 int iSelect = num.nextInt(iCnt);
	 //Selecting value from DropDownList
	 randonCancelReason.selectByIndex(iSelect); //  .selectByIndex(iSelect);
	 //Selected Value
	 System.out.println(cancelReason.getAttribute("value"));
	 System.out.println("The Random Cancel Reason drop down value is " + cancelReason.getAttribute("value")); 
	 
	}
	
	public void selectRandomCancelReason() {
		String varCancelReason = DataGenerator.randomCancelReason();
		System.out.println("Variable Random Cancel Reason-->" + varCancelReason);
		cancelReason.selectByVisibleText(varCancelReason);
		System.out.println("Random Cancel Reason-->" + varCancelReason);
	}
	
	
	
	
/////	
//	/**
//	 * @param inputText
//	 *            will be selected from the list of Cancel Reason
//	 */
//	public void selectRandomCancelReason(String inputText) {
//		Select dropDownList = new Select(cancelReason);
//		dropDownList.selectByValue(inputText);
//	}
//
//	/**
//	 * @return a list of all of the Cancel Reasons from the drop-down. String.
//	 */
//	public List<String> getListOfCancelReasons() {
//		Select dropDownList = new Select(cancelReason);
//		List<WebElement> dropDownListCancelReason = dropDownList.getOptions();
//		List<String> listOfCancelReason = new ArrayList<String>();
//		for (int j = 0; j < dropDownListCancelReason.size(); j++) {
//			listOfCancelReason.add(dropDownListCancelReason.get(j).getAttribute(
//					"value"));
//		}
//		 System.out.println(cancelReason.getAttribute("value"));
//		 System.out.println("The Random Cancel Reason drop down value is " + listOfCancelReason); 
//		 System.out.println("****Random Cancel Reason is ****" +cancelReason.getAttribute("value"));
//
//		return listOfCancelReason;
//	}	
////
	
	
	
	
	
public void typeIntoCardNumber() {
	cardNumber.type(DataGenerator.randomCreditCardNumber());
	System.out.println("Billing City1 is " + cityStateZip[0]);
	System.out.println("Billing State1 is " + cityStateZip[1]);
	System.out.println("Billing Zip1 is " + cityStateZip[2]);
	System.out.println("Billing Credit Card Number is: " + getTypeIntoCardNumber());
	assertThat(cardNumberTitle.isCurrentlyVisible()).isTrue();
	
}
public String getTypeIntoCardNumber() {
	return cardNumber.getAttribute("value");
}
public void typeCvcNumber() {
	cvcNumber.type(DataGenerator.randomNumber(4));
	System.out.println("CVC Number is: " + getTypeCvcNumber());
	assertThat(cardNumberTitle.isCurrentlyVisible()).isTrue();
}
public String getTypeCvcNumber() {
	return cvcNumber.getAttribute("value");
}
public void selectARandomExpirationMonth() {
	expMonth.selectByVisibleText(DataGenerator.randomExpMonth());
	System.out.println("Random Expire Month is: " + getARandomExpirationMonth());
	assertThat(expMonthTitle.isCurrentlyVisible()).isTrue();
	}
public String getARandomExpirationMonth() {
	return expMonth.getAttribute("value");
}
public void selectARandomExpirationYear() {
	//expYear.selectByIndex(DataGenerator.randomIntegerBetween(0,expYear.getSelectOptions().size()) - 1);
	expYear.selectByVisibleText(DataGenerator.randomExpYear());
	System.out.println("Randomw Expire Year is: " + getARandomExpirationYear());
	assertThat(expYearTitle.isCurrentlyVisible()).isTrue();

}
public String getARandomExpirationYear() {
	return expYear.getAttribute("value");
}


//billingAddressIsSame
public void clickOnBillingIsSameCheckbox() {
	billingAddressIsSame.click();
	System.out.println("billingAddressIsSame has been checked");
	//Serenity.takeScreenshot();
	waitABit(1000);
	billingAddressIsSame.click();
	System.out.println("billingAddressIsSame has been Unchecked");
	//Serenity.takeScreenshot();
}


public void typeIntoBillingFirstName() {
	billingFirstName.type(DataGenerator.randomLastName());
	System.out.println(getTypeIntoBillingFirstName());
	System.out.println("Last Name is " + getTypeIntoBillingFirstName());
	assertThat(billingFirstNameTitle.isCurrentlyVisible()).isTrue();
}
public String getTypeIntoBillingFirstName() {
	return billingFirstName.getAttribute("value");
}

public void typeIntoBillingLastName() {
	billingLastName.type(DataGenerator.randomLastName());
	System.out.println(getTypeIntoBillingLastName());
	System.out.println("Last Name is " + getTypeIntoBillingLastName());
	assertThat(billingLastNameTitle.isCurrentlyVisible()).isTrue();
}

public String getTypeIntoBillingLastName() {
	return billingLastName.getAttribute("value");
}
public void selectARandomCountry() {
	//billingCountry.selectByIndex(DataGenerator.randomIntegerBetween(0,billingCountry.getSelectOptions().size()) - 1);
	//String varBillingCountry =  country;
	System.out.println("Billing Country is " + varBillingCountry );
	System.out.println("Random Billing Country is " + varBillingCountry);
	billingCountry.selectByVisibleText(varBillingCountry);
//	System.out.println(getselectARandomCountry());
	System.out.println("Random Country of United States is " + getselectARandomCountry());
//	System.out.println("Country is " + billingCountry);
	assertThat(billingAddress_countryTitle.isCurrentlyVisible()).isTrue();
	
}
public String getselectARandomCountry() {
	//return billingCountry.getAttribute("value");
	return billingCountry.getSelectedVisibleTextValue();  
}
public void typeIntoBillingAddress1() {
	billingAddress1.type(DataGenerator.randomNumber(6) + " " + DataGenerator.randomStreetAddress());
	assertThat(billingAddress_addressLine1Title.isCurrentlyVisible()).isTrue();
}	
public String getTypeIntoBillingAddress1() {
	//return billingAddress1.getAttribute("value");//value is string:US
	return billingAddress1.getAttribute("label"); //label is United States

}
public void typeIntoBillingAddress2() {
	billingAddress2.type("PO Box " + DataGenerator.randomNumber(6));
	assertThat(billingAddress_addressLine2Title.isCurrentlyVisible()).isTrue();
}	
public String getTypeIntoBillingAddress2() {
	return billingAddress2.getAttribute("value");
}
public void typeIntoBillingCity() {
	billingCity.type(cityStateZip[0]);
	//System.out.println("Select City Name is " + billingCity);
	System.out.println("Select City Name from array is " + cityStateZip[0]);
	assertThat(billingAddress_cityTitle.isCurrentlyVisible()).isTrue();
	
	
}	
public String getTypeIntoBillingCity() {
	return billingCity.getAttribute("value");
}
public void selectBillingState() {
//	System.out.println("Selected State Name inputText is " + getSelectBillingState());
	System.out.println("Select State Name is " + billingState);
	System.out.println("Select State Name from array is " + cityStateZip[1]);
	billingState.selectByVisibleText(cityStateZip[1].trim());
	if (varBillingCountry.equals("United States")){
		System.out.println("Billing Country is US ==> billingAddress_stateProvinceRegionTitle is visible" );
		assertThat(billingAddress_stateProvinceRegionTitle.isCurrentlyVisible()).isTrue();
	} else {	
		System.out.println("Select State Name from array is " + cityStateZip[1]);
		System.out.println("Billing Country is NOT US or US territory ==> billingAddress_stateProvinceRegionNonUsTitle is visible" );
		assertThat(billingAddress_stateProvinceRegionNonUsTitle.isCurrentlyVisible()).isTrue();
	}

}	
public String getSelectBillingState() {
	return billingState.getAttribute("value");
	
}	
	public void typeIntoBillingZip() {
		billingZip.clear();
		billingZip.type(cityStateZip[2].trim());
		System.out.println("Billing zip is " + cityStateZip[2]);
		System.out.println("Billing zip array is " + zip1);
		assertThat(billingAddress_zipPostalTitle.isCurrentlyVisible()).isTrue();
		
	}	
	
	
	/**body#body div div div uas-breadcrumbs ol li a
	UAS Registration Home Link **/
	@FindBy(css = "body#body div div div uas-breadcrumbs ol li a") private WebElementFacade uasRegistrationLink;
	
	
//	@FindBy(xpath = "//button[@type='button']") private WebElementFacade iAgreeButton;
	
	//Welcome banner on welcome page
	@FindBy(css = "html body div div div div div div h1") private WebElementFacade welcomeBanner;
	
	
	@FindBy(id = "login") WebElementFacade usernameField;
	@FindBy(id = "password") WebElementFacade passwordField;
//	@FindBy(id = "login") WebElementFacade submitButton;
	@FindBy(xpath = "//button[@type='submit']") private WebElementFacade submitButton;
	/** Click the Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-remote']") private WebElementFacade modelAircraft;

	/** Click the Non-Model Aircraft Button */
	@FindBy(xpath = "body#body div div div div div div div div [@class='icon-heads']") private WebElementFacade nonModelAircraft;
	
	//sortByShoppingCartNickname
	public void clickOnSortByShoppingCartNicknameButton() {
		sortByShoppingCartNickname.click();
		System.out.println("Click on Shopping Cart Sort By Nickname Button");
	}
	//sortByShoppingCartManufacturer
	public void clickOnSortByShoppingCartManufacturerButton() {
		sortByShoppingCartManufacturer.click();
		System.out.println("Click on Shopping Cart Sort By Manufacturer Button");
	}
	//sortByShoppingCartModel
	public void clickOnSortByShoppingCartModelButton() {
		sortByShoppingCartModel.click();
		System.out.println("Click on Shopping Cart Sort By Model Button");
	}
	//sortByShoppingCartSerialNumber
	public void clickOnSortByShoppingCartSerialNumberButton() {
		sortByShoppingCartSerialNumber.click();
		System.out.println("Click on Shopping Cart Sort By Serial Number Button");
	}
	
	//SortByNickname
	public void clickOnSortByNicknameButton() {
		click(SortByNickname);
		System.out.println("SortByNickname Button is Clicked");
	}
	//SortByManufacturer
	public void clickOnSortByManufacturerButton() {
		click(SortByManufacturer);
		System.out.println("SortByManufacturer Button is Clicked");
	}
		//SortByModel
	public void clickOnSortByModelButton() {
		click(SortByModel);
		System.out.println("SortByModel Button is Clicked");
	}
		//SortBySerialNumber
	public void clickOnSortBySerialNumberButton() {
		click(SortBySerialNumber);
		System.out.println("SortBySerialNumber Button is Clicked");
	}
		//SortByRegistration
	public void clickOnSortByRegistrationButton() {
		click(SortByRegistration);
		System.out.println("SortByRegistration Button is Clicked");
	}
		//SortByIssued
	public void clickOnSortByIssuedButton() {
		click(SortByIssued);
		System.out.println("SortByIssued Button is Clicked");
	}
		//SortByExpires
	public void clickOnSortByExpiresButton() {
		click(SortByExpires);
		System.out.println("SortByExpires Button is Clicked");
	}
	//SortByStatus
	public void clickOnSortByStatusButton() {
		click(SortByStatus);
		System.out.println("SortByStatus Button is Clicked");
	}
	//viewInventoryButton
	public void clickOnViewInventoryButton() {
		click(viewInventoryButton);
		System.out.println("Inventory Button is Clicked");
	}
	//registeredInventory1
	public void clickOnRegisteredInventory1() {
		click(registeredInventory1);
		System.out.println("Click on Registered Inventory Button is Clicked");
	}
	//ellipse1
	public void clickOnEllipse1Button() {
		waitABit(1000);
		click(ellipse1);
		System.out.println("Click on ellipse Button");
	}
	//ellipseEditButton1
	public void clickOnEllipseEditButton1() {
//		click(ellipseEditButton1);
//		System.out.println("Click on ellipse Edit Button");
//	}
	if (ellipseEditButton1.isCurrentlyVisible()){
		click(ellipseEditButton1);
		System.out.println("Click on ellipse Edit Button");
	} else {
		clickOnSortByStatusButton();
		//clickOnSortByExpiresButton();
		clickOnEllipse1Button();
		click(ellipseCancelButton1);
		}
	}	
	
	
	
	//ellipseCloneButton
	public void clickOnEllipseCloneButton() {
		click(ellipseCloneButton1);
		System.out.println("456 Click on Ellipse Clone Button");
	}
	//ellipseCancelButton
	public void clickOnEllipseCancelButton() {
		if (ellipseCancelButton1.isCurrentlyVisible()){
		click(ellipseCancelButton1);
		System.out.println("Cancel Button is visible and now you Click on Ellipse Cancel Button");
	} else {
		clickOnSortByExpiresButton();
		clickOnEllipse1Button();
		click(ellipseCancelButton1);
		}
	}	
		
	//ellipseEmailButton
	public void clickOnEllipseEmailButton() {
		if (!ellipseEmailButton1.isCurrentlyVisible()){
			clickOnSortByStatusButton();
			waitABit(1000);
			System.out.println("I am clicking on Ellipse 1 Button");
			clickOnEllipse1Button();
			System.out.println("Successfully clicked on the Ellipse 1 Button");
		}
		click(ellipseEmailButton1);
		System.out.println("Click on Ellipse Email Button");
	}
	//ellipseRenewButton
	public void clickOnEllipseRenewButton() {
		click(ellipseRenewButton1);
		System.out.println("Click on Ellipse Renew Button");
	}
	//ellipseDetailsButton1
	public void clickOnEllipseDetailsButton() {
		click(ellipseDetailsButton1);
		System.out.println("Click on ellipse Details Button");
	}
	//cancelButton
	public void clickOnCancelButton() {
		click(cancelButton);
		System.out.println("Click on Cancel Button");
	}
	//shoppingCartEllipse
	public void clickOnShoppingCartEllipseButton() {
		shoppingCartEllipse.click();
		System.out.println("Click on Shopping Cart Ellipse Button");
	}
	//shoppingCartEllipseEdit
	public void clickOnShoppingCartEllipseEditButton() {
		shoppingCartEllipseEdit.click();
		System.out.println("Click on Shopping Cart Ellipse Edit Button");
	}
	//shoppingCartEllipseClone
	public void clickOnShoppingCartEllipseCloneButton() {
		shoppingCartEllipseClone.click();
		System.out.println("Click on Shopping Cart Ellipse Clone Button");
	}
	//shoppingCartEllipseRemove	
	public void clickOnShoppingCartEllipseRemoveButton() {
		shoppingCartEllipseRemove.click();
		System.out.println("Click on Shopping Cart Ellipse Remove Button");
	}
	
	//shoppingCartUndoRemoval	
	public void clickOnShoppingCartUndoRemovalButton() {
		shoppingCartUndoRemoval.click();
		System.out.println("Click on Shopping Cart Undo Removal Button");
	}


	//returnToInventoryButton
	public void clickOnReturnToInventoryButton() {
		returnToInventoryButton.click();
		System.out.println("Click on Return to Inventory Link on the Cancel UAS Registration Screen");
	}
	//cancelRegistrationButton
	public void clickOnCancelRegistrationButton() {
		cancelRegistrationButton.click();
		System.out.println("Click on Cancel Registration Button from the Cancel UAS Registration Screen");
	}
	
	//confirmCancelRegistrationCheckbox
	public void clickOnConfirmCancelRegistrationCheckbox() {
		confirmCancelRegistrationCheckbox.click();
		System.out.println("Click on Confirm Cancel Registration Button from the Cancel UAS Registration Screen");
	}
	//acknowledgmentNextButton
	public void clickOnAcknowledgmentNextButton() {
		click(acknowledgmentNextButton);
	}
	//billingNextButton
	public void clickOnBillingNextButton() {
		billingNextButton.click();
	}
	//uasRegistrationLink
	public void clickOnUasRegistrationLink() {
		click(uasRegistrationLink);
	}
	public void clickmodelAircraftButton() {
		click(modelAircraft);
	}
	public void clicknonModelAircraftButton() {
		click(nonModelAircraft);
	}
	public void typeIntoUsernameField(String username) {
		usernameField.type(username);
	}

	public void typeIntoPasswordField(String password) {
		passwordField.type(password);
	}

	public void clickSubmitButton() {
		click(submitButton);
	}
	//reviewAcknowledgeButton
	public void clickOnReviewAcknowledgmentButton() {
		click(reviewAcknowledgeButton);
	}
	//reviewPayButton
	public void clickOnReviewPayButton() {
		click(reviewPayButton);
	}

	//paymentDoneButton
	public void clickOnDoneButton() {
		paymentDoneButton.click();
		System.out.println("Click on Done Button to complete payment process");
	}

}

