package com.example.androidlabs;

import androidx.annotation.Nullable;
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

        SharedPreferences bobb = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String storedValue = bobb.getString("storedEtString", "");

                            //Debug toast
                            Toast bob = Toast.makeText(this,storedValue, Toast.LENGTH_LONG);
                            bob.show();

        //Next activity
        Intent nextActivity = new Intent (this, NameActivity.class);
        nextActivity.putExtra("intentStoredValue", storedValue);

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
        String test = prefs.getString("StoredEtString", "");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1) {
            finish();
        }else {
        }

        }
    }

