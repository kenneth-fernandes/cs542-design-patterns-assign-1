package wordPlay.processing;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MetricsCalculation {

    private static float avgNoOfWrds = 0.00f;
    private static float avgNoOfChars = 0.00f;
    private static String maxFreqWrd = "";
    private static String longstWrd = "";

    public static void performMetricsCalculation(String finalSentence, int newLineCharsCount) {

        calculateAvgNoOfWords(finalSentence);

        calculateAvgNoOfChars(finalSentence, newLineCharsCount);

    }

    private static void calculateAvgNoOfWords(String finalSentence) {
        String[] words = finalSentence.split("[\\s\\.]");
        avgNoOfWrds = (avgNoOfWrds + words.length) / 2;
        avgNoOfWrds = roundNumber(avgNoOfWrds);
        // System.out.println(roundNumber(avgNoOfWrds));
    }

    private static void calculateAvgNoOfChars(String finalSentence, int newLineCharsCount) {
        char[] sentenceCharArr = finalSentence.toCharArray();

        avgNoOfChars = (avgNoOfChars + (sentenceCharArr.length - newLineCharsCount)) / 2;

        avgNoOfChars = roundNumber(avgNoOfChars);
        // System.out.println(roundNumber(avgNoOfChars));
    }

    private static float roundNumber(float number) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Float.parseFloat(df.format(number));
    }
}