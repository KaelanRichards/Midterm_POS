/**
 * 
 */
package com.pucci;

import java.util.ArrayList;

/**
 * @author Brandon Spencer
 *
 */
public class Bottoms extends Clothes {

	public Bottoms(String gender, String name, String type, String price, String inventory) {
		super(gender, name, type, price, inventory);

	}

	// this method will print the list of men's bottoms in a numbered format
	public static void printMenBottoms() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFileBottoms("Products.txt");
		ArrayList<Clothes> mBottomList = new ArrayList<>();
		mBottomList.add(menu2.get(7));
		mBottomList.add(menu2.get(8));
		int i = 1;
		for (Clothes c : mBottomList) {

			System.out.println(i + ". " + c);
			i++;
		}
	}

	// this method will print the list of women's bottoms in a numbered format
	public static void printWomenBottoms() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFileBottoms("Products.txt");
		ArrayList<Clothes> wBottomList = new ArrayList<>();
		wBottomList.add(menu2.get(12));
		wBottomList.add(menu2.get(13));

		int i = 1;
		for (Clothes c : wBottomList) {

			System.out.println(i + ". " + c);
			i++;
		}
	}

	// this method returns the arraylist of men's bottoms
	public static ArrayList<Clothes> getMBottomList() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> mBottomList = new ArrayList<>();
		mBottomList.add(menu2.get(7));
		mBottomList.add(menu2.get(8));

		return mBottomList;
	}

	// this method returns the arraylist of women's bottoms
	public static ArrayList<Clothes> getWBottomList() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> wBottomList = new ArrayList<>();
		wBottomList.add(menu2.get(12));
		wBottomList.add(menu2.get(13));

		return wBottomList;
	}
	
	// this method adds men's bottoms to the shopping cart by using an enhanced for loop to iterate over the
	// Products.txt file, referencing the index of the item.
	public static void getMenBottomsToCart(int userChoice) {

		int i = userChoice;
		for (i = 7; i <= 8; i++) {
			if ((i - 6) == userChoice) {
				// (i - 6) is used in the if statement because when the list of men's bottoms is displayed to the user,
				// it is shown in a numbered list beginning with 1. So when the user enters their selection (1 or 2),
				// 6 is added to userChoice and the index at that location is added to the Shopping Cart, 
				// i.e. if a user enters 1, index 7 from the Products.txt file will be added to the cart.
				ShoppingCart.addItem(FileMethods.readFromFileBottoms("Products.txt").get(i));
			}
		}
	}
	
	public static void getWomenBottomsToCart(int userChoice) {

		int i = userChoice;
		for (i = 12; i <= 13; i++) {
			if ((i - 11) == userChoice) {
				// (i - 11) is used in the if statement because when the list of women's bottoms is displayed to the user,
				// it is shown in a numbered list beginning with 1. So when the user enters their selection (1 or 2),
				// 11 is added to userChoice and the index at that location is added to the Shopping Cart, 
				// i.e. if a user enters 1, index 12 from the Products.txt file will be added to the cart.
				ShoppingCart.addItem(FileMethods.readFromFileBottoms("Products.txt").get(i));
			}
		}
	}

//	@Override
//	public String toString() {
//
//		return String.format("%-18s  %-18s", getName(), (getPrice()));
//		
	}

