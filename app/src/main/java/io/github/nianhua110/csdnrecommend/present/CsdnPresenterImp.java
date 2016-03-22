package io.github.nianhua110.csdnrecommend.present;

import io.github.nianhua110.csdnrecommend.View.ISubscriberView;
import io.github.nianhua110.csdnrecommend.model.CsdnBlogModel;
import io.github.nianhua110.csdnrecommend.model.ILoadCsdnBlogModel;
import io.github.nianhua110.csdnrecommend.model.entity.Articles;

/**
 * Created by kankan on 2016/3/20.
 */
public class CsdnPresenterImp implements  ICsdnPresenter, OnCsdnPresenterListener{
    private ISubscriberView iSubscriberView = null;
    private ILoadCsdnBlogModel iLoadCsdnBlogModel = null;
    public CsdnPresenterImp(ISubscriberView view) {
        iSubscriberView = view;
        iLoadCsdnBlogModel = new CsdnBlogModel();
    }

    @Override
    public void getRandowmContent() {
        iLoadCsdnBlogModel.loadCsdnBlog( this);

    }

    @Override
    public void onGetRandowmContent(Articles articles) {
        iSubscriberView.setSubscriberInfo(articles);
        System.out.println("dfd");
    }

    @Override
    public void onError() {

    }
}
