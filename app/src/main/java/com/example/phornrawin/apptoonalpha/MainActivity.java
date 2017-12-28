package com.example.phornrawin.apptoonalpha;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.example.phornrawin.apptoonalpha.fragment.DairyTableFragment;
import com.example.phornrawin.apptoonalpha.fragment.HomeFragment;
import com.example.phornrawin.apptoonalpha.fragment.MyToonFragment;
import com.example.phornrawin.apptoonalpha.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Drawable drawable;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        viewPager = findViewById(R.id.viewpage_main);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                if(position == 0){
                    drawable = getResources().getDrawable(R.drawable.home);
                }else if (position == 1) {
                    drawable = getResources().getDrawable(R.drawable.calendar);
                }else if (position == 2){
                    drawable = getResources().getDrawable(R.drawable.like);
                }else if (position == 3){
                    drawable = getResources().getDrawable(R.drawable.user);
                }
                SpannableStringBuilder sb = new SpannableStringBuilder("    ");
                drawable.setBounds(5, 5, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BASELINE);
                sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                return sb;
            }

            @Override
            public Fragment getItem(int position) {
                if(position == 0)
                    return HomeFragment.newInstance();
                else if (position == 1)
                    return DairyTableFragment.newInstance();
                else if (position == 2)
                    return MyToonFragment.newInstance();
                else if (position == 3)
                    return ProfileFragment.newInstance();
                return HomeFragment.newInstance();
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }



}
