/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 6, 2023
 */
package projmays.models;

/**
 * @author Adell
 *
 */

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String favoriteGenre;
	private int numTicketsPurchased;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFavoriteGenre() {
		return favoriteGenre;
	}
	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}
	public int getNumTicketsPurchased() {
		return numTicketsPurchased;
	}
	public void setNumTicketsPurchased(int numTicketsPurchased) {
		this.numTicketsPurchased = numTicketsPurchased;
	}
	
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String firstName, String lastName, String password, String favoriteGenre,
			int numTicketsPurchased) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	
	public Customer(String firstName, String lastName, String password, String favoriteGenre, int numTicketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	
	public Customer(String firstName, String lastName, String password, int numTicketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	
	public Customer(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", favoriteGenre=" + favoriteGenre + ", numTicketsPurchased=" + numTicketsPurchased + "]";
	}
	
	
	
}
