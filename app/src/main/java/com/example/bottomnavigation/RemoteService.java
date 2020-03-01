package com.example.bottomnavigation;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {
    @GET("films")
    Call<ArrayList<FilmData>>getFilms();
}
