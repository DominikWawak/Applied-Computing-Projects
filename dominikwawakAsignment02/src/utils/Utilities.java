package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    public static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    public static String max20Chars(String string) {

        return (string.length() <= 20) ? string : string.substring(0, 20);
    }

    static String validPPSNumber(String string) {

        return (string.length() <= 8) ? string : string.substring(0, 8);
    }

    public static boolean validEmail(String email) {
        return (email.contains("@") && email.contains("."));
    }

    static boolean validIntRange(int start, int end, int value) {
        return ((value >= start) && (value <= end));
    }

    static boolean validIntNonNegative(int number) {
        return (number >= 0);
    }

    public static boolean validDoubleNonNegative(Double number) {
        return (number >= 0);
    }

    static String validGenre(String genre) {
        genre = genre.toUpperCase();
        List<String> genres = Arrays.asList("RIGHT", "LEFT", "EXTREME RIGHT", "EXTREME LEFT", "CENTRE", "UNCATEGORISED");
        return (genres.contains(genre)) ? genre : "unknown";
    }


    public static boolean validIndex(int index, ArrayList list) {
        return (index >= 0 && index < list.size());
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

}