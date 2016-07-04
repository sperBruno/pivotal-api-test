package com.fundacionjala.apiPivotalTest.cucumber.steps;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ResponseSteps {

    private ApiResources apiResources;

    public ResponseSteps(ApiResources apiResources) {
        this.apiResources = apiResources;
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, apiResources.getResponse().statusCode());
    }
}
