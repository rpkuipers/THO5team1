package veilingActions.visitor;

import veilingDomain.Product;
import veilingService.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class ProductSpecs extends ActionSupport {

	private IVeilingService ibs = ServiceProvider.getBiebService();
	private Product book;
	private String searchId; 											// Doordat in BookInfoForm.jsp aan het textField de naam "searchId" 
																		// gegeven wordt, kan de inhoud daarvan meteen opgehaald worden in de
																		// volgende action.
	public String execute() {
		ValueStack stack = ActionContext.getContext().getValueStack();
		
		book = ibs.getBookById(Integer.parseInt(searchId));				// Ingevoerde text omzetten naar een int 
		String titel = book.getTitel();									// zodat gezocht kan worden naar het juiste id.
		String auteur = book.getAuteur();		
		int id = book.getId();
		int pages = book.getPages();
		String isbn = book.getIsbn();
		
		stack.set("id", id);											// Alle losse gegevens op de ValueStack zetten met een unieke key.
		stack.set("titel", titel);										// Als je dit niet doet kunnen de losse gegevens niet opgehaald worden 
		stack.set("auteur", auteur);									// in de JSP. (Althans, ik weet (nog) niet hoe.)
		stack.set("isbn", isbn);
		stack.set("pages", pages);
		
		return ActionSupport.SUCCESS;
	}

	public String getSearchId() {										// Getter en setter voor het gezochtte ID, 
		return searchId;												// om hem op te halen en te setten in deze action.
	}

	public void setSearchId(String search) {
		this.searchId = search;
	}
	
	public void validate(){												// Validator om te kijken of het veld niet leeg is en of er geen letters 
		if (searchId == null || searchId.equals("")){					// of vreemde tekens zijn ingevuld. *WERKT NOG NIET*
			addFieldError("searching", "Het zoekveld moet ingevuld worden.");
		}
	}
}
