package carenthusiasts.andriod;

/**
 * This Activity written by: Alex Brooks
 */

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class will run the search results page
 */
public class SearchResultsActivity extends AppCompatActivity {

    ListView list;
    TextView setmake;
    TextView setmodel;
    TextView setyear;
    TextView setprice;
    TextView setmileage;
    TextView setcolor;
    TextView setcarid;
    ImageView setimage;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    private static final String CARID = "CARID";
    private static final String USER = "USER";
    //JSON Node Names
    private static final String TAG_MAKE = "make";
    private static final String TAG_MODEL = "model";
    private static final String TAG_CARID= "carid";
    private static final String TAG_YEAR = "yearmade";
    private static final String TAG_MILEAGE = "mileage";
    private static final String TAG_EXTERIOR= "exterior";
    private static final String TAG_PICTURE= "picture";
    private static final String TAG_PRICE= "price";



    JSONArray android = null;

    private String useremail="0";

    private String make = "Select";
    private String model = "Select";
    private String yearmin = "Select";
    private String pricemin ="Select";
    private String mileagemin = "Select";
    private String cylindersmin = "Select";
    private String displacementmin="Select";
    private String hpmin ="Select";
    private String tqmin = "Select";
    private String zerosixtymin = "Select";
    private String topspeedmin="Select";
    private String sixtyzeromin = "Select";
    private String seatsmin = "Select";
    private String yearmax = "Select";
    private String pricemax= "Select";
    private String mileagemax ="Select";
    private String cylindersmax = "Select";
    private String displacementmax = "Select";
    private String hpmax = "Select";
    private String tqmax = "Select";
    private String zerosixtymax= "Select";
    private String topspeedmax= "Select";
    private String sixtyzeromax = "Select";
    private String seatsmax = "Select";
    private String exterior = "Select";
    private String interior = "Select";
    private String drivetrain = "Select";
    private String transmission = "Select";
    private String fuel = "Select";
    private String bodytype = "Select";
    private String tag1 ="Select";
    private String tag2 ="Select";
    private String tag3 ="Select";
    private String tag4 ="Select";
    private String tag5 ="Select";
    private String tag6 ="Select";
    private String tag7 ="Select";
    private String tag8 ="Select";
    private String tag9 ="Select";
    private String tag10 ="Select";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        getextras();
        loadButtons();
        loadCars(savedInstanceState);
    }
    private  void loadButtons(){
        Button newSearchButton = (Button) findViewById(R.id.newSearchButton);
        newSearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SearchActivity.class);
                i.putExtra("USER", useremail);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            if(useremail.equals("0")){
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                i.putExtra("PREVIOUS", "1");
                startActivity(i);
            }
            else {
                Intent i = new Intent(getBaseContext(), ProfileActivity.class);
                i.putExtra("USER", useremail);
                startActivity(i);
            }
        }

        return super.onOptionsItemSelected(item);
    }
    private void getextras(){
        Intent i = getIntent();

        make = i.getStringExtra("MAKE");
        model =  i.getStringExtra("MODEL");
        yearmin =  i.getStringExtra("YEARMIN");
        pricemin = i.getStringExtra("PRICEMIN");
        mileagemin =  i.getStringExtra("MILEAGEMIN");
        cylindersmin =  i.getStringExtra("CYLINDERSMIN");
        displacementmin= i.getStringExtra("DISPLACEMENTMIN");
        hpmin = i.getStringExtra("HPMIN");
        tqmin =  i.getStringExtra("TQMIN");
        zerosixtymin =  i.getStringExtra("ZEROSIXTYMIN");
        topspeedmin= i.getStringExtra("TOPSPEEDMIN");
        sixtyzeromin =  i.getStringExtra("SIXTYZEROMIN");
        seatsmin =  i.getStringExtra("SEATSMIN");
        yearmax =  i.getStringExtra("YEARMAX");
        pricemax=  i.getStringExtra("PRICEMAX");
        mileagemax = i.getStringExtra("MILEAGEMAX");
        cylindersmax =  i.getStringExtra("CYLINDERSMAX");
        displacementmax =  i.getStringExtra("DISPLACEMENTMAX");
        hpmax =  i.getStringExtra("HPMAX");
        tqmax =  i.getStringExtra("TQMAX");
        zerosixtymax=  i.getStringExtra("ZEROSIXTYMAX");
        topspeedmax=  i.getStringExtra("TOPSPEEDMAX");
        sixtyzeromax =  i.getStringExtra("SIXTYZEROMAX");
        seatsmax =  i.getStringExtra("SEATSMAX");
        exterior =  i.getStringExtra("EXTERIOR");
        interior =  i.getStringExtra("INTERIOR");
        drivetrain =  i.getStringExtra("DRIVETRAIN");
        transmission =  i.getStringExtra("TRANSMISSION");
        fuel =  i.getStringExtra("FUEL");
        bodytype =  i.getStringExtra("BODYTYPE");
        tag1 = i.getStringExtra("TAG1");
        tag2 = i.getStringExtra("TAG2");
        tag3 = i.getStringExtra("TAG3");
        tag4 = i.getStringExtra("TAG4");
        tag5 = i.getStringExtra("TAG5");
        tag6 = i.getStringExtra("TAG6");
        tag7 = i.getStringExtra("TAG7");
        tag8 = i.getStringExtra("TAG8");
        tag9 = i.getStringExtra("TAG9");
        tag10 = i.getStringExtra("TAG10");
        useremail = i.getStringExtra("USER");
    }
    private void loadCars(Bundle savedInstanceState){

        oslist = new ArrayList<HashMap<String, String>>();
        new JSONParse().execute();

    }

    /**
     * this class will parse the results for the php file to get json and format it into the list adapter for
     * the cars
     */
    private class JSONParse extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setcarid = (TextView)findViewById(R.id.hiddencarid);
            setmake = (TextView)findViewById(R.id.setmake);
            setmodel = (TextView)findViewById(R.id.setmodel);
            setyear = (TextView)findViewById(R.id.setyear);
            setprice = (TextView)findViewById(R.id.setprice);
            setmileage = (TextView)findViewById(R.id.setmileage);
            setcolor = (TextView)findViewById(R.id.setcolor);
            setimage = (ImageView)findViewById(R.id.imageView2);

            pDialog = new ProgressDialog(SearchResultsActivity.this);
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
                data = "?make=" + URLEncoder.encode(make, "UTF-8");
                data += "&model=" + URLEncoder.encode(model, "UTF-8");
                if( yearmin.equals("Select")){
                    data+="&yearmin=";
                }
                else {
                    data += "&yearmin=" + URLEncoder.encode(yearmin, "UTF-8");
                }
                if (pricemin.equals("Select")){
                    data+="&pricemin=";
                }else {
                    data += "&pricemin=" + URLEncoder.encode(pricemin, "UTF-8");
                }
                if (mileagemin.equals("Select")){
                    data+="&mileagemin=";
                }
                else {
                    data += "&mileagemin=" + URLEncoder.encode(mileagemin, "UTF-8");
                }
                data += "&cylindersmin=";
                if(!cylindersmin.equals("Select")){
                    data += URLEncoder.encode(cylindersmin, "UTF-8");
                }

                data += "&displacementmin=";
                if(!displacementmin.equals("Select")){
                    data += URLEncoder.encode(displacementmin, "UTF-8");
                }
                data += "&hpmin=";
                if(!hpmin.equals("Select")) {
                    data += URLEncoder.encode(hpmin, "UTF-8");
                }
                data += "&tqmin=";
                if(!tqmin.equals("Select")) {
                    data += URLEncoder.encode(tqmin, "UTF-8");
                }
                data += "&zerosixtymin=";
                if(!zerosixtymin.equals("Select")) {
                    data += URLEncoder.encode(zerosixtymin, "UTF-8");
                }
                data += "&topspeedmin=";
                if(!topspeedmin.equals("Select")) {
                    data += URLEncoder.encode(topspeedmin, "UTF-8");
                }
                data += "&sixtyzeromin=";
                if(!sixtyzeromin.equals("Select")) {
                    data += URLEncoder.encode(sixtyzeromin, "UTF-8");
                }
                data += "&seatsmin=";
                if(!seatsmin.equals("Select")) {
                    data += URLEncoder.encode(seatsmin, "UTF-8");
                }
                data += "&exterior=";
                if(!exterior.equals("Select")){
                    data += URLEncoder.encode(exterior, "UTF-8");
                }

                data += "&interior=";
                if(!interior.equals("Select")) {
                    data += URLEncoder.encode(interior, "UTF-8");
                }
                data += "&drivetrain=";
                if(!drivetrain.equals("Select")){
                    data += URLEncoder.encode(drivetrain, "UTF-8");
                }
                data += "&transmission=";
                if(!transmission.equals("Select")) {
                    data += URLEncoder.encode(transmission, "UTF-8");
                }
                data += "&fuel=";
                if(!fuel.equals("Select")) {
                    data += URLEncoder.encode(fuel, "UTF-8");
                }
                data += "&bodytype=";
                if(!bodytype.equals("Select")) {
                    data += URLEncoder.encode(bodytype, "UTF-8");
                }

                data += "&yearmax=";
                if(!yearmax.equals("Select")) {
                    data += URLEncoder.encode(yearmax, "UTF-8");
                }
                data += "&pricemax=";
                if(!pricemax.equals("Select")) {
                    data += URLEncoder.encode(pricemax, "UTF-8");
                }
                data += "&mileagemax=";
                if(!mileagemax.equals("Select")) {
                    data += URLEncoder.encode(mileagemax, "UTF-8");
                }
                data += "&cylindersmax=";
                if(!cylindersmax.equals("Select")) {
                    data += URLEncoder.encode(cylindersmax, "UTF-8");
                }
                data += "&displacementmax=";
                if(!displacementmax.equals("Select")) {
                    data += URLEncoder.encode(displacementmax, "UTF-8");
                }
                data += "&hpmax=";
                if(!hpmax.equals("Select")) {
                    data += URLEncoder.encode(hpmax, "UTF-8");
                }
                data += "&tqmax=";
                if(!tqmax.equals("Select")) {
                    data += URLEncoder.encode(tqmax, "UTF-8");
                }
                data += "&zerosixtymax=";
                if(!zerosixtymax.equals("Select")) {
                    data += URLEncoder.encode(zerosixtymax, "UTF-8");
                }
                data += "&topspeedmax=";
                if(!topspeedmax.equals("Select")) {
                    data += URLEncoder.encode(topspeedmax, "UTF-8");
                }
                data += "&sixtyzeromax=";
                if(!sixtyzeromax.equals("Select")) {
                    data += URLEncoder.encode(sixtyzeromax, "UTF-8");
                }
                data += "&seatsmax=";
                if(!seatsmax.equals("Select")) {
                    data += URLEncoder.encode(seatsmax, "UTF-8");
                }
                data += "&tag1=";
                if(!tag1.equals("Select")) {
                    data += URLEncoder.encode(tag1, "UTF-8");
                }
                data += "&tag2=";
                if(!tag2.equals("Select")) {
                    data += URLEncoder.encode(tag2, "UTF-8");
                }
                data += "&tag3=";
                if(!tag3.equals("Select")) {
                    data += URLEncoder.encode(tag3, "UTF-8");
                }
                data += "&tag4=";
                if(!tag4.equals("Select")) {
                    data += URLEncoder.encode(tag4, "UTF-8");
                }
                data += "&tag5=";
                if(!tag5.equals("Select")) {
                    data += URLEncoder.encode(tag5, "UTF-8");
                }
                data += "&tag6=";
                if(!tag6.equals("Select")) {
                    data += URLEncoder.encode(tag6, "UTF-8");
                }
                data += "&tag7=";
                if(!tag7.equals("Select")) {
                    data += URLEncoder.encode(tag7, "UTF-8");
                }
                data += "&tag8=";
                if(!tag8.equals("Select")) {
                    data += URLEncoder.encode(tag8, "UTF-8");
                }
                data += "&tag9=";
                if(!tag9.equals("Select")) {
                    data += URLEncoder.encode(tag9, "UTF-8");
                }
                data += "&tag10=";
                if(!tag10.equals("Select")) {
                    data += URLEncoder.encode(tag10, "UTF-8");
                }

                link ="http://192.168.0.6/carenthusiasts/selectCars.php" + data;

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
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            pDialog.dismiss();
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        String resultString = jsonArray.getString(i);
                        JSONObject jsonObj = new JSONObject(resultString);
                        String carid =jsonObj.getString("carid");
                        String make = jsonObj.getString("make");
                        String model = jsonObj.getString("model");
                        String year = jsonObj.getString("yearmade");
                        String price ="$ "+ jsonObj.getString("price");
                        String mileage = jsonObj.getString("mileage")+ " Miles";
                        String exterior = jsonObj.getString("exterior");
                        String picture = jsonObj.getString("picture");

                        if(make.equals("NULL")){
                            make ="Unknown";
                        }
                        if(model.equals("NULL")){
                            model ="Unknown";
                        }
                        if(year.equals("NULL")){
                            year ="Unknown";
                        }
                        if(price.equals("NULL")){
                            price ="Price";
                        }
                        if(mileage.equals("NULL")){
                            mileage ="Mileage";
                        }
                        if(exterior.equals("NULL")){
                            exterior ="Color";
                        }
                        if(picture.equals("NULL")){
                            picture ="Unknown";
                        }
                        else{
                            try {

                                Uri myUri = Uri.parse(picture);
                                File filePath = getFileStreamPath(picture);
                                drawable = Drawable.createFromPath(filePath.toString());
                            } catch (Exception e) {
                                drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                            }
                        }

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_CARID,carid);
                        map.put(TAG_MAKE, make);
                        map.put(TAG_MODEL, model);
                        map.put(TAG_YEAR, year);
                        map.put(TAG_PRICE, price);
                        map.put(TAG_MILEAGE, mileage);
                        map.put(TAG_EXTERIOR, exterior);
                        map.put(TAG_PICTURE, picture);

                        oslist.add(map);
                        list=(ListView)findViewById(R.id.list);

                        ListAdapter adapter = new SimpleAdapter(SearchResultsActivity.this, oslist,
                                R.layout.list_cars,
                                new String[] {TAG_CARID,TAG_MAKE,TAG_MODEL,TAG_YEAR,TAG_PRICE,TAG_MILEAGE,TAG_EXTERIOR,
                                        TAG_PICTURE }, new int[] {R.id.hiddencarid, R.id.setmake, R.id.setmodel, R.id.setyear, R.id.setprice
                        , R.id.setmileage, R.id.setcolor, R.id.imageView2});

                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Intent i = new Intent(getBaseContext(), CarPageActivity.class);
                                String carid = oslist.get(+position).get(TAG_CARID).toString();
                                i.putExtra("CARID", carid );
                                startActivity(i);
                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(SearchResultsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(SearchResultsActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
