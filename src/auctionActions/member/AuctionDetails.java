package auctionActions.member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionAware.UserAware;
import auctionDomain.Auction;
import auctionDomain.Bid;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class AuctionDetails extends ActionSupport implements UserAware, SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private List<Auction> auctions = new ArrayList<Auction>();
	private List<Bid> bids = new ArrayList<Bid>();
	private Auction detailedAuction;
	private String title;
	private User auctionUser;
	private User user;
	@SuppressWarnings("rawtypes")
	private Map session;
	
	public String execute(){
		
		auctions = ias.getAuctions();
		for(Auction a : getAuctions()){
			if(a.getTitle().equals(title)){
				detailedAuction = a;
				auctionUser = ias.getUserByUserId(detailedAuction.getUserid());
				setBids(detailedAuction.getBids());
				Collections.reverse(bids);
				return SUCCESS;
			}
		}
		addFieldError("error", "No auction found.");
		return ERROR;
		
	}
	
	@Override
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Auction getDetailedAuction() {
		return detailedAuction;
	}



	public void setDetailedAuction(Auction detailedAuction) {
		this.detailedAuction = detailedAuction;
	}



	public User getAuctionUser() {
		return auctionUser;
	}



	public void setAuctionUser(User auctionUser) {
		this.auctionUser = auctionUser;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
}
