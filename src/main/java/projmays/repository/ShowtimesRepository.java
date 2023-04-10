/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projmays.beans.Showtimes;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Long> {

}