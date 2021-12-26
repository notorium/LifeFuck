package com.example.lifefuck;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONReader extends ArrayList<Words> {
    private JSONObject jsonObject;

    public JSONReader(String jsonFileName, Activity activity) {
        try {
            InputStream inputStream = activity.getAssets().open(jsonFileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(strLine);
            }
            this.jsonObject = new JSONObject(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Words> wordsList() {
        ArrayList<Words> list = new ArrayList<>();
        try {
            String word;
            String[] positiveMeaning, negativeMeaning;
            int[] positiveEmotionNum, negativeEmotionNum;

            JSONArray words = jsonObject.getJSONArray("words");
            for (int i = 0; i < words.length(); i++) {
                JSONObject tmpObject = words.getJSONObject(i);
                JSONArray tmpArray;

                word = tmpObject.getString("word");

                tmpArray = tmpObject.getJSONArray("positivemean");
                positiveMeaning = new String[tmpArray.length()];
                for (int j = 0; j < tmpArray.length(); j++) {
                    positiveMeaning[j] = tmpArray.getString(j);
                }

                tmpArray = tmpObject.getJSONArray("positivenum");
                positiveEmotionNum = new int[tmpArray.length()];
                for (int j = 0; j < tmpArray.length(); j++) {
                    positiveEmotionNum[j] = tmpArray.getInt(j);
                }

                tmpArray = tmpObject.getJSONArray("negativemean");
                negativeMeaning = new String[tmpArray.length()];
                for (int j = 0; j < tmpArray.length(); j++) {
                    negativeMeaning[j] = tmpArray.getString(j);
                }

                tmpArray = tmpObject.getJSONArray("negativenum");
                negativeEmotionNum = new int[tmpArray.length()];
                for (int j = 0; j < tmpArray.length(); j++) {
                    negativeEmotionNum[j] = tmpArray.getInt(j);
                }

                list.add(new Words(
                        word,
                        positiveMeaning,
                        positiveEmotionNum,
                        negativeMeaning,
                        negativeEmotionNum
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
