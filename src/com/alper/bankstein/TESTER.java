package com.alper.bankstein;

public class TESTER {

	public static void main(String[] args) {
		Account alper = new Account("Alper Diker", 90000, "password1241");
		
		Account johndoe = new Account("John Doe", 11, "password1");
				
		Account janedoe = new Account("Jane Doe", 500, "Password110");
		
		// testing print info
		System.out.println(alper.toString());
		
		System.out.println("..............");
		
		// testing add balance
		alper.addBalance(650);
		System.out.println(alper.toString());
		
		System.out.println("..............");
		
		
		// let's add all the accounts we made into our bank 
		Bank bank1 = new Bank();
		
		bank1.addAccount(alper);
		bank1.addAccount(janedoe);
		bank1.addAccount(johndoe);
		
		System.out.println("..............");
		
		// testing the block feature
		
		System.out.println("Jane Doe's money before transfer: ");
		System.out.println(janedoe.getBalance());
		
		alper.block(janedoe.getID());
		System.out.println();
		
		bank1.transfer(alper.getID(), janedoe.getID(), 500, "password1241");
		System.out.println();
		
		alper.unblock(janedoe.getID());
		
		bank1.transfer(alper.getID(), janedoe.getID(), 500, "password1241");
		System.out.println();
		
		System.out.println("Jane Doe's money after transfer: ");
		System.out.println(janedoe.getBalance());
		
		
	
	}

}
