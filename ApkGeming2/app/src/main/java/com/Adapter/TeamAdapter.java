package com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.TeamModel;
import com.example.apkgeming.R;
import com.google.gson.Gson;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.HolderData>{
    private Context ctx;
    private List<TeamModel> listTeam;

    public TeamAdapter(Context ctx, List<TeamModel> listTeam){
        this.ctx = ctx;
        this.listTeam = listTeam;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_team, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        TeamModel tm = listTeam.get(position);
        holder.tvId.setText(String.valueOf(tm.getId_team()));
        holder.tvIdteam.setText(String.valueOf(tm.getId_team()));
        holder.tvIdcoach.setText(String.valueOf(tm.getId_coach()));
        holder.tvNama.setText(tm.getNama_team());
    }

    @Override
    public int getItemCount() {
        return listTeam.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvNama, tvId, tvIdteam, tvIdcoach;
        RelativeLayout List;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvIdteam = itemView.findViewById(R.id.tv_idteam);
            tvIdcoach = itemView.findViewById(R.id.tv_idcoach);
            tvNama = itemView.findViewById(R.id.tv_namat);
            List = itemView.findViewById(R.id.card_team);
        }
    }
}
