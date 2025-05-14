package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public abstract class TestBase 
{
    protected AndroidDriver driver;
    
    @BeforeMethod
    @Parameters({"appPackage"})
    public void beforeMethod(String appPackage)
    {
        driver.activateApp(appPackage);
    }

    @AfterMethod
    @Parameters({"appPackage"})
    public void afterMethod(String appPackage)
    {
        driver.terminateApp(appPackage);
    }

    /* 
     * Contrary to web automation, we can't create multiple instances of the mobile app, 
     * so we have to recycle it.
    */
    @BeforeClass
    @Parameters({"automationName", "platformName", "udid", "appLocation", "appiumURL",
        "appPackage", "appWaitActivity"})
    public void beforeClass(String automationName, String platformName, String udid, 
        String appLocation, String appiumURL, String appPackage, String appWaitActivity) 
        throws URISyntaxException, MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName(automationName)
            .setPlatformName(platformName)
            .setApp(appLocation)
            .setAppPackage(appPackage)
            .setAppWaitActivity(appWaitActivity)
            .setUdid(udid);

        driver = new AndroidDriver(
            new URI(appiumURL).toURL(), 
            options
        );
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
