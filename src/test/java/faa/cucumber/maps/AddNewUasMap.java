package faa.cucumber.maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import faa.cucumber.stepLibraries.AddNewUasSteps;
//import faa.cucumber.pages.LoginPage;
import faa.cucumber.stepLibraries.BaseUserSteps;
import faa.cucumber.stepLibraries.CompleteNewProfileSteps;
import faa.cucumber.stepLibraries.GmailLoginSteps;
//import faa.cucumber.stepLibraries.MenuUser;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
//make sure have correct import statements - I had to add these
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class AddNewUasMap {
	@Steps BaseUserSteps baseUserSteps;
	@Steps GmailLoginSteps gmailLoginSteps;
	@Steps AddNewUasSteps addNewUasSteps;
	@Steps CompleteNewProfileSteps completeNewProfileSteps;

	@Then("i click on the Add UAS Non-Model option")
	public void clickOnNonModelAircraftToAddNewUASButton(){
		addNewUasSteps.clickOnNonModelAircraftButton();
	}	
	@Then("i click on the Add New UAS button")
	public void clickOnAddNewUasButton(){
		addNewUasSteps.clickOnAddUasButton();
	}	
	
	@Then("Add One New UAS")
	public void clickToAddOneUas(){
		addNewUasSteps.clickToAddOneUas();
	}	
	
	@Then("click on the CheckOut Button")
	public void clickOnCheckOutButton(){
		addNewUasSteps.clickOnCheckOutButton();
	}	
	
	@Then("i click to Add Five New UAS")
	public void clickOnAddFiveUasButton(){
		addNewUasSteps.clickToAddFiveUAS();
	}	

	@Then("i click to Add Ten New UAS Do Not Pay")
	public void clickToAddTenUasDoNotPay(){
		addNewUasSteps.clickToAddTenUasDoNotPay();
	}	
	
	
	@Then("i click to add multiple UAS")
	public void clickToAddMultipleUAS(){
		addNewUasSteps.clickToAddMultipleUAS();
		//addNewUasSteps.clickOnAddUasButton();
	}	
	
	@Then("i complete payment for the hobbyist drone")
	public void completeHobbyistPayment(){
		completeNewProfileSteps.completeHobbyistPaymentProcess();
	}

	@Then("complete payment for the non hobbyist user")
	public void completeNonHobbyistPayment(){
		completeNewProfileSteps.completeNonHobbyistPaymentProcess();
	}

	
	@Then("i select a random UAS Type")
	public void selectARandomUasTypeFromDropDownList(){
		addNewUasSteps.selectARandomUasType();
	}	
	@Then("i enter a manufacturer")
	public void typeIntoManufacturerField(){
		addNewUasSteps.typeIntoManufacturerName();
		System.out.println("Confirmed a manufacturer has been entered. ");
		baseUserSteps.waitABit(1000);
	}
	@Then("i enter a serial number")
	public void typeIntoSerialNumberField(){
		addNewUasSteps.typeIntoSerialNumberField();
		System.out.println("Confirmed a serial number has been entered. ");
		baseUserSteps.waitABit(1000);
	}
	@Then("i enter a nickname")
	public void typeIntoNicknameField(){
		addNewUasSteps.typeIntoNicknameField();
		System.out.println("Confirmed a nickname has been entered. ");
		baseUserSteps.waitABit(1000);
	}	
	@Then("i enter a model number")
	public void typeIntoModelNumberField(){
		addNewUasSteps.typeIntoModelNumberField();
		System.out.println("Confirmed a model mumber has been entered. ");
		baseUserSteps.waitABit(1000);
	}	
	@Then("i click the Add button")
	public void clickOnAddSubmitButton(){
		addNewUasSteps.clickOnAddSubmitButton();
		System.out.println("Confirmed the Add Submit Button has been clicked.");
		baseUserSteps.waitABit(1000);
	}	
	
	@Then("i click on the done button")
	public void clickOnDoneButton(){
		addNewUasSteps.clickOnDoneButton();
		System.out.println("Confirmed the Done Button has been clicked.");
		baseUserSteps.waitABit(1000);
	}	
	




}