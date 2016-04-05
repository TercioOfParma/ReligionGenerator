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
    public void generateGodName(int scriptNo)
    {
        char [] temporaryName;
        Random nameGen = new Random();
        characterFrequencyGenerator nameCharDecider = new characterFrequencyGenerator(scriptNo);
        int nameSize, i;
        float frequencyCompare;
        String temporaryCombination;
        
        temporaryCombination = new String();
        //The below is so there are an even number of characters
        nameSize = ((nameGen.nextInt(programConstants.MAXIMUM_NAME_SIZE.getConstant()) /2) *2) + 2;
        temporaryName = new char[nameSize];
        nameCharDecider.generateAlphabetFrequencies();
        nameCharDecider.generateCombinations();
        for(i = 0; i < nameSize / 2; i++)
        {
            frequencyCompare = nameGen.nextFloat() * nameGen.nextInt(programConstants.LATIN_ALPHABET_SIZE.getConstant());
            temporaryCombination = nameCharDecider.returnCombination(nameCharDecider.findIndexClosest(frequencyCompare));
            temporaryName[2*i] = temporaryCombination.charAt(0);
            temporaryName[2*i + 1] = temporaryCombination.charAt(1);
            nameGen.setSeed(nameGen.nextInt());
        }
       godName = new String(temporaryName);
    }
    public void generateGodDescription(int godType, godTypes godDescriptor)
    {
    	String temp;
    	int i;
    	Random genderDecide = new Random();
    	int gender = genderDecide.nextInt(3);
    	switch(gender)
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
    	temp = String.format("%s%s", temp, godDescriptor.getDescription(godType));
    	godTemperament = godDescriptor.getTemperament(godType);
        this.godDescription = temp;
    }
    public String getGodName()
    {
        return godName;
        
    }
    public String getGodDescription()
    {
        return godDescription;
        
    }
}
