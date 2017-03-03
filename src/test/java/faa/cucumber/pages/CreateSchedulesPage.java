package faa.cucumber.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author jfranklin
 */
public class CreateSchedulesPage extends BasePageObject{

	@FindBy(id = "site")
	protected WebElementFacade uscisSiteLocationDropdown;
	@FindBy(id = "duration")
	protected WebElementFacade durationMinutesField;
	@FindBy(id = "room")
	protected WebElementFacade roomNumberField;
	@FindBy(id = "setupBreakBtn")
	protected WebElementFacade addBreakButton;
	@FindBy(id = "break_duration_0")
	protected WebElementFacade enterBreakDurationTimesMin;
	@FindBy(id = "resources")
	protected WebElementFacade resourcesPerTimeSlotField;
	@FindBy(id="boOverrideInd")
	protected WebElementFacade createSchdeulesOnHolidayCheckBox;
	@FindBy(id = "save_schedule")
	protected WebElementFacade saveScheduleButton;
	@FindBy(id = "save_schedule")
	protected WebElementFacade saveScheduleFinalTab;
	@FindBy(css = "div#form-views div.row.ng-scope div.col-md-4 div.form-group div.input-group span button.btn.btn-default")
	private List<WebElementFacade> calendarButtons;
	@FindBy(css = "div#form-views div div ul li div table thead tr th button.btn.btn-default.btn-sm.pull-right")
	private List<WebElementFacade> monthForwardButton;
	@FindBy(css = "div.input-group ul li div table tbody tr td.text-center.ng-scope")
	private List<WebElementFacade> calendarDayButtons;
	@FindBy(css = "div#daysOfWeek div")
	private List<WebElementFacade> daysOfTheWeek;
	@FindBy(css = "table#startTime tbody tr td input")
	private List<WebElementFacade> startTimeHourMinutes;
	@FindBy(css = "table#startTime tbody tr td button")
	private WebElementFacade startAmPmButton;
	@FindBy(css = "table#endTime tbody tr td input")
	private List<WebElementFacade> endTimeHourMinutes;
	@FindBy(css = "table#endTime tbody tr td button")
	private WebElementFacade endAmPmButton;
	@FindBy(css = "table#break_time_0 tbody tr td input")
	private List<WebElementFacade> breakTimeHoursAndMinutes0;
	@FindBy(css = "table#break_time_0 tbody tr td button")
	private WebElementFacade breakAmPmButton;
	@FindBy(id = "break_duration_0")
	protected WebElementFacade breakDurationField0;
	@FindBy(id = "removeBreakBtn_0")
	protected WebElementFacade firstRemoveBreakButton;
	@FindBy(css = "div#manageschedule-page-summary div div span strong")
	protected WebElementFacade statusMessage;
	/**Entire Table for calendars  {@value}*/
	static final String calendarTablesCssSelector = "ul li div table";
	/**continue Buttons  {@value}*/
	static final String continueButtonCssSelector = "button#continue";
	/** {@value}*/
	static final String setUpScheduleCssSelector= "div.container.fade-element.container-main.ng-scope div ul li a";
	/**<p>the today button and clear buttons on the calendar {@value}*/
	static final String todayAndClearButtonsCssSelector = "ul li.ng-scope span.btn-group.pull-left button";
	/**the category dropdown {@value}*/
	static final String categoryDropdown = "#type";


	
	public WebElementFacade appointmentCategoryDropdown(){
		return find(By.id("type"));
	}
	
	public List<WebElementFacade> calendarTableButtons(){
		return findAll(By.cssSelector("div.col-md-4 div div ul li div table tbody tr td button"));
	}
	
	public List<WebElementFacade> calendarTableSpans(){
		return findAll(By.cssSelector("div.col-md-4 div div ul li div table tbody tr td span"));
	}


	

	public void selectFromAppointmentCategoryDropdownByPartialVisibleText(String inputText) {
		selectFromDropdownVisibleTextThatContains(findWebElementByCssSelector(categoryDropdown), inputText);

	}
	
	public void selectFromAppointmentCategoryDropdownByValue(String inputText) {
		appointmentCategoryDropdown().selectByValue(inputText);
	}

	public List<String> getListOfAppointmentCategories() {
		return appointmentCategoryDropdown().getSelectOptions();
	}

