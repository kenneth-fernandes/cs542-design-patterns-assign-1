package wordPlay.util;

import wordPlay.processing.MetricsCalculation;
import wordPlay.processing.SentenceHandler;
import java.io.*;
import java.util.Arrays;

public class FileProcessor {

    private String inputFilePath;
    private String outputFilePath;
    private String metricsFilePath;

    private FileReader inputFileReader;
    private char[] sentenceCharArr = new char[1024];

    /**
     * Constructor to set file paths from command line input
     * 
     * @param files - Array of command line arguments containing file path
     */
    public FileProcessor(String[] files) {
        this.inputFilePath = files[0];
        this.outputFilePath = files[1];
        this.metricsFilePath = files[2];
    }

    /**
     * 
     * Function to proces input file
     */
    public void processInputFile() {
        File inputFile = new File(inputFilePath);
        try {

            if (inputFile.exists()) {

                inputFileReader = new FileReader(inputFilePath);
                SentenceHandler sentHandle = new SentenceHandler();
                Results resultsObj = new Results();
                MetricsCalculation metricCalnObj = new MetricsCalculation();

                String initialSentence = "";
                String reversedStr = "";

                int i = inputFileReader.read();
                int index = 0;
                int sentenceCharCount = 0;

                if (i != -1) {
                    while (i != -1) {
                        sentenceCharArr[index] = (char) i;
                        sentenceCharCount += 1;
                        if (((char) i) == '.') {

                            initialSentence = String.copyValueOf(sentenceCharArr).substring(0, index + 1);

                            reversedStr = sentHandle.processSentence(initialSentence, sentenceCharCount);
                            if (!reversedStr.equals("")) {
                                resultsObj.sentencesProcessed += 1;

                                resultsObj.setResultSentences(initialSentence, reversedStr);
                                resultsObj.isMetricsFilePath = false;

                                resultsObj.writeResultSentencesToFile(outputFilePath);

                                metricCalnObj.performMetricsCalculation(initialSentence, reversedStr,
                                        sentHandle.newLineCount);

                                resultsObj.setResultMetrics(metricCalnObj.avgNoOfWrds, metricCalnObj.avgNoOfChars,
                                        metricCalnObj.maxFreqWrd, metricCalnObj.longstWrd);

                                resultsObj.isMetricsFilePath = true;

                                resultsObj.writeResultMetricsToFile(metricsFilePath);

                                Arrays.fill(sentenceCharArr, '\0');

                                index = -1;
                                sentenceCharCount = 0;
                            } else {
                                System.out.println("The input file contains contains invalid characters.");
                                break;
                            }

                        }
                        index += 1;
                        i = inputFileReader.read();
                    }
                } else {
                    System.out.println("File is empty. Please enter some text in the file. ");
                }

            } else {
                System.out.println("Input file doesnt exist.");
            }
            if (inputFileReader == null) {
                inputFileReader.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not present in the directory.");
        } catch (Exception e) {
            System.out.println("Exception occured! Printing Stacktrace: -");
            e.printStackTrace();
        }

    }
}
