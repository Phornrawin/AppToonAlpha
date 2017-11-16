package com.example.phornrawin.apptoonalpha;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.phornrawin.apptoonalpha.adapter.MyToonAdapter;
import com.example.phornrawin.apptoonalpha.adapter.ShowImageSlideAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private GridView gridView;
    private int images[];
    private String myToons[] ;
    private ShowImageSlideAdapter slideAdapter;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    public void initialize(){
        createImageSlide();
        createGridViewMyToon();

    }

    public void createImageSlide(){
        viewPager = findViewById(R.id.viewPager);
        slideAdapter = new ShowImageSlideAdapter(MainActivity.this, images);
        viewPager.setAdapter(slideAdapter);

    }

    public void createGridViewMyToon(){
        gridView = findViewById(R.id.GV_homepage);
        gridView.setAdapter(new MyToonAdapter(this, myToons));
        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
