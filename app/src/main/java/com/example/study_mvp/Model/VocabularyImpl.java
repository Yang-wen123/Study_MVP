package com.example.study_mvp.Model;

import com.example.study_mvp.Bean.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class VocabularyImpl implements VocabularyModel {
    @Override
    public void loadVocabulary(OnLoadListener listener) {
        List<Vocabulary> data = new ArrayList<>();
        data.add(new Vocabulary("名词","鸟","niao","一种飞行动物"));
        data.add(new Vocabulary("动词","跑","pao","跑步这种动作"));
        data.add(new Vocabulary("形容词","帅","shuai","形容一个人外貌好看"));
        data.add(new Vocabulary("副词","慢慢地","man man de","多用于修饰"));
        listener.onComplete(data);
    }
}
