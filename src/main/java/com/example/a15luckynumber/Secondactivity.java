package com.example.a15luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Secondactivity extends AppCompatActivity {

    TextView textView2,lucky_number;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        textView2 = findViewById(R.id.textView2);
        lucky_number = findViewById(R.id.lucky_number);
        btn2 = findViewById(R.id.btn2);

        // Recieving the data from main Activity
        Intent i = getIntent();
        String username = i.getStringExtra("name");

        // Generating Random Numbers

        int randomnum= Generate_random_number ();
        lucky_number.setText(""+randomnum);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedata ( username,randomnum);
            }
        });



    }
    public int  Generate_random_number(){
        Random random = new Random();
        int upper_limit  = 10000;
        int random_number_Generate = random.nextInt(upper_limit);
        return random_number_Generate;
    }
    public void sharedata(String username , int randomNum){
        // implement intent
        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        // Additional Info
        i.putExtra(getIntent().EXTRA_SUBJECT,username+"got lucky number today");
        i.putExtra(getIntent().EXTRA_SUBJECT,"his lucky number is : "+randomNum);

        startActivity(Intent.createChooser(i,"Choose the Platform"));
    }
}