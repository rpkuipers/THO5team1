package auctionDomain;

import java.util.ArrayList;
import java.util.Date;

public class Auction {
	private int userid;
	private int id;
	private String title;
	private String productName;
	private String description;
	private double startPrice;
	private double buyoutPrice;
	private Date entryDate;
	private Date startDate;
	private Date endDate;
	private ArrayList<Bid> bids = new ArrayList<Bid>();

	public Auction(int userid, int id, String title, String productName,
			String description, double startPrice, double buyoutPrice,
			Date entryDate, Date startDate, Date endDate) {
		this.userid = userid;
		this.id = id;
		this.title = title;
		this.productName = productName;
		this.description = description;
		this.startPrice = startPrice;
		this.buyoutPrice = buyoutPrice;
		this.entryDate = entryDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getBuyoutPrice() {
		return buyoutPrice;
	}

	public void setBuyoutPrice(double buyoutPrice) {
		this.buyoutPrice = buyoutPrice;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}

	public String toString() {
		return "Product with name: " + productName;
	}
}
