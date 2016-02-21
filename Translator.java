package Assignment3;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Translator
{
	ShoppingCart cart = new ShoppingCart();
	final static String[] STATES = 
		{
				"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", 
				"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", 
				"MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", 
				"NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", 
				"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
		};
	public void translate(String data)
	{
		ArrayList<String> dataList = parseInput(data);
		if(confirmCorrect(dataList))
		{
			execute(dataList, cart);
		}
		else
		{
			System.out.println("Unable to execute given inputs");
		}
	};
	
	public ArrayList<String> parseInput(String input)
	{
		StringTokenizer parser = new StringTokenizer(input);
		
		ArrayList<String> parsed = new ArrayList<String>();
		
		while(parser.hasMoreTokens())
		{
			parsed.add(parser.nextToken().toUpperCase());
		}
		
		return parsed;
		
	}
	
	public boolean confirmCorrect(ArrayList<String> input)
	{
		if(input.size() == 0){
			System.out.println("Empty inputs are NOT valid");
			return false;
		}
		int index = 0;
		if(input.get(index).equals( "INSERT"))
		{
			try
			{
				for(int i =0; i< input.size(); i++)
				{
					System.out.println(input.get(i));
				}
				index++;
				if(!input.get(index).equals("CLOTHING") && !input.get(index).equals("ELECTRONICS") && !input.get(index).equals("GROCERY"))
				{
					System.out.println("INCORRECT TYPE OF ITEM");
					System.out.println("Wrong inputs, try again");
					return false;
				}
				String itemType = input.get(index);
				//TODO: replace magic numbers with constants
				if(!isPositiveDouble(input.get(3)) || !isPositiveInteger(input.get(4)) || !isPositiveDouble(input.get(5)))
				{
					return false;
				}
				
				index = 6;			//index of first op field
				if(itemType.equals("CLOTHING"))
				{
					//should only have 6 fields
					if(input.size() != 6)
					{
						return false;
					}
				}
				else if(itemType.equals("ELECTRONICS"))
				{
					//should only have 8 fields
					if(input.size() != 8)
					{
						return false;
					}
					
					if (!input.get(index).equals("F") && !input.get(index).equals("F"))
					{
						return false;
					}
					index++;
					if(!isState(input.get(index)))
					{
						return false;
					}
					
				}
				else if(itemType.equals("GROCERY"))
				{
					//should only have 7 fields
					if(input.size() != 7)
					{
						return false;
					}
					if(!input.get(index).equals("NP") && !input.get(index).equals("P"))
					{
						return false;
					}
				}
				else
					return false;
				
			}
			catch(IndexOutOfBoundsException ioobe)
			{
				return false;
			}
		}
		else if(input.get(index).equals("SEARCH"))
		{
			if(input.size() != 2)
			{
				return false;
			}
		}
		else if(input.get(index).equals("DELETE"))
		{
			if(input.size() != 2)
			{
				return false;
			}
			
		}
		else if(input.get(index).equals("UPDATE"))
		{
			if(input.size() != 3)
			{
				return false;
			}
			index = 2;
			if(!isPositiveInteger(input.get(index)))
			{
				return false;
			}
			
		}
		else if(input.get(index).equals("PRINT"))
		{
			if(input.size() != 1)
			{
				return false;
			}
		}
		else{
			System.out.println("BAD INPUTS, " + input.get(index) + " IS NOT A VALID INPUT"); 
			System.out.println("Enter valid inputs");
			return false;
		}
		return true;
	}
	
	public boolean isPositiveInteger(String input)
	{
		int val;
		try
		{
			val = Integer.parseInt(input);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("This number is NOT valid");
			return false;
		}
		
		if(val < 0){
			System.out.println("Negative numbers are NOT allowed");
			return false;}
		
		return true;
	}
	
	public boolean isPositiveDouble(String input)
	{
		double val;
		try
		{
			val = Double.parseDouble(input);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("This is NOT a valid double");
			return false;
		}
		
		if(val < 0)
			return false;
		
		return true;
	}
	
	public boolean isState(String input)
	{
		for(String state : STATES)
		{
			if(input.equals(state))
				return true;
		}
		System.out.println("You're trying to ship to a state that doesn't exist");
		return false;
	}
	//TODO: insert portion and remove magic numbers
	public void execute(ArrayList<String> input, ShoppingCart cart)
	{
		String command = input.get(0);
		
		//not sure for insert since I used a String arraylist and parameter is for String array
		if(command.equals("INSERT"))
		{
			cart.insert(input);
		}
		else if(command.equals("SEARCH"))
		{
			cart.search(input.get(1));	
		}
		else if(command.equals("DELETE"))
		{
			cart.delete(input.get(1));
		}
		else if(command.equals("UPDATE"))
		{
			cart.update(input.get(1), Integer.parseInt(input.get(2)));
		}
		else if(command.equals("PRINT"))
		{
			cart.print();
		}
	}
}
	