package carenthusiasts.andriod;

/**
 * Created by Alex on 4/22/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class RegisterPHPLoader extends AsyncTask<String, Void, String> {

    private Context context;
    public static final String USER = "USERNAME";
    private String emailAddress;

    public RegisterPHPLoader(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        emailAddress = arg0[0];
        String password = arg0[1];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?emailaddress=" + URLEncoder.encode(emailAddress, "UTF-8");
            data += "&password=" + URLEncoder.encode(password, "UTF-8");


            link = "http://192.168.0.6/carenthusiasts/register.php" + data;

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
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                if (query_result.equals("SUCCESS")) {
                    Toast.makeText(context, "Data inserted successfully. Registration successfull.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, SellActivity.class);
                    i.putExtra("USER", emailAddress);
                    context.startActivity(i);
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Email already in use please login.", Toast.LENGTH_SHORT).show();
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