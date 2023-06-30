package com.example.androidlabs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    TextView ntv;
    TextView htv;
    TextView mtv;
    //Empty constructor
    public DetailsFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflates the fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ntv = view.findViewById(R.id.name);
        htv = view.findViewById(R.id.height);
        mtv = view.findViewById(R.id.mass);

        //Passing arguments to fragment
        Bundle bundle = getArguments();
        if(bundle != null) {
            // If the bundle isn't null, set the TextViews to the correct values
            ntv.setText(bundle.getString("name"));
            htv.setText(bundle.getString("height"));
            mtv.setText(bundle.getString("mass"));
        }
        return view;
    }
}
