package com.pucci;

import java.util.Scanner;

public class PucciApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// All variable declarations
		int userInput;
		
		
		
		// TODO Welcome User to Pucci and give instruction
		
		System.out.println("Welcome to Pucci");
		System.out.println("select a category from the menu below");
		
		
		
	
		
		// TODO Display menu ( Men (tops, bottoms, shoes)      |        Womens(tops, bottoms, shoes) )
		
		
		printFirstMenu();
		
		
		// TODO Get input from user  ---  read product text file ---- return list
		
		userInput = Validator.getInt(scan, "Please select the number of which category you would like", 1 , 7);
		
		
		
		// TODO Add to cart? (do - while loop to product menu) (write to cart text file)
		
		
		
		// TODO loop back when user done shopping
		
		
		
		// TODO print out user cart (read cart text file)
		
		
		
		// TODO prompt user for payment (cash, check, charge) (Validator class)
		
		
		
		// TODO display receipt (items ordered, subtotal, grand total, appropriate payment info)
		
		
		
		// TODO goodbye
		System.out.println("Have a Pucci day");
		
		//When creating a new Top: Parameters needed are (String name, String type, double price, int inventory, String size)  
//		Clothes test = new Tops("Button Down", "Shirt", 240.00, 2, "Medium");
//		System.out.println(test);
		
	}

	public static void printFirstMenu() {
		String[] firstMenu = { "Men \t\t Women", "1.Top \t\t 4.Top", "2.Bottoms \t 5.Bottoms",
				"3.Shoes \t 6.Shoes", "\t 7.Exit" };
		for (int i = 0; i < firstMenu.length; i++) {
			System.out.println(firstMenu[i]);
		}
	}

}
