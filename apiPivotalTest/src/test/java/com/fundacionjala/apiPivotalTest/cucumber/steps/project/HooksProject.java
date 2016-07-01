package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import com.jayway.restassured.response.Response;

import cucumber.api.java.After;
import java.util.ArrayList;
import java.util.Map;

import static com.fundacionjala.apiPivotalTest.RequestManager.deleteRequest;
import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;
import static com.jayway.restassured.path.json.JsonPath.from;

public class HooksProject {

    private Project project;

    private Response response;

    public HooksProject(Project project) {
        this.project = project;
    }

    @After
    public void afterScenario() {
        response = getRequest("/projects");
        ArrayList<Map<String, ?>> jsonAsArrayList = from(response.asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest("/projects/" + object.get("id"));
            }
        }
    }
}
