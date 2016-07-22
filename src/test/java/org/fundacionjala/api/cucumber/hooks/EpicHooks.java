package org.fundacionjala.api.cucumber.hooks;

import cucumber.api.java.After;
import org.fundacionjala.api.api.Mapper;
import org.fundacionjala.api.cucumber.steps.ApiResources;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.api.api.RequestManager.deleteRequest;
import static org.fundacionjala.api.util.Constants.PROJECTS_ENDPOINT;

public class EpicHooks {
    private ApiResources api;

    public EpicHooks(ApiResources api) {
        this.api = api;
    }

    @After("@project")
    public void afterProjectScenario() {
        deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get("id").toString());
    }

    @After("@epic")
    public void tearDown() {
        deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));
    }
}
