package com.qa.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class CatalogPage extends WithMenuPage
{
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement titleLabel;
    
    public CatalogPage(AndroidDriver driver)
    {
        super(driver);
        waitForVisibility(titleLabel);
        Assert.assertEquals("Products", titleLabel.getText());
    }

    public ProductPage openProduct(String productName) throws InterruptedException 
    {
        WebElement product = driver.findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"%s\"]/parent::*", productName)));
        click(product);
        return new ProductPage(driver);
    }
}
