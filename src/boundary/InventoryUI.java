package boundary;
import java.util.Scanner;
public class InventoryUI {
	private Scanner scanner;

	public InventoryUI() {
		this.scanner = new Scanner(System.in);
	}

	public void runInventoryUI() {
		int choice = 4;
		do {
			displayMainMenu();
			choice = getMenuChoice();

			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
			}
		} while (choice != 4);
	}

	public void displayMainMenu() {
		System.out.println("--- INVENTORY MANAGEMENT ---");
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
