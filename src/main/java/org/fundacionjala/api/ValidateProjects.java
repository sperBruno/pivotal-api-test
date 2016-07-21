package org.fundacionjala.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mijhailvillarroel on 7/21/2016.
 */
public class ValidateProjects {
    public Map<ProjectSteps, IAutomationStep> getStrategyStepMap(Map<ProjectSteps, Object> values) {
        Map<ProjectSteps, IAutomationStep> strategyMap = new HashMap<>();
        return strategyMap;
    }

    public boolean validateId(String id) {
        return id.matches("[0-9]{7}");
    }

    public boolean validateSizeString(String word, int size) {
        return word.length() <= size;
    }
}
