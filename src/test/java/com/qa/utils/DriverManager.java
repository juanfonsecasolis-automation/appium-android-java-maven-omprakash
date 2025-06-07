package com.qa.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager 
{
    public static AndroidDriver getDriver(
        String automationName, String platformName, String udid, 
        String appLocation, String appiumURL, String appPackage, 
        String appWaitActivity) throws MalformedURLException, URISyntaxException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName(automationName)
            .setPlatformName(platformName)
            .setApp(appLocation)
            .setAppPackage(appPackage)
            .setAppWaitActivity(appWaitActivity)
            .setUdid(udid);

        return new AndroidDriver(
            new URI(appiumURL).toURL(), 
            options
        );
    }
}
