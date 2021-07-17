package com.API;

import com.Model.LoginRequest;
import com.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIRequestUser {
    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
    @POST("api/logout")
    Call<LoginResponse> userLogout(@Header("Authorization") String token);
}