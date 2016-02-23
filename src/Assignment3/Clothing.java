/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

//Purpose: specialized shopping cart item
public class Clothing extends Item 
{
	// variables, constructors as necessary
	/**
	 * Clothing constructor
	 * @param name
	 * @param price
	 * @param quantity
	 * @param weight
	 */
	public Clothing(String name, double price, int quantity, double weight) 
	{
		super(name, price, quantity, weight);

	}
	
	/**
	 * Gets variables of clothing and puts them into string array
	 * @return String array of clothing traits
	 */
	public String[] getTraits()
	{
		
		String[] ret = super.getTraits();
		ret[0] = "CLOTHING";
		ret[5] = String.valueOf(calculatePrice());
		return ret;
	}
	
	/**
	 * calculates price including shipping and sales tax
	 * @return final price of clothing
	 */
	public double calculatePrice () 
	{
		double ret = super.calculatePrice();
		ret = (ret * 1.1) + (20 * weight * quantity);
		return ret;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
