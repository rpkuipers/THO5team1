package auctionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionActions.member.CreateAuction;
import auctionDomain.Auction;
import auctionDomain.Bid;
import auctionDomain.User;

public class AuctionService implements IAuctionService, SessionAware {
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Auction> auctions = new ArrayList<Auction>();
	private ArrayList<Bid> bids = new ArrayList<Bid>();
	public ArrayList<Auction> userAuctions = new ArrayList<Auction>();
	private ArrayList<Auction> searchResult = new ArrayList<Auction>();
	public Map session;
	public AuctionService() {		
		addUser(new User(1, "Pieter", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "Pietje92", "pieterpost92", 0, 100, 1));
		addUser(new User(2, "Pietertje Post", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "PPost", "ww", 0, 100, 0));
		addUser(new User(3, "admin", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "admin", "admin", 0, 200, 0));
		
		Bid b = new Bid("PPost", 210.0);
		Bid b1 = new Bid("PPost", 220.0);
		Bid b2 = new Bid("PPost", 250.0);
		getBids().add(b);
		getBids().add(b1);
		getBids().add(b2);
		
		Auction a = new Auction(1, 1, "iPhone4s", "iPhone", "NEWNEWNEW", 200.0, 700.0, CreateAuction.makeValidDate("28-09-2012"), CreateAuction.makeValidDate("21-12-2012"), CreateAuction.makeValidDate("22-12-2012"));
		a.setBids(getBids());
		
		addAuction(a);
		
	}

	public void addUser(User user) {
		users.add(user);
	}
	public void addAuction(Auction auction){
		auctions.add(auction);
	}
	
	public List<User> getUsers() {
		return users;
	}

	public User getUserByUsername(String username) {
		for (User user:users)								// Go through list of users.
			if (user.getUsername().equals(username))		// if username matches the inputted username, return the user.
				return user;
		return null;
	}

	public User getUserByUserId(int id) {
		for (User user:users)								// Go through list of users.
			if (user.getId() == id)		// if username matches the inputted username, return the user.
				return user;
		return null;
	}
	
	public boolean userExists(String username) {
		if(getUserByUsername(username) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Auction> getAuctionsById(int id){
			return userAuctions;
	}
	
	public ArrayList<Auction> getAuctions(){
		return auctions;
	}
	
	@Override
	// Search auctions for keywords.
	// Method now searches in productname & title.
	public ArrayList<Auction> getAuctionByProductName(String searchName) {
		for(Auction a : auctions){
			if(a.getProductName().toLowerCase().contains(searchName.toLowerCase()) || a.getTitle().toLowerCase().contains(searchName.toLowerCase())){
				if(!searchResult.contains(a)){					// if the searchResult does nog yet contain the auction...
					getSearchResult().add(a);					// ...add to the searchResult.
				}
			}
		}
		return getSearchResult();								// SearchResult is temporarily being emptied in the AuthenticationInterceptor.
	}															// TODO Make own Interceptor for SearchResult
	
	@Override
	public Auction getAuctionByTitle(String title) {
		for(Auction a : auctions){
			if(a.getTitle().toLowerCase().contains(title.toLowerCase())){
				return a;
			}
		}
		return null;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	public ArrayList<Auction> getSearchResult() {
		return searchResult;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}

	@Override
	public void plusOne(String username) {
		User user = getUserByUsername(username);
		int points = user.getPoints();
		points++;
		user.setPoints(points);
	}
}

