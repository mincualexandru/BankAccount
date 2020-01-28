package main;

public class Checking extends Account {
	
	private int debitCardNumber;
	private int debitCardPIN;
	
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNumber = "2" + this.accountNumber;
		this.setDebitCard();
	}
	
	private void setDebitCard() {
		this.debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() * .15;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checkings Account Features " + 
							"\nDebit Card Number: " + this.debitCardNumber + 
							"\nDebit Card PIN: " + this.debitCardPIN);
	}
}
