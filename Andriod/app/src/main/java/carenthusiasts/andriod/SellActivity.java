package carenthusiasts.andriod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        createNextButton();
        createAllSpinners();
    }
    private  void createAllSpinners(){
        createMakeSpinner();
        createModelSpinner();
        createYearSpinner();
        createExteriorColorSpinner();
        createInteriorColorSpinner();
        createDrivetrainSpinner();
        createTransmissionSpinner();
        createFuelSpinner();
        createBodyStyleSpinner();
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

    /** makes the MakeSpinner **/
    private void createMakeSpinner(){
        final String[] makeString = new String[]{
                "Alfa Romeo","Aston Martin","Audi"
        };
        int makePosition = 1;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //adds the listener to the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                String[] modelString= new String[]{"4C","Guilia"};;
                switch(position){
                    case 0:
                        modelString = new String[]{"4C","Guilia"};
                        break;
                    case 1:
                        modelString = new String[]{"DB4","DB5","DB7","DB9","Vanquish","Vantage","Rapide"};
                }
                Spinner modelSpinner = (Spinner) findViewById(R.id.ModelSpinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SellActivity.this,
                        android.R.layout.simple_spinner_item, modelString);
                modelSpinner.setAdapter(adapter);
                //Toast.makeText(getBaseContext(), makeString[position], Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.MakeSpinner, makeString, makePosition, listener);
    }
    /** This function will create the model Spinner*/
    private void createModelSpinner(){
        final String[] modelString = new String[]{
                "This","Needs","To","Change","Based","On","Make","Selected"
        };
        int modelPosition =2;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), modelString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.ModelSpinner, modelString, modelPosition, listener);
    }
    /** This function will create the year minimum Spinner*/
    private void createYearSpinner(){
        final String[] yearString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int yearPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), yearMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.YearSpinner, yearString, yearPosition, listener);
    }
    private void createExteriorColorSpinner(){
        final String[] exteriorColorString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int exteriorColorPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), exteriorColorString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.exteriorColorSpinner, exteriorColorString, exteriorColorPosition, listener);
    }
    private void createInteriorColorSpinner(){
        final String[] interiorColorString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int interiorColorPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),interiorColorString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.interiorColorSpinner, interiorColorString, interiorColorPosition, listener);
    }
    private void createDrivetrainSpinner(){
        final String[] drivetrainString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int drivetrainPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),drivetrainString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.drivetrainSpinner, drivetrainString, drivetrainPosition, listener);
    }
    private void createTransmissionSpinner(){
        final String[] transmissionString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int transmissionPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),transmissionString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.transmissionSpinner, transmissionString, transmissionPosition, listener);
    }
    private void createFuelSpinner(){
        final String[] fuelString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int fuelPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),fuelString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.FuelSpinner, fuelString, fuelPosition, listener);
    }
    private void createBodyStyleSpinner(){
        final String[] bodyStyleString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int bodyStylePosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),bodyStyleString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.bodyStyleSpinner, bodyStyleString, bodyStylePosition, listener);

    }
    //** takes variables to make the load spinner and give listener */
    private void createSpinner(int spinnerName, String[] spinnerString,
                               int PositionInSearch, AdapterView.OnItemSelectedListener listener){
        final String[] arraySpinner =  spinnerString;
        Spinner s = (Spinner) findViewById(spinnerName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SellActivity.this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(listener);


    }
}
