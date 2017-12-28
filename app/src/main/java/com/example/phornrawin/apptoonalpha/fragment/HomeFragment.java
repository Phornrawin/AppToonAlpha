package com.example.phornrawin.apptoonalpha.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.phornrawin.apptoonalpha.R;
import com.example.phornrawin.apptoonalpha.adapter.MyToonAdapter;
import com.example.phornrawin.apptoonalpha.adapter.ShowImageSlideAdapter;

/**
 * Created by Phornrawin on 16/11/2560.
 */

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private GridView gridView;
    private int images[];
    private String myToons[] ;
    private ShowImageSlideAdapter slideAdapter;

    public HomeFragment() {
        images = new int[] {R.drawable.id_flower, R.drawable.lookism, R.drawable.noblesses};
        myToons = new String[] {"ID Flower", "Lookism", "Noblesses"};
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_view, container, false);
        initialize(view);
        return view;
    }

    public void initialize(View view){
        createImageSlide(view);
        createGridViewMyToon(view);
    }

    public void createImageSlide(View view){
        viewPager = view.findViewById(R.id.viewPager);
        slideAdapter = new ShowImageSlideAdapter(getContext(), images);
        viewPager.setAdapter(slideAdapter);

    }

    public void createGridViewMyToon(View view){
        gridView = view.findViewById(R.id.GV_homepage);
        gridView.setAdapter(new MyToonAdapter(getContext(), myToons));
        gridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("home", "onClick in onclick method");
            }
        });


    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
        this.gridView = gridView;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public String[] getMyToons() {
        return myToons;
    }

    public void setMyToons(String[] myToons) {
        this.myToons = myToons;
    }

    public ShowImageSlideAdapter getSlideAdapter() {
        return slideAdapter;
    }

    public void setSlideAdapter(ShowImageSlideAdapter slideAdapter) {
        this.slideAdapter = slideAdapter;
    }
}
