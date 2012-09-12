package auctionDomain;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<SubCategory> subCategories = new ArrayList<SubCategory>();

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
