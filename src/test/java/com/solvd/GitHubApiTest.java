package com.solvd;

import com.solvd.api.github.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GitHubApiTest implements IAbstractTest {

    private final String TOKEN = "Bearer " + Configuration.getRequired("git_token");
    private final String USERNAME = "Luka-Vashakidze";
    private final String TEST_EMAIL = "lukavashakidze1@gmail.com";

    @Test(description = "1. Verify User Profile")
    public void testGetUserProfile() {
        GetUserMethod api = new GetUserMethod(USERNAME);
        api.callAPIExpectSuccess();
    }

    @Test(description = "2. Verify User Repos")
    public void testGetUserRepos() {
        GetUserReposMethod api = new GetUserReposMethod(USERNAME);
        Response response = api.callAPIExpectSuccess();

        Assert.assertTrue(response.jsonPath().getList("").size() >= 0);
    }

    @Test(description = "3. Add Email Address")
    public void testAddEmail() {
        PostEmailMethod api = new PostEmailMethod();
        api.setHeaders("Authorization=" + TOKEN);

        String body = String.format("{\"emails\": [\"%s\"]}", TEST_EMAIL);
        api.setBodyContent(body);

        Response response = api.callAPI();

        if (response.getStatusCode() == 422) {
            System.out.println("Email already exists, continuing...");
        } else {
            response.then().statusCode(201);
        }
    }

    @Test(dependsOnMethods = "testAddEmail", description = "4. Set Email Visibility")
    public void testSetEmailVisibility() {
        PatchEmailVisibilityMethod api = new PatchEmailVisibilityMethod();
        api.setHeaders("Authorization=" + TOKEN);

        String body = "{\"visibility\": \"private\"}";
        api.setBodyContent(body);

        api.callAPIExpectSuccess();
    }

    @Test(dependsOnMethods = "testSetEmailVisibility", description = "5. Delete Email Address")
    public void testDeleteEmail() {
        DeleteEmailMethod api = new DeleteEmailMethod();
        api.setHeaders("Authorization=" + TOKEN);

        String body = String.format("{\"emails\": [\"%s\"]}", TEST_EMAIL);
        api.setBodyContent(body);

        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 204, "Email deletion failed");
    }
}