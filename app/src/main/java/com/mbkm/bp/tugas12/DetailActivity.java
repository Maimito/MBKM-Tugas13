package com.mbkm.bp.tugas12;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbkm.bp.tugas12.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String backdrop = getIntent().getStringExtra("backdrop");
        String detail = getIntent().getStringExtra("detail");
        String title = getIntent().getStringExtra("title");

        initView();

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(title);

        Glide.with(DetailActivity.this).load(backdrop).override(640, 480).into(imageView);
        textView.setText(detail);
    }

    private void initView(){
        textView = findViewById(R.id.text_detail);
        imageView = findViewById(R.id.image_detail);
    }
}