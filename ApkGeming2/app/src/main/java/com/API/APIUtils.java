package com.API;

import retrofit2.Retrofit;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "http://workshopjti.com/sipasport/public/";
    public static APIRequestUser getRequestUser(){
        return RetrofitClient.getClient(API_URL).create(APIRequestUser.class);
    }
}
