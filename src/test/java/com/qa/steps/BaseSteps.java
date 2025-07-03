package com.qa.steps;

import com.qa.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps 
{
    protected final AndroidDriver driver;
    protected final String appPackage;

    public BaseSteps()
    {
        this.driver = Hooks.androidDriver;
        this.appPackage = Hooks.appPackage;
    }
}
