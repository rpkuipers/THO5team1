package veilingDomain;

public class Product {

	private int id;
	private String titel;
	private String auteur;
	private String isbn;
	private int pages;
	private ProductStatus status;
	private User user; // gebruiker die boek leent of reserveert
	
	public Product() {
	}
	
	public Product(int id,String titel,String auteur,String isbn,int pages)
	{
		setId(id);
		setTitel(titel);
		setAuteur(auteur);
		setIsbn(isbn);
		setPages(pages);
		setStatus(ProductStatus.AVAILABLE);
		setUser(null); // geen gebruiker leent of reserveert het boek
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
