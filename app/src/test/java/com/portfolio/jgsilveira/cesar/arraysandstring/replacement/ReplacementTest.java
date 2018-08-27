package com.portfolio.jgsilveira.cesar.arraysandstring.replacement;

import org.junit.Assert;
import org.junit.Test;

public class ReplacementTest {

    @Test
    public void replaceSpaces_success() {
        String input = "User is not allowed      ";
        String output = "User&32is&32not&32allowed";
        char[] characters = input.toCharArray();
        char[] expectedCharacters = output.toCharArray();

        char[] actualCharacters = ReplacementHelper.replaceSpaces(characters);

        Assert.assertEquals(String.valueOf(expectedCharacters), String.valueOf(actualCharacters));
    }

    @Test
    public void lastNonSpaceIndex_success() {
        String input = "User is not allowed      ";
        char[] characters = input.toCharArray();
        int expectedLastNonSpaceIndex = 18;

        int actualLastNonSpaceIndex = ReplacementHelper.lastNonSpaceIndex(characters);

        Assert.assertEquals(expectedLastNonSpaceIndex, actualLastNonSpaceIndex);
    }

    @Test
    public void lastNonSpaceIndex_emptyArray() {
        String input = "";
        char[] characters = input.toCharArray();
        int expectedLastNonSpaceIndex = -1;

        int actualLastNonSpaceIndex = ReplacementHelper.lastNonSpaceIndex(characters);

        Assert.assertEquals(expectedLastNonSpaceIndex, actualLastNonSpaceIndex);
    }

    @Test
    public void lastNonSpaceIndex_onlySpaces() {
        String input = " ";
        char[] characters = input.toCharArray();
        int expectedLastNonSpaceIndex = -1;

        int actualLastNonSpaceIndex = ReplacementHelper.lastNonSpaceIndex(characters);

        Assert.assertEquals(expectedLastNonSpaceIndex, actualLastNonSpaceIndex);
    }

}
