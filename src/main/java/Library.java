
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import com.gargoylesoftware.htmlunit.BrowserVersion;


public class Library {
public static void main(final String[] args) {

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);    
//    // Set path for Internet Explorer Driver executable
	// Create WebDriver reference
    WebDriver driver;

    System.setProperty("webdriver.ie.driver", "C:/Users/jfrankl6/Tools/IEDriverServer/IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	
//	System.setProperty("webdriver.chrome.driver", "C:/Users/jfrankl6/Tools/Chromedriver/chromedriver.exe");
//    driver = new ChromeDriver();
    
    // And now use this to visit Google
    driver.get("http://www.google.com");

//    try {
//        Thread.sleep(30000);
//    } catch (final InterruptedException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }

 // Enter the text in the search box
    WebElement searchText = driver.findElement(By.name("q"));
    searchText.sendKeys("InternetExplorerDriver");
    
    // Close the driver
    driver.quit();  
    
    // Find the text input element by its name
//    final WebElement element = driver.findElement(By.name("q"));

    // Enter something to search for
//   element.sendKeys("Cheese!");

    // Now submit the form. WebDriver will find the form for us from the element
//    element.submit();

    // Check the title of the page
    System.out.println("Page title is: " + driver.getTitle());

}
}