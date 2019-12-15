package com.example.study_mvp.Model;

import com.example.study_mvp.Presenter.onSearchListener;

public interface ISearchModel {
    void getIPaddressInfo(String ipAddress, onSearchListener onSearchListener);
}
