/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Apr 6, 2023
 */
package projmays.beans;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="theater_showtimes")
@Embeddable
public class Showtime {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name="movie_name")
	private String movieName;
	@Column(name="time")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalTime time;
	@Column(name="theater_number")
	private int theaterNumber;
	@Column(name="tickets_available")
	private int ticketsAvailable;
	@Column(name="is_discounted")
	private boolean isDiscounted = false;
	
	public Showtime(long id, String movieName, LocalTime time, int theaterNumber, int ticketsAvailable,
			boolean isDiscounted) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.time = time;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
		this.isDiscounted = isDiscounted;
	}
	public Showtime() {
		super();
	}
	public Showtime(String movieName) {
		super();
		this.movieName = movieName;
	}
	public Showtime(String movieName, LocalTime time, int theaterNumber, int ticketsAvailable) {
		super();
		this.movieName = movieName;
		this.time = time;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
	}
	public Showtime(long id, String movieName, LocalTime time, int theaterNumber, int ticketsAvailable) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.time = time;
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime showtime) {
		this.time = showtime;
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
	
	public boolean isDiscounted() {
		return isDiscounted;
	}
	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	
	@Override
	public String toString() {
		return "Showtime [id=" + id + ", movieName=" + movieName + ", time=" + time + ", theaterNumber=" + theaterNumber
				+ ", ticketsAvailable=" + ticketsAvailable +  "]";//", isDiscounted=" + isDiscounted +
	}
	
}
