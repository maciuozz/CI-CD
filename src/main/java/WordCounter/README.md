<h2>WORD FREQUENCY ANALYZER APPLICATION</h2>
This is a Java program that takes in a file path as an argument and then reads the file to count the number of words and their respective frequencies. It then prints out the following information:        
      

1. The total number of words in the file.      
2. The word(s) with the highest frequency and its frequency. 

Special cases:   

a. If there is more than one word with the same highest frequency, it will print all of them along with the frequency.   
b. If all words have the same frequency, it will indicate this along with the frequency.   
c. If the file is empty, it will indicate this.   

The program also includes ANSI color codes for better visual presentation. The program uses a Scanner object to read the file and a HashMap to store the frequency of each word. The program also uses various constants to format the output, including ANSI codes for colored output.

The main method of the program checks if the user has provided a file name as input. If no file name is provided, an error message is printed, and the program exits. If a file name is provided, the program attempts to open the file and count the words in it. If the file cannot be opened or is not a valid file, an error message is printed, and the program exits. If the file is successfully opened and read, the program prints out the statistics about the words in the file.


