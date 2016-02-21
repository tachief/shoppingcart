package Assignment3;

public class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name;
	protected int quantity;
	protected double price;
	protected double weight;
	protected double finalPrice;
// You will need a constructor (Why?). Create it here.
	public Item(String name, double price, int quantity, double weight)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.quantity = quantity;
	}
	
	public void addQuantity(int amount)
	{
		this.quantity += amount;
	}
	
	public String[] getTraits()
	{
		String[] ret = {name, Integer.toString(quantity),Double.toString(weight),
				Double.toString(finalPrice),Double.toString(price), "", "",""};
		return ret;
	}
	
	double calculatePrice () 
	{	
		return (20 * weight)*quantity;
	}
	
	String getName()
	{
		return name;
	}

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}

}
