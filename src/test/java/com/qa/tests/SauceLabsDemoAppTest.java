package com.qa.tests;

import org.junit.Assert;
import org.junit.Test;
import com.qa.pages.LoginPage;

public class SauceLabsDemoAppTest extends TestBase 
{
    @Test
    public void testDifferentLocatorsOfTheSameAccessibilityMenuItem() throws Exception
    {        
        LoginPage loginPage = new LoginPage(driver);
    }
}
