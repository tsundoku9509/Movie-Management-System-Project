/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

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
		Showtime bean = new Showtime();
		return bean;
	}
}
