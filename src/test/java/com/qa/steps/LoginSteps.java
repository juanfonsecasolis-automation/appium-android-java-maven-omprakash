package com.qa.steps;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.Assert;
import org.testng.Reporter;
import com.qa.pages.CatalogPage;
import com.qa.pages.LogInAttempt;
import com.qa.pages.LogInPage;
import com.qa.pages.WithMenuPage.MenuItemType;
import com.qa.tests.TestBase;
import com.qa.utils.DriverManager;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps extends TestBase
{
    LogInPage logInPage;
    LogInAttempt logInAttempt;

    protected static AndroidDriver driver;
    protected static String appPackage;

    static String getTestngParameter(String parameterName)
    {
        return Reporter.getCurrentTestResult().getTestContext()
            .getCurrentXmlTest().getParameter(parameterName);       
    }

    @BeforeAll
    public static void setUp() throws URISyntaxException, MalformedURLException
    {
        appPackage = getTestngParameter("appPackage");
        driver = DriverManager.getDriver(
                getTestngParameter("automationName"), 
                getTestngParameter("platformName"), 
                getTestngParameter("udid"), 
                getTestngParameter("appLocation"), 
                getTestngParameter("appiumURL"), 
                appPackage, 
                getTestngParameter("appWaitActivity")
            );
    }

    @Before
    public void beforeScenario(Scenario scenario)
    {
        driver.activateApp(appPackage);
    }

    @After
    public void afterScenario(Scenario scenario)
    {
        driver.terminateApp(appPackage);
    }

    @AfterAll
    public static void teardown()
    {
        driver.quit();
    }

    @Given("user navigates to the login page")
    public void navigateToLoginPage() throws Exception 
    {
        CatalogPage catalogPage = new CatalogPage(driver);
        logInPage = (LogInPage) catalogPage.openMenuItem(MenuItemType.LogIn);
    }

    @When("user tries to log in using username {string} and password {string}")
    public void enterValidCredentials(String username, String password) 
    {
        logInAttempt = logInPage.logIn(username, password);
    }

    @Then("user receives error message {string}")
    public void verifyRedirection(String expectedErrorMessage) 
    {
        Assert.assertEquals(expectedErrorMessage, logInAttempt.errors.get(0));
    }
}
