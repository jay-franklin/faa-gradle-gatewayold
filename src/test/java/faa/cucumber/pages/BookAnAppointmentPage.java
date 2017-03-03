/**
 * 
 */
package faa.cucumber.pages;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import faa.utils.DataGenerator;
//import faa.utils.PageSourceParser;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jfranklin
 *
 */
public class BookAnAppointmentPage extends BasePageObject {

	@FindBy(id = "scheduling")
	protected WebElementFacade schedulingButton;
	@FindBy(id = "appointments")
	protected WebElementFacade appointmentButton;
	@FindBy(id = "zipCode")
	protected WebElementFacade zipcodeField;
	@FindBy(id = "next")
	protected WebElementFacade next1Button;
	@FindBy(id = "next_2")
	protected WebElementFacade next2Button;
	@FindBy(id = "next_4")
	protected WebElementFacade next4Button;
	@FindBy(id = "next_5")
	protected WebElementFacade next5Button;
	@FindBy(id = "next_6")
	protected WebElementFacade next6Button;
	@FindBy(css = "a#location span")
	protected WebElementFacade number1Button;
	@FindBy(id = "firstName")
	protected WebElementFacade firstNameField;
	@FindBy(id = "middleName")
	protected WebElementFacade middleNameField;
	@FindBy(id = "lastName")
	protected WebElementFacade lastNameField;
	@FindBy(id = "dob")
	protected WebElementFacade dobField;
	@FindBy(id = "applZip")
	protected WebElementFacade applicantZipcodeField;
	@FindBy(id = "country")
	protected WebElementFacade countryField;
	@FindBy(id = "teleNo")
	protected WebElementFacade phoneNumberField;
	
	
	//@FindBy(id = "numPerson") Old element name
	@FindBy(id = "applGrpSize")
	protected WebElementFacade numberOfPeopleField;
	@FindBy(id = "email")
	protected WebElementFacade emailAddressField;
	@FindBy(id = "aNum")
	protected WebElementFacade aNumberField;
	@FindBy(id = "rcptNo")
	protected WebElementFacade receiptNumberField;
	@FindBy(id = "apptDt")
	protected WebElementFacade appointmentDate;
	@FindBy(css = "table tbody tr.ng-scope td.text-center.ng-scope")
	protected WebElementFacade clickApptDateCalender;
	@FindBy(xpath = "//input[contains(@id,'deletebtn_')]")
	protected WebElementFacade deleteButton;
	@FindBy(id = "schedule")
	protected WebElementFacade scheduleButton;
	@FindBy(id = "confirmationbtn")
	protected WebElementFacade confirmationIcon;
	@FindBy(css = "form#bookAppt-form div div div label input")
	private List<WebElementFacade> allFieldOfficeRadioButtons;
	@FindBy(css="div.form-group fieldset div.ng-scope label span")
	private List<WebElementFacade> allServiceType;
	@FindBy(id = "type_dropdown")
	protected WebElementFacade appointmentCategoryDropdown;

