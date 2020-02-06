package wordPlay.util;

import java.io.FileWriter;
import java.io.File;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String reversedWrdsSentence;
    private String initialSentence;
    private float avgNoOfWrds;
    private float avgNoOfChars;
    private String maxFreqWrd;
    private String longstWrd;
    public int sentencesProcessed;
    public boolean isMetricsFilePath;

    /**
     * Function to set values for input and output sentences
     * 
     * @param initialSentence
     * @param reversedWrdsSentence
     */
    public void setResultSentences(String initialSentence, String reversedWrdsSentence) {
        this.initialSentence = initialSentence;
        this.reversedWrdsSentence = reversedWrdsSentence;
    }

    /**
     * Function to set metrics that have been calculated for the sentences
     * 
     * @param avgNoOfWrds
     * @param avgNoOfChars
     * @param maxFreqWrd
     * @param longstWrd
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
     * @param outputFilePath
     */
    public void writeResultSentencesToFile(String outputFilePath) {
        writeDataToFile(reversedWrdsSentence.toCharArray(), outputFilePath);
    }

    /**
     * Function to write the metrics calculated for the input sentences to metrics
     * file
     * 
     * @param metricsFilePath
     */
    public void writeResultMetricsToFile(String metricsFilePath) {
        String metricsOutputStr = "AVG_NUMBER_WORDS_PER_SENTENCE = " + avgNoOfWrds + "\nAVG_NUM_CHARS_PER_SENTENCE = "
                + avgNoOfChars + "\nMAX_FREQ_WORD = " + maxFreqWrd + "\nLONGEST_WORD = " + longstWrd;
        writeDataToFile(metricsOutputStr.toCharArray(), metricsFilePath);
    }

    /**
     * Function to write date into the file.
     * 
     * @param charArr
     * @param filePath
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

            System.out.println("Failure in writing to file.");
        }
    }

}
