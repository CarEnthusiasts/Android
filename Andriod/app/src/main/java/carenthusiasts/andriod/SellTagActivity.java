package carenthusiasts.andriod;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SellTagActivity extends AppCompatActivity {

    private String category ="NULL";
    private String tag = "NULL";
    private String description = "NULL";
    private String carid = "NULL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                carid= null;
            } else {
                carid= extras.getString("CARID");
            }
        } else {
            carid= (String) savedInstanceState.getSerializable("CARID");
        }
        setContentView(R.layout.activity_sell_tag);
        createAddTagButton();
        createSearchButton();
    }

    private void createAddTagButton(){
        final Button addTagButton = (Button) findViewById(R.id.AddTagButton);
        addTagButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createNewSpinners();
            }
        });
    }
    private void createSearchButton(){
        final Button SearchButton = (Button) findViewById(R.id.SearchButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SearchResultsActivity.class);
                //i.putExtra("PersonID", personID);
                startActivity(i);
            }
        });
    }
    private void createNewSpinners(){
        LinearLayout tagContainer = (LinearLayout) findViewById(R.id.tagContainer);
        LinearLayout masterContainer = new LinearLayout(SellTagActivity.this);
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        masterContainer.setLayoutParams(linLayoutParam);
        masterContainer.setOrientation(LinearLayout.VERTICAL);

        LinearLayout newTagContainer = new LinearLayout(SellTagActivity.this);
        newTagContainer.setLayoutParams(linLayoutParam);
        newTagContainer.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout descriptionContainer = new LinearLayout(SellTagActivity.this);
        descriptionContainer.setLayoutParams(linLayoutParam);
        descriptionContainer.setOrientation(LinearLayout.HORIZONTAL);

        TextView tagName = new TextView(SellTagActivity.this);
        tagName.setText("Select new tag: ");
        tagName.setTextAppearance(this,android.R.style.TextAppearance_Medium);  //deprecated but new version without passing This requires api 23+
        Spinner TagCategorySpinner = new Spinner(SellTagActivity.this);

        final Spinner TagSpinner = new Spinner(SellTagActivity.this);

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

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SellTagActivity.this,
                        android.R.layout.simple_spinner_item, modelString);
                category = arraySpinner[position];

                final String[] resultString = modelString;
                TagSpinner.setAdapter(adapter);
                TagSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

                                                         @Override
                                                         public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                                                             // TODO Auto-generated method stub
                                                             tag =  resultString[position];

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


        TextView Description = new TextView(SellTagActivity.this);
        Description.setText("Description: ");
        Description.setTextAppearance(this, android.R.style.TextAppearance_Medium);

        final TextInputEditText descriptionText = new TextInputEditText(SellTagActivity.this);
        descriptionText.setWidth(600);
        descriptionText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String hold =descriptionText.getText().toString();
                    if(hold.equals("")){
                        description="NULL";
                    }
                    else{
                        description=hold;
                    }
                    if(category.equals("Select")){
                        category="NULL";
                    }
                    if(tag.equals("Select")){
                        tag="NULL";
                    }

                    new TagPHPLoader(SellTagActivity.this).execute(category,tag,description,carid);
                }

            }
        });
        newTagContainer.addView(tagName);
        newTagContainer.addView(TagCategorySpinner);
        newTagContainer.addView(TagSpinner);

        descriptionContainer.addView(Description);
        descriptionContainer.addView(descriptionText);

        masterContainer.addView(newTagContainer);
        masterContainer.addView(descriptionContainer);
        tagContainer.addView(masterContainer);

    }
}