	/**{@value}*/
	static final String allConfirmationItemsCssSelector = "div#form-views.col-xs-10.col-xs-offset-1.col-md-8.col-md-offset-2.fader.ng-scope div.row.ng-scope div.col-sm-6.ng-binding";
	/**{@value}*/
	static final String allTypeOfServiceRadioButtonsCssSelector = "div#form-views div div label input";
	/**<p>Names of all the service types{@value}*/
	static final String allTypeOfServiceTitlesCssSelector = "div#form-views div div label span";
	/**{@value}*/
	static final String newsTextCssSelector = "div#form-views div.form-group.row.fader.ng-scope div.well.black-font.ng-binding";
	/**<p>Success Message {@value}*/
	static final String notificationMessageCssSelector = "div div span strong";
	/**<p>Appointment Date Field {@value}</p>*/
	static final String appointmentDateFieldCssSelector = "input#apptDt";
	/**<p>Appointment Time Field {@value}"</p>*/
	static final String appointmentTimeFieldCssSelector = "select#apptTm";
	/**<p>Country dropdown {@value}</p>*/
	static final String countryDropdownCssSelector = "select#country";
	/**<p>the today button and clear buttons on the calendar {@value}*/
	static final String todayAndClearButtonsCssSelector = "ul li.ng-scope span.btn-group.pull-left button";	
	/**<p>appointment time select dropdown {@value}</p>*/
	static final String appointmentTimesDropdownCssSelector = "select#apptTm";
	/**<p>appointment time select OPTIONS {@value}</p>*/
	static final String appointmentTimesOptionsCssSelector = "select#apptTm option";
	/**<p>button to open the calendar {@value}*/
	static final String calendarButtonCssSelector = "div.input-group span.input-group-btn button.btn.btn-default";
	/**<p>appointment Category Dropdown {@value}*/
	static final String appointmentCategoryDropdownCssSelector = "select#type_dropdown";
	/**<p>number 1 Button Css Selector {@value}*/
	static final String number1ButtonCssSelector = "a#location span";
	/**<p>next 2 Button Css Selector {@value}*/
	static final String next2ButtonCssSelector = "button#next_2";
	/**<p>next 5 Button Css Selector {@value}*/
	static final String next5ButtonCssSelector = "button#next_5";
	/**<p>next 6 Button Css Selector {@value}*/
	static final String next6ButtonCssSelector = "button#next_6";
	/**<p>Schedule Button Css Selector {@value}*/
	static final String scheduleButtonCssSelector = "button#schedule";
	/**{@value}*/
	static final String calendarItemsCssSelector = "div#form-views div div ul li div table tbody tr td button";
	/**{@value}*/
	static final String next3ButtonCssSelector = "button#next_3";
	
	public void clickApptDateCalenderButton() {
		click(clickApptDateCalender);
	}

	public void clickNext6Button() {
		WebElementFacade  nextButton = findWebElementByCssSelector(next6ButtonCssSelector);
		click(nextButton);
	}

	public List<String> getListOfAvailableTimeslots() {
		return findWebElementByCssSelector(appointmentTimesDropdownCssSelector).getSelectOptions();
	}

	public void selectAvailableSlot(String inputText) {
		findWebElementByCssSelector(appointmentTimesDropdownCssSelector).selectByVisibleText(inputText);
	}

	public void clickOnSchedulingButton() {
		click(schedulingButton);
	}

	public void clickOnScheduleButton() {
		click(scheduleButton);
	}

	public void clickOnAppointmentButton() {
		click(appointmentButton);
	}

	public void ClickOnNumber1Button() {
		waitForSplashScreenToFinish();
		waitABit(1000);
		waitForElement(number1ButtonCssSelector);
		click(number1ButtonCssSelector);
	}

	public void typeIntoZipBox(String inputText) {
		zipcodeField.type(inputText);
	}

	public void typeIntoZipcode(String inputText) {
		applicantZipcodeField.type(inputText);
	}

	public void clickOnNext1Button() {
		waitABit(500);
		click(next1Button);
	}

	public void clickOnNext2Button() {
		WebElementFacade  nextButton = findWebElementByCssSelector(next2ButtonCssSelector);
		click(nextButton);
	}

	public void clickOnNext3Button() {
		waitForSplashScreenToFinish();
		WebElementFacade  nextButton = findWebElementByCssSelector(next3ButtonCssSelector);
		click(nextButton);
	}

	public void clickOnNext4Button() {
		click(next4Button);
	}

	public void clickOnNext5Button() {
		waitABit(1000);
		waitForElement(next5ButtonCssSelector);
		WebElementFacade  nextButton = findWebElementByCssSelector(next5ButtonCssSelector);
		click(nextButton);
	}

	public void clickOnNext6Button() {
		click(next6Button);
	}

	public void typeIntoFirstName(String inputText) {
		firstNameField.type(inputText);
	}

	public void typeIntoMiddleName(String inputText) {
		middleNameField.type(inputText);
	}

	public String getLastNameValue() {
		return lastNameField.getValue();
	}

	public void typeIntoLastName(String inputText) {
		lastNameField.type(inputText);
	}

