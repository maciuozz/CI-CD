<h2>WORD FREQUENCY ANALYZER APPLICATION</h2>  

This is a Java program that takes in a file name as input and then reads it to count the number of words and their respective frequencies. It then prints out the following information:    
   
- The total number of words in the file.      
- The word(s) with the highest frequency and its frequency. 

Special cases:   

a. If there is more than one word with the same highest frequency, it will print all of them along with the frequency.   
b. If all words have the same frequency, it will indicate this along with the frequency.   
c. If the file is empty, it will indicate this.   
d. If we pass a non-existent file or an empty name, it will indicate this.  
e. If there are more files with the same name in different paths, it will indicate this.  

It looks for the file in the current user's home directory and its subdirectories and in case there are multiple files with the same name but different paths, it issues a warning message and selects the most recent one.

The program uses a regular expression pattern to define the delimiter for parsing the input file. This pattern matches any non-letter character or apostrophe, so it effectively splits the input file into words and discards any non-alphabetic characters or apostrophes. By doing so, it ensures that only valid words are counted and their frequencies are correctly calculated.
It also includes ANSI color codes for better visual presentation:  

<img width="1363" alt="Screenshot 2023-04-03 at 12 23 25" src="https://user-images.githubusercontent.com/118285718/229485019-e809eed0-c50d-4c26-a0f3-dc9ab1047dee.png">
<img width="1364" alt="Screenshot 2023-04-03 at 12 27 18" src="https://user-images.githubusercontent.com/118285718/229485065-5f4ad5ca-b6e3-4e85-b941-dea4f161b821.png">
<img width="1360" alt="Screenshot 2023-04-03 at 12 30 02" src="https://user-images.githubusercontent.com/118285718/229485083-b356be68-267c-49ed-b1cf-5ac7bf11c5c0.png">
<img width="1398" alt="Screenshot 2023-04-03 at 13 18 51" src="https://user-images.githubusercontent.com/118285718/229495019-9bb0802f-f2f3-4d2b-a804-932177d091f2.png">




When attempting to pass a non-existent file and an empty name respectively, we get:  

<img width="1398" alt="Screenshot 2023-04-03 at 12 38 01" src="https://user-images.githubusercontent.com/118285718/229486464-a2956a2d-743f-4067-9b8b-f1cdbbf5610c.png">
<img width="1397" alt="Screenshot 2023-04-03 at 12 40 07" src="https://user-images.githubusercontent.com/118285718/229486857-539fa54e-a063-4ccf-b54e-03e8cad32f8f.png">




