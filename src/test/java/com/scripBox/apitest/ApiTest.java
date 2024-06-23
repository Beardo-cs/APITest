package com.scripBox.apitest;

import com.qapitol.sauron.core.pages.DiService;
import com.qapitol.sauron.report.core.annotations.ReportTest;
import org.testng.annotations.Test;

import com.qapitol.sauron.common.annotations.SauronTest;


public class ApiTest {

    final LoginPage loginPage = DiService.get(LoginPage.class);

    @SauronTest
    @Test(priority = 0)
    @ReportTest("Register API Test with Valid Credentials")
    public void RegisterAPI() {
        loginPage.Register();
    }

    @SauronTest
    @Test(priority = 1)
    @ReportTest("Negative Register API Test with NULL password")
    public void NegativeRegisterAPI() {
        loginPage.NegativeRegisterScenario();
    }


    @SauronTest
    @Test(priority = 2)
    @ReportTest("Login API Test with Valid Credentials")
    public void LoginAPI() {
        loginPage.Login();
    }

    @SauronTest
    @Test(priority = 3)
    @ReportTest("Negative Login API Test with Invalid password")
    public void NegativeRegisterAPIWithInvalidPassword() {
        loginPage.NegativeRegisterScenarioWithInvalidPassword();
    }


    @SauronTest
    @Test(priority = 4)
    @ReportTest("Negative Login API Test with NULL username")
    public void NegativeLoginAPI() {
        loginPage.NegativeLoginScenario();
    }


    @SauronTest
    @Test(priority = 5)
    @ReportTest("Profile API Test with Successful login Bearer Token")
    public void ProfileAPI() {
        loginPage.UserProfile();
    }


    @SauronTest
    @Test(priority = 6)
    @ReportTest("Unknown API Test with Successful login Bearer Token ")
    public void UnknownAPI() {
        loginPage.ResourceList();
    }

    @SauronTest
    @Test(priority = 7)
    @ReportTest("User API Test with Successful login Bearer Token and UserID")
    public void UserAPI() {
        loginPage.User();
    }


}

