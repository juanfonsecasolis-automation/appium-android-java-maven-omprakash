package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestBase 
{
    protected AndroidDriver driver;
    
    @BeforeTest
    @Parameters({"automationName", "platformName", "deviceName", "appLocation", "appiumURL",
        "appPackage", "appWaitActivity"})
    public void beforeTest(String automationName, String platformName, String deviceName, 
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

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
