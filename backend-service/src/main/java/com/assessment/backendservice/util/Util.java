package com.merchaint.api.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Util {

    public static final Pattern numericPattern = Pattern.compile("(-?\\.?\\d+(\\.\\d+)?)");

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static int randomInt(double min, double max) {
        return (int) randomNumber(min, max);
    }

    public static double randomNumber(double min, double max) {
        return Math.random() * (max - min + 1) + min;
    }

    public static String randomString(int length, boolean alphaNumeric) {
        int leftLimit = 'a';
        int rightLimit = 'z';
        if (alphaNumeric)
            leftLimit = '0';

        IntStream intStream = new Random().ints(leftLimit, rightLimit + 1);
        if (alphaNumeric)
            intStream = intStream.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97));

        return intStream.limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        return numericPattern.matcher(strNum).matches();
    }

    /**
     * Array Reverse <br>
     * Reverse Array In Place
     * @param array Array of Objects
     **/
    public static void reverseArray(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static String getExtension(String name) {
        return name.substring(name.lastIndexOf('.'));
    }


    public static Integer extractInteger(String string) {
        if (string == null) return null;
        Matcher matcher = numericPattern.matcher(string);
        if (matcher.find()) {
            return (int) Double.parseDouble(matcher.group());
        }
        return null;
    }

    public static BigDecimal extractBigDecimal(String string) {
        if (string == null) return null;
        string = string.replaceAll("[,$]", "").trim();
        Matcher matcher = numericPattern.matcher(string);
        if (matcher.find()) {
            return new BigDecimal(matcher.group());
        }
        return null;
    }

}
