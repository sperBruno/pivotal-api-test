package org.fundacionjala.api.cucumber.steps.story;

import java.util.Map;

import cucumber.api.java.en.Then;
import org.fundacionjala.api.cucumber.steps.ApiResources;
import org.fundacionjala.api.endpoints.story.StoryParams;

import static org.junit.Assert.assertEquals;

/**
 * Created by Charito on 7/21/2016.
 */
public class StoryAsserts {
    private ApiResources apiResources;
    private Map<StoryParams, Object> storiesValues;
    
    public StoryAsserts(ApiResources apiResources){
        this.apiResources = apiResources;
    }

    @Then("^I validate fields$")
    public void iValidateFields() {
        final String expected = "newStory";
        assertEquals(expected, apiResources.getResponse().jsonPath().get("name"));
    }
}
