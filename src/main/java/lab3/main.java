package lab3;

import lab3.entities.ProductEntity;
import lab3.repositories.InMemoryProductRepository;
import lab3.repositories.MySQLProductRepository;
import lab3.repositories.Repository;
import lab3.services.ProductService;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the repository to use:");
        System.out.println("1. In-Memory (temporary, resets on restart)");
        System.out.println("2. MySQL (persistent between sessions)");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine();
        Repository<ProductEntity> repository = null;

        switch (choice) {
            case "1":
                repository = new InMemoryProductRepository();
                System.out.println("Using In-Memory repository.");
                break;
            case "2":
                try {
                    repository = new MySQLProductRepository();
                    System.out.println("Using MySQL repository.");
                } catch (Exception e) {
                    System.out.println("Error connecting to MySQL database: " + e.getMessage());
                    System.out.println("Please ensure the database is running and configured correctly in persistence.xml.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice. Exiting application.");
                return;
        }

        try {
            ProductService productService = new ProductService(repository);

            App app = new App(System.in, System.out, productService);

            if (repository instanceof InMemoryProductRepository) {
                app.populate();
            }

            app.run();

        } finally {
            if (repository != null) {
                repository.close();
                System.out.println("\nRepository resources have been released. Application terminated.");
            }
        }
    }
}