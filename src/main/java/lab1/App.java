package lab1;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            printMainMenu();
            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1 -> addItemsMenu();
                case 2 -> System.out.println("\n... Edit Items functionality will be implemented here ...\n");
                case 3 -> System.out.println("\n... Delete Items functionality will be implemented here ...\n");
                case 4 -> System.out.println("\n... Sell Item(s) functionality will be implemented here ...\n");
                case 5 -> System.out.println("\n... List Items functionality will be implemented here ...\n");
                case 99 -> {
                    System.out.println("\nExiting application...");
                    break;
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("***********************");
        System.out.println(" 1. Add Items");
        System.out.println(" 2. Edit Items");
        System.out.println(" 3. Delete Items");
        System.out.println(" 4. Sell item(s)");
        System.out.println(" 5. List items");
        System.out.println("99. Quit");
        System.out.println("***********************");
    }

    private void addItemsMenu() {
        boolean inAddMenu = true;

        while (inAddMenu) {
            System.out.println("\nAdd an item");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add DiscMag");
            System.out.println("4. Add Ticket");
            System.out.println("99. Exit");
            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1 -> System.out.println("\n... Add Book functionality will be implemented here ...\n");
                case 2 -> System.out.println("\n... Add Magazine functionality will be implemented here ...\n");
                case 3 -> System.out.println("\n... Add DiscMag functionality will be implemented here ...\n");
                case 4 -> System.out.println("\n... Add Ticket functionality will be implemented here ...\n");
                case 99 -> {
                    System.out.println("\nReturning to main menu...\n");
                    inAddMenu = false;
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
