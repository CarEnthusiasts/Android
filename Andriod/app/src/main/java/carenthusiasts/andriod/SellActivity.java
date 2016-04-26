package carenthusiasts.andriod;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SellActivity extends AppCompatActivity {

    private String make ="NULL";
    private String model = "NULL";
    private String year = "NULL";
    private String price = "NULL";
    private String mileage = "NULL";
    private String cylinders = "NULL";
    private String displacement = "NULL";
    private String hp = "NULL";
    private String tq = "NULL";
    private String zerosixty = "NULL";
    private String topspeed = "NULL";
    private String sixtyzero = "NULL";
    private String seats = "NULL";
    private String exterior = "NULL";
    private String interior = "NULL";
    private String drivetrain = "NULL";
    private String transmission = "NULL";
    private String fuel = "NULL";
    private String bodytype = "NULL";
    private String picture = "NULL";
    private String useremail = "0";
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                useremail= null;
            } else {
                useremail= extras.getString("USER");
            }
        } else {
            useremail= (String) savedInstanceState.getSerializable("USER");
        }


        setContentView(R.layout.activity_sell);
        createNextButton();
        createAllSpinners();
        createImageButton();
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
                loadcar();

            }
        });
    }
    private void loadcar(){
        String hold="";
        if(year.equals("Select")){
            year="NULL";
        }
        if(exterior.equals("Select")){
            exterior="NULL";
        }
        if(interior.equals("Select")){
            interior="NULL";
        }
        if(drivetrain.equals("Select")){
            drivetrain="NULL";
        }
        if(transmission.equals("Select")){
            transmission="NULL";
        }
        if(fuel.equals("Select")){
            fuel="NULL";
        }
        if(bodytype.equals("Select")){
            bodytype="NULL";
        }
        EditText priceT = (EditText) findViewById(R.id.PriceEditText);
        hold =priceT.getText().toString();
        if(hold.equals("")){
            price="NULL";
        }
        else{
            price=hold;
        }
        EditText mileageT = (EditText) findViewById(R.id.MileageEditText);
        hold =mileageT.getText().toString();
        if(hold.equals("")){
            mileage="NULL";
        }
        else{
            mileage=hold;
        }
        EditText cylindersT = (EditText) findViewById(R.id.cylindersEditText);
        hold =cylindersT.getText().toString();
        if(hold.equals("")){
            cylinders="NULL";
        }
        else{
            cylinders=hold;
        }
        EditText displacementT = (EditText) findViewById(R.id.EngineDisplacementEditText);
        hold =displacementT.getText().toString();
        if (hold.equals("")){
            displacement="NULL";
        }
        else{
            displacement=hold;
        }
        EditText hpT = (EditText) findViewById(R.id.HPEditText);
        hold =hpT.getText().toString();
        if(hold.equals("")){
            hp="NULL";
        }
        else{
            hp=hold;
        }
        EditText tqT = (EditText) findViewById(R.id.TorqueEditText);
        hold =tqT.getText().toString();
        if(hold.equals("")){
            tq="NULL";
        }
        else{
            tq=hold;
        }
        EditText zeroSixtyT = (EditText) findViewById(R.id.ZeroSixtyEditText);
        hold =zeroSixtyT.getText().toString();
        if(hold.equals("")){
            zerosixty="NULL";
        }
        else{
            zerosixty=hold;
        }
        EditText sixtyzeroT = (EditText) findViewById(R.id.SixtyZeroEditText);
        hold =sixtyzeroT.getText().toString();
        if(hold.equals("")){
            sixtyzero="NULL";
        }
        else{
            sixtyzero=hold;
        }

        EditText topspeedT = (EditText) findViewById(R.id.TopspeedEditText);
        hold =topspeedT.getText().toString();
        if(hold.equals("")){
            topspeed="NULL";
        }
        else{
            topspeed=hold;
        }
        EditText seatsT = (EditText) findViewById(R.id.SeatsEditText);
        hold =seatsT.getText().toString();
        if(hold.equals("")){
            seats="NULL";
        }
        else{
            seats=hold;
        }
        TextView pictureT = (TextView) findViewById(R.id.imageURI);
        hold =pictureT.getText().toString();
        if(hold.equals("")){
            picture="NULL";
        }
        else{
            picture=hold;
        }

        if(!year.equals("NULL")&&!price.equals("NULL")){

//            Toast.makeText(SellActivity.this, make+","+model+","+year+","+price+","+mileage+" ,"+cylinders+","+displacement+","+
//                          hp+","+tq+","+zerosixty+" ,"+topspeed+","+sixtyzero+","+seats+","+exterior+" ,"+interior
//                            +","+drivetrain+" ,"+transmission+","+fuel+","+bodytype+","+picture+",,,"+useremail, Toast.LENGTH_LONG).show();
            new CarPHPLoader(SellActivity.this).execute(make,model,year,price,mileage,cylinders,displacement,
                    hp,tq,zerosixty,topspeed,sixtyzero,seats,exterior,interior,drivetrain,transmission,
                    fuel,bodytype,picture,useremail);
        }
        //
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
                "Alfa Romeo","Aston Martin","Audi", "BMW","Chevrolet","Dodge","Ferrari","Honda"
        };
        int makePosition = 1;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //adds the listener to the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SellActivity.this,
                        android.R.layout.simple_spinner_item, modelString);
                make = makeString[position];
                final String[] resultString = modelString;
                modelSpinner.setAdapter(adapter);
                modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

                                                           @Override
                                                           public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                                                               // TODO Auto-generated method stub
                                                               model= resultString[position];

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
    private void createYearSpinner(){
        final String[] yearString = new String[]{
                "Select","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004"
                ,"2003","2002","2001","2000"
        };
        int yearMinPosition =3;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                year= yearString[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        };
        createSpinner(R.id.YearSpinner, yearString, yearMinPosition, listener);
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
                exterior = exteriorColorString[position];

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
                interior=interiorColorString[position];

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
                drivetrain=drivetrainString[position];

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
                transmission=transmissionString[position];

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
                "Select","Gasoline","E-85","Electric"
        };
        int fuelPosition =4;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {    //int the listener for the spinner

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                fuel=fuelString[position];

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
                bodytype=bodyStyleString[position];

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
