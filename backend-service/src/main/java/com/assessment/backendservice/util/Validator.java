package com.merchaint.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        if (email == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

}
