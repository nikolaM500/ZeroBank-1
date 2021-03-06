package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utils.BrowserUtils;
import com.zerobank.utils.ConfigurationReader;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.swing.*;

public class Login_steps {
    LoginPage loginPage = new LoginPage();
    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {

        String url= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @When("user logs in")
    public void user_logs_in() {
        loginPage.login();
    }
    @Then("user should see ZeroBank homepage")
    public void user_should_see_zero_bank_homepage() {

        String expected="Zero Bank";
        String actual=loginPage.getHomePageOfZeroBank();
        Assert.assertEquals(expected,actual);


    }



}
