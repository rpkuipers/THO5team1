package auctionDomain;

import java.util.ArrayList;

public class SubCategory {
	private String name;
	private ArrayList<Auction> auctions = new ArrayList<Auction>();

	public SubCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(ArrayList<Auction> auctions) {
		this.auctions = auctions;
	}

}
