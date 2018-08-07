/**
 * 
 */
package com.pucci;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author CoderBoyKado
 *
 */
public class ShoppingCart {

	

	static ArrayList<Clothes> shoppingCart = new ArrayList<>();

	// This will create a shopping cart list and add clothes objects to it
	public static ArrayList<Clothes> addItem(Clothes product, int userQty) {

			for (int i = 0; i < userQty; i++) {
				shoppingCart.add(product);
			}
			
		return shoppingCart;

	}

	// This class will read from the shopping cart text file and return a list
	// It will then remove an item from list then overwrite old cart file with new
	// list
	public static void removeItem(int userEdit) {
			shoppingCart.remove(userEdit - 1);
	}

	// This method will print the contents from your current shopping cart
	// by using a for loop
	public static void viewCart() {
		for (Clothes c : shoppingCart) {
			
			String one = "$" + c.getPrice();
			
			System.out.printf("%-20s%-20s%n", c.getName(), one );
		}
	}
		public static void viewEditCart() {
			int i = 1;
			for (Clothes c : shoppingCart) {
				
				String one = "$" + c.getPrice();
				
				System.out.print(i + ". ");
				System.out.printf("%-20s%-20s%n", c.getName(), one );
				i++;
			}
		
	}

	// This method will return the grand total of your cart
	// by calculating sum w/ tax
	public static double grandTotalCart() {

		String[] newProductList;

		double total = 0;
		for (Clothes product : shoppingCart) {
			newProductList = product.toString().split(",");
			double doublePrice = Double.parseDouble(newProductList[2]);
			total += doublePrice;
		}
		total = total * 1.08;
		return total;
	}

	// This method will return the sub total of your cart
	public static double subTotalCart() {
		String[] newProductList;

		double total = 0;
		for (Clothes product : shoppingCart) {
			newProductList = product.toString().split(",");
			


			double doublePrice = Double.parseDouble(newProductList[2]);

			total += doublePrice;
		}
		
		return total;
	}

	// return receipt information
	public static void checkoutCart(double subTotal, double grandTotal, String paymentMethod) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		
		System.out.println("\nYou paid with " + paymentMethod + "\n" + "Subtotal... $" +  df.format(subTotal) + "\n" +  "Grandtotal... $" + df.format(grandTotal));
	}

}
