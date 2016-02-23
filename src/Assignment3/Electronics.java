/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

//Purpose: specialized shopping cart item
public class Electronics extends Item 
{		private boolean premiumShipping;
		private boolean fragile;
		private String state;
	
	/**
	 * Electronics constructor
	 * @param name
	 * @param price
	 * @param quantity
	 * @param weight
	 * @param fragile
	 * @param state
	 */
	public Electronics(String name, double price, int quantity, double weight,
			 boolean fragile, String state) 
	{
		super(name, price, quantity, weight);
			this.premiumShipping = fragile;
			this.fragile = fragile;
			this.state = state;
	}
	
	/**
	 * Puts traits of electronics into string array
	 * @return String array of electronics traits
	 */
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[0] = "ELECTRONICS";
		ret[5] = String.valueOf(calculatePrice());
		ret[6] = String.valueOf(fragile);
		ret[7] = state;
		return ret;
		
	}
	
	/**
	 * calculates price including shipping and sales tax(as applicable)
	 * @return final price of electronics item
	 */
	public double calculatePrice () 
	{
		double ret = super.calculatePrice();
		
		if(!state.equals("TX") && !state.equals("NM") && !state.equals("VA") && !state.equals("AK") && !state.equals("AZ"))
		{
			ret = ret * 1.1;
		}
		
		if(premiumShipping){ret = ret + (20 * weight * quantity) * 1.2;}
		else{ret = ret + (20 * weight * quantity);}
		
		return ret;
	}
	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
