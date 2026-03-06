package org.example.featureFlagSystem.model;

import java.util.Set;

public class UserIdRule implements Rule{
    Set<Integer> allowedUserIds;
    public boolean evaluate(User user){
        return false;
    }
}
