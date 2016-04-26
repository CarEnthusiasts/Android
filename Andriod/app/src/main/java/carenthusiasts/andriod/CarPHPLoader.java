package carenthusiasts.andriod;

/**
 * Created by Alex on 4/22/2016.
 */




import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class CarPHPLoader extends AsyncTask<String, Void, String> {

    private Context context;

    public static final String USER = "USER";
    public static final String CARID = "USERNAME";

    private String useremail;
    public CarPHPLoader(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String make = arg0[0];
        String model = arg0[1];
        String year = arg0[2];
        String price = arg0[3];
        String mileage = arg0[4];
        String cylinders = arg0[5];
        String displacement = arg0[6];
        String hp = arg0[7];
        String tq = arg0[8];
        String zerosixty = arg0[9];
        String topspeed = arg0[10];
        String sixtyZero = arg0[11];
        String seats = arg0[12];
        String exterior = arg0[13];
        String interior = arg0[14];
        String drivetrain = arg0[15];
        String transmission = arg0[16];
        String fuel = arg0[17];
        String bodytype = arg0[18];
        String picture = arg0[19];
        useremail = arg0[20];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?make=" + URLEncoder.encode(make, "UTF-8");
            data += "&model=" + URLEncoder.encode(model, "UTF-8");
            data += "&year=" + URLEncoder.encode(year, "UTF-8");
            data += "&price=" + URLEncoder.encode(price, "UTF-8");
            data += "&mileage=" + URLEncoder.encode(mileage, "UTF-8");
            data += "&cylinders=" + URLEncoder.encode(cylinders, "UTF-8");
            data += "&displacement=" + URLEncoder.encode(displacement, "UTF-8");
            data += "&hp=" + URLEncoder.encode(hp, "UTF-8");
            data += "&tq=" + URLEncoder.encode(tq, "UTF-8");
            data += "&zerosixty=" + URLEncoder.encode(zerosixty, "UTF-8");
            data += "&topspeed=" + URLEncoder.encode(topspeed, "UTF-8");
            data += "&sixtyzero=" + URLEncoder.encode(sixtyZero, "UTF-8");
            data += "&seats=" + URLEncoder.encode(seats, "UTF-8");
            data += "&exterior=" + URLEncoder.encode(exterior, "UTF-8");
            data += "&interior=" + URLEncoder.encode(interior, "UTF-8");
            data += "&drivetrain=" + URLEncoder.encode(drivetrain, "UTF-8");
            data += "&transmission=" + URLEncoder.encode(transmission, "UTF-8");
            data += "&fuel=" + URLEncoder.encode(fuel, "UTF-8");
            data += "&bodytype=" + URLEncoder.encode(bodytype, "UTF-8");
            data += "&picture=" + URLEncoder.encode(picture, "UTF-8");
            data += "&useremail=" + URLEncoder.encode(useremail, "UTF-8");


            link = "http://192.168.0.6/carenthusiasts/car.php" + data;

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            con.disconnect();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("tagconvertstr", "[" + result + "]");
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("id");
                if (!query_result.equals("0")) {
                    Toast.makeText(context, "car loaded", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, SellTagActivity.class);
                    i.putExtra("USER",useremail);
                    i.putExtra("CARID", query_result);
                    context.startActivity(i);
                } else if (query_result.equals("0")) {
                    Toast.makeText(context, "Data could not be inserted. Signup failed.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();

                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }
    }
}
