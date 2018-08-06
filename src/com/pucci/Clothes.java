package com.pucci;


/**
 * @author Joseph Bojovic J.
 *
 */

public class Clothes {

	private String name;
	private String qnt; //Tops Bottoms Shoes
	private String price;
	private String size; //Available product amount 
	private String gender;
	
	
	
	public Clothes(String gender, String name, String price, String qnt, String size) {
		super();
		this.gender = gender;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
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
	public String getQnt() {
		return qnt;
	}
	/**
	 * @param type the type to set
	 */
	public void setQnt(String qnt) {
		this.qnt = qnt;
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
	public String getSize() {
		return size;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return gender + "," + name + "," + price + "," + qnt + "," + size;
	}
	
	
	
	
}
