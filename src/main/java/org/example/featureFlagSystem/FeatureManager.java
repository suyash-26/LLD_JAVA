package org.example.featureFlagSystem;

import org.example.featureFlagSystem.model.Feature;
import org.example.featureFlagSystem.model.User;
import org.example.featureFlagSystem.repository.FeatureRepository;

public class FeatureManager {

    private final FeatureRepository repository;
    private final FeatureEvaluator evaluator;

    public FeatureManager(FeatureRepository repository,
                          FeatureEvaluator evaluator) {
        this.repository = repository;
        this.evaluator = evaluator;
    }

    public boolean isEnabled(String featureName, User user) {
        Feature feature = repository.getFeature(featureName);
        if (feature == null) {
            return false; // fail-safe
        }
        return evaluator.isEnabled(feature, user);
    }
}

