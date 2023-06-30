package com.example.androidlabs;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> cL;
    private ArrayAdapter<String> aA;
    private ListView lV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cL = new ArrayList<>();
        lV = findViewById(R.id.list_view);
        aA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        lV.setAdapter(aA);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FrameLayout frameLayout = findViewById(R.id.fragment_container);

                //lack of frame layout denotes phone, else its a tablet
                //todo: need to review this as tablet functionality is broken...
                if (frameLayout == null) {
                    // We're on a phone - start EmptyActivity
                    Intent intent = new Intent(MainActivity.this, EmptyActivity.class);
                    intent.putExtra("name", cL.get(position).get("name"));
                    intent.putExtra("height", cL.get(position).get("height"));
                    intent.putExtra("mass", cL.get(position).get("mass"));
                    startActivity(intent);
                } else {
                    // We're on a tablet - show fragment
                    DetailsFragment detailsFragment = new DetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", cL.get(position).get("name"));
                    bundle.putString("height", cL.get(position).get("height"));
                    bundle.putString("mass", cL.get(position).get("mass"));
                    detailsFragment.setArguments(bundle);

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, detailsFragment);
                    ft.commit();
                }
            }
        });
        new FetchCharactersTask().execute();
    }

    private class FetchCharactersTask extends AsyncTask<Void, Void, Void> {

        //json info getter
        @Override
        protected Void doInBackground(Void... params) {
            String strUrl = "https://swapi.dev/api/people/?format=json";
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(strUrl);
                urlConnection = (HttpURLConnection) url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuffer = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject character = jsonArray.getJSONObject(i);
                    HashMap<String, String> cM = new HashMap<>();
                    cM.put("name", character.getString("name"));
                    cM.put("height", character.getString("height"));
                    cM.put("mass", character.getString("mass"));
                    cL.add(cM);
                }

                bufferedReader.close();
            } catch (Exception e) {
                Log.e("MainActivity", "Error ", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        //ui update via async
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> cN = new ArrayList<>();
            for (HashMap<String, String> character : cL) {
                cN.add(character.get("name"));
            }
            aA.clear();
            aA.addAll(cN);
            aA.notifyDataSetChanged();
        }
        }
    }

