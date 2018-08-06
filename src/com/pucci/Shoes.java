/**
 * 
 */
package com.pucci;

import java.util.ArrayList;

/**
 * @author Brandon Spencer
 *
 */
public class Shoes extends Clothes {

	public Shoes(String gender, String name, String type, String price, String inventory) {
		super(gender, name, type, price, inventory);
	}

	// this method prints the list of men's shoes in a numbered list.
	public static void printMenShoes() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFileShoes("Products.txt");
		ArrayList<Clothes> mShoeList = new ArrayList<>();
		mShoeList.add(menu2.get(5));
		mShoeList.add(menu2.get(6));

		int i = 1;
		for (Clothes c : mShoeList) {

			System.out.println(i + ". " + c);
			i++;
		}
	}

	// this method prints the list of women's shoes in a numbered list.
	public static void printWomenShoes() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFileShoes("Products.txt");
		ArrayList<Clothes> wShoeList = new ArrayList<>();
		wShoeList.add(menu2.get(14));
		wShoeList.add(menu2.get(15));

		int i = 1;
		for (Clothes c : wShoeList) {

			System.out.println(i + ". " + c);
			i++;
		}
	}

	// this method returns the arraylist of men's shoes.
	public static ArrayList<Clothes> getMShoeList() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> mShoeList = new ArrayList<>();
		mShoeList.add(menu2.get(5));
		mShoeList.add(menu2.get(6));

		return mShoeList;

	}
	// this method returns the arraylist of women's shoes.
	public static ArrayList<Clothes> getWShoeList() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> wShoeList = new ArrayList<>();
		wShoeList.add(menu2.get(14));
		wShoeList.add(menu2.get(15));

		return wShoeList;
	}

	public static void getMenShoesToCart(int userChoice) {

		int i = userChoice;
		
		for (i = 5; i <= 6; i++) {
			if ((i - 4) == userChoice) {
				// (i - 4) is used in the if statement because when the list of men's shoes is displayed to the user,
				// it is shown in a numbered list beginning with 1. So when the user enters their selection (1 or 2),
				// 4 is added to userChoice and the index at that location is added to the Shopping Cart, 
				// i.e. if a user enters 1, index 5 from the Products.txt file will be added to the cart.
				ShoppingCart.addItem(FileMethods.readFromFileShoes("Products.txt").get(i));
			}
		}
	}

	public static void getWomenShoesToCart(int userChoice) {

		int i = userChoice;
		for (i = 14; i <= 15; i++) {
			if ((i - 13) == userChoice) {
				// (i - 13) is used in the if statement because when the list of men's bottoms is displayed to the user,
				// it is shown in a numbered list beginning with 1. So when the user enters their selection (1 or 2),
				// 13 is added to userChoice and the index at that location is added to the Shopping Cart, 
				// i.e. if a user enters 1, index 14 from the Products.txt file will be added to the cart.
				ShoppingCart.addItem(FileMethods.readFromFileShoes("Products.txt").get(i));
			}
		}
	}

	@Override
	public String toString() {

		//return String.format("%-18s  %-18s", getName(), (getPrice()));
		return getName() + ", " + "\t" + "\t" + getPrice();
	}
	}

