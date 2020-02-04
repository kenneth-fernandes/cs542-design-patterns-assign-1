package wordPlay.util;

import java.io.FileWriter;
import java.io.IOException;
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

    public void setResultSentences(String initialSentence, String reversedWrdsSentence) {
        this.initialSentence = initialSentence;
        this.reversedWrdsSentence = reversedWrdsSentence;
    }

    public void setResultMetrics(float avgNoOfWrds, float avgNoOfChars, String maxFreqWrd, String longstWrd) {
        this.avgNoOfWrds = avgNoOfWrds;
        this.avgNoOfChars = avgNoOfChars;
        this.maxFreqWrd = maxFreqWrd;
        this.longstWrd = longstWrd;
    }

    public void writeResultSentencesToFile(String outputFilePath) {
        writeDataToFile(reversedWrdsSentence.toCharArray(), outputFilePath);
    }

    public void writeResultMetricsToFile(String metricsFilePath) {
        String metricsOutputStr = "AVG_NUMBER_WORDS_PER_SENTENCE = " + avgNoOfWrds + "\nAVG_NUM_CHARS_PER_SENTENCE = "
                + avgNoOfChars + "\nMAX_FREQ_WORD = " + maxFreqWrd + "\nLONGEST_WORD = " + longstWrd;
        writeDataToFile(metricsOutputStr.toCharArray(), metricsFilePath);
    }

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
            System.out.println(e);
            System.out.println("Failure in writing to file.");
        }
    }

}
