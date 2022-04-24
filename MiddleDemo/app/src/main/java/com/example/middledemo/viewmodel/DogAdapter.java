package com.example.middledemo.viewmodel;


import com.example.middledemo.R;
import com.example.middledemo.model.DogBreed;
import com.example.middledemo.model.DogBreed;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NavigableMap;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder>  {


    private  ArrayList<DogBreed> dogBreeds;



    public DogAdapter(ArrayList<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dogs_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {

        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvOrigin.setText(dogBreeds.get(position).getOrigin());
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.ivAvatar);





    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;


        public ViewHolder(View itemview) {
            super(itemview);


            tvName = itemview.findViewById(R.id.tv_name);
            tvOrigin= itemview.findViewById(R.id.tv_origin);
            ivAvatar = itemview.findViewById(R.id.iv_avatar);





        }
    }
}
