package com.qa.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.Reporter;
import com.qa.utils.DriverManager;
import io.cucumber.java.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import java.io.File;

public class Hooks 
{
    public static AndroidDriver androidDriver;
    public static String appPackage;
    static AppiumDriverLocalService appiumServer;

    static String getTestngParameter(String parameterName)
    {
        return Reporter.getCurrentTestResult().getTestContext()
            .getCurrentXmlTest().getParameter(parameterName);       
    }

    @BeforeAll
    public static void setUp() throws URISyntaxException, MalformedURLException
    {
        // initialize the appium server
        appiumServer = AppiumDriverLocalService.buildDefaultService();
        appiumServer.start();

        // initialize web driver
        appPackage = getTestngParameter("appPackage");
        androidDriver = DriverManager.getDriver(
                getTestngParameter("automationName"), 
                getTestngParameter("platformName"), 
                getTestngParameter("udid"), 
                getTestngParameter("appLocation"), 
                getTestngParameter("appiumURL"), 
                appPackage, 
                getTestngParameter("appWaitActivity")
            );
    }

    @AfterAll
    public static void teardown()
    {
        androidDriver.quit();
        appiumServer.close();
    }

    @Before
    public void beforeScenario(Scenario scenario)
    {
        androidDriver.activateApp(appPackage);
    }

    @After
    public void afterScenario(Scenario scenario)
    {
        androidDriver.terminateApp(appPackage);
    }
}
