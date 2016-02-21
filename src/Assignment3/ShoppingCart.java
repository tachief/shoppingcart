package Assignment3;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<Item> cart = new ArrayList<Item>();
	private final int nPlace = 1;
	private final int pPlace = 2;
	private final int qPlace = 3;
	private final int wPlace = 4;
	private final int psPlace = 5;
	private final int fPlace = 6;
	private final int sPlace = 7;
	private final int csPlace = 5;
	
	public int delete(String data)
	{
		int ret = 0;
		for(int i =0; i < cart.size(); i++)
		{
			if(cart.get(i).getName().equals(data))
			{
				cart.remove(cart.get(i));
				ret++;
			}
		}
		return ret;
	}

	public void insert(String data[])
	{
		double price = Double.valueOf(data[pPlace]);
		int quantity = Integer.valueOf(data[qPlace]);
		double weight = Double.valueOf(data[wPlace]);

		
		if(data[nPlace].equals("ELECTRONICS"))
		{
			boolean pShipping = Boolean.valueOf(data[psPlace]);
			boolean fragile = Boolean.valueOf(data[fPlace]);
			Electronics toAdd = new Electronics(data[nPlace], price,quantity,weight,pShipping,fragile,data[sPlace]);
			cart.add(toAdd);
		}
		if(data[nPlace].equals("CLOTHING"))
		{
			Clothing toAdd = new Clothing(data[nPlace],price,quantity,weight,data[csPlace]);
			cart.add(toAdd);
			
		}
		if(data[nPlace].equals("GROCERY"))
		{
			boolean pShipping = Boolean.valueOf(data[psPlace]);
			boolean perishable = Boolean.valueOf(data[fPlace]);
			Grocery toAdd = new Grocery(data[nPlace],price,quantity,weight,pShipping,perishable);
			cart.add(toAdd);
		}
	}
	public void print()
	{	
		final int pricePlace = 4;
		final int quantityPlace = 1;
		final int weightPlace = 2;
		final int fpPlace = 3;
		double totalPrice =0;
		String ask = " ** ";
		String tab = "\t";
		ArrayList<Item> sortedCart = sort(cart);
		System.out.println("************************************");
		System.out.println("**The contents of the cart are: **");
		for(int i =0; i < cart.size();i++)
		{	
	
			String base = ask + "" + i + ") " + sortedCart.get(i).getName() + ask ;
			String[] data = cart.get(i).getTraits();
			System.out.println(" ");
			System.out.println(base);
			System.out.println(ask + tab + "Price: " + data[pricePlace] + ask );
			System.out.println(ask + tab + "Quantity: " + data[quantityPlace]+ ask);
			System.out.println(ask + tab + "Weight: " + data[weightPlace]+ ask);

			if(cart.get(i) instanceof Grocery)
			{
			System.out.println(ask + tab + "Premium Shipping: " + data[psPlace] + ask);
			System.out.println(ask + tab + "Perishable: " + data[fPlace] + ask);
			}
			if(cart.get(i) instanceof Clothing)
			{
			System.out.println(ask + tab + "Shipping to: " + data[csPlace] + ask);
			}
			if(cart.get(i) instanceof Electronics)
			{
			System.out.println(ask + tab + "Premium Shipping: " + data[psPlace] + ask);
			System.out.println(ask + tab + "Perishable: " + data[fPlace] + ask);
			System.out.println(ask + tab + "Perishable: " + data[sPlace] + ask);
			}
			System.out.println(ask + tab + "Final Price: " + data[fpPlace]+ ask);
			totalPrice += Integer.valueOf(data[fpPlace]);
			System.out.println("Total Price of Shopping Cart is: " + totalPrice);
			System.out.println("************************************");
		}
	}

	
	public int search(String input)
	{
		int counter = 0;
		for(int i = 0; i < cart.size(); i++)
		{
			if(cart.get(i).equals(input))
				counter++;
		}
		
		return counter;
	}
	
	public String update(String input, int amount)
	{
		if(search(input) == 0)
		{
			return "There are no " + input + " in the cart"; 
		}
		int index = 0;
		while(index < cart.size())
		{
			if(cart.get(index).equals(input))
				break;
			
			index++;
		}
		cart.get(index).addQuantity(amount);
		
		return "There are now " + cart.get(index).quantity 
				+ " " +  cart.get(index).name + " in the cart";
	}

	public ArrayList<Item> sort(ArrayList<Item> data)
	{
		ArrayList<Item> ret = new ArrayList<Item>();
		int size = data.size();
		
		for(int j = 0; j< size; j++){
		String next = data.get(j).getName();
		int nextPlace = 0;
		for(int i =0; i< data.size();i++)
		{
			if(data.get(i).getName().compareTo(next) < 1)
			{
				nextPlace = i;
				next = data.get(i).getName();
			}
		}
		ret.add(data.get(nextPlace));
		data.remove(data.get(nextPlace));
		}
		return ret;

	}

	
}

/*	public Item findItem(String data){
for(int i =0;i<cart.size();i++){
	if(cart.get(i).getName() == data){
		return cart.get(i);}
}
	// the below constructor is not allowed
	Item newItem = new Item(data);
	cart.add(newItem);
    return newItem;
}*/