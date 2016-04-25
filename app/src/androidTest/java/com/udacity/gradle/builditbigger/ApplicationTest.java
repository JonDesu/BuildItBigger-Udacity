package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.json.JSONObject;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase{
    public void testJokeService(){
        JokeService jService = new JokeService(new JokeCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {
                assertNotNull(result.toString());
            }

            @Override
            public void onErrorResponse(String result) {
                assertTrue(false);
            }
        },getContext());
    }
}