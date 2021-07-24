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

import com.Model.GameModel;
import com.example.apkgeming.R;
import com.google.gson.Gson;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.HolderData>{
    private Context ctx;
    private List<GameModel> listGame;

    public GameAdapter(Context ctx, List<GameModel> listGame){
        this.ctx = ctx;
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_game, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        GameModel gm = listGame.get(position);
        holder.tvId.setText(String.valueOf(gm.getId_game()));
        holder.tvIdgame.setText(String.valueOf(gm.getId_game()));
        holder.tvNama.setText(gm.getNama_game());
        holder.tvKet.setText(gm.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvKet, tvId, tvIdgame, tvNama;
        RelativeLayout List;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvIdgame = itemView.findViewById(R.id.tv_idgame);
            tvNama = itemView.findViewById(R.id.tv_ngm);
            tvKet = itemView.findViewById(R.id.tv_idket);
            List = itemView.findViewById(R.id.card_game);
        }
    }

}
