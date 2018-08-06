package com.pucci;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMainCamila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// All variable declarations
		int menuChoice;
		int userProductChoice = 0;
		String cont = "y";
		double subTotal;
		double grandTotal;

		// System.out.println("Welcome to Pucci");
		// System.out.println("Feel free to browse our shop");

		do {

			// Using method in main to print the category menu
			printFirstMenu();

			// Getting user input to pick which category they would like to explore
			menuChoice = Validator.getInt(scan, "Please select the number of which category you would like: ", 1, 7);

			// This method call will navigate to whichever category the user chose
			getMenuChoice(menuChoice);

			// This method will take in the category and specific product user would like
			// and add it to cart
			if (menuChoice == 7) {
				break;
			} else {
				// validate user input for which item they would like
				System.out.println("0. Return");
				userProductChoice = Validator.getInt(scan,
						"Please select the number to add product to your shopping cart: ");
				if (userProductChoice == 0) {
					continue;
				} else {
					putProductInCart(menuChoice, userProductChoice);
				}
			}

			// View Shopping Cart
			System.out.println();
			System.out.println("SHOPPING CART");
			System.out.println("=========================");
			ShoppingCart.viewCart();
			System.out.println();

			cont = Validator.getString(scan, "Would you like to continue shopping (y/n): ");

		} while (cont.equalsIgnoreCase("y"));

		subTotal = ShoppingCart.subTotalCart();
		// payment info)
		if (subTotal != 0) {
			// TODO This is not working yet
			System.out.println("You purchased " + ShoppingCart.shoppingCart.size() + " items");
			System.out.println("Your subtotal is: $" + Math.round(subTotal));
			grandTotal = ShoppingCart.grandTotalCart();
			System.out.println("Your grandtotal is: $" + Math.round(grandTotal));
			// Prompt user for payment (cash, check, charge) (Validator class)
			payment(scan, grandTotal);
			scan.nextLine();
			String receipt = Validator.getString(scan, "Would you like your reciept? (y/n)");
			if (receipt.equalsIgnoreCase("y")) {
				System.out.println("Here is your receipt");
				ShoppingCart.viewCart();
				ShoppingCart.checkoutCart(subTotal, grandTotal, "");

			}
		}
		System.out.println("Have a Pucci day");

	}

	// CUSTOM METHODS START BELOW//

	public static String payment(Scanner scan, double sumTotal) {
		String userPayChoice;

		System.out.println("Please select your method of payment: ");
		System.out.println("1. Cash \n2. Check \n3. Card");
		userPayChoice = scan.nextLine();

		if (userPayChoice.equals("1")) {
			System.out.println("Your change is " + (PaymentValidation.usersChange(sumTotal, scan)) + " Dollars.");
		} else if (userPayChoice.equals("2")) {
			if (PaymentValidation.isValidCheck(scan)) {
				System.out.println("Your purchase was approved.");
			}
		} else if (userPayChoice.equals("3")) {
			if (PaymentValidation.isValidCard(scan)) {
			}
		}
		return userPayChoice;
	}

	public static void putProductInCart(int menuChoice, int productChoice) {
		// getMenuChoice(menuChoice);

		switch (menuChoice) {
		case 1:
			Tops.getMenTopsToCart(productChoice);
			break;
		case 2:
			Bottoms.getMenBottomsToCart(productChoice);
			break;
		case 3:
			Shoes.getMenShoesToCart(productChoice);
			ShoppingCart.viewCart();
			break;
		case 4:
			Tops.getWomenTopsToCart(productChoice);
			break;
		case 5:
			Bottoms.getWomenBottomsToCart(productChoice);
			break;
		case 6:
			Shoes.getWomenShoesToCart(productChoice);
			break;
		}

		// for (int i = 0; i < 6 ; i++) {
		// if((i+1) == userProductChoice) {
		//
		// ShoppingCart.addItem(FileMethods.readFromFileTops("Products.txt").get(i));
		// }
		// }
	}

	public static void getMenuChoice(int userInput) {
		String genderType = null;

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
				System.out.println(singleProduct[1] + " $" + singleProduct[2]);
			}
		}

	}

	public static void printFirstMenu() {
		String[] firstMenu = { "Men \t\t Women", "1.Top \t\t 4.Top", "2.Bottoms \t 5.Bottoms", "3.Shoes \t 6.Shoes",
				"\t 7.Exit" };
		for (int i = 0; i < firstMenu.length; i++) {
			System.out.println(firstMenu[i]);

		}
	}

}
//
// for (int i = 0; i < productList.size(); i++) {
// String[] b = productList.get(0).toString().split(",");
// System.out.println(b[0]);
// if (b[0].equalsIgnoreCase(optionGender + optionType)) {
// int j = 0;
// System.out.println(j + ". " + productList.get(i).toString());
// indexes[j] = i;
// j++;
// }
// }
//
// return indexes;
// }
