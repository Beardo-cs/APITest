package com.scripBox.apitest;

import com.qapitol.sauron.core.pages.DiService;
import com.qapitol.sauron.report.core.annotations.ReportTest;
import org.testng.annotations.Test;

import com.qapitol.sauron.common.annotations.SauronTest;


public class ApiTest {

  final LoginPage loginPage = DiService.get(LoginPage.class);

//  @SauronTest
//  @Test
//  @ReportTest("Asking for joke from random joke api")
//  public void askForJokeTest() {
//    loginPage.askingForJoke();
//  }


  @SauronTest
  @Test
  @ReportTest("Register API Test")
  public void RegisterAPI() {
   loginPage.Register();
  }

  @SauronTest
  @Test
  @ReportTest("Negative Register API Test")
  public void NegativeRegisterAPI() {
    loginPage.NegativeRegisterScenario();
  }

  @SauronTest
  @Test
  @ReportTest("Negative Login API Test with Invalid password")
  public void NegativeRegisterAPIWithInvalidPassword() {
    loginPage.NegativeRegisterScenarioWithInvalidPassword();
  }


  @SauronTest
  @Test
  @ReportTest("Login API Test")
  public void LoginAPI() {
    loginPage.Login();
  }



  @SauronTest
  @Test
  @ReportTest("Negative Login API Test")
  public void NegativeLoginAPI() {
    loginPage.NegativeLoginScenario();
  }


  @SauronTest
  @Test
  @ReportTest("Profile API Test")
  public void ProfileAPI() {
    loginPage.UserProfile();
  }


  @SauronTest
  @Test
  @ReportTest("Unknown API Test")
  public void UnknownAPI() {
    loginPage.ResourceList();
  }




}

