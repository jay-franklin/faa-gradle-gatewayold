package faa.cucumber.maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import faa.cucumber.stepLibraries.BaseUserSteps;
//import faa.cucumber.stepLibraries.MenuUser;
import net.thucydides.core.annotations.Steps;

public class MapTemplate {
	@Steps BaseUserSteps baseUserSteps;
//	@Steps MenuUser menuUser;

	@Given("giventemplate")
	public void givenTemplateMethod(String someVariable) {
		baseUserSteps.goTofaaAndLogInAs("globalAdmin");

	}

	@When("whentemplate")
	public void whenTemplateMethod() {

	}

	@Then("thentemplate")
	public void thenTemplateMethod() {

	}

}