	public String getDOBValue() {
		return dobField.getValue();

	}

	public void typeIntoDobField(String inputText) {
		dobField.type(inputText);
	}

	public String getPhoneNumberFieldValue() {
		return phoneNumberField.getValue();
	}

	public void typeIntoPhoneNumberField(String inputText) {
		phoneNumberField.type(inputText);
	}

	public String getNumberOfPeopleFieldValue() {
		return numberOfPeopleField.getValue();
	}

	public void typeIntoNumberOfPerson(String inputText) {
		numberOfPeopleField.type(inputText);
	}

	public String getEmailAddressFieldValue() {
		return emailAddressField.getValue();
	}

	public void typeIntoEmailAddress(String inputText) {
		emailAddressField.type(inputText);
	}

	public String getANumberFieldValue() {
		return aNumberField.getValue();
	}

	public void typeIntoANumberField(String inputText) {
		aNumberField.type(inputText);
	}

	public String getReceiptNumberFieldValue() {
		return receiptNumberField.getValue();
	}

	public void typeIntoReceiptNumberField(String inputText) {
		receiptNumberField.type(inputText);
	}

	public void typeIntoAppointmentDateField(String inputText) {
		appointmentDate.type(inputText);
	}

	public void clickScheduleButton() {
		waitForSplashScreenToFinish();
		WebElementFacade  nextButton = findWebElementByCssSelector(scheduleButtonCssSelector);
		click(nextButton);
		confirmationIcon.waitUntilEnabled();
		assertThat(confirmationIcon.isCurrentlyVisible()).isTrue();
	}

	public void clickOnConfirmationIcon(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
		confirmationIcon.waitUntilClickable();
//		wait.until(ExpectedConditions.elementToBeClickable(confirmationIcon));
		int attempts = 0;
		while (attempts < 3) {
			try {
				click(confirmationIcon);
				break;
			} catch (NoSuchElementException e) {
			}
			attempts++;
		}
		click(confirmationIcon);
	}

	public void fillInAppointmentDate(String date) {
		appointmentDate.type(date);

		appointmentDate.shouldContainText("");

		assertThat(appointmentDate.getValue()).contains("12/09/2015");

	}



	public void clickOnAValidDateFromTheCalendarAndSelectATimeSlot() {
		waitABit(1500);
		waitForElement(calendarButtonCssSelector);
		waitForElement(appointmentTimesDropdownCssSelector);
		waitForElement("input#apptDt");
		click(calendarButtonCssSelector);
		waitABit(500);
		List<WebElementFacade> calendarItemsToKeep = new ArrayList<WebElementFacade>();
		List<WebElementFacade> allCalendarItems = findWebElementsByCssSelector(calendarItemsCssSelector);
		waitABit(1000);
		for (WebElementFacade current : allCalendarItems) {
			String disabled = current.getAttribute("disabled");
			if(disabled==null){
				calendarItemsToKeep.add(current);
			}
			
		}
		int dayToClick = DataGenerator.randomIntegerBetween(1,
				calendarItemsToKeep.size() - 1);
		
		click(calendarItemsToKeep.get(dayToClick));
		calendarItemsToKeep.get(dayToClick).waitUntilNotVisible();

		//select time
		waitABit(500);
		selectARandomTimeSlotForAppointment();
	}

	public void verifyPrintButtonExists() {
		confirmationIcon.waitUntilEnabled();
		assertThat(confirmationIcon.isCurrentlyVisible()).isTrue();

	}

	public void selectAFieldOfficeByNameAbbreviation(String siteName) {
		//somewhere around here has a wait problem
		for (WebElementFacade a : allFieldOfficeRadioButtons) {
			if (a.getAttribute("id").equalsIgnoreCase(siteName)) {
				click(a);
			}
		}
	}


	public List<String> getAllFieldOfficeSiteCodes() {
		List<String> returnStrings = new ArrayList<String>();
		for (WebElementFacade a : allFieldOfficeRadioButtons) {
			returnStrings.add(a.getAttribute("id"));
		}
		return returnStrings;
	}

