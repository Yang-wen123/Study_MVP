package com.example.study_mvp.View;

import com.example.study_mvp.Bean.Girl;

import java.util.List;

public interface IGirlView {
    void showLoading();
    void showGirls(List<Girl> girls);
}
