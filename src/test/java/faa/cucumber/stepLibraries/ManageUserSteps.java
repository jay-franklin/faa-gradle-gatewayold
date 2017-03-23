
package faa.cucumber.stepLibraries;

import faa.cucumber.pages.AddNewUasPage;
import faa.cucumber.pages.AddUserPage;
import faa.cucumber.pages.EditUserPage;
import faa.cucumber.pages.FaaHomePage;
//import faa.cucumber.pages.ManageUsersPage;
import faa.cucumber.pages.AddNewUasPage;
import faa.models.User;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ManageUserSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6798534333250676289L;

	AddUserPage addUserPage;
	EditUserPage editUserPage;
//	ManageUsersPage manageUsersPage;
	FaaHomePage faaHomePage;
	AddNewUasPage addNewUasPage;

	
	
	@Step 
	public void clickOnLogoutButton(){
		faaHomePage.clickOnLogoutButton();
	}
	
	@Step
	public void clickOnProfileTab(){
		faaHomePage.clickOnProfileTab();
		System.out.println("Profile Tab has been clicked");
	}
	@Step
	public void clickOnInventoryTab() {
		faaHomePage.clickOnInventoryTab();
	}
	
	
	@Step
	public void clickOnWelcomeDropdownMenuButton(){
		faaHomePage.clickOnWelcomeDropdownButton();
	}
	
	
	@Step
	public void verifyProfileUpdatedSuccessMessage(){
		editUserPage.verifyProfileUpdatedSuccessMessage();
	}

	
	@Step
	public void clickOnEditProfileButton(){
		faaHomePage.clickOnEditProfileButton();
	}
	
	//Edit Non Hobbyist Account Details Section
	@Step
	public void clickOnEditNonHobbyistAccountDetailsButton(){
		editUserPage.clickOnEditGeneralAccountInformation();
	}
	@Step
	public void clickToEditNonHobbyistAccountDetails(){
		editUserPage.editNonHobbyistAccountDetails();
	}

	
	//Edit Primary Email Address Button Section
	@Step
	public void clickOnEditPrimaryEmailAddressButton(){
		editUserPage.clickOnEditPrimaryEmailAddressButton();
	}
	
	
	//Edit Non Hobbyist Personal Information Section
	@Step
	public void clickOnEditNonHobbyistPersonalInformation(){
		editUserPage.clickOnEditNonHobbyistPersonalInformation();
	}

	@Step
	public void clickOnEditNonHobbyistOrganizationInformation(){
		editUserPage.clickOnEditNonHobbyistOrganizationInformation();
	}

	
	
	@Step
	public void clickToEditNonHobbyistGatewayAccountDetails(){
		editUserPage.editNonHobbyistAccountDetails();
	}
	
	
		
	@Step
	public void fillOutTheAddUserFormWithNewUserInformationAsSiteAdminRole(User newUser) {
		addUserPage.fillFormWithUserInformationSA(newUser);
	}

	@Step
	public void fillOutTheAddUserFormWithNewUserInformation(User newUser) {
		addUserPage.fillFormWithUserInformation(newUser);
		printUserInformation(newUser);
	}


	@Step
	public void printUserInformation(User newUser) {
		System.out.println(newUser);
	}

	@Step
	public void clickOnSaveButton() {
		addUserPage.clickSave();
	}

//	@Step
//	public void clickOnManageUsersTab(String tabSelection) {
//		manageUsersPage.selectTab(tabSelection);
//	}

	@Step
	public void searchForUser(String nameToSearch) {
		editUserPage.searchForUser(nameToSearch);
	}

	@Step
	public void clickEditUserForResult(int i) {
		editUserPage.clickEditButtonForResult(i);
	}

	@Step
	public void editFirstNameTo(String newFirstName) {
		editUserPage.typeIntoFirstNameField(newFirstName);
	}

	@Step
	public void saveNewInformation() {
		editUserPage.clickSaveButton();
	}

	@Step
	public void verifySuccessfullySavedMessageIsVisible() {
		editUserPage.successfullySavedMessageShouldBeVisible();
	}
	
	@Step
	public void verifySuccessfullyUpdatedMessageIsVisible() {
		editUserPage.successfullyUpdatedMessageShouldBeVisible();
	}

	@Step
	public void verifyUserInformationMatches(String userToSearch) {
		String[] splitName = userToSearch.split(" ");
		editUserPage.verifyFirstNameEquals(splitName[0]);
		editUserPage.verifyMiddleNameEquals(splitName[1]);
		editUserPage.verifyLastNameEquals(splitName[2]);
	}

	@Step
	public void insertIntoNewUser(User newUser, String userType, String userRole1,
			String userRole2, String userRole3, String userRole4,
			String userRole5, String userRole6, String userRole7,
			String userRole8) {
		List<String> userRoles = new ArrayList<String>();
		userRoles.add(userRole1);
		userRoles.add(userRole2);
		userRoles.add(userRole3);
		userRoles.add(userRole4);
		userRoles.add(userRole5);
		userRoles.add(userRole6);
		userRoles.add(userRole7);
		userRoles.add(userRole8);
		newUser.resetAllUserAccess();
		for(String a : userRoles){
			switch(a){
			
			case "Global Reports":
				newUser.setGlblreport(true);
				break;
			case "Multiple Appointments":
				newUser.setMultipleappt(true);
				break;
			case "Overbook Appointments":
				newUser.setOverbook(true);
				break;
			case "Reports":
				newUser.setReport(true);
				break;
			case "Scheduling":
				newUser.setSchedule(true);
				break;
			case "Check In and Check Out":
				newUser.setCheckInOut(true);
				break;
			default:
				break;
			}
		}
		newUser.setUserType(userType);
	}

	public void editMiddleIntialTo(String newMiddleName) {
		editUserPage.typeIntoMiddleInitialField(newMiddleName);
		
	}

	public void editLastNameTo(String newLastName) {
		editUserPage.typeIntoLastNameField(newLastName);
		
	}

	public void clickOnChangePrimaryEmailLink() {
		editUserPage.clickOnChangePrimaryEmailLink();
	}

	public void completeChangePrimaryEmailForm() {
		editUserPage.completeChangePrimaryEmailForm();
	}

	

}