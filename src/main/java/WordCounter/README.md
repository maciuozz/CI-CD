<h2>WORD FREQUENCY ANALYZER APPLICATION</h2>
This is a Java program that takes in a file path to a text file as an argument and then reads it to count the number of words and their respective frequencies.    
It then prints out the following information:    
   
- The total number of words in the file.      
- The word(s) with the highest frequency and its frequency. 

Special cases:   
a. If there is more than one word with the same highest frequency, it will print all of them along with the frequency.   
b. If all words have the same frequency, it will indicate this along with the frequency.   
c. If the file is empty, it will indicate this.   
 
The program uses a regular expression pattern to define the delimiter for parsing the input file. This pattern matches any non-letter character or apostrophe, so it effectively splits the input file into words and discards any non-alphabetic characters or apostrophes. By doing so, it ensures that only valid words are counted and their frequencies are correctly calculated.
It also includes ANSI color codes for better visual presentation.  
