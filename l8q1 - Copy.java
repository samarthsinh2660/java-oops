import java.io.*;
public class l8q1 {
    public static void main(String[] args){
        String filePath = "1.txt";
        int senc =0;
        int charc = 0; 
        int wordc = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine())!= null){
                charc = line.length() + 1;
                // Counting words using space as a delimiter
            String[] words = line.split("\\s+");
            wordc += words.length;

            // Counting sentences using common sentence-ending punctuation
            String[] sentences = line.split("[.!?]+");
            senc += sentences.length;
            }
            System.out.println("Number of sentences: " + senc);
            System.out.println("Number of words: " + wordc);
            System.out.println("Number of characters: " + charc);
            
        }
        catch(IOException e ){
            System.out.println("cant read the file");
        }
    }
}
