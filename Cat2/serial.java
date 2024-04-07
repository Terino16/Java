import java.io.*;

class Employee {
    private String name = "Unknown";
    private String gender = "Unknown";
    private double height = Double.NaN;

    public Employee(String name, String gender, double height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender + ", Height: " + this.height;
    }

}

public class serial {
    public static void main(String args[]) {
        Employee e1 = new Employee("SAM1", "MALE", 4.7);
        Employee e2 = new Employee("SAM2", "MALE", 4.5);
        Employee e3 = new Employee("SAM3", "FEMALE", 4.3);

        File fileobject = new File("Employee.txt");

        try (FileWriter writer = new FileWriter(fileobject)) {
            writer.write(e1.toString());
            writer.write(e2.toString());
            writer.write(e3.toString());

            System.out.println(e1);
            System.out.println(e2);
            System.out.println(e3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
