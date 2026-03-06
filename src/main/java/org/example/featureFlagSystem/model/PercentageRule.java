package org.example.featureFlagSystem.model;

public class PercentageRule implements Rule{
    public boolean evaluate(User user){
        return true;
    }
}
