package br.com.Money;

/**
 * Account.java Represents a bank account
 */

public class Account {

	private int accountNumber; // account number
	private int pin; // PIN for authentication
	private double availableBalance; // funds available for withdrawal
	private double totalBalance; // funds available + pending deposits

	/**
	 * Account constructor initializes attributes
	 * 
	 * @param theAccountNumber
	 * @param thePIN
	 * @param theAvailableBalance
	 * @param theTotalBalance
	 */
	public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
		accountNumber = theAccountNumber;
		pin = thePIN;
		availableBalance = theAvailableBalance;
		totalBalance = theTotalBalance;
	} // end Account constructor

	/**
	 * determines whether a user-specified PIN matches PIN in Account
	 * 
	 * @param userPIN
	 * @return true or false
	 */
	public boolean validatePIN(int userPIN) {
		if (userPIN == pin)
			return true;
		else
			return false;
	} // end method validatePIN

	/**
	 * returns available balance
	 * 
	 * @return
	 */
	public double getAvailableBalance() {
		return availableBalance;
	} // end getAvailableBalance

	/**
	 * returns the total balance
	 * 
	 * @return
	 */
	public double getTotalBalance() {
		return totalBalance;
	} // end method getTotalBalance

	/**
	 * credits an amount to the account
	 * 
	 * @param amount
	 */
	public void credit(double amount) {
		totalBalance += amount;
		availableBalance += amount;// add to total balance
	} // end method credit

// debits an amount from the account
	public void debit(double amount) {
		availableBalance -= amount; // subtract from available balance
		totalBalance -= amount; // subtract from total balance
	} // end method debit

	/**
	 * returns account number
	 * 
	 * @return
	 */
	public int getAccountNumber() {
		return accountNumber;
	} // end method getAccountNumber

	@Override
	public String toString() {

		System.out.printf(" %d; \t%d; \t$%,.2f; \t$%,.2f %n", accountNumber, pin, availableBalance, totalBalance);
		return null;
	}

	/**
	 * Método toStringWrite() da Classe de Contas para BufferedWriter
	 * @return String
	 **/
	public String toStringWriter() {
		return accountNumber+","+pin+","+availableBalance+","+totalBalance;
	}

} // end class Account
