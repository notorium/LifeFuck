package com.example.lifefuck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

import static com.example.lifefuck.WordsListActivity.wordsArrayList;


public class WordsExplanationActivity extends AppCompatActivity {
    private WordsExplanationAdapter wordsExplanationAdapter;
    private ListView wordsMeanListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_explanation);

        // ListViewにAdapterを設定する
        wordsExplanationAdapter = new WordsExplanationAdapter(this);

        wordsMeanListView = findViewById(R.id.positive_mean_listview);
        wordsExplanationAdapter.setList(Arrays.asList(wordsArrayList.get(0).getPositiveMeaning()));
        wordsMeanListView.setAdapter(wordsExplanationAdapter);

        wordsMeanListView = findViewById(R.id.negative_mean_listview);
        wordsExplanationAdapter.setList(Arrays.asList(wordsArrayList.get(0).getNegativeMeaning()));
        wordsMeanListView.setAdapter(wordsExplanationAdapter);
    }
}