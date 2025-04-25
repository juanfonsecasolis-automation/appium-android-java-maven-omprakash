package com.qa.tests;

import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBase 
{
    protected AndroidDriver driver;
    
    @BeforeTest
    @Parameters({"automationName", "platformName", "deviceName", "appLocation", "appiumURL"})
    public void beforeTest(String automationName, String platformName, String deviceName, 
        String appLocation, String appiumURL) 
        throws URISyntaxException, FileNotFoundException, IOException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName(automationName)
            .setPlatformName(platformName)
            .setDeviceName(deviceName)
            .setApp(appLocation);

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
