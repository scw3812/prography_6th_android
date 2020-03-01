package com.example.bottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ChatViewHolder> {

    private List<FilmData> dataList;
    private Context context;

    public ChatRecyclerViewAdapter(List<FilmData> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }
    @NonNull
    @Override
    public ChatRecyclerViewAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout)LayoutInflater.from(parent.getContext()).inflate(R.layout.row_film, parent, false);
        ChatViewHolder viewHolder = new ChatViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatRecyclerViewAdapter.ChatViewHolder holder, final int position) {
        holder.numTextView.setText(Integer.toString(position + 1));
        holder.titleTextView.setText(dataList.get(position).getTitle());
        holder.directorTextView.setText("감독 : " + dataList.get(position).getDirector());
        holder.dateTextView.setText("출시년도 : " + dataList.get(position).getReleaseDate());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FilmDataActivity.class);
                intent.putExtra("filmData", (Serializable)dataList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView numTextView, titleTextView, directorTextView, dateTextView;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.recyclerview_layout);
            numTextView = (TextView)itemView.findViewById(R.id.recyclerview_num);
            titleTextView = (TextView)itemView.findViewById(R.id.recyclerview_title);
            directorTextView = (TextView)itemView.findViewById(R.id.recyclerview_director);
            dateTextView = (TextView)itemView.findViewById(R.id.recyclerview_date);
        }
    }
}
