package org.fundacionjala.api.cucumber.hooks;

import org.apache.commons.lang3.StringUtils;
import org.fundacionjala.api.util.PropertiesInfo;

import cucumber.api.java.Before;

import static org.fundacionjala.api.api.RequestManager.getRequest;
import static org.fundacionjala.api.util.CommonMethods.deleteAllProjects;
import static org.fundacionjala.api.util.CommonMethods.quitProgram;
import static org.fundacionjala.api.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.api.util.Constants.SUCCESS_STATUS_CODE;

/**
 *This class stores the global hooks methods required to run the test
 *
 * @author Henrry Salinas.
 */
public class GlobalHooks {

    private static final String PROPERTIES_FILE_UNFILLED = "Error reading the properties file, one of the next properties is missing: email, api token or password";

    private static final String API_CREDENTIALS_INCORRECT = "The api rest credentials is not correct";

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    private static boolean BEFORE_ALL_FLAG = false;

    @Before
    public void beforeAll() {
        if (!BEFORE_ALL_FLAG) {
            deleteAllProjects();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    deleteAllProjects();
                }
            });
            if (StringUtils.isEmpty(PROPERTIES_INFO.getEmail()) || StringUtils.isEmpty(PROPERTIES_INFO.getApiToken()) || StringUtils.isEmpty(PROPERTIES_INFO.getPassword())) {
                quitProgram(PROPERTIES_FILE_UNFILLED);
            } else if (getRequest(PROJECTS_ENDPOINT).statusCode() != SUCCESS_STATUS_CODE) {
                quitProgram(API_CREDENTIALS_INCORRECT);
            }
            BEFORE_ALL_FLAG = true;
        }
    }
}
