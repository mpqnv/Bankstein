import java.util.Random;

public class Account {
	private static final Random random = new Random();
	private static int nextID = random.nextInt(800000000) + 100000000;
	private String fullName;
	private double balance;
	private String password;
	private final int id;
	private int[] blocklist = new int[20];
	private int blockindex = 0;
	
	public Account(String fullName, double balance, String password) {
		if(fullName != null) this.fullName = fullName.trim();
		if (balance < 0) {
			this.balance = 0;
		}else {
			this.balance =  balance;
		}
		if(password != null) this.password = password.trim();
		this.id = nextID;
		nextID++;
	}
	
	
	public void setName(String fullName) {
		this.fullName =	fullName;
	}
	
	public boolean setPassword(String oldpass, String newpass) {
		if (oldpass != null && newpass != null && checkpassword(oldpass.trim())) {
			this.password = newpass.trim();
			return true;
		}
		return false;
	}
	
	public boolean block(int blockID) {
		
		if(blockID == this.id || blockID <= 99999999) {
			return false;
		}
		if(isBlocked(blockID)) {
			return false;
		}
		if (blockindex < blocklist.length) {
			blocklist[blockindex] = blockID;
			this.blockindex++;
			return true;
		}
		return false;
	}
	
	public void viewBlocklist() {
		if (blockindex == 0) {
			System.out.println("Blocklist is empty.");
			return;
			
		}
		for (int i = 0; i < blockindex; i++) {
			if (blocklist[i] > 0 ) {
				System.out.println(blocklist[i]);
			}
		}
	}
	public boolean isBlocked(int blockID) {
		for (int i = 0; i < blockindex; i++) {
			if (blocklist[i] == blockID) {
				return true;
			}
		}
		return false;
	}
	
	public void unblock(int unblockID) {
		for (int i = 0; i < blockindex; i++) {
			if (blocklist[i] == unblockID) {
				blocklist[i] = blocklist[blockindex - 1];
				blocklist[blockindex - 1] = 0;
				blockindex--;
				return;
			}
		}
	}
	
	public String getName() {
		return fullName;
	}
	
	public int getID() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	
	public boolean checkpassword(String pass) {
		if (pass == null) {
			return false;
		}
		return password != null && password.equals(pass.trim());
	}
	

	boolean addBalance(double amount) {
	    if (amount > 0) {
	        this.balance += amount;
	        return true;
	    }
	    return false;
	}

	boolean deductBalance(double amount) {
	    if (amount > 0 && amount <= balance) {
	        this.balance -= amount;
	        return true;
	    }
	    return false;
	}
	
	
	@Override
	public String toString() {
		String name = "Full Name: " + fullName + "\n";
		String identification = "ID: "	+ id + "\n";
		String money = "Balance: " + balance + "\n";
		
		
		return name + identification + money;
	}

}