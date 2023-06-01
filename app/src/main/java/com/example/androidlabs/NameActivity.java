package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent dataSent = getIntent();
        //String nameSent = dataSent.getStringExtra("storedEtString");
        //String formatNameSent = String.format(nameSent);
        //dataSent.getStringExtra("storedEtString");



        //Previous button
        Button previousButton = findViewById(R.id.button2);
        //Confirmation button
        Button confirmationButton = findViewById(R.id.button3);

        previousButton.setOnClickListener(click -> {
            setResult(0, dataSent);
            finish();
        });


    }
}