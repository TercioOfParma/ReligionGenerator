/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Elliot Lake
 * @Brief Handles judging frequency of combination occurrence and the making these
 * combinations
 * @Todo Change the branching if statements to allow for more scripts in a versatile
 * way without modifiying the code
 */
public class characterFrequencyGenerator 
{
    //==== Class Variables ====
    private float [] alphabetFrequencies;
    private String [] charCombinations;
    int scriptNo;
     //==== Class Initialization ===
    public characterFrequencyGenerator(int scriptNo)
    {
    	this.scriptNo = scriptNo;
    	if(scriptNo == programConstants.ARAMAIC.getConstant())//This allows for multiple script god names
    	{
    		alphabetFrequencies = new float[programConstants.ARAMAIC_ALPHABET_SIZE.getConstant()];
    		charCombinations = new String[programConstants.ARAMAIC_ALPHABET_SIZE.getConstant()];
    	}
    	else
    	{
    		alphabetFrequencies = new float[programConstants.LATIN_ALPHABET_SIZE.getConstant()];
    		charCombinations = new String[programConstants.LATIN_ALPHABET_SIZE.getConstant()];
    	}
    }
     // ===== Basic Functionality ======
    public void generateAlphabetFrequencies()
    {
        int i;
        Random frequencyGenerator = new Random();
        if(this.scriptNo == programConstants.ARAMAIC.getConstant())
        {
        	for(i = 0; i < programConstants.ARAMAIC_ALPHABET_SIZE.getConstant(); i++)
        	{
        		alphabetFrequencies[i] = frequencyGenerator.nextFloat() * i;
        		frequencyGenerator.setSeed(frequencyGenerator.nextInt());
		
        	}
	    
        }
        else
        {
        	for(i = 0; i < programConstants.LATIN_ALPHABET_SIZE.getConstant(); i++)
        	{
        		alphabetFrequencies[i] = frequencyGenerator.nextFloat() * i;
        		frequencyGenerator.setSeed(frequencyGenerator.nextInt());
		
        	}
        }
    }
    public void generateCombinations()
    {
        int i;
        Random charGenerator = new Random();
        char [] tempCombination = new char[2];
        if(this.scriptNo == programConstants.ARAMAIC.getConstant())
        {
        	for(i = 0; i < programConstants.ARAMAIC_ALPHABET_SIZE.getConstant(); i++)
        	{
        		tempCombination[0] = (char)(charGenerator.nextInt(programConstants.ARAMAIC_ALPHABET_SIZE.getConstant()) 
        				+ programConstants.ARAMAIC_MINIMUM_CHAR.getConstant());
        		tempCombination[1] = (char)(charGenerator.nextInt(programConstants.ARAMAIC_ALPHABET_SIZE.getConstant()) + 
        				programConstants.ARAMAIC_MINIMUM_CHAR.getConstant());
        		charCombinations[i] = new String(tempCombination);
            
        	} 
        }
        else
        {
        	for(i = 0; i < programConstants.LATIN_ALPHABET_SIZE.getConstant(); i++)
        	{
        		tempCombination[0] = (char)(charGenerator.nextInt(programConstants.LATIN_ALPHABET_SIZE.getConstant()) 
        				+ programConstants.LATIN_MINIMUM_CHAR.getConstant());
        		tempCombination[1] = (char)(charGenerator.nextInt(programConstants.LATIN_ALPHABET_SIZE.getConstant()) + 
        				programConstants.LATIN_MINIMUM_CHAR.getConstant());
        		charCombinations[i] = new String(tempCombination);
            
        	}
        }
    }
    public int findIndexClosest(float generatedValue)
    {
         int i;
         int preferredIndex = 0;
         float preferredIndexValue = 1000.0f;
         if(this.scriptNo == programConstants.ARAMAIC.getConstant())
         {
        	 for(i = 0; i < programConstants.ARAMAIC_ALPHABET_SIZE.getConstant(); i++)
        	 {
        		 if(Math.abs(generatedValue - preferredIndexValue) > Math.abs(generatedValue - alphabetFrequencies[i]))
        		 {
        			 preferredIndex = i;
        			 preferredIndexValue = alphabetFrequencies[i];
        		 }
                     
        	 }
         }
         else
         {
        	 for(i = 0; i < programConstants.LATIN_ALPHABET_SIZE.getConstant(); i++)
        	 {
        		 if(Math.abs(generatedValue - preferredIndexValue) > Math.abs(generatedValue - alphabetFrequencies[i]))
        		 {
        			 preferredIndex = i;
        			 preferredIndexValue = alphabetFrequencies[i];
        		 }
                     
        	 }
         }
         return preferredIndex;
    }
    public String returnCombination(int index)
    {
        return charCombinations[index];
    }
}
