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

    private UtilityConstants utilityConstants;

    /**
     * Constructor to set file paths from command line input and utility constants
     * object
     * 
     * @param files - Array of command line arguments containing file path
     */
    public FileProcessor(String[] files, UtilityConstants utilityConstants) {
        this.inputFilePath = files[0];
        this.outputFilePath = files[1];
        this.metricsFilePath = files[2];
        this.utilityConstants = utilityConstants;
    }

    /**
     * 
     * Function to proces input file
     */
    public void processInputFile() {
        /**
         * Creating the File object in order to
         */
        File inputFile = new File(inputFilePath);
        try {
            /**
             * Condition check to see if the input file exists or does not exist
             */

            if (inputFile.exists()) {
                /**
                 * Creating the FileReader object to read the input file contents
                 */
                inputFileReader = new FileReader(inputFile);

                /**
                 * Creating objects of other classes in order to process the senetences and
                 * print it in the output files
                 */
                SentenceHandler sentHandle = new SentenceHandler(utilityConstants);
                Results resultsObj = new Results(utilityConstants);
                MetricsCalculation metricCalnObj = new MetricsCalculation(utilityConstants);

                /**
                 * I nitializing the input and reversed word sentences
                 */
                String initialSentence = utilityConstants.emptyString;
                String reversedStr = utilityConstants.emptyString;

                /**
                 * Reading the characters from the file
                 */
                int i = inputFileReader.read();
                int index = 0;
                int sentenceCharCount = 0;
                boolean sentenceCompleted = true;

                /**
                 * Condition to check if the file is empty
                 */
                if (i != -1) {
                    while (i != -1) {
                        sentenceCompleted = false;
                        sentenceCharArr[index] = (char) i;
                        sentenceCharCount += 1;

                        /**
                         * Condition check for (".") period character in order to mark the reading of a
                         * sentence
                         */
                        if (((char) i) == utilityConstants.periodCharcter) {

                            initialSentence = String.copyValueOf(sentenceCharArr).substring(0, index + 1);

                            /**
                             * The input sentence is passed in order to be processed by revering the words
                             * in the sentence
                             */
                            reversedStr = sentHandle.processSentence(initialSentence, sentenceCharCount);

                            /**
                             * Condition check if the sentence processing method returns an empty string. If
                             * yes then we do not move forward to writing the output to output files
                             */
                            if (!reversedStr.equals(utilityConstants.emptyString)) {

                                /**
                                 * Performing the opertion to write the reversed words sentence to the output
                                 * text file.
                                 */
                                resultsObj.sentencesProcessed += 1;
                                resultsObj.setResultSentences(initialSentence, reversedStr);
                                resultsObj.isMetricsFilePath = false;
                                resultsObj.writeResultSentencesToFile(outputFilePath);

                                /**
                                 * Performing the calculation of various metrics for the input ssentence.
                                 */
                                metricCalnObj.performMetricsCalculation(initialSentence, reversedStr,
                                        sentHandle.newLineCount);

                                /**
                                 * Performing the operating to write the results of metrics calculated for the
                                 * given input sentence into the metrics file
                                 */
                                resultsObj.setResultMetrics(metricCalnObj.avgNoOfWrds, metricCalnObj.avgNoOfChars,
                                        metricCalnObj.maxFreqWrd, metricCalnObj.longstWrd);
                                resultsObj.isMetricsFilePath = true;
                                resultsObj.writeResultMetricsToFile(metricsFilePath);

                                /**
                                 * Clearing the contents from the character array storing characters of each
                                 * sentence
                                 */
                                Arrays.fill(sentenceCharArr, utilityConstants.nullCharacter);
                                index = -1;
                                sentenceCharCount = 0;
                                sentenceCompleted = true;

                            } else {
                                break;
                            }

                        }
                        index += 1;
                        i = inputFileReader.read();
                    }

                    /**
                     * Condition check to see if the sentences are process properly. If not then
                     * error messsages are printed.
                     */
                    if (!sentenceCompleted) {
                        System.out.println(utilityConstants.lineSeparator);
                        System.out.println(utilityConstants.invalidCharsErrorMsg);
                        inputFileReader.close();
                        deleteFiles(outputFilePath, metricsFilePath);
                    }

                } else {
                    System.out.println(utilityConstants.emptyFileErrorMsg);
                }

            } else {
                System.out.println(utilityConstants.inputFileNotExistErrorMsg);
            }

            inputFileReader.close();

        } catch (Exception e) {
            System.out.println(utilityConstants.lineSeparator);
            System.out.println(utilityConstants.fileProcessExceptnMsg);
            e.printStackTrace();
            deleteFiles(outputFilePath, metricsFilePath);

        }

    }

    /**
     * Function to delete files
     * 
     * @param files - An array of file path arguments
     */
    public void deleteFiles(String... files) {
        /**
         * Looping through the file paths provided in the array and deleting the files
         */
        File resultFile;
        for (String file : files) {
            resultFile = new File(file);
            if (resultFile.exists()) {
                resultFile.delete();
            }
        }

    }
}
