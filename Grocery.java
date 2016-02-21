package Assignment3;

public class Grocery extends Item {
	//variables, constructor here
	private boolean premiumShipping;
	private boolean perishable;
	public Grocery(String name, double price, int quantity, double weight
			, boolean perishable) {
		super(name, price, quantity, weight);
			this.premiumShipping = perishable;
			this.perishable = perishable;
	}
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[0] = "GROCERIES";
		ret[6] = String.valueOf(perishable);
		return ret;
	}
	public double calculatePrice()
	{
		double ret = super.calculatePrice();
		if(premiumShipping){ret = ret *1.2;}
		ret = ret + price;
		return ret;
	}
}
