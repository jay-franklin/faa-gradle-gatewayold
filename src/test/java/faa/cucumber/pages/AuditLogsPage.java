package faa.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;

import faa.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AuditLogsPage extends BasePageObject {

	/**  */
	private static final String transactionTypeDropdownCssSelector = "select#transactionType";

	@FindBy(id = "E-mail") WebElementFacade emailField;
	@FindBy(id = "ipAddress") WebElementFacade ipAddress;
	@FindBy(id = "startDate") WebElementFacade startDate;
	@FindBy(id = "endDate") WebElementFacade endDate;
	@FindBy(id = "search") WebElementFacade searchButton;

	public void selectTransactionTypeByValue(String transactionTypeDropdown) {
		findWebElementByCssSelector(transactionTypeDropdownCssSelector)
				.selectByVisibleText(transactionTypeDropdown);
	}

	public void clickOnSearchButton() {
		click(searchButton);
	}

}
