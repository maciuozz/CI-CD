package main.java.count;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    private static final String NUM_WORDS_MSG = "\nThe number of words in the file \"%s\" is: %d.";
    private static final String MOST_FREQ_MSG = "The most repeated word is \"%s\" with a frequency of %d.\n";
    private static final String ALL_SAME_FREQ_MSG = "All words have the same frequency of %d.\n";
    private static final String MULTIPLE_FREQ_MSG = "%d words have the same highest frequency of %d: %s";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_MAGENTA = "\u001B[95m";
    private static final String ANSI_RED = "\u001B[91m";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println(ANSI_RED + "\n[ERROR] Please, provide a valid file name.\n" + ANSI_RESET);
            return;
        }

        String filePath = getAbsolutePathWithCheck(args[0]);
        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            System.err.printf(ANSI_RED + "\n[ERROR] The file \"%s\" was not found or is not a valid file.\n" + ANSI_RESET, filePath);
            return;
        }

        //Create a Scanner object to read the input file and use the delimiter.
        try (Scanner scanner = new Scanner(inputFile).useDelimiter("[^\\p{L}']+")) {
            //Pass the Scanner object to the countWordsAndGetFrequencies method, which returns a Map containing the frequency of each word in the file.
            Map<String, Integer> wordFreq = countWordsAndGetFrequencies(scanner);
            //Calculate the total number of words in the file by summing up the values of the frequencies of each word in the map.
            int numWords = wordFreq.values().stream().mapToInt(Integer::intValue).sum();
            //Pass the map to the getHighestFrequencyWords method, which returns a list of word(s) that have the highest frequency in the file.
            List<String> highestFrequencyWords = getHighestFrequencyWords(wordFreq);
            int maxFrequency = 0;
            //If the list of highest frequency words is not empty, get the frequency of the first word in the list from the wordFreq map, which 
            //represents the highest frequency in the file.
            if (!highestFrequencyWords.isEmpty()) { maxFrequency = wordFreq.get(highestFrequencyWords.get(0));}
            printResults(inputFile.getName(), numWords, wordFreq, maxFrequency, highestFrequencyWords);

          //If the file is not found or cannot be opened, catch the FileNotFoundException and print an error message indicating the issue.
        } catch (FileNotFoundException e) {
            System.err.printf(ANSI_RED + "[ERROR] The file \"%s\" was not found or is not a valid file.\n" + ANSI_RESET, filePath);
            return;
        }
    }

    //The method takes a Scanner object as input and returns a Map that contains the frequency count of each word found in the scanner.
    //In the map the words are all different and converted to lowercase.
    private static Map<String, Integer> countWordsAndGetFrequencies(Scanner scanner) {
        Map<String, Integer> wordFreq = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (!word.isEmpty()) {
                wordFreq.merge(word, 1, Integer::sum);
            }
        }
        return wordFreq;
    }
    
    //The method takes a Map object as input that contains all the different words with their frequencies and returns a List of words
    //that have the highest frequency count.
    private static List<String> getHighestFrequencyWords(Map<String, Integer> wordFreq) {
        List<String> highestFrequencyWords = new ArrayList<>();
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                highestFrequencyWords.clear();
                highestFrequencyWords.add(entry.getKey());
                maxFrequency = frequency;
            } else if (frequency == maxFrequency) {
                highestFrequencyWords.add(entry.getKey());
            }
        }
        return highestFrequencyWords;
    }

    //The method takes as inputs the file name, the number of words in the file, the Map with all the different words and their frequencies, the
    //highest frequency, the list of word(s) with the highest frequency, and uses them to print out the results of the word frequency analysis.
    private static void printResults(String fileName, int numWords, Map<String, Integer> wordFreq, int maxFrequency, List<String> highestFrequencyWords) {
        System.out.printf(ANSI_MAGENTA + NUM_WORDS_MSG + "\n" + ANSI_RESET, fileName, numWords);
        if (wordFreq.isEmpty()) {
            System.out.println(ANSI_MAGENTA + "The file is empty." + ANSI_RESET);
        } else if (highestFrequencyWords.size() == 1) {
            System.out.printf(ANSI_MAGENTA + MOST_FREQ_MSG + "\n" + ANSI_RESET, highestFrequencyWords.get(0), maxFrequency);
        } else if (wordFreq.size() == highestFrequencyWords.size()) {
            System.out.printf(ANSI_MAGENTA + ALL_SAME_FREQ_MSG + "\n" + ANSI_RESET, maxFrequency);
        } else {
            System.out.printf(ANSI_MAGENTA + MULTIPLE_FREQ_MSG + "\n" + ANSI_RESET, highestFrequencyWords.size(), maxFrequency, "\"" + String.join("\", \"", highestFrequencyWords) + "\"" + "." + "\n");
        }
    }
    
    public static String getAbsolutePathWithCheck(String fileName) {
        String absolutePath = null;
        try {
            Process process = Runtime.getRuntime().exec(new String[] { "sudo", "find", "/", "-name", fileName, "-type", "f", "-print0" });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            List<String> filePaths = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                filePaths.add(line);
            }
            int count = filePaths.size();
            if (count == 0) {
                return null; // file not found
            } else if (count > 1) {
                System.out.println("\n\033[1;33m[WARNING]\033[0m Found " + count + " files with the same name:");
                for (String filePath : filePaths) {
                    System.out.println("- " + filePath);
                }
                File[] files = new File[filePaths.size()];
                for (int i = 0; i < filePaths.size(); i++) {
                    files[i] = new File(filePaths.get(i));
                }
                Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
                absolutePath = files[0].getAbsolutePath();
                System.out.println("\nUsing the most recent file: " + absolutePath);
            } else {
                absolutePath = filePaths.get(0);
            }
        } catch (IOException e) {
              e.printStackTrace();
        }
        return absolutePath;
    }
}

