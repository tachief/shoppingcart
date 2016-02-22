package Assignment3;

public class Electronics extends Item 
{		private boolean premiumShipping;
		private boolean fragile;
		private String state;
	public Electronics(String name, double price, int quantity, double weight,
			 boolean fragile, String state) {
		super(name, price, quantity, weight);
			this.premiumShipping = fragile;
			this.fragile = fragile;
			this.state = state;
	}
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[0] = "ELECTRONICS";
		ret[5] = String.valueOf(calculatePrice());
		ret[6] = String.valueOf(fragile);
		ret[7] = state;
		return ret;
		
	}
	double calculatePrice () 
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
