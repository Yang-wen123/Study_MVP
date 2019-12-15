package com.example.study_mvp.Presenter;

import com.example.study_mvp.Bean.Girl;
import com.example.study_mvp.Model.GirlModelImpl;
import com.example.study_mvp.Model.IGirlModel;
import com.example.study_mvp.View.IGirlView;

import java.lang.ref.WeakReference;
import java.util.List;

public class GirlPresenter {
    //View引用
    private WeakReference<IGirlView> mGirlView;
    //Model引用
    private IGirlModel girlModel = new GirlModelImpl();
    public GirlPresenter(IGirlView mGirlView) {
        this.mGirlView = new WeakReference<>(mGirlView);
    }
    public void fetch(){
        //显示进度条
        if (girlModel != null) {
            //显示进度条
            if (mGirlView != null) {
                mGirlView.get().showLoading();
            }
            girlModel.loadGirl(new IGirlModel.GrilOnLoadListener() {
                @Override
                public void onComplete(List<Girl> girls) {
                    //返回数据
                    // 显示到view层
                    mGirlView.get().showGirls(girls);
                }
            });
        }
    }
}
