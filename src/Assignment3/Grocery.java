/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

//Purpose: specialized shopping cart item
public class Grocery extends Item {
	//variables, constructor here
	private boolean premiumShipping;
	private boolean perishable;
	
	/**
	 * Grocery constructor
	 * @param name
	 * @param price
	 * @param quantity
	 * @param weight
	 * @param perishable
	 */
	public Grocery(String name, double price, int quantity, double weight
			, boolean perishable) {
		super(name, price, quantity, weight);
			this.premiumShipping = perishable;
			this.perishable = perishable;
	}
	
	/**
	 * Puts traits of grovery item into String array
	 * @return String array of grocery traits
	 */
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[0] = "GROCERIES";
		ret[5] = String.valueOf(calculatePrice());
		ret[6] = String.valueOf(perishable);
		return ret;
	}
	
	/**
	 * Calculates price including shipping
	 * @return final price of grocery
	 */
	public double calculatePrice()
	{
		double ret = super.calculatePrice();
		if(premiumShipping){ret = ret + (20 * weight * quantity) * 1.2;}
		else{ret = ret + (20 * weight * quantity) * 1.2;}
		return ret;
	}
}
