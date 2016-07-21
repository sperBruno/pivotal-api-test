package org.fundacionjala.api.cucumber.hooks;

import org.fundacionjala.api.api.Mapper;
import org.fundacionjala.api.cucumber.steps.ApiResources;

import cucumber.api.java.After;

import static org.fundacionjala.api.api.RequestManager.deleteRequest;
import static org.fundacionjala.api.util.Constants.DELETE_STATUS_CODE;
import static org.fundacionjala.api.util.Constants.SUCCESS_STATUS_CODE;

public class StoryHooks {

    private ApiResources api;

    public StoryHooks(ApiResources api) {
        this.api = api;
    }

    @After("@story")
    public void afterStoryScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE || api.getResponse().statusCode() == DELETE_STATUS_CODE) {
            deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));
        }
    }
}
