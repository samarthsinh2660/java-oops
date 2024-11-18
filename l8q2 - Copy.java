import java.io.*;

public class l8q2 {
    public static void main(String[] args) {
        // Declare file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Read from input file, convert to uppercase, and write to output file
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            System.out.println("\nReading content of the input file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print each line of the input file

                // Convert to uppercase and write to output file
                String upperc = line.toUpperCase();
                writer.write(upperc);
                writer.newLine();
            }

            // Close writer to ensure content is written to output file
            writer.flush();

            // Print content of the output file
            System.out.println("\nContent of the output file (in uppercase):");
            try (BufferedReader oreader = new BufferedReader(new FileReader(outputFilePath))) {
                while ((line = oreader.readLine()) != null) {
                    System.out.println(line);  // Print each line of the output file
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
