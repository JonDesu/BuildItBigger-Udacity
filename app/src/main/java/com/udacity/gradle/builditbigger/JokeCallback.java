package com.udacity.gradle.builditbigger;

import org.json.JSONObject;

public interface JokeCallback {
        void onSuccessResponse(JSONObject result);
        void onErrorResponse(String result);
}
