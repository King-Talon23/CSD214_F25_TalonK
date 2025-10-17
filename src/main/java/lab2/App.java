package lab2;

import lab2.pojos.*;

import java.util.*;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<SaleableItem> inventory = new ArrayList<>();

    public void run() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1 -> addItemsMenu();
                case 2 -> deleteItem();
                case 3 -> editItem();
                case 4 -> sellItem();
                case 5 -> listItems();
                case 99 -> {
                    System.out.println("\nExiting application...");
                    running = false;
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("***********************");
        System.out.println(" 1. Add Items");
        System.out.println(" 2. Delete Items");
        System.out.println(" 3. Edit Items");
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
                case 1 -> {
                    Book b = new Book();
                    b.initialize();
                    inventory.add(b);
                    System.out.println("Book added!");
                }
                case 2 -> {
                    Magazine m = new Magazine();
                    m.initialize();
                    inventory.add(m);
                    System.out.println("Magazine added!");
                }
                case 3 -> {
                    DiscMag d = new DiscMag();
                    d.initialize();
                    inventory.add(d);
                    System.out.println("DiscMag added!");
                }
                case 4 -> {
                    Ticket t = new Ticket();
                    inventory.add(t);
                    System.out.println("Ticket added!");
                }
                case 99 -> {
                    System.out.println("\nReturning to main menu...\n");
                    inAddMenu = false;
                }
                default -> System.out.println("\nInvalid choice. Please try again\n");
            }
        }
    }

    private void editItem() {
        if (inventory.isEmpty()) {
            System.out.println("\nNo items available to edit\n");
            return;
        }

        listItems();
        int index = getIntInput("Enter item number to edit: ") - 1;
        if (index < 0 || index >= inventory.size()) {
            System.out.println("\nInvalid item number\n");
            return;
        }

        SaleableItem item = inventory.get(index);
        if (item instanceof Editable editable) {
            editable.edit();
            System.out.println("\nItem edited successfully!\n");
        } else {
            System.out.println("\nThis item type cannot be edited\n");
        }
    }

    private void deleteItem() {
        if (inventory.isEmpty()) {
            System.out.println("\nNo items to delete\n");
            return;
        }

        listItems();
        int index = getIntInput("Enter item number to delete: ") - 1;
        if (index < 0 || index >= inventory.size()) {
            System.out.println("\nInvalid item number\n");
            return;
        }

        inventory.remove(index);
        System.out.println("\nItem deleted successfully!\n");
    }

    private void sellItem() {
        if (inventory.isEmpty()) {
            System.out.println("\nyou have nothing for sale\n");
            return;
        }

        listItems();
        int index = getIntInput("Enter item number to sell: ") - 1;
        if (index < 0 || index >= inventory.size()) {
            System.out.println("\nInvalid item number.\n");
            return;
        }

        SaleableItem item = inventory.get(index);
        item.sellItem();
        inventory.remove(index);
    }

    private void listItems() {
        if (inventory.isEmpty()) {
            System.out.println("\nNo items to list\n");
            return;
        }

        System.out.println("\n---- Current Items ----");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, inventory.get(i));
        }
        System.out.println("-----------------------\n");
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
