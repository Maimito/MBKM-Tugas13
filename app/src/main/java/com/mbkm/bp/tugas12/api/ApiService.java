package com.mbkm.bp.tugas12.api;

import com.mbkm.bp.tugas12.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie/now_playing?api_key=a8d1f81c5c644db1a3410e03c542aca4")
    Call<MovieResponse> ambilData();
}

