package com.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.ModelJadwal;
import com.example.apkgeming.DetailJadwal;
import com.example.apkgeming.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class jadwalAdapter extends RecyclerView.Adapter<jadwalAdapter.HolderData>{
    private Context ctx;
    private List<ModelJadwal> listJadwal;

    public jadwalAdapter(Context ctx, List<ModelJadwal> listJadwal){
        this.ctx = ctx;
        this.listJadwal = listJadwal;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_jadwal, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelJadwal mj = listJadwal.get(position);
        holder.tvId.setText(String.valueOf(mj.getId_jadwal()));
        holder.tvIdteam.setText(String.valueOf(mj.getId_team()));
        holder.tvKet.setText(mj.getKeterangan());
        holder.List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailJadwal.class );
                Gson gson = new Gson();
                String str = gson.toJson(listJadwal.get(position), ModelJadwal.class);
                intent.putExtra("extra", str);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJadwal.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvKet, tvId, tvIdteam;
        RelativeLayout List;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvIdteam = itemView.findViewById(R.id.tv_idteam);
            tvKet = itemView.findViewById(R.id.tv_idket);
            List = itemView.findViewById(R.id.card_jadwal);
        }
    }
}