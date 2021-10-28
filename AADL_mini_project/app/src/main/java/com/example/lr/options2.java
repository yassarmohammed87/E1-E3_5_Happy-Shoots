package com.example.lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class options2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options2);
        Button feedbackbtn = findViewById(R.id.ofeedback);
        Button appointmentbtn = findViewById(R.id.oappointment);
        Button gallerybtn = findViewById(R.id.oimages);

        feedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbackpg();
            }
        });
        appointmentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appointmentpg();
            }
        });
        gallerybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallerypg();
            }
        });
    }

    private void gallerypg() {
        Intent intent = new Intent(this, galllery.class);
        startActivity(intent);
    }

    private void appointmentpg() {
        Intent intent = new Intent(this, appointment.class);
        startActivity(intent);
    }

    private void feedbackpg() {
        Intent intent = new Intent(this, feedback.class);
        startActivity(intent);
    }
}