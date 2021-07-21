package com.API;

import com.Model.DataModel;
import com.Model.LoginRequest;
import com.Model.LoginResponse;
import com.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRequestUser {
    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("api/event")
    Call<ResponseModel> ardEventData();

    @GET("api/jadwal")
    Call<ResponseModel> ardJadwalData();

    @POST("api/logout")
    Call<LoginResponse> userLogout(@Header("Authorization") String token);
}