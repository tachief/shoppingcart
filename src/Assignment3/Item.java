package Assignment3;

public class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name;
	
	protected double price;
	
	protected int quantity;
	
	
// You will need a constructor (Why?). Create it here.
	
	public double calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	

	public void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}
	
	public void addQuantity(int quantity)
	{
		this.quantity += quantity;
	}

}
