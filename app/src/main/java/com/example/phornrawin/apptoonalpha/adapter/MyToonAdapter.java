package com.example.phornrawin.apptoonalpha.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.phornrawin.apptoonalpha.R;

/**
 * Created by Phornrawin on 15/11/2560.
 */

public class MyToonAdapter extends BaseAdapter {
    private Context context;
    private final String[] values;

    public MyToonAdapter(Context context, String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridview;

        if(view == null){
            gridview = new View(context);
            gridview = inflater.inflate(R.layout.gridview, null);

        }else{
            gridview = view;
        }
        return gridview;
    }
}
