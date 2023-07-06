package com.example.androidlabs;

import android.os.Bundle;
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupNavigationDrawer();
    }
}
//TODO: Change title to app name string
//TODO: Localize to french(?)
//TODO: Remove menu with menu icon
//TODO: Make Dad Activity work when clicked and add dad joke
