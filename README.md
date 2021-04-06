# CS542 - Design Patterns: Assignment 1
## Name: Kenneth Peter Fernandes

-----------------------------------------------------------------------
## Assignment Goal:
Assignment Goal: Develop a program, using Java, to reverse the words constituting sentences in a file and also to calculate certain metrics.

An input file contains sentences. Each sentence contains words delimited by <space> character. Each sentence terminates with a period.
The words in each sentence should be reversed.
The sentences with the words reversed should be written to an output file.
Note: words in the input file are made of characters [a-zA-Z0-9] Note: The order of words in the sentence should not be changed - just each word should be reversed. Example A good student => A doog tneduts
Note: The order of sentences should not be changed. Instead, the words in each sentence need to be reversed (see input/output example for better understanding).
METRICS

The following metrics should be calculated and written to a metrics file, the name of which provided via commandline.
AVG_NUM_WORDS_PER_SENTENCE - Average number of words per sentence. Round to 2 decimal places. Format: AVG_NUM_WORDS_PER_SENTENCE = <value>
AVG_NUM_CHARS_PER_SENTENCE - Average number of characters per sentence (include spaces, including period, excluding newline characters). Round to 2 decimal places. Format: AVG_NUM_CHARS_PER_SENTENCE = <value>
MAX_FREQ_WORD - Most used word in the file (max frequency). If there is contention between multiple words, then any one of them can be selected. Format: MAX_FREQ = <value>
LONGEST_WORD - Word with the most number of characters. If there is contention between multiple words, then any one of them can be selected. Format: LONGEST_WORD = <value>
The following rules MUST be followed.

The input file should be processed one sentence at a time.
The program should not read in all the lines and store it in a data structure.
You should implement your own function for reversing a string.
INPUT FORMAT 

Your program should accept three filenames from the commandline - input.txt, putput.txt, and metrics.txt. Note that input.txt will be well formatted. 

EXAMPLES 

input.txt
```
A new student has registered for design patterns in the spring of 2020. During the semester the students
are going to learn good design principles and design guidelines to be followed when developing applications.
All programming assignments are to be done in Java.
```
output.txt
```
A wen tneduts sah deretsiger rof ngised snrettap ni eht gnirps fo 0202. gniruD eht retsemes eht stneduts
era gniog ot nrael doog ngised selpicnirp dna ngised senilediug ot eb dewollof nehw gnipoleved snoitacilppa.
llA gnimmargorp stnemngissa era ot eb enod ni avaJ.
```
metrics.txt
```
AVG_NUMBER_WORDS_PER_SENTENCE = 14.33
AVG_NUM_CHARS_PER_SENTENCE = 87.66
MAX_FREQ_WORD = design
LONGEST_WORD = applications
```
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


