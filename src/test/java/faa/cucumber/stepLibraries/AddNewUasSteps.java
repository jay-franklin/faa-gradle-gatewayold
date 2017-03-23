package faa.cucumber.stepLibraries;

import java.util.Properties;

import faa.cucumber.pages.AddNewUasPage;
import faa.cucumber.pages.CreateNewProfilePage;
import faa.cucumber.pages.NewAccountPage;
import faa.utils.DataGenerator;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class AddNewUasSteps {

	//AddNewUasPage addNewUasPage;
	CreateNewProfilePage createNewProfilePage;
	AddNewUasPage addNewUasPage;
	
	public static Properties serenityProperties;
	
	///////////String physicalCountry = "United States";
	//Physical Address values
	String[] physicalAddress  = DataGenerator.randomAddress();
	String physicalCountry = physicalAddress[0];
	String physicalNewAddress1 = physicalAddress[1];
	String physicalNewAddress2 = physicalAddress[2];
    String physicalNewCity = physicalAddress[3];
    String PhysicalNewState = physicalAddress[4];
    String PhysicalNewZip = physicalAddress[5];
    //Mailing Address values
	String[] mailingAddress  = DataGenerator.randomAddress();
	String mailinglNewCountry = mailingAddress[0];
	String mailinglNewAddress1 = mailingAddress[1];
	String mailinglNewAddress2 = mailingAddress[2];
	String mailingNewCity = mailingAddress[3];
    String mailingNewState = mailingAddress[4];
    String mailingNewZip = mailingAddress[5];

    
//    String newFaaAcountEmail = Serenity.sessionVariableCalled("newFaaAccount").toString();
//    System.out.println("On Verify new FAA Drone Email Account part of test  " + newFaaAcountEmail);
	@Step 
	public void clickOnNonModelAircraftButton(){
		addNewUasPage.clickOnNonModelAircraftButton();
	}
	@Step 
	public void clickOnAddUasButton(){
		addNewUasPage.clickOnAddUasButton();
	}
	
	@Step
	public void clickToAddOneUas(){
		addNewUasPage.clickToAddOneUas();
	}
	
	@Step 
	public void clickToAddMultipleUAS(){
		addNewUasPage.clickToAddMultipleUAS();
	}
	@Step
	public void clickToAddFiveUAS(){
		addNewUasPage.clickToAddFiveUAS();
	}

	//clickToAddTenUasDoNotPay
	@Step
	public void clickToAddTenUasDoNotPay(){
		addNewUasPage.clickToAddTenUasDoNotPay();
	}
	
	
	@Step 
	public void selectARandomUasType(){
		addNewUasPage.selectARandomUasType();
	}
	@Step
	public void typeIntoManufacturerName(){
		addNewUasPage.typeIntoManufacturerNameField();
	}
	@Step
	public void typeIntoSerialNumberField() {
		addNewUasPage.typeIntoSerialNumberField();
	}
	@Step
	public void typeIntoNicknameField() {
		addNewUasPage.typeIntoNicknameField();
	}
	@Step
	public void typeIntoModelNumberField() {
		addNewUasPage.typeIntoModelNumberField();
	}
	@Step
	public void clickOnAddSubmitButton() {
		addNewUasPage.clickAddSubmitButton();
	}
	@Step
	public void clickOnDoneButton() {
		addNewUasPage.clickOnDoneButton();
	}
	
	@Step
	public void clickOnCheckOutButton(){
		addNewUasPage.clickOnCheckOutButton();
	}
	
	@Step
	public void typeIntoCreateProfileFirstName(){
		
		createNewProfilePage.typeIntoCreateProfileFirstName();
		System.out.println("Profile First Name is " + createNewProfilePage.getTypeIntoCreateProfileFirstName());
	}
	@Step
	public void typeIntoCreateProfileMiddleInitial(){
		createNewProfilePage.typeIntoCreateProfileMiddleInitial();
		System.out.println("Profile Middle Intial is " + createNewProfilePage.getTypeIntoCreateProfileMiddleInitial());
	}
	@Step
	public void typeIntoCreateProfileLastName(){
		createNewProfilePage.typeIntoCreateProfileLastName();
		System.out.println("Profile Last Name is " + createNewProfilePage.getTypeIntoCreateProfileLastName());
	}
	@Step
	public void typeIntoCreateProfileNameSuffix(){
		createNewProfilePage.typeIntoCreateProfileNameSuffix();
		System.out.println("Profile Suffix Name is " + createNewProfilePage.getCreateProfileNameSuffix());
	}
	@Step
	public void typeIntoCreateProfileTitle(){
		createNewProfilePage.typeIntoCreateProfileTitle();
		System.out.println("Profile Title is " + createNewProfilePage.getCreateProfileNameTitle());
	}
	@Step
	public void typeIntoCreateProfileAltEmail(){
		createNewProfilePage.typeIntoCreateProfileAlternateEmail();
		System.out.println("Profile Alternate Email Address is: " + createNewProfilePage.getCreateProfileAlternateEmail());
	}
	@Step
	public void typeIntoCreateProfilePhone(){
		createNewProfilePage.typeIntoCreateProfilePhone();
//		System.out.println("Profile Phone Number is: " + createNewProfilePage.getCreateProfilePhone());
	}
	@Step
	public void typeIntoCreateProfilePhoneExt(){
		createNewProfilePage.typeIntoCreateProfilePhoneExt();
//		System.out.println("Profile Phone Number Extension is: " + createNewProfilePage.getCreateProfilePhoneExt());
	}
	@Step
	public void typeIntoCreateProfileOrganization(){
		createNewProfilePage.typeIntoCreateProfileOrganizationName();
		System.out.println("Profile Organization Name is: " + createNewProfilePage.getCreateProfileOrganizationName());
	}
	@Step
	public void typeIntoCreateProfileDba(){
		createNewProfilePage.typeIntoCreateProfileDba();
		System.out.println("Profile DBA Name is: " + createNewProfilePage.getCreateProfileDba());
	}
	@Step
	public void selectProfilePhysicalCountryDropDownList(){
		//Serenity.setSessionVariable("United States").to(country);
		createNewProfilePage.selectProfilePhysicalCountryDropDown("United States");
		System.out.println("Physical Country Name is: " + createNewProfilePage.getCreateProfilePhysicalCountry()); 
	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress1(){
	    Serenity.setSessionVariable("address1").to(physicalNewAddress1);
	    String newAddress1 = Serenity.sessionVariableCalled("address1").toString();
        System.out.println("On Verify new Address1 is--->  " + newAddress1);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(newAddress1);
		System.out.println("PhysicalAddress 1 is: " + createNewProfilePage.getCreateProfilePhysicalAddress1());
		System.out.println("Physical Address1 from array is: " + physicalAddress[0]);

	}
	@Step
	public void typeIntoCreateProfilePhysicalAddress2(){
	    Serenity.setSessionVariable("address2").to(physicalNewAddress2);
	    String newAddress2 = Serenity.sessionVariableCalled("address2").toString();
        System.out.println("On Verify new Address2 is--->  " + newAddress2);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress2(newAddress2);
		System.out.println("Physical Address2 is: " + newAddress2);
	}
	@Step
	public void typeIntoCreateProfileCity(){
	    Serenity.setSessionVariable("city1").to(physicalNewCity);
	    String newCity1 = Serenity.sessionVariableCalled("city1").toString();
        System.out.println("On Verify new City is--->  " + newCity1);
		createNewProfilePage.typeIntoCreateProfilePhysicalCity(newCity1);
		System.out.println("Physical City is: " + createNewProfilePage.getCreateProfilePhysicalCity());
		System.out.println("Physical City from array is: " + physicalAddress[1]);
		
	}
	@Step
	public void selectProfilePhysicalStateDropList(){
		//createNewProfilePage.selectCreateProfilePhysicalState();
	    Serenity.setSessionVariable("state1").to(PhysicalNewState);
	    String newState1 = Serenity.sessionVariableCalled("state1").toString();
		createNewProfilePage.selectFromPhysicalStateNameDropdownList(newState1);
        System.out.println("On Verify new State is--->  " + newState1);
		System.out.println("Physical State Name from array is: " + physicalAddress[2]);
        System.out.println("On Verify new State is--->  " + newState1);
	}
	@Step
	public void typeIntoCreateProfileZipCode(){
	    Serenity.setSessionVariable("zip1").to(PhysicalNewZip);
	    String newZip1 = Serenity.sessionVariableCalled("zip1").toString();
        System.out.println("On Verify new Zip is--->  " + newZip1);
		createNewProfilePage.typeIntoCreateProfilePhysicalZip(newZip1);
		System.out.println("Physical Zip Code from array is: " + physicalAddress[3]);
	}
	
	@Step
	public void selectProfileMailingCountryFromDropList(){
		//Serenity.setSessionVariable("United States").to(country);
		createNewProfilePage.selectProfileMailingCountryDropDown("United States");
		System.out.println("Mailing Country Name is: " + createNewProfilePage.getCreateProfileMailingCountry());

	}
	@Step
	public void typeIntoCreateProfileMailingAddress1(){
		//mailinglNewAddress1
	    Serenity.setSessionVariable("mailingAddress1").to(mailinglNewAddress1);
	    String newMailingAddress1 = Serenity.sessionVariableCalled("mailingAddress1").toString();
        System.out.println("On Verify new mailing Address1 is--->  " + newMailingAddress1);
		createNewProfilePage.typeIntoCreateProfileMailingAddress1(newMailingAddress1);
		System.out.println("Mailing Address 1 is: " + createNewProfilePage.getCreateProfileMailingAddress1());
	}
	@Step
	public void typeIntoCreateProfileMailingAddress2(){
	    Serenity.setSessionVariable("mailingAddress2").to(mailinglNewAddress2);
	    String newMailingAddress2 = Serenity.sessionVariableCalled("mailingAddress2").toString();
        System.out.println("On Verify new mailing Address2 is--->  " + newMailingAddress2);
		createNewProfilePage.typeIntoCreateProfileMailingAddress2(newMailingAddress2);
		System.out.println("Mailing Address2 is: " + createNewProfilePage.getCreateProfileMailingAddress2());
	}
	@Step
	public void typeIntoCreateProfileMailingCity(){
	    Serenity.setSessionVariable("mailingCity1").to(mailingNewCity);
	    String newMailingCity1 = Serenity.sessionVariableCalled("mailingCity1").toString();
        System.out.println("On Verify new City is--->  " + newMailingCity1);
		createNewProfilePage.typeIntoCreateProfileMailingCity(newMailingCity1);
		System.out.println("Mailing City is: " + createNewProfilePage.getCreateProfileMailingCity());
	}
	
	@Step
	public void selectProfileMailingStateDropList(){
	    Serenity.setSessionVariable("mailingState1").to(mailingNewState);
	    String newMailingState1 = Serenity.sessionVariableCalled("mailingState1").toString();
        System.out.println("On Verify new State is--->  " + mailingNewState);
		createNewProfilePage.selectFromMailingStateNameDropdownList(newMailingState1);
		//System.out.println("Physical State Name is: " + createNewProfilePage.getCreateProfilePhysicalState());
		System.out.println("Physical State Name from array is: " + newMailingState1);
	}

	
	@Step
	public void typeIntoCreateProfileMailingZipCode(){
//	    mailingNewZip
	    Serenity.setSessionVariable("mailingZip1").to(mailingNewZip);
	    String newMailingZip1 = Serenity.sessionVariableCalled("mailingZip1").toString();
        System.out.println("On Verify new mailing Zip is--->  " + newMailingZip1);
		createNewProfilePage.typeIntoCreateProfileMailingZip(newMailingZip1);
		//System.out.println("Mailing Zip Code is: " + createNewProfilePage.getCreateProfileMailingZip());
		System.out.println("Mailing Zip Code array is: " + newMailingZip1);
		
	}
	
	@Step
	public void clickOnSaveButtonCssSelectorButton(){
		createNewProfilePage.clickOnSaveButtonCssSelectorButton();
	}
	
	@Step
	public void clickOnSendEmailCertificatePrimaryButton() {
		addNewUasPage.clickOnEmailPrimaryCertificateButton();
	}
	@Step
	public void clickOnSendEmailCertificateAlternateButton() {
		addNewUasPage.clickOnEmailAlternateCertificateButton();
	}

		
	
}
