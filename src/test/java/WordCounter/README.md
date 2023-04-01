<h2>WORD FREQUENCY ANALYZER TEST CLASS</h2>

This is a test class that uses JUnit to test the WordCounter class. JUnit is a widely used open-source testing framework for Java applications.  
In the ***tests**** repository there are all the files used to test the application.  

There are 7 tests and 2 methods.

***<h3>TESTS</h3>***
1. testEmptyFile() tests the application when an empty file is passed as input.
2. testNoFileNameProvided() tests the application when no file name is provided as input.
3. testInvalidFileName() tests the application when an invalid file name is provided as input.
4. testMultipleWordsWithSameFrequency() tests the application when the input file has multiple words with the same highest frequency.
5. testHighestFrequency() tests the application when the input file has just 1 word with the highest frequency.
6. testOneWord() tests the application when the input file has only one word.
7. testAllSameFrequency() tests the application when all the words in the input file have the same frequency.

***<h3>METHODS</h3>***
1. removeAnsiEscapeCodes(String str) takes a String argument str and removes any ANSI escape codes from it.
2. searchForFile(File directory, String filename) searches for a file with a given name filename in a directory and its subdirectories, 
   starting from the given directory parameter (root).


