package com.example.study_mvp.utils;

import android.content.Context;
import android.widget.Toast;
/*
*
* created on 2019/12/19
* by wen
*
* */
public class ToastUtils {
    Context C;
    public ToastUtils(Context context){
        super();
        C=context;
    }
    public void shorttoast(String s){
        Toast.makeText(C,s,Toast.LENGTH_SHORT).show();
    }
    public void longtoast(String s){
        Toast.makeText(C,s,Toast.LENGTH_LONG).show();
    }
}
