package com.qa.tests.sauceLabsDemoApp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.pages.CatalogPage;
import com.qa.pages.ProductPage;
import com.qa.tests.TestBase;

public class CatalogTests extends TestBase
{
    @DataProvider(name = "productsDataProvider")
    public Object[][] logInDataProvider() {
        return new Object[][] {
            { "Sauce Labs Backpack", "$29.99" }
        };
    }

    @Test(dataProvider = "productsDataProvider")
    public void testProductPage(String productName, String productPrice) throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
        ProductPage productPage = catalogPage.openProduct(productName);
        Assert.assertEquals(productName, productPage.getProductName());
        //Assert.assertEquals(productPrice, productPage.getProductPrice());
    }
}
