/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projmays.beans.Showtime;

/**
 * @author Adell
 *
 */
@Repository
public interface ShowtimesRepository  extends JpaRepository<Showtime, Long>{
	
}
