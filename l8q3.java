import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class l8q3 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt"; // Input file with potential duplicates
        String outputFilePath = "output.txt"; // Output file to store unique lines

        Set<String> uniqueLines = new HashSet<>(); // Set to store unique lines

        // Read from the input file and collect unique lines
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                uniqueLines.add(line); // Add line to the set (duplicates are ignored)
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return; // Exit if there's an error reading the file
        }

        // Write unique lines to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String uniqueLine : uniqueLines) {
                writer.write(uniqueLine);
                writer.newLine(); // Write each unique line followed by a newline
            }
            System.out.println("Duplicates removed. Unique lines written to " + outputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
