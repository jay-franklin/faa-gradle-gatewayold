package faa.cucumber.maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import faa.cucumber.apiStepLibraries.ManageUserApiLibrary;
import faa.cucumber.stepLibraries.BaseUserSteps;
import faa.cucumber.stepLibraries.ManageUserSteps;
//import faa.cucumber.stepLibraries.MenuUser;
//import faa.cucumber.stepLibraries.UserAccessUser;
import faa.models.User;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;


public class CreateANewUserMap {
	
	@Steps BaseUserSteps baseUserSteps;
//	@Steps MenuUser menuUser;
	@Steps ManageUserSteps manageUserSteps;
//	@Steps UserAccessUser userAccessUser;
//	@Steps ManageUserApiLibrary manageUserLibrary;

	public User newUser;

//	@When("'(.*)' tab is selected")
//	public void goToManageUsersAndClickTab(String tabSelection) {
//		manageUserSteps.clickOnManageUsersTab(tabSelection);
//	}

	@When("I fill out the new applicant form with random data")
	public void whenIFillOutTheFormWRandomData() {
		newUser = new User();
		newUser.setUSCISSiteCode("MIK");
		Serenity.setSessionVariable("userName").to(newUser.getFullName());
		manageUserSteps.fillOutTheAddUserFormWithNewUserInformation(newUser);
		manageUserSteps.clickOnSaveButton();
		manageUserSteps.verifySuccessfullySavedMessageIsVisible();
	}

//	@Then("A new applicant should be created")
//	public void thenANewApplicantShouldBeCreated() {
//		String userName = Serenity.sessionVariableCalled("userName").toString();
//		menuUser.clickManageUsersFromAdministration();
//		manageUserSteps.clickOnManageUsersTab("Edit User");
//		manageUserSteps.searchForUser(userName);
//		manageUserSteps.clickEditUserForResult(1);
//		manageUserSteps.verifyUserInformationMatches(userName);
//
//	}

	@When("I click save")
	public void iClickSaveButton() {
		manageUserSteps.clickOnSaveButton();
	}

	@When("i edit the first name field to '(.*)'")
	public void editTheFirstNameField(String newFirstName) {
		manageUserSteps.editFirstNameTo(newFirstName);
		manageUserSteps.saveNewInformation();
		manageUserSteps.verifySuccessfullyUpdatedMessageIsVisible();
	}

//	@Then("when i search for '(.*)' the results should be correct")
//	public void whenISearchForUserResultsShouldBeCorrect(String userToSearch) {
//		menuUser.clickManageUsersFromAdministration();
//		manageUserSteps.clickOnManageUsersTab("Edit User");
//		manageUserSteps.searchForUser(userToSearch);
//		manageUserSteps.clickEditUserForResult(1);
//		manageUserSteps.verifyUserInformationMatches(userToSearch);
//	}

//	@When("I click the '(.*)' tab selected")
//	public void givenOnEditUserPage(String tabSelection) {
//		manageUserSteps.clickOnManageUsersTab(tabSelection);
//	}

	@When("I fill out the new applicant form with random data as role Site Admin")
	public void whenIFillOutTheForm() {

		manageUserSteps.fillOutTheAddUserFormWithNewUserInformationAsSiteAdminRole(newUser);
	}

	@Then("A new applicant should be created with role Site Admin")
	public void thenToTheCreateApplicantPage() {
//		menuUser.clickManageUsersFromAdministration();
		baseUserSteps.logOutOffaa();
	}

	@When("I search for and click edit for the user '(.*)'")
	public void searchForAndEdit(String userToEdit) {
		manageUserSteps.searchForUser(userToEdit);
		manageUserSteps.clickEditUserForResult(1);
	}
	

	
	@When ("i edit the user first name field to '(.*)', middle name field to '(.*)' and last name to '(.*)'")
	public void editTheUser(String newFirstName, String newMiddleName, String newLastName){
		manageUserSteps.editFirstNameTo(newFirstName);
		manageUserSteps.editMiddleIntialTo(newMiddleName);
		manageUserSteps.editLastNameTo(newLastName);
		manageUserSteps.saveNewInformation();
		manageUserSteps.verifySuccessfullyUpdatedMessageIsVisible();	
		
	}	
	
//	@Then("delete the user for a clean purpose")
//	public void deleteTheUser()
//	{
//		manageUserLibrary.deleteTheUser(newUser);
//	}
//	

}