import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.util.Random;
public class ChangePrimaryEmail {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		ProfilesIni profileObj = new ProfilesIni();
		FirefoxProfile myFFProfile = profileObj.getProfile("default");
		driver = new FirefoxDriver(myFFProfile);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void testChangePrimaryEmail() throws Exception {
		String siteType = "integration";
		String baseUrl = "https://registermyuas-" + siteType + ".faa.gov/";
		String userName = System.getProperty("user.name");
//		String userDomain = System.getenv("USERDOMAIN");
		String outputFile = "C:\\Users\\" + userName + "\\Desktop\\ChangePrimaryEmail.txt";
		String eMailFrom = "UAS.Registry@faa.gov";
		String eMailSubject = "sUAS Primary Email Change";
		String originalEmail =  "mynewfaadrone+nh1100@gmail.com";  
		Random rand = new Random();
		int randNumber = rand.nextInt(10000);
		
		//DataGenerator.getActiveNonHobbyistCpeUserFromIntegrationDB(); // Original Email
		String newEmail = "mynewfaadrone+CPE" + randNumber +  "@gmail.com"; // New Email
		String passWord = "Dummy$11";
		String s = originalEmail;
		    char[] array = s.toCharArray();
		    for(int i = 0; i < array.length; i++){
		        if(array[i] == '@'){
		            System.out.println(i);
		            System.out.println("EMail -->" + originalEmail.substring(0,i) + "+CPE"+ randNumber + "@Gmail.com" );
		        }   
		    }
		
		driver.get(baseUrl);
		driver.findElement(By.id("loginHeader")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(originalEmail); // Login Email
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(passWord); // Login Password
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a/div")).click(); // Hobbyist Account
		TimeUnit.SECONDS.sleep(1);
		int index = 0;
		while (index < 2) {
			driver.findElement(By.id("changePrimaryEmailBtnNotRegistered")).click();
			driver.findElement(By.id("newPrimaryEmail")).clear();
			driver.findElement(By.id("newPrimaryEmail")).sendKeys(newEmail); // Enter New Email
			driver.findElement(By.id("confirmNewPrimaryEmail")).clear();
			driver.findElement(By.id("confirmNewPrimaryEmail")).sendKeys(newEmail); // Re-Enter New Email
			driver.findElement(By.id("newConfirmEmailPassword")).clear();
			driver.findElement(By.id("newConfirmEmailPassword")).sendKeys(passWord); // Enter Login Password
			driver.findElement(By.id("isConfirmEmail")).click(); // Click Confirm Check-Box
			driver.findElement(By.id("submitPrimaryEmailChange")).click(); // Click Submit Button
			String validationNumber = "";
			TimeUnit.SECONDS.sleep(1); // Wait for mail
			while (validationNumber == ""){
				readGmailMessage sample = new readGmailMessage();
				sample.readGmail(newEmail, eMailFrom, eMailSubject, outputFile);
				File file = new File(outputFile);
				String searchCriteria = "<p> ";
				final Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					final String lineFromFile = scanner.nextLine();
					if(lineFromFile.contains(searchCriteria)) { 
						System.out.println(lineFromFile);
						validationNumber = lineFromFile.substring(0, lineFromFile.length()-4).substring(3).trim();
						System.out.println(validationNumber);
						break;}}
				scanner.close();
			}
			driver.findElement(By.id("verificationCode")).clear();
			driver.findElement(By.id("verificationCode")).sendKeys(validationNumber);
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.id("submitVerificationCode")).click();
			TimeUnit.SECONDS.sleep(1);
			index++;
			String originalEmail1 = originalEmail;
			String newEmail1 = newEmail;
			originalEmail = newEmail1;
			newEmail = originalEmail1;
		}
		driver.findElement(By.cssSelector("button.close")).click();
		driver.findElement(By.id("logout")).click();
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
