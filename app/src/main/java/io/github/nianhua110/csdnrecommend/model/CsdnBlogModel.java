package io.github.nianhua110.csdnrecommend.model;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Random;

import io.github.nianhua110.csdnrecommend.model.entity.Article;
import io.github.nianhua110.csdnrecommend.model.entity.Articles;
import io.github.nianhua110.csdnrecommend.model.entity.FavoriteUrlModel;
import io.github.nianhua110.csdnrecommend.present.OnCsdnPresenterListener;
import io.github.nianhua110.csdnrecommend.utils.Constant;
import io.github.nianhua110.csdnrecommend.utils.HttpUtil;

/**
 * Created by kankan on 2016/3/20.
 */
public class CsdnBlogModel implements ILoadCsdnBlogModel {


    public CsdnBlogModel() {

    }

    @Override
    public void loadCsdnBlog(final OnCsdnPresenterListener listener) {
        HttpUtil httpUtil = HttpUtil.getInstance();

        httpUtil.sendGet(Constant.BASE_URL+getRandomAuthor(), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                    Articles mArticles = paraseRandomContent(s);
                    listener.onGetRandowmContent(mArticles);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

    }

    private  String getRandomAuthor(){
        String[] urls = FavoriteUrlModel.getFavoriteUrls();
        int length = urls.length;
        Random random  = new Random();
        int position = random.nextInt(length);
        String url = urls[position];
        Log.i("position","random position "+position+url );
        return  url;

    }
    private Articles paraseRandomContent(String s){
        Articles articles = new Articles();
        Document document =  Jsoup.parse(s);
        Elements blog_wrap = document.getElementsByClass("blog_wrap");
        Elements elements = blog_wrap.get(0).getElementsByTag("dl");
        for(Element element : elements){
            Article article = new Article();
            Element temp = element.child(0).child(0);
            article.setUrl(temp.attr("href"));
            article.setTitle(temp.text());
            articles.addArticle(article);
        }
        return  articles;
    }
}
