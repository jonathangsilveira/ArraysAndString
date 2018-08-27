package com.portfolio.jgsilveira.cesar.arraysandstring.typo;

import org.junit.Assert;
import org.junit.Test;

import static com.portfolio.jgsilveira.cesar.arraysandstring.typo.TyposHelper.hasTypo;

public class TypoTest {

    @Test
    public void hasTypo_remove() {
        String first = "pale";
        String second = "ple";

        Assert.assertTrue(hasTypo(first, second));
    }

    @Test
    public void hasTypo_removeAndReplace() {
        String first = "blake";
        String second = "fake";

        Assert.assertFalse(hasTypo(first, second));
    }

    @Test
    public void hasTypo_replace() {
        String first = "bake";
        String second = "fake";

        Assert.assertTrue(hasTypo(first, second));
    }

    @Test
    public void hasTypo_insert() {
        String first = "bake";
        String second = "bakes";

        Assert.assertTrue(hasTypo(first, second));
    }

    @Test
    public void hasTypo_insertInvalid() {
        String first = "glass";
        String second = "glasses";

        Assert.assertFalse(hasTypo(first, second));
    }

}
