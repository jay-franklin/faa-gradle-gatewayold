import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CloseWindows {
	@FindBy(id = "uh-search-box") private static WebElementFacade yahooSearch;
	@FindBy(id = "lst-ib") private static WebElementFacade googleSearch;
	@FindBy( id = "Google Search") private static WebElementFacade googleSearchButton;
	
	public static void typeIntoYahooSearchField() {
		yahooSearch.type("Faa Drone");
	}
	public static void typeIntoGoogleSearchField() {
		googleSearch.type("Google Faa Drone");
	}
	
	public static void clickOnGoogleSearchButton() {
		googleSearchButton.click();
	}
	
	
    public static void main(String[] args) throws InterruptedException, AWTException {
    	
    	
    	
    	//***Code 1***
    //First tab(default tab)
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("http://www.google.com");
//    driver.get("http://www.google.com/xhtml");
    driver.manage().window().maximize();
    typeIntoGoogleSearchField();
    clickOnGoogleSearchButton();

    //second tab
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    driver.navigate().to("https://yahoo.com");
//    typeIntoYahooSearchField();
    //third tab
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    driver.navigate().to("http://www.google.com");
    typeIntoGoogleSearchField();
    clickOnGoogleSearchButton();
    
    //move to very first tab.
    driver.findElement(By.cssSelector("body"))
            .sendKeys(Keys.CONTROL + "\t");

    // To close the current tab.    
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
//    **code 2**
    driver.navigate().to("http://www.google.com");
    driver.manage().window().maximize();


    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_T);

    Set<String> handles = driver.getWindowHandles();
    List<String> handlesList = new ArrayList<String>(handles);
    String newTab = handlesList.get(handlesList.size() - 1);

    // switch to new tab
    driver.switchTo().window(newTab); 
    driver.get("http://www.yahoo.com");


    }


}
