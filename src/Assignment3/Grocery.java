package Assignment3;

public class Grocery extends Item {
	//variables, constructor here
	private boolean premiumShipping;
	private boolean perishable;
	public Grocery(String name, double price, int quantity, double weight,
			boolean premiumShipping, boolean perishable) {
		super(name, price, quantity, weight);
			this.premiumShipping = premiumShipping;
			this.perishable = perishable;
	}
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[5] = String.valueOf(premiumShipping);
		ret[6] = String.valueOf(perishable);
		return ret;
	}
	public double calculatePrice()
	{
		double ret = super.calculatePrice();
		if(premiumShipping){ret = ret *1.2;}
		return ret;
	}
}
