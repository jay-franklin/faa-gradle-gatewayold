package faa.cucumber.pages;

import faa.utils.PageSourceParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ListOfEmployeesPage extends BasePageObject {

	/** @authors khossain, mddamato */

	@FindBy(id = "administration") private WebElementFacade clickTopMenuAdministrationTab;
	@FindBy(css = "table thead tr th input") private WebElementFacade globalSearchBox;
	@FindBy(css = "div div table tbody tr td") private List<WebElementFacade> searchResultsTable;
	@FindBy(id = "listofemployees") private WebElementFacade subMenulistofemployeesTab;
	@FindBy(id = "site") private WebElementFacade selectUscisLocationSiteDropDownList;
	/** All the input fields for filtering. {@value} */
	static final String searchInputFieldsCssSelector = "table.table.table-striped.table-bordered.ng-scope thead tr td input";
	/** All the results from the table. {@value} */
	static final String allSearchResultsObjects = "table.table.table-striped.table-bordered.ng-scope tbody tr td";

	public void clickTopMenuAdministrationTab() {
		click(clickTopMenuAdministrationTab);
	}

	public void subMenulistofemployeesButton() {
		click(subMenulistofemployeesTab);
	}

	public void selectUscisLocationSiteDropDownList(String inputText) {
		selectUscisLocationSiteDropDownList.selectByValue(inputText);
	}

	public void typeIntoNameField(String input) {
		findWebElementsByCssSelector(searchInputFieldsCssSelector).get(0).type(input);
	}

	public void typeIntoEmailField(String input) {
		findWebElementsByCssSelector(searchInputFieldsCssSelector).get(1).type(input);
	}

	/** return all of the names from the results
	 * 
	 * @return List<String> */
//	public List<String> getAllNamesFromResults() {
//		waitForSplashScreenToFinish();
//		PageSourceParser parser = new PageSourceParser(allSearchResultsObjects, getDriver());
//		List<String> allText = parser.getListOfTextFromAllElements();
//		Iterator<String> it = allText.iterator();
//		List<String> names = new ArrayList<String>();
//		while (it.hasNext()) {
//			names.add(it.next());
//			for (int i = 0; i < 12; i++)
//				it.next();
//		}
//		return names;
//	}

	public void clearNameSearchField() {
		findWebElementsByCssSelectorWithError(searchInputFieldsCssSelector).get(0).clear();
	}

	public void clearEmailSearchField() {
		findWebElementsByCssSelectorWithError(searchInputFieldsCssSelector).get(1).clear();
	}

}
