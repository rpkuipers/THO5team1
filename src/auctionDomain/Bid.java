package auctionDomain;

public class Bid implements Comparable<Bid>{
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

	@Override
	public int compareTo(Bid o) 
	{
		if(this.amount > o.amount)
		{
			return -1;
		}
		else 
		{
			return 1;
		}
	}

}
