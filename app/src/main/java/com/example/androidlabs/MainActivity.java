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


//todo: manually update each toast message and menu drawer with the constant string
