package Assignment3;

import java.util.ArrayList;

public class Translator
{
	
	ArrayList<String> test = new ArrayList();
	
	
	
	public boolean confirmCorrect()
	{
		if(test.size() == 0)
			return false;
		
		int index = 0;
		if(test.get(index) == "INSERT")
		{
			try
			{
				index++;
				if(!test.get(index).equals("CLOTHING") && !test.get(index).equals("ELECTRONICS") && !test.get(index).equals("GROCERY"))
				{
					return false;
				}
				String itemType = test.get(index);
				//TODO: replace magic numbers with constants
				if(!isPositiveDouble(test.get(3)) || !isPositiveInteger(test.get(4)) || !isPositiveDouble(test.get(5)))
				{
					return false;
				}
				
				index = 6;			//index of first op field
				if(itemType.equals("CLOTHING"))
				{
					if(test.size() != 6)
					{
						return false;
					}
				}
				//TODO: Not done with electronics portion
				else if(itemType.equals("ELECTRONICS"))
				{
					if(test.size() != 8)
					{
						return false;
					}
					index++;
				}
				else if(itemType.equals("GROCERY"))
				{
					if(test.size() != 7)
					{
						return false;
					}
					if(!test.get(index).equals("NP") && !test.get(index).equals("P"))
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
		else if(test.get(index) == "SEARCH")
		{
			if(test.size() != 2)
			{
				return false;
			}
		}
		else if(test.get(index) == "DELETE")
		{
			if(test.size() != 2)
			{
				return false;
			}
			
		}
		else if(test.get(index) == "UPDATE")
		{
			if(test.size() != 3)
			{
				return false;
			}
			index = 2;
			if(!isPositiveInteger(test.get(index)))
			{
				return false;
			}
			
		}
		else if(test.get(index) == "PRINT")
		{
			if(test.size() > 1)
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
	
}