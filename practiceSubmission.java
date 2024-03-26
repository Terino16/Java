import java.util.Scanner;
import java.util.TreeMap;

class Transaction {
    private int age;
    private String name;
    private String time;

    public Transaction(int age, String name, String time) {
        this.age = age;
        this.name = name;
        this.time = time;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Time: " + time;
    }
}

public class practiceSubmission {
    private static final int HOURLY_LIMIT = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.8;
    private static int visitorCount = 0;
    private static TreeMap<String, Transaction> transactionHistory = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Visitor");
            System.out.println("2. Display Visitor History");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter time (HH:MM:SS): ");
                    String time = scanner.nextLine();

                    visitorCount++;
                    if ((double) visitorCount / HOURLY_LIMIT >= LOAD_FACTOR_THRESHOLD) {
                        System.out.println("Loading factor exceeded 80% of hourly limit. Creating new TreeMap for next hour...");
                        transactionHistory = new TreeMap<>();
                        visitorCount = 0;
                    }

                    Transaction transaction = new Transaction(age, name, time);
                    transactionHistory.put(name + " " + time, transaction);
                    System.out.println("Visitor added successfully!");
                    break;

                case 2:
                    System.out.println("\nVisitor History:");
                    transactionHistory.values().forEach(System.out::println);
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                    break;
            }
        }

        System.out.println("\nThank you for using XYZ Art Gallery System!");
        scanner.close();
    }
}
