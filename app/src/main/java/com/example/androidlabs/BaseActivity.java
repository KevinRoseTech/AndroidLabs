package com.example.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setupToolbar();
        setupNavigationDrawer();
    }
    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
        String toast1 = getString(R.string.button_toast1);
        //uses String resource instead of hardcoded message now
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast1, Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        String toast2 = getString(R.string.button_toast2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void setupNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_nav, R.string.close_nav);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //Changed from a switch in the example to an if/else because of compat issues.
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(BaseActivity.this, MainActivity.class));
                } else if (id == R.id.nav_dad_joke) {
                    startActivity(new Intent(BaseActivity.this, DadJoke.class));
                } else if (id == R.id.nav_exit) {
                    finishAffinity();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
