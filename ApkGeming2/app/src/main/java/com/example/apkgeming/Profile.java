package com.example.apkgeming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Auth.LoginActivity;

public class Profile extends AppCompatActivity {

    TextView nama;
    Button logout;

    SharedPreferences sharedPreferences;
    static final String PREF_NAME = "pref";
    static final String NAMA_SEDANG_LOGIN = "Name_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nama = findViewById(R.id.nama);
        logout = findViewById(R.id.edit);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(NAMA_SEDANG_LOGIN, null);

        if (nama !=null){
            nama.setText(name);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Profile.this, "Berhasil logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Profile.this, LoginActivity.class));
                finish();

            }
        });


    }
}
