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
import com.Model.DataModel;
import com.Model.ResponseModel;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class event extends AppCompatActivity {
    private RecyclerView rvData;
    public APIRequestUser apiRequestUser;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> lisData = new ArrayList<>();
    private TextView Hasil;
    private AdapterData adapterData;
    String Nama_Event;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        apiRequestUser = APIUtils.getRequestUser();
        rvData = findViewById(R.id.rv_event);
        recyclerView = findViewById(R.id.rv_event);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        eventData();
    }


    public void eventData(){
        APIRequestUser ardData = RetroServer.konekRetrofit().create(APIRequestUser.class);
        Call<ResponseModel> tampilData = ardData.ardEventData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Toast.makeText(event.this, "Berhasil memuat data" , Toast.LENGTH_SHORT).show();

                lisData = response.body().getData();

                adData = new AdapterData(event.this, lisData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(event.this, "Gagal Menghubungi Server "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}