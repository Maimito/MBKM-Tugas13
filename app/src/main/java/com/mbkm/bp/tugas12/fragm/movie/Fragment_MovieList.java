package com.mbkm.bp.tugas12.fragm.movie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mbkm.bp.tugas12.R;
import com.mbkm.bp.tugas12.adapterr.MovieAdapter;
import com.mbkm.bp.tugas12.api.ApiService;
import com.mbkm.bp.tugas12.api.InitRetrofit;
import com.mbkm.bp.tugas12.model.MovieResponse;
import com.mbkm.bp.tugas12.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_MovieList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_MovieList extends Fragment {

    private RecyclerView recyclerView;
    private final String TAG = "debug";

    private MovieAdapter movieAdapter;
    private List<Result> result;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_MovieList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment com.mbkm.bp.tugas11.MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_MovieList newInstance(String param1, String param2) {
        Fragment_MovieList fragment = new Fragment_MovieList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = root.findViewById(R.id.rv_movie);
        getData();
        return root;
    }

    public void getData(){
        ApiService apiService = InitRetrofit.getApiService();
        apiService.ambilData().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response){
                Log.d(TAG, "onResponse: " + response.body().getDateList().getMaximum());
                if (response.isSuccessful()){
                    result = new ArrayList<>();
                    result = response.body().getResults();
                    movieAdapter = new MovieAdapter(getActivity(), result);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(movieAdapter);
                } else {
                    Toast.makeText(getActivity(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Periksa koneksi internet anda" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}