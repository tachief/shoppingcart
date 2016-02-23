/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

import java.util.ArrayList;
import java.util.StringTokenizer;

//Purpose: translates input into commands
public class Translator
{
	final static int OP_FIELD_ONE = 6;		//proper input will contain info about perishable or fragile
	
	final static int INS_CLOTH_SIZE = 6;	//correct # inputs insert of clothing should have
	final static int INS_ELEC_SIZE = 8;		//correct # inputs insert of electronics should have
	final static int INS_GROC_SIZE = 7;		//correct # inputs insert of groceries should have
	
	final static int SEARCH_SIZE = 2;		//correct # inputs for search
	final static int DEL_SIZE = 2;			//correct # inputs for delete
	final static int UPDATE_SIZE = 3;		//correct # inputs for update
	final static int PRINT_SIZE = 1;		//correct # inputs for print
	
	final static int INS_NAME_INDEX = 2;		//name index for insert
	final static int INS_PRICE_INDEX = 3;		//price index for insert
	final static int INS_QUANT_INDEX = 4;		//quantity index for insert
	final static int INS_WT_INDEX = 5;			//weight index for insert
	
	final static int SEARCH_NAME_INDEX = 1;		//name index for search
	final static int DEL_NAME_INDEX = 1;		//name index for delete
	final static int UPDATE_NAME_INDEX = 1;		//name index for update
	
	
	final static String[] STATES = 
		{
				"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", 
				"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", 
				"MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", 
				"NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", 
				"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
		};
	
	private ShoppingCart cart = new ShoppingCart();
	
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
	
	/**
	 * Parses string by putting words into array
	 * Words are considered any group of chars separated by a space
	 * @param input String to be parsed
	 * @return ArrayList of parsed input
	 */
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
	
	/**
	 * Analyzes input for proper form/syntax
	 * Does not check for validity of eventual command(e.g deleting an item that does not exist)
	 * @param input	ArrayList of input to be analyzed
	 * @return true if syntactically correct input, false if not
	 */
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
				if(!input.get(index).equals("CLOTHING") && !input.get(index).equals("ELECTRONICS") && !input.get(index).equals("GROCERIES"))
				{
					System.out.println("INCORRECT TYPE OF ITEM");
					System.out.println("Wrong inputs, try again");
					return false;
				}
				String itemType = input.get(index);
				//TODO: replace magic numbers with constants
				if(!isPositiveDouble(input.get(INS_PRICE_INDEX)) || !isPositiveInteger(input.get(INS_QUANT_INDEX)) || !isPositiveDouble(input.get(INS_WT_INDEX)))
				{
					return false;
				}
				
				index = OP_FIELD_ONE;			//index of first op field
				if(itemType.equals("CLOTHING"))
				{
					//should only have 6 fields
					if(input.size() != INS_CLOTH_SIZE)
					{
						return false;
					}
				}
				else if(itemType.equals("ELECTRONICS"))
				{
					//should only have 8 fields
					if(input.size() != INS_ELEC_SIZE)
					{
						return false;
					}
					
					if (!input.get(index).equals("F") && !input.get(index).equals("NF"))
					{
						return false;
					}
					index++;
					if(!isState(input.get(index)))
					{
						return false;
					}
					
				}
				else if(itemType.equals("GROCERIES"))
				{
					//should only have 7 fields
					if(input.size() != INS_GROC_SIZE)
					{
						return false;
					}
					//last field contains info about perishable
					if(!input.get(index).equals("P") && !input.get(index).equals("NP"))
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
			if(input.size() != SEARCH_SIZE)
			{
				return false;
			}
		}
		else if(input.get(index).equals("DELETE"))
		{
			if(input.size() != DEL_SIZE)
			{
				return false;
			}
			
		}
		else if(input.get(index).equals("UPDATE"))
		{
			if(input.size() != UPDATE_SIZE)
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
			if(input.size() != PRINT_SIZE)
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
	
	/**
	 * Checks if string can be parsed to positive int value
	 * @param input String to check if positive int
	 * @return true if input is positive int value, false if not
	 */
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
	
	/**
	 * Checks if string is positive double value
	 * @param input String to check if positive double value
	 * @return true if positive double value, false if not
	 */
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
	
	/**
	 * Checks input to see if it is valid US state
	 * @param input input to check if valid US state abbreviation
	 * @return true if valid state, false if not
	 */
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
	
	/**
	 * Executes a shopping cart command
	 * precondition: assumes that input is a syntactically correct command
	 * @param input command to execute
	 * @param cart shoppping cart to modify/summarize with command
	 */
	public void execute(ArrayList<String> input, ShoppingCart cart)
	{
		String command = input.get(0);
		
		
		if(command.equals("INSERT"))
		{
			cart.insert(input);
		}
		else if(command.equals("SEARCH"))
		{
			System.out.println();
			System.out.println("SEARCH:");
			int findings = cart.search(input.get(SEARCH_NAME_INDEX));
			if(findings == 0)
			{
				System.out.println("There are no " + input.get(SEARCH_NAME_INDEX) + " object(s) in the cart");
				System.out.println();
			}
			else
			{
				System.out.println("There is/are " + findings + " " + input.get(SEARCH_NAME_INDEX) +  " object(s) in the cart");
				System.out.println();
			}
			
		}
		else if(command.equals("DELETE"))
		{
			cart.delete(input.get(DEL_NAME_INDEX));
		}
		else if(command.equals("UPDATE"))
		{
			cart.update(input.get(UPDATE_NAME_INDEX), Integer.parseInt(input.get(2)));
		}
		else if(command.equals("PRINT"))
		{
			cart.print();
		}
	}
}
	