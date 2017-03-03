package faa.cucumber.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class UserAccessPage extends BasePageObject {

	@FindBy(id = "reports") WebElementFacade reportLink;
	@FindBy(id = "appointments") WebElementFacade bookAppointmentsLink;
	@FindBy(css = "button#addholidaybtn") private WebElementFacade addHolidayButton;
	@FindBy(id = "userType") private WebElementFacade UserTypeDropdown;

	/** {@value} */
	private static final String allUSCISLocationDropdown = "select#site";
	/** {@value} */
	private static final String schedulingButtonCssSelector = "a#scheduling";
	/** {@value} */
	private static final String allHolidayTypeDropdown = "select#blkoutTypCdDesc_";

	public boolean reportLinkNotVisible(String menuLink) {

		waitForSplashScreenToFinish();
		waitABit(2000);
		if (isElementVisible(By.partialLinkText(menuLink)))
			return false;
		else
			return true;
	}

	public boolean reportLinkVisible(String menuLink) {

		waitForSplashScreenToFinish();
		waitABit(3000);
		click(schedulingButtonCssSelector);

		if (isElementVisible(By.linkText(menuLink)))
			return true;
		else
			return false;
	}

	public boolean reportLinkShouldBeVisible(String menuLink) {
		waitForSplashScreenToFinish();
		if (isElementVisible(By.linkText(menuLink)))
			return true;
		else
			return false;

	}

	public boolean schedulingLinkNotVisible(String menuLink) {
		waitForSplashScreenToFinish();
		if (isElementVisible(By.linkText(menuLink)))
			return false;
		else
			return true;

	}

	public List<String> getAllUSCISLocations() {
		WebElementFacade uscisLocationDropdown = findWebElementByCssSelector(allUSCISLocationDropdown);
		List<String> allLocations = uscisLocationDropdown.getSelectOptions();
		List<String> allSiteCodes = new ArrayList<String>();
		for (String a : allLocations) {
			allSiteCodes.add(a.substring(0, 3));
		}
		return allSiteCodes;
	}

	public void clickAddHolidayButton() {
		click(addHolidayButton);
	}

	public List<String> getAllHolidayType() {
		WebElementFacade holidayTypeDropdown = findWebElementByCssSelector(allHolidayTypeDropdown);
		List<String> allHolidayTypes = holidayTypeDropdown.getSelectOptions();
		List<String> allHoliday = new ArrayList<String>();
		for (String a : allHolidayTypes) {
			allHoliday.add(a);
		}
		return allHoliday;
	}

	public boolean manageAppointmentAndBookAppointmentLinkVisible(String firstLink, String secondLink) {
		waitForSplashScreenToFinish();
		waitABit(3000);
		click(schedulingButtonCssSelector);
		if (isElementVisible(By.linkText(firstLink)) && isElementVisible(By.linkText(secondLink)))
			return true;
		else
			return false;

	}

	public void changeAccessLevel(String accessLevel) {
		UserTypeDropdown.selectByVisibleText(accessLevel);

	}

}
