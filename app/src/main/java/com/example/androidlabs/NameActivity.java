package com.example.androidlabs;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {
    private TextView tvv;
    private Button previousButton;
    private Button confirmationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        tvv = findViewById(R.id.textView2);

        //Previous button
        previousButton = findViewById(R.id.button2);
        confirmationButton = findViewById(R.id.button3);
        Intent dataSent = getIntent();
        String nameSent = dataSent.getStringExtra("name");

        tvv.setText("welcome " +  nameSent);

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