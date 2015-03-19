package coreClasses;

public class User {
	
	private final String ID;
	
	private String firstname; 
	private String surname; 
	private String email;
	private String phone;
	private String password;
	
	public User()
	{
		ID = null;
	}
	public User(String firstName, String surname, String userID, String email, String phone, String password)
	{
		
		ID = userID;
		
		this.firstname = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return ID;
	}
}
