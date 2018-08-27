package com.portfolio.jgsilveira.cesar.arraysandstring.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    private List<String> mData = new ArrayList<>();

    WordsAdapter(List<String> data) {
        setData(data);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new WordViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String content = mData.get(position);
        TextView text = (TextView) holder.itemView;
        text.setText(content);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    void setData(List<String> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
