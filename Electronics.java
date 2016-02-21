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
		ret[6] = String.valueOf(fragile);
		ret[7] = state;
		return ret;
		
	}
	double calculatePrice () 
	{
		double ret = super.calculatePrice();
		if(premiumShipping){ret = ret * 1.2;}
		if(state.equals("TX")){}
		else if(state.equals("NM")){ret = ret + price;}
		else if(state.equals("VA")){ret = ret + price;}
		else if(state.equals("AK")){ret = ret + price;}
		else if(state.equals("AZ")){ret = ret + price;}
		else{ ret = ret + (price * 1.1);}
		return ret;
	}
	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
