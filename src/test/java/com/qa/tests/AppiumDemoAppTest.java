package com.qa.tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class AppiumDemoAppTest extends TestBase
{
    @Test
    public void testDifferentLocatorsOfTheSameAccessibilityMenuItem() throws Exception
    {        
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
