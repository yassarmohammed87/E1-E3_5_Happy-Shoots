package com.example.lr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar;


import android.os.Bundle;

public class feedback extends AppCompatActivity {
    feedbackdb DB;
    EditText username,email,feedback;
    RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        username=findViewById(R.id.funame);
        email=findViewById(R.id.femail);
        feedback=findViewById(R.id.feedback);
        rating=findViewById(R.id.rating);




        DB=new feedbackdb(this);

        Button b=findViewById(R.id.fsubmit);

        b.setOnClickListener((v)->{

                    int rating_count=rating.getNumStars();
                    String uname=username.getText().toString();
                    String em=email.getText().toString();
                    String feed=feedback.getText().toString();

                    if (DB.insertData(uname,em,feed,rating_count)==Boolean.TRUE)
                    {
                        Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
                    }

                }












        );

    }


}


