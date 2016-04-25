package com.udacity.gradle.builditbigger;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by Jon on 4/17/16.
 */
public class JokeService{

    private final static String url = "https://gcetestapp.appspot.com/_ah/api/myApi/v1/myjoke";
    private static RequestQueue queue;

    public JokeService(final JokeCallback callback, Context context){

        if(queue == null) queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    callback.onSuccessResponse(response);
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error.toString());
            }
        });

        queue.add(jsonObjectRequest);
    }
}




