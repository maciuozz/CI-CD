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

<img width="1376" alt="Screenshot 2023-04-02 at 14 20 49" src="https://user-images.githubusercontent.com/118285718/229352854-28d48a72-70a5-4475-8c72-f0cfc41814b6.png">
<img width="1375" alt="Screenshot 2023-04-02 at 14 16 54" src="https://user-images.githubusercontent.com/118285718/229352885-000fdf8f-eab2-4739-b2f1-6416634d59d6.png">
<img width="1374" alt="Screenshot 2023-04-02 at 14 25 25" src="https://user-images.githubusercontent.com/118285718/229352895-073a48cd-3cc1-4d9d-a0b2-646d951dfbaa.png">

When attempting to pass a non-existent or empty name to the application, we get:  

<img width="1375" alt="Screenshot 2023-04-02 at 14 32 49" src="https://user-images.githubusercontent.com/118285718/229352999-a02c26bd-c629-4a60-9850-40cbc015afb2.png">

