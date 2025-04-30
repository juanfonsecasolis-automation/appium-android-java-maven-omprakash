package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends WithMenuPage 
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    WebElement titleLabel;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    WebElement addToCartButton;

    public ProductPage(AndroidDriver driver) 
    {
        super(driver);
        waitForVisibility(titleLabel);
        waitForVisibility(addToCartButton);
    }
    
    public String getTitleLabel()
    {
        return titleLabel.getText();
    }
}
