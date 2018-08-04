/**
 * 
 */
package com.pucci;

import java.util.ArrayList;

/**
 * @author CoderBoyKado
 *
 */
public class ShoppingCart {

	static ArrayList<Clothes> shoppingCart = new ArrayList<>();
	// shoppingCart = null;

	// This will create a shopping cart list and add clothes objects to it
	public static ArrayList<Clothes> addItem(Clothes product) {

		shoppingCart.add(product);
		return shoppingCart;

	}

	// This class will read from the shopping cart text file and return a list
	// It will then remove an item from list then overwrite old cart file with new
	// list
	public static void removeItem() {

	}

	// This method will print the contents from your current shopping cart
	// by using a for loop
	public static void viewCart() {
		for (Clothes c : shoppingCart) {
			System.out.println(c);
		}

	}

	// This method will return the grand total of your cart
	// by calculating sum w/ tax
	public static double grandTotalCart() {

		String[] newProductList;

		double total = 0;
		for (Clothes product : shoppingCart) {
			newProductList = product.toString().split(",");
			double doublePrice = Double.parseDouble(newProductList[1]);
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

			double doublePrice = Double.parseDouble(newProductList[1].substring(1));
			System.out.println(Double.parseDouble(newProductList[1].substring(1)));
			total += doublePrice;
		}
		
		return total;
	}

	// return receipt information
	//
	public static void checkoutCart(double subTotal, double grandTotal, String paymentMethod) {
		String sTotal;
		String gTotal;

		ArrayList<String> receipt = new ArrayList<>();

		sTotal = Double.toString(subTotal);
		gTotal = Double.toString(grandTotal);

//		receipt.add(paymentMethod);
//		receipt.add(gTotal);
//		receipt.add(sTotal);
//		System.out.println(receipt); 
		
		System.out.println("You paid with " + paymentMethod + "- Your Subtotal was " + sTotal + "- Your grandtotal was " + gTotal);
	}

}
