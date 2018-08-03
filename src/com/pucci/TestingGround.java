package com.pucci;

import java.util.ArrayList;

public class TestingGround {

	public static void main(String[] args) {
		
//		Tops.printMenTops();
//		Tops.printWomenTops();
//		Bottoms.printMenBottoms();
//		Shoes.printMenShoes();
//		
//		System.out.println(FileMethods.readFromFile("Products.txt"));
		ArrayList<Clothes> arr = new ArrayList<>();
		arr = Shoes.getMShoeList();
		System.out.println(arr.get(0));
		System.out.println(Shoes.getMShoeList());
		System.out.println(Bottoms.getMBottomList().get(1));
		Bottoms.printMenBottoms();
		
	}
}
