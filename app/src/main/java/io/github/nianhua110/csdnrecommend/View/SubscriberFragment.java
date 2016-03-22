package io.github.nianhua110.csdnrecommend.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import io.github.nianhua110.csdnrecommend.R;
import io.github.nianhua110.csdnrecommend.adapter.RecylcerAdapter;
import io.github.nianhua110.csdnrecommend.model.entity.Articles;
import io.github.nianhua110.csdnrecommend.present.CsdnPresenterImp;

/**
 * Created by kankan on 2016/3/19.
 */
public class SubscriberFragment extends BaseFragment implements  ISubscriberView {
    private final static String TITLE = "随机";
    private CsdnPresenterImp csdnPresenterImp = null;
    private RecyclerView recyclerView;
    private  Articles articles= null;
    RecylcerAdapter recylcerAdapter = null;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        articles = new Articles();
        recylcerAdapter = new RecylcerAdapter(articles, new RecylcerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                System.out.println(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("title",articles.getArticle(position).getTitle());
                intent.putExtra("url",articles.getArticle(position).getUrl());
                startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        recyclerView.setAdapter(recylcerAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.subscribe_fragment, container, false);
        csdnPresenterImp = new CsdnPresenterImp(this);
        csdnPresenterImp.getRandowmContent();

        return view;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public void setSubscriberInfo(Articles articles) {
        this.articles.setArticles(articles.getArticles());
        this.recylcerAdapter.addArticles(articles);
        recylcerAdapter.notifyDataSetChanged();
        recylcerAdapter.notifyItemRangeChanged(0,articles.getArticles().size());

    }

    public void onVibrate(){
        csdnPresenterImp.getRandowmContent();
    }
}
