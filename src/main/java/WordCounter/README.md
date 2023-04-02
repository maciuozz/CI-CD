<h2>WORD FREQUENCY ANALYZER APPLICATION</h2>  

This is a Java program that takes in a path to a text file as an argument and then reads it to count the number of words and their respective frequencies. It then prints out the following information:    
   
- The total number of words in the file.      
- The word(s) with the highest frequency and its frequency. 

Special cases:   

a. If there is more than one word with the same highest frequency, it will print all of them along with the frequency.   
b. If all words have the same frequency, it will indicate this along with the frequency.   
c. If the file is empty, it will indicate this.   
 
The program uses a regular expression pattern to define the delimiter for parsing the input file. This pattern matches any non-letter character or apostrophe, so it effectively splits the input file into words and discards any non-alphabetic characters or apostrophes. By doing so, it ensures that only valid words are counted and their frequencies are correctly calculated.
It also includes ANSI color codes for better visual presentation:  

<img width="892" alt="Screenshot 2023-03-31 at 12 56 02" src="https://user-images.githubusercontent.com/118285718/229329252-4d188cd0-411a-4e23-8f36-3354ad74510c.png">

<img width="917" alt="Screenshot 2023-04-02 at 05 43 13" src="https://user-images.githubusercontent.com/118285718/229330114-616b416f-913f-4531-a021-5edaa7162a44.png">

<img width="889" alt="Screenshot 2023-04-02 at 05 48 38" src="https://user-images.githubusercontent.com/118285718/229330294-dd24c31c-621a-4822-8523-de349c9948d1.png">


When attempting to pass a non-existent or empty name to the application, we get:  

<img width="787" alt="Screenshot 2023-04-02 at 05 24 01" src="https://user-images.githubusercontent.com/118285718/229329611-ee15654a-6278-4580-9ffd-84ec03a137af.png">
