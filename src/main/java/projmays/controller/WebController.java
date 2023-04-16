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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import projmays.repository.ShowtimesRepository;
import projmays.repository.UserRepository;
import projmays.beans.Showtime;
import projmays.beans.User;

/**
 * @author Adell
 *
 */

@Controller
public class WebController {
	@Autowired
	ShowtimesRepository showtimesRepo;
	@Autowired
	UserRepository userRepo;
	
	@GetMapping({"/", "signIn"})
	public String userSignIn(Model model) {
		List<User> users = userRepo.findAll();
		model.addAttribute("users", users);
		return "signIn";
	}
	@GetMapping("/createUser")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "userInput";
	}
	@PostMapping("/createUser")
	public String addShowtime(@ModelAttribute User u, Model model) {
		userRepo.save(u);
		return userSignIn(model);
	}
	
	@GetMapping("/viewShowtimes")
	public String viewShowtimes(Model model) {
		if(showtimesRepo.findAll().isEmpty()) {
			return addShowtime(model);
		}
		model.addAttribute("showtimes", showtimesRepo.findAll());
		return "showtimesResults";
	}
	@GetMapping("/addShowtime")
	public String addShowtime(Model model) {
		Showtime s = new Showtime();
		List<Showtime> shows = showtimesRepo.findAll();
		List<Integer> theatersUsed = new ArrayList<Integer>();
		List<String> theaterOneTimes = new ArrayList<String>();
		List<String> theaterTwoTimes = new ArrayList<String>();
		List<String> theaterThreeTimes = new ArrayList<String>();
		List<String> theaterFourTimes = new ArrayList<String>();
		List<List<String>> timesUsed = new ArrayList<>();
		for(Showtime e : shows) {
			theatersUsed.add(e.getTheaterNumber());
			if(e.getTheaterNumber() == 1) {
				theaterOneTimes.add(e.getTime().toString());
			}
			else if(e.getTheaterNumber() == 2) {
				theaterTwoTimes.add(e.getTime().toString());
			}
			else if(e.getTheaterNumber() == 3) {
				theaterThreeTimes.add(e.getTime().toString());
			}
			else if(e.getTheaterNumber() == 4) {
				theaterFourTimes.add(e.getTime().toString());
			}
		}
		timesUsed.add(theaterOneTimes);
		timesUsed.add(theaterTwoTimes);
		timesUsed.add(theaterThreeTimes);
		timesUsed.add(theaterFourTimes);
		model.addAttribute("newShowtime", s);
		model.addAttribute("theatersUsed", theatersUsed);
		model.addAttribute("timesUsed", timesUsed);
		return "showtimesInput";
	}
	@PostMapping("/addShowtime")
	public String addShowtime(@ModelAttribute Showtime s, Model model) {
		showtimesRepo.save(s);
		return viewShowtimes(model);
	}
}