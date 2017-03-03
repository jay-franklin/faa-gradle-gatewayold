package faa.cucumber.pages;

import faa.utils.DataGenerator;
import faa.utils.PageSourceParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/** @author mddamato */
public class ManageAppointmentsPage extends BasePageObject {

	@FindBy(id = "manageAppointments") protected WebElementFacade manageAppointments;
	@FindBy(id = "site") protected WebElementFacade site;
	@FindBy(id = "release") protected WebElementFacade appointmentRelease;
	@FindBy(css = "td#pageBody div div div div table thead tr td input.input-sm.form-control") protected WebElementFacade globalSearch;
	@FindBy(xpath = "/html/body/table/tbody/tr[2]/td/div/div/div/div[2]/table/tbody/tr/td[2]") protected WebElementFacade manageAppointmentName;
	@FindBy(linkText = "table thead tr th") protected WebElementFacade appointmentType;
	@FindBy(id = "editbtn_0") protected WebElementFacade editRescheduleButton_0;
	@FindBy(id = "reschedDt") protected WebElementFacade rescheduleAppointmentDate;
	@FindBy(id = "apptTm") protected WebElementFacade rescheduleAppointmentTime;
	@FindBy(id = "save") protected WebElementFacade rescheduleAppointmentButton;

	/** On the Manage Appointments page, Appointment Date Field {@value} */
	private static final String appointmentDateFieldCssSelector = "div div span button";
	/** On the Manage Appointments page, Appointment Time Field {@value} */
	private static final String appointmentTimeFieldCssSelector = "select#apptTm";
	/** {@value} */
	private static final String calendarItemsCssSelector = "div#form-views div div ul li div table tbody tr td button";
	/** Select all calendar dates with ID starting with datepicker {@value} */
	private static final String manageAppointmentCalendarItemsCssSelector = "div ul li div table tbody tr td button";
	/** {@value} */
	private static final String successMessageCssSelector = "div div span strong";
	/** All elements form the manage appointments result table {@value} */
	private static final String allTableElementsCssSelector = "table.table.table-striped.table-bordered tbody tr td";
	/** site dropdown list {@value} */
	private static final String siteDropdownListCssSelector = "select#site";
	/** Success Message {@value} */
	private static final String manageAppointmentNotificationMessageCssSelector = "div div span strong";
	/** the today button and clear buttons on the calendar {@value} */
	private static final String todayAndClearButtonsCssSelector = "ul li.ng-scope span.btn-group.pull-left button";
	/** button to open the calendar {@value} */
	private static final String calendarButtonCssSelector = "div.input-group span.input-group-btn button.btn.btn-default";

	public void verifyManageAppointmentSuccessMessage() {
		verifyWebElementByCssSelectorContainsText(manageAppointmentNotificationMessageCssSelector, "SUCCESS");
	}

	public List<WebElementFacade> searchAppointmentResultTable() {

		return findAll(By
				.cssSelector("table.table.table-striped.table-bordered.ng-scope tbody tr.animate-repeat.ng-scope td"));
	}

	public WebElementFacade searchResultRow1() {
		return find(By.cssSelector("td#pageBody div div div table tbody tr"));
	}

	/** @deprecated If the name is known then use:
	 *             releaseAppointmentByName(String fullName)
	 * @param searchResultRow */
	public void clickCheckboxForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 0;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			WebElementFacade button = (searchAppointmentResultTable
					.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight).findBy(By.tagName("label")));
			click(button);
		} else {
			// TODO: error message
		}

		site.shouldBePresent();
	}

	public String getDateAndTimeForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 1;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getNameForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 2;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getStatusForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 3;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getTypeForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 4;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getCategoryForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 5;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getConfirmationNumberForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 6;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public String getCreatedDateForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 7;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			return searchAppointmentResultTable.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight)
					.getText();
		} else {
			return "";
			// TODO: error message
		}
	}

	public void clickEditRescheduleForSearchResult(int searchResultRow) {
		waitForSearchResultsToLoad();
		int totalColumns = 9;
		int columnOffsetFromRight = 8;
		List<WebElementFacade> searchAppointmentResultTable = searchAppointmentResultTable();
		if (searchAppointmentResultTable.size() >= (searchResultRow * totalColumns)) {
			WebElementFacade button = (searchAppointmentResultTable
					.get(((searchResultRow - 1) * totalColumns) + columnOffsetFromRight).findBy(By.tagName("button")));
			click(button);
		} else {

			// TODO: error message
		}
	}

	public void typeAndEnterIntoglobalSearch(String inputText) {
		globalSearch.typeAndEnter(inputText);
	}

	public void clickOnManageAppointmentsLeftHandMenuButton() {
		click(manageAppointments);
	}

	public void clickOnAppointmentReleaseButton() {
		click(appointmentRelease);
	}

	public void clickOnEditReschedule_0Button() {
		click(editRescheduleButton_0);
	}

	public void clickOnRescheduleAppointmentButtonButton() {
		click(rescheduleAppointmentButton);
		verifySuccessMessage();

	}

	public void selectSiteCodeFromSiteDropdownList(String sitecode) {
		waitABit(1000);
		findWebElementByCssSelector(siteDropdownListCssSelector).selectByValue(sitecode);
	}

	public void waitForSearchResultsToLoad() {
		searchResultRow1().waitUntilPresent();
		searchResultRow1().waitUntilVisible();
	}

	public void verifySuccessMessage() {
		findWebElementByCssSelector(successMessageCssSelector).shouldContainText("SUCCESS:");
	}

