package org.fundacionjala.api.cucumber.hooks;

import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.fundacionjala.api.cucumber.steps.ApiResources;

import static org.fundacionjala.api.api.RequestManager.deleteRequest;
import static org.fundacionjala.api.util.Constants.PROJECTS_ENDPOINT;

/**
 * Created by Charito on 7/21/2016.
 */
public class StoryHooks {
    public static final String BASE_PROJECTS = "/projects/";
    private static final Logger LOGGER = Logger.getLogger(StoryHooks.class);
    private ApiResources apiResources;

    public StoryHooks(ApiResources apiResources) {
        this.apiResources = apiResources;
    }

    @After("@deleteProject")
    public void tearDownProject() {
        deleteRequest(PROJECTS_ENDPOINT + apiResources.getResponse().jsonPath().get("id"));
    }

    @After("@deleteProjectStory")
    public void tearDownStory() {
        deleteRequest(PROJECTS_ENDPOINT + apiResources.getResponse().jsonPath().get("project_id"));
    }
}
