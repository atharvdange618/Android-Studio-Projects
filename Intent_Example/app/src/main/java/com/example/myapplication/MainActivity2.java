package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Items;

public class MainActivity2 extends AppCompatActivity {

    EditText quantity;
    TextView tv1;
    Button btn;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initResources();
    }

    private void initResources() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iv = findViewById(R.id.iv_image);
        tv1 = findViewById(R.id.tv_total_item);
        Items item = (Items) getIntent().getExtras().getSerializable("Item");
        iv.setImageResource(item.getItemImg());
        tv1.setText(item.getHeader());
        quantity = findViewById(R.id.et_quantity);
        quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(this,"Amount: "+ quantity.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        btn = findViewById(R.id.btn_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}