package io.github.nianhua110.csdnrecommend.model;

import io.github.nianhua110.csdnrecommend.present.OnGetArticleDetailListener;

/**
 * Created by kankan on 2016/3/21.
 */
public interface IAriticleDetailModel {
    void loadAritcleDetail(String url,OnGetArticleDetailListener onGetArticleDetailListener);

}
