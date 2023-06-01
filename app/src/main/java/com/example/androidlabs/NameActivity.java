package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent dataSent = getIntent();
        String nameSent = dataSent.getStringExtra("intentStoredValue");

        TextView tv = findViewById(R.id.textView2);
        String welcome = (String) tv.getText();

                        //Debug toast
                        //Toast bobb = Toast.makeText(this,welcome, Toast.LENGTH_LONG);
                        //bobb.show();

        tv.setText(welcome + " " + nameSent);



                        //Debug toast
                        //Toast bob = Toast.makeText(this,nameSent, Toast.LENGTH_LONG);
                        //bob.show();



        //Previous button
        Button previousButton = findViewById(R.id.button2);
        //Confirmation button
        Button confirmationButton = findViewById(R.id.button3);

        previousButton.setOnClickListener(click -> {
            setResult(0, dataSent);
            finish();
        });

        confirmationButton.setOnClickListener(click -> {
            setResult(1, dataSent);
            finish();
        });


    }
}