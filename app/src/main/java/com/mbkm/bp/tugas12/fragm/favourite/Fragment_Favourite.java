package com.mbkm.bp.tugas12.fragm.favourite;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mbkm.bp.tugas12.MainActivity;
import com.mbkm.bp.tugas12.R;
import com.mbkm.bp.tugas12.adapterr.FavAdapter;
import com.mbkm.bp.tugas12.db.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Favourite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Favourite extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button mAddFav;
    private Button mViewFav;
    private Button mEditFav;
    private Button mDeleteFav;

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    List<User> users;




    public Fragment_Favourite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment com.mbkm.bp.tugas11.FavFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Favourite newInstance(String param1, String param2) {
        Fragment_Favourite fragment = new Fragment_Favourite();
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
        View root = inflater.inflate(R.layout.fragment_fav, container, false);

        users = MainActivity.appDatabase.myDao().getFavourite();

        recyclerView = (RecyclerView) root.findViewById(R.id.rv_fav);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        List daftar = Data();
        recyclerViewAdapter = new FavAdapter(getActivity(), daftar);
        recyclerView.setAdapter(recyclerViewAdapter);

        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setReorderingAllowed(false);
        transaction.detach(this).attach(this).commitAllowingStateLoss();
    }

    private List Data(){
        List arrayList = new ArrayList<>();
        users = MainActivity.appDatabase.myDao().getFavourite();
        int i = 0;
        for(User user: users){
            List_Favourite lf = new List_Favourite();
            String title = user.getTitle();
            lf.setTitle(title);
            String detail = user.getOverview();
            lf.setOverview(detail);
            String backdrop = user.getBackdrop_url();
            lf.setBackdrop(backdrop);
            int id = user.getId();
            lf.setId(String.valueOf(id));
            arrayList.add(lf);
        }
        return arrayList;
    }
}