package auctionActions.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import auctionDomain.Auction;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAuction extends ActionSupport implements SessionAware {

	private IAuctionService ias = ServiceProvider.getAuctionService();
	private int id = ias.getUsers().size() + 1;
	private Auction auction;
	private String title;
	private String productname;
	private String description;
	private int startprice;
	private int buyoutprice;
	private Date entrydate;
	private String startdate;
	private String enddate;
	private User user;
	private Map session;

	public String execute() {
		Date now = new Date();

		user = (User) session.get("user");
		auction = new Auction(user.getId(), id, title, productname,
				description, startprice, buyoutprice, now, makeValidDate(startdate), makeValidDate(enddate));
		user.getUserAuctions().add(auction);
		ias.addAuction(auction);

		return SUCCESS;
	}

	public void validate() {
		title = title.trim();
		productname = productname.trim();
		description = description.trim();

		// TODO Add Date validation options
		if (title.length() == 0) {
			addFieldError("title", "Title is required.");
		}
		if (productname.length() == 0) {
			addFieldError("productname", "Product name is required.");
		}
		if (description.length() == 0) {
			addFieldError("description", "Description is required.");
		}
		if (startprice == 0) {
			addFieldError("startprice", "Startprice is required.");
		}
		
		if (buyoutprice == 0) {
			addFieldError("buyoutprice", "buyoutprice is required.");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStartprice() {
		return startprice;
	}

	public void setStartprice(int startprice) {
		this.startprice = startprice;
	}

	public int getBuyoutprice() {
		return buyoutprice;
	}

	public void setBuyoutprice(int buyoutprice) {
		this.buyoutprice = buyoutprice;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public void setSession(Map session) {
		this.session = session;

	}
	public static Date makeValidDate(String inDate) {
	 	Date d;
	    if (inDate == null)
	      return null;

	    //set the format to use as a constructor argument
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    
	    if (inDate.trim().length() != dateFormat.toPattern().length())
	      return null;

	    dateFormat.setLenient(false);
	    
	    try {
	      //parse the inDate parameter
	    	
	      d = dateFormat.parse(inDate.trim());
	      System.out.println(d);
	    }
	    catch (ParseException pe) {
	      return null;
	    }
	    return d;
	  }
}
