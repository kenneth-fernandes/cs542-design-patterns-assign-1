package wordPlay.processing;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MetricsCalculation {
    private int totalWrdCount;
    private int totalCharCount;
    public float avgNoOfWrds = 0.00f;
    public float avgNoOfChars = 0.00f;
    public String maxFreqWrd = "";
    public String longstWrd = "";
    private int sentencesProcessed;

    public void performMetricsCalculation(String initialSentence, String finalSentence, int newLineCharsCount) {

        sentencesProcessed += 1;

        calculateAvgNoOfWords(finalSentence);

        calculateAvgNoOfChars(finalSentence, newLineCharsCount);

        findLongestWrd(initialSentence);

    }

    private void calculateAvgNoOfWords(String finalSentence) {
        String[] words = finalSentence.split("[\\s\\.]");
        int count = 0;
        for (String str : words) {

            count = !str.isEmpty() ? count + 1 : count + 0;
        }
        totalWrdCount += count;

        avgNoOfWrds = ((float) totalWrdCount / (float) sentencesProcessed);
        avgNoOfWrds = roundNumber(avgNoOfWrds);
    }

    private void calculateAvgNoOfChars(String finalSentence, int newLineCharsCount) {
        char[] sentenceCharArr = finalSentence.toCharArray();
        totalCharCount += (sentenceCharArr.length - newLineCharsCount);

        avgNoOfChars = (float) totalCharCount / (float) sentencesProcessed;

        avgNoOfChars = roundNumber(avgNoOfChars);
    }

    private void findLongestWrd(String initialSentence) {
        String[] words = initialSentence.trim().split("[\\s\\.]");
        for (String word : words) {
            if (word.toLowerCase().length() > longstWrd.toLowerCase().length()) {
                longstWrd = word;
            }

        }
    }

    private float roundNumber(float number) {
        DecimalFormat df = new DecimalFormat("");
        df.setMaximumFractionDigits(2);
        return Float.parseFloat(df.format(number));
    }
}