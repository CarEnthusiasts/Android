package carenthusiasts.andriod;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class SearchActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_search);


        createMakeSpinner();
        createModelSpinner();
        createYearMinSpinner();
        createYearMaxSpinner();
        createPriceMinSpinner();
        createPriceMaxSpinner();
        createMileageMinSpinner();
        createMileageMaxSpinner();
        createCylindersMinSpinner();
        createCylingersMaxSpinner();
        createExteriorColorSpinner();
        createInteriorColorSpinner();
        createDrivetrainSpinner();
        createTransmissionSpinner();
        createFuelSpinner();
        createBodyStyleSpinner();
        createSeatsMinSpinner();
        createSeatsMaxSpinner();
        createHorsepowerMinSpinner();
        createHorsepowerMaxSpinner();
        createTorqueMinSpinner();
        createTorqueMaxSpinner();
        createEngineDisplacementMinSpinner();
        createEngineDisplacementMaxSpinner();
        createZeroSixtyMinSpinner();
        createZeroSixtyMaxSpinner();
        createTopSpeedMinSpinner();
        createTopSpeedMaxSpinner();
        createSixtyZeroMinSpinner();
        createSixtyZeroMaxSpinner();
        createImageButton();
        createSearchButton();

    }
    private void createImageButton(){
        ImageButton buttonLoadImage = (ImageButton) findViewById(R.id.searchImageButton);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data
                )
        {
            Uri selectedImage = data.getData();
          /*  String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

          //  ImageView imageView = (ImageView) findViewById(R.id.imageView);
           // imageView.setImageURI(selectedImage);
*/
            TextView imageURI = (TextView) findViewById(R.id.imageURI);
            imageURI.setText(selectedImage.toString());
            //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }

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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchActivity.this,
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
    private void createYearMinSpinner(){
        final String[] yearMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int yearMinPosition =3;
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
        createSpinner(R.id.minYearSpinner, yearMinString, yearMinPosition, listener);
    }
    /** This function will create the year max Spinner*/
    private void createYearMaxSpinner(){
        final String[] yearMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int yearMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),yearMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxYearSpinner, yearMaxString, yearMaxPosition, listener);
    }
    /** This function will create the year minimum Spinner*/
    private void createPriceMinSpinner(){
        final String[] priceMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int priceMinPosition =5;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), priceMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minPriceSpinner, priceMinString, priceMinPosition, listener);
    }
    /** This function will create the model Spinner*/
    private void createPriceMaxSpinner(){
        final String[] priceMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int priceMaxPosition =6;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),priceMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxPriceSpinner, priceMaxString, priceMaxPosition, listener);
    }
    /** This function will create the mileage minimum Spinner*/
    private void createMileageMinSpinner(){
        final String[] mileageMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int mileageMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), mileageMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minMileageSpinner, mileageMinString, mileageMinPosition, listener);
    }
    /** This function will create the model Spinner*/
    private void createMileageMaxSpinner(){
        final String[] mileageMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int mileageMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),mileageMaxString[position], /.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxMileageSpinner, mileageMaxString, mileageMaxPosition, listener);
    }
    private void createCylindersMinSpinner(){
        final String[] cylindersMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int cylindersMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), cylindersMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minCylinderSpinner, cylindersMinString, cylindersMinPosition, listener);
    }
    private void createCylingersMaxSpinner(){
        final String[] cylindersMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int cylindersMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),cylindersMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxCylinderSpinner, cylindersMaxString, cylindersMaxPosition, listener);
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
        createSpinner(R.id.TransmissionSpinner, transmissionString, transmissionPosition, listener);
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
    private void createSeatsMinSpinner(){
        final String[] seatsMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int seatsMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), seatsMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minSeatsSpinner, seatsMinString, seatsMinPosition, listener);
    }
    private void createSeatsMaxSpinner(){
        final String[] seatsMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int seatsMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),seatsMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxSeatsSpinner, seatsMaxString, seatsMaxPosition, listener);
    }
    private void createHorsepowerMinSpinner(){
        final String[] hpMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int hpMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), hpMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minHpSpinner, hpMinString, hpMinPosition, listener);
    }
    private void createHorsepowerMaxSpinner(){
        final String[] hpMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int hpMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),hpMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxHpSpinner, hpMaxString, hpMaxPosition, listener);
    }
    private void createTorqueMinSpinner(){
        final String[] tqMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int tqMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), tqMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minTqSpinner, tqMinString, tqMinPosition, listener);
    }
    private void createTorqueMaxSpinner(){
        final String[] tqMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int tqMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),tqMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxTqSpinner, tqMaxString, tqMaxPosition, listener);
    }
    private void createEngineDisplacementMinSpinner(){
        final String[] engineDisplacementMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int engineDisplacementMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), engineDisplacementMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minEngineDisplacementSpinner, engineDisplacementMinString, engineDisplacementMinPosition, listener);
    }
    private void createEngineDisplacementMaxSpinner(){
        final String[] engineDisplacementMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int engineDisplacementMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),engineDisplacementMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxEngingeDisplacementSpinner, engineDisplacementMaxString, engineDisplacementMaxPosition, listener);
    }
    private void createZeroSixtyMinSpinner(){
        final String[] zeroSixtyMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int zeroSixtyMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), zeroSixtyMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minZeroSixtySpinner, zeroSixtyMinString, zeroSixtyMinPosition, listener);
    }
    private void createZeroSixtyMaxSpinner(){
        final String[] zeroSixtyMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int zeroSixtyMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),zeroSixtyMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxZeroSixtySpinner, zeroSixtyMaxString, zeroSixtyMaxPosition, listener);
    }
    private void createTopSpeedMinSpinner(){
        final String[] topSpeedMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int topSpeedMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), topSpeedMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minTopSpeedSpinner, topSpeedMinString, topSpeedMinPosition, listener);
    }
    private void createTopSpeedMaxSpinner(){
        final String[] topSpeedMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int topSpeedMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),topSpeedMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxTopSpeedSpinner, topSpeedMaxString, topSpeedMaxPosition, listener);
    }
    private void createSixtyZeroMinSpinner(){
        final String[] sixtyZeroMinString = new String[]{
                "1912","1913","1914","1873","1874","1875"
        };
        int sixtyZeroMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), sixtyZeroMinString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.minSixtyZeroSpinner, sixtyZeroMinString, sixtyZeroMinPosition, listener);
    }
    private void createSixtyZeroMaxSpinner(){
        final String[] sixtyZeroMaxString = new String[]{
                "This","Needs","To","Change","Based","On","max","years"
        };
        int sixtyZeroMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),sixtyZeroMaxString[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.maxSixtyZeroSpinner, sixtyZeroMaxString, sixtyZeroMaxPosition, listener);
    }
    private void createSearchButton(){
        final Button SearchButton = (Button) findViewById(R.id.nextButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SearchTagActivity.class);
                //i.putExtra("PersonID", personID);
                startActivity(i);
            }
        });
    }
    //** takes variables to make the load spinner and give listener */
    private void createSpinner(int spinnerName, String[] spinnerString,
                               int PositionInSearch, AdapterView.OnItemSelectedListener listener){
        final String[] arraySpinner =  spinnerString;
        Spinner s = (Spinner) findViewById(spinnerName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(listener);


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
            Intent i = new Intent(getBaseContext(), ProfileActivity.class);
            //i.putExtra("PersonID", personID);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
