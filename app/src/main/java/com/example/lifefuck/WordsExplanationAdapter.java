package com.example.lifefuck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordsExplanationAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater = null;
    private ArrayList<Words> rows;

    public WordsExplanationAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<Words> rows) {
        this.rows = rows;
    }

    @Override
    public int getCount() {
        return rows.size();
    }

    @Override
    public Object getItem(int i) {
        return rows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.words_list_item, viewGroup, false);
        Words row = rows.get(i);
        ((TextView) view.findViewById(R.id.word)).setText(row.getWord());
        return view;
    }


}