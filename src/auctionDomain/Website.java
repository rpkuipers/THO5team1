package auctionDomain;

import java.util.ArrayList;

public class Website {
	private String name;
	private String url;
	private String slogan;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Category> categories = new ArrayList<Category>();

	public Website(String name, String url, String slogan) {
		this.name = name;
		this.url = url;
		this.slogan = slogan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

}
