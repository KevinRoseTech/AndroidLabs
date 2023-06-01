package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = findViewById(R.id.button);
        EditText et = findViewById(R.id.editText);

        Intent nextActivity = new Intent (this, NameActivity.class);
        View.OnClickListener( click -> startActivityForResult(nextActivity, int code));


        }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences(String fileName, int mode);

    }

}
}