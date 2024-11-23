package app;

//Imports
import control.InventoryManager;
import boundary.InventoryManagerUI;
import control.OrderProcessingManager;
import boundary.OrderProcessingManagerUI;
import control.BillingManager;
import boundary.BillingManagerUI;
import control.ReservationManager;
import boundary.ReservationManagerUI;
import java.util.Scanner;

public class RestaurantManagementApplication {

	//All managers
	private InventoryManager inventoryManager;
	private OrderProcessingManager orderProcessingManager;
	private BillingManager billingManager;
	private ReservationManager reservationManager;

	//All UI components
	private InventoryManagerUI inventoryManagerUI;
	private OrderProcessingManagerUI orderProcessingManagerUI;
	private BillingManagerUI billingManagerUI;
	private ReservationManagerUI reservationManagerUI;

	//Scanner
	private Scanner scanner;

	//Constructor
	public RestaurantManagementApplication() {

		//Initialize managers
		this.inventoryManager = new InventoryManager();
		this.orderProcessingManager = new OrderProcessingManager(inventoryManager);
		this.billingManager = new BillingManager();
		this.reservationManager = new ReservationManager();

		//Initialize UIs
		this.inventoryManagerUI = new InventoryManagerUI(inventoryManager);
		this.orderProcessingManagerUI = new OrderProcessingManagerUI(orderProcessingManager);
		this.billingManagerUI = new BillingManagerUI(billingManager);
		this.reservationManagerUI = new ReservationManagerUI(reservationManager);

		//Load initial data

		//Initialize scanner
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		boolean exit = false;
		int choice = 5;
		do {
			displayMainMenu();
			choice = getMenuChoice();

			switch (choice) {
				case 1 :
					exit = inventoryManagerUI.runInventoryManagerUI();
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
		} while (choice != 5 && !exit);
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
