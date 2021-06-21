package com.example.a2_saqibusman_191119.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2_saqibusman_191119.R;

import java.util.ArrayList;

public class recyclerAdapter  extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {
    Context context;
    ArrayList get_id,get_name,get_city,get_age;

    public recyclerAdapter(Context context, ArrayList get_id, ArrayList get_name, ArrayList get_city, ArrayList get_age) {
        this.context = context;
        this.get_id = get_id;
        this.get_name = get_name;
        this.get_city = get_city;
        this.get_age = get_age;
    }

    @NonNull
    @Override
    public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewdesign,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.ViewHolder holder, int position) {
        holder.txt_id.setText("ID: " + String.valueOf(get_id.get(position)));
        holder.txt_name.setText("Name: " + String.valueOf(get_name.get(position)));
        holder.txt_city.setText("City: " + String.valueOf(get_city.get(position)));
        holder.txt_age.setText("Age: " + String.valueOf(get_age.get(position)));

    }

    @Override
    public int getItemCount() {
        return get_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name,txt_id,txt_city,txt_age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id=itemView.findViewById(R.id.rdv_tv_id);
            txt_name=itemView.findViewById(R.id.rdv_tv_Name);
            txt_city=itemView.findViewById(R.id.rdv_tv_city);
            txt_age=itemView.findViewById(R.id.rdv_tv_age);
        }
    }
}
