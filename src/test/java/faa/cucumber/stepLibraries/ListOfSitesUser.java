package faa.cucumber.stepLibraries;

//import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import faa.cucumber.pages.ListOfSitesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ListOfSitesUser extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListOfSitesPage listOfSitesPage;

	@Step
	public void enterRegion(String region) {
		listOfSitesPage.enterRegion(region);
	}

//	@Step
//	public void seeInternationalSites(String region) {
//		List<String> allRegionFromResults = listOfSitesPage.getAllRegionFromResults();
//		boolean found = false;
//		for (String a : allRegionFromResults) {
//			if (a.equalsIgnoreCase(region)) {
//				found = true;
//
//			}
//		}
//		assertThat(found).overridingErrorMessage("Not all of the filter results were" + region).isTrue();
//	}

	@Step
	public void enterSiteCode(String siteCode) {
		listOfSitesPage.clearRegionField();
		listOfSitesPage.enterSiteCode(siteCode);
	}

//	@Step
//	public void seeOnlyBkk(String siteCode) {
//		List<String> allSiteFromResults = listOfSitesPage.getAllSiteFromResults();
//		boolean found = false;
//		for (String a : allSiteFromResults) {
//			if (a.equalsIgnoreCase(siteCode)) {
//				found = true;
//			}
//		}
//		assertThat(found).overridingErrorMessage("Not all of the filter results were" + siteCode).isTrue();
//	}

	@Step
	public void enterStateCode(String stateCode) {
		listOfSitesPage.clearSiteCodeField();
		listOfSitesPage.enterStateCode(stateCode);
	}

//	@Step
//	public void seeOnlySitesInVA() {
//		List<String> locationCodesFromPage = listOfSitesPage.getAllSiteFromResults();
//		String[] sites = new String[] { "AAA", "AAE", "CHB", "CHK", "CHW", "COY", "CSC", "DCT", "EAJ", "EAU", "EAX",
//				"EAZ", "HOI", "HOI" };
//		List<String> expectedSiteCodes = new ArrayList<String>(Arrays.asList(sites));
//		boolean match = false;
//		for (String expectedSite : expectedSiteCodes) {
//			for (String siteFromPage : locationCodesFromPage) {
//				if (siteFromPage.equalsIgnoreCase(expectedSite)) {
//					match = true;
//					break;
//				}
//
//			}
//			assertThat(match).overridingErrorMessage("Not all the matched were found" + expectedSite + " was missing")
//					.isTrue();
//			match = false;
//		}
//
//	}

}
