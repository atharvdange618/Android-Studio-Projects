package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Adapters.CustomAdapter;
import com.example.myapplication.models.Items;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private ListView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initResources();
        Log.e("tag", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("tag1", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("tag2", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tag3", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("tag4", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("tag5", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tag6", "onDestroy");
    }

    private void initResources() {
        items = findViewById(R.id.lv_items);
        String[] itemList = {"pencil", "pen", "notebook", "brush", "scissors", "divider"};
        Integer[] itemPrice = {5, 20, 55, 25, 45, 15};
        ArrayList<Items> arrayList = new ArrayList<>();

        int i = 0;
        for (String s : itemList) {
            Items item = new Items(getResources().getIdentifier(s, "drawable", getPackageName()), s.toUpperCase(Locale.ROOT), String.valueOf(itemPrice[i]));
            arrayList.add(item);
            i++;
        }

        CustomAdapter adapter = new CustomAdapter(MainActivity3.this, R.layout.list_view, arrayList);

        items.setAdapter(adapter);

    }

}