/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 6, 2023
 */
package projmays.beans;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
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
	@ManyToMany
	@JoinColumn(name = "tickets_purchased")
	private List<Showtime> ticketsPurchased;
	@Column(name = "user_persmissions")
	private int userPermissions;
	public User() {
		super();
	}
	public User(long id, String firstName, String lastName, String username, String password, String favoriteGenre,
			List<Showtime> ticketsPurchased, int userPermissions) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.ticketsPurchased = ticketsPurchased;
		this.userPermissions = userPermissions;
	}
	public User(long id, String firstName, String lastName, String username, String password, String favoriteGenre,
			List<Showtime> ticketsPurchased) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.ticketsPurchased = ticketsPurchased;
		this.userPermissions = 0;
	}
	public User(String firstName, String lastName, String password, String favoriteGenre, List<Showtime> ticketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
		this.ticketsPurchased = ticketsPurchased;
		this.userPermissions = 0;
	}
	public User(String firstName, String lastName, String password, List<Showtime> ticketsPurchased) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.ticketsPurchased = ticketsPurchased;
		this.userPermissions = 0;
	}
	public User(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userPermissions = 0;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public List<Showtime> getTicketsPurchased() {
		return ticketsPurchased;
	}
	public void setTicketsPurchased(List<Showtime> ticketsPurchased) {
		this.ticketsPurchased = ticketsPurchased;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", favoriteGenre=" + favoriteGenre + ", ticketsPurchased="
				+ ticketsPurchased + "]";
	}
	public void addTicket(Showtime s) {
		ticketsPurchased.add(s);
	}
}
