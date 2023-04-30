package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.Adoptee;
import ARL.repository.AdopteeRepository;
import ARL.repository.AnimalsRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 10, 2023
 */

@Controller
public class HomeController {
	
	@Autowired
	AnimalsRepository animalRepo;
	
	@GetMapping({"/", "/index"})
	public String Index() {
		return "index";
	}
	
	@GetMapping("/arl-homepage")
	public String ARLHomePage() {
		return "arl-homepage";
	} 
	
	@GetMapping("/adoptee-homepage") 
	public String AdopteeHomepage(Model model) {
		model.addAttribute("animals", animalRepo.findAll());
		return "adoptee-homepage";
	}
	
	@GetMapping("/about")
	public String About() {
		return "about";
	}
	
	
}
