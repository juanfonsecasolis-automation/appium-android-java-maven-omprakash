package com.appium;

import org.junit.Assert;
import java.net.URI;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppTest 
{
    @Test
    public void testDifferentLocatorsOfTheSameAccessibilityMenuItem() throws Exception
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
        
        WebElement[] elements= new WebElement[]
        {
            driver.findElement(AppiumBy.accessibilityId("Accessibility")),
            driver.findElements(AppiumBy.id("android:id/text1")).get(1),
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']")),
            driver.findElement(AppiumBy.xpath("//*[@content-desc='Accessibility']")),
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")")),
            driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2),
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")")),
            driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1),
        };

        for (WebElement element : elements) {
            Assert.assertEquals(
                "Accessibility", 
                element.getText()
            );
        }
    }
}
