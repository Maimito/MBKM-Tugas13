package com.mbkm.bp.tugas12.adapterr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.mbkm.bp.tugas12.DetailActivity;
import com.mbkm.bp.tugas12.R;
import com.mbkm.bp.tugas12.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<Result> result;
    String url = "https://image.tmdb.org/t/p/w500";

    public MovieAdapter(Context context, List<Result> result){
        this.context = context;
        this.result = result;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_movie, viewGroup, false);
        return new MovieViewHolder(itemView);
    }

    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i){
        movieViewHolder.movie_title.setText(result.get(i).getTitle());
        Glide.with(context).load(url + result.get(i).getBackdropPath())
                .override(400, 200)
                .centerCrop()
                .into(movieViewHolder.movie_poster);

        movieViewHolder.cv_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("backdrop", url + result.get(i).getBackdropPath());
                intent.putExtra("detail", result.get(i).getOverview());
                intent.putExtra("title", result.get(i).getTitle());
                context.startActivity(intent);
            }
        });
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ImageView movie_poster;
    private TextView movie_title;
    private CardView cv_movie;
        public MovieViewHolder(View itemView){
            super(itemView);

            movie_poster = itemView.findViewById(R.id.movie_poster);
            movie_title = itemView.findViewById(R.id.movie_title);
            cv_movie = itemView.findViewById(R.id.cv_movie);
        }
    }

    public int getItemCount(){
        return result.size();
    }
}
