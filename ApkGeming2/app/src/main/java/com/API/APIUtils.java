package com.API;

import retrofit2.Retrofit;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "http://192.168.88.250:8000/";
    public static APIRequestUser getRequestUser(){
        return RetrofitClient.getClient(API_URL).create(APIRequestUser.class);
    }
}
