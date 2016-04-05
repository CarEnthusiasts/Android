package carenthusiasts.andriod;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SearchResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        loadCars(savedInstanceState);
    }
    private void loadCars(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            Fragment newFragment = new CarsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.frame1, newFragment).commit();
        }
    }
}
