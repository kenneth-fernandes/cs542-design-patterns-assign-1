package wordPlay.processing;

import java.util.regex.Pattern;

public class SentenceHandler {

    public void processSentence(String sentence) {
        if (isSentenceValid(sentence)) {

            System.out.println("Sentence is valid.");
        } else {

            System.out.println("Sentence is invalid.");
        }
    }

    private boolean isSentenceValid(String sentence) {

        System.out.println(sentence);
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s]");

        return pattern.matcher(sentence).matches();

    }
}