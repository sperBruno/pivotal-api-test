package org.fundacionjala.pivotaltracker.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.pivotaltracker.cucumber.steps.ApiResources;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotaltracker.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotaltracker.util.CommonMethods.deleteAllProjects;
import static org.fundacionjala.pivotaltracker.util.CommonMethods.deleteAllWorkspaces;
import static org.fundacionjala.pivotaltracker.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotaltracker.util.Constants.WORKSPACES_ENDPOINT;

/**
 * Created by danielgonzales
 */
public class WorkspaceHooks {

    private ApiResources api;

    public WorkspaceHooks (ApiResources api) {
        this.api = api;
    }

    @After("@DeleteProject")
    public void deleteProject() {
        deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get("id").toString());
    }

    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
            deleteRequest(WORKSPACES_ENDPOINT + from(api.getResponse().asString()).get("id").toString());
    }

    @Before("@CleanEnviroment")
    public void DeleteAllWorkspaces() {
        deleteAllProjects ();
        deleteAllWorkspaces();
    }
}
