package auctionService;

import java.util.ArrayList;
import java.util.List;

import auctionDomain.Auction;
import auctionDomain.Bid;
import auctionDomain.User;

public interface IAuctionService {
	
	//User methods
	boolean userExists (String username);
	List<User> getUsers();
	User getUserByUsername(String username);
	User getUserByUserId(int userid);
	void addUser(User user);
	void plusOne(String username);
	//void changeUserData(User user, String name, String address, String email, String phoneNumber);
	
	//Auction methods
	ArrayList<Auction> getAuctions();
	ArrayList<Auction> getAuctionsById(int id);
	ArrayList<Auction> getAuctionByProductName(String searchName);
	Auction getAuctionByTitle(String title);
	void addAuction(Auction auction);
	List<Auction> getSearchResult();
	//void addBid(Bid bid);
}
