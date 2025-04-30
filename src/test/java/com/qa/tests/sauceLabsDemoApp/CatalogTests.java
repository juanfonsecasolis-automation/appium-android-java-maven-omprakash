package com.qa.tests.sauceLabsDemoApp;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.CatalogPage;
import com.qa.pages.ProductPage;
import com.qa.tests.TestBase;

public class CatalogTests extends TestBase
{
    @Test
    public void testProductPage() throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
        String productName = "Sauce Labs Backpack";
        ProductPage productPage = catalogPage.openProduct(productName);
        Assert.assertEquals(productName, productPage.getTitleLabel());
    }
}
