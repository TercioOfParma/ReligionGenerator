/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Elliot Lake
 * @brief This is the main function, it governs all basic functionality of the
 * program
 */
public class ReligionGenerator
{
	//Just dummy main, a vehicle to test religions with no use of command line arguments
	//and no returned values
    public static void main(String[] args)
    {
       Religion toGenerate = new Religion(false, programConstants.LATIN.getConstant());
       
       toGenerate.displayGods();
       
    }
    
}
