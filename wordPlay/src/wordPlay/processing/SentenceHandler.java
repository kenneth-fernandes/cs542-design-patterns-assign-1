package wordPlay.processing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentenceHandler {

    private Pattern p1 = Pattern.compile("[a-zA-Z0-9\\.\\s]");
    private Pattern p2 = Pattern.compile(" \\n|\\n\\n|  ");
    private Matcher m;
    private int sentenceCharsLength;
    private int[] newLinePositionArr;
    public int newLineCount;

    /**
     * Function to start processing of the sentence
     * 
     * @param sentence    - The sentence from input text file
     * @param charsLength - The length of characters of the sentence
     * @return - Reversed string or empty string
     */
    public String processSentence(String sentence, int charsLength) {
        this.sentenceCharsLength = charsLength;

        if (isSentenceValid(sentence)) {

            String[] words = sentence.split("[\\s\\.]");

            String reversedStr = getReversedWrdsStr(words);

            for (int i = 0; i < newLineCount; i += 1) {

                if (newLinePositionArr[i] == 0) {
                    reversedStr = sentence.charAt(newLinePositionArr[i])
                            + reversedStr.substring(newLinePositionArr[i] + 1, reversedStr.length());

                } else if (newLinePositionArr[i] == sentenceCharsLength - 2) {
                    reversedStr = reversedStr.substring(0, newLinePositionArr[i]) + "\n.";
                } else {
                    reversedStr = reversedStr.substring(0, newLinePositionArr[i]) + "\n"
                            + reversedStr.substring(newLinePositionArr[i] + 1, reversedStr.length());
                }

            }
            newLinePositionArr = null;

            return reversedStr;

        } else {
            return "";
        }
    }

    /**
     * Function to check if the sentence is valid or not
     * 
     * @param sentence - Sentence of the input text file
     * @return - Retruns if the sentence is valid or not
     */
    private boolean isSentenceValid(String sentence) {

        m = p1.matcher(sentence);
        int count = 0;
        newLineCount = 0;
        newLinePositionArr = new int[50];

        while (m.find()) {
            count = count + 1;
            if (sentence.charAt(count - 1) == '\n') {
                newLinePositionArr[newLineCount] = count - 1;
                newLineCount += 1;
            }
        }

        if (this.sentenceCharsLength != count) {
            return false;
        }
        m = p2.matcher(sentence);

        count = 0;
        while (m.find()) {
            count = count + 1;
        }

        return count == 0 ? true : false;
    }

    /**
     * Function to reverese the words in a sentence
     * 
     * @param words Array of words of a sentence
     * @return Returns the reversed words string
     */
    private String getReversedWrdsStr(String[] words) {

        String reversedStr = "";
        for (int i = 0; i < words.length; i += 1) {
            String reversedWrd = "";

            if (words[i] == "") {
                reversedStr = " ";
            } else {

                char[] wordCharArr = words[i].toCharArray();
                for (int j = wordCharArr.length - 1; j > -1; j -= 1) {
                    reversedWrd = reversedWrd.concat(String.valueOf(wordCharArr[j]));
                }
            }

            reversedStr = reversedStr.concat(reversedWrd + " ");

        }
        reversedStr = reversedStr.substring(0, reversedStr.length() - 1) + ".";

        return reversedStr;
    }

}