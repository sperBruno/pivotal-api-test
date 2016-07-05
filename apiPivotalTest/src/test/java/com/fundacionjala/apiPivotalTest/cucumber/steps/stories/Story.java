package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;

import org.json.simple.JSONObject;

import cucumber.api.java.en.And;

public class Story {

    private JSONObject parameters;

    private ApiResources api;

    public Story(ApiResources api) {
        this.api = api;
    }

//    @And("^I have the next parameters? to (?:create|update) a story:$")
//    public void iHaveTheNextParametersToCreateAStory(Map<String, Object> storyData) {
//        api.setParameters(storyData);
//    }


    @And("^I have a story created$")
    public void iHaveAStoryCreated() {
    }
}
