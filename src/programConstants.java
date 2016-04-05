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
	MAX_GODS(4), MONOTHEISM(0),
	FIRE(1), WATER(2),
	EARTH(3), NO_GOD_TYPES(3),
    MAXIMUM_NAME_SIZE(15), LATIN(0),
    ARAMAIC(1), LATIN_MINIMUM_CHAR('a'),
    LATIN_MAXIMUM_CHAR('z'), LATIN_ALPHABET_SIZE(26),
    ARAMAIC_MINIMUM_CHAR('ܐ'), ARAMAIC_MAXIMUM_CHAR('ܬ'),
    ARAMAIC_ALPHABET_SIZE(27);
 
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
