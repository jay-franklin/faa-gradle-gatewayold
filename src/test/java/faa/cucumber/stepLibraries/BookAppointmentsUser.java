/**
 * 
 */
package faa.cucumber.stepLibraries;

import java.util.List;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import faa.cucumber.pages.BookAnAppointmentPage;
import faa.cucumber.pages.CustomerSearchPage;
//import faa.cucumber.pages.MenuPage;
import faa.models.Appointment;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/** @author mddamato */
public class BookAppointmentsUser extends ScenarioSteps {
	private static final long serialVersionUID = -4700362749187260360L;

//	MenuPage menuPage;
	BookAnAppointmentPage bookAppointmentPage;
	CustomerSearchPage customerSearchPage;

	@Step
	public void verifyConfirmationMessageAndPrintButtonExists() {
		bookAppointmentPage.verifyPrintButtonExists();
	}

	@Step
	public void fillOutNewAppointmentFormWithAppointmentModel(Appointment appointmentModel) {
		waitABit(500);
		bookAppointmentPage.ClickOnNumber1Button();
		if (appointmentModel.getCountry().equalsIgnoreCase("US")) {
			bookAppointmentPage.typeIntoZipBox(appointmentModel.getZipCode());
			bookAppointmentPage.clickOnNext1Button();
			bookAppointmentPage.selectAFieldOfficeByNameAbbreviation(appointmentModel.getSiteCode());
			bookAppointmentPage.clickOnNext2Button();
			bookAppointmentPage.selectAnAppointmentCategoryByValue(appointmentModel.getAppointmentCategoryCode());
			bookAppointmentPage.clickOnNext3Button();

		} else {
			bookAppointmentPage.selectFromCountryDropDown(appointmentModel.getCountry());
			bookAppointmentPage.clickOnNext1Button();
			bookAppointmentPage.selectATypeOfServiceRandomly();
			bookAppointmentPage.clickOnNext3Button();

		}

		// }
		// else {
		// bookAppointmentPage.selectFromCountryDropDown(appointmentModel.getCountry());
		// bookAppointmentPage.clickOnNext1Button();
		// bookAppointmentPage.clickATypeOfServiceByTextValue(appointmentModel.getAppointmentType());
		// bookAppointmentPage.clickOnNext3Button();
		// }

		bookAppointmentPage.typeIntoFirstName(appointmentModel.getFirstName());
		bookAppointmentPage.typeIntoMiddleName(appointmentModel.getMiddleName());
		bookAppointmentPage.typeIntoLastName(appointmentModel.getLastName());
		bookAppointmentPage.typeIntoDobField(appointmentModel.getDateOfBirth());
		bookAppointmentPage.typeIntoPhoneNumberField(appointmentModel.getTelephoneNumber());
		bookAppointmentPage.typeIntoNumberOfPerson(Integer.toString(appointmentModel.getApplGrpSize()));
		bookAppointmentPage.typeIntoEmailAddress(appointmentModel.getEmailAddress());
		bookAppointmentPage.typeIntoANumberField(appointmentModel.getAlienNumber());
		bookAppointmentPage.typeIntoReceiptNumberField(appointmentModel.getReceiptNumber());
		bookAppointmentPage.clickOnNext4Button();
		waitABit(500);
		bookAppointmentPage.clickOnNext5Button();
		bookAppointmentPage.clickOnAValidDateFromTheCalendarAndSelectATimeSlot();
		appointmentModel.setAppointmentDate(bookAppointmentPage.getSelectedDate());
		appointmentModel.setAppointmentTime(bookAppointmentPage.getSelectedTime());
		bookAppointmentPage.clickNext6Button();
		waitABit(500);
		bookAppointmentPage.clickScheduleButton();
		bookAppointmentPage.verifySuccessMessage();
		appointmentModel.setConfirmationNumber(bookAppointmentPage.getConfirmationNumber());
		printConfirmationInfo(appointmentModel);
	}

	@Step
	public void printConfirmationInfo(Appointment appointmentModel) {
		System.out.println(appointmentModel);
	}

	@Step
	public String getDateOfAppointmentFromConfirmationMessage() {
		return bookAppointmentPage.getAppointmentConfirmationDate();
	}

	@Step
	public String getAppointmentTimeFromConfirmationMessage() {
		return bookAppointmentPage.getAppointmentConfirmationTime();
	}

	@Step
	public void typeIntoZipcodeFieldAndClickNext(String zipcode) {
		bookAppointmentPage.ClickOnNumber1Button();
		bookAppointmentPage.typeIntoZipBox(zipcode);
		bookAppointmentPage.clickOnNext1Button();
	}

	@Step
	public void typeIntoZipcodeFieldAndClickNextAgain(String zipcode) {
		waitABit(10000);
		bookAppointmentPage.ClickOnNumber1Button();
		bookAppointmentPage.typeIntoZipBox(zipcode);
		bookAppointmentPage.clickOnNext1Button();
	}

	@Step
	public void verifySiteCodeExistsInListOfSitesCodes(String siteCodeToCheckFor) {
		List<String> allSiteCodes = bookAppointmentPage.getAllFieldOfficeSiteCodes();
		boolean found = false;
		String allSites = "";
		for (String current : allSiteCodes) {
			allSites = allSites + current + " ";
			if (current.equalsIgnoreCase(siteCodeToCheckFor)) {
				found = true;
			}
		}
		assertThat(found).overridingErrorMessage("The sitecode was not found in the list. Sitecode we are looking for:"
				+ siteCodeToCheckFor + " but found: " + allSites).isTrue();
	}

