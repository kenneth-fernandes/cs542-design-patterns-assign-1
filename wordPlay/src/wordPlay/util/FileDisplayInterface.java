package wordPlay.util;

public interface FileDisplayInterface {
    /**
     * Function to write the reversed words sentences the the output file
     * 
     * @param outputFilePath
     */
    void writeResultSentencesToFile(String outputFilePath);

    /**
     * Function to write the metrics calculated for the input sentences to metrics
     * file
     * 
     * @param metricsFilePath
     */
    void writeResultMetricsToFile(String metricsFilePath);
}
