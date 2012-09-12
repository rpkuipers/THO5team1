package veilingService;

import java.util.List;

import veilingDomain.Product;
import veilingDomain.User;


public interface IVeilingService {
	
	void addBook(int BookId, String titel,String auteur,String isbn,int pages);
	List<Product> getBooks();
	Product getBookById(int bookId);
	boolean bookExists (int id);
	void deleteBook(int BookId);	
	
	boolean userExists (String username);
	List<User> getUsers();
	List<User> getMembers();
	User getUserByUsername(String username);
	boolean hasBorrowedBooks(String username);
	void deleteUser(String username);
	void addMember(String username, String password);
	void addCoworker(String username, String password);
	
	void changePassword(String username,String password);
	void reserveBook(String username, int BookId);
	void cancelReservationBook(String username, int BookId);
	void takeBackBook(int BookId);
	void lendBook(String username, int BookId);
	List<Product> getBooks(String username);
	
}
