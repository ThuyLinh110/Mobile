package com.example.dogapp.viewmodel;


import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
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

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder>  {


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
        holder.tvNameDetail.setText(dogBreeds.get(position).getName());
        holder.tvOriginDetail.setText(dogBreeds.get(position).getOrigin());
        holder.tvLifeSpanDetail.setText(dogBreeds.get(position).getLifeSpan());
        holder.tvBreedForDetail.setText(dogBreeds.get(position).getBreedFor());
        holder.tvBreedGroupDetail.setText(dogBreeds.get(position).getBreedGroup());
        holder.tvHeightDetail.setText(dogBreeds.get(position).getHeight());
        holder.tvWeightDetail.setText(dogBreeds.get(position).getWeight());




    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;
        public TextView tvNameDetail;
        public TextView tvOriginDetail;
        public TextView tvLifeSpanDetail;
        public TextView tvBreedForDetail;
        public TextView tvBreedGroupDetail;
        public TextView tvHeightDetail;
        public TextView tvWeightDetail;
        public LinearLayout lnMain;
        public LinearLayout lnDetail;

        public ViewHolder(View itemview) {
            super(itemview);

            lnMain = itemview.findViewById(R.id.ln_main);
            lnDetail = itemview.findViewById(R.id.ln_detail);
            tvName = itemview.findViewById(R.id.tv_name);
            tvOrigin= itemview.findViewById(R.id.tv_origin);
            ivAvatar = itemview.findViewById(R.id.iv_avatar);
            tvNameDetail = itemview.findViewById(R.id.tv_nameDetail);
            tvOriginDetail = itemview.findViewById(R.id.tv_originDetail);
            tvLifeSpanDetail =itemview.findViewById(R.id.tv_lifeSpanDetail);
            tvBreedForDetail = itemview.findViewById(R.id.tv_breedForDetail);
            tvBreedGroupDetail = itemview.findViewById(R.id.tv_breedGroupDetail);
            tvHeightDetail = itemview.findViewById(R.id.tv_HeightDetail);
            tvWeightDetail = itemview.findViewById(R.id.tv_weightDetail);

            itemview.setOnTouchListener(new OnSwipeTouchListener(itemview.getContext())
            {
                public void viewDetail()
                {
                    if (lnMain.getVisibility() == View.VISIBLE){
                        lnMain.setVisibility(View.INVISIBLE);
                        lnDetail.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        lnMain.setVisibility(View.VISIBLE);
                        lnDetail.setVisibility(View.INVISIBLE);
                    }
                }

                public void onClick(){
                    DogBreed dogBreed =dogBreeds.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed",dogBreed);
                    Navigation.findNavController(itemview).navigate(R.id.detailsFragment, bundle);
                }

                public void onSwipeRight()
                {
                    viewDetail();
                }
                public void onSwipeLeft()
                {
                    viewDetail();
                }
            });


        }
    }
}
