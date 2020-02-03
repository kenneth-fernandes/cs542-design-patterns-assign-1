package wordPlay.util;

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

                int i = inputFileReader.read();
                int index = 0;
                int charCount = 0;
                while (i != -1) {
                    sentenceCharArr[index] = (char) i;
                    charCount += 1;
                    if (((char) i) == '.') {

                        sentHandle.processSentence(String.copyValueOf(sentenceCharArr), charCount);

                        Arrays.fill(sentenceCharArr, '\0');
                        index = -1;
                        charCount = 0;
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
