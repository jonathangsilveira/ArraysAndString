package com.portfolio.jgsilveira.cesar.arraysandstring.jumbledletters;

public final class JumbledLettersHelper {

    private JumbledLettersHelper() {  }

    public static boolean isPartialPermutation(String first, String second) {
        boolean hasAnyEmpty = isEmpty(first) || isEmpty(second);
        if (hasAnyEmpty) {
            return false;
        }
        boolean isSameSize = first.length() == second.length();
        if (isSameSize) {
            boolean startWithSameChar = first.charAt(0) == second.charAt(0);
            if (startWithSameChar) {
                int length = first.length();
                int differentLettersCount = 0;
                for (int i = 0; i < length; i++) {
                    char character = second.charAt(i);
                    int charIndex = first.indexOf(character);
                    boolean notExists = charIndex == -1;
                    if (notExists) {
                        return false;
                    }
                    boolean isDifferentPosition = charIndex != i;
                    if (isDifferentPosition) {
                        differentLettersCount++;
                    }
                }
                if (length > 3) {
                    double calc = length * (2.0 / 3.0);
                    return differentLettersCount < calc;
                } else {
                    return differentLettersCount > 0;
                }
            }
        }
        return false;
    }

    private static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

}
