package carenthusiasts.andriod;
/**
 * This Activity written by: Alex Brooks
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
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
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by Alex on 4/24/2016.
 */
public class LoginAttempt extends AsyncTask<String, Void, String> {
    public static final String USER = "USER";
    private ProgressDialog pDialog;

    private Context context;

    private String email;
    private String password;
    private String previous;

    public LoginAttempt(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected String doInBackground(String... arg0) {

        email = arg0[0];
        password= arg0[1];
        previous = arg0[2];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data= "?email="+ URLEncoder.encode(email, "UTF-8");
            data+= "&password="+ URLEncoder.encode(password, "UTF-8");
            link ="http://192.168.0.6/carenthusiasts/login.php"+data;
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
        String jsonStr = result;
        if (jsonStr != null && !jsonStr.equals("[]")) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for(int i = 0; i < jsonArray.length(); i++)
                {
                    String resultString = jsonArray.getString(i);
                    JSONObject jsonObj = new JSONObject(resultString);
                    String getemail = jsonObj.getString("email");
                    String getpassword = jsonObj.getString("password");

                    if (getemail.equals(email) && getpassword.equals(password)){
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                        if(previous.equals("0")) {
                            Intent intent = new Intent(context, SellActivity.class);
                            intent.putExtra("USER", email);
                            context.startActivity(intent);
                        }
                        else{
                            if(previous.equals("1")){
                                Intent intent = new Intent(context, ProfileActivity.class);
                                intent.putExtra("USER", email);
                                context.startActivity(intent);
                            }
                            else{
                                Intent intent = new Intent(context, SearchResultsActivity.class);
                                intent.putExtra("USER", email);
                                context.startActivity(intent);
                            }
                        }
                    }
                    else{
                        Toast.makeText(context, "Wrong password or email", Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();

                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Wrong password or email", Toast.LENGTH_SHORT).show();
        }

    }
}