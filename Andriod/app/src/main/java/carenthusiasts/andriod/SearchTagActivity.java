package carenthusiasts.andriod;

import android.content.Intent;
import android.graphics.Color;
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

public class SearchTagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tag);
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
        LinearLayout newTagContainer = new LinearLayout(SearchTagActivity.this);
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        newTagContainer.setLayoutParams(linLayoutParam);
        newTagContainer.setOrientation(LinearLayout.HORIZONTAL);

        TextView tagName = new TextView(SearchTagActivity.this);
        tagName.setText("Select new Tag: ");
        tagName.setTextAppearance(this,android.R.style.TextAppearance_Medium);  //deprecated but new version without passing This requires api 23+
        Spinner TagCategorySpinner = new Spinner(SearchTagActivity.this);

        final Spinner TagSpinner = new Spinner(SearchTagActivity.this);

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
                                                             Toast.makeText(getBaseContext(), resultString[position], Toast.LENGTH_SHORT).show();

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
