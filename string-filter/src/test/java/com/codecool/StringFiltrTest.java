package com.codecool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


public class StringFiltrTest {

    @Test
    public void testFiltrateWithOnePredicate() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = new ArrayList<>();
        rules.add((word) -> (word.equals("karol")));
        List<String> words = Arrays.asList("karol", "adrian", "krzysiek");
        List<String> expected = Collections.singletonList("karol");

        List<String> actual = filtr.filtrate(rules, words);

        assertThat(actual, is(expected));
    }

    @Test
    public void testFiltrateWithThreePredicates() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = getRules();
        List<String> words = Arrays.asList("karol", "adrian", "krzysiek");
        List<String> expected = Collections.singletonList("karol");

        List<String> actual = filtr.filtrate(rules, words);

        assertThat(actual, is(expected));
    }

    @Test
    public void testPassThreshold() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = getRules();

        boolean actual = filtr.passThreshold("dupa", rules, 0.5);

        assertTrue(actual);
    }

    private List<Predicate<String>> getRules() {
        List<Predicate<String>> rules = new ArrayList<>();
        rules.add((word) -> (word.equals("karol")));
        rules.add(word -> (word.length() > 2));
        rules.add((word) -> (word.length() > 3));
        return rules;
    }

    @Test
    public void testFailThreshold() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = getRules();

        boolean actual = filtr.passThreshold("dup", rules, 0.5);

        assertFalse(actual);
    }

    @Test
    public void testFiltrateWithThresholdAllPass() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = getRules();

        List<String> words = Arrays.asList("karol", "adrian", "krzysiek");
        List<String> expected = words;

        List<String> actual = filtr.filtrate(rules, words, 0.6);

        assertThat(actual, is(expected));
    }

    @Test
    public void testFiltrateWithThresholdOnePass() {
        StringFiltr filtr = new StringFiltr();
        List<Predicate<String>> rules = getRules();

        List<String> words = Arrays.asList("karol", "adrian", "krzysiek");
        List<String> expected = Collections.singletonList("karol");

        List<String> actual = filtr.filtrate(rules, words, 0.8);

        assertThat(actual, is(expected));
    }
}
