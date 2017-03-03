package faa.cucumber.pages;

import faa.utils.PageSourceParser;

import java.util.Iterator;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/** @author mddamato */
public class ListOfServiceEmployeesPage extends BasePageObject {

	@FindBy(css = "") private List<WebElementFacade> list;
	@FindBy(id = "site") private WebElementFacade siteCodeDropdown;
	@FindBy(css = "tfoot tr td div nav ul.pagination li a") private List<WebElementFacade> pageNumbers;
	@FindBy(css = "table.table.table-striped.table-bordered tbody tr td.ng-binding") private List<WebElementFacade> tableResults;
	@FindBy(css = "tfoot tr td div nav ul.pagination li") private List<WebElementFacade> pageNumberButtons;

	public int getNumberOfResultPages() {
		return pageNumbers.size();
	}

	/** returns true if successful
	 * 
	 * @return - bool - true if next page exists, false otherwise */
	public boolean clickNextPageCheck() {
		List<WebElementFacade> allPageButtons = pageNumberButtons;
		Iterator<WebElementFacade> it = allPageButtons.iterator();
		WebElementFacade activeButton = null;
		int currentPageNum = 1;
		while (it.hasNext()) {
			activeButton = it.next();
			if (activeButton.getAttribute("class").contains("ng-scope active")) {
				break;
			}
			currentPageNum++;
		}

		if (allPageButtons.size() == currentPageNum) {
			return false;
		}

		click(allPageButtons.get(currentPageNum));
		return true;
	}

	/** clicks the next page if possible, otherwise nothing */
	public void clickNextPage() {
		List<WebElementFacade> allPageButtons = pageNumberButtons;
		Iterator<WebElementFacade> it = allPageButtons.iterator();
		WebElementFacade activeButton = null;
		int currentPageNum = 1;
		while (it.hasNext()) {
			activeButton = it.next();
			if (activeButton.getAttribute("class").contains("ng-scope active")) {
				break;
			}
			currentPageNum++;
		}
		if (allPageButtons.size() == currentPageNum) {
		} else {
			click(allPageButtons.get(currentPageNum));
		}
	}

//	public boolean userExistsInList(String Name) {
//		boolean found = false;
//		boolean hasAnotherSearchPage = true;
//		while (hasAnotherSearchPage) {
//			PageSourceParser parser = new PageSourceParser(
//					"table.table.table-striped.table-bordered tbody tr td.ng-binding", getDriver());
//			found = parser.listContainsText(Name);
//			if (found) {
//				break;
//			}
//			hasAnotherSearchPage = clickNextPageCheck();
//		}
//		return found;
//	}

}
