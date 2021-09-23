package com.mbkm.bp.tugas12.adapterr;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbkm.bp.tugas12.FavouriteDetailActivity;
import com.mbkm.bp.tugas12.MovieDetailActivity;
import com.mbkm.bp.tugas12.R;
import com.mbkm.bp.tugas12.fragm.favourite.List_Favourite;

import java.util.ArrayList;
import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder>{

    Context context;
    List<List_Favourite> lf;
    String url = "https://image.tmdb.org/t/p/w500";

    public FavAdapter(Context context, List<List_Favourite> lf){
        this.context = context;
        this.lf = lf;
    }

    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_fav, viewGroup, false);
        return new FavViewHolder(itemView);
    }

    public void onBindViewHolder(FavViewHolder favViewHolder, int i){
        favViewHolder.title.setText(lf.get(i).getTitle());
        favViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FavouriteDetailActivity.class);
                intent.putExtra("backdrop", url + lf.get(i).getBackdrop());
                intent.putExtra("detail", lf.get(i).getOverview());
                intent.putExtra("title", lf.get(i).getTitle());
                intent.putExtra("id", lf.get(i).getId());
                context.startActivity(intent);
            }
        });
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private CardView cardView;
        public FavViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.fav_title);
            cardView = itemView.findViewById(R.id.cv_fav);
        }
    }

    public int getItemCount(){
        return lf.size();
    }
}
