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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "theater_showtimes")
@Embeddable
public class Showtime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "movie")
	private Movie movie;
	@Column(name = "time")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalTime time;
	@Column(name = "theater_number")
	private int theaterNumber;
	@Column(name = "tickets_available")
	private int ticketsAvailable;
	@Column(name = "is_discounted")
	private boolean isDiscounted = false;
	@Column(name = "past_showtimes")
	private LocalTime pastShowTimes;
	@Column(name = "future_showtimes")
	private LocalTime futureShowTimes;
	private static LocalTime MAX;

	public Showtime(long id, Movie movie, LocalTime time, int theaterNumber, int ticketsAvailable,
			boolean isDiscounted) {
		super();
		this.id = id;
		this.movie = movie;
		this.time = time;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
		this.isDiscounted = isDiscounted;

		while (time != MAX) {
			System.out.println("Recent showtimes: " + this.pastShowTimes);
		}
		if (time == MAX) {
			System.out.println("Future showtimes: " + this.futureShowTimes);
		}
	}

	public Showtime() {
		super();
	}

	public Showtime(Movie movie) {
		super();
		this.movie = movie;
	}

	public Showtime(Movie movie, LocalTime time, int theaterNumber, int ticketsAvailable) {
		super();
		this.movie = movie;
		this.time = time;
		this.theaterNumber = theaterNumber;
		this.ticketsAvailable = ticketsAvailable;
	}

	public Showtime(long id, Movie movie, LocalTime time, int theaterNumber, int ticketsAvailable) {
		super();
		this.id = id;
		this.movie = movie;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
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

	public LocalTime getPastShowTimes() {
		return pastShowTimes;
	}

	public void setPastShowTimes(LocalTime pastShowTimes) {
		this.pastShowTimes = pastShowTimes;
	}

	public LocalTime getFutureShowTimes() {
		return futureShowTimes;
	}

	public void setFutureShowTimes(LocalTime futureShowTimes) {
		this.futureShowTimes = futureShowTimes;
	}

	@Override
	public String toString() {
		return "Showtime [id=" + id + ", movie=" + movie + ", time=" + time + ", theaterNumber=" + theaterNumber
				+ ", ticketsAvailable=" + ticketsAvailable + "]";// ", isDiscounted=" + isDiscounted +
	}

}
