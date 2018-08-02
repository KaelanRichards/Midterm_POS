package com.pucci;


/**
 * @author Joseph Bojovic J.
 *
 */

public abstract class Clothes {

	private String name;
	private String type; //Tops Bottoms Shoes
	private double price;
	private int inventory; //Available product amount 
	private String size;
	
	
	
	public Clothes(String name, String type, double price, int inventory, String size) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.inventory = inventory;
		this.size = size;
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
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the inventory
	 */
	public int getInventory() {
		return inventory;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return type + "," + size + "," + name + "," + "$" + price + "," + inventory;
	}
	
	
	
	
}
