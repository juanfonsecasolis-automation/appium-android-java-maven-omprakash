package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;

public class PageBase 
{
    protected AndroidDriver driver;

    public PageBase(AndroidDriver driver)
    {
        this.driver = driver;
    }

}
