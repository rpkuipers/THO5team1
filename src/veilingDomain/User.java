package veilingDomain;

import java.util.ArrayList;

public class User {
	
	private String username;
	private String password;
	private UserRole ur;
	private ArrayList<Product> books =  new ArrayList<Product>(); // geleende of gereserveerde boeken
	
	public User() {
	}
	
	public User(String username, String password, UserRole ur)
	{
		setUsername(username);
		setPassword(password);
		setUr(ur);
	}
	

	public UserRole getUr() {
		return ur;
	}

	public void setUr(UserRole ur) {
		this.ur = ur;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ArrayList<Product> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Product> books) {
		this.books = books;
	}


}
