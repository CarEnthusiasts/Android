package carenthusiasts.andriod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class EditPersonalInfoActivity extends AppCompatActivity {

    private static final String USER = "USER";

    private String email = "";
    private String first = "";
    private String last = "";

    private EditText emailText;
    private EditText firstText;
    private EditText lastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_info);
        Intent i = getIntent();
        email = i.getStringExtra("USER");
        first = i.getStringExtra("FIRST");
        if(first.equals("null")){
            first="";
        }
        last = i.getStringExtra("LAST");
        if(last.equals("null")){
            last="";
        }

        emailText = (EditText) findViewById(R.id.editEmailText);
        firstText = (EditText) findViewById(R.id.editFirstNameText);
        lastText = (EditText) findViewById(R.id.editLastNameText);

        emailText.setText(email);
        firstText.setText(first);
        lastText.setText(last);

        loadsave();
    }

    private void loadsave() {
        Button save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                email = emailText.getText().toString();
                first = firstText.getText().toString();
                last = lastText.getText().toString();

                new JSONUpdate().execute(email, first, last);


            }
        });
    }

    private class JSONUpdate extends AsyncTask<String, Void, String> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... arg0) {

            String email = arg0[0];
            String first = arg0[1];
            String last = arg0[2];

            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?email=" + URLEncoder.encode(email, "UTF-8");
                data += "&first=";
                if(!first.equals("")){
                    data+=URLEncoder.encode(first, "UTF-8");
                }
                data += "&last=";
                if(!last.equals("")){
                    data+=URLEncoder.encode(last, "UTF-8");
                }
                link = "http://192.168.0.6/carenthusiasts/userinfo.php" + data;
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
            if (jsonStr.equals("Record updated successfully")) {
                Intent i = new Intent(getBaseContext(), ProfileActivity.class);
                i.putExtra("USER", email);
                startActivity(i);
            } else {
                Toast.makeText(EditPersonalInfoActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }

}