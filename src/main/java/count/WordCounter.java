package main.java.count;

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

        String filePath = args[0];
        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            System.err.printf(ANSI_RED + "\n[ERROR] The file \"%s\" was not found or is not a valid file.\n" + ANSI_RESET, filePath);
            return;
        }

        try (Scanner scanner = new Scanner(inputFile).useDelimiter("[^\\p{L}']+")) {
            Map<String, Integer> wordFreq = countWordsAndGetFrequencies(scanner);
            int numWords = wordFreq.values().stream().mapToInt(Integer::intValue).sum();
            List<String> highestFrequencyWords = getHighestFrequencyWords(wordFreq);
            int maxFrequency = 0;
            if (!highestFrequencyWords.isEmpty()) { maxFrequency = wordFreq.get(highestFrequencyWords.get(0));}
            printResults(inputFile.getName(), numWords, wordFreq, maxFrequency, highestFrequencyWords);

        } catch (FileNotFoundException e) {
            System.err.printf(ANSI_RED + "[ERROR] The file \"%s\" was not found or is not a valid file.\n" + ANSI_RESET, filePath);
            return;
        }
    }

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
}

