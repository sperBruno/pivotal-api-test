package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;


import java.util.Map;

import com.fundacionjala.apiPivotalTest.RequestManager;
import com.fundacionjala.apiPivotalTest.cucumber.steps.RequestSteps;
import com.fundacionjala.apiPivotalTest.cucumber.steps.project.Project;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;

public class Story {
    private JSONObject parameters;

    private String storyEndpoint;

    private Project project;

    private RequestSteps requestSteps;

    public Story(Project project,RequestSteps requestSteps){
        this.project =project;
        this.requestSteps=requestSteps;
    }
    @And("^I have the story endpoint$")
    public void iHaveTheStoryEndpoint() {
        storyEndpoint = new StringBuilder().append("/projects/")
                .append(this.project.getParameters().get("id"))
                .append("/stories").toString();
    }
    @And("^I have the next parameters to create a story:$")
    public void iHaveTheNextParametersToCreateAStory(Map<String,Object> storyData) {
        parameters = new JSONObject();

        parameters.put("name", new StringBuilder().append(storyData.get("name")).append(System.currentTimeMillis()).toString());
        parameters.put("description", storyData.get("description"));

    }

    @When("^I send a story POST request to /stories endpoint$")
    public void iSendAStoryPOSTRequestToStoriesToStoriesEndpoint() {
        requestSteps.setResponse(RequestManager.postRequest(storyEndpoint,parameters));

    }


}
