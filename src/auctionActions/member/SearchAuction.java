package auctionActions.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionDomain.Auction;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SearchAuction extends ActionSupport implements SessionAware {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private List<Auction> auctions = new ArrayList<Auction>();
	private String searchProductName;
	private List<Auction> searchResult = new ArrayList<Auction>();
	private User user;
	@SuppressWarnings("rawtypes")
	private Map session;

	public String execute() {
		ValueStack stack = ActionContext.getContext().getValueStack();

		if (getSearchProductName() == null) { // Kijken of het boek bestaat
			setAuctions(ias.getAuctions());
			addFieldError("searching", "Please enter a product name.");
			return ActionSupport.INPUT;
		} else {

			setSearchResult(ias.getAuctionByProductName(getSearchProductName()));
			if (searchResult.size() == 0) {
				setAuctions(ias.getAuctions());
				addFieldError("searching", "No products found.");
				return ActionSupport.INPUT;
			} else {
				return ActionSupport.SUCCESS;
			}
		}
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	public List<Auction> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<Auction> searchResult) {
		this.searchResult = searchResult;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public String getSearchProductName() {
		return searchProductName;
	}

	public void setSearchProductName(String searchProductName) {
		this.searchProductName = searchProductName;
	}

}
