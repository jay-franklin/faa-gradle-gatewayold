/**
 * 
 */
package faa.models;


//import faa.cucumber.pages.FaaHomePage;
import faa.utils.DataGenerator;
import net.serenitybdd.core.Serenity;
import faa.cucumber.pages.FaaHomePage;
import faa.models.InviteUser;
/**
 * @author jfranklin
 *
 */
public class InviteUser {

	private String inviteFirstName;
	private String inviteLastName;
	private String inviteEmail;
	private String inviteRoleCode;

	FaaHomePage faaHomePage;

	public InviteUser() {
		super();
		this.inviteFirstName = DataGenerator.randomFirstName();
		this.inviteLastName = DataGenerator.randomLastName();
		String newInvitedEmailAccount = "mynewfaadrone+Invite" + DataGenerator.randomIntegerBetween(20,10000) + "@gmail.com";
		Serenity.setSessionVariable("newInvitedEmailAccount").to(newInvitedEmailAccount);
		System.out.println("Random Invited Email Address-->" + newInvitedEmailAccount);
		this.inviteEmail = newInvitedEmailAccount;
		//this.inviteRoleCode =  inviteRoleCode; //   faaHomePage.selectModelARoleTypeCodeRandomly();  
		//selectARoleTypeCodeRandomly
		this.inviteRoleCode = DataGenerator.randomRoleType();
	}

	
	/**
	 * @return the firstName
	 */
	public String getInviteFirstName() {
		return inviteFirstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setInviteFirstName(String firstName) {
		this.inviteFirstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getInviteLastName() {
		return inviteLastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setInviteLastName(String lastName) {
		this.inviteLastName = lastName;
	}

	
	/**
	 * @return the emailAddress
	 */
	public String getInviteEmailAddress() {
		return inviteEmail;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setInviteEmail(String emailAddress) {
		this.inviteEmail = emailAddress;
	}
	/**
	 * @return the emailAddress
	 */
	public String getInviteEmail() {
		return inviteEmail;
	}
	
	/**
	 * @param inviteRoleCode the inviteRoleCode to set
	 */
	public void setInviteRoleTypeCode(String inviteRoleCode) {
		this.inviteRoleCode = inviteRoleCode;
	}
	/**
	 * @return the userType
	 */
	public String getInviteRoleTypeCode() {
		return inviteRoleCode;
	}


	

	/**
	 * set all access to false
	 */
//	public void resetAllUserAccess() {
//		this.checkInOut = false;
//		this.glblreport = false;
//		this.multipleappt = false;
//		this.overbook = false;
//		this.report = false;
//		this.schedule = false;
//		
//	}

//	public String getFullName() {
//		return this.getFirstName()+" "+this.getMiddleName()+" "+this.getLastName();
//	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String returnString = "";
		returnString ="User information: "
				+ "\nFirst Name = "+ inviteFirstName
				+ "\nLast Name = " + inviteLastName
				+ "\nEmail Address = " + inviteEmail 
				+ "\nRole Type Code = "+ inviteRoleCode;
		return returnString;
	}




//	inviteFirstName
//	inviteLastName
//	inviteEmail
//	inviteRoleCode


//	/**
//	 * @return the userTypeCode
//	 */
//	public String getUserTypeCode() {
//		return userTypeCode;
//	}
//
//



}