package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.API.APIRequestUser;
import com.API.RetroServer;
import com.Adapter.TeamAdapter;
import com.Adapter.jadwalAdapter;
import com.Model.JadwalResponse;
import com.Model.ModelJadwal;
import com.Model.TeamModel;
import com.Model.TeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class team extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<TeamModel> lisData = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        rvData = findViewById(R.id.rv_team);
        recyclerView = findViewById(R.id.rv_team);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        getTeam();
    }

    public void getTeam() {
        APIRequestUser ardData = RetroServer.konekRetrofit().create(APIRequestUser.class);
        Call<TeamResponse> tampilData = ardData.ardTeamData();
        tampilData.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {

                Toast.makeText(team.this, "Berhasil memuat data", Toast.LENGTH_SHORT).show();

                lisData = response.body().getData();

                adData = new TeamAdapter(team.this, lisData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(team.this, "Gagal Menghubungi Server "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}