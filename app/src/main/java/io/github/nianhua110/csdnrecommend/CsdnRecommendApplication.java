package io.github.nianhua110.csdnrecommend;

import android.app.Application;

import io.github.nianhua110.csdnrecommend.utils.HttpUtil;

/**
 * Created by kankan on 2016/3/19.
 */
public class CsdnRecommendApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
         HttpUtil.init(getApplicationContext());
    }
}
