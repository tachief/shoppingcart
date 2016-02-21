package Assignment3;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	private String state;
	
	public Clothing(String name, double price, int quantity, double weight, String state) {
		super(name, price, quantity, weight);
		this.state = state;
	}
	
	public String[] getTraits()
	{
		String[] ret = super.getTraits();
		ret[5] = state;
		return ret;
	}
	
	double calculatePrice () 
	{
		double ret = super.calculatePrice();
		if(state.equals("TX")){}
		else if(state.equals("NM")){}
		else if(state.equals("VA")){}
		else if(state.equals("AK")){}
		else if(state.equals("AZ")){}
		else{ ret = ret * 1.1;}
		return ret;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
