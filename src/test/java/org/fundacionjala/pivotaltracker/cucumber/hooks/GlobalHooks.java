package org.fundacionjala.pivotaltracker.cucumber.hooks;

import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.fundacionjala.pivotaltracker.util.PropertiesInfo;

import static org.fundacionjala.pivotaltracker.api.RequestManager.getRequest;
import static org.fundacionjala.pivotaltracker.util.CommonMethods.deleteAllProjects;
import static org.fundacionjala.pivotaltracker.util.CommonMethods.deleteAllWorkspaces;
import static org.fundacionjala.pivotaltracker.util.CommonMethods.quitProgram;
import static org.fundacionjala.pivotaltracker.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotaltracker.util.Constants.SUCCESS_STATUS_CODE;

/**
 *This class stores the global hooks methods required to run the test
 *
 * @author Henrry Salinas.
 */
public class GlobalHooks {

    private static final String PROPERTIES_FILE_UNFILLED = "Error reading the properties file, one of the next properties is missing: email, pivotaltracker token or password";

    private static final String API_CREDENTIALS_INCORRECT = "The pivotaltracker rest credentials is not correct";

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    private static boolean BEFORE_ALL_FLAG = false;

    @Before
    public void beforeAll() {
        if (!BEFORE_ALL_FLAG) {
            deleteAllProjects();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    deleteAllProjects();
                    deleteAllWorkspaces ();
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
