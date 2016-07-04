package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;

import java.util.Map;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;
import cucumber.api.java.en.And;
import org.json.simple.JSONObject;

public class Story {

    private JSONObject parameters;

    private ApiResources api;

    public Story(ApiResources api) {
        this.api = api;
    }

    @And("^I have the next parameters? to (?:create|update) a story:$")
    public void iHaveTheNextParametersToCreateAStory(Map<String, Object> storyData) {
        parameters = new JSONObject();
        parameters.put("name", storyData.get("name").toString());
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
