package ecommerce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ECommerce {
    private static List<Product> inventory = new ArrayList<Product>();

    public static void main(String[] args) {
        // Store inventory
        Product workstation = new Product("Workstation", 5000.0);
        Product laptop = new Product("Laptop", 1500.0);

        inventory.add(workstation);
        inventory.add(laptop);


        System.out.println("\nWelcome to our Store!");

        Scanner reader = new Scanner(System.in);


        System.out.println("Please enter your username: ");
        String username = reader.nextLine();

        Order order = new Order(username);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Boolean exit = false;
        while (exit == false) {
            System.out.println("\n");
            System.out.println("1.\tAdd Product");
            System.out.println("2.\tView Cart");
            System.out.println("3.\tPlace Order");
            System.out.println("4.\tGet Order");
            System.out.println("99.\tExit");

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

                    Product product = new Product(inventory.get(choice - 1).getName(), inventory.get(choice - 1).getPrice());
                    order.addProduct(product);

                    session.save(product);

                    System.out.println("Added " + product.getName() + " to your Cart");
                    break;

                case 2:
                    System.out.println("Your Cart");
                    viewProducts(order.getProducts());
                    break;

                case 3:
                    System.out.println("Order #" + order.getId());
                    System.out.println("Total Amount: " + order.getAmount());

                    System.out.println("\nOrder placed.");

                    session.save(order);
                    break;

                case 4:
                    System.out.println("Enter your Order ID:");
                    choice = reader.nextInt();

                    Order fetchedOrder = (Order) session.get(Order.class, choice);

                    System.out.println("Order #" + fetchedOrder.getId());
                    System.out.println("Total Amount: " + fetchedOrder.getAmount());
                    break;

                case 99:
                    System.out.println("Exiting...");
                    exit = true;
                    break;

                default:
                    break;
            }
        }

        session.getTransaction().commit();
    }

    public static void viewInventory() {
        Integer i = 1;
        for (Product p : inventory) {
            System.out.println(i + ". " + p.getName() + " - $" + p.getPrice());
            i += 1;
        }
    }

    public static void viewProducts(Collection<Product> products) {
        Integer i = 1;
        for (Product p : products) {
            System.out.println(i + ". " + p.getName() + " - $" + p.getPrice());
            i += 1;
        }
    }
}
