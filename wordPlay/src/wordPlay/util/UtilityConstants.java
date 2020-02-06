package wordPlay.util;

public class UtilityConstants {
    /**
     * Driver class constant variables
     */
    public final String invalidArgumentsErroMsg = "Error: Incorrect number of arguments. Program accepts 3 arguments.";

    public final String firstArgumentVariableTxt = "${arg0}";

    public final String secondArgumentVariableTxt = "${arg1}";

    public final String thirdArgumentVariableTxt = "${arg2}";

    public final String programExectnCompletdMsg = "Program execution completed!!!";

    /**
     * FileProcessor class constant variables
     */

    public final String emptyString = "";

    public final String spaceString = " ";

    public final char periodCharcter = '.';

    public final char nullCharacter = '\0';

    public final String invalidCharsErrorMsg = "Error : The input file contains contains invalid characters."
            + "\nPlese check if there are special characters or extra spacing applied.";

    public final String emptyFileErrorMsg = "Error : File is empty. Please enter some text in the file.";

    public final String inputFileNotExistErrorMsg = "Error : Input file doesnt exist.";

    public final String fileNotPresentErrorMsg = "Error : File is not present in the directory.";

    public final String exceptionOccuredErrorMsg = "Exception occured!";

    public final String printStackTraceMsg = "Printing Stacktrace: -";

    public final String fileProcessExceptnMsg = "Error : Exception occured while processing the file.";

    /**
     * 
     * SentenceHandler class constants
     */

    public final String sentenceValidationRegExp = "[a-zA-Z0-9\\.\\s]";

    public final String spacingValidationRegExp = " \\n|\\n\\n|  ";

    public final String splitBySpacingRegExp = "[\\s\\.]";

    public final String newLineString = "\n";

    public final String periodString = ".";

    public final char newLineCharacter = '\n';

    public final String sentenceValidntExceptnMsg = "Error: Exception occured while validating the sentences";

    public final String reverseWrdExceptnMsg = "Error : Exception occured while reversing the words in the sentence.";

    public final String sentenceProcessExceptnMsg = "Error : Exception occured while processing the sentence.";

    /**
     * Results class constants
     */

    public final String averageNoOfWrdsString = "AVG_NUMBER_WORDS_PER_SENTENCE = ";

    public final String averageNoOCharsString = "AVG_NUM_CHARS_PER_SENTENCE = ";

    public final String maxFrequencyWrdsString = "MAX_FREQ_WORD = ";

    public final String longstWrdsString = "LONGEST_WORD = ";

    public final String fileWritingErrorMsg = "Failure in writing to file.";

    /**
     * MetricsCalculation class constants
     */

    public final String decimalFormatString = "#.##";

    public final String lineSeparator = "--------------------------------------------------------------\n";
}