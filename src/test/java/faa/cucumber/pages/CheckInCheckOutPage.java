package faa.cucumber.pages;

//import static org.assertj.core.api.StrictAssertions.assertThat;

import faa.utils.PageSourceParser;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfranklin
 */
public class CheckInCheckOutPage extends BasePageObject {

	@FindBy(id = "cnfrmtnNum")
	protected WebElementFacade confirmationNumberField;
	@FindBy(id = "search")
	protected WebElementFacade searchButton;
	@FindBy(css = "#pageBody div div div div h2.ng-scope")
	protected WebElementFacade next2Button;
	@FindBy(id = "dailyRosterModal")
	protected WebElementFacade dailyRosterModalButton;
	/**<p>Description of element {@value}*/
	static final String globalSearch2CssSelector = "table.table.table-striped.table-bordered thead tr th input";
	/**<p>the message that appears at the top of the page, can be ERROR, SUCCESS, or INFO {@value}*/
	static final String statusMessageCssSelector = "div>span>strong";
	/**<p>Check-in and check-out button that appears after searching/clicking a confirmation number {@value}*/
	static final String checkInAndOutButtonCssSelector = "button#confirm";
	/**<p>all Confirmation Numbers From Checkout Roster {@value}*/
	static final String allConfirmationNumbersFromModalPanelCssSelector = "table.table.table-striped.table-bordered tbody tr td a";
	/**<p>check out roster button {@value}*/
	static final String dailyCheckoutRosterButtonCssSelector = "button#dailyCheckoutRoster";
	/**<p>roster modal title {@value}*/
	static final String rosterModalTitleCssSelector = "div.modal-content div h3.modal-title";
	/**<p>button to open check in roster {@value}*/
	static final String checkInRosterButtonCssSelector = "button#dailyCheckinRoster";
	/**<p>OK button to close roster modal panel {@value}*/
	static final String okButtonInRosterModalPanelCssSelector = "button#dailyRosterModal";
	
	public void clickWebElementName2(){
		click(findWebElementByCssSelector(globalSearch2CssSelector));
	}
	
	public void typeIntoConfirmationNumberField(String inputText) {
		confirmationNumberField.type(inputText);
	}

	public void clickSearchButton() {
		click(searchButton);
	}

	public String getStatusMessage() {
		waitForSplashScreenToFinish();
		return findWebElementByCssSelector(statusMessageCssSelector).getText();
	}

	/**this is the button that appears after searching or selecting from check in roster*/
	public void clickCheckInOrOut() {
		click(findWebElementByCssSelector(checkInAndOutButtonCssSelector));
	}

	public void clickCheckOutRoster() {
		waitABit(1000);
		click(findWebElementByCssSelector(dailyCheckoutRosterButtonCssSelector));
	}
	
	public void clickCheckInRoster() {
		click(findWebElementByCssSelector(checkInRosterButtonCssSelector));
	}

//	public List<String> getAllConfirmationNumbersFromCheckOutList() {
//		PageSourceParser parser = new PageSourceParser(allConfirmationNumbersFromModalPanelCssSelector, getDriver());
//		return parser.getListOfTextFromAllElements();
//	}
	

	/**click on the confirmation number that matches the one sent, assert it was found*/
	public void clickConfirmationNumber(String confirmationNumber) {
		List<WebElementFacade> allConfNumbers = findWebElementsByCssSelector(allConfirmationNumbersFromModalPanelCssSelector);
		boolean found = false;
		for(WebElementFacade a: allConfNumbers){
			if(a.getText().equalsIgnoreCase(confirmationNumber)){
				waitABit(1000);
				click(a);
				found = true;
				break;
			}
		}
		assertThat(found)
		.overridingErrorMessage("The confirmation number: "
		+confirmationNumber
		+" was not found in the list")
		.isTrue();
		
	
	}

	public void clickOkInRosterModalPanel() {
		waitABit(1000);
		click(findWebElementByCssSelector(okButtonInRosterModalPanelCssSelector));
	}


}