package org.fundacionjala.api.util;

import java.util.ArrayList;
import java.util.Map;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.api.api.RequestManager.deleteRequest;
import static org.fundacionjala.api.api.RequestManager.getRequest;
import static org.fundacionjala.api.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.api.util.Constants.PROJECT_ID;
import static org.fundacionjala.api.util.Constants.WORKSPACES_ENDPOINT;
import static org.fundacionjala.api.util.Constants.WORKSPACE_ID;

/**
 * Created by mijhailvillarroel.
 */
public final class CommonMethods {

    private CommonMethods() {
    }

    public static void deleteAllProjects() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(getRequest(PROJECTS_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(PROJECTS_ENDPOINT + object.get(PROJECT_ID).toString());
            }
        }
    }

    public static void deleteAllWorkspaces() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(getRequest(WORKSPACES_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(WORKSPACES_ENDPOINT + object.get(WORKSPACE_ID).toString());
            }
        }
    }
    public static void quitProgram(String message) {
        System.err.println(message);
        Runtime.getRuntime().exit(1);
    }
}
