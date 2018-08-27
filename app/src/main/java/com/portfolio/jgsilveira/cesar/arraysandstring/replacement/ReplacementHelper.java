package com.portfolio.jgsilveira.cesar.arraysandstring.replacement;

public class ReplacementHelper {

    private static final char SPACE_CHAR = ' ';

    /**
     * This method replaces spaces ({@link ReplacementHelper#SPACE_CHAR}) in a given array of char
     * {@code characteres} by "&32". The {@code characteres} must contain enough positions to hold
     * the additional characters.
     *
     * @param characteres Array of char.
     * @return The output is the same as {@code characteres} but with spaces replaced by "&32".
     */
    public static char[] replaceSpaces(char[] characteres) {
        for (int i = 0; i < characteres.length; i++) {
            char character = characteres[i];
            int lastNonSpaceIndex = lastNonSpaceIndex(characteres);
            if (character == SPACE_CHAR) {
                for (int j = lastNonSpaceIndex; j > i; j--) {
                    char currentChar = characteres[j];
                    int nextIndex = j + 2;
                    characteres[nextIndex] = currentChar;
                }
                characteres[i] = '&';
                characteres[i + 1] = '3';
                characteres[i + 2] = '2';
            }
        }
        return characteres;
    }

    /**
     * It returns the last index of any character different of {@link ReplacementHelper#SPACE_CHAR}.
     * Otherwise, this method will return -1.
     *
     * @param characteres Array of char.
     * @return Index of the last character different of {@link ReplacementHelper#SPACE_CHAR}.
     */
    public static int lastNonSpaceIndex(char[] characteres) {
        if (characteres == null || characteres.length == 0) {
            return -1;
        }
        for (int i = characteres.length - 1; i > -1; i--) {
            char character = characteres[i];
            if (character != SPACE_CHAR) {
                return i;
            }
        }
        return -1;
    }

}
