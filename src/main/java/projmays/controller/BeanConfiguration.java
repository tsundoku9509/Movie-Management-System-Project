/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import projmays.beans.Showtime;

/**
 * @author Adell
 *
 */
@Configuration
public class BeanConfiguration {
	@Bean
	public Showtime showtime() {
		Showtime bean = new Showtime("Indiana Jones", LocalTime.now(), 20, 20);
		return bean;
	}
}
