/**
 * Classes to drive shopping cart
 * Solves EE422C programming assignment #3
 * @author Tauseef Aziz
 * @author John Polarinakis
 * @version 1.00 2016-02-22
 */

package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Purpose: logic behind the shopping cart
public class ShoppingCartDriver 
	{

	  public static void main(String[] args) 
	  {
		//Open file; file name specified in args (command line)
		  	//copty from prog 1?
		if (args.length != 1) 
			{
				System.err.println ("Error: Incorrect number of command line arguments");
				System.exit(-1);
			}
		processLinesInFile (args[0]);
		//Parse input, take appropriate actions.
		  	//PARSE
		  	//VERIFY
		  	//TAKE ACTION
	  }
	  
	  /**
	   * Shopping cart input processor
	   * @param filename file from which input is processed
	   */
	  public static void processLinesInFile (String filename) 
	  { 

		  Translator translator = new Translator(); 
		  try 
		  {
			  FileReader freader = new FileReader(filename);
			  BufferedReader reader = new BufferedReader(freader);
				
			  for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			  {
				  translator.translate(s);

			  }
		  } 
		  catch (FileNotFoundException e) 
		  {
			  System.err.println ("Error: File not found. Exiting...");
			  e.printStackTrace();
			  System.exit(-1);
		  }catch (IOException e) 
		  {
			  System.err.println ("Error: IO exception. Exiting...");
			  e.printStackTrace();
			  System.exit(-1);
		  }
	  }
}
