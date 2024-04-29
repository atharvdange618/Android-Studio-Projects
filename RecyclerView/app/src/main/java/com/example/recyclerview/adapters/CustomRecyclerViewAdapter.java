package com.example.recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.SpinnerItemModel;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.RVViewHolder> {

    private List<SpinnerItemModel> mDataList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapter(Context context,List<SpinnerItemModel> dataList) {
        this.mDataList = dataList;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.spinner_dropdown_item,null);
        RVViewHolder viewHolder = new RVViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder rvViewHolder, int position) {
        SpinnerItemModel model = mDataList.get(position);
        rvViewHolder.countryIcon.setImageDrawable(mContext.getDrawable(model.getIvCountryIcon()));
        rvViewHolder.countryName.setText(model.getTvCountry());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class RVViewHolder extends RecyclerView.ViewHolder{

        ImageView countryIcon;
        TextView countryName;
        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            countryIcon = itemView.findViewById(R.id.iv_country_flag);
            countryName = itemView.findViewById(R.id.tv_country_name);
        }
    }
}
