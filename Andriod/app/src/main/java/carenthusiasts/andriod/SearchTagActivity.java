package carenthusiasts.andriod;

/**
 * This Activity written by: Alex Brooks
 */
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this activity will loads the search tags as well as pass on search parameters
 */
public class SearchTagActivity extends AppCompatActivity {

    public static final String MAKE = "MAKE";
    public static final String MODEL = "MODEL";
    public static final String YEARMIN = "YEARMIN";
    public static final String PRICEMIN ="PRICEMIN";
    public static final String MILEAGEMIN = "MILEAGEMIN";
    public static final String CYLINDERSMIN = "CYLINDERSMIN";
    public static final String DISPLACEMENTMIN="DISPLACEMENTMIN";
    public static final String HPMIN ="HPMIN";
    public static final String TQMIN = "TQMIN";
    public static final String ZEROSIXTYMIN = "ZEROSIXTYMIN";
    public static final String TOPSPEEDMIN="TOPSPEEDMIN";
    public static final String SIXTYZEROMIN = "SIXTYZEROMIN";
    public static final String SEATSMIN = "SEATSMIN";
    public static final String YEARMAX = "YEARMAX";
    public static final String PRICEMAX= "PRICEMAX";
    public static final String MILEAGEMAX ="MILEAGEMAX";
    public static final String CYLINDERSMAX = "CYLINDERSMAX";
    public static final String DISPLACEMENTMAX = "DISPLACEMENTMAX";
    public static final String HPMAX = "HPMAX";
    public static final String TQMAX = "TQMAX";
    public static final String ZEROSIXTYMAX= "ZEROSIXTYMAX";
    public static final String TOPSPEEDMAX= "TOPSPEEDMAX";
    public static final String SIXTYZEROMAX = "SIXTYZEROMAX";
    public static final String SEATSMAX = "SEATSMAX";
    public static final String EXTERIOR = "EXTERIOR";
    public static final String INTERIOR = "INTERIOR";
    public static final String DRIVETRAIN = "DRIVETRAIN";
    public static final String TRANSMISSION = "TRANSMISSION";
    public static final String FUEL = "FUEL";
    public static final String BODYTYPE = "BODYTYPE";
    public static final String TAG1 ="TAG1";
    public static final String TAG2 ="TAG2";
    public static final String TAG3 ="TAG3";
    public static final String TAG4 ="TAG4";
    public static final String TAG5 ="TAG5";
    public static final String TAG6 ="TAG6";
    public static final String TAG7 ="TAG7";
    public static final String TAG8 ="TAG8";
    public static final String TAG9 ="TAG9";
    public static final String TAG10 ="TAG10";
    public static final String USER = "USER";


    private String useremail = "0";

    private String make = "Select";
    private String model = "Select";
    private String yearmin = "Select";
    private String pricemin ="Select";
    private String mileagemin = "Select";
    private String cylindersmin = "Select";
    private String displacementmin="Select";
    private String hpmin ="Select";
    private String tqmin = "Select";
    private String zerosixtymin = "Select";
    private String topspeedmin="Select";
    private String sixtyzeromin = "Select";
    private String seatsmin = "Select";
    private String yearmax = "Select";
    private String pricemax= "Select";
    private String mileagemax ="Select";
    private String cylindersmax = "Select";
    private String displacementmax = "Select";
    private String hpmax = "Select";
    private String tqmax = "Select";
    private String zerosixtymax= "Select";
    private String topspeedmax= "Select";
    private String sixtyzeromax = "Select";
    private String seatsmax = "Select";
    private String exterior = "Select";
    private String interior = "Select";
    private String drivetrain = "Select";
    private String transmission = "Select";
    private String fuel = "Select";
    private String bodytype = "Select";
    private String[] tag = new String[]{"Select","Select","Select","Select","Select",
        "Select","Select","Select","Select","Select"};

    private int count=0;

