<h2>WORD FREQUENCY ANALYZER TEST CLASS</h2>

This is a test class that uses JUnit to test the WordCounter class. JUnit is a widely used open-source testing framework for Java applications.
In the ***tests*** repository there are all the files used to test the application.  

***<h3>TESTS</h3>***  
1. testEmptyFile() tests the application when an empty file is passed as input.
2. testNoFileNameProvided() tests the application when no file name is provided as input.
3. testInvalidFileName() tests the application when an invalid file name is provided as input.
4. testMultipleWordsWithSameFrequency() tests the application when the input file has multiple words with the same highest frequency.
5. testHighestFrequency() tests the application when the input file has just 1 word with the highest frequency.
6. testOneWord() tests the application when the input file has only one word.
7. testAllSameFrequency() tests the application when all the words in the input file have the same frequency.

During the test stage we use the JaCoCo plugin to generate a report on code coverage. This report can be viewed in the ***Artifacts*** section:

<img width="1792" alt="Screenshot 2023-04-05 at 18 19 43" src="https://user-images.githubusercontent.com/118285718/230146351-29a2f05f-0a13-460c-be37-b2253c72560b.png">

Clicking on the ***JaCoCo Coverage Report*** will open an HTML file where we can see that the ***main.java.count*** module has a code coverage of 79% for instructions and 81% for branches:  

<img width="1789" alt="Screenshot 2023-04-05 at 17 15 42" src="https://user-images.githubusercontent.com/118285718/230146378-954f117b-5777-4dd7-adab-ba699f5806f2.png">
