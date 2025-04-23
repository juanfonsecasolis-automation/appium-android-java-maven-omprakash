package com.appium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException, URISyntaxException
    {
        UiAutomator2Options options = new UiAutomator2Options()
            .setAutomationName("uiautomator2")
            .setPlatformName("Android")
            .setDeviceName("SmallPhoneAPI35")
            .setApp("/home/juanf/repositorios/appium-android-java-maven-omprakash/apps/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(
            new URI("http://127.0.0.1:4723").toURL(), 
            options
        );
        
        assertTrue( true );
    }
}
