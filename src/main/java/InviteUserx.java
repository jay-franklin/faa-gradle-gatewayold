/////////////////////////////
//Add User
//Calls readGmailMessage.java
/////////////////////////////
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//import faa.cucumber.pages.BasePageObject;
//import readGmailMessage.java;

//public class GmailLoginPage extends BasePageObject {
public class InviteUserx  extends  readGmailMessagex {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
		driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testInviteUser() throws Exception {
	String userName = System.getProperty("user.name");
	String userDomain = System.getenv("USERDOMAIN");
	String filePath = "C:\\Users\\" + userName + "." + userDomain + "\\Desktop\\AddUser.txt";
	String siteType = "integration";
	String baseUrl = "https://registermyuas-" + siteType + ".faa.gov/";
	   String userAccount = "mynewfaadrone+Invite105@gmail.com"; // Fill this
	   String userPassword = "Dummy$11"; // Fill this
	String invitedUserPassword = "Dummy$11"; // Fill this
	String eMailSender = "UAS.Registry@faa.gov";
	String eMailSubject = "Invitation to join the FAA sUAS Registration Site";
	//String eMailSubject = "sUAS Primary Email Change";
	String searchURL = "<a href=\"https://registermyuas-" + siteType + ".faa.gov/invitation";
	int numberOfInvitedUsers = 1;
	int acceptInvite = 0;
	int index = 0;
	while (index < numberOfInvitedUsers) {
		String firstName = "Jacksonville"; // Fill this
	    String lastName = "Franksville"; // Fill this
	    String email ="mynewfaadrone+JayAdmin@gmail.com"; // Fill this
	driver.get(baseUrl);
    driver.findElement(By.id("loginHeader")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys(userAccount);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(userPassword);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/a/div")).click();
    driver.findElement(By.id("userTab")).click();
    driver.findElement(By.cssSelector("div.icon-add")).click();
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys(firstName);
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys(lastName);
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(email);
    String userRoll = "Organization Administrator";
    new Select(driver.findElement(By.id("roleType"))).selectByVisibleText(userRoll);
    driver.findElement(By.id("submitInviteUser")).click();
	TimeUnit.SECONDS.sleep(5);
	driver.quit();
	driver = new FirefoxDriver();
	readGmailMessagex sample = new readGmailMessagex();
	sample.readGmail(email, eMailSender, eMailSubject, filePath);
	File file = new File(filePath);
	String searchCriteria = searchURL;
	final Scanner scanner = new Scanner(file);
	while (scanner.hasNextLine()) {
		final String lineFromFile = scanner.nextLine();
		if(lineFromFile.contains(searchCriteria)) { 
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(lineFromFile);
			while (m.find()) {
				String uRL = m.group(1);
				System.out.println("\r\nNew URL: " + uRL + "\r\n");
				TimeUnit.SECONDS.sleep(1);
				driver.get(uRL);
				TimeUnit.SECONDS.sleep(5);
				if ( acceptInvite == 0 ) {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/button")).click();
				driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys(invitedUserPassword);
			    driver.findElement(By.id("confirmPassword")).clear();
			    driver.findElement(By.id("confirmPassword")).sendKeys(invitedUserPassword);
				JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,600)", "");
			    driver.findElement(By.id("Accept_Invitation")).click();
			    driver.findElement(By.id("logout")).click();}
			    TimeUnit.SECONDS.sleep(5);
			    index++;
			}
			break;}}
	scanner.close();
 }
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}







