package com.udacity.gradle.jokes.test;

import com.udacity.gradle.jokes.JokeProvider;

import org.junit.Test;

public class JokeProviderTest {
    @Test
    public void test() {
        JokeProvider joker = new JokeProvider();
        assert joker.getJoke().length != 0;
    }
}