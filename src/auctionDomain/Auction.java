package auctionDomain;

import java.util.ArrayList;
import java.util.Date;

public class Auction {
	private int id;
	private String title;
	private String productName;
	private String description;
	private double startPrize;
	private double buyoutPrize;
	private Date entryDate;
	private Date startDate;
	private Date endDate;
	private ArrayList<Bid> bids = new ArrayList<Bid>();

	public Auction(int id, String title, String productName,
			String description, double startPrize, double buyoutPrize,
			Date entryDate, Date startDate, Date endDate) {
		this.id = id;
		this.title = title;
		this.productName = productName;
		this.description = description;
		this.startPrize = startPrize;
		this.buyoutPrize = buyoutPrize;
		this.entryDate = entryDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getStartPrize() {
		return startPrize;
	}

	public void setStartPrize(double startPrize) {
		this.startPrize = startPrize;
	}

	public double getBuyoutPrize() {
		return buyoutPrize;
	}

	public void setBuyoutPrize(double buyoutPrize) {
		this.buyoutPrize = buyoutPrize;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}

}
