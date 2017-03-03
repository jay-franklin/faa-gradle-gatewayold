package faa.cucumber.maps;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.jayway.restassured.RestAssured;

import cucumber.api.java.en.Given;
//import faa.cucumber.apiStepLibraries.BaseAPILibrary;
//import faa.cucumber.apiStepLibraries.ManageSiteApiLibrary;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

/**
 * 
 * @author mddamato
 *
 */
public class TemplateApiTest extends BaseApiTests
{

	/*
	 * Step Libraries
	 */
//	@Steps private ManageSiteApiLibrary manageSiteLibrary;
	
	/*
	 * JUnit Tests
	 */
	
	
	@Given("Some given hook")
	public void testName()
	{
		
	}
}