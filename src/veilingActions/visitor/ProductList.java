package veilingActions.visitor;

import java.util.ArrayList;
import java.util.List;

import veilingDomain.Product;
import veilingService.IVeilingService;
import veilingService.ServiceProvider;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProductList extends ActionSupport {

	private IVeilingService ibs = ServiceProvider.getBiebService();
	private List<Product> books = new ArrayList<Product>();
	
	public String execute() {
		books = ibs.getBooks();
		
		return ActionSupport.SUCCESS;
	}

	public List<Product> getBooks() {
		return books;
	}
}
