package auctionActions.member;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import auctionAware.UserAware;
import auctionDomain.User;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Logout extends ActionSupport implements SessionAware {

	private User user;
	private SessionMap session;

	public String execute() {
		session.invalidate();

		return ActionSupport.SUCCESS;
	}

	public User getUser() {
		return user;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = (SessionMap) session;
	}
}
