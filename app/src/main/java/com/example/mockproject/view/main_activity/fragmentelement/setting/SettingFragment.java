package com.example.mockproject.view.main_activity.fragmentelement.setting;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mockproject.R;
import com.example.mockproject.viewmodel.MainViewModel;
import com.example.mockproject.viewmodel.SettingViewModel;

public class SettingFragment extends Fragment {

    private MainViewModel mViewModel;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onStart() {
        mViewModel.setVisibilityForBottomControl(true);
        super.onStart();
    }
}