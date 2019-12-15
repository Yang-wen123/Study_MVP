package com.example.study_mvp.View;

import com.example.study_mvp.Bean.MyIP;

public interface ISearchView {
    String getIPaddress();

    void setMsg(MyIP myIP);

    void hideLoad();

    void showLoad();
}
