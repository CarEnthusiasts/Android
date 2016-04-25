package carenthusiasts.andriod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class CarPageActivity extends AppCompatActivity {

    ListView list;
    TextView tagname;
    TextView tagdescription;

    //xml elements of the page
    ImageView carimage ;
    TextView price;
    TextView make;
    TextView model;
    TextView year;
    TextView mileage;
    TextView exterior;
    TextView bodystyle;
    TextView seats;
    TextView interior;
    TextView drivetrain;
    TextView transmission;
    TextView displacement;
    TextView cylinders;
    TextView hp;
    TextView tq;
    TextView fuel;
    TextView zerosixty;
    TextView topspeed;
    TextView sixtyzero;
    TextView email;

    Drawable drawable;

    TextView api;
    Button Btngetdata;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    //JSON Node Names
    private static final String TAG_TAG = "tag";
    private static final String TAG_DESC = "description";

    private String carid;

    JSONArray android = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        carid = i.getStringExtra("CARID");
        i.removeExtra("CARID");
        setContentView(R.layout.activity_car_page);
        loadPage();
        loadTags();
    }
    private void loadPage(){
        new JSONParsePage().execute();
    }
    private void loadTags(){
        oslist = new ArrayList<HashMap<String, String>>();
        new JSONParseTags().execute();
    }
    private class JSONParsePage extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            carimage = (ImageView) findViewById(R.id.CarImage) ;
             price = (TextView) findViewById(R.id.priceText);
             make = (TextView) findViewById(R.id.makeText);
             model = (TextView) findViewById(R.id.modelText);
             year = (TextView) findViewById(R.id.yearText);
             mileage = (TextView) findViewById(R.id.mileageText);
             exterior = (TextView) findViewById(R.id.exteriorColorText);
             bodystyle = (TextView) findViewById(R.id.bodyStyleText);
             seats = (TextView) findViewById(R.id.seatsText);
             interior = (TextView) findViewById(R.id.interiorColorText);
             drivetrain = (TextView) findViewById(R.id.drivetrainText);
             transmission = (TextView) findViewById(R.id.transmissionText);
             displacement = (TextView) findViewById(R.id.engineDisplacementText);
             cylinders = (TextView) findViewById(R.id.cylinderText);
             hp = (TextView) findViewById(R.id.horsepowerText);
             tq = (TextView) findViewById(R.id.torqueText);
             fuel = (TextView) findViewById(R.id.fuelText);
             zerosixty = (TextView) findViewById(R.id.zeroSixtyText);
             topspeed = (TextView) findViewById(R.id.topSpeedText);
             sixtyzero = (TextView) findViewById(R.id.SixtyZeroText);
            email = (TextView) findViewById(R.id.emailText);

            pDialog = new ProgressDialog(CarPageActivity.this);
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

                data = "?carid="+ URLEncoder.encode(carid, "UTF-8");
                link ="http://192.168.0.6/carenthusiasts/getcarpage.php"+ data;
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

                        String imageuri = jsonObj.getString("picture");
                        /*if(imageuri.equals("NULL")){
                            drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                        }
                        else{
                            try {
                                Uri myUri = Uri.parse(imageuri);
                                FileInputStream fis = new FileInputStream(new File("content://media/external/images/media/9382"));
                                drawable = Drawable.createFromPath(fis.toString());
                                fis.close();
                            } catch (Exception e) {
                                Toast.makeText(CarPageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                            }
                        }*/
                        
                        carimage.setImageDrawable(drawable);
                        price.setText(jsonObj.getString("price"));
                        make.setText(jsonObj.getString("make"));
                        model.setText(jsonObj.getString("model"));
                        year.setText(jsonObj.getString("yearmade"));
                        mileage.setText(jsonObj.getString("mileage"));
                        exterior.setText(jsonObj.getString("exterior"));
                        bodystyle.setText(jsonObj.getString("bodytype"));
                        seats.setText(jsonObj.getString("seats"));
                        interior.setText(jsonObj.getString("interior"));
                        drivetrain.setText(jsonObj.getString("drivetrain"));
                        transmission.setText(jsonObj.getString("transmission"));
                        displacement.setText(jsonObj.getString("displacement"));
                        cylinders.setText(jsonObj.getString("cylinders"));
                        hp.setText(jsonObj.getString("hp"));
                        tq.setText(jsonObj.getString("tq"));
                        fuel.setText(jsonObj.getString("fuel"));
                        zerosixty.setText(jsonObj.getString("zerosixty"));
                        topspeed.setText(jsonObj.getString("topspeed"));
                        sixtyzero.setText(jsonObj.getString("sixtyzero"));
                        email.setText(jsonObj.getString("userid"));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(CarPageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CarPageActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class JSONParseTags extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tagname = (TextView)findViewById(R.id.tagname);
            tagdescription = (TextView)findViewById(R.id.tagdescription);

            pDialog = new ProgressDialog(CarPageActivity.this);
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
                data= "?carid="+URLEncoder.encode(carid, "UTF-8");
                link ="http://192.168.0.6/carenthusiasts/selectTags.php"+data;
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
            if (jsonStr != null && !jsonStr.equals("[]")) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        String resultString = jsonArray.getString(i);
                        JSONObject jsonObj = new JSONObject(resultString);
                        String tag = jsonObj.getString("tag");
                        String description = jsonObj.getString("description");


                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_TAG, tag);
                        map.put(TAG_DESC, description);

                        oslist.add(map);
                        list=(ListView)findViewById(R.id.listTags);

                        ListAdapter adapter = new SimpleAdapter(CarPageActivity.this, oslist,
                                R.layout.list_tags,
                                new String[] { TAG_TAG,TAG_DESC }, new int[] {
                               R.id.tagname, R.id.tagdescription});

                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Toast.makeText(CarPageActivity.this, "You Clicked at " + oslist.get(+position).get("name"), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(CarPageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CarPageActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
