package com.example.lifefuck;

public class Words {
    private final String word;
    private final String[] positiveMeaning, negativeMeaning;
    private final int[] positiveEmotionNum, negativeEmotionNum;


    public Words(String str, String[] strArray1, int[] num1, String[] strArray2, int[] num2) {
        this.word = str;
        this.positiveMeaning = strArray1;
        this.positiveEmotionNum = num1;
        this.negativeMeaning = strArray2;
        this.negativeEmotionNum = num2;
    }

    public String getWord() {
        return word;
    }

    public String[] getPositiveMeaning() {
        return positiveMeaning;
    }

    public String[] getNegativeMeaning() {
        return negativeMeaning;
    }

    public int[] getPositiveEmotionNum() {
        return positiveEmotionNum;
    }

    public int[] getNegativeEmotionNum() {
        return negativeEmotionNum;
    }
}
