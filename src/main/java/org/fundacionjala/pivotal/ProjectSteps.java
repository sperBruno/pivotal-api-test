package org.fundacionjala.pivotal;

/**
 * Created by mijhailvillarroel on 7/21/2016.
 */
public enum ProjectSteps {
    ID,
    KIND,
    NAME,
    VERSION,
    ITERATION_LENGTH,
    WEEK_START_DAY,
    POINT_SCALE,
    POINT_SCALE_IS_CUSTOM,
    BUGS_AND_CHORES_ARE_ESTIMATABLE,
    AUTOMATIC_PLANNING,
    ENABLE_TASKS,
    TIME_ZONE,
    VELOCITY_AVERAGED_OVER,
    NUMBER_OF_DONE_ITERATIONS_TO_SHOW,
    HAS_GOOGLE_DOMAIN,
    ENABLE_INCOMING_EMAILS,
    INITIAL_VELOCITY,
    PUBLIC,
    ATOM_ENABLED,
    PROJECT_TYPE,
    START_TIME,
    CREATED_AT,
    UPDATED_AT,
    ACCOUNT_ID,
    CURRENT_ITERATION_NUMBER,
    ENABLE_FOLLOWING;

    public String nameLowerCase() {
        return name().toLowerCase();
    }
}
