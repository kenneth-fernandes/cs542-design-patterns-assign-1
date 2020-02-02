package wordPlay.util;

import wordPlay.processing.SentenceHandler;
import java.io.*;
import java.util.Arrays;

public class FileProcessor {

    private String inputFilePath;
    private String outputFilePath;
    private String metricsFilePath;
    private char[] sentenceCharArr = new char[2096];

    public FileProcessor(String[] files) {
        this.inputFilePath = files[0];
        this.outputFilePath = files[1];
        this.metricsFilePath = files[2];
    }

    public void processFile() {
        try {
            File inputFile = new File(inputFilePath);
            if (inputFile.exists()) {
                FileReader fileReader = new FileReader(inputFilePath);
                SentenceHandler sentHandle = new SentenceHandler();

                int i = fileReader.read();
                int index = 0;
                int charCount = 0;
                int startIndex = 0;
                while (i != -1) {
                    sentenceCharArr[index] = (char) i;
                    charCount += 1;
                    if (((char) i) == '.') {
                        sentHandle.processSentence(String.copyValueOf(sentenceCharArr), charCount);
                        Arrays.fill(sentenceCharArr, '\0');
                        startIndex = charCount;
                        charCount = 0;

                    }
                    index += 1;
                    i = fileReader.read();
                }

                fileReader.close();
            } else {

            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

}
