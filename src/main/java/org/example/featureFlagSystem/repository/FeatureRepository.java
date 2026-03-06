package org.example.featureFlagSystem.repository;

import org.example.featureFlagSystem.model.Feature;
import java.util.*;

public class FeatureRepository {

    private final Map<String, Feature> featureStore = new HashMap<>();

    public void addFeature(Feature feature) {
        featureStore.put(feature.getName(), feature);
    }

    public Feature getFeature(String featureName) {
        return featureStore.get(featureName);
    }

    public void removeFeature(String featureName) {
        featureStore.remove(featureName);
    }
}

