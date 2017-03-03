package faa.cucumber.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
/** @author jfranklin */
public class faaChangePrimaryEmailPage {

	/** Change Primary Email Button */
	@FindBy(xpath = "//button[@class='btn' and contains(text(), 'Change Primary Email')]") private WebElementFacade changePrimaryEmailButton;
	/** newPrimaryEmail textbox */
	@FindBy(xpath = "//input[@id='newPrimaryEmail']") private WebElementFacade newPrimaryEmailTextBox;
	/**confirmNewPrimaryEmail textbox */
	@FindBy(xpath = "//input[@id='confirmNewPrimaryEmail']") private WebElementFacade ConfirmNewPrimaryEmailTextBox;
	/**newConfirmEmailPassword textbox */
	@FindBy(xpath = "//input[@id='newConfirmEmailPassword']") private WebElementFacade newConfirmNewEmailPasswordTextBox;
	/**isConfirmEmail Checkbox */
	@FindBy(xpath = "//input[@id='isConfirmEmail']") private WebElementFacade isConfirmedEmailCheckBox;
	/** Save Button */
	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Save')]") private WebElementFacade saveButton;


}