	public void selectAFieldOfficeRandomly() {
		click(allFieldOfficeRadioButtons.get(
				DataGenerator.randomIntegerBetween(0,allFieldOfficeRadioButtons.size() - 1)));
	}

	public void selectATypeOfServiceById(String id) {
		for (WebElementFacade a : allFieldOfficeRadioButtons) {
			if (a.getAttribute("id").equalsIgnoreCase(id)) {
				click(a);			}
		}
	}
	
	public void clickATypeOfServiceByTextValue(String serviceType){
		waitABit(1000);
		for(WebElementFacade type: allServiceType){
			
			if(type.getText().equalsIgnoreCase(serviceType)){
				click(type);
			}
		}
	}
	

	public String selectATypeOfServiceRandomly() {
		waitABit(1500);
		List<WebElementFacade> allServiceTypeRadioButtons = findWebElementsByCssSelectorWithError(allTypeOfServiceRadioButtonsCssSelector);
		List<WebElementFacade> allServiceTypeDescriptions = findWebElementsByCssSelectorWithError(allTypeOfServiceTitlesCssSelector);
		int selection = DataGenerator.randomIntegerBetween(0,allServiceTypeRadioButtons.size()-1);
		click(allServiceTypeRadioButtons.get(selection));
		return allServiceTypeDescriptions.get(selection).getText();
	}

	public void selectAnAppointmentCategoryRandomly() {
		List<String> categoryOptions = appointmentCategoryDropdown
				.getSelectOptions();
		appointmentCategoryDropdown.selectByVisibleText(categoryOptions
				.get(DataGenerator.randomIntegerBetween(0,
						categoryOptions.size() - 1)));
	}

	public void selectAnAppointmentCategoryByValue(String categoryAbbreviation) {
		WebElementFacade dropdown = findWebElementByCssSelector(appointmentCategoryDropdownCssSelector);
		dropdown.selectByValue(categoryAbbreviation);
		click(dropdown);
	}

	public String getAppointmentConfirmationDate() {
		return findWebElementsByCssSelector(allConfirmationItemsCssSelector).get(16).getText();
	}

	public String getAppointmentConfirmationTime() {
		return findWebElementsByCssSelector(allConfirmationItemsCssSelector).get(17).getText();
	}

	public String getNewsText() {
		return findWebElementByCssSelector(newsTextCssSelector).getText();
	}

	public String getTextFromConfirmationPDF() {
		return getPDFTextFromLink(confirmationIcon);
	}

	public void verifySuccessMessage() {
		verifyWebElementByCssSelectorContainsText(notificationMessageCssSelector, "SUCCESS");
	}

	public String getConfirmationNumber() {
		return findWebElementsByCssSelector(allConfirmationItemsCssSelector).get(0).getText();
	}

	public String getSelectedDate() {
		return findWebElementByCssSelector(appointmentDateFieldCssSelector).getValue();
	}

	public String getSelectedTime() {
		return findWebElementByCssSelector(appointmentTimeFieldCssSelector).getSelectedValue();
	}

	public String getSelectedCountry() {
		return findWebElementByCssSelector(countryDropdownCssSelector).getSelectedValue();
	}

	public void clickTodaysDateForAppointment() {
		waitForRenderedElementsToBePresent(By.cssSelector(calendarButtonCssSelector));
		waitABit(300);
		click(calendarButtonCssSelector);
		waitForRenderedElementsToBePresent(By.cssSelector(todayAndClearButtonsCssSelector));
		waitABit(300);
		click(todayAndClearButtonsCssSelector,0);
		waitABit(300);
	}

	public void selectARandomTimeSlotForAppointment() {
		findWebElementByCssSelector(appointmentTimesDropdownCssSelector).selectByIndex(1);
	}

	public void selectFromCountryDropDown(String country) {
		countryField.selectByValue(country);
	}

	public void verifyErrorMessage() {
		verifyWebElementByCssSelectorContainsText(notificationMessageCssSelector, "ERROR");
		
	}

}
