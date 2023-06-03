package com.example.androidlabs;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private Button btn;
    private SharedPreferences sharedPreferences;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String storedValue = sharedPreferences.getString("storedEtString", "");

        //Intent describes how
        Intent nextActivity = new Intent (this, NameActivity.class);
        nextActivity.putExtra("intentStoredValue", storedValue);
        et.setText(storedValue);

        //On button click, go to next view and pass the entered text along to the next view via INTENT
        btn.setOnClickListener(view -> {
            String enteredName = et.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("name", enteredName);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        String etString = et.getText().toString();
        sharedPreferences.edit().putString("name", etString).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //If requestCode is 0, the text is blank (not the right name!)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 0) {
                et.setText("");
                //If requestCode is 1, ends the program!
            } else if (resultCode == 1) {
                finish();
            }
        }
    }
}
