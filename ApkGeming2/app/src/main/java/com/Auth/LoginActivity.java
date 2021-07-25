package com.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.API.APIRequestUser;
import com.API.APIUtils;
import com.Model.LoginRequest;
import com.Model.LoginResponse;
import com.example.apkgeming.MainActivity2;
import com.example.apkgeming.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public APIRequestUser apiRequestUser;
    private Button btnLogin;
    private EditText et_email, et_password;
    private String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fragment);
        apiRequestUser = APIUtils.getRequestUser();

        btnLogin = findViewById(R.id.login_btn);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findView();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this,"Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(LoginActivity.this,"Username: "+user+"Password: "+pass, Toast.LENGTH_SHORT).show();
                    cekData();
                }
            }
        });

    }

    public void cekData(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(pass);
        Call<LoginResponse> loginResponseCall = apiRequestUser.userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    Integer id = response.body().getId();
                    String user = response.body().getEmail();
                    String token = response.body().getToken();
                    String name = response.body().getName();

                    SharedPreference.setLoginId(getBaseContext(), id.toString());
                    SharedPreference.setLoginEmail(getBaseContext(), user);
                    SharedPreference.setLogInToken(getBaseContext(), token);
                    SharedPreference.setLoginName(getBaseContext(), name);
                    SharedPreference.setLoginStatus(getBaseContext(), true);
                    startActivity(new Intent(LoginActivity.this, MainActivity2.class));
                    finish();

                    Toast.makeText(getBaseContext(),"Selamat datang "+name, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(),"email atau password tidak valid : ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Login gagal", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void findView(){
        et_email = findViewById(R.id.login_email);
        email = et_email.getText().toString();
        et_password = findViewById(R.id.login_password);
        pass = et_password.getText().toString();
    }
}
