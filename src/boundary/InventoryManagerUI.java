package boundary;

//Imports
import control.InventoryManager;
import java.util.Scanner;

public class InventoryManagerUI {

	private InventoryManager inventoryManager;

	private Scanner scanner;

	public InventoryManagerUI(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
		this.scanner = new Scanner(System.in);
	}

	public boolean runInventoryManagerUI() {
		boolean exit = false;
		int choice = 4;
		do {
			displayMainMenu();
			choice = getMenuChoice();

			switch (choice) {
				case 1:
					addNewInventoryItem();
					displayInventory(inventoryManager.getAllInventoryItems());
					break;
				case 2:
					displayInventory(inventoryManager.getAllInventoryItems());
					break;
				case 3:
					break;
				case 4:
					exit = true;
					break;
				default:
			}
		} while (choice != 4 && choice != 3);

		return exit;
	}

	public void addNewInventoryItem() {
		System.out.print("Enter new inventory item name: ");
		String tempName = scanner.nextLine();
		System.out.print("Enter initial quantity: ");
		int tempQuantity = scanner.nextInt();
		scanner.nextLine();

		inventoryManager.addNewInventoryItem(tempName, tempQuantity);
		System.out.println("Added New Inventory Item Successfully");
	}

	public void displayInventory(String outputStr) {
		System.out.println("\nList of Inventory:\n" + outputStr);
	}

	public void displayMainMenu() {
		System.out.println("\n--- INVENTORY MANAGEMENT ---");
		System.out.println("SUBSYSTEM MENU");
		System.out.println("1. Add Inventory Item");
		System.out.println("2. Display Inventory");
		System.out.println("3. Return to Main Menu");
		System.out.println("4. Exit System");
		System.out.println("----------------------------");
		System.out.print("Enter your choice (1-4): ");
	}

	public int getMenuChoice() {
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}
}
