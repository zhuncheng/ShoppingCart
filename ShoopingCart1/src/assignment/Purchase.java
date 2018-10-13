package assignment;

public class Purchase {
	private String orderNo;
	private Product product;
	private double qty;
	private double discount;
	
	public Purchase(String orderNo, Product product, double qty, double discount) {
		this.orderNo = orderNo;
		this.product = product;
		this.qty = qty;
		this.discount = discount;
	}
	
//	public Purchase() {
//		// TODO Auto-generated constructor stub
//	}

	//New
	public String getOrderNo() {
		return orderNo;
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public double getQty() {
		return qty;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getProductPrice() {
		return product.getPrice();
	}
	
	public double getPrice() {
		return product.getPrice() * qty - discount * (product.getPrice() * qty);
	}
	
	public String toString() {
		return orderNo + "\t" + product.getName() + "\t\t" + qty + "\t" + product.getPrice() + "\t\t" + discount + "\t" + getPrice();
	}
	
//	public void addProduct(String id, String name, String description, double price, double  qty) {
//		
//	}
}
