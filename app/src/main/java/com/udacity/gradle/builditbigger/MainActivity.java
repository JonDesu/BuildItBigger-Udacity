package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.gradle.JokeActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final static String url = "https://gcetestapp.appspot.com/_ah/api/myApi/v1/myjoke";
    private final static String EXTRA_QUESTION = "com.udacity.gradle.QUESTION";
    private final static String EXTRA_ANSWER = "com.udacity.gradle.ANSWER";
    private final static String REQUEST_TAG = "MainVolleyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        TextView tView = (TextView)findViewById(R.id.mainButton);
        tView.setText("Get Joke!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        TextView txtView = (TextView) view;
        txtView.setText("BUSY...");

        JokeService jokeService = new JokeService(new JokeCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {
                String question;
                String answer;
                try{
                    question = result.getString("currentQuestion");
                    answer = result.getString("currentAnswer");
                }
                catch (JSONException e){
                    question = "Uh oh! An unexpected error occured.";
                    answer = e.toString();
                }

                Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
                intent.putExtra(EXTRA_QUESTION,question);
                intent.putExtra(EXTRA_ANSWER,answer);
                startActivity(intent);

            }
            @Override
            public void onErrorResponse(String result){
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT);
            }
        },this);
    }
}
