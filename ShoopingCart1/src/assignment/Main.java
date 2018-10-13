package assignment;

import helper.DrawingTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	//public static DrawingTable drawingTable = new DrawingTable();
	public static Scanner in = new Scanner(System.in);
	public static Cart cart = new Cart();
	public static List<Product> products = new ArrayList<Product>();
	public static List<Customer> customers = new ArrayList<Customer>();
	
	public static void main(String[] args) {	
		String option;
		String choice;
		
		List<Purchase> purchaseItems = new ArrayList<Purchase>();
	
		/*Initialize 3 products  */		 
		products.add(new Product("001","Laptop","Product of Cambodia", 10, 1000));
		products.add(new Product("002","Desktop","Product of Cambodia", 100, 1100));
		products.add(new Product("003","Mouse","Product of Cambodia", 100, 10));
		
		Purchase purchase;
//	
		
		String proCode;
		
		do {
			option = menu();
			switch(option) {
			case "1":
				System.out.print("HEE");
					createNewProduct();
				break;
				
			case "2":
					showProductList();
				break;
				
			case "3":
					System.out.println("-----------------------Let's go shopping products you want---------------------------------");
					again:
						while(true) {
							System.out.println("Enter product code you want to buy : "); proCode = in.nextLine();
							//
							for(Product product : products) {
								if(product.getID().equalsIgnoreCase(proCode)) {
									System.out.println(product.toString());
								}
							}
							
							System.out.println("Enter product qty you want to buy : "); double qty = in.nextDouble();
							for(Product product : products) {
								if(product.getID().equalsIgnoreCase(proCode)) {
									if(product.isValidStock(qty) == false) {
										System.out.println("Not enough stock!!! Product with code " + product.getID() + " has only " + product.getQtyInStock() + " in stock");
										in.nextLine();
									}
									else {
										product.setQtyInStock(product.getQtyInStock() - qty); //reduce product in stock
										System.out.println("Your product in stock : " + product.getQtyInStock());
										System.out.println("Enter discount for this product if you have: "); double discount = in.nextDouble();
										purchase = new Purchase(proCode, product, qty, discount);
										cart.addItem(purchase);
									}
								}
							}
							
							System.out.println("--------------------------Your Cart-------------------------");
							for(Purchase p : cart.getPurchasedItems()) {
								System.out.println(p.toString());
							}
							System.out.println("------------------------------------------------------------");
							System.out.println("Do you want to shop more product?(Y/N)");
							in.nextLine();
							choice = in.nextLine();
							if(choice.equalsIgnoreCase("y")) continue again;
							else break again;
						}
				break;
			case "4":
				showMyShoppingCart(cart);
				break;
			case "5":
					System.out.println("-------------------------------Before Check out, give me your information-------------------------------");
					System.out.println("Enter your identification Number : "); String id = in.nextLine();
					System.out.println("Enter your name : "); String name = in.nextLine();
					System.out.println("Enter your email : "); String email = in.nextLine();
					System.out.println("Enter your shipping address : "); String shippingAddress = in.nextLine();
					System.out.println("Enter your billing address :  "); String billingAddress = in.nextLine();
					System.out.println("\n-------------------------------Do you have discount card?---------------------------------------------");
					System.out.println("\nEnter Pertage on your discount card : "); double discountCard = in.nextDouble();
					Customer customer = new Customer(id, name, email, shippingAddress, billingAddress);
					customers.add(customer);
					
					System.out.println("------------------------------------Your purchased Invoice----------------------------------------------");
					
					for(Customer customer1 : customers) {
						System.out.println(customer1.toString());
						showMyShoppingCart(cart);
					}
				break;
					
			}
		}while(!option.equals("6"));
	}
	
	public static String menu() {
		String option;
		Scanner in = new Scanner(System.in);
		DrawingTable drawingTable1 = new DrawingTable();
		
		drawingTable1.setHeaders("              Menu              ");
		drawingTable1.addRow("   1. Create New Product   ");
		drawingTable1.addRow("   2. List of Product(s)   ");
		drawingTable1.addRow("   3. Go to Shopping    ");
		drawingTable1.addRow("   4. My Shopping Cart   ");
		drawingTable1.addRow("   5. Check Out  ");
		
		drawingTable1.print();
		option = in.nextLine();
		return option;
	}
	
	public static void createNewProduct() {
		String choice;
		again:
			while(true) {
				System.out.println("-----------------Create New Product---------------\n");
				System.out.println("Enter Your Product ID : "); String proID = in.nextLine();
				System.out.println("Enter Your product name : "); String proName = in.nextLine();
				System.out.println("Enter Your Product Description : "); String description = in.nextLine();
				System.out.println("Enter Quanlity of Your Product : "); double qty = in.nextDouble();
				System.out.println("Enter Price of Your Product : "); double price = in.nextDouble();
				Product product = new Product(proID, proName, description, qty, price);
				products.add(product);
				
				System.out.println("Do you want to add more Product? (Y/N)");
				in.nextLine();
				choice = in.nextLine();
				if(choice.equalsIgnoreCase("Y")) continue again;
				else break;
			}
	}
	
	public static void showProductList() {
		String choice;
		DrawingTable drawingTable;
		again:
			while(true) {
				System.out.println("----------------------Product List-------------------------\n");
			
				drawingTable = new DrawingTable();
				drawingTable.setHeaders(" ID ", " Name ", " QTY ", " Price ", " Description ");
				for(Product product : products) {
					drawingTable.addRow(product.getID() , product.getName(), product.getQtyInStock() + "", product.getPrice() + "", product.getDescription());
				}
				
				drawingTable.print();
				System.out.println("Do you want to continue to Main Menu? (Y/N)");
				choice = in.nextLine();
				if(choice.equalsIgnoreCase("y")) {
					break again;
				}
				else {
					continue again;
				}
			}
	}
	
	public static void showMyShoppingCart(Cart cart) {
		DrawingTable drawingTable = new DrawingTable();
		System.out.println("--------------------My Shopping Cart----------------------------\n");
		
		drawingTable.setHeaders(" NO ", " Name ", " Qty ", "Unit Price", " Discount ", " Price " );
		
		for(Purchase item : cart.getPurchasedItems()) {
			drawingTable.addRow(item.getOrderNo().toString(), item.getProductName(), 
					item.getQty() + "","$ " +item.getProductPrice(), item.getDiscount() + "",
					item.getPrice() + "");
		}
		drawingTable.print();
		in.nextLine();
	}
}
