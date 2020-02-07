package wordPlay.driver;

/**
 * @author Kenneth Fernandes
 *
 */

import wordPlay.util.FileProcessor;
import wordPlay.util.UtilityConstants;

/**
 * Driver class containing the entry point of the program
 */
public class Driver {
	/**
	 * The entry point of the program - main method
	 * 
	 * @param args - Command line arguments array
	 */
	public static void main(String[] args) {

		/**
		 * Creating the utility constants object
		 */
		UtilityConstants utilityConstants = new UtilityConstants();
		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals(utilityConstants.FIRST_ARGUMENT_VARIABLE_TEXT))
				|| (args[1].equals(utilityConstants.SECOND_ARGUMENT_VARIABLE_TEXT))
				|| (args[2].equals(utilityConstants.THIRD_ARGUMENT_VARIABLE_TEXT))) {
			System.err.println(utilityConstants.INVALID_ARGUMENTS_ERROR_MESSAGE);
			System.exit(0);
		}

		FileProcessor fileProcessor = new FileProcessor(args, utilityConstants);

		/**
		 * Deleting the output files that are already present
		 */
		fileProcessor.deleteFiles(args[1], args[2]);

		/**
		 * Initiating the file processing for reading the input file
		 */
		boolean status = fileProcessor.processInputFile();

		if (status) {
			System.out.println(utilityConstants.PROGRAM_EXECUTION_COMPLETED_MSG);
		}

	}
}
