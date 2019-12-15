package com.example.study_mvp.Presenter;

import android.os.Handler;
import android.os.Looper;
import com.example.study_mvp.Bean.MyPicture;
import com.example.study_mvp.Model.IIdentifyModel;
import com.example.study_mvp.Model.IdentifyModel;
import com.example.study_mvp.View.MyIdentifyView;

public class IdentifyPresenter implements onIdentifyListener,IIdentifyPresentor {
    private static final String TAG ="1111" ;
    MyIdentifyView myIdentifyView;
    IIdentifyModel identifyModel;
    Handler handler;

    public IdentifyPresenter(MyIdentifyView myIdentifyView) {
        this.myIdentifyView = myIdentifyView;
        identifyModel = new IdentifyModel();
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void Identify() {
        myIdentifyView.showLoad();
        identifyModel.getPictureInfo(myIdentifyView.getImage(),this);
    }

    @Override
    public void onSuccess(final MyPicture myPicture) {
        handler.post(new Runnable() {
            @Override public void run() {
                myIdentifyView.setMsg(myPicture);
                myIdentifyView.hideLoad();
            }
        });
    }

    @Override
    public void onError() {
        handler.post(new Runnable() {
            @Override public void run() {
                myIdentifyView.setMsg(null);
                myIdentifyView.hideLoad();
            }
        });
    }
}
