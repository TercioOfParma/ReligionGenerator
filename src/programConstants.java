/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Elliot Lake
 * @brief This governs all of the program constants that I will utilise in the
 * project
 */
public enum programConstants
{
	//Misc constants
	MAX_GODS(20),
    MAXIMUM_NAME_SIZE(15),
    
    //Script types
    LATIN(0),
    ARAMAIC(1), 
    
    //Latin Script
    LATIN_MINIMUM_CHAR('a'),
    LATIN_MAXIMUM_CHAR('z'), LATIN_ALPHABET_SIZE(26),
    
    //Aramaic Script
    ARAMAIC_MINIMUM_CHAR('ܐ'), ARAMAIC_MAXIMUM_CHAR('ܬ'),
    ARAMAIC_ALPHABET_SIZE(28);
 
    private int constantValue;
     // ===== Basic Functionality ======
    //Assigns a value to a constant
    private programConstants(int toAssign)
    {
        this.constantValue = toAssign;
    }
    //Gets the value of a constant
    public int getConstant()
    {
        return this.constantValue;
        
    }
}
