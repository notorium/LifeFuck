package com.example.lifefuck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import static com.example.lifefuck.WordsListActivity.wordsArrayList;


public class WordsExplanationActivity extends AppCompatActivity {
    private WordsExplanationAdapter wordsExplanationAdapter;
    private ListView positiveMeanListView, negativeMeanListView;
    private TextView wordTextView;
    private TextView[] positiveEmotionTextView, negativeEmotionTextView;
    private Button emotionChangeButton;
    private View positiveMeaningIcons, negativeMeaningIcons;
    private boolean emotionFlg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_explanation);

        int listIndexNum = getIntent().getIntExtra("ListIndexNum", 0);

        wordTextView = findViewById(R.id.wordTextView);
        emotionChangeButton = findViewById(R.id.emotion_change_button);
        positiveMeaningIcons = findViewById(R.id.positive_meaning_icons);
        negativeMeaningIcons = findViewById(R.id.negative_meaning_icons);

        positiveEmotionTextView = new TextView[]{
                findViewById(R.id.emotion_textView1),
                findViewById(R.id.emotion_textView2),
                findViewById(R.id.emotion_textView3),
                findViewById(R.id.emotion_textView4)
        };

        negativeEmotionTextView = new TextView[]{
                findViewById(R.id.emotion_textView5),
                findViewById(R.id.emotion_textView6),
                findViewById(R.id.emotion_textView7),
                findViewById(R.id.emotion_textView8)
        };

        for (int value : wordsArrayList.get(listIndexNum).getPositiveEmotionNum()) {
            positiveEmotionTextView[value - 1].setVisibility(View.VISIBLE);
        }

        for (int value : wordsArrayList.get(listIndexNum).getNegativeEmotionNum()) {
            negativeEmotionTextView[value - 5].setVisibility(View.VISIBLE);
        }

        wordTextView.setText(wordsArrayList.get(listIndexNum).getWord());
        // ListViewにAdapterを設定する
        wordsExplanationAdapter = new WordsExplanationAdapter(this);
        positiveMeanListView = findViewById(R.id.positive_meaning_listview);
        wordsExplanationAdapter.setList(Arrays.asList(wordsArrayList.get(listIndexNum).getPositiveMeaning()));
        positiveMeanListView.setAdapter(wordsExplanationAdapter);

        wordsExplanationAdapter = new WordsExplanationAdapter(this);
        negativeMeanListView = findViewById(R.id.negative_meaning_listview);
        wordsExplanationAdapter.setList(Arrays.asList(wordsArrayList.get(listIndexNum).getNegativeMeaning()));
        negativeMeanListView.setAdapter(wordsExplanationAdapter);


        emotionChangeButton.setOnClickListener(v -> {
            if (emotionFlg) {
                positiveMeaningIcons.setVisibility(View.GONE);
                negativeMeaningIcons.setVisibility(View.VISIBLE);
                positiveMeanListView.setVisibility(View.GONE);
                negativeMeanListView.setVisibility(View.VISIBLE);
                emotionChangeButton.setBackgroundColor(getResources().getColor(R.color.negative));
                emotionChangeButton.setText("Negative");
            } else {
                positiveMeaningIcons.setVisibility(View.VISIBLE);
                negativeMeaningIcons.setVisibility(View.GONE);
                positiveMeanListView.setVisibility(View.VISIBLE);
                negativeMeanListView.setVisibility(View.GONE);
                emotionChangeButton.setBackgroundColor(getResources().getColor(R.color.positive));
                emotionChangeButton.setText("Positive");
            }
            emotionFlg = !emotionFlg;
        });
    }
}