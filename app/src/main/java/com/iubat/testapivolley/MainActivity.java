package com.iubat.testapivolley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView responseText;
    private ProgressBar progressBar;
    private Button fetchButton;

    private static final String API_URL = "https://official-joke-api.appspot.com/random_joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        responseText = findViewById(R.id.responseText);
        progressBar = findViewById(R.id.progressBar);
        fetchButton = findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchDataFromApi();
            }
        });
    }
    private void fetchDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
        responseText.setText("");

        //before adding volley it was showing error but after adding volley
        // in dependency we can use it for api
        RequestQueue queue = Volley.newRequestQueue(this);

        //now let us request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET,API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                responseText.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                responseText.setText("Error: " + error.getMessage());
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }
}