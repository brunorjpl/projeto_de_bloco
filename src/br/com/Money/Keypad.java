package br.com.Money;

import java.util.InputMismatchException;
import java.util.Scanner; // program uses Scanner to obtain user input

/**
 * Keypad.java
 * Represents the keypad of the ATM
 * @param Scanner input
 */

public class Keypad
{
   private Scanner input; // reads data from the command line
                         
   /**
    * no-argument constructor initializes the Scanner
    */
   public Keypad()
   {
      input = new Scanner( System.in );    
   } // end no-argument Keypad constructor

   /**
    * return an integer value entered by user 
    * @return nextInt
    */
   public int getInput() throws InputMismatchException
   {
	   try{
		   return input.nextInt(); // we assume that user enters an integer
	   }
	   catch (InputMismatchException inputMismatchException){
		   //System.err.printf("\nException: %s\n", inputMismatchException);
		   input.nextLine();// descarta a entrada para o usu�rio poder entrar novamente.
		   System.out.println("Voc� deve digitar apenas n�meros!\n Por favor, tente novamente.\n");
	   }
	   
	   return 0;
        
   } // end method getInput
} // end class Keypad  

