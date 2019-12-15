package com.example.study_mvp.Model;

import com.example.study_mvp.Bean.Girl;

import java.util.List;

public interface IGirlModel {
    void loadGirl(GrilOnLoadListener listener);
    interface GrilOnLoadListener{
        void onComplete(List<Girl> girls);
    }
}
