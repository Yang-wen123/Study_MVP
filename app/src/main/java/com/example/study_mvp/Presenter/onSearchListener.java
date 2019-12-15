package com.example.study_mvp.Presenter;

import com.example.study_mvp.Bean.MyIP;

public interface onSearchListener {
    void onSuccess(MyIP myIP);

    void onError();
}
