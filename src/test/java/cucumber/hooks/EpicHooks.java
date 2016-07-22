package cucumber.hooks;

import org.fundacionjala.pivotal.api.Mapper;
import cucumber.steps.ApiResources;

import cucumber.api.java.After;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.util.Constants.PROJECTS_ENDPOINT;

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
