package org.fundacionjala.api.cucumber.steps.story;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Then;
import org.fundacionjala.api.cucumber.steps.ApiResources;
import org.fundacionjala.api.endpoints.story.StoryParams;

import static org.fundacionjala.api.endpoints.story.StoryParams.STORY_TITLE;
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
        storiesValues = (Map) apiResources.getParameters();
        storiesValues.keySet().stream().forEach((step) -> {
            assertEquals(assertionMap().get(step), storiesValues.get(step));
        });
    }
    
    public Map<StoryParams, Object> assertionMap() {
        Map<StoryParams, Object> assertionMap = new HashMap<>();
        assertionMap.put(STORY_TITLE, apiResources.getResponse().jsonPath().getBoolean("name"));
        return assertionMap;
    }
}
