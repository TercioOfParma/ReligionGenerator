/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package religiongenerator;
import java.util.Random;
/**
 *
 * @author Elliot Lake
 * @Brief Handles judging frequency of combination occurrence and the making these
 * combinations
 */
public class characterFrequencyGenerator 
{
    //==== Class Variables ====
    private float [] alphabetFrequencies;
    private String [] charCombinations;
     //==== Class Initialization ====
    public characterFrequencyGenerator()
    {
        alphabetFrequencies = new float[programConstants.ALPHABET_SIZE.getConstant()];
        charCombinations = new String[programConstants.ALPHABET_SIZE.getConstant() * 2];
    }
     // ===== Basic Functionality ======
    public void generateAlphabetFrequencies()
    {
        int i;
        Random frequencyGenerator = new Random();
        
        for(i = 0; i < programConstants.ALPHABET_SIZE.getConstant(); i++)
        {
            alphabetFrequencies[i] = frequencyGenerator.nextFloat() * i;
            frequencyGenerator.setSeed(frequencyGenerator.nextInt());
            
        }
    }
    public void generateCombinations()
    {
        int i;
        Random charGenerator = new Random();
        char [] tempCombination = new char[2];
        
        for(i = 0; i < programConstants.ALPHABET_SIZE.getConstant(); i++)
        {
            tempCombination[0] = (char)(charGenerator.nextInt(programConstants.ALPHABET_SIZE.getConstant()) + programConstants.MINIMUM_CHAR.getConstant());
            tempCombination[1] = (char)(charGenerator.nextInt(programConstants.ALPHABET_SIZE.getConstant()) + programConstants.MINIMUM_CHAR.getConstant());
            charCombinations[i] = new String(tempCombination);
            
        }
    }
    public int findIndexClosest(float generatedValue)
    {
         int i;
         int preferredIndex = 0;
         float preferredIndexValue = 1000.0f;
         for(i = 0; i < programConstants.ALPHABET_SIZE.getConstant(); i++)
         {
             if(Math.abs(generatedValue - preferredIndexValue) > Math.abs(generatedValue - alphabetFrequencies[i]))
             {
                 preferredIndex = i;
                 preferredIndexValue = alphabetFrequencies[i];
             }
                     
         }
         
         return preferredIndex;
    }
    public String returnCombination(int index)
    {
        return charCombinations[index];
    }
}
