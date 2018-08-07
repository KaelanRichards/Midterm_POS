package com.pucci;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author CoderBoyKado
 * @author Brandon Spencer
 * @author Joseph Bojovic
 * @author Camila Brasil
 *
 */

public class PucciApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		// All variable declarations
		int menuChoice;
		int userProductChoice = 0;
		int cont = 0;
		double subTotal;
		double grandTotal;
		int userQty;
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		do {

			// Using method in main to print the category menu
			printFirstMenu();

			System.out.println(); // Line space for readability

			// Getting user input to pick which category they would like to explore
			menuChoice = Validator.getInt(scan, "Please select the number of which category you would like: ", 1, 7);

			// This method call will navigate to whichever category the user chose
			getMenuChoice(menuChoice, indexes);

			// This method will take in the category and specific product user would like
			// and add it to cart
			if (menuChoice == 7) {
				break;
			} else {
				// validate user input for which item they would like
				System.out.println("0. Return");

				System.out.println(); // Line space for readability

				userProductChoice = Validator.getInt(scan, "Please select the number to add product "
														 + "to your shopping cart: ", 0, indexes.size());
				if (userProductChoice == 0) {
					cont = 2;
					continue;
				} else if (userProductChoice > 0 && userProductChoice < indexes.size()) {
					userQty = Validator.getInt(scan, "Quantity?");
					putProductInCart(indexes, userProductChoice, userQty);				
				}
				
			}

			// View Shopping Cart
			System.out.println("1. View shopping cart?");
			System.out.println("2. Continue shopping? ");
			cont = Validator.getInt(scan, " ");
			if (cont == 1) {
				// View Shopping Cart
				displayShoppingCart(df);

				// cont2 = Validator.getString(scan, "Are you still shopping? (y/n)");
				// cont = Validator.getString(scan, "Would you like to continue shopping (y/n):
				// ");
				System.out.println("1. Edit Shopping Cart?");
				System.out.println("2. Continue shopping?");
				System.out.println("3. Checkout");

				cont = Validator.getInt(scan, " ");

				if (cont == 1) {
					editShoppingCart(df);
					System.out.println("1. Remove Item?");
					System.out.println("2. Continue shopping?");
					cont = Validator.getInt(scan, " ");
					if (cont == 1) {
						int userEdit = 0;
						userEdit = Validator.getInt(scan, "Enter the number of the item you would like to remove: ", 1,
								ShoppingCart.shoppingCart.size());
						ShoppingCart.removeItem(userEdit);
						displayShoppingCart(df);

						cont = 2;
					}
				}

			}

		} while (cont == 2);
		subTotal = (ShoppingCart.subTotalCart());
		// payment info)
		if (subTotal != 0) {
			System.out.println("You purchased " + ShoppingCart.shoppingCart.size() + " items");
			System.out.println("Your subtotal is: $" + df.format(subTotal));
			grandTotal = ShoppingCart.grandTotalCart();
			System.out.println("Your grandtotal is: $" + df.format(grandTotal));
			// Prompt user for payment (cash, check, charge) (Validator class)

			System.out.println(); // Line space for readability

			String userPay = payment(scan, grandTotal, df);

			String receipt = Validator.getString(scan, "Would you like your reciept? (y/n)");
			if (receipt.equalsIgnoreCase("y")) {
				System.out.println("\n RECEIPT Thank you for shopping at Pucci");
				System.out.println("===========================================");
				ShoppingCart.viewCart();
				System.out.println();
				ShoppingCart.checkoutCart(subTotal, grandTotal, userPay);

			}
		}
		System.out.println("\nYour puchase today is so Pucci!");

	}

	public static void editShoppingCart(DecimalFormat df) {
		System.out.println("SHOPPING CART");
		System.out.println("====================================");
		ShoppingCart.viewEditCart();
		System.out.println("\n====================================");
		System.out.println("Your current subtotal is: $" + df.format(ShoppingCart.subTotalCart()) + "\n");
	}

	public static void displayShoppingCart(DecimalFormat df) {
		System.out.println();
		System.out.println("SHOPPING CART");
		System.out.println("====================================");
		ShoppingCart.viewCart();
		System.out.println();
		System.out.println("====================================");
		System.out.println("Your current subtotal is: $" + df.format(ShoppingCart.subTotalCart()));
		System.out.println();
	}

	// CUSTOM METHODS START BELOW//

	public static String payment(Scanner scan, double sumTotal, DecimalFormat df) {
		String userPayChoice;

		System.out.println("Please select your method of payment: ");
		System.out.println("1. Cash \n2. Check \n3. Card");
		userPayChoice = scan.nextLine();

		if (userPayChoice.equals("1")) {
			System.out.println(
					"Your change is $" + (df.format(PaymentValidation.usersChange(sumTotal, scan))));
			userPayChoice = "Cash";
		} else if (userPayChoice.equals("2")) {
			PaymentValidation.isValidCheck(scan);
			System.out.println("Your purchase was approved.");
			userPayChoice = "Check";
		} else if (userPayChoice.equals("3")) {
			PaymentValidation.isValidCard(scan);
			userPayChoice = "Credit Card";
		}
		return userPayChoice;
	}

	public static void putProductInCart(ArrayList<Integer> indexes, int productChoice, int userQty) {

		int i = indexes.get(productChoice - 1);
		
		ShoppingCart.addItem(FileMethods.readFromFile("Products.txt").get(i), userQty);
	}

	public static void getMenuChoice(int userInput, ArrayList<Integer> indexes) {
		String genderType = null;
		int j = 1;

		if (userInput <= 3 & userInput >= 1) {
			genderType = "Men";
		} else if (userInput <= 6) {
			genderType = "Women";
		}

		if (userInput == 1 || userInput == 4) {
			genderType += "Tops";
		} else if (userInput == 2 || userInput == 5) {
			genderType += "Bottom";
		} else if (userInput == 3 || userInput == 6) {
			genderType += "Shoes";
		}

		ArrayList<Clothes> inventory = FileMethods.readFromFile("Products.txt");
		String[] singleProduct;

		for (int i = 0; i < inventory.size(); i++) {
			singleProduct = inventory.get(i).toString().split(",");

			if (singleProduct[0].equals(genderType)) {
				String one = j + ". " + singleProduct[1];
				String two = "$" + singleProduct[2];
				System.out.printf("%-20s%-20s%n", one, two );
				indexes.add(i);
				j += 1;
			}
		}

	}

	public static void printFirstMenu() {
		String[] firstMenu = { "Men \t\t Women", "1. Tops \t 4. Tops", "2. Bottoms \t 5. Bottoms", "3. Shoes \t 6. Shoes",
				"\t 7.Checkout" };
		for (int i = 0; i < firstMenu.length; i++) {
			System.out.println(firstMenu[i]);

		}
	}

}