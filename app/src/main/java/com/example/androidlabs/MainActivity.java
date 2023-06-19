package com.example.androidlabs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar);

        CatImages req = new CatImages();
        req.execute("http://Torunski.ca/CST2335_XML.xml"

        );

    }

    class CatImages extends AsyncTask< String, Integer, String> {

        public String doInBackground(String ... args) {
            try {
            //create a URL object of what server to contact:
            URL url = new URL(args[0]);

            //open the connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //wait for data:
            InputStream response = urlConnection.getInputStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput( response , "UTF-8");


            }
            catch (Exception e)
            {

            }




            //infinite loop
            //int x = 0;
            //while (x == 0){
                //TODO: Implement cat
                //return "Done";
            //}

            for (int i = 0; i < 100; i++) {
                try {
                    publishProgress(i);
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return "done";
        }
        public void onProgressUpdate(Integer ... args)
        {
            super.onProgressUpdate(args);

            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(args[0]);
        }
        //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i("HTTP", fromDoInBackground);
        }
    }

}
