package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.pages.CatalogPage;

public class SauceLabsDemoAppTest extends TestBase 
{
    @Test
    public void testNegativeLogin() throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
    }
}
