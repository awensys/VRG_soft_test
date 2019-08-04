package com.example.vrgsoft;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vrgsoft.nyt.Result;
import java.util.ArrayList;


public class PageFragment extends Fragment {

    static final String RESULTS = "results";
    ArrayList<Result> results;
    static PageFragment pageFragment;
    RVAdapter adapter;
    RecyclerView rv;

    static PageFragment newInstance(ArrayList<Result> results) {
       pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList(RESULTS, results);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            results = getArguments().getParcelableArrayList(RESULTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv = view.findViewById(R.id.rv_page_fragment);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        adapter = new RVAdapter(results);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        super.onViewCreated(view, savedInstanceState);
    }
}

