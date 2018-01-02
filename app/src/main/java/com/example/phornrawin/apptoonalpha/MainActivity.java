package com.example.phornrawin.apptoonalpha;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.phornrawin.apptoonalpha.fragment.DairyTableFragment;
import com.example.phornrawin.apptoonalpha.fragment.HomeFragment;
import com.example.phornrawin.apptoonalpha.fragment.MyToonFragment;
import com.example.phornrawin.apptoonalpha.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageSpan imageSpan;
    private SpannableStringBuilder sb;
    private int[] icons = {R.drawable.home, R.drawable.calendar, R.drawable.like, R.drawable.user};
    private Drawable drawable;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpage_main);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        initialize();
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(2).setIcon(icons[2]);
        tabLayout.getTabAt(3).setIcon(icons[3]);
//        createTabIcons();
    }

    public void initialize(){

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
////                if(position == 0){
////                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.home);
////                }else if (position == 1) {
////                    drawable =ContextCompat.getDrawable(MainActivity.this, R.drawable.calendar);
////                }else if (position == 2){
////                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.like);
////                }else if (position == 3){
////                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.user);
////                }
//                drawable =  MainActivity.this.getResources().getDrawable(icons[position]);
//                sb = new SpannableStringBuilder("    ");
//                drawable.setBounds(5, 5, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//                imageSpan = new ImageSpan(drawable);
//                sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                for (int i = 0; i < tabLayout.getTabCount(); i++) {
//                    tabLayout.getTabAt(i).setIcon(icons[i]);
//                }

                return null;
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

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.home);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.calendar, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.like, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.user, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }

}
