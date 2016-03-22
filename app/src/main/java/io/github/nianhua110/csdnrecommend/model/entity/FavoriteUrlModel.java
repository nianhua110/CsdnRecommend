package io.github.nianhua110.csdnrecommend.model.entity;

/**
 * Created by kankan on 2016/3/22.
 */
public class FavoriteUrlModel {
    public static String[] getFavoriteUrls() {
        return favoriteUrls;
    }

    private  static   String[] favoriteUrls={
            "/blog/index?username=lnho2015",
            "/blog/index?username=sinyu890807",
            "/blog/index?username=singwhatiwanna"
    };
}
