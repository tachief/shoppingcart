package Assignment3;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Translator
{
	final static String[] STATES = 
		{
				"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", 
				"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", 
				"MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", 
				"NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", 
				"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
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
		if(input.size() == 0)
			return false;
		
		int index = 0;
		if(input.get(index) == "INSERT")
		{
			try
			{
				index++;
				if(!input.get(index).equals("CLOTHING") && !input.get(index).equals("ELECTRONICS") && !input.get(index).equals("GROCERY"))
				{
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
					if(input.size() != 6)
					{
						return false;
					}
				}
				//TODO: Not done with electronics portion
				else if(itemType.equals("ELECTRONICS"))
				{
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
		else if(input.get(index) == "SEARCH")
		{
			if(input.size() != 2)
			{
				return false;
			}
		}
		else if(input.get(index) == "DELETE")
		{
			if(input.size() != 2)
			{
				return false;
			}
			
		}
		else if(input.get(index) == "UPDATE")
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
		else if(input.get(index) == "PRINT")
		{
			if(input.size() > 1)
			{
				return false;
			}
		}
		else
			return false;
		
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
			return false;
		}
		
		if(val < 0)
			return false;
		
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
		
		return false;
	}
	
	public void execute(ArrayList<String> input)
	{
		String command = input.get(0);
		
		if(command.equals("INSERT"))
		{
			
		}
		else if(command.equals("SEARCH"))
		{
			
		}
		else if(command.equals("DELETE"))
		{
			
		}
		else if(command.equals("UPDATE"))
		{
			
		}
		else if(command.equals("PRINT"))
		{
			
		}
	}
	
}