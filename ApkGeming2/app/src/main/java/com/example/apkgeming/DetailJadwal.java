package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.Model.DataModel;
import com.Model.JadwalModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailJadwal extends AppCompatActivity {

    public JadwalModel jm;
    TextView nama,id_game,id_team,tgl_mul,tgl_akh,keterangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal);
        nama = findViewById(R.id.dt_nama);
        id_game = findViewById(R.id.dt_idg);
        id_team = findViewById(R.id.dt_idt);
        tgl_mul = findViewById(R.id.dt_wm);
        tgl_akh = findViewById(R.id.dt_wa);
        keterangan = findViewById(R.id.dt_ket);
        getJadwal();
    }

    private void getJadwal() {
        String data = getIntent().getStringExtra("extra");
        Gson gson = new Gson();
        jm = gson.fromJson(data, JadwalModel.class);
        nama.setText(jm.getNama_jadwal());
        id_game.setText(String.valueOf(jm.getId_game()));
        id_team.setText(String.valueOf(jm.getId_team()));
        tgl_mul.setText(jm.getWaktu_mulai());
        tgl_akh.setText(jm.getWaktu_akhir());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            keterangan.setText(Html.fromHtml(jm.getKeterangan(), Html.FROM_HTML_MODE_LEGACY));
        } else
            keterangan.setText(Html.fromHtml(jm.getKeterangan()));
    }
}