	@Step
	public String getNewsTextForSite(String siteCode) {
		bookAppointmentPage.selectAFieldOfficeByNameAbbreviation(siteCode);
		return bookAppointmentPage.getNewsText();
	}

	@Step
	public void verifyTextPresentInPDF(String textToVerify) {
		String PDFText = bookAppointmentPage.getTextFromConfirmationPDF();
		assertThat(PDFText).overridingErrorMessage(
				"Text was not found in the PDF: " + textToVerify + ", \n\n The PDF Contents: \n\n" + PDFText + "\n\n")
				.containsIgnoringCase(textToVerify);

	}

	@Step
	public void fillOutNewAppointmentFormWithAppointmentModelAndRandomAppointmentForToday(
			Appointment appointmentModel) {
		bookAppointmentPage.ClickOnNumber1Button();
		bookAppointmentPage.typeIntoZipBox(appointmentModel.getZipCode());
		appointmentModel.setCountry(bookAppointmentPage.getSelectedCountry());
		bookAppointmentPage.clickOnNext1Button();
		// here
		bookAppointmentPage.selectAFieldOfficeByNameAbbreviation(appointmentModel.getSiteCode());
		bookAppointmentPage.clickOnNext2Button();
		bookAppointmentPage.selectAnAppointmentCategoryByValue(appointmentModel.getAppointmentCategoryCode());
		bookAppointmentPage.clickOnNext3Button();
		bookAppointmentPage.typeIntoFirstName(appointmentModel.getFirstName());
		bookAppointmentPage.typeIntoMiddleName(appointmentModel.getMiddleName());
		bookAppointmentPage.typeIntoLastName(appointmentModel.getLastName());
		bookAppointmentPage.typeIntoDobField(appointmentModel.getDateOfBirth());
		bookAppointmentPage.typeIntoPhoneNumberField(appointmentModel.getTelephoneNumber());
		bookAppointmentPage.clickOnNext4Button();
		bookAppointmentPage.clickOnNext5Button();
		bookAppointmentPage.clickTodaysDateForAppointment();
		bookAppointmentPage.selectARandomTimeSlotForAppointment();
		appointmentModel.setAppointmentDate(bookAppointmentPage.getSelectedDate());
		appointmentModel.setAppointmentTime(bookAppointmentPage.getSelectedTime());
		bookAppointmentPage.clickNext6Button();
		bookAppointmentPage.clickScheduleButton();
		bookAppointmentPage.verifySuccessMessage();
		appointmentModel.setConfirmationNumber(bookAppointmentPage.getConfirmationNumber());
		printConfirmationInfo(appointmentModel);
	}

	@Step
	public void selectFieldOfficeAndClickNext(String siteCode) {
		bookAppointmentPage.selectAFieldOfficeByNameAbbreviation(siteCode);
		bookAppointmentPage.clickOnNext2Button();
	}

	@Step
	public void selectCategoryCodeAndClickNext(String appointmentCategoryCode) {
		bookAppointmentPage.selectAnAppointmentCategoryByValue(appointmentCategoryCode);
		bookAppointmentPage.clickOnNext3Button();

	}

	@Step
	public void typeIntoFirstNameField(String firstName) {
		bookAppointmentPage.typeIntoFirstName(firstName);

	}

	@Step
	public void typeIntoMiddleNameField(String middleName) {
		bookAppointmentPage.typeIntoMiddleName(middleName);
	}

	@Step
	public void typeIntoLastNameField(String lastName) {
		bookAppointmentPage.typeIntoLastName(lastName);
	}

	@Step
	public void typeIntoBirthdayField(String dateOfBirth) {
		bookAppointmentPage.typeIntoDobField(dateOfBirth);

	}

	@Step
	public void typeIntoTelephoneField(String telephoneNumber) {
		bookAppointmentPage.typeIntoPhoneNumberField(telephoneNumber);
	}

	@Step
	public void typeIntoNumberOfPersons(String numberOfPersons) {
		bookAppointmentPage.typeIntoPhoneNumberField(numberOfPersons);

	}

	@Step
	public void typeIntoEmailAddress(String emailAddress) {
		bookAppointmentPage.typeIntoEmailAddress(emailAddress);

	}

	@Step
	public void typeIntoAlienNumber(String alienNumber) {
		bookAppointmentPage.typeIntoANumberField(alienNumber);
	}

	@Step
	public void typeIntoReceiptNumberAndClickNextButton(String receiptNumber) {
		bookAppointmentPage.typeIntoReceiptNumberField(receiptNumber);
		bookAppointmentPage.clickOnNext4Button();
		waitABit(1000);
		bookAppointmentPage.clickOnNext5Button();

	}

	@Step
	public void clickRandomDateAndTimeAndClickNext() {
		bookAppointmentPage.clickOnAValidDateFromTheCalendarAndSelectATimeSlot();
		bookAppointmentPage.clickNext6Button();
		bookAppointmentPage.clickScheduleButton();

	}

	@Step
	public void verifyErrorMessage() {
		bookAppointmentPage.verifyErrorMessage();

	}

	public void selectFromCountryDropDownAndClickNext(String country) {
		bookAppointmentPage.ClickOnNumber1Button();
		bookAppointmentPage.selectFromCountryDropDown(country);
		bookAppointmentPage.clickOnNext1Button();
	}

	public void selectATypeOfServiceRandomlyAndClickNext() {
		bookAppointmentPage.selectATypeOfServiceRandomly();
		bookAppointmentPage.clickOnNext3Button();

	}

}