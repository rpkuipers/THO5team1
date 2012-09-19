package auctionActions.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionDomain.Auction;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class ProductList extends ActionSupport implements SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private Map session;
	public List<Auction> auctions = new ArrayList<Auction>();
	private User user;

	public String execute() {
		auctions = ias.getAuctions();

		return SUCCESS;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;

	}
}
