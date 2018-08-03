package com.pucci;

import java.util.ArrayList;

public class TestingGround {

	public static void main(String[] args) {
		
		
		ArrayList<Clothes> menu = FileMethods.readFromFile("Products.txt");
System.out.println(menu);
	}

}
