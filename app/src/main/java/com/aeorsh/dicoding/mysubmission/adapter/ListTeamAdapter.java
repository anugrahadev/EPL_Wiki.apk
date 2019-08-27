package com.aeorsh.dicoding.mysubmission.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aeorsh.dicoding.mysubmission.R;
import com.aeorsh.dicoding.mysubmission.model.Team;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.ListViewHolder> {
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Team data);
    }

    private ArrayList<Team> listProv;
    public ListTeamAdapter(ArrayList<Team> list) {
        this.listProv = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_team, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Team prov = listProv.get(position);
        Glide.with(holder.itemView.getContext())
                .load(prov.getPic())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(prov.getName());
        holder.tvKonten.setText(prov.getKonten());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickCallback.onItemClicked(listProv.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProv.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvKonten;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_pic);
            tvName = itemView.findViewById(R.id.tv_namep);
            tvKonten = itemView.findViewById(R.id.tv_konten);
        }
    }
}