    private Spinner TagCategorySpinner ;

    private Spinner TagSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getextras();
        setContentView(R.layout.activity_search_tag);
        createNewSpinners();
        createAddTagButton();
        createSearchButton();
    }
    private void getextras(){
        Intent i = getIntent();
        useremail = i.getStringExtra("USER");
        make = i.getStringExtra("MAKE");
        model =  i.getStringExtra("MODEL");
        yearmin =  i.getStringExtra("YEARMIN");
        pricemin = i.getStringExtra("PRICEMIN");
        mileagemin =  i.getStringExtra("MILEAGEMIN");
        cylindersmin =  i.getStringExtra("CYLINDERSMIN");
        displacementmin= i.getStringExtra("DISPLACEMENTMIN");
        hpmin = i.getStringExtra("HPMIN");
        tqmin =  i.getStringExtra("TQMIN");
        zerosixtymin =  i.getStringExtra("ZEROSIXTYMIN");
        topspeedmin= i.getStringExtra("TOPSPEEDMIN");
        sixtyzeromin =  i.getStringExtra("SIXTYZEROMIN");
        seatsmin =  i.getStringExtra("SEATSMIN");
        yearmax =  i.getStringExtra("YEARMAX");
        pricemax=  i.getStringExtra("PRICEMAX");
        mileagemax = i.getStringExtra("MILEAGEMAX");
        cylindersmax =  i.getStringExtra("CYLINDERSMAX");
        displacementmax =  i.getStringExtra("DISPLACEMENTMAX");
        hpmax =  i.getStringExtra("HPMAX");
        tqmax =  i.getStringExtra("TQMAX");
        zerosixtymax=  i.getStringExtra("ZEROSIXTYMAX");
        topspeedmax=  i.getStringExtra("TOPSPEEDMAX");
        sixtyzeromax =  i.getStringExtra("SIXTYZEROMAX");
        seatsmax =  i.getStringExtra("SEATSMAX");
        exterior =  i.getStringExtra("EXTERIOR");
        interior =  i.getStringExtra("INTERIOR");
        drivetrain =  i.getStringExtra("DRIVETRAIN");
        transmission =  i.getStringExtra("TRANSMISSION");
        fuel =  i.getStringExtra("FUEL");
        bodytype =  i.getStringExtra("BODYTYPE");


    }
    private void createAddTagButton(){
        final Button addTagButton = (Button) findViewById(R.id.AddTagButton);
        addTagButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tag[count]=TagSpinner.getSelectedItem().toString();
                count ++;
                createNewSpinners();
            }
        });
    }
    private void createSearchButton(){
        final Button SearchButton = (Button) findViewById(R.id.SearchButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SearchResultsActivity.class);
                i.putExtra("USER", useremail);
                i.putExtra("MAKE", make);
                i.putExtra("MODEL",model);
                i.putExtra("YEARMIN",yearmin);
                i.putExtra("PRICEMIN",pricemin);
                i.putExtra("MILEAGEMIN",mileagemin);
                i.putExtra("CYLINDERSMIN",cylindersmin);
                i.putExtra("DISPLACEMENTMIN",displacementmin);
                i.putExtra("HPMIN",hpmin);
                i.putExtra("TQMIN",tqmin);
                i.putExtra("ZEROSIXTYMIN",zerosixtymin);
                i.putExtra("TOPSPEEDMIN",topspeedmin);
                i.putExtra("SIXTYZEROMIN",sixtyzeromin);
                i.putExtra("SEATSMIN",seatsmin);
                i.putExtra("YEARMAX",yearmax);
                i.putExtra("PRICEMAX",pricemax);
                i.putExtra("MILEAGEMAX",mileagemax);
                i.putExtra("CYLINDERSMAX",cylindersmax);
                i.putExtra("DISPLACEMENTMAX",displacementmax);
                i.putExtra("HPMAX", hpmax);
                i.putExtra("TQMAX",tqmax);
                i.putExtra("ZEROSIXTYMAX", zerosixtymax);
                i.putExtra("TOPSPEEDMAX",topspeedmax);
                i.putExtra("SIXTYZEROMAX",sixtyzeromax);
                i.putExtra("SEATSMAX",seatsmax);
                i.putExtra("EXTERIOR",exterior);
                i.putExtra("INTERIOR",interior);
                i.putExtra("DRIVETRAIN",drivetrain);
                i.putExtra("TRANSMISSION",transmission);
                i.putExtra("FUEL",fuel);
                i.putExtra("BODYTYPE",bodytype);
                i.putExtra("TAG1",tag[0]);
                i.putExtra("TAG2",tag[1]);
                i.putExtra("TAG3",tag[2]);
                i.putExtra("TAG4",tag[3]);
                i.putExtra("TAG5",tag[4]);
                i.putExtra("TAG6",tag[5]);
                i.putExtra("TAG7",tag[6]);
                i.putExtra("TAG8",tag[7]);
                i.putExtra("TAG9",tag[8]);
                i.putExtra("TAG10",tag[9]);
                startActivity(i);
            }
        });
    }
    private void createNewSpinners(){
        LinearLayout tagContainer = (LinearLayout) findViewById(R.id.tagContainer);
        LinearLayout newTagContainer = new LinearLayout(SearchTagActivity.this);
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        newTagContainer.setLayoutParams(linLayoutParam);
        newTagContainer.setOrientation(LinearLayout.HORIZONTAL);

        TextView tagName = new TextView(SearchTagActivity.this);
        tagName.setText("Select new Tag: ");
        tagName.setTextAppearance(SearchTagActivity.this,android.R.style.TextAppearance_Medium);  //deprecated but new version without passing This requires api 23+
        TagCategorySpinner = new Spinner(SearchTagActivity.this);
        TagSpinner = new Spinner(SearchTagActivity.this);

        final String[] arraySpinner =  {"Select","Engine","Suspension","Interior","Bodywork","Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        TagCategorySpinner.setAdapter(adapter);

        TagCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                String[] modelString = new String[]{"Select"};
                switch (position) {
                    case 1:
                        modelString = new String[]{"Select","Turbo", "Supercharge", "Engine Swap", "Headers", "Air Intake"};
                        break;
                    case 2:
                        modelString = new String[]{"Select","Frontend Swap", "Rearend Swap", "Lug Swap", "Lowered", "Stanced", "Sway Bars"};
                        break;
                    case 3:
                        modelString = new String[]{"Select","Trim", "Seats", "Rollbar", "Rollcage"};
                        break;
                    case 4:
                        modelString = new String[]{"Select","Body Kit", "Hood", "Trunk", "Fenders", "Doors", "Roof", "Spoiler"
                        };
                        break;
                    case 5:
                        modelString = new String[]{"Other"
                        };
                        break;
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchTagActivity.this,
                        android.R.layout.simple_spinner_item, modelString);

                final String[] resultString = modelString;
                TagSpinner.setAdapter(adapter);
                TagSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

                                                         @Override
                                                         public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                                                             // TODO Auto-generated method stub


                                                         }

                                                         @Override
                                                         public void onNothingSelected(AdapterView<?> arg0) {
                                                             // TODO Auto-generated method stub

                                                         }
                                                     }
                );
            }
                //Toast.makeText(getBaseContext(), makeString[position], Toast.LENGTH_SHORT).show();
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }

            });



        final String[] arraySpinner2 =  {"Filled","with","dummy","data","aswell"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        TagSpinner.setAdapter(adapter2);

        TagSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), arraySpinner[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

        newTagContainer.addView(tagName);
        newTagContainer.addView(TagCategorySpinner);
        newTagContainer.addView(TagSpinner);
        tagContainer.addView(newTagContainer);

    }
}
