package com.qa.steps;

import com.qa.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps 
{
    protected final AndroidDriver driver;
    protected final String appPackage;

    public BaseSteps()
    {
        this.driver = Hooks.driver;
        this.appPackage = Hooks.appPackage;
    }
}
