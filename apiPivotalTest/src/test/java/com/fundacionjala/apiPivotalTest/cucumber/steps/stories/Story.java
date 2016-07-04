package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;

import org.json.simple.JSONObject;

import cucumber.api.java.en.And;
import java.util.Map;

public class Story {

    private JSONObject parameters;

    private ApiResources api;

    public Story(ApiResources api) {
        this.api = api;
    }

    @And("^I have the next parameters? to (?:create|update) a story:$")
    public void iHaveTheNextParametersToCreateAStory(Map<String, Object> storyData) {
        parameters = new JSONObject();
        parameters.put("name", new StringBuilder().append(storyData.get("name")).append(System.currentTimeMillis()).toString());
        parameters.put("description", storyData.get("description"));
        api.setParameters(this.parameters);
    }

    @And("^I store the story (.*) endpoint$")
    public void iHaveTheStoriesEndpoint(String endpoint) {
        api.setEndPoint(api.mapEndpoint(endpoint));
    }

    @And("^I have a story created$")
    public void iHaveAStoryCreated() {
    }
}
