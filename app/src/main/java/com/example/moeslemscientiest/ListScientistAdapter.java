package com.example.moeslemscientiest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListScientistAdapter extends RecyclerView.Adapter<ListScientistAdapter.ListViewHolder> {
    public ArrayList<Scientist> listScientist;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListScientistAdapter(ArrayList<Scientist> list){
        this.listScientist = list;
    }
    @NonNull
    @Override
    public ListScientistAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_scientist, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Scientist scientist = listScientist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(scientist.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listScientist.get(holder.getAdapterPosition()));
            }
        });

        holder.tvName.setText(scientist.getName());
        holder.tvDesc.setText(scientist.getDesc());
    }

    @Override
    public int getItemCount() {
        return listScientist.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Scientist data);
    }
}
