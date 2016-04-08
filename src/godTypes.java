/**
 * @author Elliot Lake
 * @Brief Loads all the god descriptions and type
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class godTypes 
{
	
	private String [] typeDescription;
	private String [] typeTemperament;
	private int noGodTypes;
	
	//============ Initialisation ===============
	/*
	 * 
	 * Generates descriptions and temperament of the various god types
	 * Allows there to be variable god kinds from a file
	 */
	public godTypes(String filename)
	{
		try
		{
			loadDescriptions(filename);
		}
		catch(IOException e)
		{
			System.out.println("FATAL ERROR : Couldn't load descriptions");
			
		}
	}
	
	private void loadDescriptions(String filename) throws IOException
	{
		int noLines, i;
		String rawString;
		File descriptorFile = new File(filename);
		String [] splitString;
		BufferedReader typeReader = new BufferedReader( new InputStreamReader(new FileInputStream(descriptorFile), "UTF8"));
		
		//Makes the descriptions etc. the right size, and gets the amount of god types
		rawString = typeReader.readLine();
		noLines = Integer.parseInt(rawString);
		this.noGodTypes = noLines;
		this.typeDescription = new String[noLines];
		this.typeTemperament = new String[noLines];
		
		for(i = 0; i < noLines; i++)//Loads the descriptions and temperament
		{
			rawString = typeReader.readLine();
			splitString = rawString.split(",");
			this.typeDescription[i] = splitString[0];
			this.typeTemperament[i] = splitString[1];
		}
		typeReader.close();
		
	}
	//Gets the number of god types
	public int getGodTypes()
	{
		return noGodTypes;
		
	}
	//Gets the description of the god type
	public String getDescription(int index)
	{
		return typeDescription[index];
	}
	//Gets the temperament of the god type
	public String getTemperament(int index)
	{
		return typeTemperament[index];
		
	}

}
