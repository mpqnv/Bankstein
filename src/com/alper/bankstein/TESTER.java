package com.alper.bankstein;

public class TESTER {

	public static void main(String[] args) {
		Account alper = new Account("Alper Diker", 90000, "password1241");
		
		Account johndoe = new Account("John Doe", 11, "password1");
				
		Account janedoe = new Account("Jane Doe", 500, "Password110");
		
		// let's display alper's info right after creating the account;
		System.out.println(alper.toString());
		
		System.out.println("..............");
		
		// let's give alper some money and then display info again
		alper.addBalance(650);
		System.out.println(alper.toString());
		
		
		// let's add all the accounts we made into our bank + add a non existent account
		Bank bank1 = new Bank();
		
		bank1.addAccount(alper);
		bank1.addAccount(janedoe);
		bank1.addAccount(johndoe);
		
		bank1.addAccount(smith);
		
		
		
		
	
	}

}
