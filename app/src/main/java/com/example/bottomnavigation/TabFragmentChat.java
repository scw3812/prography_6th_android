package com.example.bottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFragmentChat extends Fragment {

    private List<FilmData> dataList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_fragment, null);
        TextView textView = view.findViewById(R.id.fragment_textview);
        textView.setVisibility(View.GONE);

        dataList = new ArrayList<>();

        Call<ArrayList<FilmData>> result = NetworkHelper.getInstance().getRemoteService().getFilms();
        result.enqueue(new Callback<ArrayList<FilmData>>() {
            @Override
            public void onResponse(Call<ArrayList<FilmData>> call, Response<ArrayList<FilmData>> response) {
                if(response.isSuccessful()){
                    dataList = response.body();
                    RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.fragment_recyclerview);
                    recyclerView.setHasFixedSize(true);
                    ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(dataList, getActivity());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FilmData>> call, Throwable t) {

            }
        });

        return view;
    }
}
