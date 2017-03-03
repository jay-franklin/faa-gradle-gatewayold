package faa.cucumber.stepLibraries;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.StrictAssertions.assertThat;


//import faa.cucumber.pages.MenuPage;
import faa.cucumber.pages.FaaHomePage;

/**
 * @author jfranklin
 *Welcome screen User.
 */
public class WelcomeScreenUser extends ScenarioSteps {


	private static final long serialVersionUID = 1009287685241604703L;
	
	/**
	 * Pages needed for this user
	 */
	FaaHomePage faaHomePage;
//	MenuPage menuPage;
    
	/**
	 * Each Step this user can perform
	 */
    @Step
    public void userAction1() {

    	faaHomePage.open();
    }
    
    @Step
    public void verifyWelcomeBannerShouldBeVisible() {
    		elementLocatedByCss("div.alert.ng-isolate-scope.alert-success div span.ng-binding.ng-scope")
    				.shouldContainText("Welcome to the Small Unmanned Aircraft System");
    	}

	private PageObject elementLocatedByCss(String string) {
		// TODO Auto-generated method stub
		return null;
	}

//    	public void verifyFirstNameEquals(String string) {
//    		String firstName = firstNameField.getValue();
//    		assertThat(firstName).containsIgnoringCase(string);
//    	}
//
    
  //  }
}
