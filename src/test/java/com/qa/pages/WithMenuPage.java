package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WithMenuPage extends PageBase
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement menuIcon;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginButton;

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
        menuIcon = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuIV"));
        click(menuIcon);
        switch (menuItemType) {
            case LogIn:
                new Actions(driver).scrollToElement(loginButton);
                loginButton.click();
                return new LogInPage(driver);
            default:
                throw new Exception(String.format("Unkown page type '%s'.", menuItemType));
        }
    }

}
