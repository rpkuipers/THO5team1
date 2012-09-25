package auctionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionDomain.Auction;
import auctionDomain.User;

public class AuctionService implements IAuctionService, SessionAware {
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Auction> auctions = new ArrayList<Auction>();
	public ArrayList<Auction> userAuctions = new ArrayList<Auction>();
	private ArrayList<Auction> searchResult = new ArrayList<Auction>();
	public Map session;
	public AuctionService() {		
		addUser(new User(1, "Pieter", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "Pietje92", "pieterpost92", 0, 100));
		addUser(new User(2, "Pietertje Post", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "PPost", "ww", 0, 100));
		addUser(new User(3, "admin", "Pieterlaan 1", "pietje@hotmail.com", "06336452836", "admin", "admin", 0, 200));
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
	public void setSession(Map session) {
		this.session = session;
	}

	public ArrayList<Auction> getSearchResult() {
		return searchResult;
	}
}

