package com.example.androidlabs;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import java.io.BufferedReader;
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
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        new DownloadImageTask().execute("https://cataas.com/cat?json=true");
    }

    private class DownloadImageTask extends AsyncTask<String, Bitmap, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            while (true) {
                Bitmap bitmap = null;
                try {
                    //Download JSON.
                    URL url = new URL(urls[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream response = urlConnection.getInputStream();
                    //Builds the JSON to a string
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    String result = sb.toString();
                    //Parses JSON string.
                    JSONObject catObject = new JSONObject(result);
                    String imageUrl = "https://cataas.com" + catObject.getString("url");
                    //Downloads image and publishes progress as a bitmap
                    InputStream in = new URL(imageUrl).openStream();
                    bitmap = BitmapFactory.decodeStream(in);
                    publishProgress(bitmap);
                    //Sleeps bitmap for 5 seconds
                    //TODO: Get progress bar to sync with it
                    Thread.sleep(5000);
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Bitmap... values) {
            imageView.setImageBitmap(values[0]);
            progressBar.setProgress(0);
            //TODO: Fix progressbar, needs to be done in here as previous method passes Bitmap progress...
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        try {
                            //running for 5 seconds, 5 loops, sleep for 1 second
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        int finalI = i;
                        progressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress((finalI + 1) * 1000);
                            }
                        });
                    }
                }
            }).start();
        }
        protected void onPostExecute(Bitmap ... result){
            //Not needed, we are looping this indefinitely?
        }
    }
}