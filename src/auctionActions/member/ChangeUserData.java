package auctionActions.member;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserData extends ActionSupport implements SessionAware {

	private IAuctionService ias = ServiceProvider.getAuctionService();
	private User user;
	private Map session;
	private String name;
	private String address;
	private String username;
	private String password;
	private String newPassword;
	private String newPasswordRepeat;
	private String email;
	private String phoneNumber;
	private boolean hasName = false;
	private boolean hasAddress = false;
	private boolean hasEmail = false;
	private boolean hasPhoneNumber = false;
	private boolean hasPassword = false;
	private boolean validUser = false;

	boolean PasswordHasUpperCase = false;
	boolean PasswordHasLowerCase = false;
	boolean PasswordHasDigit = false;
	boolean PasswordHasWhiteSpace = true;
	
	private Pattern pattern;
	private Matcher matcher;

	public String execute() {
		if (hasName || hasAddress || hasEmail || hasPhoneNumber || hasPassword) {
			session.put("user", user);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	// TODO Check for special characters.
	public void validate() {

		user = (User) session.get("user");
		
		if(username.length() != 0 && password.length() != 0){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				validUser = true;
			}
		}
		
		if(validUser){
			System.out.println("Valid User = " + validUser);
			if (getName().length() != 0) {
				if (!user.getName().equals(getName())) {
					if (validName(name)) {
						user.setName(getName());						
						hasName = true;
						System.out.println("hasName = " + hasName);
					} else {
						addFieldError("namepattern", "Your new name may not contain numbers and must contain at least 1 space.");
					}
				} else {
					addFieldError("newname", "Your new name may not be the same as your old name.");
				}
			}
			
			// TODO Split into multiple parts. (street, postal, etc.)
			if (getAddress().length() != 0) {
				if (!user.getAddress().equals(getAddress())) {
					user.setAddress(getAddress());
					hasAddress = true;
					System.out.println("hasAddress = " + hasAddress);
				} else {
					addFieldError("newaddress", "Your new address may not be the same as your old address.");
				}
			}
			if (getEmail().length() != 0) {
				if (!user.getEmail().equals(getEmail())) {
					if(validEmail(email)){
						user.setEmail(getEmail());
						hasEmail = true;
						System.out.println("hasEmail = " + hasEmail);
					}else {
						addFieldError("emailpattern", "Email addresses must match the following format: xxxxx@xxxxx.xxx");
					}
				} else {
					addFieldError("newemail", "Your new email may not be the same as your old email.");
				}
			}
			
			if (getPhoneNumber().length() != 0) {
				if(getPhoneNumber().length() + 1 != 10){
					if(validPhoneNumber(phoneNumber)) {
						if (!user.getPhoneNumber().equals(getPhoneNumber())) {
							user.setPhoneNumber(getPhoneNumber());
							hasPhoneNumber = true;
							System.out.println("hasPhoneNumber = " + hasPhoneNumber);
						} else {
							addFieldError("newphonenumber", "Your new phonenumber may not be the same as your old phonenumber.");
						}
					} else {
						addFieldError("invalidphonenumber", "Your new phonenumber may only contain digits.");
					}
				} else {
					addFieldError("shortphonenumber", "Your new phonenumber must contain 10 characters (numbers only).");
				}
			}
			
			if (getNewPassword().length() != 0 && getNewPasswordRepeat().length() != 0) {
				
				System.out.println("NewPassword length = " + getNewPassword().length());
				System.out.println("NewPasswordRepeat length = " + getNewPasswordRepeat().length());
				System.out.println("NewPassword = " + newPassword);
				System.out.println("NewPasswordRepeat = " + newPasswordRepeat);
				
				if(newPassword.equals(newPasswordRepeat)){
					if(!validPassword()) {
						System.out.println("validPassword = " + validPassword());
						if (!PasswordHasUpperCase) {
							addFieldError("passworduppercase", "Password must contain at least 1 uppercase character.");
						} else if (!PasswordHasLowerCase) {
							addFieldError("passwordlowercase", "Password must contain at least 1 lowercase character.");
						} else if (!PasswordHasDigit) {
							addFieldError("passworddigit", "Password must contain at least 1 number.");
						} else if (newPassword.length() + 1 < 8) {
							addFieldError("passwordlength", "Password length must be at least 8 characters.");
						}
					} else{
						hasPassword = true;
						user.setPassword(newPassword);
						System.out.println("hasPassword = " + hasPassword);
					}
				} else {
					addFieldError("passwordmatch", "New passwords must match.");
				}
			}
		}else {
			addFieldError("user", "Username and/or password are incorrect.");
		}
	}

	public boolean validName(String name) {
		boolean hasDigit = false;
		boolean hasWhiteSpace = false;
		for (int i = 0; i < name.length(); i++) {
			if (Character.isDigit(name.charAt(i))) {
				hasDigit = true;
			}
			if (Character.isWhitespace(name.charAt(i))) {
				hasWhiteSpace = true;
			}
		}
		if (hasDigit || !hasWhiteSpace) {
			return false;
		}
		return true;
	}
	
	public boolean validEmail(String email) {
		String EMAIL_PATTERN = "^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*(.[a-zA-Z]{2,3})$";
		pattern = Pattern.compile(EMAIL_PATTERN);								// Compile above String to a pattern.
		matcher = pattern.matcher(email);										// Check if E-mail matches the pattern.			
		
		boolean hasWhiteSpace = false;
		for (int i = 0; i < email.length(); i++) {
			if (Character.isWhitespace(email.charAt(i))) {
				hasWhiteSpace = true;
			}
		}
		
		if(matcher.matches() && !hasWhiteSpace){								// matcher.matches() returns true if it matches, else it returns a false.
			return true;
		}					
		return false;												
	}
	
	public boolean validPhoneNumber(String phoneNumber) {
		boolean hasLetter = false;
		boolean hasWhiteSpace = false;
		for(int i = 0; i<phoneNumber.length(); i++){
			if(Character.isLetter(phoneNumber.charAt(i))){
				hasLetter = true;
			}
			if(Character.isWhitespace(phoneNumber.charAt(i))){
				hasWhiteSpace = true;
			} 
		}
		if(hasLetter || hasWhiteSpace){
			return false;
		}
		return true;

	}
	
	public boolean validPassword() {
		for (int i = 0; i < newPassword.length(); i++) {						// Walk through the string.
			if (Character.isUpperCase(newPassword.charAt(i))) {				// Check if any character in the String is an upper case character.
				PasswordHasUpperCase = true;											// Return true if above statement is the case.
			} else if (Character.isLowerCase(newPassword.charAt(i))) {		// Check if any character in the String is a lower case character.
				PasswordHasLowerCase = true;
			} else if (Character.isDigit(newPassword.charAt(i))) {			// Check if the String contains numbers.
				PasswordHasDigit = true;
			}
		}
		if (PasswordHasUpperCase && PasswordHasLowerCase && PasswordHasDigit							// If the String has an uppercase & lowercase character, ... 
				&& newPassword.length() >= 8) {								// ...contains no numbers and the length is at least 8...
			return true;														// Return true.
		} else {
			return false;														// If not, return false.
		}
	}

	/*
	 * if(!hasUpperCase) { addFieldError("characters",
	 * "Wachtwoord moet minimaal 1 hoofdletter bevatten." ); } else
	 * if(!hasLowerCase){ addFieldError("characters",
	 * "Wachtwoord moet minimaal 1 kleine letter bevatten." ); } else
	 * if(!hasDigit){ addFieldError("characters",
	 * "Wachtwoord moet minimaal 1 nummer bevatten." ); } else
	 * if(string.length() < 8){ addFieldError("characters",
	 * "Wachtwoord moet minimaal 8 characters bevatten." ); } else
	 * if(hasWhiteSpace){ addFieldError("characters",
	 * "Wachtwoord mag geen spaties bevatten." ); } }
	 */

	// public String getPassword() {
	// return password;
	// }

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public User getUser() {
		return user;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}
}
