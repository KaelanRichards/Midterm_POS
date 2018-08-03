/**
 * 
 */
package com.pucci;

/**
 * @author Joseph Bojovic Jr.
 *
 */


public class Tops extends Clothes {

		
	public Tops(String gender, String name, String type, String price, String inventory) {
		super(gender, name, type, price, inventory);
		// TODO Auto-generated constructor stub
	}



	private String size;

	
	
	public void printTops() {
		FileMethods.readFromFile("Products.txt");
		
	}
	
	


	
	
	

	
	


	

	
	
	
}
