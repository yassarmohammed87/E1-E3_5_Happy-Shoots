package com.example.lr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class appointment extends AppCompatActivity {
    appointmentdb ADB;
    Button btpicker;
    TextView textview;
    TextView etlocation;
    EditText etname , etemail , etphonenumber , etdate, ettime;
    int PLACE_PICKER_REQUEST=1;
   boolean isAllFieldsChecked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        btpicker = findViewById(R.id.bt_picker);

        etname = findViewById(R.id.name);
        etemail = findViewById(R.id.Emailaddress);
        etphonenumber = findViewById(R.id.phonenumber);
        etdate = findViewById(R.id.editTextDate);
        ettime = findViewById(R.id.apptime);
        etlocation = findViewById(R.id.location);

        ADB=new appointmentdb(this);
        Button submit = findViewById(R.id.submitbt);


        btpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(appointment.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();

                }
            }
        });


        submit.setOnClickListener((v)->{
//            Intent i2 = new Intent(appointment.this, Thank_you.class);
//            startActivity(i2);

//            isAllFieldsChecked = CheckAllFields();
//                if (isAllFieldsChecked) {
                    String appname = etname.getText().toString();
                    String phnumber = etphonenumber.getText().toString();
                    String appemail = etemail.getText().toString();
                    String time = ettime.getText().toString();
                    String date = etdate.getText().toString();
                    String location = "mumbai";
            if(appname.length()==0 || phnumber.length()==0 ||appemail.length()==0||time.length()==0||date.length()==0) {
                Toast.makeText(getApplicationContext(), "Fill all the field", Toast.LENGTH_SHORT).show();
                }
            else {
                boolean success = ADB.insertData(appname, phnumber, appemail, time, date, location);
                if (success) {
                    Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(appointment.this, options2.class);
                    startActivity(i2);

                }
            }});



//        btpicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//                try {
//                    startActivityForResult(builder.build(appointment.this), PLACE_PICKER_REQUEST);
//
//                } catch (GooglePlayServicesRepairableException e) {
//                    e.printStackTrace();
//
//                } catch (GooglePlayServicesNotAvailableException e) {
//                    e.printStackTrace();
//
//                }
//            }
//        });
    }
    private boolean CheckAllFields(){
        if(etname.length()==0 || etemail.length()==0 ||etdate.length()==0||etphonenumber.length()==0||ettime.length()==0) {
            Toast.makeText(getApplicationContext(), "fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data , this);
                StringBuilder stringBuilder = new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);

                stringBuilder.append(latitude);
                stringBuilder.append(",");

                stringBuilder.append(longitude);
                etlocation.setText(stringBuilder.toString());
            }
        }
    }
}