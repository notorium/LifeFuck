package com.example.lifefuck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class WordsListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater = null;
    private List<Words> rows;

    public WordsListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<Words> rows) {
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
        if (view == null) {
            view = layoutInflater.inflate(R.layout.words_list_item, viewGroup, false);
            Words row = rows.get(i);

            ((TextView) view.findViewById(R.id.wordTextView)).setText(row.getWord());
            TextView[] positiveEmotionTextView = {
                    view.findViewById(R.id.emotion_textView1),
                    view.findViewById(R.id.emotion_textView2),
                    view.findViewById(R.id.emotion_textView3),
                    view.findViewById(R.id.emotion_textView4)
            };

            TextView[] negativeEmotionTextView = {
                    view.findViewById(R.id.emotion_textView5),
                    view.findViewById(R.id.emotion_textView6),
                    view.findViewById(R.id.emotion_textView7),
                    view.findViewById(R.id.emotion_textView8)
            };

            for (int value : row.getPositiveEmotionNum()) {
                positiveEmotionTextView[value - 1].setVisibility(View.VISIBLE);
            }

            for (int value : row.getNegativeEmotionNum()) {
                negativeEmotionTextView[value - 5].setVisibility(View.VISIBLE);
            }
        }

        return view;
    }
}