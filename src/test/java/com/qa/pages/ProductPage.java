package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends WithMenuPage 
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    WebElement titleLabel;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    WebElement addToCartButton;

    By priceLabelLocator = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/priceTV\").instance(0))");

    public ProductPage(AndroidDriver driver) 
    {
        super(driver);
        waitForVisibility(titleLabel);
        //waitForVisibility(addToCartButton);
    }
    
    public String getProductName()
    {
        return titleLabel.getText();
    }

    public String getProductPrice() throws InterruptedException 
    {
        return driver.findElement(priceLabelLocator).getText();
    }
}
