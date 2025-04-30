package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class PageBase 
{
    protected AndroidDriver driver;

    public PageBase(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element)
    {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text)
    {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attributeName)
    {
        waitForVisibility(element);
        return element.getDomAttribute(attributeName);
    }
}
