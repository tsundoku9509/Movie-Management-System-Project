/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import projmays.beans.Showtimes;

/**
 * @author Adell
 *
 */
@Configuration
public class BeanConfiguration {
	@Bean
	public Showtimes showtimes() {
		Showtimes bean = new Showtimes();
		return bean;
	}
}
