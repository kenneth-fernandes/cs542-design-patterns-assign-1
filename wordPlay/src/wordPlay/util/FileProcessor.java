package wordPlay.util;

import wordPlay.processing.MetricsCalculation;
import wordPlay.processing.SentenceHandler;
import java.io.*;
import java.util.Arrays;

public class FileProcessor {

    private String inputFilePath;
    private String outputFilePath;
    private String metricsFilePath;

    private char[] sentenceCharArr = new char[1024];

    public FileProcessor(String[] files) {
        this.inputFilePath = files[0];
        this.outputFilePath = files[1];
        this.metricsFilePath = files[2];
    }

    public void processFiles() {
        processInputFile();
    }

    private void processInputFile() {
        try {
            File inputFile = new File(inputFilePath);
            if (inputFile.exists()) {

                FileReader inputFileReader = new FileReader(inputFilePath);
                SentenceHandler sentHandle = new SentenceHandler();
                Results resultsObj = new Results();
                MetricsCalculation metricCalnObj = new MetricsCalculation();

                String initialSentence = "";
                String reversedStr = "";

                int i = inputFileReader.read();
                int index = 0;
                int sentencesProcessed = 0;
                int sentenceCharCount = 0;

                while (i != -1) {
                    sentenceCharArr[index] = (char) i;
                    sentenceCharCount += 1;
                    if (((char) i) == '.') {

                        initialSentence = String.copyValueOf(sentenceCharArr).substring(0, index + 1);

                        reversedStr = sentHandle.processSentence(initialSentence, sentenceCharCount);

                        resultsObj.sentencesProcessed += 1;

                        resultsObj.setResultSentences(initialSentence, reversedStr);
                        resultsObj.isMetricsFilePath = false;

                        resultsObj.writeResultSentencesToFile(outputFilePath);

                        metricCalnObj.performMetricsCalculation(initialSentence, reversedStr, sentHandle.newLineCount);

                        resultsObj.setResultMetrics(metricCalnObj.avgNoOfWrds, metricCalnObj.avgNoOfChars,
                                metricCalnObj.maxFreqWrd, metricCalnObj.longstWrd);

                        resultsObj.isMetricsFilePath = true;

                        resultsObj.writeResultMetricsToFile(metricsFilePath);

                        Arrays.fill(sentenceCharArr, '\0');

                        index = -1;
                        sentenceCharCount = 0;
                    }
                    index += 1;
                    i = inputFileReader.read();
                }

                inputFileReader.close();
            } else {
                System.out.println("Input file doesnt exist.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
