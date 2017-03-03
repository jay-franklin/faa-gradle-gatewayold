package faa.cucumber.pages;

//import faa.utils.PageSourceParser;
import faa.utils.PageSourceParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerSearchPage extends BasePageObject {

	/** @authors jfranklin */

	@FindBy(css = "input#firstName") private WebElementFacade firstName;
	@FindBy(css = "input#lastName") private WebElementFacade lastName;
	@FindBy(css = "input#dob") private WebElementFacade dob;
	@FindBy(css = "input#aNumber") private WebElementFacade aNumber;
	/** Match All Entered Parameters Checkbox */
	@FindBy(id = "allMatch") private WebElementFacade allMatch;
	@FindBy(id = "searchBtn") private WebElementFacade searchBtn;
	@FindBy(id = "print") private WebElementFacade print;

	/** All the input fields for filtering. {@value} */
	static final String customerSearchInputFieldsCssSelector = "table.table.table-striped.table-bordered.ng-scope thead tr th input";
	/** All the input fields for filtering. {@value} */
	static final String customerSearchResultsObjects = "#section-to-print.ng-scope table tbody";
	/** All the Customer Search Results. {@value} */
	static final String customerSearchResults = "table.table.table-striped.table-bordered tbody tr td";

	/** Customer Search Screen - Search Results */

//	public List<String> getAllFieldsFromResults() {
//		PageSourceParser parser = new PageSourceParser(customerSearchResults, getDriver());
//		List<String> allText = parser.getListOfTextFromAllElements();
//		Iterator<String> it = allText.iterator();
//		List<String> names = new ArrayList<String>();
//		while (it.hasNext()) {
//			names.add(it.next());
//			for (int i = 0; i < 12; i++)
//				it.next();
//		}
//		System.out.println("All names" + names);
//		return names;
//	}

	public void typeIntoFirstName(String firstName2) {
		firstName.type(firstName2);
	}

	public void clickOnSearchButton() {
		click(searchBtn);
	}

	public void typeIntoLastName(String lastName2) {
		lastName.type(lastName2);
	}

	public void typeIntoDateOfBirth(String dateOfBirth) {
		dob.type(dateOfBirth);
	}

	public void typeIntoAlienNumberField(String alienNumber) {
		aNumber.type(alienNumber);
	}

	public void clickOnMatchAllCheckBox() {
		click(allMatch);
	}

//	public List<String> getInfoFromSearchResults() {
//		PageSourceParser parser = new PageSourceParser(customerSearchResults, getDriver());
//		List<String> allText = parser.getListOfTextFromAllElements();
//		List<String> infoToSend = new ArrayList<String>();
//
//		Iterator<String> it = allText.iterator();
//		while (it.hasNext()) {
//			for (int i = 0; i < 4; i++)
//				it.next();
//			infoToSend.add(it.next());
//			infoToSend.add(it.next());
//			for (int i = 0; i < 4; i++)
//				it.next();
//			infoToSend.add(it.next());
//			for (int i = 0; i < 3; i++)
//				it.next();
//		}
//		return infoToSend;
//
//	}

}
