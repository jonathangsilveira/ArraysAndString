package com.portfolio.jgsilveira.cesar.arraysandstring.jumbledletters;

import org.junit.Assert;
import org.junit.Test;

import static com.portfolio.jgsilveira.cesar.arraysandstring.jumbledletters.JumbledLettersHelper.isPartialPermutation;

public class JumbledLettersTest {

    @Test
    public void isPartialPermutation_success() {
        String first = "you";
        String second = "yuo";

        Assert.assertTrue(isPartialPermutation(first, second));

        first = "probably";
        second = "porbalby";

        Assert.assertTrue(isPartialPermutation(first, second));

        first = "despite";
        second = "desptie";

        Assert.assertTrue(isPartialPermutation(first, second));

        first = "moon";
        second = "nmoo";

        Assert.assertFalse(isPartialPermutation(first, second));

        first = "misspellings";
        second = "mpeissngslli";

        Assert.assertFalse(isPartialPermutation(first, second));
    }



}
