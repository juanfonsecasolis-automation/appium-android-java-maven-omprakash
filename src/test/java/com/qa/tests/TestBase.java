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
    
    /* 
     * Opposite to web automation, we can't create multiple instances of the mobile app, 
     * we have to use one.
    */
    @BeforeClass
    @Parameters({"automationName", "platformName", "deviceName", "appLocation", "appiumURL",
        "appPackage", "appWaitActivity"})
    public void beforeClass(String automationName, String platformName, String deviceName, 
        String appLocation, String appiumURL, String appPackage, String appWaitActivity) 
        throws URISyntaxException, MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName(automationName)
            .setPlatformName(platformName)
            .setDeviceName(deviceName)
            .setApp(appLocation)
            .setAppPackage(appPackage)
            .setAppWaitActivity(appWaitActivity);

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
