package faa.cucumber.stepLibraries;

import java.util.Iterator;
import java.util.List;

import faa.cucumber.pages.CustomerSearchPage;
import faa.cucumber.pages.FaaHomePage;
//import faa.cucumber.pages.MenuPage;
import faa.models.Appointment;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.StrictAssertions.assertThat;


/**
 * @author authorName
 *Description of this User.
 */
public class CustomerSearchSteps extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3709744635638309995L;
	/**
	 * Pages needed for this user
	 */
	FaaHomePage faaHomePage;
//	MenuPage menuPage;
	CustomerSearchPage customerSearchPage;

	/**
	 * Each Step this user can perform
	 */
	@Step
	public void userAction1() {

		faaHomePage.open();
	}

	@Step
	public void userAction2(String stringInput) {

	}
	@Step
	public void typeIntoAppointmentFirstNameField(Appointment appointmentModel) {
		customerSearchPage.typeIntoFirstName(appointmentModel.getFirstName());
	}


	@Step
	public void clickSearchButton() {
		customerSearchPage.clickOnSearchButton();

	}

	public void typeIntoAppointmentLastName(Appointment appointmentModel) {
		customerSearchPage.typeIntoLastName(appointmentModel.getLastName()); 

	}

	public void typeIntoAppointmentDateOfBirth(Appointment appointmentModel) {
		customerSearchPage.typeIntoDateOfBirth(appointmentModel.getDateOfBirth()); 

	}

	public void typeIntoAlienNumberField(Appointment appointmentModel) {
		customerSearchPage.typeIntoAlienNumberField(appointmentModel.getAlienNumber());


	}

	public void checkAllMatchParameter() {
		customerSearchPage.clickOnMatchAllCheckBox();
	}


//	@Step
//	public void verifyCustomerSearchResultsMatch(Appointment appointmentModel) {
//		waitABit(1000);
//		String expectedLastName = appointmentModel.getLastName();
//		String expectedFirstName = appointmentModel.getFirstName();
//		String expectedConfirmationNumber = appointmentModel.getConfirmationNumber();
//
//		List<String> infoFromPage = customerSearchPage.getInfoFromSearchResults();
//
//		boolean foundLastName = false;
//		boolean foundFirstName = false;
//		boolean foundConf = false;
//
//		Iterator<String> it = infoFromPage.iterator();
//		while(it.hasNext()){
//			if(it.next().equalsIgnoreCase(expectedLastName)){
//				foundLastName=true;
//			}
//			if(it.next().equalsIgnoreCase(expectedFirstName)){
//				foundFirstName=true;
//			}
//			if(it.next().equalsIgnoreCase(expectedConfirmationNumber)){
//				foundConf=true;
//			}
//
//			if(foundLastName && foundFirstName && foundConf)
//				break;
//			else{
//				foundLastName = false;
//				foundFirstName = false;
//				foundConf = false;
//			}
//		}
//		
//		assertThat(foundLastName)
//		.overridingErrorMessage("The last name was not found: "+expectedLastName)
//		.isTrue();
//		
//		assertThat(foundFirstName)
//		.overridingErrorMessage("The first Name was not found: "+expectedFirstName)
//		.isTrue();
//		
//		assertThat(foundConf)
//		.overridingErrorMessage("The confirmation number was not found: "+expectedConfirmationNumber)
//		.isTrue();
//	}

}
