package app;
import control.InventoryManager;
import boundary.InventoryUI;
import java.util.Scanner;

public class RestaurantManagementApplication {
	// All managers
	private InventoryManager inventoryManager;
/*	private OrderManager orderManager;
	private BillingManager billingManager;
	private ReservationManager reservationManager;*/

	// All UI components
	private InventoryUI inventoryUI;
/*	private InventoryUI inventoryUI;
	private OrderUI orderUI;
	private BillingUI billingUI;
	private ReservationUI reservationUI;*/

	private Scanner scanner;

	public RestaurantManagementApplication() {
		//Initialize managers
		this.inventoryManager = new InventoryManager();

		//Initialize UIs
		this.inventoryUI = new InventoryUI();

		//Load initial data
	}

	public void start() {
		int choice = 5;
		do {
			displayMainMenu();
			choice = getMenuChoice();

			switch (choice) {
				case 1 :
					inventoryUI.runInventoryUI();
					break;
				case 2 :
					break;
				case 3 :
					break;
				case 4 :
					break;
				case 5 :
					System.out.println("Exiting system.");
					break;
				default :
					System.out.println("Invalid choice.");
			}
		} while (choice != 5);
	}

	public int getMenuChoice() {
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	private void displayMainMenu() {
		System.out.println("\n========================================");
		System.out.println("    Restaurant Management System");
		System.out.println("========================================");
		System.out.println("1. Inventory Management");
		System.out.println("2. Order Processing");
		System.out.println("3. Billing Management");
		System.out.println("4. Reservation Management");
		System.out.println("5. Exit System");
		System.out.println("========================================");
		System.out.print("Enter your choice (1-5): ");
	}

	public static void main(String[] args) {
		RestaurantManagementApplication app = new RestaurantManagementApplication();
		app.start();
	}
}
