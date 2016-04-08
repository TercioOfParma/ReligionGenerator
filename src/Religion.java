/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author Elliot Lake
 * @brief This is the basis for an entire religion, It contains the whole pantheon
 * of gods or 1 god if the religion is decided to be monotheistic
 */
public class Religion 
{
    
    //=== Class Variables =====
    private boolean isMonotheistic;
    public  God [] godContainer; 
    private int noGods;
    private godTypes godDescriptor;
    characterFrequencyGenerator nameCharDecider;
     //==== Class Initialization ====
    /*
     * This initalises a religion
     * This generates religions based on whether or not monotheism is desired
     * and what glyph script to use to generate names
     * 
     */
    public Religion(boolean monotheism, int scriptNo)
    {
    	int i;
    	Random godDecider;
    	
        setMonotheism(monotheism);
        godDescriptor = new godTypes("godNames.txt");
        godDecider = new Random();
        nameCharDecider = new characterFrequencyGenerator(scriptNo);
        nameCharDecider.generateAlphabetFrequencies();
        nameCharDecider.generateCombinations();
        if(isMonotheistic == true)//Generates 1 god for monotheism
        {
            this.godContainer = new God[1];
            this.godContainer[0] = new God();
            this.godContainer[0].generateGodName( nameCharDecider );
            this.godContainer[0].generateGodDescription(0, godDescriptor, isMonotheistic);
        }
        else//Generates a random amount of god for a polytheistic pantheon
        {
        	noGods = godDecider.nextInt(programConstants.MAX_GODS.getConstant()) + 1;
        	this.godContainer = new God[noGods];
        	for(i = 0; i < noGods; i++)
        	{
        		this.godContainer[i] = new God();
        		this.godContainer[i].generateGodName(  nameCharDecider );
        		this.godContainer[i].generateGodDescription(godDecider.nextInt(godDescriptor.getGodTypes()), godDescriptor, isMonotheistic);
        	}
        }
    }
    //===== GETTERS AND SETTERS =====
    //Gets monotheism
    public boolean getMonotheism()
    {
        return isMonotheistic;
        
    }
    //Sets monotheism
    public void setMonotheism(boolean monotheism)
    {
        this.isMonotheistic = monotheism; 
        
    }
    //Displays all the gods without any non console output
    public void displayGods()
    {
    	int i;
    	System.out.println("Monotheistic Religion? " + getMonotheism());
    	if(getMonotheism() == true)
    	{
    		
    	       System.out.println("God Name? " + godContainer[0].getGodName() + ", " + godContainer[0].getGodDescription());
    	}
    	else
    	{
    		for(i = 0;i < this.noGods;i++)
    		{
    			 System.out.println("God Name? " + godContainer[i].getGodName() + ", " + godContainer[i].getGodDescription());	
    			
    		}
    		
    	}
    	
    }
}
