package com.example.study_mvp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.study_mvp.Bean.Vocabulary;
import com.example.study_mvp.R;

import java.util.List;

public class VocabularyAdapter extends ArrayAdapter {

    public VocabularyAdapter(Context context, List<Vocabulary> objects) {
        super(context, R.layout.listview, objects);
    }
    @Override
    public View getView(int position, View convertview, ViewGroup parent){
        @SuppressLint("ViewHolder")
        View v= LayoutInflater.from(getContext()).inflate(R.layout.listview,null);
        Vocabulary vocabulary= (Vocabulary) getItem(position);
        TextView charater=v.findViewById(R.id.charater);
        TextView words=v.findViewById(R.id.words);
        TextView spell=v.findViewById(R.id.spell);
        TextView para=v.findViewById(R.id.para);
        charater.setText(vocabulary.getCharacter());
        words.setText(vocabulary.getWords());
        spell.setText(vocabulary.getSpell());
        para.setText(vocabulary.getParaphrase());
        return v;
    }
}
