package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.models.Items;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Items> {
    private ArrayList dataList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList dataList) {
        super(context, resource, dataList);
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getItemView(position);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getItemView(position);
    }

    private View getItemView(int position) {
        View view = layoutInflater.inflate(R.layout.list_view, null);
        ImageView icon = view.findViewById(R.id.iv_icon);
        TextView header = view.findViewById(R.id.tv_header);
        TextView price = view.findViewById(R.id.tv_price);
        Items model = (Items) dataList.get(position);
        icon.setImageDrawable(context.getDrawable(model.getItemImg()));
        header.setText(model.getHeader());
        price.setText(model.getPrice());
        RelativeLayout rlClick = view.findViewById(R.id.rl_click);
        rlClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Explicit Intent Example
                Intent intent = new Intent(context, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Item", model);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


        return view;
    }
}

