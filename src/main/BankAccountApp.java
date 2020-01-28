package main;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;

import utility.CSV;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "C:\\Users\\alexandru.mincu\\eclipse-workspace\\BankAccount\\NewBankAccounts.txt";
		CSV csv = new CSV();
		List<String[]> customers = csv.read(file);
		for (String[] strings : customers) {
			String name = strings[0];
			String sSN = strings[1];
			String accountType = strings[2];
			double initDeposit = Double.parseDouble(strings[3]);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			} 
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			} 
			else { 
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account account : accounts) {
			account.showInfo();
		}
	}
	
}
