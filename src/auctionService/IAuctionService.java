package auctionService;

import java.util.ArrayList;
import java.util.List;

import auctionDomain.Auction;
import auctionDomain.User;

public interface IAuctionService {
	boolean userExists (String username);
	List<User> getUsers();
	User getUserByUsername(String username);
	void addUser(User user);
	void addAuction(Auction auction);
	//void changeUserData(User user, String name, String address, String email, String phoneNumber);
	List<Auction> getSearchResult();
	
	ArrayList<Auction> getAuctionsById(int id);
	ArrayList<Auction> getAuctions();

	ArrayList<Auction> getAuctionByProductName(String searchName);
}
