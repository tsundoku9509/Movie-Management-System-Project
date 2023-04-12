/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Apr 9, 2023
 */
package projmays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import projmays.repository.ShowtimesRepository;
import projmays.beans.Showtime;

/**
 * @author Adell
 *
 */

@Controller
public class WebController {
	@Autowired
	ShowtimesRepository showtimesRepo;
	
	@GetMapping({ "/", "viewShowtimes" })
	public String viewShowtimes(Model model) {
		//if(showtimesRepo.findAll().isEmpty()) {
			//return addShowtime(model);
		//}
		model.addAttribute("showtimes", showtimesRepo.findAll());
		return "showtimesResults";
	}
	@GetMapping("/addShowtime")
	public String addShowtime(Model model) {
		Showtime s = new Showtime();
		int time = 0;
		model.addAttribute("newShowtime", s);
		model.addAttribute("time", time);
		return "showtimesInput";
	}
	@PostMapping("/addShowtime")
	public String addShowtime(@ModelAttribute Showtime s, Model model) {
		showtimesRepo.save(s);
		return viewShowtimes(model);
	}
}