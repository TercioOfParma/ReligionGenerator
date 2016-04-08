/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
/**
 *
 * @author Elliot Lake
 * @brief This will govern how the gods are stored and also how they
 * are generated
 */
public class God 
{
    //==== Class Variables ====
    private String godName, godDescription;
    private String godTemperament;
     //==== Class Initialization ====
    public God()
    {
        this.godName = new String();
        this.godDescription = new String();
    }
    // ===== GETTERS AND SETTERS ======
    // ===== Basic Functionality ======
    //This takes in the script of the god's name, and generates a god name based on a character
    //frequency generator and script value
    public void generateGodName( characterFrequencyGenerator nameCharDecider)
    {
        char [] temporaryName;
        Random nameGen = new Random();
        int nameSize, i;
        float frequencyCompare;
        String temporaryCombination;
        
        temporaryCombination = new String();
        //The below is so there are an even number of characters
        nameSize = ((nameGen.nextInt(programConstants.MAXIMUM_NAME_SIZE.getConstant()) /2) *2) + 2;
        temporaryName = new char[nameSize];

        for(i = 0; i < nameSize / 2; i++)//Generates the names characters two at a time
        {
        	//Chooses a value based on a generated float and pregenerated frequency values
            frequencyCompare = nameGen.nextFloat() * nameGen.nextInt(programConstants.LATIN_ALPHABET_SIZE.getConstant());
            //gets valid string
            temporaryCombination = nameCharDecider.returnCombination(nameCharDecider.findIndexClosest(frequencyCompare));
            temporaryName[2*i] = temporaryCombination.charAt(0);
            temporaryName[2*i + 1] = temporaryCombination.charAt(1);
            nameGen.setSeed(nameGen.nextInt());//Resets seed for more randomised names, since random generator is based on time initially
        }
       godName = new String(temporaryName);
    }
    //Generates the god's description based on its type, and if the religion is monotheism
    public void generateGodDescription(int godType, godTypes godDescriptor, boolean monotheism)
    {
    	String temp;
    	int i;
    	Random genderDecide = new Random();
    	int gender = genderDecide.nextInt(3);
    	switch(gender)//Decides gender
    	{
    		case 1:
    			temp = String.format("God of ");
    			break;
    		case 2:
    			temp = String.format("Goddess of ");
    			break;
    		default:
    			temp = String.format("God of ");
    			break;
    	}
    	if(monotheism == true)
    	{
    		temp = String.format("%s%s", temp, "God of All");
    		
    	}
    	else
    	{
    		temp = String.format("%s%s", temp, godDescriptor.getDescription(godType));
    	}
    	godTemperament = godDescriptor.getTemperament(godType);
        this.godDescription = temp;
    }
    //Gets the god's name
    public String getGodName()
    {
        return godName;
        
    }
    //Gets the god's description
    public String getGodDescription()
    {
        return godDescription;
        
    }
}
