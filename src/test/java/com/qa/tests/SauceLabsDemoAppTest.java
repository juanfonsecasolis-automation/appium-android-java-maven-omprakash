package com.qa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.pages.CatalogPage;
import com.qa.pages.LogInAttempt;
import com.qa.pages.LogInPage;
import com.qa.pages.WithMenuPage.MenuItemType;

public class SauceLabsDemoAppTest extends TestBase 
{

    @DataProvider(name = "logInDataProvider")
    public Object[][] logInDataProvider() {
        return new Object[][] {
            { "", "", "Username is required" },
            { "username", "", "Enter Password" },
        };
    }

    @Test(dataProvider = "logInDataProvider")
    public void testNegativeLogin(String username, String password, String expectedErrorMessage) 
        throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
        LogInPage logInPage = (LogInPage) catalogPage.openMenuItem(MenuItemType.LogIn);
        LogInAttempt logInAttempt = logInPage.logIn(username, password);
        Assert.assertEquals(expectedErrorMessage, logInAttempt.errors.get(0));
    }
}
