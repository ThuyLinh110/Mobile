package com.example.posterapp.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posterapp.R;
import com.example.posterapp.model.Poster;
import com.example.posterapp.model.PosterAPI;
import com.example.posterapp.model.PosterDao;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.ViewHolder> {


    private List<Poster> Posters;
    private PosterDao posterDAO;


    public PosterAdapter(List<Poster> Posters)
    {
        this.Posters =Posters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poster_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterAdapter.ViewHolder holder, int position) {

        holder.tvName.setText(Posters.get(position).getName());
        holder.tvBuy.setText("- Buy : "+Posters.get(position).getBuy());
        holder.tvSell.setText("- Sell : "+Posters.get(position).getSell());


        Picasso.get().load(Posters.get(position).getImage()).into(holder.ivImage);





    }

    @Override
    public int getItemCount() {
        return Posters.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvBuy;
        public TextView tvSell;

        public Button btnDelete;
        public ImageView ivImage;


        public ViewHolder(View itemview) {
            super(itemview);


            tvName = itemview.findViewById(R.id.tv_name);
            tvBuy= itemview.findViewById(R.id.tv_buy);
            tvSell= itemview.findViewById(R.id.tv_sell);
            ivImage = itemview.findViewById(R.id.iv_image);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Poster pos= Posters.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("poster",pos);
                    Navigation.findNavController(itemview).navigate(R.id.detailFragment, bundle);

                }
            });





        }
    }
}
