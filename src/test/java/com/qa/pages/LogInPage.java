package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogInPage extends PageBase
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    By usernameErrorLocator = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameErrorTV");
    By passwordErrorLocator = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public LogInPage(AndroidDriver driver)
    {
        super(driver);
    }

    public LogInAttempt logIn(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(loginButton);
        
        List<String> errors = getErrorMessages();
        if(errors.isEmpty())
        {
            return new LogInAttempt(errors, new CatalogPage(driver));
        }
        return new LogInAttempt(errors, null);
    }

    public List<String> getErrorMessages() {
        List<String> errors = new ArrayList<String>();
        if(!driver.findElements(usernameErrorLocator).isEmpty())
        {
            errors.add(driver.findElement(usernameErrorLocator).getText());
        }
        if(!driver.findElements(passwordErrorLocator).isEmpty())
        {
            errors.add(driver.findElement(passwordErrorLocator).getText());
        }
        return errors;
    }

}
