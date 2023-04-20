/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import projmays.beans.Showtime;

/**
 * @author Adell
 *
 */
@Repository
public interface ShowtimesRepository  extends JpaRepository<Showtime, Long>{
	//List<Showtime> findByOrderMovieNameAsc(); //This should sort the showtimes in alphabetical order of the movie name as a default
}
