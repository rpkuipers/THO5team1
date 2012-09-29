package auctionDomain;

public class Bid {
	private double amount;
	private String username;

	public Bid(String username, double amount) {
		this.username = username;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
