package com.example.study_mvp.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.study_mvp.Presenter.WebPresenter;
import com.example.study_mvp.R;
import com.example.study_mvp.utils.StaticConstant;
import com.example.study_mvp.utils.ToastUtils;

public class WebActivity extends AppCompatActivity implements MyWebView{
    private WebView webView;
    private ProgressBar pb;
    private WebPresenter webPresenter=new WebPresenter(this);
    private ToastUtils toastUtils=new ToastUtils(this);
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        pb=findViewById(R.id.pb);
        webView =findViewById(R.id.web);
        webPresenter.loadweb();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        Log.d("TAG", "onCreate: "+StaticConstant.url);

    }

    @Override
    public void showloading() {
        toastUtils.shorttoast("加载中，请稍后");
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideloading() {
        if(StaticConstant.url.length()>0){
            webView.loadUrl(StaticConstant.url);
            toastUtils.shorttoast("加载完毕");
            pb.setVisibility(View.GONE);
        }else {
            webView.loadUrl(StaticConstant.initurl);
            toastUtils.shorttoast("加载出错，即将打开百度链接");
            pb.setVisibility(View.GONE);
        }
    }
}
