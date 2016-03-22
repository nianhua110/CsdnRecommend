package io.github.nianhua110.csdnrecommend.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import io.github.nianhua110.csdnrecommend.View.BaseFragment;
import io.github.nianhua110.csdnrecommend.View.SubscriberFragment;

/**
 * Created by kankan on 2016/3/20.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment>  fragments = null;
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ((BaseFragment)fragments.get(position)).getTitle();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
