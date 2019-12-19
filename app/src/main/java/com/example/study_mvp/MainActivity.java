package com.example.study_mvp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.study_mvp.Adapter.GirlAdapter;
import com.example.study_mvp.Bean.Girl;
import com.example.study_mvp.Presenter.GirlPresenter;
import com.example.study_mvp.View.IGirlView;
import com.example.study_mvp.utils.ToastUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGirlView {
    private static final String TAG = "";
    private ListView listView;
    private ToastUtils toastUtils=new ToastUtils(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviewanddata();
    }

    private void initviewanddata() {
        listView=findViewById(R.id.list_view);
        new GirlPresenter(this).fetch();

    }

    @Override
    public void showLoading() {
        toastUtils.shorttoast("正在加载中...");
        //Toast.makeText(this, "正在加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(final List<Girl> girls) {
        listView.setAdapter(new GirlAdapter(this,girls));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Girl girl=girls.get(position);
                Uri uri=Uri.parse(girl.getUrl());
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
    }
}
