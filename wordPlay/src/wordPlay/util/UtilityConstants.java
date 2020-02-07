package wordPlay.util;

/**
 * Class consisting of contant variables using by the program
 */
public class UtilityConstants {
    /**
     * Driver class constant variables
     */
    public final String INVALID_ARGUMENTS_ERROR_MESSAGE = "Error: Incorrect number of arguments. Program accepts 3 arguments.";

    public final String FIRST_ARGUMENT_VARIABLE_TEXT = "${arg0}";

    public final String SECOND_ARGUMENT_VARIABLE_TEXT = "${arg1}";

    public final String THIRD_ARGUMENT_VARIABLE_TEXT = "${arg2}";

    public final String PROGRAM_EXECUTION_COMPLETED_MSG = "Program execution completed!!!";

    /**
     * FileProcessor class constant variables
     */

    public final String EMPTY_STRING = "";

    public final String SPACE_STRING = " ";

    public final char PERIOD_CHARACTER = '.';

    public final char NULL_CHARACTER = '\0';

    public final String INVALID_CHARACTER_ERROR_MSG = "Error : The input file contains contains invalid characters."
            + "\nPlese check if there are special characters or extra spacing applied.";

    public final String EMPTY_FILE_ERROR_MSG = "Error : File is empty. Please enter some text in the file.";

    public final String INPUT_FILE_NOT_EXIST_ERROR_MSG = "Error : Input file doesnt exist.";

    public final String FILE_NOT_PRESENT_ERROR_MSG = "Error : File is not present in the directory.";

    public final String EXCEPTION_OCCURED_ERROR_MSG = "Exception occured!";

    public final String PRINT_STACK_TRACE_MSG = "Printing Stacktrace: -";

    public final String FILE_PROCESSING_EXCEPTION_MSG = "Error : Exception occured while processing the file.";

    /**
     * 
     * SentenceHandler class constants
     */

    public final String SENTENCE_VALIDATION_REGEXP = "[a-zA-Z0-9\\.\\s]";

    public final String SPACING_VALIDATION_REGEXP = " \\n|\\n\\n|  ";

    public final String SPLIT_BY_SPACING_REGEXP = "[\\s\\.]";

    public final String NEW_LINE_STRING = "\n";

    public final String PERIOD_STRING = ".";

    public final char NEW_LINE_CHARCTER = '\n';

    public final String SENTENCE_VALIDATION_EXCEPTION_MSG = "Error: Exception occured while validating the sentences";

    public final String REVERSE_WORD_EXCEPTION_MSG = "Error : Exception occured while reversing the words in the sentence.";

    public final String SENTENCE_PROCESSING_EXCEPTION_MSG = "Error : Exception occured while processing the sentence.";

    /**
     * Results class constants
     */

    public final String AVG_NO_OF_WORDS_STRING = "AVG_NUMBER_WORDS_PER_SENTENCE = ";

    public final String AVG_NO_OF_CHARACTERS_STRING = "AVG_NUM_CHARS_PER_SENTENCE = ";

    public final String MAX_FREQUENCY_WORDS_STRING = "MAX_FREQ_WORD = ";

    public final String LONGEST_WORDS_STRING = "LONGEST_WORD = ";

    public final String FILE_WRITING_ERROR_MSG = "Failure in writing to file.";

    /**
     * MetricsCalculation class constants
     */

    public final String DECIMAL_FORMAT_STRING = "#.##";

    public final String LINE_SEPARATOR = "--------------------------------------------------------------\n";
}