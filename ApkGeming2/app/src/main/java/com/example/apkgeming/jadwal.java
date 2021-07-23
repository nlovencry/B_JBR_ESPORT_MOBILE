package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.API.APIRequestUser;
import com.API.APIUtils;
import com.API.RetroServer;
import com.Adapter.AdapterData;
import com.Adapter.jadwalAdapter;
import com.Model.JadwalResponse;
import com.Model.ModelJadwal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class jadwal extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<ModelJadwal> lisData = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
        rvData = findViewById(R.id.rv_jadwal);
        recyclerView = findViewById(R.id.rv_jadwal);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        getJadwal();
    }

    public void getJadwal() {
        APIRequestUser ardData = RetroServer.konekRetrofit().create(APIRequestUser.class);
        Call<JadwalResponse> tampilData = ardData.ardJadwalData();
        tampilData.enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {

                Toast.makeText(jadwal.this, "Berhasil memuat data", Toast.LENGTH_SHORT).show();

                lisData = response.body().getData();

                adData = new jadwalAdapter(jadwal.this, lisData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                Toast.makeText(jadwal.this, "Gagal Menghubungi Server "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}