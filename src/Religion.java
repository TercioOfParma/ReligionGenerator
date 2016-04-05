/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    
   
     //==== Class Initialization ====
    public Religion(boolean monotheism, int scriptNo)
    {
        setMonotheism(monotheism);
        if(isMonotheistic == true)
        {
            this.godContainer = new God[1];
            this.godContainer[0] = new God();
            this.godContainer[0].generateGodName(scriptNo);
            this.godContainer[0].generateGodDescription(this.isMonotheistic);
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
}
