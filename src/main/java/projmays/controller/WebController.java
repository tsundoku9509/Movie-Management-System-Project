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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projmays.repository.MovieRepository;
import projmays.repository.ShowtimesRepository;
import projmays.repository.UserRepository;
import projmays.beans.Movie;
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
	@Autowired
	MovieRepository movieRepo;
	
	long currentUserId;
	
	@GetMapping({"/", "signIn"})
	public String userSignIn(Model model) {
		List<User> users = userRepo.findAll();
		model.addAttribute("users", users);
		return "signIn";
	}
	@PostMapping("/signIn")
	public String userSignIn(@RequestParam("id") long id, Model model) {
		currentUserId = id;
		return viewShowtimes(model);
	}
	@GetMapping("/createUser")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		List<User> users = userRepo.findAll();
		model.addAttribute("users", users);
		return "userInput";
	}
	@PostMapping("/createUser")
	public String addUser(@ModelAttribute User u, Model model) {
		userRepo.save(u);
		return userSignIn(model);
	}
	@GetMapping("/viewShowtimes")
	public String viewShowtimes(Model model) {
		model.addAttribute("showtimes", showtimesRepo.findAll());
		return "showtimesResults";
	}
	@GetMapping("/addShowtime")
	public String addShowtime(Model model) {
		Showtime s = new Showtime();
		List<Showtime> currentShowtimes = showtimesRepo.findAll();
		List<Movie> currentMovies = movieRepo.findAll();
		List<List<String>> timesUsed = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
		for(Showtime i : currentShowtimes) {
			if(i.getTheaterNumber() == 1) {
				timesUsed.get(0).add(i.getTime().toString());
			}
			else if(i.getTheaterNumber() == 2) {
				timesUsed.get(1).add(i.getTime().toString());
			}
			else if(i.getTheaterNumber() == 3) {
				timesUsed.get(2).add(i.getTime().toString());
			}
			else if(i.getTheaterNumber() == 4) {
				timesUsed.get(3).add(i.getTime().toString());
			}
		}
		model.addAttribute("newShowtime", s);
		model.addAttribute("currentMovies", currentMovies);
		model.addAttribute("timesUsed", timesUsed);
		return "showtimesInput";
	}
	@PostMapping("/addShowtime")
	public String addShowtime(@ModelAttribute Showtime s, Model model) {
		showtimesRepo.save(s);
		return viewShowtimes(model);
	}
	//Deletes A ShowTime
	@GetMapping("/delete/{id}")
		public String deleteShowtime(@PathVariable("id") long id, Model model) {
			Showtime s = showtimesRepo.findById(id).orElse(null);
			showtimesRepo.delete(s);
			return viewShowtimes(model);
	}
	@PostMapping("/purchaseTickets")
	public String purchaseTickets(@RequestParam("id") long id, @RequestParam("ticketQuantity") int quantity, Model model) {
		Showtime s = showtimesRepo.findById(id).orElse(null);
		User u = userRepo.findById(currentUserId).orElse(null);
		for(int i = 0; i < quantity; i++) {
			u.addTicket(s);
		}
		s.setTicketsAvailable(s.getTicketsAvailable() - quantity);
		userRepo.save(u);
		showtimesRepo.save(s);
		//Delete at some point
		System.out.println(u.toString());
		return viewShowtimes(model);
	}
	@GetMapping("/viewTicketsPurchased")
	public String viewTicketsPurchased(Model model) {
		User u = userRepo.findById(currentUserId).orElse(null);
		model.addAttribute("user", u);
		return "purchasedTicketsResults";
	}
	@GetMapping("/addMovie")
	public String addMovie(Model model) {
		Movie m = new Movie();
		List<Movie> movies = movieRepo.findAll();
		model.addAttribute("newMovie", m);
		model.addAttribute("currentMovies", movies);
		return "movieInput";
	}
	@PostMapping("/addMovie")
	public String addMovie(@ModelAttribute Movie m, Model model) {
		movieRepo.save(m);
		System.out.println(m.toString());
		return addShowtime(model);
	}
	
	//Edit Showtimes
	@GetMapping("/edit/{id}")
		public String showUpdateShowtime(@PathVariable("id") long id, Model model) {
			Showtime s = showtimesRepo.findById(id).orElse(null);
			model.addAttribute("newShowtime", s);
			return "showtimesInput"; 
	}
	
	//This should update the showtime list with any changes
	@PostMapping("/update/{id}")
		public String reviseShowtime(Showtime s, Model model)  {
		showtimesRepo.save(s);
		return viewShowtimes(model);
	}
}