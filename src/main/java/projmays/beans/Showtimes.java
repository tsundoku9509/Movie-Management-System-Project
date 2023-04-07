/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Apr 6, 2023
 */
package projmays.beans;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="theater_showtimes")
@Embeddable
public class Showtimes {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="movie_name")
	private String movieName;
	@Column(name="showtime")
	private LocalTime showtime;
	@Column(name="theater_number")
	private int theaterNumber;
	@Column(name="tickets_available")
	private int ticketsAvailable;
	public Showtimes() {
		super();
	}
	public Showtimes(String movieName) {
		super();
		this.movieName = movieName;
	}
	public Showtimes(String movieName, LocalTime showtime, int theaterNumber, int ticketsAvailable) {
		super();
		this.movieName = movieName;
		this.showtime = showtime;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
	}
	public Showtimes(long id, String movieName, LocalTime showtime, int theaterNumber, int ticketsAvailable) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.showtime = showtime;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalTime getShowtime() {
		return showtime;
	}
	public void setShowtime(LocalTime showtime) {
		this.showtime = showtime;
	}
	public int getTheaterNumber() {
		return theaterNumber;
	}
	public void setTheaterNumber(int theaterNumber) {
		this.theaterNumber = theaterNumber;
	}
	public int getTicketsAvailable() {
		return ticketsAvailable;
	}
	public void setTicketsAvailable(int ticketsAvailable) {
		this.ticketsAvailable = ticketsAvailable;
	}
	@Override
	public String toString() {
		return "Showtimes [id=" + id + ", movieName=" + movieName + ", showtime=" + showtime + ", theaterNumber="
				+ theaterNumber + ", ticketsAvailable=" + ticketsAvailable + "]";
	}
}
