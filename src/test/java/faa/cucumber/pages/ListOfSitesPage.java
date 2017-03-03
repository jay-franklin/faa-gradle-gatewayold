package faa.cucumber.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import faa.utils.PageSourceParser;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ListOfSitesPage extends BasePageObject {

	/** {@value} */
	private static final String searchFieldCssSelector = "thead tr td input.input-sm.form-control";
	/** {@value} */
	private static final String allRegionFromSearchCssSelector = "table.table.table-striped.table-bordered tbody tr td";

	public void enterRegion(String region) {

		waitABit(1000);
		findWebElementsByCssSelector(searchFieldCssSelector).get(0).type(region);

	}

	public void enterSiteCode(String siteCode) {
		waitABit(1000);
		findWebElementsByCssSelector(searchFieldCssSelector).get(3).type(siteCode);

	}

	public void enterStateCode(String stateCode) {
		waitABit(1000);
		findWebElementsByCssSelector(searchFieldCssSelector).get(7).type(stateCode);
	}

	public void clearRegionField() {
		waitABit(500);
		findWebElementsByCssSelectorWithError(searchFieldCssSelector).get(0).clear();

	}

	public void clearSiteCodeField() {
		waitABit(500);
		findWebElementsByCssSelectorWithError(searchFieldCssSelector).get(3).clear();

	}

//	public List<String> getAllRegionFromResults() {
//		waitABit(1500);
//		PageSourceParser parser = new PageSourceParser(allRegionFromSearchCssSelector, getDriver());
//		List<String> allText = parser.getListOfTextFromAllElements();
//		Iterator<String> it = allText.iterator();
//		List<String> names = new ArrayList<String>();
//		while (it.hasNext()) {
//			names.add(it.next());
//			for (int i = 0; i < 11; i++)
//				it.next();
//		}
//		return names;
//	}

//	public List<String> getAllSiteFromResults() {
//		waitABit(1500);
//		PageSourceParser parser = new PageSourceParser(allRegionFromSearchCssSelector, getDriver());
//		List<String> allText = parser.getListOfTextFromAllElements();
//		Iterator<String> it = allText.iterator();
//		List<String> site = new ArrayList<String>();
//		while (it.hasNext()) {
//			it.next();
//			it.next();
//			it.next();
//			site.add(it.next());
//			for (int i = 0; i < 8; i++)
//				it.next();
//		}
//		return site;
//	}

}
