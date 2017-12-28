package com.example.phornrawin.apptoonalpha.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phornrawin.apptoonalpha.R;

/**
 * Created by Phornrawin on 16/11/2560.
 */

public class DairyTableFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dairytable, container, false);
        return view;
    }

    public static DairyTableFragment newInstance() {
        Bundle args = new Bundle();
        DairyTableFragment fragment = new DairyTableFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
