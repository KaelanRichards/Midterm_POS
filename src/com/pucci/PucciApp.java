package com.pucci;

import java.util.Scanner;

public class PucciApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// All variable declarations
		int menuChoice;
		int userProductChoice = 0;
		String cont = "y";
		double subTotal;
		double grandTotal;

		System.out.println("Welcome to Pucci");
		System.out.println("Feel free to browse our shop");

		do {

			// Using method in main to print the category menu
			printFirstMenu();

			// Getting user input to pick which category they would like to explore
			menuChoice = Validator.getInt(scan, "Please select the number of which category you would like: ", 1, 7);

			// This method call will navigate to whichever category the user chose
			getMenuChoice(menuChoice);

			// validate user input for which item they would like
			userProductChoice = Validator.getInt(scan,
					"Please select the number to add product to your shopping cart: ");

			// This method will take in the category and specific product user would like
			// and add it to cart
			putProductInCart(menuChoice, userProductChoice);

			// View Shopping Cart
			System.out.println();
			System.out.println("SHOPPING CART");
			System.out.println("=========================");
			ShoppingCart.viewCart();
			System.out.println();

			cont = Validator.getString(scan, "Would you like to continue shopping (y/n): ");

		} while (cont.equalsIgnoreCase("y"));

		// TODO This is not working yet
		subTotal = ShoppingCart.subTotalCart();
		System.out.println("Your subtotal is: $" + subTotal);
		grandTotal = ShoppingCart.grandTotalCart();
		System.out.println("Your grandtotal is: $" + grandTotal);
		
		double sumTotal = 0.0; // Real variable will come from the cart class

		// Prompt user for payment (cash, check, charge) (Validator class)
		// payment(scan, sumTotal);

		// TODO display receipt (items ordered, subtotal, grand total, appropriate
		// payment info)

		System.out.println("Have a Pucci day");

	}

	public static void payment(Scanner scan, double sumTotal) {
		String userPayChoice;

		System.out.println("What it will be your choice of payment: ");
		System.out.println("1. Cash \n 2. Check \n 3.Card");
		userPayChoice = scan.nextLine();

		if (userPayChoice.equals("1")) {
			System.out.println("This is your change: ");
			System.out.println(PaymentValidation.usersChange(sumTotal, scan));
		} else if (userPayChoice.equals("2")) {
			if (PaymentValidation.isValidCheck(scan)) {
				System.out.println("Your purchase was approved.");
			}
		} else if (userPayChoice.equals("3")) {
			if (PaymentValidation.isValidCard(scan))
				;
			{
				System.out.println("Your purchase was approved.");
			}
		}
		System.out.println("Thank you for shopping at Pucci!");
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
		switch (userInput) {
		case 1:
			Tops.printMenTops();
			break;
		case 2:
			Bottoms.printMenBottoms();
			break;
		case 3:
			Shoes.printMenShoes();
			break;
		case 4:
			Tops.printWomenTops();
			break;
		case 5:
			Bottoms.printWomenBottoms();
			break;
		case 6:
			Shoes.printWomenShoes();
			break;
		case 7:
			System.out.println("quit");
			break;

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
