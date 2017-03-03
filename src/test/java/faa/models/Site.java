package faa.models;

public class Site 
{
	
	
	private String districtCode;
	private String code;
	private String name;
	private String address1;
	private String address2;
	private String cityName;
	private String state;
	private String zipcode;
	private String country;
	private String timezone;
	private String sharesZipcode;
	private String earlyCheckIn;
	private String phasedDisplayOfAppointments;
	private String countryDescription;
	private String addressId;
	

	
	public Site() {
		super();
		this.districtCode = "noValueSet";
		this.code = "noValueSet";
		this.name = "noValueSet";
		this.address1 = "noValueSet";
		this.address2 = "noValueSet";
		this.cityName = "noValueSet";
		this.state = "noValueSet";
		this.zipcode = "noValueSet";
		this.country = "noValueSet";
		this.timezone = "noValueSet";
		this.sharesZipcode = "noValueSet";
		this.countryDescription = "noValueSet";
		this.addressId = "noValueSet";
		this.sharesZipcode = null;
		this.earlyCheckIn = null;
		this.phasedDisplayOfAppointments = null;
	}



	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}



	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}



	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}



	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}



	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}



	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}



	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}



	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}



	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}



	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	/**
	 * @return the sharesZipcode
	 */
	public String getSharesZipcode() {
		return sharesZipcode;
	}



	/**
	 * @param sharesZipcode the sharesZipcode to set
	 */
	public void setSharesZipcode(String sharesZipcode) {
		this.sharesZipcode = sharesZipcode;
	}



	/**
	 * @return the earlyCheckIn
	 */
	public String getEarlyCheckIn() {
		return earlyCheckIn;
	}



	/**
	 * @param earlyCheckIn the earlyCheckIn to set
	 */
	public void setEarlyCheckIn(String earlyCheckIn) {
		this.earlyCheckIn = earlyCheckIn;
	}



	/**
	 * @return the phasedDisplayOfAppointments
	 */
	public String getPhasedDisplayOfAppointments() {
		return phasedDisplayOfAppointments;
	}



	/**
	 * @param phasedDisplayOfAppointments the phasedDisplayOfAppointments to set
	 */
	public void setPhasedDisplayOfAppointments(String phasedDisplayOfAppointments) {
		this.phasedDisplayOfAppointments = phasedDisplayOfAppointments;
	}



	/**
	 * @return the countryDescription
	 */
	public String getCountryDescription() {
		return countryDescription;
	}



	/**
	 * @param countryDescription the countryDescription to set
	 */
	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}



	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}



	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Site \n[\ndistrictCode=%s,\n code=%s,\n name=%s,\n address1=%s,\n address2=%s,\n cityName=%s,\n state=%s,\n zipcode=%s,\n country=%s,\n timezone=%s,\n sharesZipcode=%s,\n earlyCheckIn=%s,\n phasedDisplayOfAppointments=%s,\n countryDescription=%s,\n addressId=%s\n]",
				districtCode, code, name, address1, address2, cityName, state, zipcode, country, timezone,
				sharesZipcode, earlyCheckIn, phasedDisplayOfAppointments, countryDescription, addressId);
	}


	

	

}
