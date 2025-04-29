package com.qa.tests;

import org.junit.Test;
import org.testng.Assert;
import com.qa.pages.CatalogPage;

public class SauceLabsDemoAppTest extends TestBase 
{
    @Test
    public void testNegativeLogin() throws Exception
    {       
        Assert.fail(); 
        CatalogPage catalogPage = new CatalogPage(driver);
        Assert.fail();
    }
}
