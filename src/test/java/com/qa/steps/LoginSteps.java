package com.qa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import com.qa.pages.CatalogPage;
import com.qa.pages.LogInAttempt;
import com.qa.pages.LogInPage;
import com.qa.pages.WithMenuPage.MenuItemType;
import com.qa.tests.TestBase;

public class LoginSteps extends TestBase {

    LogInPage logInPage;
    LogInAttempt logInAttempt;

    @Given("user navigates to the login page")
    public void navigateToLoginPage() throws Exception {
        CatalogPage catalogPage = new CatalogPage(driver);
        logInPage = (LogInPage) catalogPage.openMenuItem(MenuItemType.LogIn);
    }

    @When("user tries to log in using username {String} and password {String}")
    public void enterValidCredentials(String username, String password) {
        logInAttempt = logInPage.logIn(username, password);
    }

    @Then("user receives error message {String}")
    public void verifyRedirection(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, logInAttempt.errors.get(0));
    }
}
