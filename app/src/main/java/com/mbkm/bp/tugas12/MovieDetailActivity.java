package com.mbkm.bp.tugas12;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbkm.bp.tugas12.databinding.ActivityDetailBinding;
import com.mbkm.bp.tugas12.db.User;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = new User();
        String backdrop = getIntent().getStringExtra("backdrop");
        String detail = getIntent().getStringExtra("detail");
        String title = getIntent().getStringExtra("title");
        String id = getIntent().getStringExtra("id");

        initView();
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setId(Integer.parseInt(id));
                user.setTitle(title);
                user.setOverview(detail);
                user.setBackdrop_url(backdrop);
                MainActivity.appDatabase.myDao().addFavourite(user);
                Toast.makeText(MovieDetailActivity.this, "Added to favourite", Toast.LENGTH_SHORT).show();
            }
        });

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(title);

        Glide.with(MovieDetailActivity.this).load(backdrop).override(640, 480).into(imageView);
        textView.setText(detail);
    }

    private void initView(){
        textView = findViewById(R.id.text_detail);
        imageView = findViewById(R.id.image_detail);
    }
}