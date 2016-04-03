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
 * @brief This will govern how the gods are stored and also how they
 * are generated
 */
public class God 
{
    //==== Class Variables ====
    private String godName, godDescription;
    public int value;
     //==== Class Initialization ====
    public God()
    {
        this.godName = new String();
        this.godDescription = new String();
    }
    // ===== GETTERS AND SETTERS ======
    // ===== Basic Functionality ======
    public void generateGodName()
    {
        char [] temporaryName;
        Random nameGen = new Random();
        characterFrequencyGenerator nameCharDecider = new characterFrequencyGenerator();
        int nameSize, i;
        float frequencyCompare;
        String temporaryCombination = new String();
        nameSize = nameGen.nextInt(programConstants.MAXIMUM_NAME_SIZE.getConstant()) + 2;
        temporaryName = new char[nameSize];
        nameCharDecider.generateAlphabetFrequencies();
        nameCharDecider.generateCombinations();
        for(i = 0; i < nameSize / 2; i++)
        {
            frequencyCompare = nameGen.nextFloat() * nameGen.nextInt(programConstants.ALPHABET_SIZE.getConstant());
            temporaryCombination = nameCharDecider.returnCombination(nameCharDecider.findIndexClosest(frequencyCompare));
            
            temporaryName[2*i] = temporaryCombination.charAt(0);
            temporaryName[2*i + 1] = temporaryCombination.charAt(1);
            nameGen.setSeed(nameGen.nextInt());
        }
       godName = new String(temporaryName);
    }
    public void generateGodDescription(boolean monotheist)
    {
        if(monotheist == true)
        {
            this.godDescription = ", God of All!Bow Before his splendor!";
        }
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
