package Assignment3;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	public Clothing(String name, double price, int quantity, double weight) {
		super(name, price, quantity, weight);

		}
	public String[] getTraits()
	{
		
		String[] ret = super.getTraits();
		ret[0] = "CLOTHING";
		ret[5] = String.valueOf(calculatePrice());
		return ret;
	}
	double calculatePrice () 
	{
		double ret = super.calculatePrice();
		ret = ret + (price * 1.1);
		return ret;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
