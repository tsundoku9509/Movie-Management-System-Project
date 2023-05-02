/**

 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import projmays.beans.User;
/**
 * @author Adell
 *
 */
@Configuration
public class BeanConfiguration {
	@Bean(name="Jacoby")
	public User jacoby() {
		User jacobyBean = new User(1, "Jacoby", "King", "jking", "Password1", "Adventure", 1);
		return jacobyBean;
	}
	@Bean(name="Adelle")
	public User adelle() {
		User adelleBean = new User(2, "Adelle", "Rogers", "amrogers5", "Password1", "Action", 1);
		return adelleBean;
	}
	@Bean(name="Austin")
	public User austin() {
		User austinBean = new User(3, "Austin", "Mays", "ajmays", "Password1", "Action", 1);
		return austinBean;
	}
}
