package com.balancer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdValidator {

    private static final Pattern pattern = Pattern.compile("^[\\p{Alnum}]+$");
    private IdValidator(){}

    public static boolean validateId(String userId){
        Matcher matcher = pattern.matcher(userId);
        return matcher.matches();
    }
}
