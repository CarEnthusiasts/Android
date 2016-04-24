package carenthusiasts.andriod;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {
    ListView list;
    TextView ver;
    TextView name;
    TextView api;
    Button Btngetdata;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> searchOslist = new ArrayList<HashMap<String, String>>();

    //JSON Node Names
    private static final String TAG_OS = "android";
    private static final String TAG_VER = "ver";
    private static final String TAG_NAME = "name";
    private static final String TAG_API = "api";

    JSONArray android = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadcars(savedInstanceState);
    }
    private void loadcars(Bundle savedInstanceState){
        oslist = new ArrayList<HashMap<String, String>>();

        searchOslist = new ArrayList<HashMap<String, String>>();
//        new JSONParseCars().execute();
//        new JSONParseSearch().execute();
    }
/*
    private class JSONParseCars extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ver = (TextView)findViewById(R.id.vers);
            name = (TextView)findViewById(R.id.name);
            api = (TextView)findViewById(R.id.api);
            pDialog = new ProgressDialog(ProfileActivity.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... arg0) {

            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                link ="http://192.168.0.6/example/getinfo.php";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }


        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        String resultString = jsonArray.getString(i);
                        JSONObject jsonObj = new JSONObject(resultString);
                        String ver = jsonObj.getString("id");
                        String name = jsonObj.getString("fullname");
                        String api = jsonObj.getString("username");

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_VER, ver);
                        map.put(TAG_NAME, name);
                        map.put(TAG_API, api);

                        oslist.add(map);
                        list=(ListView)findViewById(R.id.listCars);

                        ListAdapter adapter = new SimpleAdapter(ProfileActivity.this, oslist,
                                R.layout.list_cars,
                                new String[] { TAG_VER,TAG_NAME, TAG_API }, new int[] {
                                R.id.vers,R.id.name, R.id.api});

                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Toast.makeText(ProfileActivity.this, "You Clicked at " + oslist.get(+position).get("name"), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ProfileActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class JSONParseSearch extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ver = (TextView)findViewById(R.id.vers);
            pDialog = new ProgressDialog(ProfileActivity.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... arg0) {

            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                link ="http://192.168.0.6/example/getinfo.php";
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }


        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        String resultString = jsonArray.getString(i);
                        JSONObject jsonObj = new JSONObject(resultString);
                        String ver = jsonObj.getString("fullname");

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_VER, ver);


                        searchOslist.add(map);
                        list=(ListView)findViewById(R.id.listSearch);

                        ListAdapter adapter = new SimpleAdapter(ProfileActivity.this, searchOslist,
                                R.layout.list_searchs,
                                new String[] { TAG_VER,TAG_NAME, TAG_API }, new int[] {
                                R.id.vers,R.id.name, R.id.api});

                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Toast.makeText(ProfileActivity.this, "You Clicked at " + searchOslist.get(+position).get("name"), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ProfileActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }*/
}
