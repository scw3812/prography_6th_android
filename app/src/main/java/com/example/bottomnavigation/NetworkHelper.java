package com.example.bottomnavigation;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    public final static NetworkHelper networkHelper = new NetworkHelper();

    public NetworkHelper(){
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
            .build();

    RemoteService remoteService = retrofit.create(RemoteService.class);

    public static NetworkHelper getInstance(){
        return networkHelper;
    }

    public RemoteService getRemoteService(){
        return remoteService;
    }
}
