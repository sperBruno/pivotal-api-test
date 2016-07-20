package org.fundacionjala.apiPivotalTest.cucumber.steps;

import java.util.ArrayList;
import java.util.Map;

import org.fundacionjala.apiPivotalTest.api.Mapper;

import cucumber.api.java.After;

import static org.fundacionjala.apiPivotalTest.api.RequestManager.deleteRequest;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.apiPivotalTest.util.Constants.DELETE_STATUS_CODE;
import static org.fundacionjala.apiPivotalTest.util.Constants.SUCCESS_STATUS_CODE;

public class Hooks {

    ApiResources api;

    public Hooks(ApiResources api) {
        this.api = api;
    }


    public void afterProjectScenario() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(api.getResponse().asString()).get("");
        String id=from(api.getResponse().asString()).get("id").toString();
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest("/projects/" + object.get("id").toString());
            }
        }
    }

    @After("@story")
    public void afterStoryScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE || api.getResponse().statusCode() == DELETE_STATUS_CODE) {
            deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));
        }
    }


}
