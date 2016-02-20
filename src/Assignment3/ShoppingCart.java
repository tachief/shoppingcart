package Assignment3;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> cart = new ArrayList<Item>();
	
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
	public void print()
	{
		System.out.println("The contents of the cart are: ");
		for(int i =0; i < cart.size();i++)
		{	
			String base = "" + i + ") ";
			String[] data = cart.get(i).getTraits();
			System.out.println(" ");
			System.out.println(base);
			if(cart.get(i) instanceof Grocery)
			{
				
			}
			if(cart.get(i) instanceof Clothing){}
			if(cart.get(i) instanceof Electronics){}
		}
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