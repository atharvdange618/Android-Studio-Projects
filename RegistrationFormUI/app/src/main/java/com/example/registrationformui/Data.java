package com.example.registrationformui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        String name = getIntent().getStringExtra("Name");
        String gender = getIntent().getStringExtra("Gender");
        String qualification = getIntent().getStringExtra("Qualification");
        String subject = getIntent().getStringExtra("Subject");

        TextView txt = findViewById(R.id.textView);
        txt.setText(name + "\n" + gender + "\n" + qualification + "\n" + subject);

    }
}