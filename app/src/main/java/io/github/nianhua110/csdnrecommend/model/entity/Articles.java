package io.github.nianhua110.csdnrecommend.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kankan on 2016/3/21.
 */
public class Articles {
    List<Article> articles = null;

    public Articles() {
        this.articles = new ArrayList<>();
    }
    public void addArticle(Article article){
        this.articles.add(article);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    public  Article getArticle(int position){
        return  articles.get(position);
    }
}
