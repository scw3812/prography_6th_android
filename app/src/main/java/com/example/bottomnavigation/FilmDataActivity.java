package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FilmDataActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_data);

        FilmData filmData = (FilmData)getIntent().getSerializableExtra("filmData");
        textView = (TextView)findViewById(R.id.film_info);

        String film_info = filmData.getTitle() + "\n설명 : " + filmData.getDescription() +
                "\n감독 : " + filmData.getDirector() + "\n제작자 : " + filmData.getProducer() +
                "\n출시년도 : " + filmData.getReleaseDate() +"\n평점 : " + filmData.getRtScore();
        textView.setText(film_info);
    }
}
