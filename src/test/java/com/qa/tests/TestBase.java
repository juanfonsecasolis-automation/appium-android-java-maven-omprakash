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
    
    /*@BeforeClass
    public void beforeClass()
    {
        driver.activateApp("com.saucelabs.mydemoapp.android");
    }

    @AfterClass
    public void afterClass()
    {
        driver.terminateApp("com.saucelabs.mydemoapp.android");
    }*/

    /* 
     * Opposite to web automation, we can't create multiple instances of the mobile app, 
     * we have to use one.
    */
    @BeforeMethod
    @Parameters({"automationName", "platformName", "deviceName", "appLocation", "appiumURL",
        "appPackage", "appWaitActivity"})
    public void beforeMethod(String automationName, String platformName, String deviceName, 
        String appLocation, String appiumURL, String appPackage, String appWaitActivity) 
        throws URISyntaxException, MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName(automationName)
            .setPlatformName(platformName)
            //.setDeviceName(deviceName)
            .setApp(appLocation)
            .setAppPackage(appPackage)
            .setAppWaitActivity(appWaitActivity)
            .setUdid("920135baf02f444a");

        driver = new AndroidDriver(
            new URI(appiumURL).toURL(), 
            options
        );
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }
}
