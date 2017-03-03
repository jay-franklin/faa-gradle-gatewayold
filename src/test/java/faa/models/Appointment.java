/**
 * 
 */
package faa.models;

import faa.utils.DataGenerator;

/** @author jfranklin */
public class Appointment {

	private String zip;
	private String country;
	private String uscisLctnCd;
	private String fieldOfficeName;
	private String typeOfService;
	private String catg;
	private String fName;
	private String mName;
	private String lName;
	private String dob;
	private String phoneNum;
	private Integer applGrpSize;
	private String email;
	private String aNum;
	private String rcptNum;
	private String apptDt;
	private String apptTm;
	private String confirmationNumber;
	private String pinNumber;
	private String appointmentType;

	public Appointment() {
		super();
		this.zip = "NoZipCodeSet";
		this.country = "US";
		this.uscisLctnCd = "NoSiteCodeSet";
		this.appointmentType = "NoAppointmentTypeSet";
		this.typeOfService = "NoTypeOfServiceSet";
		this.catg = "NoCategorySet";
		this.fName = DataGenerator.randomFirstName();
		this.mName = DataGenerator.randomMiddleName();
		this.lName = DataGenerator.randomLastName();
		this.dob = DataGenerator.randomBDay12to85();
		;
		this.phoneNum = DataGenerator.randomNumber(10);
		this.applGrpSize = DataGenerator.randomIntegerBetween(1, 3);
		this.email = this.fName + "." + this.lName + DataGenerator.randomNumber(2) + "@test.com";
		this.aNum = DataGenerator.randomNumber(9); // "NoAlienNumberLoaded";
		this.rcptNum = "RCT" + DataGenerator.randomNumber(10); // "NoReceiptNumberLoaded";
		this.apptDt = "NoDateLoaded";
		this.apptTm = "NoTimeLoaded";
		this.fieldOfficeName = "NoFieldOfficeNameSet";
		this.confirmationNumber = "NoConfirmationNumberSet";

	}

	/** @return the zipCode */
	public String getZipCode() {
		return zip;
	}

	/** @param zipCode
	 *            the zipCode to set */
	public void setZipCode(String zipCode) {
		this.zip = zipCode;
	}

	/** @return the country */
	public String getCountry() {
		return country;
	}

	/** @param country
	 *            the country to set */
	public void setCountry(String country) {
		this.country = country;
	}

	/** @return the fieldOfficeCode */
	public String getSiteCode() {
		return uscisLctnCd;
	}

	/** @param fieldOfficeCode
	 *            the fieldOfficeCode to set */
	public void setSiteCode(String fieldOfficeCode) {
		this.uscisLctnCd = fieldOfficeCode;
	}

	/** @return the fieldOfficeName */
	public String getFieldOfficeName() {
		return fieldOfficeName;
	}

	/** @param fieldOfficeName
	 *            the fieldOfficeName to set */
	public void setFieldOfficeName(String fieldOfficeName) {
		this.fieldOfficeName = fieldOfficeName;
	}

	/** @return the typeOfService */
	public String getTypeOfService() {
		return typeOfService;
	}

	/** @param typeOfService
	 *            the typeOfService to set */
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	/** @return the appointmentCategoryCode */
	public String getAppointmentCategoryCode() {
		return catg;
	}

	/** @param appointmentCategoryCode
	 *            the appointmentCategoryCode to set */
	public void setAppointmentCategoryCode(String appointmentCategoryCode) {
		this.catg = appointmentCategoryCode;
	}

	/** @return the firstName */
	public String getFirstName() {
		return fName;
	}

	/** @param firstName
	 *            the firstName to set */
	public void setFirstName(String firstName) {
		this.fName = firstName;
	}

	/** @return the middleName */
	public String getMiddleName() {
		return mName;
	}

	/** @param middleName
	 *            the middleName to set */
	public void setMiddleName(String middleName) {
		this.mName = middleName;
	}

	/** @return the lastName */
	public String getLastName() {
		return lName;
	}

	/** @param lastName
	 *            the lastName to set */
	public void setLastName(String lastName) {
		this.lName = lastName;
	}

	/** @return the dateOfBirth */
	public String getDateOfBirth() {
		return dob;
	}

	/** @param dateOfBirth
	 *            the dateOfBirth to set */
	public void setDateOfBirth(String dateOfBirth) {
		this.dob = dateOfBirth;
	}

	/** @return the telephoneNumber */
	public String getTelephoneNumber() {
		return phoneNum;
	}

	/** @param telephoneNumber
	 *            the telephoneNumber to set */
	public void setTelephoneNumber(String telephoneNumber) {
		this.phoneNum = telephoneNumber;
	}

	/** @return the emailAddress */
	public String getEmailAddress() {
		return email;
	}

	/** @param emailAddress
	 *            the emailAddress to set */
	public void setEmailAddress(String emailAddress) {
		this.email = emailAddress;
	}

	/** @return the alienNumber */
	public String getAlienNumber() {
		return aNum;
	}

	/** @param alienNumber
	 *            the alienNumber to set */
	public void setAlienNumber(String alienNumber) {
		this.aNum = alienNumber;
	}

	/** @return the receiptNumber */
	public String getReceiptNumber() {
		return rcptNum;
	}

	/** @param receiptNumber
	 *            the receiptNumber to set */
	public void setReceiptNumber(String receiptNumber) {
		this.rcptNum = receiptNumber;
	}

	/** @return the appointmentDate */
	public String getAppointmentDate() {
		return apptDt;
	}

	/** @param appointmentDate
	 *            the appointmentDate to set */
	public void setAppointmentDate(String appointmentDate) {
		this.apptDt = appointmentDate;
	}

	/** @return the appointmentTime */
	public String getAppointmentTime() {
		return apptTm;
	}

	/** @param appointmentTime
	 *            the appointmentTime to set */
	public void setAppointmentTime(String appointmentTime) {
		this.apptTm = appointmentTime;
	}

	public String getFullName() {
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	}

	/** @return the confirmationNumber */
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	/** @param confirmationNumber
	 *            the confirmationNumber to set */
	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "\nAppointment Information:\n" + "first Name: " + fName + "\n" + "middle Name: " + mName + "\n"
				+ "last Name: " + lName + "\n" + "date Of Birth: " + dob + "\n" + "telephone Number: " + phoneNum + "\n"
				+ "number Of Persons: " + applGrpSize + "\n" + "email Address: " + email + "\n" + "alien Number: "
				+ aNum + "\n" + "receipt Number: " + rcptNum + "\n" + "zip Code: " + zip + "\n" + "site Code: "
				+ uscisLctnCd + "\n" + "country: " + country + "\n" + "field Office Name: " + fieldOfficeName + "\n"
				+ "type Of Service: " + typeOfService + "\n" + "confirmation Number: " + confirmationNumber + "\n"
				+ "appointment Date: " + apptDt + "\n" + "appointment Time: " + apptTm + "\n" + "appointment Type: "
				+ appointmentType + "\n";

	}

	/** @return the pinNumber */
	public String getPinNumber() {
		return pinNumber;
	}

	/** @param pinNumber
	 *            the pinNumber to set */
	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	/** @return the applGrpSize */
	public Integer getApplGrpSize() {
		return applGrpSize;
	}

	/** @param applGrpSize
	 *            the applGrpSize to set */
	public void setApplGrpSize(Integer applGrpSize) {
		this.applGrpSize = applGrpSize;
	}

	/** @param applGrpSize
	 *            the applGrpSize to set */
	public void setApplGrpSize(String applGrpSize) {
		this.applGrpSize = Integer.parseInt(applGrpSize);
	}

}