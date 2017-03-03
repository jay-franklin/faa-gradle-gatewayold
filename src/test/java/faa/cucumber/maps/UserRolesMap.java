package faa.cucumber.maps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import faa.cucumber.stepLibraries.BaseUserSteps;
import faa.cucumber.stepLibraries.ManageUserSteps;
//import faa.cucumber.stepLibraries.MenuUser;
import faa.models.User;
import net.thucydides.core.annotations.Steps;

public class UserRolesMap
{
    @Steps
    BaseUserSteps baseUserSteps;
    @Steps
    ManageUserSteps appManager;
//    @Steps
//    MenuUser menuUser;

    User newUser = new User();
    
    @Given("a new user is created with '(.*)' user type and user access '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void aNewUserIsCreatedWithCertainProperties(String userType, String userRole1, String userRole2, String userRole3, String userRole4, String userRole5, String userRole6, String userRole7, String userRole8) 
    {
    	baseUserSteps.goTofaaAndLogInAs("globalAdmin");
//    	menuUser.clickManageUsersFromAdministration();
 //   	appManager.clickOnManageUsersTab("add user");

    	appManager.insertIntoNewUser(newUser, userType, userRole1, userRole2, userRole3, userRole4, userRole5, userRole6, userRole7, userRole8);
    	appManager.fillOutTheAddUserFormWithNewUserInformation(newUser);
//    	menuUser.logout();
    }
    
   /* @When("")
    public void when1() 
    {

    }*/
    

}