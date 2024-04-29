package com.example.loginpage_example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginpage_example.R;
import com.example.loginpage_example.models.SpinnerItemModel;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<SpinnerItemModel> {
    private List<SpinnerItemModel> dataList;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public CustomSpinnerAdapter(@NonNull Context context, int layout, List<SpinnerItemModel> dataList) {
        super(context, layout, dataList);
        this.context = context;
        this.dataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
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
        View view = mLayoutInflater.inflate(R.layout.spinner_dropdown_item, null);
        ImageView imageView = view.findViewById(R.id.iv_country_flag);
        TextView textView = view.findViewById(R.id.tv_country_name);
        SpinnerItemModel model = dataList.get(position);
        imageView.setImageDrawable(context.getDrawable(model.getIvCountryIcon()));
        textView.setText(model.getTvCountry());
        return view;
    }
}
