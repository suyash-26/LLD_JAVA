package org.example.featureFlagSystem;

import org.example.featureFlagSystem.model.Feature;
import org.example.featureFlagSystem.model.Rule;
import org.example.featureFlagSystem.model.User;

public class FeatureEvaluator {
    public boolean isEnabled(Feature feature, User user) {
        if (!feature.isEnabled()) return false;

        for (Rule rule : feature.getRules()) {
            if (rule.evaluate(user)) {
                return true;
            }
        }
        return false;
    }
}
