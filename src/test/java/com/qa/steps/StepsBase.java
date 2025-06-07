package com.qa.steps;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.qa.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;

public class StepsBase 
{
    /*protected static AndroidDriver driver;
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
    }*/
}
