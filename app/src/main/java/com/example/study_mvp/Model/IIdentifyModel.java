package com.example.study_mvp.Model;

import android.graphics.Bitmap;
import com.example.study_mvp.Presenter.onIdentifyListener;

public interface IIdentifyModel {
    void getPictureInfo(Bitmap bitmap, onIdentifyListener onIdentifyListener);
}
