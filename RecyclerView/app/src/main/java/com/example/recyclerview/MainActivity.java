package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapters.CustomRecyclerViewAdapter;
import com.example.recyclerview.models.SpinnerItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initResources();
    }

    private void initResources() {
        String[] country = {"india","russia","usa","china","australia"};
        List<SpinnerItemModel> dataList = new ArrayList<>();

        for(String con : country){
            SpinnerItemModel itemModel = new SpinnerItemModel(con.toUpperCase(Locale.ROOT),getResources().getIdentifier(con,"drawable",getPackageName()));
            dataList.add(itemModel);
            dataList.add(itemModel);
            dataList.add(itemModel);
            dataList.add(itemModel);
            dataList.add(itemModel);
        }
        recyclerView = findViewById(R.id.rv_countries);
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(this,dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}