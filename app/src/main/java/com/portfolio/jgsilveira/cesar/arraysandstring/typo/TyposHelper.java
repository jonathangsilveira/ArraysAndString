package com.portfolio.jgsilveira.cesar.arraysandstring.typo;

import android.support.annotation.NonNull;

public final class TyposHelper {

    private TyposHelper() {
    }

    public static boolean hasTypo(String first, String second) {
        if (first.equals(second)) {
            return false;
        }
        int lengthDifference = first.length() - second.length();
        Typo typo = getTypo(lengthDifference);
        int differentCharsCount;
        switch (typo) {
            case INSERT:
                differentCharsCount = validadeInsert(first, second);
                break;
            case REMOVE:
                differentCharsCount = validateRemove(first, second);
                break;
            default:
                differentCharsCount = validateReplace(first, second);
                break;
        }
        return differentCharsCount == 1;
    }

    private static Typo getTypo(int difference) {
        if (difference > 0) {
            return Typo.REMOVE;
        } else if (difference < 0) {
            return Typo.INSERT;
        } else {
            return Typo.REPLACE;
        }
    }

    private static int validadeInsert(@NonNull String first, @NonNull String second) {
        int count = 0;
        int differenceLength = second.length() - first.length();
        StringBuilder builder = new StringBuilder(first);
        while (differenceLength > 0) {
            builder.append(" ");
            differenceLength--;
        }
        first = builder.toString();
        builder = new StringBuilder();
        for (int i = 0; i < second.length(); i++) {
            char character = second.charAt(i);
            char secondChar = first.charAt(i);
            if (character != secondChar) {
                builder.append(first.substring(0, i))
                        .append(character)
                        .append(first.substring(i, first.length() - 1));
                first = builder.toString();
                count++;
            }
        }
        return count;
    }

    private static int validateReplace(@NonNull String first, @NonNull String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            char character = first.charAt(i);
            char secondChar = second.charAt(i);
            if (character != secondChar) {
                count++;
            }
        }
        return count;
    }

    private static int validateRemove(@NonNull String first, @NonNull String second) {
        int count = 0;
        int differenceLength = first.length() - second.length();
        StringBuilder builder = new StringBuilder(second);
        while (differenceLength > 0) {
            builder.append(" ");
            differenceLength--;
        }
        second = builder.toString();
        builder = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            char character = first.charAt(i);
            char secondChar = second.charAt(i);
            if (character != secondChar) {
                builder.append(second.substring(0, i))
                        .append(character)
                        .append(second.substring(i, second.length() - 1));
                second = builder.toString();
                count++;
            }
        }
        return count;
    }

    private enum Typo {

        INSERT, REPLACE, REMOVE

    }

}
