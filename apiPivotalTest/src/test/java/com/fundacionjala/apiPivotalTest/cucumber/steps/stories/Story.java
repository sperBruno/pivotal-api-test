package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;

import cucumber.api.java.en.And;

public class Story {

    private ApiResources api;

    public Story(ApiResources api) {
        this.api = api;
    }

    @And("^I have a story created$")
    public void iHaveAStoryCreated() {
    }
}
