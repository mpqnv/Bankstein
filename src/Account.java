import java.util.Random;

public class Account {
	private static final Random random = new Random();
	private static int nextID = random.nextInt(800000000) + 100000000;
	private String fullName;
	private float balance;
	private String password;
	private final int id;
	private int[] blocklist = new int[20];
	private int blockindex = 0;
	
	public Account(String fullName, float balance, String password) {
		this.fullName = fullName;
		if (balance < 0) {
			this.balance = 0;
		}else {
			this.balance =  balance;
		}
		this.password = password;
		this.id = nextID;
		nextID++;
	}
	
	
	public void setName(String fullName) {
		this.fullName =	fullName;
	}
	
	public boolean setPassword(String oldpass, String newpass) {
		if (checkpassword(oldpass)) {
			this.password = newpass;
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
	public float getBalance() {
		return balance;
	}
	
	public boolean checkpassword(String pass) {
		return password != null && password.equals(pass);
	}
	

	void addBalance(float amount) {
	    if (amount > 0) {
	        this.balance += amount;
	    }
	}

	void deductBalance(float amount) {
	    if (amount > 0 && amount <= balance) {
	        this.balance -= amount;
	    }
	}
	
	
	@Override
	public String toString() {
		String name = "Full Name: " + fullName + "\n";
		String identification = "ID: "	+ id + "\n";
		String money = "Balance: " + balance + "\n";
		
		
		return name + identification + money;
	}

}