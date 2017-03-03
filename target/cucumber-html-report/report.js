$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: jay.franklin@csra.com"
    }
  ],
  "line": 5,
  "name": "Access the Manage Access Tool",
  "description": "User Stories [ UAS-20 ][ UAS-93 ][ UAS-815 ][ UAS-816 ][ UAS-823 ][ UAS-824 ][ UAS-826 ][ UAS-827 ][ UAS-831 ][ UAS-980 ]\r\nThis feature file logs in as an Admin to access the Manage Access Tool Page",
  "id": "access-the-manage-access-tool",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@all_faa"
    },
    {
      "line": 3,
      "name": "@jay_group2"
    },
    {
      "line": 3,
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "line": 9,
  "name": "Gateway App Validate the Login Access Tool -- 12 Steps",
  "description": "",
  "id": "access-the-manage-access-tool;gateway-app-validate-the-login-access-tool----12-steps",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "i have accessed the welcome page",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "i click on the Login button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "i click on the I Agree button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "log in with random gateway hobbyist account",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "i click the logout button",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationMap.given_welcome()"
});
formatter.result({
  "duration": 1477672064,
  "error_message": "net.serenitybdd.core.exceptions.SerenityManagedException: org.openqa.selenium.os.CommandLine.find(Ljava/lang/String;)Ljava/lang/String;\r\n\tat net.serenitybdd.core.webdriver.servicepools.DriverServiceExecutable.asAFile(DriverServiceExecutable.java:90)\r\n\tat net.serenitybdd.core.webdriver.servicepools.GeckoDriverServiceExecutable.geckoBinaryCalled(GeckoDriverServiceExecutable.java:38)\r\n\tat net.serenitybdd.core.webdriver.servicepools.GeckoDriverServiceExecutable.executablePath(GeckoDriverServiceExecutable.java:24)\r\n\tat net.serenitybdd.core.webdriver.servicepools.GeckoDriverServiceExecutable.inEnvironment(GeckoDriverServiceExecutable.java:20)\r\n\tat net.serenitybdd.core.webdriver.servicepools.GeckoServicePool.configureGeckoDriverBinaries(GeckoServicePool.java:38)\r\n\tat net.serenitybdd.core.webdriver.servicepools.GeckoServicePool.\u003cinit\u003e(GeckoServicePool.java:29)\r\n\tat net.serenitybdd.core.webdriver.driverproviders.FirefoxDriverProvider.\u003cinit\u003e(FirefoxDriverProvider.java:29)\r\n\tat net.thucydides.core.webdriver.WebDriverFactory.driverProviders(WebDriverFactory.java:102)\r\n\tat net.thucydides.core.webdriver.WebDriverFactory.newWebdriverInstance(WebDriverFactory.java:126)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.newDriverInstance(WebDriverFacade.java:144)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.newProxyDriver(WebDriverFacade.java:135)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.getProxiedDriver(WebDriverFacade.java:105)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.openIgnoringHtmlUnitScriptErrors(WebDriverFacade.java:180)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.get(WebDriverFacade.java:175)\r\n\tat net.serenitybdd.core.pages.PageObject.openPageAtUrl(PageObject.java:829)\r\n\tat net.serenitybdd.core.pages.PageObject.openAt(PageObject.java:782)\r\n\tat faa.cucumber.stepLibraries.BaseUserSteps.navigateToTheFaaHomePage(BaseUserSteps.java:60)\r\n\tat faa.cucumber.stepLibraries.BaseUserSteps$$EnhancerByCGLIB$$8346fc2.CGLIB$navigateToTheFaaHomePage$10(\u003cgenerated\u003e)\r\n\tat faa.cucumber.stepLibraries.BaseUserSteps$$EnhancerByCGLIB$$8346fc2$$FastClassByCGLIB$$29f612bc.invoke(\u003cgenerated\u003e)\r\n\tat net.sf.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:228)\r\n\tat net.thucydides.core.steps.StepInterceptor.invokeMethod(StepInterceptor.java:372)\r\n\tat net.thucydides.core.steps.StepInterceptor.executeTestStepMethod(StepInterceptor.java:357)\r\n\tat net.thucydides.core.steps.StepInterceptor.runTestStep(StepInterceptor.java:332)\r\n\tat net.thucydides.core.steps.StepInterceptor.testStepResult(StepInterceptor.java:134)\r\n\tat net.thucydides.core.steps.StepInterceptor.intercept(StepInterceptor.java:61)\r\n\tat faa.cucumber.stepLibraries.BaseUserSteps$$EnhancerByCGLIB$$8346fc2.navigateToTheFaaHomePage(\u003cgenerated\u003e)\r\n\tat faa.cucumber.maps.NavigationMap.given_welcome(NavigationMap.java:197)\r\n\tat ✽.Given i have accessed the welcome page(login.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "NavigationMap.when_click_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NavigationMap.clickOnIAgreeButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NavigationMap.iloginWithRandomGatewayHobbyistAccount()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserProfileMap.clickOnLogoutButton()"
});
formatter.result({
  "status": "skipped"
});
});