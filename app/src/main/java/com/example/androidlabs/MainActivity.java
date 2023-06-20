package com.example.androidlabs;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView); // Replace with your ImageView's id.
        progressBar = findViewById(R.id.progressBar); // Replace with your ProgressBar's id.

        new DownloadImageTask().execute("https://cataas.com/cat?json=true");
    }

    private class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap bitmap = null;
            try {
                // Download JSON.
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream response = urlConnection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(response, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line;
                int progress = 0;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");

                    // This is a dummy progress update for the example. You'd have to calculate the actual progress based on the data you have.
                    progress += 10;
                    publishProgress(progress);
                }
                String result = sb.toString();

                // Parse JSON.
                JSONObject catObject = new JSONObject(result);
                String imageUrl = "https://cataas.com" + catObject.getString("url");

                // Download image.
                InputStream in = new URL(imageUrl).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Update the progress bar.
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Hide the progress bar when finished.
            progressBar.setVisibility(View.GONE);
            // Set the image to the ImageView.
            imageView.setImageBitmap(result);
        }
    }
}