	public void selectFromTheCalendarStartAndEndDateOfNextMonth(String startDay, String endDay) {
		setImplicitTimeout(20, TimeUnit.SECONDS);
		click(calendarButtons,1);
		click(calendarButtons,0);
		click(monthForwardButton.get(1));
		click(monthForwardButton.get(0));
		List<WebElementFacade> buttons = calendarTableButtons();
		List<WebElementFacade> spans = calendarTableSpans();
		click(buttons.get(startIndexThatMatchesDayNumber(spans, startDay)));
		click(calendarButtons.get(0));
		monthForwardButton.get(0).waitUntilClickable();
		buttons = calendarTableButtons();
		spans = calendarTableSpans();
		click(buttons.get(endIndexThatMatchesDayNumber(spans, endDay)));
		click(calendarButtons.get(0));
		resetImplicitTimeout();
	}
	
	/**
	 * returns the index of the first calendar span tag that contains the given day, 
	 * use this to select the button to click
	 * @param spans - a list of all the span tags in the calendar
	 * @param day - the day you want to return the index of
	 * @return
	 */
	public int startIndexThatMatchesDayNumber(List<WebElementFacade> spans, String day){
		int i = 0;
		while(!spans.get(i).getText().contains("01")){
			i++;
		}
		for(int j =i ; j < spans.size(); j++){
			if(spans.get(j).getText().contains(day)){
				return j;
			}
		}
		return 0;
	}
	
	/**
	 * returns the index of the second calendar span tag that contains the given day, 
	 * use this to select the button to click
	 * 
	 * goes to the third occuring "01" in the span tag, then looks for your day from there
	 * 
	 * BOTH calendars need to be open
	 * 
	 * @param spans - a list of all the span tags in the calendar
	 * @param day - the day you want to return the index of
	 * @return
	 */
	public int endIndexThatMatchesDayNumber(List<WebElementFacade> spans, String day){
		
		int i = 0;
		while(!spans.get(i).getText().contains("01")){
			i++;
		}
		i++;
		while(!spans.get(i).getText().contains("01")){
			i++;
		}
		i++;
		while(!spans.get(i).getText().contains("01")){
			i++;
		}
		for(int j =i ; j < spans.size(); j++){
			//System.out.println(spans.get(j).getText());
			if(spans.get(j).getText().contains(day)){
				return j;
			}
		}
		return 0;
	}


	
	
	public void selectSunday() {
		click(daysOfTheWeek.get(0));
	}

	public void selectMonday() {
		click(daysOfTheWeek.get(1));
	}

	public void selectTuesday() {
		click(daysOfTheWeek.get(2));
	}

	public void selectWednesday() {
		click(daysOfTheWeek.get(3));
	}

	public void selectThursday() {
		click(daysOfTheWeek.get(4));
	}

	public void selectFriday() {
		click(daysOfTheWeek.get(5));
	}

	public void selectSaturday() {
		click(daysOfTheWeek.get(6));
	}

	public void unCheckWeekdays() {
		Iterator<WebElementFacade> it = daysOfTheWeek.iterator();
		it.next();
		click(it.next());
		click(it.next());
		click(it.next());
		click(it.next());
		click(it.next());
	}


	public void selectFromUscisLocationSiteLists(String inputText) {
		waitForSplashScreenToFinish();
		uscisSiteLocationDropdown.selectByValue(inputText);
		waitABit(1000);
	}

	public void selectFromAppointmentCategoryLists(String inputText) {
		appointmentCategoryDropdown().selectByValue(inputText);
	}

	public void clickOnAddBreakButton() {
		click(addBreakButton);
		firstRemoveBreakButton.waitUntilClickable();

	}

	public String getEnterBreakDurationTimesMin() {
		return enterBreakDurationTimesMin.getValue();
	}

	public void enterBreakDurationTimesMin(String inputText) {
		enterBreakDurationTimesMin.type(inputText);
	}

	public void typeIntoResourcesPerTimeSlotField(String inputText) {
		resourcesPerTimeSlotField.type(inputText);
	}

	public void clickOnContinueButton() {
		click(continueButtonCssSelector);
	}

	public void clickOnSaveScheduleButton() {
		waitForSplashScreenToFinish();
		click(saveScheduleButton);
	}

