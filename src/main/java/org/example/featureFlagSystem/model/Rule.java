package org.example.featureFlagSystem.model;

public interface Rule {
    boolean evaluate(User user);
}
