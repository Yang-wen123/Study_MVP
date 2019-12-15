package com.example.study_mvp.Presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.example.study_mvp.Bean.MyIP;
import com.example.study_mvp.Model.ISearchModel;
import com.example.study_mvp.Model.SearchModel;
import com.example.study_mvp.View.ISearchView;

public class SearchPresenter implements ISearchPresenter, onSearchListener {
    private static final String TAG ="1111" ;
    ISearchView searchView;
    ISearchModel searchModel;
    Handler handler;

    public SearchPresenter(ISearchView searchView) {
        this.searchView = searchView;
        searchModel = new SearchModel();
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void onSuccess(final MyIP myIP) {
        handler.post(new Runnable() {
            @Override public void run() {
                searchView.setMsg(myIP);
                searchView.hideLoad();
            }
        });
    }

    @Override
    public void onError() {
        handler.post(new Runnable() {
            @Override public void run() {
                searchView.setMsg(null);
                searchView.hideLoad();
            }
        });
    }

    @Override
    public void Search() {
        searchView.showLoad();
        searchModel.getIPaddressInfo(searchView.getIPaddress(),this);
        Log.d(TAG, "Search: "+searchView.getIPaddress());
    }
}
