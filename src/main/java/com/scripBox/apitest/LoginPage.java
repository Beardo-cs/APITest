package com.scripBox.apitest;

import com.qapitol.sauron.common.configuration.Config;
import com.scripBox.apitest.impl.LoginServiceImpl;
import com.scripBox.apitest.pojos.*;
import com.qapitol.sauron.api.client.ApiClientFactory;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import org.testng.Assert;

import java.util.Map;

public class LoginPage {

    private String token;


    @ReportTestStep("Register API Test")
    public void Register() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Credentials credentials = new Credentials();
        credentials.setEmail(Config.getConfigProperty("email"));
        credentials.setPassword(Config.getConfigProperty("password"));
        ResToken registeredUser = scripBoxApi.RegisterAPI(credentials);
        Assert.assertNotNull(registeredUser.getToken(), "Token should not be null");
        this.token = registeredUser.getToken(); // Store token for further tests
        System.out.println("Captured token: " + token);
        System.out.println("Captured ID: " + registeredUser.getId());

    }


    @ReportTestStep("Register API Test with NULL password")
    public void NegativeRegisterScenario() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Credentials credentials = new Credentials();
        credentials.setEmail(Config.getConfigProperty("email"));
        credentials.setPassword("");
        ResToken registeredUser = scripBoxApi.RegisterAPI(credentials);
        Assert.assertNotNull(registeredUser.getToken(), "Token should not be null");

    }

    @ReportTestStep("Register API Test Negative Scenario with Invalid Password")
    public void NegativeRegisterScenarioWithInvalidPassword() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Credentials credentials = new Credentials();
        credentials.setEmail(Config.getConfigProperty("email"));
        credentials.setPassword(Config.getConfigProperty("invalidPassword"));
        ResToken registeredUser = scripBoxApi.RegisterAPI(credentials);
        Assert.assertNull(registeredUser.getToken(), "Token should not be null");
    }

    @ReportTestStep("Login API test")
    public void Login() {
        LoginServiceImpl loginService = new LoginServiceImpl();
        Map<String, String> authToken = loginService.login();
        Assert.assertTrue(authToken.containsKey("Authorization"), "Authorization token should be present");
        this.token = authToken.get("Authorization").substring("Bearer ".length());
        System.out.println("Captured token: " + token);
    }

    @ReportTestStep("Negative Login API test with NULL email")
    public void NegativeLoginScenario() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Credentials credentials = new Credentials();
        credentials.setEmail("");
        credentials.setPassword(Config.getConfigProperty("password"));
        ResToken registeredUser = scripBoxApi.RegisterAPI(credentials);
        Assert.assertNotNull(registeredUser.getToken(), "Token should not be null");
    }


    @ReportTestStep("List of Resources API Test")
    public void ResourceList() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Assert.assertNotNull(this.token, "Token is not available. Please login first.");
        Unknown resources = scripBoxApi.ResourceAPI("Bearer " + this.token);
        Assert.assertNotNull(resources, "Resources should not be null");
    }

    @ReportTestStep("User Profile API Test")
    public void UserProfile() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Assert.assertNotNull(this.token, "Token is not available. Please login first.");
        Unknown profile = scripBoxApi.ProfileAPI(Integer.valueOf(Config.getConfigProperty("ID")), "Bearer " + this.token);
        Assert.assertNull(profile, "Profile should not be null");
    }


    @ReportTestStep("Get user details by User ID")
    public void User() {
        ScripBoxApi scripBoxApi = ApiClientFactory.create(ScripBoxApi.class);
        Assert.assertNotNull(this.token, "Token is not available. Please login first.");
        Users users = scripBoxApi.GetUsers(Integer.valueOf(Config.getConfigProperty("ID")), "Bearer " + this.token);
        Assert.assertEquals(users.getData().getEmail(), Config.getConfigProperty("userEmail"));

    }
}

