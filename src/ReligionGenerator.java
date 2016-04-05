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
    public static void main(String[] args)
    {
       Religion toGenerate = new Religion(true, programConstants.ARAMAIC.getConstant());
       
       System.out.println("Monotheistic Religion? " + toGenerate.getMonotheism());
       System.out.println("God Name? " + toGenerate.godContainer[0].getGodName() 
               + toGenerate.godContainer[0].getGodDescription());
       
    }
    
}
