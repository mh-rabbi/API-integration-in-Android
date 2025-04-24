package com.iubat.testapivolley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView responseText;
    private ProgressBar progressBar;
    private Button fetchButton;

    private static final String API_URL = "https://api.example.com/data";
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

            }
        });
    }
    private void fetchDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
        responseText.setText("");




    }

}