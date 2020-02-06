package wordPlay.processing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import wordPlay.util.UtilityConstants;

public class SentenceHandler {

    private Matcher matcherObj;
    private int sentenceCharsLength;
    private int[] newLinePositionArr;
    public int newLineCount;
    private Pattern sentenceValidntPatternObj;
    private Pattern spaceinValidntPatternObj;
    private UtilityConstants utilityConstants;

    /**
     * Constructor of SentenceHandler that set the utilityConstants object with its
     * handle and intializes the Pattern object
     * 
     * @param utilityConstants - The utility constants object
     */
    public SentenceHandler(UtilityConstants utilityConstants) {
        this.utilityConstants = utilityConstants;
        this.sentenceValidntPatternObj = Pattern.compile(utilityConstants.sentenceValidationRegExp);
        this.spaceinValidntPatternObj = Pattern.compile(utilityConstants.spacingValidationRegExp);
    }

    /**
     * Function to start processing of the sentence
     * 
     * @param sentence    - The sentence from input text file
     * @param charsLength - The length of characters of the sentence
     * @return - Reversed string or empty string
     */
    public String processSentence(String sentence, int charsLength) {
        try {
            this.sentenceCharsLength = charsLength;

            /**
             * Checking if the sentence is having invalid charcters. Returns empty string if
             * invalid.
             */
            if (isSentenceValid(sentence)) {

                /**
                 * Once the sentence is validated, the sentence is passed for revering of words.
                 */
                String[] words = sentence.split(utilityConstants.splitBySpacingRegExp);
                String reversedStr = getReversedWrdsStr(words);

                /**
                 * Logic to position the new line charcter in the reversed string
                 */
                for (int i = 0; i < newLineCount; i += 1) {

                    if (newLinePositionArr[i] == 0) {
                        reversedStr = sentence.charAt(newLinePositionArr[i])
                                + reversedStr.substring(newLinePositionArr[i] + 1, reversedStr.length());

                    } else if (newLinePositionArr[i] == sentenceCharsLength - 2) {
                        reversedStr = reversedStr.substring(0, newLinePositionArr[i]) + utilityConstants.newLineString
                                + utilityConstants.periodString;
                    } else {
                        reversedStr = reversedStr.substring(0, newLinePositionArr[i]) + utilityConstants.newLineString
                                + reversedStr.substring(newLinePositionArr[i] + 1, reversedStr.length());
                    }

                }
                newLinePositionArr = null;

                return reversedStr;

            } else {
                return utilityConstants.emptyString;
            }
        } catch (Exception e) {
            System.out.println(utilityConstants.lineSeparator);
            System.out.println(utilityConstants.sentenceProcessExceptnMsg);
            e.printStackTrace();
            return utilityConstants.emptyString;
        }

    }

    /**
     * Function to check if the sentence is valid or not
     * 
     * @param sentence - Sentence of the input text file
     * @return - Retruns if the sentence is valid or not
     */
    private boolean isSentenceValid(String sentence) {
        try {

            /**
             * Creating the matcher object for regular expression matching for sentence
             * validation.
             */
            matcherObj = sentenceValidntPatternObj.matcher(sentence);
            int count = 0;
            newLineCount = 0;
            newLinePositionArr = new int[50];

            /**
             * Logic to check if the count of characters matching the pattern is equal to
             * the count of input characters.
             */
            while (matcherObj.find()) {
                count = count + 1;
                if (sentence.charAt(count - 1) == utilityConstants.newLineCharacter) {
                    newLinePositionArr[newLineCount] = count - 1;
                    newLineCount += 1;
                }
            }
            if (this.sentenceCharsLength != count) {
                return false;
            }

            /**
             * Creating the matcher object for regular expression matching for checking
             * unwanted spacings
             */

            matcherObj = spaceinValidntPatternObj.matcher(sentence);

            /**
             * Counting if there is unwanted spacing in the sentence
             */
            count = 0;
            while (matcherObj.find()) {
                count = count + 1;
            }

            return count == 0 ? true : false;

        } catch (Exception e) {
            System.out.println(utilityConstants.lineSeparator);
            System.out.println(utilityConstants.sentenceValidntExceptnMsg);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Function to reverese the words in a sentence
     * 
     * @param words - Array of words of a sentence
     * @return - Returns the reversed words string
     */
    private String getReversedWrdsStr(String[] words) {

        /**
         * Logic to reverese each word of the sentence and append it as one sentence
         */
        String reversedStr = utilityConstants.emptyString;
        try {
            for (int i = 0; i < words.length; i += 1) {
                String reversedWrd = utilityConstants.emptyString;

                char[] wordCharArr = words[i].toCharArray();
                for (int j = wordCharArr.length - 1; j > -1; j -= 1) {
                    reversedWrd = reversedWrd.concat(String.valueOf(wordCharArr[j]));

                }
                reversedStr = reversedStr.concat(reversedWrd + utilityConstants.spaceString);
            }
            reversedStr = reversedStr.substring(0, reversedStr.length() - 1) + utilityConstants.periodString;

            return reversedStr;

        } catch (Exception e) {
            System.out.println(utilityConstants.lineSeparator);
            System.out.println(utilityConstants.reverseWrdExceptnMsg);
            e.printStackTrace();
            return utilityConstants.emptyString;
        }
    }

}