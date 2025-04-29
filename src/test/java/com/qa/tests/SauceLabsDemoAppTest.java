package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.pages.CatalogPage;
import com.qa.pages.LogInAttempt;
import com.qa.pages.LogInPage;
import com.qa.pages.WithMenuPage.MenuItemType;

public class SauceLabsDemoAppTest extends TestBase 
{
    @Test
    public void testNegativeLogin() throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
        LogInPage logInPage = (LogInPage) catalogPage.openMenuItem(MenuItemType.LogIn);
        LogInAttempt logInAttempt = logInPage.logIn("", "");
        Assert.assertEquals("Username is required", logInAttempt.errors.get(0));
        logInAttempt = logInPage.logIn("username", "");
        Assert.assertEquals("Enter Password", logInAttempt.errors.get(0));
    }
}
