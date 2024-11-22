package control;
import java.io.*;
import adt.ListInterface;
import adt.ArrayList;
import entity.Ingredient;
import java.util.Scanner;
public class InventoryManager {
    private ListInterface<Ingredient> inventory = new ArrayList<>();

    public void runInventoryManagement() {
        int choice = 0;
        do {
            choice = getMenuChoice();
            switch (choice) {
                case 0 :
                    System.out.println("\nExiting System");
                    break;
                case 1 :
                    addNewInventory();
                    displayInventory();
                    break;
                case 2 :
                    displayInventory();
                    break;
                default:
                    System.out.println("\nInvalid Choice");
            }
        } while (choice != 0);
    }

    public void addNewInventory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Inventory Item Name: ");
        String tempName = scanner.nextLine();
        System.out.println("Enter Initial Quantity: ");
        int tempQuantity = scanner.nextInt();
        scanner.nextLine();
        Ingredient newItem = new Ingredient(tempName, tempQuantity);
        inventory.add(newItem);
        save(inventory);
    }

    public void displayInventory() {
        System.out.println(inventory);
    }

    public int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- INVENTORY MANAGEMENT ---");
        System.out.println("MAIN MENU");
        System.out.println("1. Add new inventory item");
        System.out.println("2. List all inventory");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public static void main(String[] args) {
        InventoryManager inventoryManagement = new InventoryManager();
        inventoryManagement.inventory = retrieve();
        inventoryManagement.runInventoryManagement();
    }

    public static void save(ListInterface<Ingredient> inventory) {
        File file = new File("inventory.dat");
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(inventory);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file");
        }
    }

    public static ListInterface<Ingredient> retrieve() {
        File file = new File("inventory.dat");
        ListInterface<Ingredient> inventory = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            inventory = (ArrayList<Ingredient>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return inventory;
        }
    }

}
