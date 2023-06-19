package com.example.androidlabs;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
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
        //Begin thread
        CatImages req = new CatImages();
        req.execute("http://api.openweathermap.org/data/2.5/uvi?appid=7e943c97096a9784391a981c4d878b22&lat=45.348945&lon=-75.759389"
        );
    }

    class CatImages extends AsyncTask< String, Integer, String> {

        public String doInBackground(String ... args) {
            int x = 0;
            while (x == 0){
            try {
            //create a URL object of what server to contact:
            URL url = new URL(args[0]);
            //open the connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //wait for data:
            InputStream response = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(response, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                String result = sb.toString();
            }
            catch (Exception e)
            {}
            //infinite loop

                //TODO: Implement cat
                //Progress bar can be thought of as %
                //i represnts progress % from 0-100
                for (int i = 0; i < 100; i++) {
                    try {
                        publishProgress(i);
                        Thread.sleep(30);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            return "donetest";
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
