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
     //==== Class Initialization ====
    public Religion(boolean monotheism, int scriptNo)
    {
    	int i;
    	Random godDecider;
    	
        setMonotheism(monotheism);
        godDescriptor = new godTypes("godNames.txt");
        godDecider = new Random();
        if(isMonotheistic == true)
        {
            this.godContainer = new God[1];
            this.godContainer[0] = new God();
            this.godContainer[0].generateGodName(scriptNo);
            this.godContainer[0].generateGodDescription(0, godDescriptor);
        }
        else
        {
        	noGods = godDecider.nextInt(programConstants.MAX_GODS.getConstant()) + 1;
        	this.godContainer = new God[noGods];
        	for(i = 0; i < noGods; i++)
        	{
        		this.godContainer[i] = new God();
        		this.godContainer[i].generateGodName(scriptNo);
        		this.godContainer[i].generateGodDescription(godDecider.nextInt(godDescriptor.getGodTypes()), godDescriptor);
        	}
        }
    }
    //===== GETTERS AND SETTERS =====
    public boolean getMonotheism()
    {
        return isMonotheistic;
        
    }
    public void setMonotheism(boolean monotheism)
    {
        this.isMonotheistic = monotheism; 
        
    }
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
