package com.example.phornrawin.apptoonalpha;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] icons = {R.drawable.home, R.drawable.calendar, R.drawable.like, R.drawable.user};
    private Drawable drawable;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        createTabIcons();
    }

    public void initialize(){
        viewPager = findViewById(R.id.viewpage_main);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
//                if(position == 0){
//                    drawable = getResources().getDrawable(R.drawable.home);
//                }else if (position == 1) {
//                    drawable = getResources().getDrawable(R.drawable.calendar);
//                }else if (position == 2){
//                    drawable = getResources().getDrawable(R.drawable.like);
//                }else if (position == 3){
//                    drawable = getResources().getDrawable(R.drawable.user);
//                }
                drawable = getBaseContext().getDrawable(icons[position]);
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

    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home, 0, 0);
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



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
