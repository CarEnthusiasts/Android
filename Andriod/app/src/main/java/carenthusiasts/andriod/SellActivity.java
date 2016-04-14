package carenthusiasts.andriod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        createNextButton();
    }
    private void createNextButton(){
        final Button NextButton = (Button) findViewById(R.id.NextButton);
        NextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SellTagActivity.class);
                //i.putExtra("PersonID", personID);
                startActivity(i);
            }
        });
    }
}
