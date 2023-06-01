package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = findViewById(R.id.button);
        EditText et = findViewById(R.id.editText);

        Intent nextActivity = new Intent (this, NameActivity.class);
        nextActivity.putExtra("name", et.getText());
        btn.setOnClickListener( click -> startActivityForResult( nextActivity, 123));
        }

    @Override
    protected void onPause() {
        super.onPause();
        EditText et = findViewById(R.id.editText);
        String etString = et.getText().toString();
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("storedEtString", etString);
        edit.commit();

        Toast bob = Toast.makeText(this,etString, Toast.LENGTH_LONG);

        bob.show();
    }
}
