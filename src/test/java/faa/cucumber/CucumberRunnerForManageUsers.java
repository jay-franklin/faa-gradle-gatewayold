package faa.cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;

@RunWith(CucumberWithSerenity.class)


@CucumberOptions(

features = { "src/test/resources/features/Manage_Users" }, 
glue = { "faa.cucumber.maps" },
plugin = {"pretty", "html:target/cucumber-html-report/", "json:reports/json/results.json"}
//plugin = {"pretty", "html:reports/html/", "json:reports/json/results.json"}
//plugin = {"html:target/cucumber-html-report"}
)

public class CucumberRunnerForManageUsers {
//	@Managed(uniqueSession = true, driver="htmluhit")
//    public WebDriver webdriver;
	//	@Managed WebDriver driver;
	//@Managed(driver="chrome")
	//@Managed(driver="htmluhit");
}
