package com.pucci;


/**
 * @author Joseph Bojovic J.
 *
 */

public class Clothes {

	private String name;
	private String type; //Tops Bottoms Shoes
	private String price;
	private String inventory; //Available product amount 
	private String Gender;
	
	
	
	public Clothes(String gender, String name, String type, String price, String inventory) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.inventory = inventory;
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the inventory
	 */
	public String getInventory() {
		return inventory;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "," + "$" + price + "," + inventory;
	}
	
	
	
	
}
