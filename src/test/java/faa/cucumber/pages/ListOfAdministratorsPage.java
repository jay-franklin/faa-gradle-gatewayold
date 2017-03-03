package faa.cucumber.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/** @author jfranklin */
public class ListOfAdministratorsPage extends BasePageObject {

	@FindBy(css = "table thead tr th input") private WebElementFacade globalSearchBox;
	@FindBy(css = "div div table tbody tr td") private List<WebElementFacade> searchResultsTable;

	public void typeInGlobalSearch(String searchInput) {
		globalSearchBox.type(searchInput);
	}

	public String getNameFromFirstResult() {
		return searchResultsTable.get(0).getText();
	}

	public String getSiteFromFirstResult() {
		return searchResultsTable.get(1).getText();
	}

	public String getEmailFromFirstResult() {
		return searchResultsTable.get(2).getText();
	}

	public String getAdminTypeFromFirstResult() {
		return searchResultsTable.get(3).getText();
	}

	public String getLastLoginFromFirstResult() {
		return searchResultsTable.get(4).getText();
	}

	public String getStatusFromFirstResult() {
		return searchResultsTable.get(5).getText();
	}

}
