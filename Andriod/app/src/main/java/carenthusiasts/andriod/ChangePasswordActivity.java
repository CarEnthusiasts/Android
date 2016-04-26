package carenthusiasts.andriod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ChangePasswordActivity extends AppCompatActivity {

    private String email;
    private String password;

    private String holdoldpasswordtext;
    private String holdnewpasswordtext;
    private String holdrepeatpasswordtext;

    private EditText oldpasswordText;
    private EditText newpasswordText;
    private EditText repeatpasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Intent i = getIntent();
        email = i.getStringExtra("USER");
        password = i.getStringExtra("PASSWORD");

        oldpasswordText = (EditText) findViewById(R.id.oldPasswordText);
        newpasswordText = (EditText) findViewById(R.id.newPasswordText);
        repeatpasswordText = (EditText) findViewById(R.id.repeatPasswordText);

        loadsave();
    }

    private void loadsave() {
        Button save = (Button) findViewById(R.id.savePasswordButton);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                holdoldpasswordtext = oldpasswordText.getText().toString();
                holdnewpasswordtext = newpasswordText.getText().toString();
                holdrepeatpasswordtext = repeatpasswordText.getText().toString();

                if(password.equals(holdoldpasswordtext) && holdnewpasswordtext.equals(holdrepeatpasswordtext)){
                    new JSONUpdate().execute(email,holdnewpasswordtext);
                }



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
            String password = arg0[1];

            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?email=" + URLEncoder.encode(email, "UTF-8");
                data += "&password=" + URLEncoder.encode(password, "UTF-8");

                link = "http://192.168.0.6/carenthusiasts/userpassword.php" + data;
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
                Toast.makeText(ChangePasswordActivity.this, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
