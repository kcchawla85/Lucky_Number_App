package com.kunal.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;
    EditText editText;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.luck);
        editText= findViewById(R.id.edit1);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name =editText.getText().toString();
                //explicit intent
                Intent i = new Intent(getApplicationContext(),verylucky.class);
                //passing the name
                i.putExtra("name",user_name);
                startActivity(i);
            }
        });

    }
}