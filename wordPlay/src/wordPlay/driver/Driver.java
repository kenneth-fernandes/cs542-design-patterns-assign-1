package wordPlay.driver;

/**
 * @author Kenneth Fernandes
 *
 */

import wordPlay.util.*;

public class Driver {
	/**
	 * The entry point of the program - main method
	 * 
	 * @param args - Command line arguments array
	 */
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}"))
				|| (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		FileProcessor fp = new FileProcessor(args);

		fp.processInputFile();

	}
}
