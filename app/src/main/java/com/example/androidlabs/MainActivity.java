package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Button btn = findViewById(R.id.button2);
        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editText);

        btn.setOnClickListener((click) -> {btn.setText("You clicked me");});
        btn.setOnClickListener((click) -> {tv.setText(et.getText());});










    }
}