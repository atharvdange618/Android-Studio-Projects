package com.example.loginpage_example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginpage_example.R;

import java.util.ArrayList;
import java.util.List;

public class CustomActAdapter extends ArrayAdapter<String> {
    private List<String> dataList;
    private List<String> originalDataList;
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null) {
                List<String> filteredList = new ArrayList<>();
                for (String data : originalDataList) {
                    if (data.startsWith(constraint.toString())) {
                        filteredList.add(data);
                    }
                }
                filterResults.count = filteredList.size();
                filterResults.values = filteredList;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            if (constraint != null && filterResults.count > 0) {
                List<String> filterDataList = new ArrayList<>();
                filterDataList.addAll((List<String>) filterResults.values);
                dataList = filterDataList;
                CustomActAdapter.this.notifyDataSetChanged();
            }
        }
    };
    private LayoutInflater mLayoutInflater;
    private Context context;


    public CustomActAdapter(@NonNull Context context, int layout, List<String> dataList) {
        super(context, layout, dataList);
        this.context = context;
        this.dataList = dataList;
        this.originalDataList = new ArrayList<>(dataList);
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
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
        View view = mLayoutInflater.inflate(R.layout.act_dropdown_item, null);
        TextView textView = view.findViewById(R.id.tv_state_name);
        String model = dataList.get(position);
        textView.setText(model);
        return view;
    }
}
