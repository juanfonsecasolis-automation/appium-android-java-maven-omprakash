package com.qa.tests;

import org.junit.Assert;
import org.junit.Test;
import com.qa.pages.LogInPage;
import com.qa.pages.ProductCatalogPage;
import com.qa.pages.WithMenuPage;

public class SauceLabsDemoAppTest extends TestBase 
{
    @Test
    public void testPositiveLogin() throws Exception
    {        
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        LogInPage logInPage = (LogInPage) productCatalogPage.openMenuItem(WithMenuPage.MenuItemType.LogIn);
        //productCatalogPage = logInPage.logIn("bod@example.com", "10203040");
        Assert.assertEquals(1, 2);
    }
}
