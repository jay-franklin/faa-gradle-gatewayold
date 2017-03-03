package faa.cucumber.pages;

import faa.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddUserPage extends BasePageObject {

	@FindBy(id = "save") WebElementFacade saveButton;
	@FindBy(id = "email") WebElementFacade emailField;
	@FindBy(id = "userType") WebElementFacade userTypeDropdown;
	@FindBy(id = "firstName") WebElementFacade firstNameField;
	@FindBy(id = "middleName") WebElementFacade middleNameField;
	@FindBy(id = "lastName") WebElementFacade lastNameField;

	/** Site code drop down Selector: {@value} */
	static final String siteCodeDropdownCssSelector = "#site";

	public void fillFormWithUserInformation(User user) {

		findWebElementByCssSelector(siteCodeDropdownCssSelector).selectByValue(user.getUSCISSiteCode());
		userTypeDropdown.selectByValue(user.getUserType());
		emailField.type(user.getEmailAddress());
		firstNameField.type(user.getFirstName());
		middleNameField.type(user.getMiddleName());
		lastNameField.type(user.getLastName());

		if (user.isCheckInOut())
			click("input#user_access_CHECKINOUT");
		if (user.isGlblreport())
			click("input#user_access_GLBLREPORT");
		if (user.isMultipleappt())
			click("input#user_access_MULTIPLEAPPT");
		if (user.isOverbook())
			click("input#user_access_OVERBOOK");
		if (user.isReport())
			click("input#user_access_REPORT");
		if (user.isSchedule())
			click("input#user_access_SCHEDULE");
	}

	public void fillFormWithUserInformationSA(User user) {
		findWebElementByCssSelector(siteCodeDropdownCssSelector).selectByValue(user.getUSCISSiteCode());
		userTypeDropdown.selectByValue(user.getUserType());
		emailField.typeAndTab(user.getEmailAddress());
		firstNameField.type(user.getFirstName());
		middleNameField.type(user.getMiddleName());
		lastNameField.type(user.getLastName());

		if (user.isCheckInOut())
			click("input#user_access_CHECKINOUT");
		if (user.isGlblreport())
			click("input#user_access_GLBLREPORT");
		if (user.isMultipleappt())
			click("input#user_access_MULTIPLEAPPT");
		if (user.isOverbook())
			click("input#user_access_OVERBOOK");
		if (user.isReport())
			click("input#user_access_REPORT");
		if (user.isSchedule())
			click("input#user_access_SCHEDULE");
	}

	public void clickSave() {
		click(saveButton);
	}

}