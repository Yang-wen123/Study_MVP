package com.example.study_mvp.Presenter;

import com.example.study_mvp.Bean.Vocabulary;
import com.example.study_mvp.Model.VocabularyImpl;
import com.example.study_mvp.Model.VocabularyModel;
import com.example.study_mvp.View.VocabularyView;

import java.lang.ref.WeakReference;
import java.util.List;

public class VocabularyPresenter {
    private WeakReference<VocabularyView> vocabularyView;
    private VocabularyModel vocabularyModel = new VocabularyImpl();
    public VocabularyPresenter(VocabularyView vocabularyView) {
        this.vocabularyView = new WeakReference<>(vocabularyView);
    }
    public void fetch(){
        if (vocabularyModel != null) {
            if (vocabularyView != null) {
                vocabularyView.get().showLoading();
            }
            vocabularyModel.loadVocabulary(new VocabularyModel.OnLoadListener() {
                @Override
                public void onComplete(List<Vocabulary> vocabulary) {
                    vocabularyView.get().showvocabulaary(vocabulary);
                }
            });
        }
    }
}
