package wordPlay.processing;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MetricsCalculation {
    private static int totalWrdCount = 0;
    private static int totalCharCount = 0;
    public static float avgNoOfWrds = 0.00f;
    public static float avgNoOfChars = 0.00f;
    public static String maxFreqWrd = "";
    public static String longstWrd = "";

    public static void performMetricsCalculation(String initialSentence, String finalSentence, int newLineCharsCount) {

        calcWrdCount(finalSentence);

        calcCharCount(finalSentence, newLineCharsCount);

        // calculateAvgNoOfWords(finalSentence);

        // calculateAvgNoOfChars(finalSentence, newLineCharsCount);

        findLongestWrd(initialSentence);

    }

    private static void calcWrdCount(String finalSentence) {
        String[] words = finalSentence.split("[\\s\\.0-9]");

        for (String str : words) {
            if (str != "") {
                totalWrdCount += 1;
            }
        }

    }

    private static void calcCharCount(String finalSentence, int newLineCharsCount) {

        char[] sentenceCharArr = finalSentence.toCharArray();

        totalCharCount += (sentenceCharArr.length - newLineCharsCount);

    }

    private static void calculateAvgNoOfWords(String finalSentence) {
        String[] words = finalSentence.split("[\\s\\.0-9]");
        int count = 0;
        for (String str : words) {

            count = !str.isEmpty() ? count + 1 : count + 0;
        }
        avgNoOfWrds = avgNoOfChars == 0 ? avgNoOfChars + count : (avgNoOfWrds + count) / 2;
        avgNoOfWrds = roundNumber(avgNoOfWrds);
        System.out.println(roundNumber(avgNoOfWrds));
    }

    private static void calculateAvgNoOfChars(String finalSentence, int newLineCharsCount) {
        char[] sentenceCharArr = finalSentence.toCharArray();

        avgNoOfChars = (avgNoOfChars + (sentenceCharArr.length - newLineCharsCount)) / 2;

        avgNoOfChars = roundNumber(avgNoOfChars);
        System.out.println(roundNumber(avgNoOfChars));
    }

    private static void findLongestWrd(String initialSentence) {
        String[] words = initialSentence.trim().split("[\\s\\.]");
        for (String word : words) {
            if (word.toLowerCase().length() > longstWrd.toLowerCase().length()) {
                longstWrd = word;
            }

        }
        System.out.println(longstWrd);
    }

    private static float roundNumber(float number) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Float.parseFloat(df.format(number));
    }
}