package beans;

public class Account {
	private int id;
	private String accountTitle;
	private double balance;
	
	public Account(int id, String accountTitle, double balance) {
		super();
		this.id = id;
		this.accountTitle = accountTitle;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountTitle() {
		return accountTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountTitle=" + accountTitle + ", balance=" + balance + "]";
	}
	
	
}
