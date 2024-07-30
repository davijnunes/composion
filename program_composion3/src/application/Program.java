package application;

import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import entities.Product;
import entities.OrderItem;
import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YY): ");
		Date birthDate = sdf.parse(sc.next());
		
	
		Client client = new Client(name,email,birthDate);
		
		System.out.println();
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(),status,client);
		
		System.out.println();
		
		System.out.print("How many items to this order? ");
		int quantityOfItem = sc.nextInt();
		
		for(int i = 0; i < quantityOfItem; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity  = sc.nextInt();
			
			Product product = new Product(productName,productPrice);
			OrderItem item  = new OrderItem(quantity,productPrice, product);
			order.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("Order summary: ");
		System.out.println(order.toString());
		
		
		sc.close();
		
		
		
		
	}
}
