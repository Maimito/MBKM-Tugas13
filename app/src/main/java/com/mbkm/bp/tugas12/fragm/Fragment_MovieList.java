package com.mbkm.bp.tugas12.fragm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbkm.bp.tugas12.R;
import com.mbkm.bp.tugas12.adapterr.MovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_MovieList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_MovieList extends Fragment {

    private RecyclerView recyclerView;
    private final String TAG = "debug";

    private MovieAdapter movieAdapter;

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

        return root;
    }
}