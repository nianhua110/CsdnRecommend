package io.github.nianhua110.csdnrecommend.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.github.nianhua110.csdnrecommend.present.OnGetArticleDetailListener;
import io.github.nianhua110.csdnrecommend.utils.Constant;
import io.github.nianhua110.csdnrecommend.utils.HttpUtil;

/**
 * Created by kankan on 2016/3/21.
 */
public class ArticleDetailModel implements  IAriticleDetailModel {

    @Override
    public void loadAritcleDetail(String url, final OnGetArticleDetailListener onGetArticleDetailListener) {
        HttpUtil httpUtil = HttpUtil.getInstance();
        httpUtil.sendGet(Constant.BASE_URL+url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               // parserArticleDetail(s);
                onGetArticleDetailListener.onGetArticleDetail(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println(volleyError);
            }
        });
    }

    private void parserArticleDetail(String string){
        System.out.println(string);
    }
}
