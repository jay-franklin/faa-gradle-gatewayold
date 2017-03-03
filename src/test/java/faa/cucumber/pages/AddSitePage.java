package faa.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @authors jfranklin
 */
public class AddSitePage extends BasePageObject {

	@FindBy(id = "siteCode") private WebElementFacade siteCodeField;
	@FindBy(id = "siteName") private WebElementFacade siteNameField;
	@FindBy(css = "li#siteCreate a") private WebElementFacade clickAddSite;
	@FindBy(css = "li#siteEdit a") private WebElementFacade clickEidtSite;
	@FindBy(id = "dstrCode") private WebElementFacade districtCodeDropdown;
	@FindBy(id = "addr1") private WebElementFacade streetAddress1;
	@FindBy(id = "cityName") private WebElementFacade cityName;
	@FindBy(id = "stateCode") private WebElementFacade stateCode;
	@FindBy(id = "zipCode") private WebElementFacade zipCode;
	@FindBy(id = "siteFormBtn") private WebElementFacade siteFormBtn;
	@FindBy(id = "timeZone") private WebElementFacade timeZone;

	public void typeIntoSiteCodeField(String input) {
		siteCodeField.type(input);
	}

	public void selectFromDistrictCodeDropdown(String inputText) {
		districtCodeDropdown.selectByValue(inputText);
	}

	public void typeIntositeNameField(String input) {
		siteNameField.type(input);
	}

	public void typeIntostreetAddress1(String input) {
		streetAddress1.type(input);
	}

	public void typeIntocityName(String input) {
		cityName.type(input);
	}

	public void selectFromstateCode(String inputText) {
		stateCode.selectByValue(inputText);
	}

	public void typeIntozipCode(String input) {
		zipCode.type(input);
	}

	public void selectFromTimeZone(String inputText) {
		timeZone.selectByValue(inputText);
	}

	public void clicksiteFormBtn() {
		click(siteFormBtn);
	}

}
