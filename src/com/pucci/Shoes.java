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

	public static ArrayList<Clothes> getMShoeList() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> mShoeList = new ArrayList<>();
		mShoeList.add(menu2.get(5));
		mShoeList.add(menu2.get(6));

		return mShoeList;

	}

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
			if ((i + 1) == userChoice) {

				ShoppingCart.addItem(FileMethods.readFromFileShoes("Products.txt").get(i));
			}
		}
	}

	public static void getWomenShoesToCart(int userChoice) {

		int i = userChoice;
		for (i = 14; i <= 15; i++) {
			if ((i + 1) == userChoice) {

				ShoppingCart.addItem(FileMethods.readFromFileShoes("Products.txt").get(i));
			}
		}
	}

	@Override
	public String toString() {
		return String.format("%-18s %-18s", getName(), (getPrice()));
	}
}
