package com.example.androidlabs;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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

    class CatImages extends AsyncTask< String, Integer, String> {

        public String doInBackground(String ... args) {
            //infinite loop
            int x = 0;
            while (x == 0){
                //TODO: Implement cat
                publishProgress(25);
                publishProgress(50);
                publishProgress(75);
                return "Done";
            }

            for (int i = 0; i < 100; i++) {
                try {
                    publishProgress(i);
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
        public void onProgressUpdate(Integer ... args)
        {

        }
        //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i("HTTP", fromDoInBackground);
        }
    }

}
