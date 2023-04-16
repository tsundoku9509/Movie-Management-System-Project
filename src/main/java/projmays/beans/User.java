/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 6, 2023
 */
package projmays.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Adell
 *
 */
@Entity
@Table(name = "user")
@Embeddable
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "favorite_genre")
	private String favoriteGenre;
	@Column(name = "tickets_purchased")
	private int numTicketsPurchased;
	public User() {
		super();
	}
	public User(int id, String firstName, String lastName, String username, String password, String favoriteGenre,
			int numTicketsPurchased) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	public User(String firstName, String lastName, String password, String favoriteGenre, int numTicketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	public User(String firstName, String lastName, String password, int numTicketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.numTicketsPurchased = numTicketsPurchased;
	}
	public User(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
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
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", favoriteGenre=" + favoriteGenre + ", numTicketsPurchased="
				+ numTicketsPurchased + "]";
	}
}
