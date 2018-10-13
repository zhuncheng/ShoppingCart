package assignment;

public class Customer {
	private String customerID;
	private String customerName;
	private String email;
	private String shippingAddress;
	private Cart shoppingCart;
	private String billingAddress;
	
	public Customer(String customerID, String customerName, String email, String shippingAddress, String billingAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
	
	public void placeOrder(Cart shoppingCart) {
		
	}
	
	public void cancelOrder() {
		
	}
	
	public String checkOut() {
		
		return "";
	}
	
	public String toString() {
		return "[ ID : " + customerID + " ]" + "\n[ Name : " + customerName + " ]"
				+ "\n[ Email : " + email + " ]\n" + "[ Ship to : " + shippingAddress + " ]"
				+ "\n[ Bill to : " + billingAddress + " ]";
		
	}
	
	
	
	
	
}
