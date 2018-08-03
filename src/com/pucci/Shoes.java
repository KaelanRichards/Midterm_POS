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
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
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
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
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
}
