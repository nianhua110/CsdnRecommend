package io.github.nianhua110.csdnrecommend.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import io.github.nianhua110.csdnrecommend.R;
import io.github.nianhua110.csdnrecommend.model.entity.Article;
import io.github.nianhua110.csdnrecommend.present.ArticlePresenter;
import io.github.nianhua110.csdnrecommend.utils.Constant;

public class DetailActivity extends AppCompatActivity implements  IDetailView{

    Article article = null;
    ArticlePresenter articlePresenter = null;
    WebView webView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        articlePresenter = new ArticlePresenter(this);
        article = new Article();
        Intent intent = getIntent();
        article.setTitle(intent.getStringExtra("title"));
        article.setUrl(intent.getStringExtra("url"));
        System.out.println(article.getUrl());
      //  articlePresenter.loadArticle(article.getUrl());
        initView();
    }

    void initView(){
        webView =(WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(Constant.BASE_URL+article.getUrl());
    }
    @Override
    public void showArticleDetail(String string) {
        //webView.
    }
}
