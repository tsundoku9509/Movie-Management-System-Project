/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Apr 22, 2023
 */
package projmays.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
@Embeddable
public class Movie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "genre")
	private String genre;
	public Movie() {
		super();
	}
	public Movie(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	public Movie(long id, String title, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + "]";
	}
}
