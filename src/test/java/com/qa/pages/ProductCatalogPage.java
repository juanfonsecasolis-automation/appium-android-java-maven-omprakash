package com.qa.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class ProductCatalogPage extends WithMenuPage
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(id = "title")
    private WebElement titleLabel;
    
    public ProductCatalogPage(AndroidDriver driver)
    {
        super(driver);
        waitForVisibility(titleLabel);
        Assert.assertEquals("Products", titleLabel.getText());
    }

}
