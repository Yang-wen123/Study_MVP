package com.example.study_mvp.View;

import android.graphics.Bitmap;
import com.example.study_mvp.Bean.MyPicture;

public interface MyIdentifyView {
    Bitmap getImage();
    void setMsg(MyPicture myPicture);

    void hideLoad();

    void showLoad();
}
