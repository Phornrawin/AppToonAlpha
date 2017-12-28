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

public class MyToonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mytoonview, container, false);
        return view;
    }

    public static MyToonFragment newInstance() {
        Bundle args = new Bundle();
        MyToonFragment fragment = new MyToonFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
