# CS542 - Design Patterns: Assignment 1
## Name: Kenneth Peter Fernandes

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="src/wordPlay/inputFiles/input.txt" -Darg1="src/BUILD/resultFiles/output.txt" -Darg2="src/BUILD/resultFiles/metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
 1. Assumptions:
 - Input file is well formatted with sentences that are equally spaced between two words and ends with a period.
 - Absoulte path of the files to be passed as input arguments while executing the program.
 - Input arguments to the run command are in the order input.txt file path, output.txt file path, metrics.txt file path.

 2. Data structures:
 - Arrays - Used character array for storing characters of each word and reversing the characters of the string. Also used for average number of characters.
 - Arrays - Used for storing words for finding the longest word.
 - HashMap - Used for storing words as key and count of frequency.
 - TreeMap - Used for sorting the words by implementing the Comparator interface to compare the value associated with the key for sorting the TreeMap.
  
 3. External Materials:
 - Used HashMap, TreeMap as well as implementing the Comparator interface's compare method to find the most frequent words in the sentence.

 4. Compiling:
 - Follow the instruction as mentioned above.

 5. Run:
 - Follow the instructions as mentioned above.

 6. Code working:
 - The contents of input text file are read charcter wise and once a period character appears, store the sentence and process it accordingly.
 - The sentence is written character wise in the output files.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 1/31/2020


