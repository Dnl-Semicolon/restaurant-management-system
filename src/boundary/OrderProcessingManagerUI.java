package boundary;

import control.OrderProcessingManager;
import java.util.Scanner;

public class OrderProcessingManagerUI {

	private OrderProcessingManager orderProcessingManager;

	private Scanner scanner;

	public OrderProcessingManagerUI(OrderProcessingManager orderProcessingManager) {
		this.orderProcessingManager = orderProcessingManager;
		this.scanner = new Scanner(System.in);
	}
}
