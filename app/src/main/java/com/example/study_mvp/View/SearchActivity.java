package com.example.study_mvp.View;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.study_mvp.Bean.MyIP;
import com.example.study_mvp.Presenter.SearchPresenter;
import com.example.study_mvp.R;

public class SearchActivity extends AppCompatActivity implements ISearchView {
    private EditText et_ip;
    private Button btn_search;
    private TextView tv_msg;
    private ProgressBar pb_load;
    private SearchPresenter mSearchPresenter = new SearchPresenter(this);

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ip = (EditText) findViewById(R.id.edit);
        btn_search = (Button) findViewById(R.id.button);
        tv_msg = (TextView) findViewById(R.id.tv);
        pb_load = (ProgressBar) findViewById(R.id.pb);

        onClick();
    }

    private void onClick() {
        btn_search.setOnClickListener(new View.OnClickListener() {
            private static final String TAG = "111";

            @Override public void onClick(View v) {
                mSearchPresenter.Search();
                Log.d(TAG, "onClick: "+et_ip.getText().toString().trim());
            }
        });
    }

    @Override
    public String getIPaddress() {
        return et_ip.getText().toString().trim();
    }
    @Override
    public void setMsg(MyIP myIP) {
        if (myIP != null) {
            tv_msg.setText(myIP.toString());
        } else {
            tv_msg.setText("获取失败");
        }
    }

    @Override
    public void hideLoad() {
        pb_load.setVisibility(View.GONE);
    }

    @Override
    public void showLoad() {
        pb_load.setVisibility(View.VISIBLE);
    }
}
