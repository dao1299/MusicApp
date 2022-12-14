package com.example.mockproject.view.main_activity.fragmentelement.songs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mockproject.R;
import com.example.mockproject.databinding.FragmentSongBinding;
import com.example.mockproject.model.SongModel;
import com.example.mockproject.view.main_activity.adapter.ListSongAdapter;
import com.example.mockproject.view.main_activity.adapter.ViewPagerSongsFragmentAdapter;
import com.example.mockproject.viewmodel.MainViewModel;
import com.example.mockproject.viewmodel.SongViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class SongFragment extends Fragment{

    private MainViewModel mViewModel;

    FragmentSongBinding fragmentSongBinding;

    public static SongFragment newInstance() {
        return new SongFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentSongBinding = FragmentSongBinding.inflate(inflater,container,false);
        return fragmentSongBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSongBinding.viewPagerSongs.setAdapter(new ViewPagerSongsFragmentAdapter(this));
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        new TabLayoutMediator(fragmentSongBinding.tabLayoutSongs,fragmentSongBinding.viewPagerSongs,(tab, position) -> {
            switch (position){
                case 0:
                    tab.setText(R.string.all_songs);
                    break;
                case 1:
                    tab.setText(R.string.Playlists);
                    break;
                case 2:
                    tab.setText(R.string.albums);
                    break;
                case 3:
                    tab.setText(R.string.artists);
                    break;
                case 4:
                    tab.setText(R.string.genres);
                    break;
            }
        }).attach();
    }

    @Override
    public void onStart() {
        mViewModel.setVisibilityForBottomControl(true);
        super.onStart();
    }
}