package com.example.lifefuck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordsExplanationAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater = null;
    private List<String> rows;

    public WordsExplanationAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<String> rows) {
        this.rows = rows;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
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
        if (view == null) {
            view = layoutInflater.inflate(R.layout.words_explanation_item, viewGroup, false);
            TextView wordMeaningTextView = view.findViewById(R.id.word_meaning_textView);
            LinearLayout wordExample = view.findViewById(R.id.word_example_layout);
            String[] string = rows.get(i).split(",");
            wordMeaningTextView.setText(string[0]);
            for (int j = 1; j < string.length; j++) {
                TextView textView = new TextView(view.getContext());
                textView.setText(string[j]);
                textView.setTextSize(15);
                wordExample.addView(textView);
            }
        }
        return view;
    }


}