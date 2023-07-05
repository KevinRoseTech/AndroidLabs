package com.example.androidlabs;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tBar = findViewById(R.id.toolbar);
        //This loads the toolbar, which calls onCreateOptionsMenu below:
        setSupportActionBar(tBar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drawer, menu);
        return true;
    }


    //Changed from a switch in the example to and if/else because of compat issues.
    //Todo: Research compat issues better before submission
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            String message = "Redirecting to home!";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.nav_dad_joke) {
            String message = "Redirecting to Dad Jokes!";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.nav_exit) {
            String message = "You clicked on exit. Goodbye!";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
