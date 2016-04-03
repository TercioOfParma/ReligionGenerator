/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package religiongenerator;

/**
 *
 * @author Elliot Lake
 * @brief This governs all of the program constants that I will utilize in the
 * project
 */
public enum programConstants
{
    MAXIMUM_NAME_SIZE(15), MINIMUM_CHAR('a'),
    MAXIMUM_CHAR('z'), ALPHABET_SIZE(26);
  
    private int constantValue;
     // ===== Basic Functionality ======
    private programConstants(int toAssign)
    {
        this.constantValue = toAssign;
    }
    public int getConstant()
    {
        return this.constantValue;
        
    }
}
