package org.fundacionjala.api.cucumber.steps;

import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;

public class Asserts {

    private ApiResources api;

    public Asserts(ApiResources api) {
        this.api = api;
    }

    @And("^The (.*?) field should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String fieldName, String expectedValue) {
        assertEquals(expectedValue, api.getResponse().path(fieldName));
    }
}
