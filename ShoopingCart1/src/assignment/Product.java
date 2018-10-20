package assignment;

public class Product {
	private String id;
	private String name;
	private String description;
	private double price;
	private double qtyInStock;
	
	public Product(String id, String name, String description, double qty, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.qtyInStock = qty;
		this.price = price;
	}
	
	//method to check qty of products in stock
	public boolean isValidStock(double qty) {
		if(qtyInStock > qty) return true;
		return false;
	}
	
	public boolean isDuplicatedProductID(String id) {
		if(this.id.equalsIgnoreCase(id)) {
			return true;
		}
		return false;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getQtyInStock()
	{
		return qtyInStock;
	}
	
	public String getDescription() {
		return description;
	}
	public void setQtyInStock(double qtyInStock) {
		this.qtyInStock = qtyInStock;
	}
	
	public String toString() {
		return id + "\t" + name + "\t\t" + qtyInStock + "\t" + price + "\t" + description;
	}
	
	public void decreaseStock(double qty) {
		this.qtyInStock = 	qtyInStock - qty;
	}
	
	
}
