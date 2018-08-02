/**
 * 
 */
package com.pucci;

/**
 * @author Joseph Bojovic Jr.
 *
 */


public class Tops extends Clothes {

		
	private String size;

	
	public Tops(String name, String type, double price, int inventory, String size) {
		super(name, type, price, inventory);
	}


	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}


	
	


	

	
	
	
}
