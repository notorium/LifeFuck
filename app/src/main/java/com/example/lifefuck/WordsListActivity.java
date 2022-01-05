package com.example.lifefuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class WordsListActivity extends AppCompatActivity {
    public static ArrayList<Words> wordsArrayList;
    private WordsListAdapter wordsListAdapter;
    private ListView wordsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);

        // ViewのID取得
        wordsListView = findViewById(R.id.words_listview);

        // Jsonファイルからデータを読む
        wordsArrayList = new JSONReader("test.json", this).wordsList();

        // ListViewにAdapterを設定する
        wordsListAdapter = new WordsListAdapter(this);
        wordsListAdapter.setList(wordsArrayList);
        wordsListView.setAdapter(wordsListAdapter);

        // ListView選択自の処理
        wordsListView.setOnItemClickListener((parent, view, position, id) -> {
                    Words prefName = (Words) parent.getItemAtPosition(position);

                    Intent intent = new Intent(getApplicationContext(), WordsExplanationActivity.class);
                    intent.putExtra("ListIndexNum", position);
                    startActivity(intent);
                }
        );
    }
}