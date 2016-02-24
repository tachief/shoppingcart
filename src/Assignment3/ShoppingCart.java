/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

import java.util.ArrayList;
import java.util.Collections;

//Class encapsulates shopping cart properties and methods
public class ShoppingCart
{
	
	private ArrayList<Item> cart = new ArrayList<Item>();
	private final int tPlace = 1;
	private final int nPlace = 2;
	private final int pPlace = 3;
	private final int qPlace = 4;
	private final int wPlace = 5;
	private final int fPlace = 6;
	private final int sPlace = 7;		
	
	public int delete(String data)
	{
		ArrayList<Integer> remove = new ArrayList<Integer>();
		int size = cart.size();
		int ret = 0;
		for(int i =0; i < size; i++)
		{
			
			if(cart.get(i).getName().equals(data))
			{
				remove.add(i);;
				ret++;
			}
		}
			Collections.reverse(remove);
			for(int j = 0; j < remove.size(); j++)
			{
				int rVal = remove.get(j);
				cart.remove(rVal);
			}
		
		
		return ret;
	}
	
	
	public void insert(ArrayList<String> data)
	{
		double price = Double.valueOf(data.get(pPlace));
		int quantity = Integer.valueOf(data.get(qPlace));
		double weight = Double.valueOf(data.get(wPlace));

		for(int i =0; i< data.size(); i++)
		{
			System.out.println(data.get(i));
		}
		
		if(data.get(tPlace).equals("ELECTRONICS"))
		{
			//boolean fragile = Boolean.valueOf(data.get(fPlace));
			boolean fragile;
			if(data.get(fPlace).equals("F"))
				fragile = true;
			else
				fragile = false;
			
			Electronics toAdd = new Electronics(data.get(nPlace), price,quantity,weight,fragile,data.get(sPlace));
			cart.add(toAdd);
		}
		if(data.get(tPlace).equals("CLOTHING"))
		{
			Clothing toAdd = new Clothing(data.get(nPlace),price,quantity,weight);
			cart.add(toAdd);
			
		}
		if(data.get(tPlace).equals("GROCERIES"))
		{
			//boolean perishable = Boolean.valueOf(data.get(fPlace));
			boolean perishable;
			if(data.get(fPlace).equals("P"))
				perishable = true;
			else
				perishable = false;
			
			Grocery toAdd = new Grocery(data.get(nPlace),price,quantity,weight,perishable);
			cart.add(toAdd);
		}
		
		Collections.sort(cart);
	}
	
	public void print()
	{	
		final int pricePlace = 2;
		final int quantityPlace = 3;
		final int weightPlace = 4;
		final int fpPlace = 5;
		double totalPrice =0;
		String ask = " ** ";
		String tab = "\t";
		
		ArrayList<Item> sortedCart = cart;
		Collections.sort(sortedCart);
		System.out.println("************************************");
		System.out.println("**The contents of the cart are: **");
		for(int i =0; i < sortedCart.size();i++)
		{	
	
			String base = ask + "" + i + ") " + sortedCart.get(i).getName() + ask ;
			String[] data = sortedCart.get(i).getTraits();
			System.out.println(" ");
			System.out.println(base);
			System.out.println(ask + tab + "Price: " + data[pricePlace] + ask );
			System.out.println(ask + tab + "Quantity: " + data[quantityPlace]+ ask);
			System.out.println(ask + tab + "Weight: " + data[weightPlace]+ ask);

			if(data[0].equals("GROCERIES"))
			{
			System.out.println(ask + tab + "Premium Shipping: " + data[fPlace] + ask);
			System.out.println(ask + tab + "Perishable: " + data[fPlace] + ask);
			}
			if(data[0].equals("CLOTHING"))
			{
			
			}
			if(data[0].equals("ELECTRONICS"))
			{
			System.out.println(ask + tab + "Premium Shipping: " + data[fPlace] + ask);
			System.out.println(ask + tab + "Fragile: " + data[fPlace] + ask);
			System.out.println(ask + tab + "State: " + data[sPlace] + ask);
			}
			
			System.out.println(ask + tab + "Final Price: " + data[fpPlace]+ ask);
			totalPrice += Double.valueOf(data[fpPlace]);
		}
		System.out.println("Total Price of Shopping Cart is: " + totalPrice);
		System.out.println("************************************");
	}
	
	/**
	 * Counts up all items' names that equal input
	 * @param input item to find
	 * @return total quantity of items of same name as input found
	 */
	public int search(String input)
	{
		int counter = 0;
		for(int i = 0; i < cart.size(); i++)
		{
			if(cart.get(i).getName().equals(input))
				counter = counter + cart.get(i).getQuantity();
		}
		
		return counter;
	}
	
	/**
	 * Updates first instance item's name to new amount
	 * @param input	name of item to update
	 * @param amount new quantity to set item to
	 */
	public void update(String input, int amount)
	{
		System.out.println();
		System.out.println("UPDATE:");
		if(search(input) == 0)
		{
			System.out.println("There are no " + input + " objects in the cart");
			System.out.println();
			return;
		}
		int index = 0;
		while(index < cart.size())
		{
			if(cart.get(index).getName().equals(input))
				break;
			
			index++;
		}
		cart.get(index).setQuantity(amount);
		
		System.out.println("There are now " + cart.get(index).getQuantity() 
				+ " " +  cart.get(index).name + " object(s) for its first instance in the cart");
		System.out.println();
	}

	
}