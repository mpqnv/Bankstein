import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;
	private static final double transactionFee = 3.5;
	
	public Bank() {
		this.accounts =  new ArrayList<>();
	}
	
	public void addAccount(Account account) {
		if(accounts.contains(account) || account == null) {
			return;
		}
		else {
			accounts.add(account);
		}
	}
	public void deleteAccount(int id, String pass) {
		for(int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID() == id) {
				if(pass != null && accounts.get(i).checkpassword(pass)){
					accounts.remove(i);
					System.out.println("Account has been deleted");
					return;
				}
					System.out.println("Invalid password");
					return;
			}
		}
		System.out.println("Invalid ID");
		return;
	}
	
	
	public void deposit(double money, int id, String pass) {
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getID() == id) {
				if(pass!= null && accounts.get(i).checkpassword(pass)) {
					double feeAmount = money * (transactionFee / 100.0);
					money -= feeAmount;
					accounts.get(i).addBalance(money);
					return;
				}
					System.out.println("Invalid password");
					return;
			}
		}
		System.out.println("Invalid ID");
		return;
	}
	
	public void withdraw(double money, int id, String pass) {
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getID() == id) {
				if(pass!= null && accounts.get(i).checkpassword(pass)) {
					double feeAmount = money * (transactionFee / 100.0);
					double totalDeduction = money + feeAmount;
					accounts.get(i).deductBalance(totalDeduction);
				}
			}
		}
	}
	public void transfer(int id, int recipient, double money, String pass) {
		if (money <= 0) return;

		int sender = -1;
		int target = -1;
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID() == id) {
				sender = i;
			}
			if (accounts.get(i).getID() == recipient) {
				target = i;
			}
		}

		if (sender == -1 || target == -1) {
			System.out.println("Invalid sender or recipient ID");
			return;
		}

		Account senderAcc = accounts.get(sender);
		Account targetAcc = accounts.get(target);

		if (pass == null || !senderAcc.checkpassword(pass)) {
			System.out.println("Invalid password");
			return;
		}

		if (senderAcc.isBlocked(targetAcc.getID())) {
			System.out.println("The recipient is in your block list");
			return;
		}
		if (targetAcc.isBlocked(senderAcc.getID())) {
			System.out.println("Failed to reach recipient");
			return;
		}

		double feeAmount = money * (transactionFee / 100.0);
		double totalDeduction = money + feeAmount;

		if (senderAcc.getBalance() < totalDeduction) {
			System.out.println("Insufficient funds for transfer and fee");
			return;
		}

		senderAcc.deductBalance(totalDeduction);
		targetAcc.addBalance(money);
	}
}
