package com.github.florent37.rxretrojsoup.sample.androidarsenal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.rxretrojsoup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 28/02/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ArticleViewHolder> {

    private List<Project> items = new ArrayList<>();

    public void addItems(List<Project> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_article, parent, false));
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView url;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            url = (TextView) itemView.findViewById(R.id.url);
        }

        public void bind(Project project) {
            title.setText(project.title);
            url.setText(project.description);
        }
    }
}
