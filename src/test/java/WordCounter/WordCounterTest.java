import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintStream;
import java.nio.file.Paths;
import main.java.count.WordCounter;
import static org.junit.Assert.*;

public class WordCounterTest {

    @Test
    public void testEmptyFile() {
        String fileName = "empty_file.txt";
        File root = new File("/"); // Start the search from the root directory.
        File filePath = searchForFile(root, fileName);
        if (filePath != null) {
            String expectedOutput = "The number of words in the file \"" + fileName + "\" is: 0.The file is empty.";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //Set the standard output stream to the outputStream variable, which means any output that would normally go to the console 
            //will now be captured by the outputStream.
            System.setOut(new PrintStream(outputStream));
      
            //Call the main method, convert the path to the file from a File object to a String and pass it as an argument.
            //The output of the main method will be automatically captured by outputStream.
            WordCounter.main(new String[] {filePath.getAbsolutePath()});

            String actualOutput = removeAnsiEscapeCodes(outputStream.toString());

            //Verify that the actualOutput variable is equal to the expectedOutput variable using the is() matcher from the Hamcrest library.
            assertThat(actualOutput, is(expectedOutput));
        } else {
            System.out.println("File not found.");
        }
    }

    @Test
    public void testNoFileNameProvided() {
        //Redirect standard error stream to a string builder.
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        //Call the main method with no arguments.
        WordCounter.main(new String[]{});

        String actualErrorMessage = removeAnsiEscapeCodes(errContent.toString());
        
        //Assert that the error message is printed to the standard error stream.
        assertEquals("[ERROR] Please, provide a valid file name.", actualErrorMessage);
    }

    @Test
    public void testInvalidFileName() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        //Call the main method with an invalid file name.
        WordCounter.main(new String[]{"invalid_file.txt"});

        String actualErrorMessage = removeAnsiEscapeCodes(errContent.toString());

        assertEquals("[ERROR] The file \"invalid_file.txt\" was not found or is not a valid file.", actualErrorMessage);
    }

    @Test
    public void testMultipleWordsWithSameFrequency() {
        String fileName = "same-highest-frequency.txt";
        File root = new File("/");
        File filePath = searchForFile(root, fileName);
        if (filePath != null) {
            String expectedOutput = "The number of words in the file \"" + fileName + "\" is: 16."
                            + "5 words have the same highest frequency of 2: \"meant\", \"be\", \"are\", \"to\", \"we\".";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
      
            WordCounter.main(new String[] {filePath.getAbsolutePath()});

            String actualOutput = removeAnsiEscapeCodes(outputStream.toString());

            assertThat(actualOutput, is(expectedOutput));
        } else {
            System.out.println("File not found.");
        }
    }

    @Test
    public void testHighestFrequency() {
        String fileName = "most-frequent.txt";
        File root = new File("/"); 
        File filePath = searchForFile(root, fileName);
        if (filePath != null) {
            String expectedOutput = "The number of words in the file \"" + fileName + "\" is: 10."
                            + "The most repeated word is \"beautiful\" with a frequency of 2.";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
      
            WordCounter.main(new String[] {filePath.getAbsolutePath()});

            String actualOutput = removeAnsiEscapeCodes(outputStream.toString());

            assertThat(actualOutput, is(expectedOutput));
        } else {
            System.out.println("File not found.");
        }
    }

    @Test
    public void testOneWord() {
        String fileName = "one-word.txt";
        File root = new File("/"); 
        File filePath = searchForFile(root, fileName);
        if (filePath != null) {
            String expectedOutput = "The number of words in the file \"" + fileName + "\" is: 1."
                            + "The most repeated word is \"paolo\" with a frequency of 1.";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
      
            WordCounter.main(new String[] {filePath.getAbsolutePath()});

            String actualOutput = removeAnsiEscapeCodes(outputStream.toString());

            assertThat(actualOutput, is(expectedOutput));
        } else {
            System.out.println("File not found.");
        }
    }

    @Test
    public void testAllSameFrequency() {
        String fileName = "all-same-frequency.txt";
        File root = new File("/"); 
        File filePath = searchForFile(root, fileName);
        if (filePath != null) {
            String expectedOutput = "The number of words in the file \"" + fileName + "\" is: 8."
                            + "All words have the same frequency of 2.";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
      
            WordCounter.main(new String[] {filePath.getAbsolutePath()});

            String actualOutput = removeAnsiEscapeCodes(outputStream.toString());

            assertThat(actualOutput, is(expectedOutput));
        } else {
            System.out.println("File not found.");
        }
    }

    //The method takes a String argument and returns a new String with ANSI escape codes removed from it.
    private String removeAnsiEscapeCodes(String str) {
        return str.replaceAll("\\u001B\\[[;\\d]*m", "").replaceAll("\\r\\n|\\n|\\r", System.lineSeparator().trim());
    }

    //The method searches for a file with a given name filename in a directory and its subdirectories, starting from the given directory parameter
    //that is root (whole filesystem).
    public static File searchForFile(File directory, String filename) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    File result = searchForFile(file, filename);
                    if (result != null) {
                        return result;
                    }
                } else if (file.getName().equals(filename)) {
                    return file;
                }
            }
        }
        return null;
    }
}
