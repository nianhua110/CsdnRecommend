package io.github.nianhua110.csdnrecommend.present;

import io.github.nianhua110.csdnrecommend.model.entity.Articles;

/**
 * Created by kankan on 2016/3/20.
 */
public interface OnCsdnPresenterListener {
     void   onGetRandowmContent(Articles articles);
     void   onError();

}
