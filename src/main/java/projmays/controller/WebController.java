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

import projmays.beans.Showtimes;
import projmays.repository.ShowtimesRepository;

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
		return "showtimesView";
	}
	@GetMapping("/inputShowtime")
	public String addShowtime(Model model) {
		Showtimes s = new Showtimes();
		model.addAttribute("newShowtime", s);
		return "showtimesInput";
	}
	@PostMapping("/inputShowtime")
	public String addShowtime(@ModelAttribute Showtimes s, Model model) {
		showtimesRepo.save(s);
		return viewShowtimes(model);
	}
}
