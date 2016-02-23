/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

//Class purpose is to encapsulate shopping cart item traits
public class Item implements Comparable<Item>
{
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name;
	protected int quantity;
	protected double price;
	protected double weight;
	protected double finalPrice;
// You will need a constructor (Why?). Create it here.
	
	/**
	 * Item constructor
	 * @param name name of item
	 * @param price price of item
	 * @param quantity quantity of item
	 * @param weight weight of item
	 */
	public Item(String name, double price, int quantity, double weight)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.quantity = quantity;
	};
	
	/**
	 * Places all of variables of Item into a string array
	 * @return String[] of item Item variables
	 */
	public String[] getTraits()
	{	
		//empty strings are place holders
		String[] ret = {"",name,Double.toString(price),
				Integer.toString(quantity),Double.toString(weight),
				Double.toString(finalPrice),"",""};
		return ret;
	}
	
	/**
	 * gets quantity of item
	 * @return quantity of item
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * Sets amount to item quantity
	 * @param amount amount to be added to item quantity
	 */
	public void setQuantity(int amount)
	{
		quantity = amount;
	}
	/**
	 * Calculates the basic price of item * quantity
	 * @return total price of item * quantity
	 */
	double calculatePrice () 
	{	
		//calculates item cost * quantity
		//tax/shipping costs are taken cared of in subclasses of Item
		return   price * quantity;
	}
	
	/**
	 * gets name of item
	 * @return String name of item
	 */
	String getName()
	{
		return name;
	}

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}
	
	/**compares names of two items
	 * @param item item to be compared to
	 */
	public int compareTo(Item item)
	{
		String compare =  item.getName();
		
		return this.name.compareTo(compare);
	}

}
