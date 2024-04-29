package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight,edtHeight,edtHeightIn;
        Button btncal;

        edtWeight = findViewById(R.id.edtweight);
        edtHeight = findViewById(R.id.edtHeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btncal = findViewById(R.id.btncal);
        txtResult = findViewById(R.id.txtResult);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                float ft = Float.parseFloat(edtHeight.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());
                float totalIn = ft*12 + in ;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                if(bmi>25){
                    txtResult.setText("You are Over weight");
                } else if (bmi<18) {
                    txtResult.setText("You are Under weight");
                }else{
                    txtResult.setText("You are Healthy");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}