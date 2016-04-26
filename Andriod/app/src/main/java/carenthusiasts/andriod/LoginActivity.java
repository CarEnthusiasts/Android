package carenthusiasts.andriod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editPassword,editEmail;
    private String previousaction="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent= getIntent();
        previousaction = intent.getStringExtra("PREVIOUS");
        intent.removeExtra("PREVIOUS");
        loadButtons();
    }
    public void loadButtons(){
        editPassword = (EditText) findViewById(R.id.editPasswordText);
        editEmail = (EditText) findViewById(R.id.editEmailText);

        Button LoginButton = (Button) findViewById(R.id.loginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String passWord = editPassword.getText().toString();
                String emailAddress = editEmail.getText().toString();

                if (!passWord.isEmpty()  && !emailAddress.isEmpty()){
                    new LoginAttempt(LoginActivity.this).execute(emailAddress, passWord,previousaction);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please fill in both email, and password", Toast.LENGTH_LONG).show();

                }
            }
        });

        Button RegisterButton = (Button) findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String passWord = editPassword.getText().toString();
                String emailAddress = editEmail.getText().toString();

                if (!passWord.isEmpty()  && !emailAddress.isEmpty()){
                    new RegisterPHPLoader(LoginActivity.this).execute(emailAddress, passWord,previousaction);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please fill in both email, and password", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
