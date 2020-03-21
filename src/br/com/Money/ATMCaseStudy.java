package br.com.Money;

import java.io.FileNotFoundException;

/**
 * ATMCaseStudy.java 
 * Projeto de Bloco
 * @author Bruno
 *
 */

public class ATMCaseStudy
{
   /**
    * main method creates and runs the ATM
    * @param args
 * @throws Exception 
 * @throws FileNotFoundException 
    */
   public static void main( String[] args ) throws FileNotFoundException, Exception
   {
      ATM theATM = new ATM();    
      theATM.run();
   } // end main
} // end class ATMCaseStudy 

