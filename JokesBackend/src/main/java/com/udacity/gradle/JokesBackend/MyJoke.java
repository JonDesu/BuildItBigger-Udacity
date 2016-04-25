package com.udacity.gradle.JokesBackend;

import com.udacity.gradle.jokes.JokeProvider;

/** The object model for the data we are sending through endpoints */

public class MyJoke{

    private static JokeProvider joker;
    private String myCurrentQuestion;
    private String myCurrentAnswer;

    public void getJoke() {
        if (joker == null) joker = new JokeProvider();
        String[] currentJoke = joker.getJoke();
        setMyCurrentQuestion(currentJoke[0]);
        setMyCurrentAnswer(currentJoke[1]);
    }

    public String getCurrentQuestion(){
        return myCurrentQuestion;
    }

    public String getCurrentAnswer(){
        return myCurrentAnswer;
    }

    private void setMyCurrentQuestion(String q){
        this.myCurrentQuestion = q;
    }

    private void setMyCurrentAnswer(String a){
        this.myCurrentAnswer = a;
    }
}
