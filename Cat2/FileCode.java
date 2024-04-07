// Write a program that prompts the user to enter the name of the bowler in the command line interface. Display the wickets, econ and balls_per_wicket from the wickets.txt file. Display the Player Not found Info if the player search name is not available.




// Assume that a file sentiment.txt contains comments of a new car launched. Write a Java program to read the comments from a file, analyze each comment, and classify them as "positive," "negative," or "neutral" based on specific keywords and phrases. Use Java string methods to perform the sentiment analysis and produce an output with counts for each sentiment category. Use the phrases as given below. Create the sentiments of your choice to implement the same

// Positive keywords = {"good", "excellent", "awesome"}

// Negative keywords = {"bad", "poor", "terrible"}

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileCode {

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        File f1=new File("hello.txt");
        System.out.println("Enter first name");
        Scanner input=new Scanner(f1);
        String fname=sc.nextLine();
        System.out.println("Enter Second name");
        String sname=sc.nextLine();
        ArrayList<String []> arr=new ArrayList<>();
        while(input.hasNextLine())
        {
            String Line=input.nextLine();
            String ans[] = Line.split("\\s+");
            arr.add(ans);
        }
        for(String str[]:arr)
        {
            if(fname.equals(str[0]) && sname.equals(str[1]))
            {
                System.out.println(Arrays.toString(str));
                break;
            }
           
        }
    }
}