//	public List<String> getAllNamesFromSearchResults() {
//		waitABit(1000);
//		PageSourceParser parser = new PageSourceParser(allTableElementsCssSelector, getDriver());
//		List<String> allTextFromTable = parser.getListOfTextFromAllElements();
//		List<String> allNamesFromTable = new ArrayList<String>();
//		Iterator<String> it = allTextFromTable.iterator();
//		while (it.hasNext()) {
//			for (int i = 0; i < 2; i++) {
//				it.next();
//			}
//			allNamesFromTable.add(it.next());
//			if (linkWithTextExists("Type")) {
//				for (int i = 0; i < 6; i++) {
//					it.next();
//				}
//			} else {
//				for (int i = 0; i < 5; i++) {
//					it.next();
//				}
//			}
//		}
//
//		return allNamesFromTable;
//	}

//	public List<String> getAllConfirmationNumbersFromSearchResults() {
//
//		waitABit(1000);
//		PageSourceParser parser = new PageSourceParser(allTableElementsCssSelector, getDriver());
//		List<String> allTextFromTable = parser.getListOfTextFromAllElements();
//		List<String> allConfirmationNumbersFromTable = new ArrayList<String>();
//		Iterator<String> it = allTextFromTable.iterator();
//		while (it.hasNext()) {
//			for (int i = 0; i < 2; i++) {
//				it.next();
//			}
//			allConfirmationNumbersFromTable.add(it.next());
//			if (linkWithTextExists("Type")) {
//				for (int i = 0; i < 6; i++) {
//					it.next();
//				}
//			} else {
//				for (int i = 0; i < 5; i++) {
//					it.next();
//				}
//			}
//		}
//
//		return allConfirmationNumbersFromTable;
//	}

	public void releaseAppointmentByName(String fullName) {
		waitABit(1000);
		List<WebElementFacade> wholeTable = findWebElementsByCssSelector(allTableElementsCssSelector);
		Iterator<WebElementFacade> it = wholeTable.iterator();
		while (it.hasNext()) {
			WebElement checkbox = it.next().findElement(By.tagName("span"));
			it.next();
			if (it.next().getText().equalsIgnoreCase(fullName)) {
				click(checkbox);
				break;
			}
			for (int i = 0; i < 5; i++) {
				it.next();
			}
		}
		waitABit(500);
		clickOnAppointmentReleaseButton();
	}

	public void selectARandomTimeSlotForAppointment() {
		// selectARandomOptionFromDropdown(appointmentTimesOptionsCssSelector,
		// appointmentTimesDropdownCssSelector);
		findWebElementByCssSelector(appointmentTimeFieldCssSelector).selectByIndex(1);
	}

	public void clickOnAValidDateFromManageAppointmentsCalendarAndSelectATimeSlot() {
		waitABit(500);
		waitForSplashScreenToFinish();
		waitForElement(appointmentDateFieldCssSelector);
		waitForElement(appointmentTimeFieldCssSelector);
		// waitForElement("input#apptDt");
		click(findWebElementByCssSelector(appointmentDateFieldCssSelector));
		waitABit(1500);
		List<WebElementFacade> calendarItemsToKeep = new ArrayList<WebElementFacade>();
		// List<WebElementFacade> allCalendarItems =
		// findWebElementsByCssSelector(calendarItemsCssSelector);
		List<WebElementFacade> allCalendarItems = findWebElementsByCssSelector(
				manageAppointmentCalendarItemsCssSelector);

		waitABit(1000);
		for (WebElementFacade current : allCalendarItems) {
			String disabled = current.getAttribute("disabled");
			if (disabled == null) {
				calendarItemsToKeep.add(current);
			}

		}
		int dayToClick = DataGenerator.randomIntegerBetween(0, calendarItemsToKeep.size() - 1);

		click(calendarItemsToKeep.get(dayToClick));
		calendarItemsToKeep.get(dayToClick).waitUntilNotVisible();

		// select time
		waitABit(500);
		selectARandomTimeSlotForAppointment();
		click(rescheduleAppointmentButton);

	}

	public void clickTodaysDateForAppointment() {
		waitForRenderedElementsToBePresent(By.cssSelector(calendarButtonCssSelector));
		waitABit(500);
		click(findWebElementByCssSelector(calendarButtonCssSelector));
		waitForRenderedElementsToBePresent(By.cssSelector(todayAndClearButtonsCssSelector));
		waitABit(500);
		click(findWebElementsByCssSelector(todayAndClearButtonsCssSelector).get(0));
		waitABit(500);
	}

}