package auctionActions.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAccount extends ActionSupport {
	private IAuctionService ias = ServiceProvider.getAuctionService();
	private int id = ias.getUsers().size() + 1;
	private User user;
	private String name;
	private String address;
	private String email;
	private String repeatemail;
	private String phonenumber;
	private String username;
	private String password;
	private String repeatpassword;
	private int credits = 0;
	private int tempCredits = 0;
	private int userRole = 100;
	boolean hasUpperCase = false;
	boolean hasLowerCase = false;
	boolean hasDigit = false;
	boolean hasWhiteSpace = true;

	private Pattern pattern;
	private Matcher matcher;

	public String execute() {
		user = new User(id, name, address, email, phonenumber, username,
				password, credits, tempCredits, userRole);
		ias.addUser(user);

		return SUCCESS;
	}

	public void validate() {
		username = username.trim();
		password = password.trim();
		name = name.trim();
		address = address.trim();
		email = email.trim();
		phonenumber = phonenumber.trim();

		// TODO Optimalisation 
		if (username.length() == 0) {
			addFieldError("username", "Username is required.");			// if username length == 0, empty field so redirect... 
		}																// ...and give error.
		else if (username.length() > 15) {
			addFieldError("username", "Username is too long.");
		} 
		else if (username.length() < 5) {
			addFieldError("username", "Username is too short.");
		} 
		else if (ias.userExists(username)) {
			addFieldError("username", "Username already exists.");		// Check if username exists.
		} 

		// TODO Check if valid name (xxxxx xxxxx OR xxxxx xxxxx xxxxx).
		if (name.length() == 0) {
			addFieldError("name", "Name is required.");
		}

		// TODO? Split address into "Street", "Postal", etc.
		if (address.length() == 0) {
			addFieldError("address", "Address is required.");
		}
		
		// TODO Optimalisation 
		if (phonenumber.length() == 0) {
			addFieldError("phonenumber", "Phonenumber is required.");
		} else if (phonenumber.length() != 10) {
			addFieldError("phonenumberlength",
					"Phonenumber must be 10 characters.");				// Check if phone number contains 10 characters. 
		}																

		if (email.length() == 0) {
			addFieldError("email", "E-mail is required.");
		}
		if (email.equals(repeatemail)) {
			if (!validEmail()) {
				addFieldError("emailvalidation",						// E-mail validation method (line 196)
						"Email addresses must match the following format: xxxxx@xxxxx.xxx");
			}
		} else {
			addFieldError("emailmatch", "Email addresses must match.");
		}

		if (password.length() == 0) {
			addFieldError("password", "Password is required.");
		}
		if (password.equals(repeatpassword)) {
			if (!validPassword()) {
				if (!hasUpperCase) {
					addFieldError("passworduppercase",					// Password validation method (line 204)
							"Password must contain at least 1 uppercase character.");
				} else if (!hasLowerCase) {
					addFieldError("passwordlowercase",
							"Password must contain at least 1 lowercase character.");
				} else if (!hasDigit) {
					addFieldError("passworddigit",
							"Password must contain at least 1 number.");
				} else if (repeatpassword.length() < 8) {
					addFieldError("passwordlength",
							"Password length must be at least 8 characters.");
				}
			}
		} else {
			addFieldError("passwordmatch", "Passwords must match.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// public String getPassword() {
	// return password;
	// }

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setTempCredits(int tempCredits) {
		this.tempCredits = tempCredits;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getRepeatemail() {
		return repeatemail;
	}

	public void setRepeatemail(String repeatemail) {
		this.repeatemail = repeatemail;
	}

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}

	// TODO Optimalisation
	public boolean validEmail() {
		// Explaination of this String at the end of this class.
		String EMAIL_PATTERN = "^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*(.[a-zA-Z]{2,3})$";
		pattern = Pattern.compile(EMAIL_PATTERN);								// Compile above String to a pattern.
		matcher = pattern.matcher(email);										// Check if E-mail matches the pattern.									
		return matcher.matches();												// Return true if it matches, else it returns a false.
	}

	public boolean validPassword() {
		for (int i = 0; i < repeatpassword.length(); i++) {						// Walk through the string.
			if (Character.isUpperCase(repeatpassword.charAt(i))) {				// Check if any character in the String is an upper case character.
				hasUpperCase = true;											// Return true if above statement is the case.
			} else if (Character.isLowerCase(repeatpassword.charAt(i))) {		// Check if any character in the String is a lower case character.
				hasLowerCase = true;
			} else if (Character.isDigit(repeatpassword.charAt(i))) {			// Check if the String contains numbers.
				hasDigit = true;
			}
		}
		if (!hasUpperCase && !hasLowerCase && hasDigit							// If the String has an uppercase & lowercase character, ... 
				&& repeatpassword.length() >= 8) {								// ...contains no numbers and the length is at least 8...
			return true;														// Return true.
		} else {
			return false;														// If not, return false.
		}
	}
}

/*
 String EMAIL_PATTERN = "^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*(.[a-zA-Z]{2,3})$";
 
 	^ = Start of the string

    [_a-zA-Z0-9-]+  = May contain: One or more characters of "_" , a letter (a-z, A-Z), a number (0-9), or "-" 
    (.[_a-zA-Z0-9-]+)*  = Part after the @: zero or more substrings of type .something, or .123, or .a123. 
    					  The substring must be formed by a . and a letter (same as before). 
    					  So "." is not valid. ".a" or ".1" or ".-" is.
 */