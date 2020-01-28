package main;

public class Savings extends Account{
	
	private int safetDepositBoxId;
	private int safetyDepositBoxKey;

	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNumber = "1" + this.accountNumber;
		this.setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox() {
		this.safetDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
		this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() - .25;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Savings Account Features " + 
							"\nSafety Deposit Box Id: " + this.safetDepositBoxId + 
							"\nSafety Deposit Box Key: " + this.safetyDepositBoxKey);
	}
	
}
