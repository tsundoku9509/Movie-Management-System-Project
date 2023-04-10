/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projmays.repository.ShowtimesRepository;

/**
 * @author Adell
 *
 */
public class WebController {
	@Autowired
	ShowtimesRepository repo;
	
	
	@GetMapping("/viewAllShowtimes")
		public String viewAllShowtimes(Model model) {
			/* if(repo.findAll().isEmpty()) {
				return addNewShowtimes(model);
			} */
			model.addAttribute("contacts", repo.findAll());
			return "showtimesResults";
	}



}
