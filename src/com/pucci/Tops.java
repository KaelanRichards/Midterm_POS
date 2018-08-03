/**
 * 
 */
package com.pucci;

import java.util.ArrayList;

/**
 * @author Joseph Bojovic Jr.
 *
 */

public class Tops extends Clothes {

	private String size;

	public Tops(String gender, String name, String type, String price, String inventory) {
		super(gender, name, type, price, inventory);
		name.equals(getName());
	}

	public static void printMenTops() {

		ArrayList<Clothes> menu = FileMethods.readFromFileTops("Products.txt");
		ArrayList<Clothes> mTopList = new ArrayList<>();
		mTopList.add(menu.get(0));
		mTopList.add(menu.get(1));
		mTopList.add(menu.get(2));
		mTopList.add(menu.get(3));
		mTopList.add(menu.get(4));

		int m = 1;
		for (Clothes c : mTopList) {

			System.out.println(m + ". " + c);
			m++;
		}
	}

	public static void printWomenTops() {

		ArrayList<Clothes> menu = FileMethods.readFromFileTops("Products.txt");
		ArrayList<Clothes> wTopList = new ArrayList<>();
		wTopList.add(menu.get(9));
		wTopList.add(menu.get(10));
		wTopList.add(menu.get(11));

		int i = 1;
		for (Clothes c : wTopList) {

			System.out.println(i + ". " + c);
			i++;
		}
	}

	public static ArrayList<Clothes> getMenTops() {

		ArrayList<Clothes> menu = FileMethods.readFromFile("Products.txt");
		ArrayList<Clothes> mTopList = new ArrayList<>();
		mTopList.add(menu.get(0));
		mTopList.add(menu.get(1));
		mTopList.add(menu.get(2));
		mTopList.add(menu.get(3));
		mTopList.add(menu.get(4));

		return mTopList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "joe's test";
	}
}
