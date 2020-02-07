package wordPlay.util;

import java.io.FileWriter;
import java.io.File;
import wordPlay.util.UtilityConstants;

/**
 * Class consisting of functions to write sentence processing and metrics
 * results to the output files
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private UtilityConstants utilityConstants;
    private String reversedWrdsSentence;
    private String initialSentence;
    private float avgNoOfWrds;
    private float avgNoOfChars;
    private String maxFreqWrd;
    private String longstWrd;
    public int sentencesProcessed;
    public boolean isMetricsFilePath;

    /**
     * Resuls class constructor for setting the constants object
     * 
     * @param utilityConstants - Utility constants object
     */
    public Results(UtilityConstants utilityConstants) {
        this.utilityConstants = utilityConstants;
    }

    /**
     * Function to set values for input and output sentences
     * 
     * @param initialSentence      - The sentence from input text
     * @param reversedWrdsSentence - The sentence after text words are reversed
     */
    public void setResultSentences(String initialSentence, String reversedWrdsSentence) {
        this.initialSentence = initialSentence;
        this.reversedWrdsSentence = reversedWrdsSentence;
    }

    /**
     * Function to set metrics that have been calculated for the sentences
     * 
     * @param avgNoOfWrds  - Average of number of words in sentences
     * @param avgNoOfChars - Average of number of characters in sentences
     * @param maxFreqWrd   - Most frequent word in the input file
     * @param longstWrd    - Longest word in the file
     */
    public void setResultMetrics(float avgNoOfWrds, float avgNoOfChars, String maxFreqWrd, String longstWrd) {
        this.avgNoOfWrds = avgNoOfWrds;
        this.avgNoOfChars = avgNoOfChars;
        this.maxFreqWrd = maxFreqWrd;
        this.longstWrd = longstWrd;
    }

    /**
     * Function to write the reversed words sentences the the output file
     * 
     * @param outputFilePath - Path of output text file used for storing reversed
     *                       words sentences
     */
    public void writeResultSentencesToFile(String outputFilePath) {
        writeDataToFile(reversedWrdsSentence.toCharArray(), outputFilePath);
    }

    /**
     * Function to write the metrics calculated for the input sentences to metrics
     * file
     * 
     * @param metricsFilePath - Path of metrics text file used for metrics for input
     *                        sentences
     */
    public void writeResultMetricsToFile(String metricsFilePath) {
        String metricsOutputStr = utilityConstants.AVG_NO_OF_WORDS_STRING + avgNoOfWrds
                + utilityConstants.NEW_LINE_STRING + utilityConstants.AVG_NO_OF_CHARACTERS_STRING + avgNoOfChars
                + utilityConstants.NEW_LINE_STRING + utilityConstants.MAX_FREQUENCY_WORDS_STRING + maxFreqWrd
                + utilityConstants.NEW_LINE_STRING + utilityConstants.LONGEST_WORDS_STRING + longstWrd;
        writeDataToFile(metricsOutputStr.toCharArray(), metricsFilePath);
    }

    /**
     * Function to write date into the file.
     * 
     * @param charArr  - Arrays of sentences characters
     * @param filePath - Path of the file to write the output data
     */
    private void writeDataToFile(char[] charArr, String filePath) {
        try {

            File outputFile = new File(filePath);

            if (sentencesProcessed == 1 || isMetricsFilePath) {
                outputFile.delete();
                outputFile.createNewFile();
            }

            FileWriter outputFileWrtrObj = new FileWriter(outputFile, true);

            for (char ch : charArr) {
                outputFileWrtrObj.write(ch);
            }

            outputFileWrtrObj.close();

        } catch (Exception e) {
            System.out.println(utilityConstants.LINE_SEPARATOR);
            System.out.println(utilityConstants.FILE_WRITING_ERROR_MSG);
            e.printStackTrace();

        }
    }
}
