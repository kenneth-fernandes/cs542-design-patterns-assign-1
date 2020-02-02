package wordPlay.processing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentenceHandler {

    private Pattern p = Pattern.compile("[a-zA-Z0-9\\.\\s]");
    private Matcher m;
    private int charsLength;

    public void processSentence(String sentence, int charsLength) {
        this.charsLength = charsLength;

        if (isSentenceValid(sentence)) {

            System.out.print("Sentence is valid.");
        } else {

            System.out.print("Sentence is invalid.");
        }
    }

    private boolean isSentenceValid(String sentence) {

        System.out.println(sentence.length());
        System.out.println(this.charsLength);

        m = p.matcher(sentence);
        int count = 0;

        while (m.find()) {
            count = count + 1;
            // if (m.start() != 0 && sentence.charAt(m.start()) == '\n' &&
            // sentence.charAt(m.start() - 1) != ' ') {
        }
        System.out.println(count);
        if (this.charsLength != count) {
            return false;
        }

        return true;
    }

}