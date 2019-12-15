package com.example.study_mvp.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.study_mvp.Bean.Girl;
import com.example.study_mvp.R;

import java.net.ConnectException;
import java.util.List;

public class GirlAdapter extends ArrayAdapter<Girl> {

    private static final String TAG ="" ;
    public GirlAdapter(Context context, List<Girl> objects) {
        super(context, R.layout.listview, objects);
    }
    @Override
    public View getView(int position, View convertview, ViewGroup parent){
        @SuppressLint("ViewHolder")
        View v= LayoutInflater.from(getContext()).inflate(R.layout.listview,null);
        Girl girl=getItem(position);
        TextView name=v.findViewById(R.id.name);
        TextView url=v.findViewById(R.id.url);
        name.setText(girl.getName());
        url.setText(girl.getUrl());
        Log.d(TAG, girl+"getView: ");
        return v;
    }
}
