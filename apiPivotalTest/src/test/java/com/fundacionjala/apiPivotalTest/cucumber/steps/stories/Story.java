package com.fundacionjala.apiPivotalTest.cucumber.steps.stories;


import java.util.Map;

import com.fundacionjala.apiPivotalTest.cucumber.steps.project.Project;
import cucumber.api.java.en.And;
import org.json.simple.JSONObject;

public class Story {


    private JSONObject parameters;



    private String storyEndpoint;

    private Project project;

    public Story(Project project){
        this.project =project;

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
    public JSONObject getParameters() {
        return parameters;
    }
    public String getStoryEndpoint() {
        return storyEndpoint;
    }
}
