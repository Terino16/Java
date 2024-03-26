import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void updateQuantity(String itemName, int newQuantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Item not found in cart!");
    }

    public double calculateTotalCost() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

   
    public void displayCart() {
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println("Name: " + item.getName() + ", Price: $" + item.getPrice() + ", Quantity: " + item.getQuantity());
        }
    }
}

public class asd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("1. Add Item\n2. Remove Item\n3. Update Quantity\n4. Display Cart\n5. Display Total Cost\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    cart.addItem(new Item(name, price, quantity));
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemNameToRemove = scanner.nextLine();
                    cart.removeItem(itemNameToRemove);
                    break;
                case 3:
                    System.out.print("Enter item name to update quantity: ");
                    String itemNameToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); 
                    cart.updateQuantity(itemNameToUpdate, newQuantity);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    System.out.println("Total Cost: $" + cart.calculateTotalCost());
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}