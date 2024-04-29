package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.myViewHolder> {

    ArrayList<ContactModel> contactModelsList;
    Context context;

    public ContactAdapter(Context context,ArrayList<ContactModel> list) {
        this.contactModelsList = list;
        this.context=context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        ContactModel model = contactModelsList.get(position);

        holder.contactNumber.setText(model.getContactNumber());
        holder.contactName.setText(model.getContactName());

    }

    @Override
    public int getItemCount() {
        return contactModelsList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView contactNumber;
        TextView contactName;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            contactName = itemView.findViewById(R.id.txtName);
            contactNumber = itemView.findViewById(R.id.txtNumber);
        }
    }
}
