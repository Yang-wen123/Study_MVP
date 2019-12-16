package com.example.study_mvp.Model;

import com.example.study_mvp.Bean.Vocabulary;

import java.util.List;

public interface VocabularyModel {
    void loadVocabulary(OnLoadListener listener);
    interface OnLoadListener{
        void onComplete(List<Vocabulary> vocabularys);
    }
}
