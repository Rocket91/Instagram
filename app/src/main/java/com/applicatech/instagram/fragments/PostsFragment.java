package com.applicatech.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applicatech.instagram.R;

public class PostsFragment extends Fragment {

    private RecyclerView rvPosts;

    // on create view to inflate the view

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       rvPosts = view.findViewById(R.id.rvPosts);

       // create the adapter
        // create the data source
        // set the adapter on the recycler view
        //set the layout manager i=on the recycler view
    }
}
