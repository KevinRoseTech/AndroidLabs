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
        int durationSB = Snackbar.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), tt, duration);
        String chkOn = getResources().getString(R.string.checkbox_on);
        String chkOff = getResources().getString(R.string.checkbox_off);
        String chkUnknown = getResources().getString(R.string.checkbox_unknown);
        String chkMessage = getResources().getString(R.string.checkbox_status);
        CheckBox cb = findViewById(R.id.checkBox);
        String chkStatus;




        // Chains the actions in one button click listen
        btn.setOnClickListener((click) -> {tv.setText(et.getText());toast.show();});
        cb.setOnCheckedChangeListener(((buttonView, isChecked) -> {Snackbar.make(cb,chkMessage + chkOn, durationSB).setAction("Undo", click->cb.setChecked( !true )).show();}));


    }

}