	public void clickOnSaveScheduleFinalTab() {
		click(saveScheduleFinalTab);
	}

	public String getStatusMessage() {
		return statusMessage.getText();
	}



	/**
	 * <p>
	 * Must be of the form <strong>"HH:MM AM"</strong>
	 * </p>
	 * 
	 * @param string
	 *            - time
	 */
	public void inputAppointmentStartTime(String string) {
		String[] time = new String[3];
		if (string.split(" ").length == 2) {
			time[2] = string.split(" ")[1];
			if (string.split(" ")[0].split(":").length == 2) {
				time[1] = string.split(" ")[0].split(":")[1];
				time[0] = string.split(" ")[0].split(":")[0];
			}
		}
		if (time[2].equalsIgnoreCase("PM")) {
			click(startAmPmButton);
		} else {
		}
		startTimeHourMinutes.get(0).clear();
		startTimeHourMinutes.get(0).sendKeys(time[0]);
		startTimeHourMinutes.get(1).clear();
		startTimeHourMinutes.get(1).sendKeys(time[1]);
	}

	/**
	 * <p>
	 * Must be of the form <strong>"HH:MM AM"</strong>
	 * </p>
	 * 
	 * @param string
	 *            - time
	 */
	public void inputAppointmentEndTime(String string) {
		String[] time = new String[3];
		if (string.split(" ").length == 2) {
			time[2] = string.split(" ")[1];
			if (string.split(" ")[0].split(":").length == 2) {
				time[1] = string.split(" ")[0].split(":")[1];
				time[0] = string.split(" ")[0].split(":")[0];
			}
		}
		if (time[2].equalsIgnoreCase("AM")) {
			click(endAmPmButton);
		} else {
		}
		endTimeHourMinutes.get(0).type(time[0]);
		endTimeHourMinutes.get(1).type(time[1]);
	}

	/**
	 * <p>
	 * Must be of the form <strong>"HH:MM AM"</strong>
	 * </p>
	 * 
	 * @param string
	 *            - time
	 */
	public void inputBreakStartTime(String string) {
		String[] time = new String[3];
		if (string.split(" ").length == 2) {
			time[2] = string.split(" ")[1];
			if (string.split(" ")[0].split(":").length == 2) {
				time[1] = string.split(" ")[0].split(":")[1];
				time[0] = string.split(" ")[0].split(":")[0];
			}
		}
		if (time[2].equalsIgnoreCase("AM")) {
			click(breakAmPmButton);
		} else {
		}

		breakTimeHoursAndMinutes0.get(0).type(time[0]);
		breakTimeHoursAndMinutes0.get(1).type(time[1]);
	}

	public void inputBreakDuration(String string) {
		breakDurationField0.type(string);
	}

	public void clickRemoveBreakButton() {
		click(firstRemoveBreakButton);
		firstRemoveBreakButton.waitUntilNotVisible();
	}

	public void clickTab(String tabSelection) {
		clickLinkWithText(tabSelection);
	}

	public void selectStartDateFromCalendar(String startDate) {
		waitForSplashScreenToFinish();
		click(calendarButtons.get(0));
		selectDateFromCalendar(calendarTablesCssSelector,startDate, 0);
		
	}

	public void selectEndDateFromCalendar(String startDate) {
		click(calendarButtons.get(1));
		selectDateFromCalendar(calendarTablesCssSelector,startDate, 0);
	}

	public void clickCheckBoxToCreateSchdeulesOnHoliday() {
		click(createSchdeulesOnHolidayCheckBox);
		
	}
	
	public void clickSetupScheduleButton()
	{
		waitABit(500);
		click(findWebElementByCssSelector(setUpScheduleCssSelector));
	}

	public void createSchedulesForToday() {
		waitABit(500);
		click(calendarButtons.get(0));
		waitForRenderedElementsToBePresent(By.cssSelector(todayAndClearButtonsCssSelector));
		waitABit(500);
		click(findWebElementsByCssSelector(todayAndClearButtonsCssSelector).get(0));
		waitABit(500);
		click(calendarButtons.get(1));
		waitForRenderedElementsToBePresent(By.cssSelector(todayAndClearButtonsCssSelector));
		waitABit(500);
		click(findWebElementsByCssSelector(todayAndClearButtonsCssSelector).get(0));
		waitABit(500);
		
	}

}
