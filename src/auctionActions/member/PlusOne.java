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

public class PlusOne extends ActionSupport implements UserAware, SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private List<Auction> auctions = new ArrayList<Auction>();
	private List<auctionDomain.Bid> bids = new ArrayList<auctionDomain.Bid>();
	private User user;
	private User auctionUser;
	private Auction detailedAuction;
	private String title;
	private String username;
	//private User auctionUser;
	@SuppressWarnings("rawtypes")
	private Map session;

	@SuppressWarnings("unchecked")
	public String execute() {
		user = (User) session.get("user");

		System.out.println("user: " + getUsername());
		
		ias.plusOne(username);
		auctionUser = ias.getUserByUsername(getUsername());
		setAuctions(ias.getAuctions());
		detailedAuction = ias.getAuctionByTitle(title);
		bids = detailedAuction.getBids();
		Collections.sort(bids);
		
		session.put("user", user);
		addActionMessage("Success!");
		return ActionSupport.SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public List<auctionDomain.Bid> getBids() {
		return bids;
	}

	public void setBids(List<auctionDomain.Bid> bids) {
		this.bids = bids;
	}

	public User getAuctionUser() {
		return auctionUser;
	}

	public void setAuctionUser(User auctionUser) {
		this.auctionUser = auctionUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}