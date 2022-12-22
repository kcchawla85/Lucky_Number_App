package com.kunal.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class verylucky extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verylucky);
        welcomeTxt= findViewById(R.id.textView2);
        luckyNumberTxt=findViewById(R.id.lucky_number_txt);
        share_btn=findViewById(R.id.share_number_btn);
        //username data
        Intent i = getIntent();
        String userName= i.getStringExtra("name");
        Toast.makeText(this, "Username: "+userName, Toast.LENGTH_SHORT).show();
        //random numbe rgenerated
        int random_Num= generateRandomNumber();
        luckyNumberTxt.setText(""+random_Num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share_data(userName,random_Num);
            }
        });
    }
    public int generateRandomNumber()
    {
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(1000);
        return randomNumberGenerated;
    }
    public void share_data(String username, int randomNumber)
    {
        //Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, username+" got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, username+" lucky number is "+randomNumber);
        startActivity(Intent.createChooser(i,"Choose a Platform to SEND"));

    }
}