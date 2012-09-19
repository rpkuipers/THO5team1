package auctionActions.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionAware.UserAware;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Account extends ActionSupport implements SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private User user;
	@SuppressWarnings("rawtypes")
	private Map session;

	@SuppressWarnings("unchecked")
	public String execute() {
		ValueStack stack = ActionContext.getContext().getValueStack();
		user = (User) session.get("user");
		user = ias.getUserByUsername(user.getUsername());

		stack.set("user", user);

		session.put("user", user);
		return ActionSupport.SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}
}
