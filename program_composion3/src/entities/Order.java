package entities;

import java.util.Date;
import entities.enums.OrderStatus;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	List<OrderItem> items = new ArrayList<OrderItem>();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss");
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {	
		double sum = 0.0;
		
		for(OrderItem item: items) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment));
		sb.append("\n");
		sb.append("Order status: ");
		sb.append(status.toString());
		sb.append("\n");
		sb.append("Client: \n");
		sb.append(client.toString());
		sb.append("Order items: \n");
		
		for(OrderItem item: items) {
			sb.append(item.toString() + "\n");
		}
		
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		// convert String builder -> to string()
		return sb.toString();
		
		
	}
	
	

}
