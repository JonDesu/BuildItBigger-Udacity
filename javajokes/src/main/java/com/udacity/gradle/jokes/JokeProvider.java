package com.udacity.gradle.jokes;

import java.util.Random;

/**
 * Created by Jon on 4/13/16.
 */
public class JokeProvider {

    int randomIndex;

    public String[] getJoke(){
        randomIndex = new Random().nextInt(JokeAndAnswer.length);
        return JokeAndAnswer[randomIndex];
    }

    private String[][] JokeAndAnswer = {
        {"Did you hear about the mathematician who’s afraid of negative numbers?","He will stop at nothing to avoid them."},
        {"Why do mathematicians like parks?","Because of all the natural logs."},
        {"What do you call a number that can’t keep still?","A roamin’ numeral."},
        {"Did you hear the one about the statistician?","Probably."},
        {"What did Al Gore play on his guitar?","An Algorithm"},
        {"How do mathematicians scold their children?","“If I’ve told you n times, I’ve told you n+1 times…”"},
        {"Why did the chicken cross the Mobius Strip?","To get to the same side."},
        {"Why don’t Calculus majors throw house parties?","Because you should never drink and derive."},
        {"Have you heard about the mathematical plant?","It has square roots."}
    };
}
