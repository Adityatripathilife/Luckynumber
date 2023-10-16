package com.example.a15luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText text_edit;
    Button button;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview =findViewById(R.id.textView);
       text_edit = findViewById(R.id.text_edit);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = text_edit.getText().toString();
                // explict Intent
                Intent i = new Intent(
                        getApplicationContext(),
                        Secondactivity.class
                );
                //Passing the name of second activity
                i.putExtra("name",username);
                startActivity(i);

            }
        });

    }
}