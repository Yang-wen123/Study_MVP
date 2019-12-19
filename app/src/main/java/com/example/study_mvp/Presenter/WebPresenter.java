package com.example.study_mvp.Presenter;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.example.study_mvp.Bean.MyPicture;
import com.example.study_mvp.Model.MyWebModel;
import com.example.study_mvp.Model.WebModel;
import com.example.study_mvp.View.MyWebView;

public class WebPresenter implements onWebListener,MyWebPresenter {
    private static final String TAG = "";
    MyWebView myWebView;
    WebModel webModel;
    Handler handler;
    public WebPresenter(MyWebView myWebView) {
        this.myWebView = myWebView;
        webModel = new MyWebModel();
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void loadweb() {
        myWebView.showloading();
        webModel.geturl(this);
    }

    @Override
    public void onSuccess() {
        handler.post(new Runnable() {
            @Override public void run() {
                myWebView.hideloading();
            }
        });
    }

    @Override
    public void onError() {
        handler.post(new Runnable() {
            @Override public void run() {
                myWebView.hideloading();
            }
        });
    }
}
