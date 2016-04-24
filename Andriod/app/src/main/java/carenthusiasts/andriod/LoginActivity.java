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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadButtons();
    }
    public void loadButtons(){
        editPassword = (EditText) findViewById(R.id.editPasswordText);
        editEmail = (EditText) findViewById(R.id.editEmailText);

        Button LoginButton = (Button) findViewById(R.id.loginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SellActivity.class);
                //i.putExtra("PersonID", personID);
                startActivity(i);
            }
        });

        Button RegisterButton = (Button) findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String passWord = editPassword.getText().toString();
                String emailAddress = editEmail.getText().toString();

                if (!passWord.isEmpty()  && !emailAddress.isEmpty()){
                    new RegisterPHPLoader(LoginActivity.this).execute(emailAddress, passWord);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please fill in both email, and password", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
