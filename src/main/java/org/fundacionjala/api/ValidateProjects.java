package org.fundacionjala.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fundacionjala.api.ProjectSteps.ACCOUNT_ID;
import static org.fundacionjala.api.ProjectSteps.ATOM_ENABLED;
import static org.fundacionjala.api.ProjectSteps.AUTOMATIC_PLANNING;
import static org.fundacionjala.api.ProjectSteps.BUGS_AND_CHORES_ARE_ESTIMATABLE;
import static org.fundacionjala.api.ProjectSteps.CREATED_AT;
import static org.fundacionjala.api.ProjectSteps.CURRENT_ITERATION_NUMBER;
import static org.fundacionjala.api.ProjectSteps.ENABLE_FOLLOWING;
import static org.fundacionjala.api.ProjectSteps.ENABLE_INCOMING_EMAILS;
import static org.fundacionjala.api.ProjectSteps.ENABLE_TASKS;
import static org.fundacionjala.api.ProjectSteps.HAS_GOOGLE_DOMAIN;
import static org.fundacionjala.api.ProjectSteps.ID_PROJECTS;
import static org.fundacionjala.api.ProjectSteps.INITIAL_VELOCITY;
import static org.fundacionjala.api.ProjectSteps.ITERATION_LENGTH;
import static org.fundacionjala.api.ProjectSteps.KIND;
import static org.fundacionjala.api.ProjectSteps.NAME;
import static org.fundacionjala.api.ProjectSteps.NUMBER_OF_DONE_ITERATIONS_TO_SHOW;
import static org.fundacionjala.api.ProjectSteps.POINT_SCALE_IS_CUSTOM;
import static org.fundacionjala.api.ProjectSteps.PROJECT_TYPE;
import static org.fundacionjala.api.ProjectSteps.PUBLIC;
import static org.fundacionjala.api.ProjectSteps.START_TIME;
import static org.fundacionjala.api.ProjectSteps.UPDATED_AT;
import static org.fundacionjala.api.ProjectSteps.VELOCITY_AVERAGED_OVER;
import static org.fundacionjala.api.ProjectSteps.VERSION;
import static org.fundacionjala.api.ProjectSteps.WEEK_START_DAY;
import static org.fundacionjala.api.ValidationsCommon.isABoolean;
import static org.fundacionjala.api.ValidationsCommon.isAInt;
import static org.fundacionjala.api.ValidationsCommon.validateId;
import static org.fundacionjala.api.ValidationsCommon.validateKind;
import static org.fundacionjala.api.ValidationsCommon.validateSizeString;
import static org.fundacionjala.api.ValidationsCommon.validateStringDate;
import static org.fundacionjala.api.ValidationsCommon.validateValueIntoList;

/**
 * Created by mijhailvillarroel on 7/21/2016.
 */
public class ValidateProjects {

    private final static List<String> nameDays;
    static {nameDays = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");}

    public static Map<ProjectSteps, Boolean> getAssertionMap(Map<ProjectSteps, Object> values) {
        Map<ProjectSteps, Boolean> strategyMap = new HashMap<>();
        strategyMap.put(ID_PROJECTS, validateSizeString(String.valueOf(values.get(ID_PROJECTS).toString()),50));
        strategyMap.put(KIND,  validateKind(values.get(KIND).toString(),"project"));
        strategyMap.put(NAME, validateSizeString(values.get(NAME).toString(),50));
        strategyMap.put(VERSION, isAInt(values.get(VERSION).toString()));
        strategyMap.put(ITERATION_LENGTH, isAInt(values.get(ITERATION_LENGTH).toString()));
        strategyMap.put(WEEK_START_DAY,  validateValueIntoList(nameDays,values.get(WEEK_START_DAY).toString()));
        strategyMap.put(POINT_SCALE_IS_CUSTOM,  isABoolean(values.get(POINT_SCALE_IS_CUSTOM).toString()));
        strategyMap.put(BUGS_AND_CHORES_ARE_ESTIMATABLE,  isABoolean(values.get(BUGS_AND_CHORES_ARE_ESTIMATABLE).toString()));
        strategyMap.put(AUTOMATIC_PLANNING,  isABoolean(values.get(AUTOMATIC_PLANNING).toString()));
        strategyMap.put(ENABLE_TASKS,  isABoolean(values.get(ENABLE_TASKS).toString()));
        strategyMap.put(VELOCITY_AVERAGED_OVER,  isAInt(values.get(VELOCITY_AVERAGED_OVER).toString()));
        strategyMap.put(NUMBER_OF_DONE_ITERATIONS_TO_SHOW,  isAInt(values.get(NUMBER_OF_DONE_ITERATIONS_TO_SHOW).toString()));
        strategyMap.put(HAS_GOOGLE_DOMAIN,  isABoolean(values.get(HAS_GOOGLE_DOMAIN).toString()));
        strategyMap.put(ENABLE_INCOMING_EMAILS,  isABoolean(values.get(ENABLE_INCOMING_EMAILS).toString()));
        strategyMap.put(INITIAL_VELOCITY,  isAInt(values.get(INITIAL_VELOCITY).toString()));
        strategyMap.put(PUBLIC,  isABoolean(values.get(PUBLIC).toString()));
        strategyMap.put(ATOM_ENABLED,  isABoolean(values.get(ATOM_ENABLED).toString()));
        strategyMap.put(PROJECT_TYPE,  projectType(values.get(PROJECT_TYPE).toString()));
        strategyMap.put(START_TIME,  validateStringDate(values.get(START_TIME).toString()));
        strategyMap.put(CREATED_AT,  validateStringDate(values.get(CREATED_AT).toString()));
        strategyMap.put(UPDATED_AT,  validateStringDate(values.get(UPDATED_AT).toString()));
        strategyMap.put(ACCOUNT_ID,  validateId(values.get(ACCOUNT_ID).toString()));
        strategyMap.put(CURRENT_ITERATION_NUMBER,  isAInt(values.get(CURRENT_ITERATION_NUMBER).toString()));
        strategyMap.put(ENABLE_FOLLOWING,  isABoolean(values.get(ENABLE_FOLLOWING).toString()));
        return strategyMap;
    }

    public static boolean projectType(String projectType) {
        return  projectType.matches("demo|private|public|shared");
    }


}
