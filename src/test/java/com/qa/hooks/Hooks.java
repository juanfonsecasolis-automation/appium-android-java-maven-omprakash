package com.qa.hooks;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.Reporter;
import com.qa.utils.DriverManager;
import io.cucumber.java.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks 
{
    public static AndroidDriver driver;
    public static String appPackage;

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
}
