package org.example.featureFlagSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Feature {
    private String name;
    private boolean isEnabled;
    List<Rule> rules;
    public Feature(String name, boolean isEnabled) {
        this.name = name;
        this.isEnabled = isEnabled;
        this.rules = new ArrayList<>();
    }
    public boolean isEnabled(){
        return isEnabled;
    }
    public List<Rule> getRules(){
        return  rules;
    }
    public String getName(){
        return name;
    }
}
