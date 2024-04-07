import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class unique {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            // FileReader to read input from file
            FileReader fileReader = new FileReader(inputFile);

            // FileWriter to write output to file
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // HashSet to store unique words
            HashSet<String> uniqueWords = new HashSet<>();
            Scanner reader=new Scanner(fileReader);
            String arr[]=reader.nextLine().split(",");
            for(String a:arr)
            uniqueWords.add(a);

            for(String a:uniqueWords)
            printWriter.println(a+" ");
            

            fileReader.close();
            reader.close();
            printWriter.close();
            System.out.println("Duplicates removed and output written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

