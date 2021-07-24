package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.API.APIRequestUser;
import com.API.RetroServer;
import com.Adapter.GameAdapter;
import com.Adapter.TeamAdapter;
import com.Model.GameModel;
import com.Model.GameResponse;
import com.Model.TeamModel;
import com.Model.TeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class game extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<GameModel> lisData = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rvData = findViewById(R.id.rv_game);
        recyclerView = findViewById(R.id.rv_game);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        getGame();
    }

    public void getGame() {
        APIRequestUser ardData = RetroServer.konekRetrofit().create(APIRequestUser.class);
        Call<GameResponse> tampilData = ardData.ardGameData();
        tampilData.enqueue(new Callback<GameResponse>() {
            @Override
            public void onResponse(Call<GameResponse> call, Response<GameResponse> response) {

                Toast.makeText(game.this, "Berhasil memuat data", Toast.LENGTH_SHORT).show();

                lisData = response.body().getData();

                adData = new GameAdapter(game.this, lisData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GameResponse> call, Throwable t) {
                Toast.makeText(game.this, "Gagal Menghubungi Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}