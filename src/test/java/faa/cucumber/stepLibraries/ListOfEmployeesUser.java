package faa.cucumber.stepLibraries;

import java.util.List;

import faa.cucumber.pages.ListOfEmployeesPage;
//import faa.cucumber.pages.MenuPage;
import faa.cucumber.pages.FaaHomePage;
import faa.models.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author mddamato
 *This user manages the List Of EMployees page
 */
public class ListOfEmployeesUser extends ScenarioSteps {


	private static final long serialVersionUID = 1009287685241604703L;
	
	/**
	 * Pages needed for this user
	 */

	ListOfEmployeesPage listOfEmployeesPage;
    
	/**
	 * Each Step this user can perform
	 */

    @Step
	public void searchForUserUsingField(User newUser, String searchField) {
    	
    	switch(searchField){
		case "Name":
			listOfEmployeesPage.clearEmailSearchField();
			waitABit(1000);
			listOfEmployeesPage.typeIntoNameField(newUser.getFullName());
			break;
		case "Email":
			listOfEmployeesPage.clearNameSearchField();
			waitABit(1000);
			listOfEmployeesPage.typeIntoEmailField(newUser.getEmailAddress());
			break;
		case "Admin Type":
			//need logic to convert typecode to full type name
			break;
		case "Last Login":
			//need to grab this info from another place
			break;
			default:
				break;
		}
    	waitABit(1500);
	}

//    @Step
//	public void verifyNameIsInSearchResults(String userName) {
//		List<String> allNamesFromResults = listOfEmployeesPage.getAllNamesFromResults();
//		boolean found = false;
//		for(String a : allNamesFromResults){
//			System.out.println("all names" +allNamesFromResults);
//			if(a.equalsIgnoreCase(userName)){
//				found = true;
//				break;
//			}
//		}
//		assertThat(found)
//		.overridingErrorMessage("The name "
//		+userName
//		+" was not found in the list of employees")
//		.isTrue();
//	}

    @Step
	public void selectSiteCode(String siteCode) {
    	listOfEmployeesPage.selectUscisLocationSiteDropDownList(siteCode);
    	waitABit(1000);
		
	}
}
