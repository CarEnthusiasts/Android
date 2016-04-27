package carenthusiasts.andriod;
/**
 * This Activity written by: Alex Brooks
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * this class is responsible for the home page
 */
public class MainActivity extends AppCompatActivity {

    public static final String USER = "USER";
    public static final String PREVIOUS ="PREVIOUS";
    private String useremail = "0";
    private String previous = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        try{
            useremail = intent.getStringExtra("USER");
            if(useremail.equals("null")){
                useremail="0";
            }
        }
        catch (Exception e){
            useremail = "0";
        }
        previous = "0";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button SearchButton = (Button) findViewById(R.id.SearchButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SearchActivity.class);
                i.putExtra("USER", useremail);
                startActivity(i);
            }
        });
        Button SellButton = (Button) findViewById(R.id.SellButton);
        SellButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(useremail.equals("0")) {
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    i.putExtra("PREVIOUS", previous);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getBaseContext(), SellActivity.class);
                    i.putExtra("USER", useremail);
                    startActivity(i);
                }
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
                previous = "1";
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                i.putExtra("PREVIOUS", previous);
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
}
