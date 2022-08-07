package com.example.mockproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GenresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenresFragment extends Fragment {

    public static GenresFragment newInstance() {
        return new GenresFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_genres, container, false);
    }
}