package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Button btn = findViewById(R.id.button2);
        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editText);
        String tt = getResources().getString(R.string.toast_message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), tt, duration);
        String chkOn = getResources().getString(R.string.checkbox_on);
        String chkMessage = getResources().getString(R.string.checkbox_status);
        CheckBox cb = findViewById(R.id.checkBox);
        String chkOff = getResources().getString(R.string.checkbox_off);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Makes the message variable equal to the corresponding localized String, depending on whether checkbox is on or off.
                String message = isChecked ? chkOn : chkOff;

                //Displays the localized default string message with the localized on/off String message, including an undo that sets the checkbox to unchecked (however, does not undo an uncheck)
                Snackbar.make(buttonView, chkMessage + " " + message, Snackbar.LENGTH_SHORT).setAction("Undo", click -> cb.setChecked(!true)).show();
            }
        });

        //Makes the text view take the edit text and make it the new text view text
        btn.setOnClickListener((click) -> {
            tv.setText(et.getText());
            toast.show();
        });
    }
}