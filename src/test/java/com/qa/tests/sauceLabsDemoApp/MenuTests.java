package com.qa.tests.sauceLabsDemoApp;

import java.util.List;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.pages.CatalogPage;
import com.qa.tests.TestBase;

public class MenuTests extends TestBase
{
    @Test
    public void testMenuContent() 
        throws Exception
    {        
        CatalogPage catalogPage = new CatalogPage(driver);
        List<String> currentMenuItemNames = catalogPage.getMenuItemNames();
        String[] expectedMenuItemNames = new String[]{"Catalog", "About"};

        for (String expectedMenuItemName : expectedMenuItemNames) {
            Assert.assertListContainsObject(
                currentMenuItemNames, 
                expectedMenuItemName, 
                String.format("Element '%s' not found", expectedMenuItemName));
        }
        
    }
}
