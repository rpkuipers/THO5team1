package auctionActions.member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionAware.UserAware;
import auctionDomain.Auction;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class Bid extends ActionSupport implements UserAware, SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private List<Auction> auctions = new ArrayList<Auction>();
	private ArrayList<auctionDomain.Bid> bids = new ArrayList<auctionDomain.Bid>();
	private Auction detailedAuction;
	private String title;
	private double amount;
	private auctionDomain.Bid bid;
	private User auctionUser;
	private User user;
	@SuppressWarnings("rawtypes")
	private Map session;
	private boolean foundAuction = false;
	
	public String execute() {
		auctions = ias.getAuctions();
		user = (User) session.get("user");
		for(Auction a : getAuctions()){
			if(a.getTitle().equals(title)){
				detailedAuction = a;
				auctionUser = ias.getUserByUserId(detailedAuction.getUserid());
				setBids(detailedAuction.getBids());
				foundAuction = true;
			}
		}
		
		System.out.println("Found Auction: " + foundAuction);
		System.out.println("Amount: " + amount);
		System.out.println("User: " + user.getUsername());
		if(foundAuction){
			System.out.println("Bids size: " + getBids().size());
			System.out.println("Bids last value: " + getBids().get(getBids().size() - 1).getAmount());
			if(getBids().size() > 0) {
				if(getBids().get(0).getAmount() < getAmount()) {
						bid = new auctionDomain.Bid(user.getUsername(), amount);
						//bid.setAmount(amount);
						System.out.println(amount);
						//bid.setUsername(user.getUsername());
						getBids().add(0,bid);
						setBids(detailedAuction.getBids());
						return SUCCESS;
				} else {
					addFieldError("wrongamount", "Amount must be higher than the current bid.");
					setBids(detailedAuction.getBids());
					return ActionSupport.INPUT;
				}
			} else {
				bid = new auctionDomain.Bid(user.getUsername(), amount);
				bids.add(bid);
				setBids(detailedAuction.getBids());
				return SUCCESS;
			}
		} else {
			addFieldError("noauction", "This auction is no longer available.");
			setBids(detailedAuction.getBids());
			return ActionSupport.INPUT;
		}
	}
	
	public List<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public ArrayList<auctionDomain.Bid> getBidsArray() {
		return getBids();
	}

	public void setBidsArray(ArrayList<auctionDomain.Bid> bids) {
		this.setBids(bids);
	}

	public Auction getDetailedAuction() {
		return detailedAuction;
	}

	public void setDetailedAuction(Auction detailedAuction) {
		this.detailedAuction = detailedAuction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuctionUser() {
		return auctionUser;
	}

	public void setAuctionUser(User auctionUser) {
		this.auctionUser = auctionUser;
	}
	
	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ArrayList<auctionDomain.Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<auctionDomain.Bid> bids) {
		this.bids = bids;
	}

}
