/**
 * 
 */
package projmays.beans;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Austin Mays - ajmays CIS175 Spring 2023 04/07/2023
 */
@Entity
@Table(name = "popular")
@Embeddable
public class PopMoviesAndShowtimes {
	/**
	* 
	*/
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "pop_movie")
	private String popMovieName;
	@Column(name = "pop_showtime")
	private LocalTime popShowTime;
	@Column(name = "pop_theater")
	private int popTheaterNum;

	public PopMoviesAndShowtimes() {
		super();
	}

	public PopMoviesAndShowtimes(String popMovieName) {
		super();
		this.popMovieName = popMovieName;
	}

	public PopMoviesAndShowtimes(String popMovieName, LocalTime popShowTime) {
		super();
		this.popMovieName = popMovieName;
		this.popShowTime = popShowTime;
	}

	public PopMoviesAndShowtimes(String popMovieName, LocalTime popShowTime, int popTheaterNum) {
		super();
		this.popMovieName = popMovieName;
		this.popShowTime = popShowTime;
		this.popTheaterNum = popTheaterNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPopMovieName() {
		return popMovieName;
	}

	public void setPopMovieName(String popMovieName) {
		this.popMovieName = popMovieName;
	}

	public LocalTime getPopShowTime() {
		return popShowTime;
	}

	public void setPopShowTime(LocalTime popShowTime) {
		this.popShowTime = popShowTime;
	}

	public int getPopTheaterNum() {
		return popTheaterNum;
	}

	public void setPopTheaterNum(int popTheaterNum) {
		this.popTheaterNum = popTheaterNum;
	}

	@Override
	public String toString() {
		return "Your popular movies are :" + this.popMovieName + " | with the most popular showtimes at: "
				+ this.popShowTime + " | in theater numbers: " + this.popTheaterNum + ".";
	}
}
