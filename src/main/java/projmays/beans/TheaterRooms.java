/**
 * 
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
 * @author Austin Mays - ajmays CIS175 - Spring 2023 04/07/2023
 */

@Entity
@Table(name = "theater_rooms")
@Embeddable
public class TheaterRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater")
	// This string allows user ability to name rooms next to their list of numbers.
	private String theaterString;

	@ManyToMany
	@JoinColumn(name = "theater_list")
	private List<Showtime> theaterList;
	// Needs propper annotations to be implemented

	public String getTheaterString() {
		return theaterString;
	}

	public void setTheaterString(String theaterString) {
		this.theaterString = theaterString;
	}

	/*
	 * public List<Showtime> getTheaterList() {
	 * return theaterList;
	 * }
	 */

	/*
	 * public void setTheaterList(List<Showtime> theaterList) {
	 * this.theaterList = theaterList;
	 * }
	 */

	public TheaterRooms() {
		super();
	}

	public TheaterRooms(String theaterString) {
		super();
		theaterString = this.theaterString;
	}

	public TheaterRooms(String theaterString, List<Showtime> theaterList) {
		super();
		theaterString = this.theaterString;
		// theaterList = this.theaterList;
	}

	@Override
	public String toString() {
		return "Theater: " + this.theaterString + " | Number=" + ".";// + this.theaterList
	}
}
