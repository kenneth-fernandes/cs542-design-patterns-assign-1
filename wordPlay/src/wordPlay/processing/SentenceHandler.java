package wordPlay.processing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentenceHandler {

    private Pattern p1 = Pattern.compile("[a-zA-Z0-9\\.\\s]");
    private Pattern p2 = Pattern.compile(" \\n");
    private Pattern p3 = Pattern.compile("[a-zA-Z0-9]");
    private Matcher m;
    private int charsLength;
    private String[] words;

    public void processSentence(String sentence, int charsLength) {
        this.charsLength = charsLength;

        if (isSentenceValid(sentence)) {
            // System.out.println(sentence);
            String[] words = sentence.split("[\\s\\.]");
            String reversedStr = "";

            for (int i = 0; i < words.length - 1; i += 1) {
                String reversedWrd = "";

                char[] wordCharArr = words[i].toCharArray();
                for (int j = wordCharArr.length - 1; j > -1; j -= 1) {
                    reversedWrd = reversedWrd.concat("" + wordCharArr[j]);
                }

                reversedStr = reversedStr.concat(reversedWrd + " ");

            }

            System.out.println(reversedStr);

            // System.out.print("Sentence is valid.");
        } else {

            System.out.print("Sentence is invalid.");
        }
    }

    private boolean isSentenceValid(String sentence) {

        m = p1.matcher(sentence);
        int count = 0;

        while (m.find()) {
            count = count + 1;
        }

        if (this.charsLength != count) {
            return false;
        }
        m = p2.matcher(sentence);

        count = 0;
        while (m.find()) {
            count = count + 1;
        }
        return count == 0 ? true : false;
    }

}