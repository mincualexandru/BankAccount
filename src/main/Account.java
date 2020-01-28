package main;

public abstract class Account implements IBaseRate {

	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		index++;
		this.accountNumber = setAccountNumber();
		this.setRate();
	}

	private String setAccountNumber() {
		String lastTwoOfSSN = this.sSN.substring(this.sSN.length()-2, this.sSN.length());
		int uniqueId = index;
		int randomNumber = (int) (Math.random() * Math.pow(10,3));
		return lastTwoOfSSN + uniqueId + randomNumber;
	}
	
	public abstract void setRate();
	
	public void compound() {
		double accoundInterest = balance * (rate/100);
		System.out.println("Account Interest: $" + accoundInterest);
		this.printBalance();
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $ " + amount);
		this.printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $ " + amount);
		this.printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		this.printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: " + this.balance + " $");
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + this.name + 
				"\nACCOUNT NUMBER: " + this.accountNumber +
				"\nBALANCE: " + this.balance +
				"\nRATE: " + this.rate + "%");
	}

}
