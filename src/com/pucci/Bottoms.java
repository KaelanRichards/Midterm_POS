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

	public static void printMenBottoms() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> mBottomList = new ArrayList<>();
		mBottomList.add(menu2.get(7));
		mBottomList.add(menu2.get(8));
		int i = 1;
		for (Clothes c : mBottomList) {

			System.out.println(i + ". " + c);
			i++;
		}

	}

	public static void printWomenBottoms() {
		ArrayList<Clothes> menu2 = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> wBottomList = new ArrayList<>();
		wBottomList.add(menu2.get(12));
		wBottomList.add(menu2.get(13));

		int i = 1;
		for (Clothes c : wBottomList) {

			System.out.println(i + ". " + c);
			i++;
		}

	}
}
