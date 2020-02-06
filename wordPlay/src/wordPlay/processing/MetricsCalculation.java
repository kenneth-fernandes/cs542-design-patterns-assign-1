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
    private HashMap<String, Integer> wrdFreqMap = new HashMap<>();

    /**
     * Function to calculate metrics for the input sentences
     * 
     * @param initialSentence   - The sentence from input text
     * @param finalSentence     - The sentence after text words are reversed
     * @param newLineCharsCount - Count of new line characters
     */
    public void performMetricsCalculation(String initialSentence, String finalSentence, int newLineCharsCount) {

        sentencesProcessed += 1;

        String[] words = initialSentence.trim().split("[\\s\\.]");

        calculateAvgNoOfWords(words);

        calculateAvgNoOfChars(initialSentence, newLineCharsCount);

        calculateMostFreqWrd(words);

        findLongestWrd(words);

    }

    /**
     * Function to calculate average number of words
     * 
     * @param words - Array of words from the sentence
     */
    private void calculateAvgNoOfWords(String[] words) {
        int count = 0;
        for (String str : words) {

            count = !str.isEmpty() ? count + 1 : count + 0;
        }
        totalWrdCount += count;

        avgNoOfWrds = ((float) totalWrdCount / (float) sentencesProcessed);
        avgNoOfWrds = roundNumber(avgNoOfWrds);
    }

    /**
     * Function to calculate average number of characters in a sentences
     * 
     * @param initialSentence   - The sentence from input text
     * @param newLineCharsCount - Count of new line characters
     */
    private void calculateAvgNoOfChars(String initialSentence, int newLineCharsCount) {
        char[] sentenceCharArr = initialSentence.toCharArray();
        totalCharCount += (sentenceCharArr.length - newLineCharsCount);

        avgNoOfChars = (float) totalCharCount / (float) sentencesProcessed;

        avgNoOfChars = roundNumber(avgNoOfChars);
    }

    /**
     * Function to calculate frequently appearing words in a sentence
     * 
     * @param words - Array of words from the sentence
     */
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

    /**
     * Function to ge sorted Tree map of words frequency of sentences
     * 
     * @param wrdFreqMap -- Word frequency Map object
     * @return
     */
    private TreeMap<String, Integer> getSortedMapByValue(Map<String, Integer> wrdFreqMap) {
        Comparator<String> comparator = new ValueComparator(wrdFreqMap);

        TreeMap<String, Integer> sortedWrdFreqTMap = new TreeMap<String, Integer>(comparator);

        sortedWrdFreqTMap.putAll(wrdFreqMap);

        return sortedWrdFreqTMap;
    }

    /**
     * Function to find longest word in a sentence
     * 
     * @param words - Array of words of the input sentence
     */
    private void findLongestWrd(String[] words) {

        for (String word : words) {
            if (word.toLowerCase().length() > longstWrd.toLowerCase().length()) {
                longstWrd = word;
            }

        }
    }

    /**
     * Function to round the number
     * 
     * @param number - The number that needs to be rounded
     * @return - The rounded float value of a number
     */
    private float roundNumber(float number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(number));
    }

}