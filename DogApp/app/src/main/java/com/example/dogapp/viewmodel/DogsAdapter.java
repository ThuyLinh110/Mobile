package com.example.dogapp.viewmodel;


import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder>{


    private  ArrayList<DogBreed> dogBreeds;

    public DogsAdapter(ArrayList<DogBreed> dogBreeds) {
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
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {

        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvOrigin.setText(dogBreeds.get(position).getOrigin());
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;
        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvOrigin= view.findViewById(R.id.tv_origin);
            ivAvatar = view.findViewById(R.id.iv_avatar);

        }
    }
}
