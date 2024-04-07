// Assume that a file sentiment.txt contains comments of a new car launched. Write a Java program to read the comments from a file, analyze each comment, and classify them as "positive," "negative," or "neutral" based on specific keywords and phrases. Use Java string methods to perform the sentiment analysis and produce an output with counts for each sentiment category. Use the phrases as given below. Create the sentiments of your choice to implement the same

// Positive keywords = {"good", "excellent", "awesome"}

// Negative keywords = {"bad", "poor", "terrible"}

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Sentiment {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        File f1=new File("sen.txt");
        if(!f1.exists())
        System.out.println("File Path Error");
        Scanner reader=new Scanner(f1);
        HashSet<String> good=new HashSet<>();
        good.add("good");
        good.add("excellent");
        good.add("awesome");

        HashSet<String> bad= new HashSet<>();
        bad.add("bad");
        bad.add("poor");
        bad.add("terrible");
    
        String str=reader.nextLine();
        String arr[]=str.split(",\\s+");
        System.out.println(Arrays.toString(arr));



    }
}
