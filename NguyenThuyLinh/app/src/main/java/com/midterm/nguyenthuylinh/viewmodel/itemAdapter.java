package com.midterm.nguyenthuylinh.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.midterm.nguyenthuylinh.R;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.nguyenthuylinh.model.item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    private List<item> items;


    public itemAdapter(List<item> items)
    {
        this.items =items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.ViewHolder holder, int position) {

        holder.tvTitle.setText(items.get(position).getTitle());
        holder.tvTime.setText(items.get(position).getTimeStamp());
        holder.tvDesc.setText(items.get(position).getDesc());








    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvDesc;
        public TextView tvTime;

//        public Button btnDelete;
//        public ImageView ivImage;


        public ViewHolder(View itemview) {
            super(itemview);


            tvTitle = itemview.findViewById(R.id.tv_title);
            tvDesc= itemview.findViewById(R.id.tv_desc);
            tvTime= itemview.findViewById(R.id.tv_time);








        }
    }
}
