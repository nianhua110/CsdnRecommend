package io.github.nianhua110.csdnrecommend.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.nianhua110.csdnrecommend.R;
import io.github.nianhua110.csdnrecommend.model.entity.Articles;

/**
 * Created by kankan on 2016/3/21.
 */
public class RecylcerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public Articles articles = null;
    private  OnItemClickListener onItemClickListener = null;
    public interface OnItemClickListener{
        void onClick(int position);
        void onLongClick(int position);
    }

    public RecylcerAdapter(Articles articles, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.articles = articles;
    }

    public void  addArticles(Articles articles){
        this.articles.setArticles(articles.getArticles());
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.subscriber_item, null);
        ViewHodler viewHodler = new ViewHodler(view);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHodler)holder).textView.setText(articles.getArticles().get(position).getTitle());
        if(onItemClickListener != null){
            ((ViewHodler) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return articles.getArticles().size();
    }

    public  static class  ViewHodler extends RecyclerView.ViewHolder{
        public TextView textView = null;

        public ViewHodler(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView_article);
        }
    }
}
