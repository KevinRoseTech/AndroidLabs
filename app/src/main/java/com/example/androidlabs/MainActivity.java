package com.example.androidlabs;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    class CatImages extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            //infinite loop
            int x = 0;
            while (x == 0){
                //play cat images
            }
            return null;

        }
    }

}
