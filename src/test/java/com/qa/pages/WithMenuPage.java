package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WithMenuPage extends PageBase
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    WebElement menuIcon;

    By loginButtonLocator = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Log In\").instance(0))");
    
    public enum MenuItemType
    {
        LogIn
    }

    public WithMenuPage(AndroidDriver driver)
    {
        super(driver);
    }

    public PageBase openMenuItem(MenuItemType menuItemType) throws Exception
    {
        click(menuIcon);
        switch (menuItemType) {
            case LogIn:
                driver.findElement(loginButtonLocator).click();
                return new LogInPage(driver);
            default:
                throw new Exception(String.format("Unkown page type '%s'.", menuItemType));
        }
    }

}
