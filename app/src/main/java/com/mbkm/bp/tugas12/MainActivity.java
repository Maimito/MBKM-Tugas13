package com.mbkm.bp.tugas12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbkm.bp.tugas12.fragm.favourite.Fragment_Favourite;
import com.mbkm.bp.tugas12.fragm.movie.Fragment_MovieList;
import com.mbkm.bp.tugas12.fragm.tv.Fragment_TVList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomMethod);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment_MovieList()).commit();

    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(R.string.exit_app_confirm).setCancelable(false).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener BottomMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    fragment = null;
                    switch (item.getItemId()){
                        case R.id.movie:
                            fragment = new Fragment_MovieList();
                            break;

                        case R.id.tv:
                            fragment = new Fragment_TVList();
                            break;

                        case R.id.favourite:
                            fragment = new Fragment_Favourite();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
                    return true;
                }
            };

}