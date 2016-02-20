package Assignment3;

import java.util.*;


public class ShoppingCart
{
	private ArrayList<Item> cart = new ArrayList<Item>(); 
	
	
	public int search(String name)
	{
		int counter = 0;
		for(int i = 0; i < cart.size(); i++)
		{
			if(cart.get(i).name.equals(name))
				counter++;
		}
		  
		return counter;
		}
	
	public String update(String name, int quantity)
	{
		if(search(name) == 0)
		{
			return "There are no " + name + " in the cart";
		}
		int i = 0;
		while(!cart.get(i).equals(name))
			i++;
		
		cart.get(i).addQuantity(quantity);
		
		return quantity + " have been added to the cart";
	}
	
	
}