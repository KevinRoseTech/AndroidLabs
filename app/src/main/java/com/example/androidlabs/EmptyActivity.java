package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        // Get data passed from MainActivity
        Bundle bundle = getIntent().getExtras();

        // Create new instance of DetailsFragment
        DetailsFragment detailsFragment = new DetailsFragment();
        // Pass the bundle to the fragment
        detailsFragment.setArguments(bundle);

        // Begin Fragment transaction.
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.fragment_container, detailsFragment);
        fT.commit();
    }
}
