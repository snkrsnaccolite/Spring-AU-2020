package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerce {
    private static List<Product> inventory = new ArrayList<Product>();

    public static void main(String[] args) {
        // Store inventory
        Product workstation = new Product("Workstation", 5000.0, 25);
        Product laptop = new Product("Laptop", 1500.0, 100);

        inventory.add(workstation);
        inventory.add(laptop);


        System.out.println("\nWelcome to our Store!");

        Scanner reader = new Scanner(System.in);

        // Initialize empty cart
        Cart cart = new Cart();

        Boolean exit = false;
        while (exit == false) {
            System.out.println("1.\tAdd Product to Cart");
            System.out.println("2.\tRemove Product from Cart");
            System.out.println("3.\tView Cart");
            System.out.println("4.\tPlace Order");
            System.out.println("5.\tCancel Order");

            System.out.println("\nSelect > ");
            Integer choice = reader.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Our Inventory");
                    System.out.println("Select the product to add.");
                    viewInventory();

                    System.out.println("\nSelect > ");
                    choice = reader.nextInt();

                    if (choice < 1 && choice > inventory.size()) {
                        System.out.println("Invalid Product");
                        break;
                    }

                    cart.addProduct(inventory.get(choice - 1));
                    System.out.println("Added " + inventory.get(choice - 1).name + " to your Cart");
                    break;

                case 2:
                    System.out.println("Select the cart item to remove.");
                    viewProducts(cart.getAll());

                    System.out.println("\nSelect > ");
                    choice = reader.nextInt();

                    if (choice < 1 && choice > inventory.size()) {
                        System.out.println("Invalid Product");
                        break;
                    }

                    Product removedProduct = cart.removeProduct(choice - 1);
                    System.out.println("Removed " + removedProduct.name + " from your cart.");
                    break;

                case 3:
                    System.out.println("Your Cart");
                    viewProducts(cart.getAll());
                    break;

                case 4:
                    System.out.println("Please enter your username: ");
                    String username = reader.nextLine();

                    Order order = new Order(username, cart);

                    System.out.println("Order #" + order.id);
                    System.out.println("Total Amount: " + order.getAmount());

                    System.out.println("\nOrder placed.");

                    cart.clear();

                    break;

                case 5:
                    System.out.println("Cancelling Order and Exiting...");
                    exit = true;
                    break;

                default:
                    break;
            }
        }
    }

    public static void viewInventory() {
        Integer i = 1;
        for (Product p : inventory) {
            System.out.println(i + ". " + p.name);
            i += 1;
        }
    }

    public static void viewProducts(List<Product> products) {
        Integer i = 1;
        for (Product p : products) {
            System.out.println(i + ". " + p.name);
            i += 1;
        }
    }
}
