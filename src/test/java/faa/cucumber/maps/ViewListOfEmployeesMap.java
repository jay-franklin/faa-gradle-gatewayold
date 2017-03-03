package faa.cucumber.maps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import faa.cucumber.stepLibraries.ListOfEmployeesUser;
import faa.cucumber.stepLibraries.ManageUserSteps;
import faa.models.User;
import net.thucydides.core.annotations.Steps;

public class ViewListOfEmployeesMap {

	@Steps
	ManageUserSteps manageUserSteps;
	@Steps
	ListOfEmployeesUser listOfEmployeesUser;

	User newUser;

	@When("a new user has been created for site '(.*)'")
	public void given1(String siteCode) {
		newUser = new User();
		newUser.setUSCISSiteCode(siteCode);
//		manageUserSteps.clickOnManageUsersTab("Add user");
		manageUserSteps.fillOutTheAddUserFormWithNewUserInformation(newUser);
		manageUserSteps.clickOnSaveButton();
		manageUserSteps.verifySuccessfullySavedMessageIsVisible();

	}

	@When("i select the site code and search the list of employees by '(.*)' for the new user")
	public void when1(String searchField) {
		listOfEmployeesUser.selectSiteCode(newUser.getUSCISSiteCode());
		listOfEmployeesUser.searchForUserUsingField(newUser, searchField);
	}

//	@Then("the list should contain the newly created user")
//	public void then1() {
//		listOfEmployeesUser.selectSiteCode(newUser.getUSCISSiteCode());
//		listOfEmployeesUser.verifyNameIsInSearchResults(newUser.getFullName());
//	}

}