package com.API;

import com.Model.GameResponse;
import com.Model.JadwalResponse;
import com.Model.LoginRequest;
import com.Model.LoginResponse;
import com.Model.ResponseModel;
import com.Model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIRequestUser {
    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("api/event")
    Call<ResponseModel> ardEventData();

    @GET("api/jadwal")
    Call<JadwalResponse> ardJadwalData();

    @GET("api/team")
    Call<TeamResponse> ardTeamData();

    @GET("api/game")
    Call<GameResponse> ardGameData();

    @POST("api/logout")
    Call<LoginResponse> userLogout(@Header("Authorization") String token);
}