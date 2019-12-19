package com.example.study_mvp.Model;

import com.example.study_mvp.Presenter.onWebListener;
import com.example.study_mvp.utils.StaticConstant;

public class MyWebModel implements WebModel {

    @Override
    public void geturl(onWebListener onWebListener) {
        try {
            if(StaticConstant.url.length()>0){
                onWebListener.onSuccess();
            }else {
                StaticConstant.initurl="http://www.baidu.com";
                onWebListener.onError();
            }
        }catch (Exception e){
            onWebListener.onError();
        }
    }
}
