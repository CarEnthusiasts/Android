package carenthusiasts.andriod;
/**
 * This Activity written by: Alex Brooks
 */
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

public class ProfileActivity extends AppCompatActivity {
    ListView list;
    private TextView userText;
    private TextView firstText;
    private TextView lastText;
    Button Btngetdata;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> searchOslist = new ArrayList<HashMap<String, String>>();

    //JSON Node Names
    private static final String TAG_MAKE = "make";
    private static final String TAG_MODEL = "model";
    private static final String TAG_CARID= "carid";
    private static final String TAG_YEAR = "yearmade";
    private static final String TAG_MILEAGE = "mileage";
    private static final String TAG_EXTERIOR= "exterior";
    private static final String TAG_PICTURE= "picture";
    private static final String TAG_PRICE= "price";

    private TextView setmake;
    private TextView setmodel;
    private TextView setyear;
    private TextView setprice;
    private TextView setmileage;
    private TextView setcolor;
    private TextView setcarid;
    private ImageView setimage;

    JSONArray android = null;

    private static final String USER = "USER";
    private static final String FIRST = "FIRST";
    private static final String LAST = "LAST";
    private static final String PASSWORD = "PASSWORD";
    private String useremail = "0";
    private String first;
    private String last;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadprofile(savedInstanceState);
    }

    private void loadprofile(Bundle savedInstanceState) {
        Intent intent = getIntent();
        useremail = intent.getStringExtra("USER");
        new JSONParsePage().execute();
        oslist = new ArrayList<HashMap<String, String>>();

        searchOslist = new ArrayList<HashMap<String, String>>();
        new JSONParseCars().execute();
        loadbuttons();
//        new JSONParseSearch().execute();
    }
    private void loadbuttons(){
        Button editpersonal = (Button) findViewById(R.id.EditPersonalInfoButton);
        editpersonal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), EditPersonalInfoActivity.class);
                i.putExtra("USER", useremail);
                i.putExtra("FIRST", first);
                i.putExtra("LAST", last);
                startActivity(i);
            }
        });

        Button editpassword = (Button) findViewById(R.id.changePasswordButton);
        editpassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ChangePasswordActivity.class);
                i.putExtra("USER", useremail);
                i.putExtra("PASSWORD", password);
                startActivity(i);
            }
        });

        Button logout = (Button) findViewById(R.id.LogoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                i.putExtra("USER", "0");
                startActivity(i);
            }
        });
    }
    private class JSONParsePage extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            userText = (TextView) findViewById(R.id.emailText);
            firstText = (TextView) findViewById(R.id.firstNameText);
            lastText = (TextView) findViewById(R.id.lastNameText);

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

                data = "?user=" + URLEncoder.encode(useremail, "UTF-8");
                link = "http://192.168.0.6/carenthusiasts/getprofilepage.php" + data;
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
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String resultString = jsonArray.getString(i);
                        JSONObject jsonObj = new JSONObject(resultString);

                        useremail =jsonObj.getString("email");
                        first =jsonObj.getString("first");
                        last = jsonObj.getString("last");
                        password = jsonObj.getString("password");
                        userText.setText(useremail);
                        firstText.setText(first);
                        lastText.setText(last);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            } else {
            }

        }
    }

    private class JSONParseCars extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setcarid = (TextView) findViewById(R.id.hiddencarid);
            setmake = (TextView) findViewById(R.id.setmake);
            setmodel = (TextView) findViewById(R.id.setmodel);
            setyear = (TextView) findViewById(R.id.setyear);
            setprice = (TextView) findViewById(R.id.setprice);
            setmileage = (TextView) findViewById(R.id.setmileage);
            setcolor = (TextView) findViewById(R.id.setcolor);
            setimage = (ImageView) findViewById(R.id.imageView2);

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
                data = "?user=" + URLEncoder.encode(useremail, "UTF-8");

                link = "http://192.168.0.6/carenthusiasts/usercars.php" + data;

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
                    for (int i = 0; i < jsonArray.length(); i++) {
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

                        if (make.equals("NULL")) {
                            make = "Unknown";
                        }
                        if (model.equals("NULL")) {
                            model = "Unknown";
                        }
                        if (year.equals("NULL")) {
                            year = "Unknown";
                        }
                        if (price.equals("NULL")) {
                            price = "Price";
                        }
                        if (mileage.equals("NULL")) {
                            mileage = "Mileage";
                        }
                        if (exterior.equals("NULL")) {
                            exterior = "Color";
                        }
                        if (picture.equals("NULL")) {
                            picture = "Unknown";
                        } else {
                            try {

                                Uri myUri = Uri.parse(picture);
                                File filePath = getFileStreamPath(picture);
                                drawable = Drawable.createFromPath(filePath.toString());
                            } catch (Exception e) {
                                drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                            }
                        }

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_CARID, carid);
                        map.put(TAG_MAKE, make);
                        map.put(TAG_MODEL, model);
                        map.put(TAG_YEAR, year);
                        map.put(TAG_PRICE, price);
                        map.put(TAG_MILEAGE, mileage);
                        map.put(TAG_EXTERIOR, exterior);
                        map.put(TAG_PICTURE, picture);

                        oslist.add(map);
                        list = (ListView) findViewById(R.id.listCars);

                        ListAdapter adapter = new SimpleAdapter(ProfileActivity.this, oslist,
                                R.layout.list_cars,
                                new String[]{TAG_CARID, TAG_MAKE, TAG_MODEL, TAG_YEAR, TAG_PRICE, TAG_MILEAGE, TAG_EXTERIOR,
                                        TAG_PICTURE}, new int[]{R.id.hiddencarid, R.id.setmake, R.id.setmodel, R.id.setyear, R.id.setprice
                                , R.id.setmileage, R.id.setcolor, R.id.imageView2});

                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Intent i = new Intent(getBaseContext(), CarPageActivity.class);
                                String carid = oslist.get(+position).get(TAG_CARID).toString();
                                i.putExtra("CARID", carid);
                                startActivity(i);
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
}
