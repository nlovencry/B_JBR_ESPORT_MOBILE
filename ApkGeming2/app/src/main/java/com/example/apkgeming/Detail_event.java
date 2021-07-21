package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.Model.DataModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class Detail_event extends AppCompatActivity {

    public DataModel dm;
    ImageView gambar;
    TextView nama,tgl_mp,tgl_ap,tgl_mul,tgl_akh,slot,price,keterangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        gambar = findViewById(R.id.dt_gambar);
        nama = findViewById(R.id.dt_nama);
        tgl_mp = findViewById(R.id.dt_tmp);
        tgl_ap = findViewById(R.id.dt_tap);
        tgl_mul = findViewById(R.id.dt_tm);
        tgl_akh = findViewById(R.id.dt_ta);
        slot = findViewById(R.id.dt_slot);
        price = findViewById(R.id.dt_price);
        keterangan = findViewById(R.id.dt_ket);
        getEvent();
    }

    private void getEvent() {
        String data = getIntent().getStringExtra("extra");
        Gson gson = new Gson();
        dm = gson.fromJson(data, DataModel.class);
        nama.setText(dm.getNama_event());
        tgl_mp.setText(dm.getTgl_mulai_pendaftaran());
        tgl_ap.setText(dm.getTgl_akhir_pendaftaran());
        tgl_mul.setText(dm.getTanggal_mulai());
        tgl_akh.setText(dm.getTanggal_akhir());
        slot.setText(dm.getSlot());
        price.setText(dm.getPrice());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            keterangan.setText(Html.fromHtml(dm.getKeterangan(), Html.FROM_HTML_MODE_LEGACY));
        } else
            keterangan.setText(Html.fromHtml(dm.getKeterangan()));
        String url = "http://192.168.88.250:8000/images/"+dm.getGambar();
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(gambar);
    }


}