package com.example.study_mvp.View;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.study_mvp.Adapter.VocabularyAdapter;
import com.example.study_mvp.Bean.Vocabulary;
import com.example.study_mvp.Presenter.VocabularyPresenter;
import com.example.study_mvp.R;

import java.util.List;
import java.util.Locale;

public class VocabularyActivity extends AppCompatActivity implements VocabularyView, TextToSpeech.OnInitListener {
    private ListView listView;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        new VocabularyPresenter(this).fetch();
        tts = new TextToSpeech(getApplicationContext(),this);
    }
    @Override
    public void showvocabulaary(final List<Vocabulary> vocabularys) {
        listView.setAdapter(new VocabularyAdapter(this,vocabularys));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vocabulary v=vocabularys.get(position);
                tts.speak(v.getWords(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopTTS();
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void onInit(int status) {
        // 判断是否转化成功
        if (status == TextToSpeech.SUCCESS){
            //默认设定语言为中文，原生的android貌似不支持中文。
            int result = tts.setLanguage(Locale.CHINESE);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(getApplicationContext(), "播放失败", Toast.LENGTH_SHORT).show();
            }else{
                //不支持中文就将语言设置为英文
                tts.setLanguage(Locale.US);
            }
        }
    }
    public void stopTTS() {
        if ( tts  != null) {
            tts .shutdown();
            tts .stop();
            tts = null;
        }
    }
}
