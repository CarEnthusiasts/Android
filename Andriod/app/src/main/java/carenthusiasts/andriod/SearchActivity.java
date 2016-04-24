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

    private String make = "null";
    private String model = "null";
    private String yearmin = "null";
    private String pricemin ="null";
    private String mileagemin = "null";
    private String cylindersmin = "null";
    private String displacementmin="null";
    private String hpmin ="null";
    private String tqmin = "null";
    private String zerosixtymin = "null";
    private String topspeedmin="null";
    private String sixtyzeromin = "null";
    private String seatsmin = "null";
    private String yearmax = "null";
    private String pricemax= "null";
    private String mileagemax ="null";
    private String cylindersmax = "null";
    private String displacementmax = "null";
    private String hpmax = "null";
    private String tqmax = "null";
    private String zerosixtymax= "null";
    private String topspeedmax= "null";
    private String sixtyzeromax = "null";
    private String seatsmax = "null";
    private String exterior = "null";
    private String interior = "null";
    private String drivetrain = "null";
    private String transmission = "null";
    private String fuel = "null";
    private String bodytype = "null";

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
        createSearchButton();

    }

    /** makes the MakeSpinner **/
    private void createMakeSpinner(){
        final String[] makeString = new String[]{
                "Alfa Romeo","Aston Martin","Audi", "BMW","Chevrolet","Dodge","Ferrari","Honda"
        };
        int makePosition = 1;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //adds the listener to the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                make = makeString[position];
                String[] modelString= new String[]{""};
                switch(position){
                    case 0:
                        modelString = new String[]{"4C","Guilia"};
                        break;
                    case 1:
                        modelString = new String[]{"DB4","DB5","DB7","DB9","Vanquish","Vantage","Rapide"};
                        break;
                    case 2:
                        modelString = new String[]{
                                "A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8"
                        };
                        break;
                    case 3:
                        modelString = new String[]{
                                "1 Series","2 Series","3 Series","4 Series","5 Series","6 Series","7 Series","8 Series","M1",
                                "1M","M2","M3","M4","M5","M6","X1","X2","X3","X4","X5","X6"
                        };
                        break;
                    case 4:
                        modelString = new String[]{
                                "Camaro","Cavalier","Cobalt","Corvette","Equinox","HHR","Impala","Malibu","S-10",
                                "Silverado","Spark","SS","SSR","Suburban","Tahoe","TrailBlazer","Volt"
                        };
                        break;
                    case 5:
                        modelString = new String[]{
                                "Avenger","Challenger","Charger","Dart","Durango","Grand Caravan","Intrepid","Neon","Ram 1500",
                                "Ram 2500","Ram 3500","Viper","Stratus"
                        };
                        break;
                    case 6:
                        modelString = new String[]{
                                "360","456","458","550","575","599","612 Scaglietti","California","Enzo",
                                "F12 Berlinetta","F355","F430","F50","F40","FF","Superamerica"
                        };
                        break;
                    case 7:
                        modelString = new String[]{
                                "Accord","Civic","CR-V","Crosstour","Element","Fit","HR-V","Insight","Odyssey",
                                "Passport","Pilot","Prelude","Ridgeline","S2000"
                        };
                        break;

                }
                Spinner modelSpinner = (Spinner) findViewById(R.id.ModelSpinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchActivity.this,
                        android.R.layout.simple_spinner_item, modelString);

                final String[] resultString = modelString;
                modelSpinner.setAdapter(adapter);
                modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

                   @Override
                   public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                       // TODO Auto-generated method stub

                        model = resultString[position];
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> arg0) {
                       // TODO Auto-generated method stub

                   }
               }
                );
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
                "Select","This","Needs","To","Change","Based","On","Make","Selected"
        };
        int modelPosition =2;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub


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
                "Select","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004"
                ,"2003","2002","2001","2000"
        };
        int yearMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                yearmin= yearMinString[position];

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
                "Select","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004"
                ,"2003","2002","2001","2000"
        };
        int yearMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                yearmax =yearMaxString[position];

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
                "Select","$1000","$2000","$3000","$4000","$5000","$6000","$7000","$8000","$9000","$10000",
                "$11000","$12000","$13000","$14000","$15000","$16000","$17000","$18000","$19000","$20000"
                ,"$25000","$30000","35000","$40000","$45000","$50000","$55000","$60000","$70000","$80000","$90000","100000"
        };
        int priceMinPosition =5;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                pricemin= priceMinString[position];

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
                "Select","$1000","$2000","$3000","$4000","$5000","$6000","$7000","$8000","$9000","$10000",
                "$11000","$12000","$13000","$14000","$15000","$16000","$17000","$18000","$19000","$20000"
                ,"$25000","$30000","35000","$40000","$45000","$50000","$55000","$60000","$70000","$80000","$90000","100000"
        };
        int priceMaxPosition =6;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                pricemax= priceMaxString[position];

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
                "Select","10000","20000","30000","40000","50000","60000","70000","80000","90000","100000"
        };
        int mileageMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                mileagemin =mileageMinString[position];

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
                "Select","10000","20000","30000","40000","50000","60000","70000","80000","90000","100000"
        };
        int mileageMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                mileagemax =mileageMaxString[position];

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
                "Select","4","6","8","10","12","16"
        };
        int cylindersMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                cylindersmin= cylindersMinString[position];

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
                "Select","4","6","8","10","12","16"
        };
        int cylindersMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                cylindersmax =cylindersMaxString[position];

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
                "Select","Blue","Green","Red","Black","White","Gold"
        };
        int exteriorColorPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                exterior=exteriorColorString[position];

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
                "Select","Tan","Light Tan","Red","Black","White","Gold"
        };
        int interiorColorPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                interior = interiorColorString[position];

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
                "Select","FWD","AWD","RWD","4x4"
        };
        int drivetrainPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                drivetrain = drivetrainString[position];

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
                "Select","Manual","Automatic","Other"
        };
        int transmissionPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                transmission = transmissionString[position];

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
                "Select","Gasoline","E-85","Electric"
        };
        int fuelPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                fuel = fuelString[position];

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
                "Select","Convertible","Coupe","Sedan","Wagon","Truck","SUV","Hatchback"
        };
        int bodyStylePosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                 bodytype = bodyStyleString[position];

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
                "Select","1","2","3","4","5","6","7","8","9"
        };
        int seatsMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                seatsmin = seatsMinString[position];

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
                "Select","1","2","3","4","5","6","7","8","9"
        };
        int seatsMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                seatsmax = seatsMaxString[position];

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
                "Select","100","150","200","250","300","350","400","450","500"
        };
        int hpMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                hpmin = hpMinString[position];

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
                "Select","100","150","200","250","300","350","400","450","500"
        };
        int hpMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                hpmax = hpMaxString[position];

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
                "Select","100","150","200","250","300","350","400","450","500"
        };
        int tqMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                tqmin = tqMinString[position];

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
                "Select","100","150","200","250","300","350","400","450","500"
        };
        int tqMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                tqmax = tqMaxString[position];

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
                "Select","1L","1.5L","2L","2.5L","3L","3.5L","4L","4.5L","5L","5.5L","6L"
        };
        int engineDisplacementMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                displacementmin = engineDisplacementMinString[position];

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
                "Select","1L","1.5L","2L","2.5L","3L","3.5L","4L","4.5L","5L","5.5L","6L"
        };
        int engineDisplacementMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                displacementmax = engineDisplacementMaxString[position];

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
                "Select", "1s","2s","3s","4s","5s","6s","7s","8s"
        };
        int zeroSixtyMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                zerosixtymin = zeroSixtyMinString[position];

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
                "Select","1s","2s","3s","4s","5s","6s","7s","8s"
        };
        int zeroSixtyMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                zerosixtymax = zeroSixtyMaxString[position];

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
                "Select","100","125","150","175","200","225"
        };
        int topSpeedMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                topspeedmin = topSpeedMinString[position];

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
                "Select","100","125","150","175","200","225"
        };
        int topSpeedMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                topspeedmax = topSpeedMaxString[position];

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
                "Select","10ft","20ft","30ft","40ft","50ft","60ft","70ft","80ft","90ft","100ft"
        };
        int sixtyZeroMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                sixtyzeromin = sixtyZeroMinString[position];

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
                "Select","10ft","20ft","30ft","40ft","50ft","60ft","70ft","80ft","90ft","100ft"
        };
        int sixtyZeroMaxPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                sixtyzeromax = sixtyZeroMaxString[position];

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
