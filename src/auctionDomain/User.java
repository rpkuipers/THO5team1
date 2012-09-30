package auctionDomain;

import java.util.ArrayList;

public class User {
	private int id;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private int credits;
	private int tempCredits;
	private int userRole;
	private int points;
	private ArrayList<Bid> userBids = new ArrayList<Bid>();
	private ArrayList<Auction> userAuctions = new ArrayList<Auction>();

	public User(int id, String name, String address, String email,
			String phoneNumber, String username, String password, int credits, int userRole, int points) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.credits = credits;
		this.userRole = userRole;
		this.points = points;
	}

	public ArrayList<Bid> getUserBids() {
		return userBids;
	}

	public void setUserBids(ArrayList<Bid> userBids) {
		this.userBids = userBids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTempCredits() {
		return tempCredits;
	}

	public void setTempCredits(int tempCredits) {
		this.tempCredits = tempCredits;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public ArrayList<Auction> getUserAuctions() {
		return userAuctions;
	}

	public void setUserAuctions(ArrayList<Auction> userAuctions) {
		this.userAuctions = userAuctions;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
