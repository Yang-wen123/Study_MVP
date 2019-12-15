package com.example.study_mvp.Presenter;

import com.example.study_mvp.Bean.MyPicture;

public interface onIdentifyListener {
    void onSuccess(MyPicture myPicture);

    void onError();
}
