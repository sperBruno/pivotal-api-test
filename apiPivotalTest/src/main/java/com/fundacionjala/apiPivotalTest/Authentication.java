package com.fundacionjala.apiPivotalTest;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.baseURI;

public class Authentication {

    private final static Logger LOGGER = Logger.getLogger(RequestManager.class);

    public static final String TOKEN_HEADER = "X-TrackerToken";

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        try {
            baseURI = PropertiesInfo.getInstance().getBaseUrl();
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .setProxy(PropertiesInfo.getInstance().getProxy())
                    .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getToken())
                    .build();
            LOGGER.info("The api was initialized");
        } catch (Exception e) {
            LOGGER.fatal("Fatal error initializing the api properties " + e.getMessage());
        }
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
