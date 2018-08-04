package com.pucci;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMainCamila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// All variable declarations
		int userProductChoice = 0;
		String cont = "y";
		String userPayChoice;

		// Welcome User to Pucci and give instruction
		System.out.println("Welcome to Pucci");
		System.out.println("select a category from the menu below");

		// Display menu with options
		printFirstMenu();

		// Get input from user
		int menuChoice = Validator.getInt(scan, "Please select the number of which category you would like", 1, 7);
		
		//Processing the users choice and returning an array with the indexes of the options from the read from file array
		int[] indexes = getMenuChoice(menuChoice);

		do {
			userProductChoice = Validator.getInt(scan,
					"Please select the number to add product to your shopping cart or 0 to return to main menu");

			//It would have to change the parameters from the method, to take the index of the product selected from the read from file array
			ShoppingCart.addItem(indexes[userProductChoice - 1]);

			cont = Validator.getString(scan, "Would you like to continue shopping");
		} while (cont.equalsIgnoreCase("y"));
		
		
		 // System.out.println(ShoppingCart.viewCart());
		//
		// ShoppingCart.viewCart();
		//
		// // TODO Add to cart? (do - while loop to product menu) (write to cart text
		// file)
		//
		// // TODO loop back when user done shopping
		//
		// // TODO print out user cart (read cart text file)
		// double sumTotal = 0;
		//
		// // Prompt user for payment (cash, check, charge)
		// payment(scan, sumTotal);
		//
		// // TODO display receipt (items ordered, subtotal, grand total, appropriate
		// // payment info)
		//
		// // Goodbye
		// System.out.println("Have a Pucci day");
		//
		// // When creating a new Top: Parameters needed are (String name, String type,
		// // double price, int inventory, String size)
		// // Clothes test = new Tops("Button Down", "Shirt", 240.00, 2, "Medium");
		// // System.out.println(test);

	}

	public static void printFirstMenu() {
		String[] firstMenu = { "Men \t\t Women", "1.Top \t\t 4.Top", "2.Bottoms \t 5.Bottoms", "3.Shoes \t 6.Shoes",
				"\t 7.Exit" };
		for (int i = 0; i < firstMenu.length; i++) {
			System.out.println(firstMenu[i]);
		}
	}

	public static int[] getMenuChoice(int userInput) {

		ArrayList<Clothes> productList = FileMethods.readFromFile("products.txt");
		String optionGender = null;
		String optionType = null;
		int[] indexes = null;

		if (userInput <= 3 && userInput >= 1) {
			optionGender = "Men";
		} else if (userInput <= 6) {
			optionGender = "Women";
		}

		if (userInput == 1 || userInput == 4) {
			optionType = "Tops";
		} else if (userInput == 2 || userInput == 5) {
			optionType = "Bottoms";
		} else if (userInput == 3 || userInput == 6) {
			optionType = "Shoes";
		}

		for (int i = 0; i < productList.size(); i++) {
			String[] b = productList.get(1).toString().split(",");
			if (b[0].equalsIgnoreCase(optionGender + optionType)) {
				int j = 0;
				System.out.println(j + ". " + productList.get(i).toString());
				indexes[j] = i;
				j++;
			}
		}

		return indexes;
	}

	public static void payment(Scanner scan, double sumTotal) {
		String userPayChoice;

		System.out.println("Please select your choice of payment: ");
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

}
