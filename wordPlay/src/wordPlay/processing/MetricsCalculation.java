package wordPlay.processing;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class MetricsCalculation {

    private int totalWrdCount;
    private int totalCharCount;
    public float avgNoOfWrds;
    public float avgNoOfChars;
    public String maxFreqWrd = "";
    public String longstWrd = "";
    private int sentencesProcessed;
    HashMap<String, Integer> wrdFreqMap = new HashMap<>();

    public void performMetricsCalculation(String initialSentence, String finalSentence, int newLineCharsCount) {

        sentencesProcessed += 1;

        String[] words = initialSentence.trim().split("[\\s\\.]");

        calculateAvgNoOfWords(words);

        calculateAvgNoOfChars(initialSentence, newLineCharsCount);

        calculateMostFreqWrd(words);

        findLongestWrd(words);

    }

    private void calculateAvgNoOfWords(String[] words) {
        int count = 0;
        for (String str : words) {

            count = !str.isEmpty() ? count + 1 : count + 0;
        }
        totalWrdCount += count;

        avgNoOfWrds = ((float) totalWrdCount / (float) sentencesProcessed);
        avgNoOfWrds = roundNumber(avgNoOfWrds);
    }

    private void calculateAvgNoOfChars(String initialSentence, int newLineCharsCount) {
        char[] sentenceCharArr = initialSentence.toCharArray();
        totalCharCount += (sentenceCharArr.length - newLineCharsCount);

        avgNoOfChars = (float) totalCharCount / (float) sentencesProcessed;

        avgNoOfChars = roundNumber(avgNoOfChars);
    }

    private void calculateMostFreqWrd(String[] words) {

        for (String word : words) {
            if (wrdFreqMap.containsKey(word)) {
                wrdFreqMap.put(word, wrdFreqMap.get(word) + 1);
            } else {
                wrdFreqMap.put(word, 1);
            }
        }

        TreeMap<String, Integer> sortedWrdFreqTMap = getSortedMapByValue(wrdFreqMap);

        maxFreqWrd = sortedWrdFreqTMap.firstEntry().getKey();
    }

    private TreeMap<String, Integer> getSortedMapByValue(Map<String, Integer> wrdFreqMap) {
        Comparator<String> comparator = new ValueComparator(wrdFreqMap);

        TreeMap<String, Integer> sortedWrdFreqTMap = new TreeMap<String, Integer>(comparator);

        sortedWrdFreqTMap.putAll(wrdFreqMap);

        return sortedWrdFreqTMap;
    }

    private void findLongestWrd(String[] words) {

        for (String word : words) {
            if (word.toLowerCase().length() > longstWrd.toLowerCase().length()) {
                longstWrd = word;
            }

        }
    }

    private float roundNumber(float number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(number));
    }

}