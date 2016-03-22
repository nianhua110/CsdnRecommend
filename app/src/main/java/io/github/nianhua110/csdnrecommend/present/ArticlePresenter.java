package io.github.nianhua110.csdnrecommend.present;

import io.github.nianhua110.csdnrecommend.View.DetailActivity;
import io.github.nianhua110.csdnrecommend.View.IDetailView;
import io.github.nianhua110.csdnrecommend.model.ArticleDetailModel;

/**
 * Created by kankan on 2016/3/21.
 */
public class ArticlePresenter implements IArticleDetailPresenter, OnGetArticleDetailListener {

    private ArticleDetailModel articleDetailModel = null;
    private IDetailView detailView = null;

    public ArticlePresenter(IDetailView view) {
        articleDetailModel = new ArticleDetailModel();
        detailView = view;
    }

    @Override
    public void loadArticle(String url) {
        articleDetailModel.loadAritcleDetail(url, this);
    }

    @Override
    public void onGetArticleDetail(String string) {
        detailView.showArticleDetail(string);
    }


}
