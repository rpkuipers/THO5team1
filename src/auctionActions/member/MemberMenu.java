package auctionActions.member;

import auctionAware.UserAware;
import auctionDomain.User;

import com.opensymphony.xwork2.ActionSupport;

public class MemberMenu extends ActionSupport implements UserAware {
	
	private User user;

	public String execute(){
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
